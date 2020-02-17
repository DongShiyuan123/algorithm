package org.dong._01number_theory;

/**
 * 最小公倍数
 *
 * @author Dong
 * @time 2020-02-16 11:09
 */
public class _03least_common_multiple {

    //辗转相除法,与 a，b大小无关
    static long gcd(long a, long b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    //lcm(a, b) = ab/gcd(a, b),与 a，b大小无关
    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        System.out.println(lcm(4, 7));
        System.out.println(lcm(7, 49));
    }
}