package HelloWord1;

import java.math.BigInteger;

/**
 * Function: 
 *
 * @author 你的花名
 * @date 2020/12/7
 */
public class TestDecrypt {
    public static void main(String[] args) {
        Long res=decrypt("3FO4K4VU0FUG");
        System.out.println(res);
        boolean flag=true;
    }
    public static Long decrypt(final String cryptStr) {
        if (cryptStr == null) {
            return null;
        }
        final BigInteger bi = new BigInteger(cryptStr, 35);
        long number = bi.longValue();

        for (int i = 0; i < 4; ++i) {
            number >>= 3;
            number ^= 71284230948672L;
        }

        return number;
    }
}
