package example.nz.org.take.compiler.userv.main;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import nz.org.take.Annotatable;
import nz.org.take.rt.DerivationController;
import nz.org.take.rt.DerivationLogEntry;


/**
 * Tree model used to visualise the rules used and their annotations.
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

public class DerivationModel  implements TreeModel {
	private List<DerivationLogEntry> derivationLog = new ArrayList<DerivationLogEntry>();
	private Map<String,List<Annotation>> annotations = new HashMap<String,List<Annotation>>();
	
	class Annotation {
		String owner,key,value;
		public Annotation(String owner, String key, String value) {
			super();
			this.owner = owner;
			this.key = key;
			this.value = value;
		}
		public String toString() {
			return key+": "+value;
		}
	}
	
	public DerivationModel(List<DerivationLogEntry> log,Map<String,Annotatable> ann) {
		
		for (DerivationLogEntry e:log) {
			if (e.getKind()==DerivationController.RULE || e.getKind()==DerivationController.FACT || e.getKind()==DerivationController.EXTERNAL_FACT_SET) {
				derivationLog.add(e);
			}
		}
		if (ann!=null) {
			for (Entry<String,Annotatable> e:ann.entrySet()) {
				String id = e.getKey();
				Annotatable a = e.getValue();
				List<Annotation> list = new ArrayList<Annotation>();
				for (Entry<String,String> e2:a.getAnnotations().entrySet()) {
					Annotation n = new Annotation(id,e2.getKey(),e2.getValue());
					list.add(n);
				}
				annotations.put(id,list);
			} 
		}
	}


	public void addTreeModelListener(TreeModelListener l) {
	}

	public Object getChild(Object parent, int index) {
		if (parent==derivationLog) {
			return derivationLog.get(index).getName();
		}
		else if (parent instanceof String) { // id
			return annotations.get(parent).get(index);
		}
		return null;
	}

	public int getChildCount(Object parent) {
		if (parent==derivationLog) {
			return derivationLog.size();
		}
		else if (parent instanceof String) { 
			List<Annotation> l = annotations.get(parent);
			return l==null?0:l.size();
		}
		return 0;
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if (parent==derivationLog)
			return derivationLog.indexOf(child);
		else if (parent instanceof String) {
			return annotations.get(parent).indexOf(child);
		}
		return 0;
	}

	@Override
	public Object getRoot() {
		return derivationLog;
	}

	public boolean isLeaf(Object node) {
		return this.getChildCount(node)==0;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
	}


}
