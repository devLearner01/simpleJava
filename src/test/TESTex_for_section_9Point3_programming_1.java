package test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chapter9.Chapter9_exercises;

public class TESTex_for_section_9Point3_programming_1 {

	Logger log = Logger.getLogger( TESTex_for_section_9Point3_programming_1.class.getName() );
	String[] hashTable;
	Chapter9_exercises ch9ex = new Chapter9_exercises();
	
	@Before
	public void setUp() throws Exception {
		
		this.hashTable = new String[10]; 
		
		int index = "lookingForMe".hashCode() % hashTable.length;
		if( index < 0 )
			index += index + hashTable.length;
		hashTable[ index ]  =  "lookingForMe" ;
		
		index = "anotherKey".hashCode() % hashTable.length;
		if( index < 0 )
			index += hashTable.length;
		hashTable[ index ]  =  "anotherKey" ;
		
	}

	@After
	public void tearDown() throws Exception {
		
		hashTable = null;
		ch9ex = null;
	}

	@Test
	public void test() {

		int pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, "lookingForMe" );
		assertEquals( 0 , pos );
		log.info( "passed 1st test" );
		
		pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, "anotherKey" );
		assertEquals( 8, pos );
		log.info( "passed 2nd test" );
		
		pos = ch9ex.ex_for_section_9Point3_programming_1( this.hashTable, "nonExistingKey" );
		assertEquals( -1, pos );
		log.info( "passed 3rd test" );
	}

}
