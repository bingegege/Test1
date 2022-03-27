package HelloWord1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author zhenghuan
 * @date 2021/5/24
 */
public class TestLinkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();
        linkedHashMap.put(0,"000");
        linkedHashMap.put(3,"111");
        linkedHashMap.put(2,"222");
        linkedHashMap.put(300,"300");
        linkedHashMap.put(41,"41");
        linkedHashMap.put(45,"42");
        linkedHashMap.put(400,"42");
        linkedHashMap.put(399,"42");
        linkedHashMap.put(1000,"42");
        for (Map.Entry<Integer, String> integerStringEntry : linkedHashMap.entrySet()) {
            System.out.println(integerStringEntry.getKey());
        }
    }
}
