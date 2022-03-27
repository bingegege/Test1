package HelloWord1;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/6/15
 */
public class TestArray {
    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        res.add(1);
        res.add(4);
        res.add(2);
        res.add(7);
        System.out.println(res);
        ABC cc=new ABC();
        System.out.println(cc.a);
    }
}
class ABC{
    @NotNull
    public String a;
}
