package External.Exercise1Maven;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class T3ReturnTest {
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
}
