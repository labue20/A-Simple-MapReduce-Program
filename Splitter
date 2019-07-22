package mapReduceProgram;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Splitter{

	public static void main(String[] args) {
		if (args.length < 3) {
			System.err.println("Please provide all the required arguments for the splitter");
			return;
		}

		// First argument is the filename		
		String filename = args[0];
		
		// Second argument is the file size in terms of lines		
		int fileSize = Integer.valueOf(args[1]);
		
		// Third argument is the number of the current quarter		
		int quarterNum = Integer.valueOf(args[2]);
		if (quarterNum < 1 || quarterNum > 4) {
			System.err.println("The quarter number argument has to be in range of 1 and 4");
			return;
		}
		
		int linesPerQuarter = fileSize / 4;
		
		// Calculate how many lines we should skip to reach the current quarter		
		int linesToSkip = 0;
		if (quarterNum > 1) {
			linesToSkip = (quarterNum - 1) * linesPerQuarter;
		}

		String fileContent = "";
		try {
			// totalLinesRead tells how many lines we have already read so far
			int totalLinesRead = 0;

			// linesReadForQuarter get increased whenever we read a line from current quarter
			int linesReadForQuarter = 0;
			
			Scanner in = new Scanner(new FileReader(filename));
			while (in.hasNextLine()) {
				// Increase the counter of read lines.				
				totalLinesRead++;
				
				// Check whether we skipped all the lines that we have to skip.				
				if (totalLinesRead <= linesToSkip) {
					in.nextLine();
					continue;
				}
				
				// Add up content as we read				
				fileContent += in.nextLine() + "\n";
				
				linesReadForQuarter++;
				
				// Check if we reached the end of the quarter				
				if (linesPerQuarter == linesReadForQuarter) {
					break;
				}
			} 
		} catch(IOException ex) {}
		
		// Send the read content to the stdout (e.g stemmer)
		System.out.println(fileContent);
	}

}
