package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Sep 13 12:50:58 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_hasSidePanelAirbags_1 {
    /**
     * Method generated for query hasSidePanelAirbags[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of hasSidePanelAirbags
    */
    public static ResultSet<hasSidePanelAirbags> hasSidePanelAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<hasSidePanelAirbags> _result = new ResultSet(KBFragement_hasSidePanelAirbags_1.hasSidePanelAirbags_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query hasSidePanelAirbags[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<hasSidePanelAirbags> hasSidePanelAirbags_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.hasSidePanelAirbags()",
            DerivationController.JAVA_METHOD);

        if (slot1.hasSidePanelAirbags()) {
            hasSidePanelAirbags result = new hasSidePanelAirbags();
            result.slot1 = slot1;

            return new SingletonIterator<hasSidePanelAirbags>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
