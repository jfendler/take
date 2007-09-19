package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Sep 18 22:54:00 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_isPreferred_1 {
    /**
     * Method generated for query isPreferred[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isPreferred
    */
    public static ResultSet<isPreferred> isPreferred_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isPreferred> _result = new ResultSet(KBFragement_isPreferred_1.isPreferred_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isPreferred[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<isPreferred> isPreferred_1(
        final example.nz.org.take.compiler.userv.domainmodel.Driver slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Driver.isPreferred()",
            DerivationController.JAVA_METHOD);

        if (slot1.isPreferred()) {
            isPreferred result = new isPreferred();
            result.slot1 = slot1;

            return new SingletonIterator<isPreferred>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
