package example.nz.org.take.compiler.userv.generated;

import nz.org.take.rt.*;


/**
 * Class generated by the take compiler.
 * @version Thu Aug 16 11:26:52 NZST 2007
 */
@SuppressWarnings("unchecked")
public class UservRules {
    /**
     * Method generated for query /potentialTheftRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialTheftRating
    */
    public ResultSet<PotentialTheftRating> getPotenialTheftRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialTheftRating> _result = new ResultSet(KBFragement_getPotenialTheftRating.getPotenialTheftRating(
                    car, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /potentialOccupantInjuryRating[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of PotentialOccupantInjuryRating
    */
    public ResultSet<PotentialOccupantInjuryRating> getPotentialOccupantInjuryRating(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<PotentialOccupantInjuryRating> _result = new ResultSet(KBFragement_getPotentialOccupantInjuryRating.getPotentialOccupantInjuryRating(
                    car, _derivation), _derivation);

        return _result;
    }

    /**
     * Method generated for query /autoEligibility[in,out]
     * @param car input parameter generated from slot 0
     * @return an iterator for instances of AutoEligibility
    */
    public ResultSet<AutoEligibility> getAutoEligibility(
        final example.nz.org.take.compiler.userv.domainmodel.Car car) {
        DerivationController _derivation = new DefaultDerivationController();
        ResultSet<AutoEligibility> _result = new ResultSet(KBFragement_getAutoEligibility.getAutoEligibility(
                    car, _derivation), _derivation);

        return _result;
    }
}
