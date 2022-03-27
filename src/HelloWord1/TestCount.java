package HelloWord1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/11/23
 */
public class TestCount {
    public static void main(String[] args) {
        final List<Long> aa=new ArrayList<>();
        aa.add(10L);
        aa.add(20L);
        aa.add(30L);
        aa.add(40L);
        System.out.println(aa.stream().mapToInt(Long::intValue).sum());
    }
}
