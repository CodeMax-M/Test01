import com.mimissm.utils.MD5Util;
import org.junit.Test;

/**
 * @Title:
 * @Description:
 * @author: FZX
 * @date: 2021/9/4 23:27
 */
public class MyTest {
    @Test
    public void testMD5(){
     String pw=   MD5Util.getMD5("000000");
        System.out.println(pw);

    }
}
