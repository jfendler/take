package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Fri Feb 01 10:03:56 NZDT 2008
 */
@SuppressWarnings("unchecked")
class KBFragement_getPolicyEligibility {
    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    public static ResultSet<InsuranceEligibility> getPolicyEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<InsuranceEligibility> _result = new ResultSet(KBFragement_getPolicyEligibility.getPolicyEligibility(
                    car, driver, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    static ResourceIterator<InsuranceEligibility> getPolicyEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<InsuranceEligibility> result = new IteratorChain<InsuranceEligibility>(4) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // ES_04  IF less_than(eligibilityScore(<car>,<client>),100) THEN /insuranceEligibility(<car>,<client>,eligible)
                    case 0:
                        return getPolicyEligibility_0(car, driver,
                            _derivation.reset(_derivationlevel));

                    // ES_05  IF greater_than_or_equal(eligibilityScore(<car>,<client>),100) AND less_than_or_equal(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,must be reviewed by underwriting manager)
                    case 1:
                        return getPolicyEligibility_1(car, driver,
                            _derivation.reset(_derivationlevel));

                    // ES_06  IF greater_than(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,not eligible)
                    case 2:
                        return getPolicyEligibility_2(car, driver,
                            _derivation.reset(_derivationlevel));

                    // ES_07  IF /isLongTermClient(<client>) THEN /insuranceEligibility(<car>,<client>,eligible)
                    case 3:
                        return getPolicyEligibility_3(car, driver,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // ES_04  IF less_than(eligibilityScore(<car>,<client>),100) THEN /insuranceEligibility(<car>,<client>,eligible)
                    case 0:
                        return "ES_04";

                    // ES_05  IF greater_than_or_equal(eligibilityScore(<car>,<client>),100) AND less_than_or_equal(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,must be reviewed by underwriting manager)
                    case 1:
                        return "ES_05";

                    // ES_06  IF greater_than(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,not eligible)
                    case 2:
                        return "ES_06";

                    // ES_07  IF /isLongTermClient(<client>) THEN /insuranceEligibility(<car>,<client>,eligible)
                    case 3:
                        return "ES_07";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    }

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    private static ResourceIterator<InsuranceEligibility> getPolicyEligibility_0(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_04", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF less_than(eligibilityScore(<car>,<client>),100) THEN /insuranceEligibility(<car>,<client>,eligible)
        class bindingsInRule34 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "100"
            long p2;

            // Property generated for term  "eligibilityScore(<car>,<client>)"
            long p3;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p4;

            // Property generated for term  "eligible"
            java.lang.String p5;
        }
        ;

        final bindingsInRule34 bindings = new bindingsInRule34();
        bindings.p1 = driver;
        bindings.p3 = Aggregations.eligibilityScore(car, driver);
        bindings.p2 = 100;
        bindings.p4 = car;
        bindings.p5 = "eligible";

        // code for prereq less_than(eligibilityScore(<car>,<client>),100)
        final ResourceIterator<less_than> iterator1 = KBFragement_less_than_11.less_than_11(bindings.p3,
                100, _derivation.increaseDepth());

        // code for prereq /insuranceEligibility(<car>,<client>,eligible)
        final ResourceIterator<InsuranceEligibility> iterator2 = new NestedIterator<less_than, InsuranceEligibility>(iterator1) {
                public ResourceIterator<InsuranceEligibility> getNextIterator(
                    less_than object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p2 = (long) 100;

                    return new SingletonIterator(new InsuranceEligibility(
                            bindings.p4, bindings.p1, bindings.p5));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    private static ResourceIterator<InsuranceEligibility> getPolicyEligibility_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_05", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF greater_than_or_equal(eligibilityScore(<car>,<client>),100) AND less_than_or_equal(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,must be reviewed by underwriting manager)
        class bindingsInRule35 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "100"
            long p2;

            // Property generated for term  "eligibilityScore(<car>,<client>)"
            long p3;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p4;

            // Property generated for term  "250"
            long p5;

            // Property generated for term  "must be reviewed by underwriting manager"
            java.lang.String p6;
        }
        ;

        final bindingsInRule35 bindings = new bindingsInRule35();
        bindings.p1 = driver;
        bindings.p3 = Aggregations.eligibilityScore(car, driver);
        bindings.p2 = 100;
        bindings.p4 = car;
        bindings.p5 = 250;
        bindings.p6 = "must be reviewed by underwriting manager";

        // code for prereq greater_than_or_equal(eligibilityScore(<car>,<client>),100)
        final ResourceIterator<greater_than_or_equal> iterator1 = KBFragement_greater_than_or_equal_11.greater_than_or_equal_11(bindings.p3,
                100, _derivation.increaseDepth());

        // code for prereq less_than_or_equal(eligibilityScore(<car>,<client>),250)
        final ResourceIterator<less_than_or_equal> iterator2 = new NestedIterator<greater_than_or_equal, less_than_or_equal>(iterator1) {
                public ResourceIterator<less_than_or_equal> getNextIterator(
                    greater_than_or_equal object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p2 = (long) 100;

                    return KBFragement_less_than_or_equal_11.less_than_or_equal_11(bindings.p3,
                        bindings.p5, _derivation.increaseDepth());
                }
            };

        // code for prereq /insuranceEligibility(<car>,<client>,must be reviewed by underwriting manager)
        final ResourceIterator<InsuranceEligibility> iterator3 = new NestedIterator<less_than_or_equal, InsuranceEligibility>(iterator2) {
                public ResourceIterator<InsuranceEligibility> getNextIterator(
                    less_than_or_equal object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p5 = (long) 250;

                    return new SingletonIterator(new InsuranceEligibility(
                            bindings.p4, bindings.p1, bindings.p6));
                }
            };

        return iterator3;
    }

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    private static ResourceIterator<InsuranceEligibility> getPolicyEligibility_2(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_06", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF greater_than(eligibilityScore(<car>,<client>),250) THEN /insuranceEligibility(<car>,<client>,not eligible)
        class bindingsInRule36 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "not eligible"
            java.lang.String p2;

            // Property generated for term  "eligibilityScore(<car>,<client>)"
            long p3;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p4;

            // Property generated for term  "250"
            long p5;
        }
        ;

        final bindingsInRule36 bindings = new bindingsInRule36();
        bindings.p1 = driver;
        bindings.p3 = Aggregations.eligibilityScore(car, driver);
        bindings.p2 = "not eligible";
        bindings.p4 = car;
        bindings.p5 = 250;

        // code for prereq greater_than(eligibilityScore(<car>,<client>),250)
        final ResourceIterator<greater_than> iterator1 = KBFragement_greater_than_11.greater_than_11(bindings.p3,
                250, _derivation.increaseDepth());

        // code for prereq /insuranceEligibility(<car>,<client>,not eligible)
        final ResourceIterator<InsuranceEligibility> iterator2 = new NestedIterator<greater_than, InsuranceEligibility>(iterator1) {
                public ResourceIterator<InsuranceEligibility> getNextIterator(
                    greater_than object) {
                    bindings.p3 = (long) object.slot1;
                    bindings.p5 = (long) 250;

                    return new SingletonIterator(new InsuranceEligibility(
                            bindings.p4, bindings.p1, bindings.p2));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query /insuranceEligibility[in,in,out]
     * @param car input parameter generated from slot 0
     * @param driver input parameter generated from slot 1
     * @return an iterator for instances of InsuranceEligibility
    */
    private static ResourceIterator<InsuranceEligibility> getPolicyEligibility_3(
        final example.nz.org.take.compiler.userv.domainmodel.Car car,
        final example.nz.org.take.compiler.userv.domainmodel.Driver driver,
        final DerivationController _derivation) {
        _derivation.log("ES_07", DerivationController.RULE, car, driver,
            DerivationController.NIL);

        // Variable bindings in rule:  IF /isLongTermClient(<client>) THEN /insuranceEligibility(<car>,<client>,eligible)
        class bindingsInRule37 {
            // Property generated for term  "<client>"
            example.nz.org.take.compiler.userv.domainmodel.Driver p1;

            // Property generated for term  "<car>"
            example.nz.org.take.compiler.userv.domainmodel.Car p2;

            // Property generated for term  "eligible"
            java.lang.String p3;
        }
        ;

        final bindingsInRule37 bindings = new bindingsInRule37();
        bindings.p1 = driver;
        bindings.p2 = car;
        bindings.p3 = "eligible";

        // code for prereq /isLongTermClient(<client>)
        final ResourceIterator<LongTermClient> iterator1 = KBFragement_isLongTermClient.isLongTermClient(driver,
                _derivation.increaseDepth());

        // code for prereq /insuranceEligibility(<car>,<client>,eligible)
        final ResourceIterator<InsuranceEligibility> iterator2 = new NestedIterator<LongTermClient, InsuranceEligibility>(iterator1) {
                public ResourceIterator<InsuranceEligibility> getNextIterator(
                    LongTermClient object) {
                    bindings.p1 = object.driver;

                    return new SingletonIterator(new InsuranceEligibility(
                            bindings.p2, bindings.p1, bindings.p3));
                }
            };

        return iterator2;
    }
}
