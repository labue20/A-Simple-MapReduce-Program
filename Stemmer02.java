//package mapReduceProgram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.Reader;

public class Stemmer02 {
    public static void main(String[] args) throws IOException {

        removeStopWords();
    }

    public static String removeStopWords() throws IOException {

        //an array of stopwords
        String stopWords [] = {"i", "a", "about","an","are","as","at","be","by","com","for","from",
                "how","in", "is","it", "of","on","or","that","the","this","to","was","what",
                "when","where","who","will","with", "but","and", "from",
                "its","has", "only", "It","also","not"};

        String wordList = Arrays.toString(stopWords); //an array list to store the stopWords

        //this reads a text file
	/*	BufferedReader br = new BufferedReader(new
				FileReader("/Users/labuew/Desktop/text.txt"));

		br.readLine();
		String line ;




		StringBuilder builder = new StringBuilder();

		//String []allWords = str.trim().split(" ");

		for(String word: allWords) {
			if(!wordList.contains(word)) {
				builder.append(word);
				builder.append(' ');
			}
		}

		String result = builder.toString().trim();

		System.out.println(result);



		return null;
	}

*/
        //this read a text file line by line
        //File file = new File(System.in);
       // BufferedReader br;

        try {


            StringBuilder  sb = new StringBuilder();

            Reader reader = new InputStreamReader(System.in);//reads input from standard input
            BufferedReader br = new BufferedReader(reader);
            br.readLine();


            String line;
            while((line = br.readLine())!=null) {
                //	sb.append(line);
                //sb.append(line +System.lineSeparator());


                //remove spaces
                String []allWords = line.trim().split(" ");//remove spaces from the textfile
                //compares the stopwords with the textfile and remove stopwords from the text file
                for(String word: allWords) {
                    if(!wordList.contains(word)) {
                        sb.append(word);
                        sb.append(' ');
                    }
                }
            }
            String result = sb.toString().trim();//trim the output

            System.out.println(result);// this print the result to the console or as standard output


            //System.out.println(sb);;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}


















