package External.Exercise1Maven;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Test;

public class TimeComplexity {

  @Test
  public void processFiles() {
	  //TODO encapsulation, comments
	  
	  ArrayList<String> filesToProcessList = new ArrayList<String>();
	  HashMap<String, T3Return> fileList = new HashMap<String, T3Return>();
	  
      String smallFile = new String("D:\\Users\\Paul\\Documents\\CRA\\Training Team\\Exercise 1\\sampledata.csv");
      String largeFile = new String("D:\\Users\\Paul\\Documents\\CRA\\Training Team\\Exercise 1\\sampledata_large.csv");
      String hugeFile = new String("D:\\Users\\Paul\\Documents\\CRA\\Training Team\\Exercise 1\\sampledata_huge.csv"); 
     
      //TODO - loadT3 returns returns a hashmap with all the return entries. assign this here and im good. 
      
      filesToProcessList.add(smallFile);
      filesToProcessList.add(largeFile);
      filesToProcessList.add(hugeFile);
     
      T3Return newReturn = new T3Return("T12345678", "gibberish", "Port Perry", "ON", "42000", "29000");
      
      //This block of code before for loop will allow for accurate time measurement in the for loop after establishing the collection. 
      fileList = FileOperations.loadT3ReturnsFromCsv(hugeFile);
	  searchCollection(0, 5000, fileList);
	  addToCollection(0, 5000, fileList, newReturn);
	  removeFromCollection(0, 5000, fileList);
	  fileList.clear();
	  
	  for(int counter = 0; counter <= 2; counter++){
		  
		  fileList.clear();
		  
		  fileList = FileOperations.loadT3ReturnsFromCsv(filesToProcessList.get(counter)); 
		  
		  System.out.println("\n*********************");
		  System.out.println("File being read: " + (counter+1));
		  System.out.println("Hash Map size:" + fileList.size());
		  System.out.println("*********************\n");
		  
		  int middleIndex = fileList.size() / 2;
		  
		  addToCollection(counter, middleIndex, fileList, newReturn);
		  
		  searchCollection(counter, middleIndex, fileList);
		  
		  removeFromCollection(counter, middleIndex, fileList);
		 
	  }
	
  }
  
  //Functions for search in middle
  public void searchCollection(int counter, int middleIndex, HashMap<String, T3Return> fileList) {
	  counter++;
	  
	  System.out.println("\nRetrieve from Hash Map sample file #" + counter + ": ");
	  
	  long startTime = System.nanoTime();
	
	  fileList.get("T12345678");
	  //System.out.println("Test: " + fileList.get("T12345678"));
    
      long endTime = System.nanoTime();

      long timeElapsed = endTime - startTime;

      System.out.println("Execution time in nanoseconds to retrieve from Hash Map sample file #" + counter + ": " + timeElapsed + " nanoseconds\n");
  }
  
  //function for add to middle and end
  public void addToCollection(int counter, int middleIndex, HashMap<String, T3Return> fileList, T3Return newReturn) {
	  counter++;
	  
	  System.out.println("\nAdd return to Hash Map: ");
      
      long startTime = System.nanoTime();
  	
      fileList.put(newReturn.getTan(), newReturn);
    
      long endTime = System.nanoTime();

      long timeElapsed = endTime - startTime;

      System.out.println("Execution time in nanoseconds to add return to Hash Map - sample file #" + counter + ": " + timeElapsed + " nanoseconds\n");
      
  }
  
  //function for delete from middle and end
  public void removeFromCollection(int counter, int middleIndex, HashMap<String, T3Return> fileList) {
	//remove return from the middle of the array list
	  counter++;
	  
      System.out.println("\nRemove return from hash map - sample file #" + counter + ": ");
      
      long startTime = System.nanoTime();
  	
      fileList.remove("T12345678");
    
      long endTime = System.nanoTime();

      long timeElapsed = endTime - startTime;

      System.out.println("Execution time in nanoseconds to remove return from Hash Map of sample file #" + counter + ": " + timeElapsed + " nanoseconds\n");
      
  }
  
}
