package HelloWord1;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *
 * @author zhenghuan
 * @date 2021/5/12
 */
public class TestHashMap {
    public static void main(String[] args) {
        Map<String,List<Integer>> map1=new HashMap<>();
        map1.put("a", Lists.newArrayList(111,222,333));
        map1.put("b",Lists.newArrayList(222,444,333));
        map1.put("c",Lists.newArrayList(555,666,777));
        System.out.println(map1.values().stream().flatMap(Collection::stream).collect(toList()));
//        Collection<Integer> values = map1.values();
//        List<Integer> val=(List<Integer>)values;
//        System.out.println(val);
//        List<Long> aa= Collections.emptyList();
//        System.out.println(aa.get(0));
//        Objects.equals(null,22);
//        HashMap<Long,String> bb=new HashMap();
//        bb.put(null,null);
//        System.out.println(bb.size());
//        final List<FDFD> cc=new ArrayList<>();
//        cc.add(null);
//        FDFD hh=new FDFD();
//        hh.setDd(11);
//        hh.setFgf(22);
//        cc.add(hh);
//        cc.stream().filter(Objects::nonNull).map1(item->item.getDd()).collect(Collectors.toList());
//        Map<Long,String> map1=new HashMap<>();
//        map1.put(1L,"111");
//        map1.put(2L,"222");
//        Map<Long,String> map2=new HashMap<>();
//        map2.put(3L,"333");
//        map2.put(4L,"444");
//        final Map<Long, String> mergedStudioIdIdx = Stream.of(map1, map2)
//                .flatMap(map -> map.entrySet().stream())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1));
//        System.out.println(mergedStudioIdIdx);
        final Map<Long, String> albumCoverIdx=new HashMap<>();
        albumCoverIdx.put(null,"1");
        System.out.println(albumCoverIdx);
    }

}
class FDFD{
    private int dd;

    private int fgf;

    public int getDd() {
        return dd;
    }

    public void setDd(final int dd) {
        this.dd = dd;
    }

    public int getFgf() {
        return fgf;
    }

    public void setFgf(final int fgf) {
        this.fgf = fgf;
    }
}
