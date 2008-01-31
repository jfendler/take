package example.nz.org.take.compiler.eurent.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 10:15:14 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_storedAt_10 {
    /**
     * Method generated for query storedAt[in,out]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of storedAt
    */
    public static ResultSet<storedAt> storedAt_10(
        final example.nz.org.take.compiler.eurent.RentalCar slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<storedAt> _result = new ResultSet(KBFragement_storedAt_10.storedAt_10(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query storedAt[in,out]
     * @param source
     * @return an iterator
     * code generated using velocity template PropertyPredicateONE2ONE_10.vm
    */
    static ResourceIterator<storedAt> storedAt_10(
        final example.nz.org.take.compiler.eurent.RentalCar source,
        final DerivationController _derivation) {
        _derivation.log("property storedAt",
            DerivationController.BEAN_PROPERTY, source, DerivationController.NIL);

        storedAt result = new storedAt();
        result.slot1 = source;
        result.slot2 = source.getStoredAt();

        return new SingletonIterator<storedAt>(result);
    }
}
