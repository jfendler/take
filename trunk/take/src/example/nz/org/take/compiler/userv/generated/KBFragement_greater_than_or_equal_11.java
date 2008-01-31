package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 10:03:56 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_greater_than_or_equal_11 {
    /**
     * Method generated for query greater_than_or_equal[in,in]
     * @param nz.org.take.compiler.reference.Slot@dfcb47
     * @param nz.org.take.compiler.reference.Slot@9abc69
     * @return an iterator
     * code generated using velocity template Comparison_11.vm
    */
    static ResourceIterator<greater_than_or_equal> greater_than_or_equal_11(
        final double slot1, final double slot2,
        final DerivationController _derivation) {
        _derivation.log(">=", DerivationController.COMPARISON);

        if (slot1 >= slot2) {
            greater_than_or_equal result = new greater_than_or_equal();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<greater_than_or_equal>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
