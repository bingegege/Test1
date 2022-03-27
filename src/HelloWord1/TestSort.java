package HelloWord1;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author zhenghuan
 * @date 2021/9/29
 */
public class TestSort {
    public static void main(String[] args) {
        List<SortObject> list=new ArrayList<>();
        SortObject a=new SortObject("阿强");
        SortObject b=new SortObject("爸爸");
        SortObject c=new SortObject("你妹");
        SortObject d=new SortObject("安义");
        list.add(c);
        list.add(b);
        list.add(a);
        list.add(d);
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        list.sort((o1, o2) -> comparator.compare(o1.getName(),o2.getName()));
//        list.sort(Collator.getInstance(java.util.Locale.CHINA));
//        list.sort(Comparator.comparing(SortObject::getName).reversed());
        System.out.println(list);
    }
}
class SortObject{
    public SortObject(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SortObject{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;
}
