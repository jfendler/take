package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Tue Feb 05 14:53:50 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_isNew_1 {
    /**
     * Method generated for query /isNew[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isNew
    */
    public static ResultSet<isNew> isNew_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<isNew> _result = new ResultSet(KBFragement_isNew_1.isNew_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /isNew[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isNew
    */
    static ResourceIterator<isNew> isNew_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<isNew> result = new IteratorChain<isNew>(2) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // AP_05  IF equal(getModelYear(<car>),[CurrentYear]) THEN /isNew(<car>)
                    case 0:
                        return isNew_1_0(slot1,
                            _derivation.reset(_derivationlevel));

                    // AP_06  IF equal(getModelYear(<car>),[NextYear]) THEN /isNew(<car>)
                    case 1:
                        return isNew_1_1(slot1,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // AP_05  IF equal(getModelYear(<car>),[CurrentYear]) THEN /isNew(<car>)
                    case 0:
                        return "AP_05";

                    // AP_06  IF equal(getModelYear(<car>),[NextYear]) THEN /isNew(<car>)
                    case 1:
                        return "AP_06";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /isNew[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isNew
    */
    private static ResourceIterator<isNew> isNew_1_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("AP_05", DerivationController.RULE, slot1);

        // Variable bindings in rule:  IF equal(getModelYear(<car>),[CurrentYear]) THEN /isNew(<car>)
        class bindingsInRule64 {
            // Property generated for term  "getModelYear(<car>)"
            long p1;

            // Property generated for term  "[CurrentYear]"
            long p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;
        }
        ;

        final bindingsInRule64 bindings = new bindingsInRule64();
        bindings.p1 = slot1.getModelYear();
        bindings.p3 = slot1;
        bindings.p2 = Constants.CurrentYear;

        // code for prereq equal(getModelYear(<car>),[CurrentYear])
        final ResourceIterator<equal> iterator1 = KBFragement_equal_11.equal_11(bindings.p1,
                Constants.CurrentYear, _derivation.increaseDepth());

        // code for prereq /isNew(<car>)
        final ResourceIterator<isNew> iterator2 = new NestedIterator<equal, isNew>(iterator1) {
                public ResourceIterator<isNew> getNextIterator(equal object) {
                    bindings.p1 = (long) object.slot1;
                    bindings.p2 = (long) Constants.CurrentYear;

                    return new SingletonIterator(new isNew(bindings.p3));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /isNew[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of isNew
    */
    private static ResourceIterator<isNew> isNew_1_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("AP_06", DerivationController.RULE, slot1);

        // Variable bindings in rule:  IF equal(getModelYear(<car>),[NextYear]) THEN /isNew(<car>)
        class bindingsInRule65 {
            // Property generated for term  "[NextYear]"
            long p1;

            // Property generated for term  "getModelYear(<car>)"
            long p2;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p3;
        }
        ;

        final bindingsInRule65 bindings = new bindingsInRule65();
        bindings.p1 = Constants.NextYear;
        bindings.p2 = slot1.getModelYear();
        bindings.p3 = slot1;

        // code for prereq equal(getModelYear(<car>),[NextYear])
        final ResourceIterator<equal> iterator1 = KBFragement_equal_11.equal_11(bindings.p2,
                Constants.NextYear, _derivation.increaseDepth());

        // code for prereq /isNew(<car>)
        final ResourceIterator<isNew> iterator2 = new NestedIterator<equal, isNew>(iterator1) {
                public ResourceIterator<isNew> getNextIterator(equal object) {
                    bindings.p2 = (long) object.slot1;
                    bindings.p1 = (long) Constants.NextYear;

                    return new SingletonIterator(new isNew(bindings.p3));
                }
            };

        return iterator2;
    }
}
