package HelloWord1;

import com.sun.istack.internal.NotNull;

/**
 *
 * @author zhenghuan
 * @date 2021/9/29
 */
public class TestNull {
    public static void main(String[] args) {
        final ABV abv = new ABV();
        System.out.println(abv.getName());
    }
}
class ABV{
    @NotNull
    private String name;

    public String getName() {
        return name;
    }
}
