package com.example.demo.eureka.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class FileTest {
   /* public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("D:\\新建文本文档.txt");
            byte[] bytes = new byte[1024];
            int len;
            while ( (len = file.read(bytes))!=-1){
                System.out.println(Arrays.toString(bytes));
                System.out.println(len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }*/
   public static void main(String[] args) {
       ExecutorService executorService = Executors.newFixedThreadPool(2);
       Collection<Callable<Integer>> collection = new ArrayList();
       collection.add(()-> 1);
       collection.add(()-> 2);
       try {
           List<Future<Integer>> futures = executorService.invokeAll(collection,0L,TimeUnit.SECONDS);
           futures.forEach(e-> {
               try {
                   System.out.println(e.get());
               } catch (InterruptedException e1) {
                   e1.printStackTrace();
               } catch (ExecutionException e1) {
                   e1.printStackTrace();
               }
           });
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
