package HelloWord1;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/2/23
 */
public class TestNpe {
    public static void main(String[] args) {
//        test(null);
        Long aa=null;
        long a=aa;
        System.out.println(a);
    }
    public static void test(String a){
        System.out.println(a);
    }
}
