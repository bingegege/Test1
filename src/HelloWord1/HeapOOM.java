package HelloWord1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhenghuan
 * @date 2021/4/26
 */

public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            // 疯狂创建对象
            list.add(new OOMObject());
        }
    }
}

