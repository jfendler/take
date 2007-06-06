/*
 * Copyright (C) 2007 Bastian Schenke (bastian.schenke(at)gmail.com) and 
 * <a href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package nz.org.take.r2ml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBElement;

import nz.org.take.Fact;
import nz.org.take.Prerequisite;

import de.tu_cottbus.r2ml.Atom;
import de.tu_cottbus.r2ml.Condition;
import de.tu_cottbus.r2ml.QfAndOrNafNegFormula;
import de.tu_cottbus.r2ml.QfConjunction;
import de.tu_cottbus.r2ml.QfDisjunction;

class ConditionHandler implements XmlTypeHandler {

	/**
	 * Maps a Condition to a List of Lists of Prerequisites.
	 * 
	 * The "inner" lists represent disjuncts of the original condition and there
	 * elements are suppossed to be conjuncted Prerequisites. This is neccessary
	 * hence take doesnt support Disjunctions in rule bodies. Each disjunct is
	 * represented by a single take rule with the same head.
	 * 
	 * @param obj
	 *            a Condition
	 * @param driver
	 *            the used R2MLDriver
	 * @return a List of Lists that contain Prerequisites
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	@SuppressWarnings("unchecked")
	public Object importObject(Object obj, MappingContext context, R2MLDriver driver)
			throws R2MLException {
		Condition condition = (Condition) obj;
		List<List<Prerequisite>> bodies = new ArrayList<List<Prerequisite>>();
		List<JAXBElement<? extends QfAndOrNafNegFormula>> formula = driver.getNormalizer().normalize(condition).getQfAndOrNafNegFormula();
		List<Prerequisite> body = null;
		for (JAXBElement<? extends QfAndOrNafNegFormula> item : formula) {
			XmlTypeHandler handler = driver.getHandlerByXmlType(item.getValue().getClass());
			// disjunctions occur only on toplevel
			if (item.getValue() instanceof QfDisjunction) {
				return handler.importObject(item.getValue(), context, driver);
			}
			if (body == null) {
				body = new ArrayList<Prerequisite>();
				bodies.add(body);
			}
			if (item.getValue() instanceof QfConjunction) {
				body.addAll((Collection<? extends Prerequisite>) handler.importObject(item.getValue(), context, driver));
			} else {
				body.add(R2MLUtil.factAsPrerequisite((Fact)handler.importObject(item.getValue(), context, driver)));
			}
		} // for
		return bodies;
	} // importObject()

}
