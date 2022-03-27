package HelloWord1;

import java.math.BigInteger;

/**
 * Function: 
 *
 * @author zhenghuan
 * @date 2020/12/28
 */
public class TestEncrypt {
    public static void main(String[] args) {
        String res=encrypt((long) 62);
        System.out.println(res);
    }
    private static final int SIZE = 4;
    private static final long DEFALUT_KEY = 71284230948672L;
    private static final int DEFALUT_RADIX = 35;
    public static String encrypt(final Long id) {
        if (id == null) {
            return null;
        }
        long number = id;

        for (int i = 0; i < SIZE; ++i) {
            number ^= DEFALUT_KEY;
            number <<= 3;
        }

        return BigInteger.valueOf(number).toString(DEFALUT_RADIX).toUpperCase();
    }
}
