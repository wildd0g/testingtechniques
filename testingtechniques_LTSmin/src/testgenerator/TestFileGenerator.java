package testgenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestFileGenerator {
	private static String inputFilePath = null;
	private static String outputFilePath = null;
	private static BufferedReader reader;
	private static PrintWriter writer;
	private static Pattern p;
	private static Matcher m;
	private static String regEx = null;
	
	private static String fileInterface;
	private static String fileConstructor;
	
	public static void main(String[] args) {
		inputFilePath = args[0];
		outputFilePath = args[1];
		

		try {
			//set reader of input file
			reader = new BufferedReader(new FileReader(inputFilePath));
			
			//set writer to output file and write first line
			writer = new PrintWriter(new FileWriter(outputFilePath), false);
			writer.println("#include <check.h>");
			
			
			
			
			//define patern from regEx for matching
			p = Pattern.compile(regEx);
			

			
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public String getInterface() {
		return fileInterface;
	}
	
	public String getConstructor() {
		return fileConstructor;
	}
}
