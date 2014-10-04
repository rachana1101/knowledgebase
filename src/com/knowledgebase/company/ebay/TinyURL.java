package com.knowledgebase.company.ebay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class TinyURL {
    
    private static final String tinyUrl = "http://tinyurl.com/api-create.php?url=";
    
    public static String  shorter(String url) throws IOException {
      String tinyUrlLookup = tinyUrl + url;
      BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(tinyUrlLookup).openStream()));
      String tinyUrl = reader.readLine();
      return tinyUrl;
    }
    
    public static void main(String argv[]) throws IOException {
        System.out.println(shorter("www.yahoo.com"));
    }

}
