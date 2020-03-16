package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CounterWords {
	public static void main( String[] args ) throws FileNotFoundException
    {
    	String text = "";
    	File myObj = new File(args[0]);
    	Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        	text = text + myReader.nextLine();
        }
        myReader.close();
    	
        text = text.toLowerCase();
        String[] wordsPlusSpaces = text.split("\\W+");
        
        List<String> allWords = new ArrayList<String>(Arrays.asList(wordsPlusSpaces));
        allWords.removeAll(Arrays.asList("", null));
        
        List<Object> allWordsWithoutDuplicates = allWords.stream().distinct().collect(Collectors.toList());
        
        allWordsWithoutDuplicates.stream().forEach(word->
        	System.out.println(word.toString().substring(0, 1).toUpperCase() + 
        			word.toString().substring(1)+": "+allWords.stream().
        			filter((value) -> value.matches(word.toString())).count()));    
    }

}
