package example.nz.org.take.r2ml.eurent.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Wed Nov 21 16:25:55 GMT+01:00 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_availableAt_00 {
    /**
     * Method generated for query /availableAt[out,out]
     * @return an iterator for instances of availableAt
    */
    public static ResultSet<availableAt> availableAt_00() {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<availableAt> _result = new ResultSet(KBFragement_availableAt_00.availableAt_00(
                    _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /availableAt[out,out]
     * @return an iterator for instances of availableAt
    */
    static ResourceIterator<availableAt> availableAt_00(
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<availableAt> result = new IteratorChain<availableAt>(1) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // car_availability  IF assignedTo(<rentalCar>,<rental>) AND storedAt(<rentalCar>,<storageBranch>) AND isRentalCarScheduledForService(<rentalCar>) THEN /availableAt(<rentalCar>,<storageBranch>)
                    case 0:
                        return availableAt_00_0(_derivation.reset(
                                _derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // car_availability  IF assignedTo(<rentalCar>,<rental>) AND storedAt(<rentalCar>,<storageBranch>) AND isRentalCarScheduledForService(<rentalCar>) THEN /availableAt(<rentalCar>,<storageBranch>)
                    case 0:
                        return "car_availability";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /availableAt[out,out]
     * @return an iterator for instances of availableAt
    */
    private static ResourceIterator<availableAt> availableAt_00_0(
        final DerivationController _derivation) {
        _derivation.log("car_availability", DerivationController.RULE,
            DerivationController.NIL, DerivationController.NIL);

        // Variable bindings in rule:  IF assignedTo(<rentalCar>,<rental>) AND storedAt(<rentalCar>,<storageBranch>) AND isRentalCarScheduledForService(<rentalCar>) THEN /availableAt(<rentalCar>,<storageBranch>)
        class bindingsInRule1 {
            // Property generated for term  "<storageBranch>"
            example.nz.org.take.r2ml.eurent.Branch p1;

            // Property generated for term  "<rental>"
            example.nz.org.take.r2ml.eurent.Rental p2;

            // Property generated for term  "<rentalCar>"
            example.nz.org.take.r2ml.eurent.RentalCar p3;
        }
        ;

        final bindingsInRule1 bindings = new bindingsInRule1();

        // code for prereq assignedTo(<rentalCar>,<rental>)
        final ResourceIterator<not_assignedTo> iterator1 = KBFragement_not_assignedTo_00.not_assignedTo_00(_derivation.increaseDepth());

        // code for prereq storedAt(<rentalCar>,<storageBranch>)
        final ResourceIterator<storedAt> iterator2 = new NestedIterator<not_assignedTo, storedAt>(iterator1) {
                public ResourceIterator<storedAt> getNextIterator(
                    not_assignedTo object) {
                    bindings.p3 = object.rentalCar;
                    bindings.p2 = object.rental;

                    return KBFragement_storedAt_10.storedAt_10(bindings.p3,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq isRentalCarScheduledForService(<rentalCar>)
        final ResourceIterator<not_isRentalCarScheduledForService> iterator3 = new NestedIterator<storedAt, not_isRentalCarScheduledForService>(iterator2) {
                public ResourceIterator<not_isRentalCarScheduledForService> getNextIterator(
                    storedAt object) {
                    bindings.p3 = object.rentalCar;
                    bindings.p1 = object.branch;

                    return KBFragement_not_isRentalCarScheduledForService_1.not_isRentalCarScheduledForService_1(bindings.p3,
                        _derivation.increaseDepth());
                }
            };

        // code for prereq /availableAt(<rentalCar>,<storageBranch>)
        final ResourceIterator<availableAt> iterator4 = new NestedIterator<not_isRentalCarScheduledForService, availableAt>(iterator3) {
                public ResourceIterator<availableAt> getNextIterator(
                    not_isRentalCarScheduledForService object) {
                    bindings.p3 = object.slot1;

                    return new SingletonIterator(new availableAt(bindings.p3,
                            bindings.p1));
                }
            };

        return iterator4;
    }
}
