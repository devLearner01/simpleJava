package test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import chapter9.Chapter9_exercises;
import devLearner01_simpleJava.GlobalConstants;

public class TESTex_for_section_9Point2_programming_1 {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		File fNoReps = new File( GlobalConstants.TEXT_WITH_NO_REPETITIONS );
		fNoReps.createNewFile();
		
		File fReps = new File( GlobalConstants.TEXT_WITH_REPETITIONS );
		fReps.createNewFile();
		
		BufferedWriter noReps = new BufferedWriter(new FileWriter(fNoReps ));
		BufferedWriter reps = new BufferedWriter(new FileWriter( fReps ));
		
		noReps.append( "There was once a dog that liked to code." );
		noReps.close();
		
		reps.append( "There was once a dog that liked to code." );reps.newLine();
		reps.append( "That dog also liked to drink water." );
		reps.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
//		File fNoReps = new File( GlobalConstants.TEXT_WITH_NO_REPETITIONS );
//		File fReps = new File( GlobalConstants.TEXT_WITH_REPETITIONS );
//		
//		fNoReps.delete();
//		fReps.delete();
	}

	
	
	@Test
	public void test() throws NumberFormatException, IOException {
		
		Chapter9_exercises ch0ex = new Chapter9_exercises();
		
		//Tests for sample text with NO repetitions
		ch0ex.ex_for_section_9Point2_programming_1( GlobalConstants.TEXT_WITH_NO_REPETITIONS );
		
		BufferedReader input = new BufferedReader( new FileReader( new File( GlobalConstants.RESULT_FILE ) ));
		
		//counts nr of repetitions encountered in the result file
		int nrOfRepetitions = 0;
		String line;
		while( ( line = input.readLine())  != null) {
			
			String[] lineColumns = line.split( " " ); //TODO i may need to increase with commas, exclamation marks, etc.
			if( Integer.parseInt( lineColumns[2] ) > 1 )
				nrOfRepetitions++;	
		}
		
		assertEquals( 0, nrOfRepetitions  );	
		
		
		//Tests for sample text with repetitions
		ch0ex.ex_for_section_9Point2_programming_1( GlobalConstants.TEXT_WITH_REPETITIONS );
		
		input = new BufferedReader( new FileReader( new File( GlobalConstants.RESULT_FILE ) ));
		
		//counts nr of repetitions encountered in the result file
		nrOfRepetitions = 0;
		while( ( line = input.readLine())  != null) {
			
			String[] lineColumns = line.split( " " ); //TODO i may need to increase with commas, exclamation marks, etc.
			if( Integer.parseInt( lineColumns[2] ) > 1 )
				nrOfRepetitions++;	
		}
		
		assertEquals ( nrOfRepetitions > 0 , true ); //TODO still need to implement the correct amount of reps per word for the TEXT_WITH_REPETITIONS file
	}
	
	
	
	

}
