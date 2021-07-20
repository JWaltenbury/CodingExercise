package External.Exercise1Maven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RuntimeTest {
	
	private HashMap<String, T3Return> importedReturnsMap = new HashMap<String, T3Return>();
	private List<String> listOfCsvUrls = new ArrayList<>(Arrays.asList("src/main/resources/sampledata.csv", "src/main/resources/sampledata_large.csv", "src/main/resources/sampledata_huge.csv"));
	T3Return testReturn = new T3Return("T25223424", "TESTNOT", "Toronto", "ON", "123456", "123456");
	
	/**
	 * Runs fake calls to properly initialize the HashMap library
	 */
	@BeforeClass
	public void initializeRuntimeLists()
	{
		System.out.println("\n---------- INITIALIZATION RUNTIME ANALYSIS ("+ importedReturnsMap.size() + " records) ----------");
		putReturnInMap(importedReturnsMap, testReturn);
		getReturnFromMap(importedReturnsMap, "T25223424");
		removeReturnFromMap(importedReturnsMap, "T25223424");
	}
	
  /**
  * Runtime analysis on the list of CSVs
  */
  @Test(priority=1)
  public void performRuntimeAnalysis()
  {	  
		for(String csvUrl : listOfCsvUrls)
		{
			importedReturnsMap = FileOperations.loadT3ReturnsFromCsv(csvUrl, false); 
			System.out.println("\n---------- SAMPLE DATA RUNTIME ANALYSIS ("+ importedReturnsMap.size() + " records) ----------");
			putReturnInMap(importedReturnsMap, testReturn);
			getReturnFromMap(importedReturnsMap, "T25223424");
			removeReturnFromMap(importedReturnsMap, "T25223424");
			importedReturnsMap.clear(); // need to empty list for next run through
		}  
  }
 
  
  
  /**
   * Outputs the runtime of adding a return to the given list
 * @param mapToUse - Map to add to
 * @param returnToAdd - T3Return to add
 */
private static void putReturnInMap(HashMap<String, T3Return> mapToUse, T3Return returnToAdd)
  {
	  long startTime = System.nanoTime();
	  mapToUse.put(returnToAdd.getTan(), returnToAdd);
	  long endTime   = System.nanoTime();
	  System.out.println("PUT - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
  
  /**
   * Outputs the runtime of getting a return from the given list
 * @param mapToUse - Map to search
 * @param keyToFind - TAN key of the T3Return to find
 */
private static void getReturnFromMap(HashMap<String, T3Return> mapToUse, String keyToFind)
  {
	  long startTime = System.nanoTime();
	  //System.out.println("\n" + mapToUse.get(keyToFind).toString());
	  mapToUse.get(keyToFind);
	  long endTime   = System.nanoTime();
	  System.out.println("GET - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
  
  /**
   * Outputs the runtime of removing a return from the given list
 * @param mapToUse - Map to remove from
 * @param keyToRemove - TAN key of the T3Return to remove
 */
private static void removeReturnFromMap(HashMap<String, T3Return> mapToUse, String keyToRemove)
  {
	  long startTime = System.nanoTime();
	  mapToUse.remove(keyToRemove);
	  long endTime   = System.nanoTime();
	  System.out.println("REMOVE - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
}
