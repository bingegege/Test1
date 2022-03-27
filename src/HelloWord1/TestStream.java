package HelloWord1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/3/17
 */
public class TestStream {
    public static void main(String[] args) {
//        List<Long> a=new ArrayList<>();
//        a.add(11L);
//        a.add(22L);
//        a.add(33L);
//        final List<Long> b = a.stream().filter(item -> item.equals(11L)).collect(
//                Collectors.toList());
//        System.out.println(a.size());
//        System.out.println(b.size());
        List<String> list=new ArrayList<>();
        final List<String> collect = list.stream().map(item -> item += "11").collect(
                Collectors.toList());
        System.out.println(collect.toString());
        System.out.println(collect);
        System.out.println(collect.size());
    }
}
