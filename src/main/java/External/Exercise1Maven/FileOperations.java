package External.Exercise1Maven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *  Utility I/O class for parsing file data
 */
public class FileOperations {
	
	
	
	/**
	 * Parses the CSV at the provided file path for valid T3 returns
	 * @param filePath - Path of the CSV to read
	 * @return HashMap<String, T3Return> - List of valid T3 returns in the CSV
	 */
	public static HashMap<String, T3Return> loadT3ReturnsFromCsv(String filePath)
	{
		
//		final Logger logger = LogManager.getLogger(Main.class);
		
		try {
			String row = "";
			int lineNumber = 1; //For outputting human-readable error messages
			
			//NOTE: Decided to go with HashMap. While LinkedList would be more optimal for adding/removing T3 returns, in a real use-case 
			//	it could be expected that searching the list for a specific return is the more common behavior. 
			//  Additionally, we can rely on TAN being a unique key for the map according to business logic.
			//	Finally, outside of reporting purposes there is no discernible reason to have the list of returns in a specific order.		
			HashMap<String, T3Return> returnList = new HashMap<String, T3Return>();
			
			BufferedReader csvReader = new BufferedReader(new FileReader(filePath));

			System.out.println("---------- CSV Import Data ----------");
			csvReader.readLine(); //Skip first line which has the header
			lineNumber++;
			
			while (( row = csvReader.readLine()) != null) {
			    String[] rowData = row.split(",");
		    	T3Return returnObject = new T3Return(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5]);
		    	
		    	//Validate returns and warn of errors
		    	if(Validations.isValidT3Return(returnObject)) { 
		    		returnList.put(returnObject.getTan(), returnObject); 
	    		}
		    	else {
		    		System.out.println("ERROR: Invalid T3 return found on line: " + lineNumber);
//		    		logger.warn("A T3 Return cannot be submitted with blanks");
		    	}
		    	
		    	lineNumber++;
			}
			csvReader.close();
			
//			for(Map.Entry<String, T3Return> returnObject : returnList.entrySet())
//			{
//				System.out.println("\n" + returnObject.getValue().toString());
//			}

			System.out.println("\nImport Complete. " + returnList.size() + " T3 returns have been imported.");
			return returnList;
		} catch (IOException e) { 
			System.out.println("ERROR: Could not parse CSV for import");  
			return null;
		}
	}
}
