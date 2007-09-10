package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Sep 10 16:43:09 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasAlarm_1 {
    /**
     * Method generated for query hasAlarm[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasAlarm
    */
    public static ResultSet<hasAlarm> hasAlarm_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasAlarm> _result = new ResultSet(KBFragement_hasAlarm_1.hasAlarm_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasAlarm[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasAlarm> hasAlarm_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasAlarm()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasAlarm()) {
            hasAlarm result = new hasAlarm();
            result.slot1 = slot1;

            return new SingletonIterator<hasAlarm>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
