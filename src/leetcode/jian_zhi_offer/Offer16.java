package leetcode.jian_zhi_offer;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 *
 * @author zhenghuan
 * @date 2022/2/21
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }

    public double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow1(x, n / 2);
        double mod = myPow1(x, n % 2);
        return half * half * mod;
    }

    public static void main(String[] args) {
        System.out.println(-5 % 2);
        System.out.println(-5 / 2);
        System.out.println(1 / (double) 3);
        int ii = 300;
        byte b = (byte) ii;
        System.out.println(b);
    }
}

