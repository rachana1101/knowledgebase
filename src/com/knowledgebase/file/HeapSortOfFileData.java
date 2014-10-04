package com.knowledgebase.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class HeapSortOfFileData {
    
    public static void main(String... argv) throws IOException {
        BufferedReader reader = null;
        StringMinHeap heap = new StringMinHeap(1000);
        StringMinHeap heap1 = new StringMinHeap(1000);
        StringMinHeap heap2 = new StringMinHeap(1000);
        TreeSet<String> sortedList = new TreeSet<String>();
        TreeSet<String> sortedList1 = new TreeSet<String>();
        
        try {
            reader = new BufferedReader(new FileReader("/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/file/log1.txt"));
            String line = null;
            while((line = reader.readLine())!=null) {
                //System.out.println(line);
                if(line!=null && line!="") {
                    System.out.println(line);
                    heap.insert(line);
                }
            }
            
            sortedList.add(heap.remove());
            sortedList.add(heap.remove());
            
            sortedList1.add(heap.remove());
            sortedList1.add(heap.remove());
            
            
            reader = new BufferedReader(new FileReader("/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/file/log2.txt"));
            line = null;
            while((line = reader.readLine())!=null) {
                //System.out.println(line);
                if(line!=null && line!="") {
                    System.out.println(line);
                    heap1.insert(line);
                }
            }
            
            sortedList.add(heap1.remove());
            sortedList.add(heap1.remove());
            
            sortedList1.add(heap1.remove());
            sortedList1.add(heap1.remove());
            
            
            reader = new BufferedReader(new FileReader("/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/file/log3.txt"));
            line = null;
            while((line = reader.readLine())!=null) {
                //System.out.println(line);
                if(line!=null && line!="") {
                    System.out.println(line);
                    heap2.insert(line);
                }
            }
            
            sortedList.add(heap2.remove());
            sortedList.add(heap2.remove());
            
            sortedList1.add(heap2.remove());
            sortedList1.add(heap2.remove());
            
            System.out.println();
            System.out.println(Arrays.toString(sortedList.toArray()));
            System.out.println(Arrays.toString(sortedList1.toArray()));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        
    }

}
