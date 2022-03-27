package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/4/22
 */
public class TestBB implements TestInterface{

    static Integer b;

    @Override
    public boolean test() {
        return false;
    }

    public static void testA(){
        System.out.println("111");
    }

    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(b);
        testA();
    }
}
