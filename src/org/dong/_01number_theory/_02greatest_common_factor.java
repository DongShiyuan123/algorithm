package org.dong._01number_theory;

/**
 * 最大公因数
 * @author Dong
 * @time 2020-02-16 10:54
 */
public class _02greatest_common_factor {

    //辗转相除法,与 a，b大小无关，O(logN)
    static long gcd(long a, long b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        System.out.println(gcd(49, 35));
        System.out.println(gcd(49, 56));
    }
}
