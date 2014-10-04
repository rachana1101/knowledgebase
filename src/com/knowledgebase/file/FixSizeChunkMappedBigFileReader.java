package com.knowledgebase.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.Time;

public class FixSizeChunkMappedBigFileReader {
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
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer) > 0)
        {
            buffer.flip();
            for (int i = 0; i < buffer.limit(); i++)
            {
                System.out.print((char) buffer.get());
            }
            buffer.clear(); // do something with the data and clear/compact it.
        }
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
