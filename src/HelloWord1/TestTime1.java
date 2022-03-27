package HelloWord1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/2/26
 */
public class TestTime1 {
    public static void main(String[] args) throws ParseException {
//        Date d=new Date();
//        System.out.println(d.getTime());
//        String beginDate = "1435845268096";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String sd = sdf.format(new Date(Long.parseLong(beginDate))); // 时间戳转换日期
//        System.out.println(sd);
//        try {
//            System.out.println(dateToStamp("2015-07-02 21:54:28"));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println(System.currentTimeMillis());
        System.out.println(stampToDate(""+System.currentTimeMillis()));
        System.out.println(dateToStamp(stampToDate(""+System.currentTimeMillis())));
        System.out.println(date1ToDate2(stampToDate(""+System.currentTimeMillis())));
    }
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String date1ToDate2(String s) throws ParseException {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat targetFormat = new SimpleDateFormat("yyMMdd");
        Date date = originalFormat.parse(s);
        String formattedDate = targetFormat.format(date);  // 20120821
        return formattedDate;
    }
}
