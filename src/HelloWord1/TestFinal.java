package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/9/26
 */
public class TestFinal {
    public boolean aa;

    public boolean isAa() {
        return aa;
    }

    public static void main(String[] args) {
        final Long userId;
        if(false){
            userId=1L;
        }
        TestFinal t=new TestFinal();
        System.out.println(t.isAa());
    }
}
