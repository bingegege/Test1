package HelloWord1;

import com.google.common.collect.Sets;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2020/12/30
 */
public class TestSet {
    public static void main(String[] args) {
//        String[] s1=new String[]{"aa","bb","cc","aa"};
//        Set<String> set=new HashSet<>();
//        set.addAll(Arrays.asList(s1));
//        System.out.println(set);
//        String[] s2=new String[]{"aa","bb","cc"};
//        StringBuilder sb=new StringBuilder();
//        sb.append("a"+",");
//        sb.append("b"+",");
//        sb.append("c"+",");
//        System.out.println(sb.toString());
//        sb.delete(sb.length()-1,sb.length());
//        System.out.println(sb.toString());
//        String s="aaaa";
//        String[] str=s.split(",");
//        for (String s1 : str) {
//            System.out.println(s1);
//        }
        final HashSet<Integer> set = Sets.newHashSet(111, 222, 333);
        System.out.println(set.contains(232));
        final Set<String> set1= Sets.newHashSet("444");
        final Set<String> set2= Sets.newHashSet("444");
        set1.add("111");
        set1.add("222");
        set1.add("333");
        System.out.println(set1.addAll(set2));
        System.out.println(set1);
    }
}
