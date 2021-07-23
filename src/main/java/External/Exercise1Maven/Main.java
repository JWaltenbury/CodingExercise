package External.Exercise1Maven;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class);
	
	public static void main(String[] args)
	{
		//Import CSV returns
		//NOTE: Using this object is out of scope for the exercise
		@SuppressWarnings("unused")
		HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata.csv"); 
		//HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("resources/sampledata_large.csv");
		//HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("resources/sampledata_huge.csv");
		
		//Initialize UI
		new ReturnSubmissionView(); //No requirement to manage UI outside of starting it
		
		logger.trace("This is a tracing message");
		logger.info("This is a information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("Don't get in the habit of using this level - only use this if absolutely fatal");
		
	}
}
