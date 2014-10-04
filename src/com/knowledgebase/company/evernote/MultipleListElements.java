package com.knowledgebase.company.evernote;

public class MultipleListElements {

    public static void main(String... argv) {
        int[] arr = new int[] { 1, 2, 3, 4 };
        int start = 0;
        int end = arr.length;
        int flag = 0;
        int mul = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                flag++;
            if (arr[i] != 0)
                mul *= arr[i];
        }
        System.out.println(mul);
        for (int i = 0; i < arr.length; i++) {

            if (flag > 0)

                if (arr[i] == 0)
                    if (flag > 1)
                        System.out.println(0);
                    else
                        System.out.println(mul);
                else
                    System.out.println(0);
            else
                System.out.println(mul / arr[i]);
        }

    }

}
