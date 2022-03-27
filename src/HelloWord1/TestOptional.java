package HelloWord1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.common.base.Optional;

/**
 *
 * @author zhenghuan
 * @date 2021/7/8
 */
public class TestOptional {
//    public static void main(String[] args) {
//        test();
//    }
//
//    static void test(){
//        String a;
//        Optional<String> demo=Optional.ofNullable(a);
//        String b=demo.orElse("bbbb");
//        System.out.println(b);
//    }
    public static void main(String[] args) {
//        List<Object> a=new ArrayList<>();
//        a.add(11);
//        System.out.println(Optional.ofNullable(a).orElse(Collections.emptyList()));
        Integer a=null;
        System.out.println(Optional.fromNullable(null).orNull());
    }
}
