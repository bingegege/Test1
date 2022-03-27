package HelloWord1;

import java.util.ArrayList;

/**
 *
 * @author zhenghuan
 * @date 2021/9/14
 */
public class TestFanXing {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
    }
}

