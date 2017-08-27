package chapter9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import devLearner01_simpleJava.GlobalConstants;

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

	/**
	 * this method counts every word of the given text
	 * @param filePath the file to be scanned
	 */
	public void ex_for_section_9Point2_programming_1( String filePath) {

		Map<String, Integer> countWords = new HashMap<String, Integer>();

		// read from file
		try( BufferedReader input = new BufferedReader(new FileReader(new File(filePath )))){

			String line;
			while( (line = input.readLine()) != null ) {
				
				String[] lineWords = line.split(" ");
				
				for(String word : lineWords) {
					
					if( countWords.containsKey(word.toLowerCase())) {
						int value = countWords.get( word.toLowerCase() );
						countWords.put(word.toLowerCase(), ++value);
					}
					else {
						countWords.put( word.toLowerCase(), 1 );
					}
				}
			}
			
			printHashMap( countWords );	
			writeResToFile( countWords );	
		}  
		catch (IOException e) {
			e.printStackTrace( );
			log.info("couldn't read from input file or couldn't create result file.");
		}
	}

	
	private void printHashMap( Map<String, Integer> hm ) {
		
		for( Entry<String, Integer> e : hm.entrySet()) {
			
			if ( e.getKey() != null)
				System.out.println( e.getKey() + " : " + e.getValue() + " time(s)." );
		}
	}
	
	private void writeResToFile( Map<String, Integer> hm  ) throws IOException{

		
		File fResFile = new File( GlobalConstants.RESULT_FILE );
		fResFile.createNewFile();
		
		
		try {
			BufferedWriter output = new BufferedWriter( new FileWriter( fResFile ));
			
			for( Entry<String, Integer> e : hm.entrySet()) {
				
				if ( e.getKey() != null)
					output.write( e.getKey().toLowerCase() + " : " + e.getValue() );
					output.newLine();	
			}
			output.close();
	
		} 
		catch ( IOException e2 ) {
			e2.printStackTrace();
			log.info( "error while writing result to file." );
		}
	}

	
}
