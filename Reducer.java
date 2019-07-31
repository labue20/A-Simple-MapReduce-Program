package mapReduceProgram;

import java.util.concurrent.TimeUnit; 
import java.util.concurrent.TimeoutException; 
import java.util.concurrent.BrokenBarrierException; 
import java.util.concurrent.CyclicBarrier;  
import java.util.Arrays;
import java.util.*;
import java.io.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Reducer extends Thread
{
    private static Socket socket;
    private CyclicBarrier barrier;
    
@Override
  public void run() 
    {      
            
        try{ 
            /*
          
            */
           //reading stream fromthe  mapper
            Reader reader = new InputStreamReader(System.in);      

        	BufferedReader breader = new BufferedReader(reader);
            
            String receivedString = breader.readLine();
            System.out.println(receivedString);
        
           
           
           //Reader reader = new InputStreamReader(System.in);
           //BufferedReader br = new BufferedReader(reader);
           
        }catch (Exception e) 
        { 
            System.out.println ("Exception is caught"); 
        }
        finally
        {
            try
            {
                socket.close();
            }catch(Exception e){}
        }
         
    } 
  
  
  
    public static void main(String args[]) throws InterruptedException, BrokenBarrierException, IOException{
     /*
     Test vals 
     __________  
     Hashtable<String, Integer> h = new Hashtable<String, Integer>(); 
     String stemWords = "Lorem 1,Ipsum 1,is 1,simply 1,dummy 1,text 1,of 1,the 1,printing 1,and 1,typesetting 1,industry 1,";
     String[] words = stemWords.split("[ ,]");  
   
     for (int i = 0; i < words.length; i += 2) {
               h.put(words[i],Integer.parseInt(words[i + 1]));
             }
     System.out.println(Arrays.asList(h));
     for(int i = 0; i < words.length; i++)
     {
        System.out.print(words[i]);
        }
        */
       //creating the barrier
    	
    	System.out.println("Server started.");
        int port = 5000;
        
        ServerSocket serverSocket = new ServerSocket(port);
        
        Socket serverClient = serverSocket.accept();
        System.out.println("Client connected.");
        
        DataInputStream istream = new DataInputStream(serverClient.getInputStream());
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        
        String receivedString = receiveRead.readLine();
        System.out.println(receivedString);
        
       CyclicBarrier newBarrier = new CyclicBarrier(4);
       Reader reader = new InputStreamReader(System.in);      
       BufferedReader breader = new BufferedReader(reader);
       Hashtable<String, Integer> h = new Hashtable<String, Integer>(); 
       int wordcount = 0;
       String stemWords = "";
       
       
       
       
       Thread t1 = new Thread(new Reducer());
       Thread t2 = new Thread(new Reducer());
       Thread t3 = new Thread(new Reducer());
       Thread t4 = new Thread(new Reducer());
       
       
       
       t1.run();
       
       stemWords = breader.readLine();
       String[] words = stemWords.split("[, ]");
           for (int i = 0; i < words.length; i += 2) {
               h.put(words[i], Integer.parseInt(words[i + 1]));
              }
       newBarrier.await();
       System.out.println("Hello?");
       t2.start();
       stemWords = breader.readLine();
       words = stemWords.split("[, ]");
           for (int i = 0; i < words.length; i += 2) {
               h.put(words[i], Integer.parseInt(words[i + 1]));
              }
       t3.start();
       stemWords = breader.readLine();
       words = stemWords.split("[, ]");
           for (int i = 0; i < words.length; i += 2) {
               h.put(words[i], Integer.parseInt(words[i + 1]));
              }
       t4.start();
       stemWords = breader.readLine();
       words = stemWords.split("[, ]");
           for (int i = 0; i < words.length; i += 2) {
               h.put(words[i], Integer.parseInt(words[i + 1]));
              }
       
       for(int value : h.values()){
           wordcount += value;
        }
       
       socket.close();
       
       System.out.println(wordcount);
       //populating the hashtable
       
       
   }     
  

  
    

}