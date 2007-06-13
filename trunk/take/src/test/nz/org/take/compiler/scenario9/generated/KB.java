package test.nz.org.take.compiler.scenario9.generated;

import nz.org.take.rt.*;


/**
 * Interface generated by the take compiler.
 * @version Wed Jun 13 21:05:32 NZST 2007
 */
@SuppressWarnings("unchecked")
public interface KB {
    /**
     * Method generated for query /is_father_of[in,in]
     * @param son input parameter generated from slot 0
     * @param father input parameter generated from slot 1
     * @return an iterator for instances of IsFatherOf
    */
    public ResultSet<IsFatherOf> getFather(
        final test.nz.org.take.compiler.scenario9.Person son,
        final test.nz.org.take.compiler.scenario9.Person father);
}
