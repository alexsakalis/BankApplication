package bus;

public class Validator {
	
	
	
	public static void IsInRange (float value) throws RaiseException
	{
		if (value <1111 || value > 9999) 
		{
			throw new RaiseException("Invalid input. Value but be between 1111 and 9999....");
		}
	}
	
	public static void IsNumber (double value) throws RaiseException
	{
		if (value <0 || value > 999999999) 
		{
			throw new RaiseException("Invalid input. Value but be between 0 and 9999....");
		}
	}
	
	public static void IsNumbers (int value) throws RaiseException
	{
		if (value <0 || value > 999999999) 
		{
			throw new RaiseException("Invalid input. Value but be between 0 and 9999....");
		}
	}

	public static void isPositive(long value) throws RaiseException
	{
	if(value <= 0) 
	{
		throw new RaiseException("Invalid input, value must be postive...");
	}
	}
	
	public static void isNumeric(String value) throws RaiseException
	{
		for(int i= 0; i != value.length(); ++i) {
			if(!Character.isDigit(value.charAt(i)))
				throw new RaiseException("Invalid input, value must be digit only...");
		}
	}
	
	public static void isAlphabetic(String value) throws RaiseException{
		for (int i=0; i!= value.length(); ++i) {
			if(!Character.isAlphabetic(value.charAt(i)))
				{
				throw new RaiseException("Invalid input, value must be alphabet letter only");
				}
		}
	}

}
