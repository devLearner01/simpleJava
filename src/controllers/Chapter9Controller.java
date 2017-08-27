package controllers;

import chapter9.Chapter9_exercises;
import devLearner01_simpleJava.GlobalConstants;

public class Chapter9Controller {

	public void execute() {

		Chapter9_exercises ch9ex = new Chapter9_exercises();
		ch9ex.ex_for_section_9Point1_selfcheck_1();
		ch9ex.ex_for_section_9Point2_programming_1( GlobalConstants.SAMPLE_TEXT_FILE );
	}

}
