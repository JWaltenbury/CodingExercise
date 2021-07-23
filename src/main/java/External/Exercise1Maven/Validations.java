package External.Exercise1Maven;

/**
 * Primary validations utility class for the application for verifying user submitted data
 */
public class Validations {
	
	/**
	 * Validates that the given string is non-null and non-empty
	 * @param input - input string to validate
	 * @return boolean - true = valid, false = invalid
	 */
	public static boolean isValidStringInput(String input)
	{
		if(input != null && !input.trim().equals("")) { 
			return true; 
		}
		else return false;
	}
	
	
	/**
	 * Validates that the given string is non-null and non-empty and can be parsed to an integer
	 * @param input - input string to validate
	 * @return boolean - true = valid, false = invalid
	 */
	public static boolean isValidInteger(String input)
	{
		try {
			//NOTE: As long as the parse function does not throw an exception we can assume the input is valid
			Integer.parseInt(input);
			return true;
		}
		catch (NumberFormatException ex){ return false; }
	}
	
	
	/**
	 * Validates that the given string is non-null and non-empty and can be parsed to a positive integer
	 * @param input - input string to validate
	 * @return boolean - true = valid, false = invalid
	 */
	public static boolean isValidNonNegativeIntegerInput(String input)
	{
		if(isValidStringInput(input) && isValidInteger(input))
		{
			Integer integerInput = Integer.parseInt(input); //Already checked
			
			if(integerInput >= 0) { 
				return true; 
			}
			else return false;
		}
		else return false;
	}
	
	
	/**
	 * Validates the given T3 Return record contains all applicable fields & meets criteria
	 * @param returnRecord - The T3 Return to be validated
	 * @return boolean - true = valid, false = invalid
	 */
	public static boolean isValidT3Return(T3Return returnRecord)
	{
		if(returnRecord != null)
		{
			//NOTE: If any of these checks fail it will return false
			return (isValidStringInput(returnRecord.getTan()) &&
					isValidStringInput(returnRecord.getNot()) &&
					isValidStringInput(returnRecord.getCity()) &&
					isValidStringInput(returnRecord.getProvince()) &&
					isValidNonNegativeIntegerInput(returnRecord.getPi()) &&
					isValidNonNegativeIntegerInput(returnRecord.getRi()));	
		}
		else return false;
	}
}
