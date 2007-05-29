/*
 * Copyright (C) 2007 <A href="http://www-ist.massey.ac.nz/JBDietrich" target="_top">Jens Dietrich</a>
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

package nz.org.take;

/**
 * Predicates to compare numbers (==,!=, < etc).
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */


public class Comparison extends AbstractPredicate {
	
	// constant instances
	public static Comparison LESS_THAN = new Comparison("<");
	public static Comparison LESS_THAN_OR_EQUALS = new Comparison("<=");
	public static Comparison GREATER_THAN = new Comparison(">");
	public static Comparison GREATER_THAN_OR_EQUALS = new Comparison(">=");
	public static Comparison EQUALS = new Comparison("==");
	public static Comparison NOT_EQUALS = new Comparison("!=");
	
	
	public Comparison(String name) {
		super();
		this.name = name;
	}
	
	
	private Class[] types = new Class[]{Double.class,Double.class};
	private String name = null;
	


	public String getName() {
		return name;
	}

	public Class[] getSlotTypes() {
		return types;
	}

	public String toString() {
		return getName();
	}
}
