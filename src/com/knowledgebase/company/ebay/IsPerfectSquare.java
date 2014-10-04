package com.knowledgebase.company.ebay;

public class IsPerfectSquare {
    public static void main(String argv[]) {
        System.out.println(IsPerfectSquare(400));
    }
    
    public static boolean IsPerfectSquare(int n)
    {
      if (n == 1) return true;
      if (n < 4) return false;

      int min = 2;
      int max = n / 2;
      do
      {
        int div = (max + min) / 2;
        System.out.println(" div "+div);
        int res = n / div;
        System.out.println(" res "+res);
        if (res * res == n) return true;

        if (res < div)
        {
          min = res;
          max = div;
        }
        else
        {
          min = div;
          max = res;
        }
      } while (max > (min + 1));
      return false;
    }

}
