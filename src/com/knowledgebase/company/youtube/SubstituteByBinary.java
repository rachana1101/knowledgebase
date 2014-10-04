package com.knowledgebase.company.youtube;

public class SubstituteByBinary {

    public static void main(String... argv) {
        String data = "aa*bbb*c";
        data = data.replace("*", ",");
        String[] temp = data.split(",");

        for (int i = 0; i < 3; i++) {
            System.out.println(temp[0].concat("0").concat(temp[1]).concat("1")
                    .concat(temp[2]));
        }
    }
}
