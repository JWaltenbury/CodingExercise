package External.Exercise1Maven;

import java.util.HashMap;

public class Main {
	public static void main(String[] args)
	{
		//Import CSV returns
		//NOTE: Using this object is out of scope for the exercise
		@SuppressWarnings("unused")
		HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata.csv", true); 
		//HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata_large.csv");
		//HashMap<String, T3Return> returnList = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata_huge.csv");
		
		//Initialize UI
		new ReturnSubmissionView(); //No requirement to manage UI outside of starting it
	}
}
