package com.knowledgebase.company.samsung.dynamicProgramming;

/**
 * Find the factorial using Dynamic programming
 * 
 * @author rachana
 * 
 */
public class Factorial {

    public static void main(String[] argv) {
        System.out.println(findFac(10));
    }

    public static long findFac(int N) {
        long fac[] = new long[N + 1];
        if (N == 0 || N == 1) {
            return 1;
        } else {
            if (fac[N] != 0) {
                return fac[N];
            } else {
                return fac[N] = N * findFac(N - 1);
            }
        }
    }
}
