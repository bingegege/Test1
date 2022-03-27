package HelloWord1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 你的花名
 * @date 2021/4/8
 */
public class TestTimestamp {
    public static void main(String[] args) {
//        final long nowTimestamp1 = System.currentTimeMillis()/1000;
//        final long a= 1627605000L;
//        System.out.println(a<=nowTimestamp1);
//        final long expireTime = LocalDateTime.now().plusMonths(1).atZone(ZoneId.systemDefault())
//                .toInstant().toEpochMilli();
//        System.out.println(expireTime);
//        final Timestamp timestamp=new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
//        System.out.println(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd"));
//
//        Timestamp a=Timestamp.valueOf("2018-05-18 09:32:32");
//        Timestamp b=Timestamp.valueOf("2018-05-19 09:32:32");
//        System.out.println(b.before(new Timestamp(System.currentTimeMillis())));
//        System.out.println(new Timestamp(System.currentTimeMillis()));
        final long a = System.currentTimeMillis();
        Timestamp s=new Timestamp(a);
        System.out.println(a);
        System.out.println(s);
        System.out.println(s.getNanos());

    }
}
