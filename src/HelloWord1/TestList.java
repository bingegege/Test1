package HelloWord1;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/1/29
 */
public class TestList {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Collections.shuffle(list);
//        System.out.println(list);
//        byte a=1;
//        int b=2;
//        System.out.println(a==b);
//        final int c=12|2|1|2|3|4;
//        System.out.println(c);
//        boolean d=true|true|false;
//        System.out.println(d);
//        final List<String> list=null;
//        System.out.println(list.get(0));
        List<Long> a=Lists.newArrayList(111L,222L,333L);
        List<Long> b=Lists.newArrayList(333L,444L,555L);
        a.retainAll(b);
        System.out.println(a);
        String c=null;
        System.out.println(StringUtils.isNotBlank(c));

    }
}
