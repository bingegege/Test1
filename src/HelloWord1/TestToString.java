package HelloWord1;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/2/24
 */
public class TestToString {
    public static void main(String[] args) {
        AA b=new AA();
        System.out.println(b);
    }
}
class AA{
    private int a=1;

    @Override
    public String toString() {
        return "AA{" +
                "a=" + a +
                '}';
    }
}
