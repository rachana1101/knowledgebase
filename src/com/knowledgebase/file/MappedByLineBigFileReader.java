package com.knowledgebase.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Time;

public class MappedByLineBigFileReader {
    public static void main(String argv[]) throws IOException {
        long startTime = System.currentTimeMillis();
        /*
        BufferedReader reader = new BufferedReader(new FileReader("/Users/rachana/part-00000"));
        String line = null;
        while((line = reader.readLine())!=null) {
            System.out.println(line);
        }*/
        
        RandomAccessFile aFile = new RandomAccessFile
                ("/Users/rachana/part-00000", "r");
        FileChannel inChannel = aFile.getChannel();
        MappedByteBuffer mmb = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        try {
            byte[] buffer = new byte[(int)inChannel.size()];
            mmb.get(buffer);
            BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)));

            for (String line = in.readLine(); line != null; line = in.readLine()) {
              System.out.println(line);
            }

        } catch(Exception e) {
            
        } finally {
           // buffer.clear(); // do something with the data and clear/compact it.
            inChannel.close();
            aFile.close();
        }
        
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
