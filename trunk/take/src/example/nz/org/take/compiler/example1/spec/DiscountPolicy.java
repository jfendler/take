package example.nz.org.take.compiler.example1.spec;
import nz.org.take.rt.*;
/**
 * Interface generated by the take compiler. 
 * @version Sun May 27 22:18:55 NZST 2007
 */
@SuppressWarnings("unchecked")
public interface DiscountPolicy{
/**
 * Method generated for query /discount[in,out]
 * @param customer input parameter generated from slot 0
 * @return an iterator for instances of CustomerDiscount
*/
public ResultSet<CustomerDiscount> getDiscount(final test.nz.org.take.compiler.scenario5.Customer customer)
;
}
