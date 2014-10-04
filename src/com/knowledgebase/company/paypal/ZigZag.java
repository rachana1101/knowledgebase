package com.knowledgebase.company.paypal;
/**
 * 
 * The string "PAYPAL IS HIRING" is written in a zigzag pattern on a given
number of rows like this: (you may want to display this pattern in a
fixed font for better legibility)

P A H N
 A P L S I I G
  Y I R

And then read line by line: PAHNAPLSIIGYIR

Write the code that will take a string and make this conversion given a
number of rows:

String convert(String text, int nRows);

convert("paypalishiring", 3) should return "pahnaplsiigyir"


 * @author rachana
 *
 */
public class ZigZag {
    public static void main(String... argv) {
        System.out.println(strConversion("paypalishiring", 3));
    }
    public static StringBuilder strConversion(String in,int rows)
    {

        StringBuilder[] stb=new StringBuilder[rows];
        StringBuilder out=new StringBuilder();
        int index=0;
        int i=0;
        for(int j=0;j<rows;j++)
        stb[j]=new StringBuilder();
        for(index=0;index<in.length() && i<rows;index++){
            i=0;
            if(index%4==0) //add them to the first row
                stb[i].append(in.charAt(index));
            i++;
            if(index%2!=0) //add them to odd row 
                stb[i].append(in.charAt(index));
            i++;
            if(index%2==0 && index%4!=0) //add them to the 2nd row
                stb[i].append(in.charAt(index));
        }
        for(int j=0;j<rows;j++)
        out.append(stb[j]);

        return out;
    }
}
