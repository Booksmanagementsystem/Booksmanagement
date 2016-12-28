package test;

import org.junit.Test;
import org.library.dao.BaseDao;
import org.library.entity.Readers;

/**
 * Created by admin on 2016/12/28.
 */
public class test {
    @Test
    public void test(){
        BaseDao dao = new BaseDao();
        Readers r = new Readers();
        r.setName("pcz");
        r.setPassword("123");
        dao.save(r);
    }
}
