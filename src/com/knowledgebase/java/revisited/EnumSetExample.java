package com.knowledgebase.java.revisited;

import java.util.EnumSet;

/**
 * Reference : http://javarevisited.blogspot.com/2014/03/how-to-use-enumset-in-java-with-example.html 
 * To learn about the enumset
 * @author rachana
 *
 */
public class EnumSetExample {
    
    public static void main(String[] argv) {
        EnumSet<Status> openButFlagged = EnumSet.of(Status.Open, Status.Flagged);
        System.out.println(openButFlagged);
    }

    public enum Status {
        Undefined, Open,Flagged, Closed;
    }
}
