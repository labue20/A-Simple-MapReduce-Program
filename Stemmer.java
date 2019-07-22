package mapReduceProgram;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Stemmer {
	
	//this method reads a text file 
	/*
	public static String loadStopwords() throws IOException {
		
		File file = new File("/Users/labuew/Desktop/text.txt");
		BufferedReader br;
		
		try {
	
		
		StringBuilder  sb = new StringBuilder();
		InputStream in = new FileInputStream(file);
		 br = new BufferedReader(new InputStreamReader(in));
		
		String line;
		while((line = br.readLine())!=null) {
		//	sb.append(line);
			sb.append(line +System.lineSeparator());
		
		}
		System.out.println(sb);;
		} catch(IOException e) {
			e.printStackTrace();
		}
		   return null;
    }
	
	*/
	public static String removeStopWords () throws IOException{
		
		String [] stopWords = {"i", "a", "about","an","are","as","at","be","by","com","for","from","how","in", "is","it",
              "of","on","or","that","the","this","to","was","what","when","where","who","will","with", "but","and", "from",
              "its","has", "only", "It","also","not"};
		
		//FileInputStream textFile = new FileInputStream("/Users/labuew/Desktop/text.txt");
		//FileInputStream stopWords = new FileInputStream("/Users/labuew/Desktop/stopWords.txt");
		
		
		ArrayList<String> wordsList = new ArrayList<String>();
		
		//this read a file from a local directory
		BufferedReader br = new BufferedReader(new FileReader("/Users/labuew/Desktop/text.txt"));
	    StringBuilder sb = new StringBuilder();
	    
	    String textFile = br.readLine();
	    while(textFile != null) {
	    	sb.append(textFile).append("\n");
	    	textFile = br.readLine();
	    	
	    	//pass a file as strings
	    	String fileAsString = sb.toString();
	    	fileAsString = fileAsString.trim().replaceAll("\\s+"," ");//split the strings and remove spaces
	    	
	    	String [] words = fileAsString.split(" ");
	    	for(String word: words) {
	    		wordsList.add(word);
	    	}
	    	//remove the stop words
	    	for(int i =0 ; i < wordsList.size(); i++) {
	    		//get the item as string
	    		for(int j = 0; j <stopWords.length; j++) {
	    			if(stopWords[j].contains(wordsList.get(i))) {
	    				
	    			
	    			wordsList.remove(i);
	    		}
	    	}
	    	
	    }
	    	//
	    	for(String str: wordsList) {
	    		System.out.print(str +  " " );
	    	
	    	}
	   }
	
	return null;
}

}	
	
		
		
		//while((String line = textFile.readLine()))
		
		
		
		
		
		
	























