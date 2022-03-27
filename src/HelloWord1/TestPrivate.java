package HelloWord1;

/**
 *
 * @author zhenghuan
 * @date 2021/5/14
 */
public class TestPrivate {
    public static void main(String[] args) {
        BBB temp=new BBB();
    }
}
class BBB{
    private Integer a=1;
    protected Integer getA(){
        return a;
    }
}
