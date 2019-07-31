
import java.io.*;
import java.util.*;

public class Mapper03 {

    public static void Mapper(String stemWords) {

        //check if the stemWords is null , if not strim the strings and append 1 to each word
        if (stemWords != null) {

            String[] words = stemWords.split(" ");//split the strings and remove spaces
            //appends a 1 to each word
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i] + " 1";
            }

            for (int i = 0; i < words.length; i++) {
                System.out.print(words[i] + ",");//prints the output to console

            }

        }
    }

    public static void main(String[] args) throws IOException {

        //reads standard input using inputStream Reader 
        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String x = br.readLine(); 
        Mapper(x); //calls the mapper method
    }
}
