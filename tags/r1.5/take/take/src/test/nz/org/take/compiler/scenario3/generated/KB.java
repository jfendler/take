package test.nz.org.take.compiler.scenario3.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Fri Feb 01 11:31:33 NZDT 2008
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /isBrother[in,in]
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an iterator for instances of IsBrotherRelationship
    */
    public ResultSet<IsBrotherRelationship> isBrother(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2);

    /**
     * Method generated for query /isBrother2[in,in]
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an iterator for instances of IsBrotherRelationship2
    */
    public ResultSet<IsBrotherRelationship2> isBrother2(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2);

    /**
    * Method that can be used to query annotations at runtime.
    * @param id the id of the rule (or other knowledge element)
    * @return a map of annotations (string-string mappings)
    * code generated using velocity template LocalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations(String id);

    /**
     * Method that can be used to query global annotations at runtime.
     * Global annotations are attached to the knowledge base, not to
     * a particular element (rule,..).
     * @return a map of annotations (string-string mappings)
     * code generated using velocity template GlobalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations();
}
