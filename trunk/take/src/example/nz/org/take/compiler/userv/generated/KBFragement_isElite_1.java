package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 10:03:56 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isElite_1 {
    /**
     * Method generated for query isElite[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isElite
    */
    public static ResultSet<isElite> isElite_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isElite> _result = new ResultSet(KBFragement_isElite_1.isElite_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isElite[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isElite> isElite_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.isElite()",
            DerivationController.JAVA_METHOD);

        if (slot1.isElite()) {
            isElite result = new isElite();
            result.slot1 = slot1;

            return new SingletonIterator<isElite>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
