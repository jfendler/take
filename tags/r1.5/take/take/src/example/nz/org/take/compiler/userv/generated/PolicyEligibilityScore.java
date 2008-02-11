package example.nz.org.take.compiler.userv.generated;

/**
 * Class generated by the take compiler.
 * This class represents the predicate policyEligibilityScore
 * @version Mon Feb 11 13:49:16 NZDT 2008
 */
public class PolicyEligibilityScore {
    public example.nz.org.take.compiler.userv.domainmodel.Car car;
    public example.nz.org.take.compiler.userv.domainmodel.Driver driver;
    public long score;

    public PolicyEligibilityScore(
        example.nz.org.take.compiler.userv.domainmodel.Car car,
        example.nz.org.take.compiler.userv.domainmodel.Driver driver, long score) {
        super();
        this.car = car;
        this.driver = driver;
        this.score = score;
    }

    public PolicyEligibilityScore() {
        super();
    }
}
