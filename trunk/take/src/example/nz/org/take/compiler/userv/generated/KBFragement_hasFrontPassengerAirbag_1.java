package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Sep 13 12:50:58 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasFrontPassengerAirbag_1 {
    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasFrontPassengerAirbag
    */
    public static ResultSet<hasFrontPassengerAirbag> hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasFrontPassengerAirbag> _result = new ResultSet(KBFragement_hasFrontPassengerAirbag_1.hasFrontPassengerAirbag_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasFrontPassengerAirbag[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasFrontPassengerAirbag> hasFrontPassengerAirbag_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasFrontPassengerAirbag()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasFrontPassengerAirbag()) {
            hasFrontPassengerAirbag result = new hasFrontPassengerAirbag();
            result.slot1 = slot1;

            return new SingletonIterator<hasFrontPassengerAirbag>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
