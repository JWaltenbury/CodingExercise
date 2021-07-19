package External.Exercise1Maven;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class MainTest {
	@Test(enabled=false)
	  public void intentionalFailedTest()
	  {
		  assertTrue(Validations.isValidStringInput(" ")); //Intentional failed test
	  }
}
