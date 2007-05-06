package test.nz.org.take.compiler.scenario3.generated;

import nz.org.take.rt.*;

import java.util.Iterator;


/**
 * Class generated by the take compiler.
 * @version Sun May 06 21:57:15 NZST 2007
 */
@SuppressWarnings("unchecked")
public class _KB {
    /**
     * Method generated for query nz.org.take.SimplePredicate@1067618c
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship
    */
    public ResultSet<IsBrotherRelationship> isBrother(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<IsBrotherRelationship> _result = new ResultSet(isBrother(
                    person1, person2, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query nz.org.take.SimplePredicate@1067618c
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship
    */
    private ResourceIterator<IsBrotherRelationship> isBrother(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<IsBrotherRelationship> result = new IteratorChain<IsBrotherRelationship>(1) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // nz.org.take.DerivationRule@b42cbf
                    case 0:
                        return isBrother_0(person1, person2,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // nz.org.take.DerivationRule@b42cbf
                    case 0:
                        return "rule1";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    } // blabla

    /**
     * Method generated for query nz.org.take.SimplePredicate@1067618c
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship
    */
    private ResourceIterator<IsBrotherRelationship> isBrother_0(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2,
        final DerivationController _derivation) {
        _derivation.log("rule1"); // Variable bindings in rule: nz.org.take.DerivationRule@b42cbf
        class bindingsInRule1 {
            // Property generated for term  "nz.org.take.ComplexTerm@6f7ce9"
            test.nz.org.take.compiler.scenario3.Person p1;

            // Property generated for term  "nz.org.take.Variable@15a8767"
            test.nz.org.take.compiler.scenario3.Person p2;

            // Property generated for term  "nz.org.take.ComplexTerm@1dfafd1"
            test.nz.org.take.compiler.scenario3.Person p3;

            // Property generated for term  "nz.org.take.Variable@171bbc9"
            test.nz.org.take.compiler.scenario3.Person p4;
        }
        ;

        final bindingsInRule1 bindings = new bindingsInRule1();
        bindings.p2 = person1;
        bindings.p1 = person1.getFather();
        bindings.p3 = person2.getFather();
        bindings.p4 = person2;

        // code for prereq nz.org.take.Prerequisite@12d7a10
        final ResourceIterator<_sameAs> iterator1 = sameAs_11(person1.getFather(),
                person2.getFather(), _derivation.increaseDepth());

        // code for prereq nz.org.take.Fact@a8c488
        final ResourceIterator<IsBrotherRelationship> iterator2 = new NestedIterator<_sameAs, IsBrotherRelationship>(iterator1) {
                public ResourceIterator<IsBrotherRelationship> getNextIterator(
                    _sameAs object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = object.slot2;

                    return new SingletonIterator(new IsBrotherRelationship(
                            bindings.p2, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query nz.org.take.SimplePredicate@2f5d83c6
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship2
    */
    public ResultSet<IsBrotherRelationship2> isBrother2(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<IsBrotherRelationship2> _result = new ResultSet(isBrother2(
                    person1, person2, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query nz.org.take.SimplePredicate@2f5d83c6
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship2
    */
    private ResourceIterator<IsBrotherRelationship2> isBrother2(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();
        ResourceIterator<IsBrotherRelationship2> result = new IteratorChain<IsBrotherRelationship2>(1) {
                public Object getIteratorOrObject(int pos) {
                    switch (pos) {
                    // nz.org.take.DerivationRule@1feca64
                    case 0:
                        return isBrother2_0(person1, person2,
                            _derivation.reset(_derivationlevel));

                    default:
                        return EmptyIterator.DEFAULT;
                    } // switch(pos)
                } // getIterator()

                public String getRuleRef(int pos) {
                    switch (pos) {
                    // nz.org.take.DerivationRule@1feca64
                    case 0:
                        return "rule2";

                    default:
                        return "";
                    } // switch(pos)
                } // getRuleRef()
            };

        return result;
    } // blabla

    /**
     * Method generated for query nz.org.take.SimplePredicate@2f5d83c6
     * @param person1 input parameter generated from slot 0
     * @param person2 input parameter generated from slot 1
     * @return an interator for instances of IsBrotherRelationship2
    */
    private ResourceIterator<IsBrotherRelationship2> isBrother2_0(
        final test.nz.org.take.compiler.scenario3.Person person1,
        final test.nz.org.take.compiler.scenario3.Person person2,
        final DerivationController _derivation) {
        _derivation.log("rule2"); // Variable bindings in rule: nz.org.take.DerivationRule@1feca64
        class bindingsInRule2 {
            // Property generated for term  "nz.org.take.ComplexTerm@998b08"
            test.nz.org.take.compiler.scenario3.Person p1;

            // Property generated for term  "nz.org.take.Variable@15a8767"
            test.nz.org.take.compiler.scenario3.Person p2;

            // Property generated for term  "nz.org.take.ComplexTerm@76cbf7"
            test.nz.org.take.compiler.scenario3.Person p3;

            // Property generated for term  "nz.org.take.Variable@171bbc9"
            test.nz.org.take.compiler.scenario3.Person p4;
        }
        ;

        final bindingsInRule2 bindings = new bindingsInRule2();
        bindings.p1 = person1.getFather();
        bindings.p2 = person1;
        bindings.p3 = person2.getFather();
        bindings.p4 = person2;

        // code for prereq nz.org.take.Prerequisite@148cc8c
        final ResourceIterator<_equals> iterator1 = equals_11(person1.getFather(),
                person2.getFather(), _derivation.increaseDepth());

        // code for prereq nz.org.take.Fact@6d084b
        final ResourceIterator<IsBrotherRelationship2> iterator2 = new NestedIterator<_equals, IsBrotherRelationship2>(iterator1) {
                public ResourceIterator<IsBrotherRelationship2> getNextIterator(
                    _equals object) {
                    bindings.p1 = object.slot1;
                    bindings.p3 = (test.nz.org.take.compiler.scenario3.Person) object.slot2;

                    return new SingletonIterator(new IsBrotherRelationship2(
                            bindings.p2, bindings.p4));
                }
            };

        return iterator2;
    }

    /**
     * Method generated for query nz.org.take.JPredicate@4089b41f
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an interator for instances of _sameAs
    */
    public ResultSet<_sameAs> sameAs_11(
        final test.nz.org.take.compiler.scenario3.Person slot1,
        final test.nz.org.take.compiler.scenario3.Person slot2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<_sameAs> _result = new ResultSet(sameAs_11(slot1, slot2,
                    _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query nz.org.take.JPredicate@4089b41f
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an interator for instances of _sameAs
    */
    private ResourceIterator<_sameAs> sameAs_11(
        final test.nz.org.take.compiler.scenario3.Person slot1,
        final test.nz.org.take.compiler.scenario3.Person slot2,
        final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();

        if (slot1.sameAs(slot2)) {
            _derivation.log(
                "public boolean test.nz.org.take.compiler.scenario3.Person.sameAs(test.nz.org.take.compiler.scenario3.Person)");

            _sameAs result = new _sameAs();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<_sameAs>(result);
        }

        return EmptyIterator.DEFAULT;
    }

    /**
     * Method generated for query nz.org.take.JPredicate@3b868ca6
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an interator for instances of _equals
    */
    public ResultSet<_equals> equals_11(
        final test.nz.org.take.compiler.scenario3.Person slot1,
        final java.lang.Object slot2) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<_equals> _result = new ResultSet(equals_11(slot1, slot2,
                    _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query nz.org.take.JPredicate@3b868ca6
     * @param slot1 input parameter generated from slot 0
     * @param slot2 input parameter generated from slot 1
     * @return an interator for instances of _equals
    */
    private ResourceIterator<_equals> equals_11(
        final test.nz.org.take.compiler.scenario3.Person slot1,
        final java.lang.Object slot2, final DerivationController _derivation) {
        final int _derivationlevel = _derivation.getDepth();

        if (slot1.equals(slot2)) {
            _derivation.log(
                "public boolean test.nz.org.take.compiler.scenario3.Person.equals(java.lang.Object)");

            _equals result = new _equals();
            result.slot1 = slot1;
            result.slot2 = slot2;

            return new SingletonIterator<_equals>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
