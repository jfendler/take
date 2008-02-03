package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Sun Feb 03 21:41:18 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isSedan_1 {
    /**
     * Method generated for query isSedan[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isSedan
    */
    public static ResultSet<isSedan> isSedan_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isSedan> _result = new ResultSet(KBFragement_isSedan_1.isSedan_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isSedan[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isSedan> isSedan_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.isSedan()",
            DerivationController.JAVA_METHOD);

        if (slot1.isSedan()) {
            isSedan result = new isSedan();
            result.slot1 = slot1;

            return new SingletonIterator<isSedan>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
