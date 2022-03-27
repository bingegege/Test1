package HelloWord1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/7/6
 */
public class TestType {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(a.getClass());
    }
}
