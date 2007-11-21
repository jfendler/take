package example.nz.org.take.r2ml.eurent.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 21 16:25:54 GMT+01:00 2007
 */
@SuppressWarnings("unchecked")
public class EURentKB {
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
            synchronized (EURentKB.class) {
                if (_annotations == null) {
                    java.beans.XMLDecoder decoder = new java.beans.XMLDecoder(new java.io.BufferedInputStream(
                                EURentKB.class.getResourceAsStream(
                                    "/example/nz/org/take/r2ml/eurent/generated/annotations.xml")));
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
    * Method generated for query /availableAt[in,in]
    * @param rentalCar input parameter generated from slot 0
    * @param branch input parameter generated from slot 1
    * @return an iterator for instances of availableAt
    */
    public ResultSet<availableAt> availableAt_11(
        final example.nz.org.take.r2ml.eurent.RentalCar rentalCar,
        final example.nz.org.take.r2ml.eurent.Branch branch) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<availableAt> _result = new ResultSet(KBFragement_availableAt_11.availableAt_11(
                    rentalCar, branch, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /availableAt[out,in]
     * @param branch input parameter generated from slot 1
     * @return an iterator for instances of availableAt
    */
    public ResultSet<availableAt> availableAt_01(
        final example.nz.org.take.r2ml.eurent.Branch branch) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<availableAt> _result = new ResultSet(KBFragement_availableAt_01.availableAt_01(
                    branch, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /availableAt[in,out]
     * @param rentalCar input parameter generated from slot 0
     * @return an iterator for instances of availableAt
    */
    public ResultSet<availableAt> availableAt_10(
        final example.nz.org.take.r2ml.eurent.RentalCar rentalCar) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<availableAt> _result = new ResultSet(KBFragement_availableAt_10.availableAt_10(
                    rentalCar, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /availableAt[out,out]
     * @return an iterator for instances of availableAt
    */
    public ResultSet<availableAt> availableAt_00() {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<availableAt> _result = new ResultSet(KBFragement_availableAt_00.availableAt_00(
                    _derivation), _derivation);

        return _result;
    }
}
