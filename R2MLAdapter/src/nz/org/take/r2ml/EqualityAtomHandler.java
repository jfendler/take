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
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import nz.org.take.Fact;
import nz.org.take.Predicate;
import nz.org.take.Term;

import de.tu_cottbus.r2ml.EqualityAtom;
import de.tu_cottbus.r2ml.ObjectTerm;

/**
 * @author Bastian Schenke (bastian.schenke@googlemail.com) TODO implement this
 *         Handler
 */
class EqualityAtomHandler implements XmlTypeHandler {

	class EqualityPair {
		EqualityPair(ObjectTerm obj1, ObjectTerm obj2) {
			this.obj1 = obj1;
			this.obj2 = obj2;
		}

		ObjectTerm obj1 = null;

		ObjectTerm obj2 = null;
	}

	/**
	 * Map a
	 * 
	 * TODO implement protected List<JAXBElement<? extends ObjectTerm>>
	 * objectTerm; TODO implement protected Boolean isNegated;
	 * 
	 * @param obj
	 *            an EqualityAtom
	 * @param driver
	 *            the used R2MLDriver
	 * @return a List of Facts
	 * 
	 * @see nz.org.take.r2ml.XmlTypeHandler#importObject(java.lang.Object,
	 *      nz.org.take.r2ml.R2MLDriver)
	 */
	public Object importObject(Object obj, MappingContext context,
			R2MLDriver driver) throws R2MLException {
		EqualityAtom atom = (EqualityAtom) obj;
		try {
			List<Fact> facts = new ArrayList<Fact>();
			for (EqualityPair pair : getArgsAsPairs(atom.getObjectTerm())) {
				facts.add(buildFact(pair, context, driver));
			}
		} catch (Exception e) {
			throw new R2MLException("Error while handling EqualityAtom!", e);
		}
		return null;
	}

	private Fact buildFact(EqualityPair pair, MappingContext context,
			R2MLDriver driver) throws R2MLException {
		XmlTypeHandler handler1 = driver.getHandlerByXmlType(pair.obj1
				.getClass());
		XmlTypeHandler handler2 = driver.getHandlerByXmlType(pair.obj2
				.getClass());
		Term term1 = (Term) handler1.importObject(pair.obj1, context, driver);
		Term term2 = (Term) handler2.importObject(pair.obj2, context, driver);
		Fact fact = new Fact();
		fact.setTerms(new Term[] { term1, term2 });
		fact.setPredicate(buildEqualsPredicate(term1, term2));
		return fact;
	}

	private Predicate buildEqualsPredicate(Term term1, Term term2) {
		
		return null;
	}

	private List<EqualityPair> getArgsAsPairs(
			List<JAXBElement<? extends ObjectTerm>> args) {
		List<EqualityPair> pairs = new ArrayList<EqualityPair>(args.size()
				* (args.size() - 1));
		for (JAXBElement<? extends ObjectTerm> i : args) {
			for (JAXBElement<? extends ObjectTerm> j : args) {
				if (!(i == j))
					pairs.add(new EqualityPair(i.getValue(), j.getValue()));
			}
		}
		return pairs;
	}
}
