package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Mon Sep 10 16:43:09 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_contains_11 {
    /**
     * Method generated for query contains[in,in]
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an iterator for instances of contains
    */
    public static ResultSet<contains> contains_11(
        final java.util.Collection slot1, final java.lang.Object slot2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<contains> _result = new ResultSet(KBFragement_contains_11.contains_11(
                    slot1, slot2, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query contains[in,in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template JPredicate_11.vm
    */
    static ResourceIterator<contains> contains_11(
        final java.util.Collection slot1, final java.lang.Object slot2,
        final DerivationController _derivation) {
        _derivation.log("public abstract boolean java.util.Collection.contains(java.lang.Object)",
            DerivationController.JAVA_METHOD);

        if (slot1.contains(slot2)) {
            contains result = new contains();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<contains>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
