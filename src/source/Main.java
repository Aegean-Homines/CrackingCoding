package source;

import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

public class Main {
	
	private static String chapterPrefix = "source.Chapter";
	private static String testPrefix = "test";
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("Please enter the chapter and the question. Format: <chapter_no>.<question_no>");
		System.out.println("Using \"0\" as your question_no would run all the tests");
		Scanner sc = new Scanner(System.in);
		
		String argument = sc.nextLine();
		String[] chapterAndQuestion = argument.split("\\.");
		sc.close();
		
		JUnitCore junit = new JUnitCore();
		String chapterName = chapterPrefix + chapterAndQuestion[0];
		Result result;
		if("0".equals(chapterAndQuestion[1])){
			result = junit.run(Class.forName(chapterName));
		}else{
			String testName = testPrefix + chapterAndQuestion[1];
			result = junit.run(Request.method(Class.forName(chapterName), testName));
		}
		
		if(result.wasSuccessful())
			System.out.println("Success");
		
		
    }
}
