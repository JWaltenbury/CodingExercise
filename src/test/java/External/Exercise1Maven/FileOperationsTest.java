package External.Exercise1Maven;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class FileOperationsTest {
	@Test
	  public void csvImportTest()
	  {
		  String badImportUrl = "";
		  String goodImportUrl = "src/main/resources/sampledata.csv";
		  
		  //TODO: Check if existing but empty CSV breaks this
		  assertNull(FileOperations.loadT3ReturnsFromCsv(badImportUrl, false));
		  assertNotNull(FileOperations.loadT3ReturnsFromCsv(goodImportUrl, false));
	  }
}
