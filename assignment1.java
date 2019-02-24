import java.lang.Math;
import java.util.Scanner;

public class assignment1
{
	public static boolean unluckyNumberCheck(int input, int base)
	{
		int total = 0; // Running total of remainder
		
		// Convert input into base
		while (input > 0)
		{
			total += (input % base);
			input /= base;
		}
		
		// Check if remainder is divisible by 3
		return total % 3 == 0;
	}
	
	public static void unluckyNumber(int input)
	{
		int count = 0;
		int upperBase = Math.min(2000, input);
		
		for (int base = 2; base <= upperBase; base++)
		{
			boolean isUnluckyNumber = unluckyNumberCheck(input, base);

			if (isUnluckyNumber)
			{
				if (count < 10)
				{
					System.out.print(base + ", ");
					count++;
				}
				else
				{
					System.out.print("...");
					break;
				}
			}
		}
		
		System.out.println();
	}
	
	private static boolean isLetterHawaiian(char c)
	{
		return "aeiouhklmnpwAEIOUHKLMNPW".indexOf(c) != -1;
	}
	
	private static void hawaiiWord(String input)
	{
        for (int i = 0; i < input.length(); i++)
        {
        	char c = input.charAt(i);
        	
        	if (!isLetterHawaiian(c))
        	{
        		System.out.println("No");
        		return;
        	}
	    }
        
        System.out.println("Ae");
	}

	
	private static boolean isStringNumeric(String s)
	{
		// Iterate through all characters in string
        for (int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
        	
        	// Check if character is a digit
        	if ("1234567890".indexOf(c) == -1)
        	{
        		// Character is not a digit
        		return false;
        	}
	    }
        
        // All characters in string are digits
        return true;
	}
	
	private static boolean isStringAlphabet(String s)
	{
		// Iterate through all characters in string
        for (int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
        	
        	// Check if character is part of the alphabet
        	if ("abcdefghijklmnopqrestuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) == -1)
        	{
        		// Character is a part of the alphabet
        		return false;
        	}
	    }
        
        // All characters in string are digits
        return true;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			System.out.print("Enter Number/String >");
			
			String input = scanner.nextLine();
			
			
			
			// Check if string exits the program
			if (input.equalsIgnoreCase("AHULHOU"))
			{
				break;
			}
			
			// Check if string is an integer
			if (isStringNumeric(input))
			{
				int parsedInt = Integer.parseInt(input);
				unluckyNumber(parsedInt);
				continue;
			}
			
			// Check if string contains only letters
			if (isStringAlphabet(input))
			{
				hawaiiWord(input);
				continue;
			}
			
			// Throw error
			System.out.println("Error. Only Postive Integers or Words. Please try again.");
		};

		System.out.println("~THE END~");
		
		
		
		// Cleanup
		scanner.close();
	}
}

