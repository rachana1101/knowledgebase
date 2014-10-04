package com.knowledgebase.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MergeAlreadySortedFiles {

    public static void main(String... argv) throws IOException {
        ArrayList<BufferedReader> mergefbr = new ArrayList<BufferedReader>();
        PriorityQueue<String> heap = new PriorityQueue<String>();
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/file/output.csv"));
        try {
            
            for(int i=1;i<=4;i++) {
                BufferedReader reader = new BufferedReader(
                    new FileReader(
                            "/Users/rachana/Workspaces/board_temp/knowledgebase/src/com/knowledgebase/file/file"+i+".csv"));
                mergefbr.add(reader);
            }
            ArrayList list =  new ArrayList();
            for(BufferedReader reader : mergefbr) {
                String line = null;
                int ctr = 0;
                while ((line = reader.readLine()) != null && ctr==0) {
                    if (line != null && line != "") {
                        String[] data = line.split(",");
                        list.add(data[0]);
                        writer.append(list.toString());
                    }
                    ctr++;
                }
                Collections.sort(list);
            }
            
            
          
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //reader.close();
        }
    }
    
    

}
