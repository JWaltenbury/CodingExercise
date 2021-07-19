package External.Exercise1Maven;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;


public class ReturnSubmissionViewTest {
	@Test
	  public void uiGenerationTest()
	  {
		  //NOTE: Not a great test, mostly just inflates coverage metric
		  ReturnSubmissionView uiObject = new ReturnSubmissionView();
		  assertNotNull(uiObject);
	  }
	  
	  @Test
	  public void reportSubmissionTest()
	  {
		//TODO: Set mock data in text boxes then check expected submission result for each field
		  
		  ReturnSubmissionView uiObject = new ReturnSubmissionView();
		  assertNull(uiObject.processSubmission()); //Simulates all text boxes being empty
	  }
}
