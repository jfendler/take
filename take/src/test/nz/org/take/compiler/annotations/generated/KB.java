package test.nz.org.take.compiler.annotations.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Tue Jan 29 15:34:01 NZDT 2008
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /is_father_of[in,in]
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an iterator for instances of is_father_of
    */
    public ResultSet<is_father_of> is_father_of_11(
        final test.nz.org.take.compiler.misc1.Person slot1,
        final test.nz.org.take.compiler.misc1.Person slot2);

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
