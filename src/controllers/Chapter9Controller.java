package controllers;

import java.util.Scanner;
import java.util.logging.Logger;

import chapter9.Chapter9_exercises;
import devLearner01_simpleJava.GlobalConstants;

public class Chapter9Controller {
	
	private final static Logger log = Logger.getLogger( Chapter9Controller.class.getName() );
	private String[] hashTable;

	
	public Chapter9Controller() {
		hashTable = new String[10];
	}
	
	public void execute() {

		Chapter9_exercises ch9ex = new Chapter9_exercises();
		
		// run ex_for_section_9Point1_selfcheck_1
		ch9ex.ex_for_section_9Point1_selfcheck_1();
		
		// run ex_for_section_9Point2_programming_1
		ch9ex.ex_for_section_9Point2_programming_1( GlobalConstants.SAMPLE_TEXT_FILE );
		
		// prepare ex_for_section_9Point3_programming_1
		String key = prepare_ex_for_section_9Point3_programming_1();
		
		// run ex_for_section_9Point3_programming_1
		int pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, key);
		if(pos == -1)
			log.info( "key not found." );
		else
			log.info( "position where key is located: " + pos );
	}
	
	/**
	 * this method is used to add a key to the hashTable
	 * @return
	 */
	private String prepare_ex_for_section_9Point3_programming_1() {
		
		log.info( "preparing for ch9ex.ex_for_section_9Point3_programming_1" );
		
		String key;
		
		// dialog to insert key
		System.out.println( "please tell me the key to insert in the hashTable: " );
		Scanner in = new Scanner(System.in);
		key = in.nextLine();
		in.close();
		
		int index = key.hashCode() % hashTable.length;
		if( index < 0 )
			index += hashTable.length;
		this.hashTable[ index ]  =  key;
		
		return key;
	}

}
