package controllers;

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
		
		ch9ex.ex_for_section_9Point1_selfcheck_1();
		
		ch9ex.ex_for_section_9Point2_programming_1( GlobalConstants.SAMPLE_TEXT_FILE );
		
		
		log.info( "preparing for ch9ex.ex_for_section_9Point3_programming_1" );
		
		int index = "lookingForMe".hashCode() % hashTable.length;
		if( index < 0 )
			index += index + hashTable.length;
		this.hashTable[ index ]  =  "lookingForMe" ;
		
		index = "anotherKey".hashCode() % hashTable.length;
		if( index < 0 )
			index += hashTable.length;
		this.hashTable[ index ]  =  "anotherKey" ;
		
		int pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, "lookingForMe" );
		if(pos == -1)
			log.info( "key not found." );
		else
			log.info( "position where key is located: " + pos );
		
		pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, "anotherKey" );
		if(pos == -1)
			log.info( "key not found." );
		else
			log.info( "position where key is located: " + pos );
	}

}
