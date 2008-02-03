package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Sun Feb 03 21:41:18 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_equal_11 {
    /**
     * Method generated for query equal[in,in]
     * @param nz.org.take.compiler.reference.Slot@bcb23e
     * @param nz.org.take.compiler.reference.Slot@5a3923
     * @return an iterator
     * code generated using velocity template Comparison_11.vm
    */
    static ResourceIterator<equal> equal_11(final double slot1,
        final double slot2, final DerivationController _derivation) {
        _derivation.log("==", DerivationController.COMPARISON);

        if (slot1 == slot2) {
            equal result = new equal();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<equal>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
