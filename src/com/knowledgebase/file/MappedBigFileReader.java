package com.knowledgebase.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Time;

public class MappedBigFileReader {
    public static void main(String argv[]) throws IOException {
        long startTime = System.currentTimeMillis();
        

        RandomAccessFile aFile = new RandomAccessFile
                ("/Users/rachana/part-00000", "r");
        FileChannel inChannel = aFile.getChannel();
        System.out.println(" Size of file "+aFile.length());
        System.out.println(" Size of channel "+inChannel.size());
        int length = 0x8FFFFFF; // 128 Mb
        MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, length);
        buffer.load(); 
        for (int i = 0; i < buffer.limit(); i++)
        {
            System.out.print((char) buffer.get());
        }
        buffer.clear(); // do something with the data and clear/compact it.
        inChannel.close();
        aFile.close();

        int mb = 1024*1024;
        
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
         
        System.out.println("~~~~~~ Heap utilization in MB ~~~~~~");
        
        long endTime = System.currentTimeMillis();
        System.out.println(" Start Date  "+new Time(startTime));
        System.out.println(" End Date "+new Time(endTime));
        //Total time used 
        System.out.println(" Time used "+ (endTime - startTime)/1000);
         
        //Print used memory
        System.out.println("Used Memory In MB:"
            + (runtime.totalMemory() - runtime.freeMemory()) / mb);
 
        //Print free memory
        System.out.println("Free Memory:"
            + runtime.freeMemory() / mb);
         
        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
 
        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
        
        
    }
}
