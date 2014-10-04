package com.knowledgebase.company.samsung.dynamicProgramming;

/**
 * 0 1 1 2 3 5 8
 * @author rachana
 *
 */
public class Fibonacci {

    public static void main(String[] args) {
        // print results
        System.out.println(fibo(10));
    }
    
    public static long fibo(int N) {
        long[] fib = new long[N+1];
        // base cases
        fib[0] = 0;
        fib[1] = 1;

        // bottom-up dynamic programming
        for (int n = 2; n <= N; n++) {
            fib[n] = fib[n-1] + fib[n-2];
        }
        return (int) fib[N];
    }
    
    public static long fibo1(int N) {
        int base0 = 1; int base1 = 1; int sum = 0;
        for(int i=3;i<N;i++) {
            sum = base0+base1;
            base0 = base1;
            base1 = sum;
        }
        return sum;
    }
}
