package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Aug 16 11:26:52 NZST 2007
 */
@SuppressWarnings("unchecked")
class KBFragement_isConvertible_1 {
    /**
     * Method generated for query isConvertible[in]
     * @param slot1 input parameter generated from slot 0
     * @return an iterator for instances of _isConvertible
    */
    public static ResultSet<_isConvertible> isConvertible_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<_isConvertible> _result = new ResultSet(KBFragement_isConvertible_1.isConvertible_1(
                    slot1, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query isConvertible[in]
     * @param source
     * @param target
     * @return an iterator
     * code generated using velocity template nz/org/take/compiler/reference/JPredicate_11.vm
    */
    static ResourceIterator<_isConvertible> isConvertible_1(
        final example.nz.org.take.compiler.userv.domainmodel.Car slot1,
        final DerivationController _derivation) {
        _derivation.log("public boolean example.nz.org.take.compiler.userv.domainmodel.Car.isConvertible()",
            DerivationController.JAVA_METHOD);

        if (slot1.isConvertible()) {
            _isConvertible result = new _isConvertible();
            result.slot1 = slot1;

            return new SingletonIterator<_isConvertible>(result);
        }

        return EmptyIterator.DEFAULT;
    }
}
