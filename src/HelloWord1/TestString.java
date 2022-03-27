package HelloWord1;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author zhenghuan
 * @date 2021/4/14
 */
public class TestString {
    public static void main(String[] args) {
//        String[] b = s.split("\\r?\\n");
//        System.out.println(Arrays.asList(b));
//        String s="";
//        System.out.println(s.length());
        String s = "10017\n" +
                "100816\n" +
                "100815\n" +
                "100813\n" +
                "100811\n" +
                "100199\n" +
                "100198\n" +
                "100197\n" +
                "100196\n" +
                "100195\n" +
                "100194\n" +
                "100193\n" +
                "100192\n" +
                "100191\n" +
                "10019\n" +
                "10018\n" +
                "1001\n" +
                "10016\n" +
                "10014\n" +
                "10012\n" +
                "1012\n" +
                "1011\n" +
                "1010\n" +
                "1009\n" +
                "1008\n" +
                "1007\n" +
                "1006\n" +
                "1005\n" +
                "1004\n" +
                "1003\n" +
                "1002\n";
        String[] b = s.split("\\r?\\n");
        System.out.println(Arrays.asList(b));
    }
}
