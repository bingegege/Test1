package HelloWord1;

import com.google.common.collect.Lists;

import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/12/21
 */
public class TestForEach {
    public static void main(String[] args) {
        List<Long> arr = Lists.newArrayList(111L, 222L, 333L, 444L);
        arr.forEach(item -> {
            if (item < 333L) {
                System.out.println(item);
            } else {
                return;
            }
            System.out.println(item);
        });
    }
}
