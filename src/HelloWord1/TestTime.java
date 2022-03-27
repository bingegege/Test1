package HelloWord1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2021/1/22
 */
public class TestTime {
    public static void main(String[] args) {
//        System.out.println(generateStudioName("YB"));
        final DateFormat targetFormat = new SimpleDateFormat("yyMMdd");
        final String formattedDate = targetFormat.format(System.currentTimeMillis());
        System.out.println("accelerate-render-"+formattedDate);
    }
    private static String generateStudioName(final String designerName){
        final StringBuilder sb=new StringBuilder(12);
        sb.append(designerName);
        final Random random=new Random();
        for (int i = 0; i <2 ; i++) {
            sb.append(random.nextInt(10));
        }
        final Date currentTime=new Date();
        final SimpleDateFormat s=new SimpleDateFormat("yyMMdd");
        sb.append(s.format(currentTime));
        return sb.toString();
    }
}
