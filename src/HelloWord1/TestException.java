package HelloWord1;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/3/2
 */
public class TestException {
    public static void main(String[] args) {
        try {
            test();
        } finally {
            System.out.println("321");
        }
        System.out.println("333");
        System.out.println("444");
    }
    public static void test(){
        System.out.println("111");
        int a=10/0;
        System.out.println("555");
    }
}
