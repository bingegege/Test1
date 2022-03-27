package HelloWord1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/9/7
 */
public class TsetFanxing {
    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());
    }

    public static <T extends Number> void addTExtend(List<T> list, T e){
        list.add(e);
    }

    public static <T extends Number> void addTExtend1(List<? super T> list, T e){
        list.add(e);//不会报错，由于限定了T的子类及T自身，限定通配符可以进行写操作
    }

//    public static <T extends Number> void addTExtend2(List<?> list, T e){
//        list.add(e);//会报错，由于通配符可泛指任何类型对象，所以在写操作后，List集合内不知道是什么类型而不允许操作
//    }

}
