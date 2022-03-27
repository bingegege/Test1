package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/7/8
 */
public class Test<T> {
    public T val;
    public void show() {
        System.out.println(val.getClass());
        System.out.println(val.toString());
        System.out.println(val.hashCode());

    }
}
class fanxing{
    public static void main(String[] args) {
        Test<Object> demo=new Test();
        demo.show();
    }
}
