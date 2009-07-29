package test.nz.org.take.compiler.scenario0.generatedclasses;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Jul 29 22:27:06 NZST 2009
 */
@SuppressWarnings("unchecked")
public class KB {
    private static java.util.Map<String, java.util.Map<String, String>> _annotations =
        null;

    /**
    * Method that can be used to query annotations at runtime.
    * @param id the id of the rule (or other knowledge element)
    * @return a map of annotations (string-string mappings)
    * code generated using velocity template LocalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations(String id) {
        if (_annotations == null) {
            synchronized (KB.class) {
                if (_annotations == null) {
                    java.beans.XMLDecoder decoder = new java.beans.XMLDecoder(new java.io.BufferedInputStream(
                                KB.class.getResourceAsStream(
                                    "/test/nz/org/take/compiler/scenario0/generatedclasses/annotations.xml")));
                    _annotations = (java.util.Map<String, java.util.Map<String, String>>) decoder.readObject();
                    decoder.close();
                }
            }
        }

        return _annotations.get(id);
    }

    /**
     * Method that can be used to query global annotations at runtime.
     * Global annotations are attached to the knowledge base, not to
     * a particular element (rule,..).
     * @return a map of annotations (string-string mappings)
     * code generated using velocity template GlobalAnnotationMethod.vm
    */
    public java.util.Map<String, String> getAnnotations() {
        return getAnnotations("___global_annotations");
    }

    /**
    * Method generated for query /son[out,in]
    * @param son input parameter generated from slot 1
    * @return an iterator for instances of son
    */
    public ResultSet<son> son_01(final java.lang.String son) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<son> _result = new ResultSet(KBFragement_son_01.son_01(son,
                    _derivation), _derivation);

        return _result;
    }
}
