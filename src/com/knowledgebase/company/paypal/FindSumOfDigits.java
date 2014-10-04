package com.knowledgebase.company.paypal;

public class FindSumOfDigits {
    public static void main(String... s) {
        System.out.println(f(154));
        System.out.println(fwithoutR(154, 0));
    }

    static int f(int num) {
        int out = 0;

        for (; num > 0; num /= 10) {
            int d = num % 10;
            out *= 10;
            out += d;
        }

        return out;
    }

    static int fwithoutR(int num, int out) {
        if (num == 0) {
            return out;
        } else {
            int d = num % 10;
            out *= 10;
            out += d;
            num = num / 10;
            return fwithoutR(num, out);
        }
    }
}
