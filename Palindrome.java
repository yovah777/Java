// Homework 8 by Yovanny Henao on 04/09/2019
// Create modified version of a PalindromeTester
// Spaces and punctuations are considered during determination
// Remember, a string is a palindrome if it is equal to itself in reverse order.
import java.util.Scanner;

public class Palindrome
{
	public static void main(String[] args)
	{
		String userInput;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a potential palindrome: ");
		userInput = keyboard.nextLine();						//Scanner object reads in line
		
		palindrome(userInput);									//palindrome method tests userInput (string)
		
		if(palindrome(userInput))
			System.out.println("This is a palindrome.");		//When boolean is true
		else
			System.out.println("This is NOT a palindrome.");	//When boolean is false
	}
	public static boolean palindrome(String word)				//implemented recursively
	{
		if(word.isEmpty() || word.length() == 1)				
			return true;
		else if(word.charAt(0) == word.charAt(word.length()-1))		//string indexes compared
			return palindrome(word.substring(1,word.length()-1));	//new string object (substring)created and
		return false;												//placed in parameters of palindrome method
	}
}