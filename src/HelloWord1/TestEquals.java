package HelloWord1;

import java.util.Objects;

/**
 *
 * @author zhenghuan
 * @date 2021/6/29
 */
public class TestEquals {
    public static void main(String[] args) {
//        String a="11";
//        System.out.println(Objects.equals(a,null));
//        System.out.println(a==null);
//        System.out.println(a.equals(null));
//        TestEquals cc=new TestEquals();
//
//        String b=new String("222");
//        String c=new String("222");
//        System.out.println(b.equals(c));
        wb a=new wb(11);
        wb b=new wb(11);
        System.out.println(a.equals(b));
    }

}
class wb{
    public wb(final int dd) {
        this.dd = dd;
    }

    private int dd;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final wb wb = (wb) o;
        return dd == wb.dd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dd);
    }
}


