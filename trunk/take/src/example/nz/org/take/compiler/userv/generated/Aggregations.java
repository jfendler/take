package example.nz.org.take.compiler.userv.generated;
/**
 * Class generated by the take compiler. 
 * In this class the aggregation functions referenced in the knowledge base are defined. 
 * @version Mon Sep 10 16:43:07 NZST 2007
 */
@SuppressWarnings("unchecked")
public class Aggregations{
    /**
     * Method generated for aggregation function eligibilityScore
     * code generated using velocity template AggregationFunctionSUM.vm
    */
    public static int eligibilityScore (example.nz.org.take.compiler.userv.domainmodel.Car arg0,example.nz.org.take.compiler.userv.domainmodel.Driver arg1) {
        
        int _value = 0;
        nz.org.take.rt.ResultSet<PolicyEligibilityScore> _result = KBFragement_getPolicyEligibilityScore.getPolicyEligibilityScore(arg0,arg1);
        while (_result.hasNext()) {
        	_value = _value + _result.next().score;
        } 
        _result.close();
        return _value;
    }}
