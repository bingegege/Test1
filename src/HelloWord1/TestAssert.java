package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/5/19
 */
public class TestAssert {
    public static void main(String[] args) {
        test(null);
    }
    static void test(Long userid){
        assert userid!=null;
        System.out.println(userid);
    }
}
