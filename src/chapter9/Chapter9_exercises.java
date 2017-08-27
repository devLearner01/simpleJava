package chapter9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class Chapter9_exercises {

	public Logger log;// = new Logger("Chapter9_exercises...");
	
	public void ex_for_section_9Point1_selfcheck_1() {

		Set<String> s = new HashSet<String>();
		s.add("hello");
		s.add("bye");
		s.addAll(s);

		Set<String> t = new TreeSet<String>();
		t.add("123");
		t.addAll(t);

		System.out.println(s.containsAll(t));
		System.out.println(t.containsAll(s));
		System.out.println(s.contains("ace"));
		System.out.println(s.contains("123"));
		s.retainAll(t);
		System.out.println(s.contains("123"));
		s.retainAll(s);
		System.out.println(s.contains("123"));

	}

	public void ex_for_section_9Point2_programming_1() {

		Map<String, Integer> countWords = new HashMap<String, Integer>();

		// read from file
		try( BufferedReader input = new BufferedReader(new FileReader(new File("Documents/sampleText")) )){

			String line;
			while( (line = input.readLine()) != null ) {
				
				String[] lineWords = line.split(" ");
				
				for(String word : lineWords) {
					
					if( countWords.containsKey(word.toLowerCase())) {
						int value = countWords.get(word);
						countWords.put(word, ++value);
					}
					else {
						countWords.put( word, 1 );
					}
				}
			}
		}  
		catch (IOException e) {
			e.printStackTrace( );
			log.info("couldn't read from input file.");
		}
		
		printHashMap( countWords );	
	}

	
	private void printHashMap( Map<String, Integer> hm ) {
		
		for( Entry e : hm.entrySet()) {
			
			if ( e.getKey() != null)
				System.out.println( e.getKey() + " : " + e.getValue() + " time(s)." );
		}
	}
}
