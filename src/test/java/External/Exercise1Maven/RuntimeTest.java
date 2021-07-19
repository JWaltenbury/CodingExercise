package External.Exercise1Maven;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RuntimeTest {
	
	private HashMap<String, T3Return> returnListNormal;
	private HashMap<String, T3Return> returnListLarge;
	private HashMap<String, T3Return> returnListHuge;
	private HashMap<String, T3Return> initializationMap = new HashMap<String, T3Return>();
	T3Return testReturn = new T3Return("T25223424", "TESTNOT", "Toronto", "ON", "123456", "123456");
	
	/**
	 * Preloads all of the CSV files into the class member lists.
	 */
	@BeforeClass
	public void initializeRuntimeLists()
	{
		returnListNormal = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata.csv", false); 
		returnListLarge = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata_large.csv", false); 
		returnListHuge = FileOperations.loadT3ReturnsFromCsv("src/main/resources/sampledata_huge.csv", false); 
		
		System.out.println("\n---------- INITIALIZATION RUNTIME ANALYSIS ("+ initializationMap.size() + " records) ----------");
		putReturnInMap(initializationMap, testReturn);
		getReturnFromMap(initializationMap, "T25223424");
		removeReturnFromMap(initializationMap, "T25223424");
	}
	
  @Test(priority=1)
  public void sampleDataRuntimeTest()
  {	  
	  System.out.println("\n---------- SAMPLE DATA RUNTIME ANALYSIS ("+ returnListNormal.size() + " records) ----------");
	  putReturnInMap(returnListNormal, testReturn);
	  getReturnFromMap(returnListNormal, "T94067732");
	  removeReturnFromMap(returnListNormal, "T92374709");
  }
  
	
//	  @Test(priority=1) public void sampleDataRuntimeTest2() {
//		  System.out.println("\n---------- SAMPLE DATA RUNTIME ANALYSIS ("+
//		  returnListNormal.size() + " records) ----------");
//		  putReturnInMap(returnListNormal, testReturn);
//		  getReturnFromMap(returnListNormal, "T94067732");
//		  removeReturnFromMap(returnListNormal, "T92374709");
//	  }
	 
  
  @Test(priority=2)
  public void sampleDataLargeRuntimeTest()
  {	  
	  System.out.println("\n---------- SAMPLE DATA (LARGE) RUNTIME ANALYSIS ("+ returnListLarge.size() + " records) ----------");
	  putReturnInMap(returnListNormal, testReturn);
	  getReturnFromMap(returnListNormal, "T38395578");
	  removeReturnFromMap(returnListNormal, "T07655165");
  }
  
  @Test(priority=3)
  public void sampleDataHugeRuntimeTest()
  {	  
	  System.out.println("\n---------- SAMPLE DATA (HUGE) RUNTIME ANALYSIS ("+ returnListHuge.size() + " records) ----------");
	  putReturnInMap(returnListNormal, testReturn);
	  getReturnFromMap(returnListNormal, "T59450429");
	  removeReturnFromMap(returnListNormal, "T75916886");
  }
  
  private static void putReturnInMap(HashMap<String, T3Return> mapToUse, T3Return returnToAdd)
  {
	  long startTime = System.nanoTime();
	  mapToUse.put(returnToAdd.getTan(), returnToAdd);
	  long endTime   = System.nanoTime();
	  System.out.println("PUT - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
  
  private static void getReturnFromMap(HashMap<String, T3Return> mapToUse, String keyToFind)
  {
	  long startTime = System.nanoTime();
	  mapToUse.get(keyToFind);
	  long endTime   = System.nanoTime();
	  System.out.println("GET - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
  
  private static void removeReturnFromMap(HashMap<String, T3Return> mapToUse, String keyToRemove)
  {
	  long startTime = System.nanoTime();
	  mapToUse.remove(keyToRemove);
	  long endTime   = System.nanoTime();
	  System.out.println("REMOVE - Complete. Runtime: " + (endTime - startTime) + " nanoseconds");
  }
}
