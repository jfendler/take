/**
 * Copyright 2008 Jens Dietrich Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package nz.org.take.nscript;


/**
 * Script parser. Stateful, instances should not be shared. 
 * @author <a href="http://www-ist.massey.ac.nz/JBDietrich/">Jens Dietrich</a>
 */

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import nz.org.take.AbstractPredicate;
import nz.org.take.AggregationFunction;
import nz.org.take.Annotatable;
import nz.org.take.AnnotationKeys;
import nz.org.take.Comparison;
import nz.org.take.Constant;
import nz.org.take.DefaultKnowledgeBase;
import nz.org.take.DerivationRule;
import nz.org.take.Fact;
import nz.org.take.JPredicate;
import nz.org.take.KnowledgeBase;
import nz.org.take.Predicate;
import nz.org.take.Prerequisite;
import nz.org.take.PropertyPredicate;
import nz.org.take.Query;
import nz.org.take.SimplePredicate;
import nz.org.take.TakeException;
import nz.org.take.Term;
import nz.org.take.Variable;


public class Parser {
	public static final String _NAME1 = "[a-zA-Z][a-zA-Z0-9_]*"; // names for types
	public static final String _NAME2 = "[a-zA-Z_][a-zA-Z0-9_]*"; // names for var and ref declarations
	public static final Pattern TYPE_NAME = Pattern.compile(_NAME1+"(\\."+_NAME1+")*");
	public static final Pattern NAME = Pattern.compile(_NAME2);
	public static final Pattern LIST_OF_NAMES = Pattern.compile(_NAME2+"([\\s]*\\,[\\s]*"+_NAME2+")*");
	public static final Pattern COMMENT = Pattern.compile("//(.)*");
	public static final Pattern GLOBAL_ANNOTATION = Pattern.compile("@@(.)+=(.)+");
	public static final Pattern LOCAL_ANNOTATION = Pattern.compile("@[^@](.)*=(.)+");	
	//public static final Pattern VAR_DECLARATION = Pattern.compile("var( )+([a-zA-Z0-9_.]+)( )+([a-zA-Z0-9_,]+)");
	//public static final Pattern REF_DECLARATION = Pattern.compile("ref( )+([a-zA-Z0-9_.]+)( )+([a-zA-Z0-9_,]+)");
	public static final Pattern QUERY = Pattern.compile("(not[\\s]+)?"+_NAME2+"[\\s]*\\[[\\s]*(in|out)([\\s]*,[\\s]*(in|out))*[\\s]*\\]");
	//query potentialTheftRating[in,out]
	//public static final Pattern _REF_DECLARATION = Pattern.compile("ref( )+([a-zA-Z0-9_.]+)( )+([a-zA-Z0-9_,]+)");
	public static final Pattern RULE = Pattern.compile(_NAME1+":[\\s]+if[\\s]+(.)*");
	public static final Pattern FACT = Pattern.compile(_NAME1+":(.)*");
	public static final Pattern CONDITION1 = Pattern.compile(_NAME2+"\\[(.)*\\]");
	public static final Pattern STRING_LITERAL = Pattern.compile("\'(.)*\'"); // TODO handle escaped quotes
	
	private ClassLoader classloader = Parser.class.getClassLoader(); 	
	private KnowledgeBase kb = null;
	private Map<String,Variable> variables = new HashMap<String,Variable>();
	private Map<String,Constant> constants = new HashMap<String,Constant>();
	private Map<String,AggregationFunction> aggregationFunctions = new HashMap<String,AggregationFunction>();
	private Map<String,String> localAnnotations = new HashMap<String,String>();
	private List<QuerySpec> querySpecs = new ArrayList<QuerySpec>();	
	private Map<String,Predicate> predicatesByName = new HashMap<String,Predicate>();
	private Map<SimplePredicate,SimplePredicate> predicates = new HashMap<SimplePredicate,SimplePredicate>(); // use map for simple lookup with get
	private List<ScriptException> issues = null;
	private Collection<String> ids = new HashSet<String>();
	private boolean verificationMode = false;	
	private JSPELParser elParser = new JSPELParser(variables,constants);
	
	public Logger LOGGER = Logger.getLogger(Parser.class);
	
	
	public List<ScriptException> check (Reader reader)  throws ScriptException {
		verificationMode = true;
		return this.issues = new ArrayList<ScriptException>();
	}
	
	public KnowledgeBase parse (Reader reader) throws ScriptException  {
		verificationMode = false;
		kb = new DefaultKnowledgeBase();
		LineNumberReader bufReader = new LineNumberReader(reader);
		String line = null;
		try {
			while ((line=bufReader.readLine())!=null) {
				int no = bufReader.getLineNumber();
				line = line.trim();
				if (line.startsWith("//")) {
					// comment, don't parse
				}
				else if (line.startsWith("@@")) {
					parseGlobalAnnotation(line,no);
				}
				else if (line.startsWith("@")) {
					System.out.println("parse line " + no + " as local annotation: " + line);
					parseLocalAnnotation(line,no);
				}
				else if (line.startsWith("var ")) {
					System.out.println("parse line " + no + " as var declaration: " + line);
					parseVarDeclaration(line,no);
				}
				else if (line.startsWith("ref ")) {
					System.out.println("parse line " + no + " as ref declaration: " + line);
					parseRefDeclaration(line,no);
				}
				else if (line.startsWith("query ")) {
					System.out.println("parse line " + no + " as query: " + line);
					parseQuery(line,no);
				}
				else if (RULE.matcher(line).matches()) {
					System.out.println("parse line " + no + " as rule: " + line);
					parseRule(line,no);
				}
				else if (FACT.matcher(line).matches()) {
					System.out.println("parse line " + no + " as fact: " + line);
					parseFact(line,no);
				}
				else {
					error(no,"Unable to parse this line (unknown syntax type): " + line);
				}
				
			}
			
			// build queries
			buildQueries();
			
		} catch (IOException e) {
			throw new ScriptException(e);
		}	
		return kb;
	}
	
	private void buildQueries() throws ScriptException {
		for (QuerySpec spec:this.querySpecs) {
			String id = this.getId(spec);
			Predicate p = this.predicatesByName.get(id);
			if (p==null) {
				this.error(spec.getLine(),"There is no rule or fact supporting the query predicate ",spec.getPredicate()," in the script");
			}
			else if (p.isNegated()) {
				this.error(spec.getLine(),"There is no rule or fact supporting the unnegated query predicate ",spec.getPredicate()," in the script");
			}
			else {
				Query query = new Query();
				query.setPredicate(p);
				boolean[] io = new boolean[spec.getIoSpec().size()];
				for (int i=0;i<io.length;i++) {
					io[i]=spec.getIoSpec().get(i);
				}
				query.setInputParams(io);
				query.addAnnotations(spec.getAnnotations());
				takeOverAnnotations(query);
				this.kb.add(query);
			}	
		}
	}

	private void error(int no,String line,Pattern pattern,String... description) throws ScriptException{
		StringBuffer buf = new StringBuffer();
		buf.append("Parser exception at line ");
		buf.append(no);
		buf.append(' ');
		buf.append(line);
		buf.append(" does not match pattern ");
		buf.append(pattern.pattern());
		buf.append(' ');
		for (String t:description)
			buf.append(t);
		error(no,buf.toString());
	}
	private void error(int no,String... description) throws ScriptException{
		StringBuffer buf = new StringBuffer();
		buf.append("Parser exception at line ");
		buf.append(no);
		buf.append(' ');
		for (String t:description)
			buf.append(t);
		error(no,buf.toString());
	}
	private void error(int no,String message) throws ScriptException{
		if (this.verificationMode) {
			this.issues.add(new ScriptException(message,no));
		}
		else {
			throw new ScriptException(message,no);
		}
	}
	private void check(int no,String txt,Pattern pattern,String... errorMessage) throws ScriptException {
		if (!pattern.matcher(txt).matches()) 
			this.error(no,txt,pattern,errorMessage);
	}

	private void parseVarDeclaration(String line, int no) throws ScriptException {
		line = line.substring(4).trim();
		int sep = line.indexOf(' ');
		String type =line.substring(0,sep).trim();
		check(no,type,TYPE_NAME,"this is not a valid type name");
		Class clazz = this.classForName(type,no);
		String names=line.substring(sep+1).trim();
		String name = null;
		check(no,names,LIST_OF_NAMES,"this is not a valid (list of) name(s)");
		
		StringTokenizer t = new StringTokenizer(names,",");
		while (t.hasMoreTokens()) {
			name = t.nextToken().trim();
			Variable var = new Variable();
			var.setType(clazz);
			var.setName(name);
			this.variables.put(name,var);
		}
	}

	private void parseRefDeclaration(String line, int no) throws ScriptException {
		line = line.substring(4).trim();
		int sep = line.indexOf(' ');
		String type =line.substring(0,sep).trim();
		check(no,type,TYPE_NAME,"this is not a valid type name");
		Class clazz = this.classForName(type,no);
		String names=line.substring(sep+1).trim();
		String name = null;
		check(no,names,LIST_OF_NAMES,"this is not a valid (list of) name(s)");
		
		StringTokenizer t = new StringTokenizer(names,",");
		while (t.hasMoreTokens()) {
			name = t.nextToken().trim();
			Constant c = new Constant();
			c.setType(clazz);
			c.setRef(name);
			this.constants.put(name,c);
		}	
	}
	
	private void parseQuery(String line, int no) throws ScriptException {
		line = line.substring(6).trim();
		
		QuerySpec query = new QuerySpec();
		query.setLine(no);
		this.consumeAnnotations(query);
		
		// TODO should we support explicit negation here?
		if (line.startsWith("not ")) {
			this.error(no,"Negation is not supported here");
			//query.setNegated(true);
			//line = line.substring(4).trim();
		}

		int sep = line.indexOf('[');
		String name = line.substring(0,sep).trim();
		String sign = line.substring(sep+1,line.length()-1).trim();
		
		query.setPredicate(name);
		
		// parse i/o
		StringTokenizer tok = new StringTokenizer(sign,",");
		while (tok.hasMoreTokens()) {
			String token = tok.nextToken().trim();
			query.getIoSpec().add("in".equals(token));
		}
		
		this.querySpecs.add(query);
	}
	
	private void parseRule(String line, int no) throws ScriptException {

		int sep = line.indexOf(":"); //take off label
		String label = line.substring(0,sep).trim();
		line = line.substring(sep);
		sep = line.indexOf("if ");
		line = line.substring(sep+3).trim();
		List<String> unparsedConditions = new ArrayList<String>();
		String unparsedHead = null;
		BitSet neg = new BitSet();
		
		StringBuffer b = new StringBuffer();
		
		List<String> tokens = Tokenizer.tokenize(line," and "," then ");
		unparsedHead = tokens.remove(tokens.size()-1).trim();
		for (int i=0;i<tokens.size();i++) {
			String token = tokens.get(i).trim();
			if (token.startsWith("not ")) {
				token = token.substring(3).trim();
				neg.set(i);
			}
			unparsedConditions.add(token);
		}
		
		DerivationRule rule = new DerivationRule();
		this.checkId(label,no);
		rule.setId(label);
		Fact head = this.parseCondition(unparsedHead,no,false,false);
		rule.setHead(head);
		for (int i=0;i<unparsedConditions.size();i++) {
			Prerequisite prereq = (Prerequisite)this.parseCondition(unparsedConditions.get(i),no,true,neg.get(i));
			rule.getBody().add(prereq);
		}
		this.consumeAnnotations(rule);
		this.kb.add(rule);
		
	}
	
	
	private void parseFact(String line, int no) throws ScriptException {

		int sep = line.indexOf(":"); //take off label
		String label = line.substring(0,sep);
		line = line.substring(sep+1).trim();		
		Fact fact = this.parseCondition(line,no,false,false);
		this.checkId(label,no);
		fact.setId(label);
		this.kb.add(fact);

	}
	
	
	
	private void parseGlobalAnnotation(String line, int no) throws ScriptException {
		check(no,line,GLOBAL_ANNOTATION,"this is not a valid global annotation");
		line = line.substring(2).trim();
		int sep = line.indexOf('=');
		String key=line.substring(0,sep).trim();
		String value=line.substring(sep+1).trim();
		this.kb.addAnnotation(key, value);
	}
	
	private void parseLocalAnnotation(String line, int no) throws ScriptException {
		check(no,line,LOCAL_ANNOTATION,"this is not a valid local annotation");
		line = line.substring(1).trim();
		int sep = line.indexOf('=');
		String key=line.substring(0,sep).trim();
		String value=line.substring(sep+1).trim();
		this.localAnnotations.put(key, value);
	}

	private Class classForName(String type,int line) throws ScriptException {
		try {
			if ("char".equals(type))
				return Character.TYPE;
			if ("byte".equals(type))
				return Byte.TYPE;
			if ("int".equals(type))
				return Integer.TYPE;
			if ("short".equals(type))
				return Short.TYPE;
			if ("long".equals(type))
				return Long.TYPE;
			if ("double".equals(type))
				return Double.TYPE;
			if ("float".equals(type))
				return Float.TYPE;
			if ("boolean".equals(type))
				return Boolean.TYPE;
			return  this.classloader.loadClass(type);
		}
		catch (ClassNotFoundException x) {
			throw new ScriptException("Can not load the type " + type + " referenced in line " + line,x);
		}	
	}
	
	private Fact parseCondition (String s,int no, boolean isPrerequisite,boolean isNegated) throws ScriptException {
		
		if (CONDITION1.matcher(s).matches()) {
			int sep = -1;
			Fact fact = isPrerequisite?new Prerequisite():new Fact();
			// type of the condition is predicate[terms]
			sep=s.indexOf('[');
			String p = s.substring(0,sep);

			
			String t = s.substring(sep+1,s.length()-1);
			List<String> unparsedTerms = Tokenizer.tokenize(t,",");
			List<Term> terms = new ArrayList<Term>();
			for (String ut:unparsedTerms) {
				terms.add(parseTerm(ut,no));
			}
			Class[] types = new Class[terms.size()];
			for (int i=0;i<terms.size();i++) {
				types[i]=terms.get(i).getType();
			}
			Predicate predicate = this.buildPredicate(p, isNegated, terms.toArray(new Term[terms.size()]),no);
			fact.setPredicate(predicate);
			fact.setTerms(terms.toArray(new Term[terms.size()]));
			return fact;
		}
		else {
			if (!isPrerequisite) {
				throw new ScriptException("Error in line " + no + " - the rule head must have the following form: predicate[term_1,..,term_n]");
			}
			else {
				// parse with JUEL
				return elParser.parseCondition(s,no);
			}
		}
	}

	private Term parseTerm(String s,int line) throws ScriptException {
		return this.elParser.parseTerm(s, line);
	}

	
	
	private void consumeAnnotations(Annotatable a) {
		a.addAnnotations(this.localAnnotations);
		this.localAnnotations.clear();
	}
	
	private void checkId(String id,int line) throws ScriptException {

		if (id==null || id.trim().length()==0)
			this.error(line,"element has no proper id");
		else if (ids.contains(id)) 
			this.error(line,"duplicated id ",id);
		else 
			ids.add(id);
	}
	
	// take over query annotations for the query predicate
	private void takeOverAnnotations(Query q) {
		Predicate p = q.getPredicate();
		for (Entry<String,String> e:q.getAnnotations().entrySet())  {
			String key = e.getKey();
			p.addAnnotation(key,e.getValue());	
			if (AnnotationKeys.TAKE_GENERATE_SLOTS.equals(key)) {
				// set slot names from annotation
				List<String> slots = new ArrayList<String>();
				for (StringTokenizer tok = new StringTokenizer(e.getValue(),",");tok.hasMoreTokens();) {
					slots.add(tok.nextToken().trim());
				}
				if (slots.size()!=p.getSlotTypes().length) {
					// TODO log warning
				}
				else {
					String[] arr = slots.toArray(new String[slots.size()]);
					if (p instanceof AbstractPredicate) 
						((AbstractPredicate)p).setSlotNames(arr);
					//else  TODO log warning
				}
			}
		}
	}
	
	private nz.org.take.Predicate buildPredicate(String name,boolean negated, Term[] terms,int line) throws ScriptException {
		Predicate predicate = null;
		
		Method m = getMethod(name,terms);
		PropertyDescriptor property = null;
		if (m==null)
			property = getProperty(name, terms[0].getType());
		
		if (m!=null) {
			debug("Interpreting predicate symbol ",name," as Java method ",m," in line ",line);
			JPredicate p = new JPredicate();
			Class[] paramTypes = getParamTypes( terms);
			p.setMethod(m);
			p.setNegated(negated);
			predicate=p;			
		}
		else if (property!=null) {
			debug("Interpreting predicate symbol ",name," as bean property"," in line ",line);
			PropertyPredicate p = new PropertyPredicate();
			p.setProperty(property);
			p.setOwnerType(terms[0].getType());
			p.setNegated(negated);
			// todo remove this line that just does lazy initialization
			predicate=p;			
		}
		else {
			debug("Interpreting predicate symbol ",name," as simple predicate"," in line ",line);
			SimplePredicate p = new SimplePredicate();
			p.setName(name);
			p.setNegated(negated);
			Class[] types = new Class[terms.length];
			for (int i=0;i<terms.length;i++) { 
				types[i] = terms[i].getType();			
			}
			p.setSlotTypes(types);
			predicate=p;
		}
		String id = this.getId(predicate);
		Predicate existingPredicate = predicatesByName.get(id);
		if (existingPredicate==null) {
			predicatesByName.put(this.getId(predicate),predicate);
			return predicate;
		}
		else
			return existingPredicate;
	}
	
	private Class[] getParamTypes(nz.org.take.Term[] terms) {
		Class[] paramTypes = new Class[terms.length-1];
		for (int i=1;i<terms.length;i++) {
			paramTypes[i-1]=terms[i].getType();
		}
		return paramTypes;
	}
	
	private Method getMethod(String name,nz.org.take.Term[] terms) throws ScriptException  {		
		Class clazz = terms[0].getType();
		Class[] paramTypes = new Class[terms.length-1];
		Method m = null;
		for (int i=1;i<terms.length;i++) {
			paramTypes[i-1]=terms[i].getType();
		}
		try {
			m = clazz.getMethod(name,paramTypes);
		}
		catch (Exception x) {}
		if (m==null) {
			// start investigating supertypes
			Method[] methods = clazz.getMethods();
			for (Method m1:methods) {
				if (m1.getReturnType()==Boolean.TYPE && Modifier.isPublic(m1.getModifiers())) {
					if (m1.getName().equals(name) && m1.getParameterTypes().length==paramTypes.length) {
						// check types
						boolean ok = true;
						for (int i=0;i<paramTypes.length;i++) {
							ok = ok && m1.getParameterTypes()[i].isAssignableFrom(paramTypes[i]);
						}
						if (ok){
							m = m1;
							break;
						}
					}
				}
			}
		}
		return m;
		
	}
	
	private PropertyDescriptor getProperty(String name,Class clazz) throws ScriptException  {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property:properties) {
				if (name.equals(property.getName()) && property.getReadMethod()!=null) {
					return property;
				}
			}
		}
		catch (Exception x) {}
		return null;
	}
	private String getId(Predicate p) {
		return p.getName()+'_'+p.getSlotTypes().length+(p.isNegated()?"-":"+");
	}
	private String getId(QuerySpec q) {
		return q.getPredicate()+'_'+q.getIoSpec().size()+"+";
	}
	private void debug(Object ...strings) {
		if (LOGGER.isDebugEnabled()) {
			StringBuffer b = new StringBuffer();
			for (Object s:strings)
				b.append(s);
			LOGGER.debug(b);
		}
		
	}
	
}
