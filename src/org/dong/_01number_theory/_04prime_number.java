package org.dong._01number_theory;

/**
 * @author Dong
 * @time 2020-02-16 11:23
 * 素数
 */
public class _04prime_number {

    //判断素数，O(√n)
    static boolean isPrime1(long n) {
        if (n == 1) return false;
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    //判断素数，当 n 过大时可能会出错,一般不会错
    static boolean isPrime2(long n) {
        if (n == 2 || n == 3 || n == 5) return true;
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n == 1) return false;
        long c = 7;
        long a[] = {4, 2, 4, 2, 4, 6, 2, 6};
        while (c * c <= n)
            for (int i = 0; i < a.length; i++) {
                if (n % c == 0) return false;
                c += i;
            }
        return true;
    }

    /*----------------------------------------------------------------------------------*/
    //素数筛，不超过 n 的所有素数，O(nlogn)
    //p[]为空数组，用于带回p[i]为true的值
    static void getPrime(boolean p[], int n) {
        for (int i = 1; i <= n; i++) p[i] = true;
        p[1] = false;
        for (int i = 2; i <= n; i++) {
            if (p[i]) {
                for (int j = i + i; j <= n; j += i) p[j] = false;
            }
        }
    }

    //素数筛，不超过 n 的所有素数，O(n)
    static long getPrime(long n, boolean vis[], int prime[]) {
        int tot = 0;
        for (int i = 1; i <= n; i++) vis[i] = false;
        for (int i = 2; i <= n; i++) {
            if (!vis[i]) prime[tot++] = i;
            for (int j = 0; j < tot; j++) {
                if (prime[j] * i > n) break;
                vis[prime[j] * i] = true;
                if (i % prime[j] == 0) break;
            }
        }
        return tot;
    }

    public static void main(String[] args) {
        System.out.println(isPrime1(29));
        System.out.println(isPrime2(18));


        boolean[] p=new boolean[11];
        getPrime(p, 10);
        for (int i = 1; i <= 10; i++) {
            if(p[i]){
                System.out.println(i);
            }
        }

    }
}
