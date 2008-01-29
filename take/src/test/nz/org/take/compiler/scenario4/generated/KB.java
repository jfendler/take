package test.nz.org.take.compiler.scenario4.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Tue Jan 29 15:29:10 NZDT 2008
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /isEnrolled[in,out]
     * @param student input parameter generated from slot 0
     * @return an iterator for instances of IsEnrolled
    */
    public ResultSet<IsEnrolled> isEnrolled(
        final test.nz.org.take.compiler.scenario4.Student student);

    /**
     * Method generated for query /isEnrolled[in,in]
     * @param student input parameter generated from slot 0
     * @param college input parameter generated from slot 1
     * @return an iterator for instances of IsEnrolled
    */
    public ResultSet<IsEnrolled> isEnrolled(
        final test.nz.org.take.compiler.scenario4.Student student,
        final test.nz.org.take.compiler.scenario4.College college);

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
