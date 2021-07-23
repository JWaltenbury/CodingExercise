package External.Exercise1Maven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Tests {
	
  @Test
  public void stringValidationTest()
  {	  
	  assertFalse(Validations.isValidStringInput(null));
	  assertFalse(Validations.isValidStringInput(""));
	  assertFalse(Validations.isValidStringInput(" "));
	  
	  assertTrue(Validations.isValidStringInput("test"));
	  assertTrue(Validations.isValidStringInput("test string"));
  }
	  
  @Test
  public void integerValidationTest()
  {
	  assertFalse(Validations.isValidInteger(null));
	  assertFalse(Validations.isValidInteger(""));
	  assertFalse(Validations.isValidInteger(" "));
	  assertFalse(Validations.isValidInteger("test"));
	  assertFalse(Validations.isValidInteger("test string"));
	  assertFalse(Validations.isValidInteger("1test1"));
	  assertFalse(Validations.isValidInteger("1 1"));  
	  assertFalse(Validations.isValidInteger("10.5"));
	  assertFalse(Validations.isValidInteger("3122342343124234234243423423423423423423")); //overflow
	  assertFalse(Validations.isValidInteger("1     "));
	  
	  assertTrue(Validations.isValidInteger("-211123"));
	  assertTrue(Validations.isValidInteger("0"));
	  assertTrue(Validations.isValidInteger("3423423"));
	  assertTrue(Validations.isValidInteger("123"));	  
  }
  
  @Test
  public void positiveIntegerValidationTest() {  
	  assertFalse(Validations.isValidNonNegativeIntegerInput(null));
	  assertFalse(Validations.isValidNonNegativeIntegerInput(""));
	  assertFalse(Validations.isValidNonNegativeIntegerInput(" "));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("test"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("test string"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("1test1"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("1 1"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("10.5"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("3122342343124234234243423423423423423423")); //overflow
	  assertFalse(Validations.isValidNonNegativeIntegerInput("1     "));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("-211123"));
	  assertFalse(Validations.isValidNonNegativeIntegerInput("-10.5"));
	  
	  assertTrue(Validations.isValidNonNegativeIntegerInput("0"));
	  assertTrue(Validations.isValidNonNegativeIntegerInput("3423423"));
	  assertTrue(Validations.isValidNonNegativeIntegerInput("123"));	    
  }
  
  @Test
  public void t3ReturnValidationTest()
  {
	  T3Return invalidTestReturnTan = new T3Return("", "test", "test", "test", "123", "123");
	  T3Return invalidTestReturnNot = new T3Return("test", "", "test", "test", "123", "123");
	  T3Return invalidTestReturnCity = new T3Return("test", "test", "", "test", "123", "123");
	  T3Return invalidTestReturnProvince = new T3Return("test", "test", "test", "", "123", "123");
	  T3Return invalidTestReturnPi = new T3Return("test", "test", "test", "test", "-10", "123");
	  T3Return invalidTestReturnRi = new T3Return("test", "test", "test", "test", "123", "10.5");
	  
	  T3Return validTestReturn = new T3Return("test", "test", "test", "test", "123", "123");
	  
	  assertFalse(Validations.isValidT3Return(null));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnTan));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnNot));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnCity));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnProvince));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnPi));
	  assertFalse(Validations.isValidT3Return(invalidTestReturnRi));
	  
	  assertTrue(Validations.isValidT3Return(validTestReturn));
  }
  
  @Test
  public void t3ReturnTest()
  {
	  T3Return validTestReturn = new T3Return("test", "test", "test", "test", "1231233", "1123123123");
	  
	  validTestReturn.setTan("newTan");
	  assertEquals(validTestReturn.getTan(), "newTan");
	  
	  validTestReturn.setNot("newNot");
	  assertEquals(validTestReturn.getNot(), "newNot");
	  
	  validTestReturn.setCity("newCity");
	  assertEquals(validTestReturn.getCity(), "newCity");
	  
	  validTestReturn.setProvince("newProvince");
	  assertEquals(validTestReturn.getProvince(), "newProvince");
	  
	  validTestReturn.setPi("123");
	  assertEquals(validTestReturn.getPi(), "123");
	  
	  validTestReturn.setRi("456");
	  assertEquals(validTestReturn.getRi(), "456");
	  
	  String expectedToString = "TAN: newTan\n" +
			  					"NOT: newNot\n" +
			  					"City: newCity\n" +
			  					"Province: newProvince\n" +
			  					"PI: 123\n" +
			  					"RI: 456";
	  assertEquals(validTestReturn.toString(), expectedToString);
  }
  
  @Test
  public void csvImportTest()
  {
	  String badImportUrl = "";
	  String goodImportUrl = "src/test/resources/sampledata.csv";
	  
	  //TODO: Check if existing but empty CSV breaks this
	  assertNull(FileOperations.loadT3ReturnsFromCsv(badImportUrl));
	  assertNotNull(FileOperations.loadT3ReturnsFromCsv(goodImportUrl));
  }
  
//  @Test
//  public void uiGenerationTest()
//  {
//	  //NOTE: Not a great test, mostly just inflates coverage metric
//	  ReturnSubmissionView uiObject = new ReturnSubmissionView();
//	  assertNotNull(uiObject);
//  }
  
//  @Test
//  public void reportSubmissionTest()
//  {
//	//TODO: Set mock data in text boxes then check expected submission result for each field
//	  
//	  ReturnSubmissionView uiObject = new ReturnSubmissionView();
//	  assertNull(uiObject.processSubmission()); //Simulates all text boxes being empty
//  }
  
  @Test
  public void intentionalFailedTest()
  {
	  assertFalse(Validations.isValidStringInput(" ")); //Intentional failed test
  }
}
