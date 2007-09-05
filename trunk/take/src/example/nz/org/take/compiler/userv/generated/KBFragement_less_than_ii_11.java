package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Sep 05 23:20:44 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_less_than_ii_11 {
    /**
     * Method generated for query less_than_ii[in,in]
     * @param nz.org.take.compiler.reference.Slot@1db699b
     * @param nz.org.take.compiler.reference.Slot@1f26605
     * @return an iterator
     * code generated using velocity template Comparison_11.vm
    */
    static ResourceIterator<less_than_ii> less_than_ii_11(final int slot1,
        final int slot2, final DerivationController _derivation) {
        _derivation.log("<", DerivationController.COMPARISON);

        if (slot1 < slot2) {
            less_than_ii result = new less_than_ii();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<less_than_ii>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
