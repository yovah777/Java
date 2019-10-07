// Program created by Yovanny Henao on 04/01/2019
// Program Assignment 7
// Program asks user for a file, file is then verified, read, and data placed into array of integer datatype
// Program will print out a histogram.
import java.util.Scanner;
import java.io.*;

public class Histogram
{
    public static void main(String[] args) 
    {
        int size = 0, min = 0, max = 99;						// counter of cells, min, max of range
		int count = 0;											// counter of invalid values (outside range)
        boolean success = false;				
		final int ranges = 10;									// size counter array of valid values
		Scanner keyboard = new Scanner(System.in);
        
     
		while(!success)										//loop runs until valid file is entered(file exists)
		{		
			try
			{	
				System.out.println("What is the file name? ");
				String userInput = keyboard.nextLine();

				File file = new File(userInput);				//File object 
				keyboard = new Scanner(file);					// Scanner object reads file/verifies if it exists
       
				while(keyboard.hasNextInt())					
				{
					size++;										//counts values inside file
					keyboard.nextInt();
				}								
	
				int[] mmList = new int[size];					//array instantiated with proper size
		
				keyboard = new Scanner(file);
				for(int index=0; index != size; index++)		//converting String to double
					mmList[index] = keyboard.nextInt();    		// values from file placed into array
		
				int[] counter = new int[ranges];				//counter array created
				for(int index = 0; index< ranges; index++)
					counter[index] = 0;							//set counter cells to zero
				for(int index=0; index < size; index++)			//counter cells increment in value	
				{		
					if(mmList[index] < min || mmList[index] > max)	
						count++;
					else	
						counter[mmList[index]/10]++;
				}
				System.out.println("range\t\t" + "count\n" + "------\t" + "\t------");
				for(int index=0;index <counter.length; index++)
				{	
					System.out.print((index*10) + "-" + ((index*10)+9)+ "\t\t" + counter[index] + "\t" + "|");
					symbolMaker(counter[index]);
					System.out.println();
				}
				System.out.print("out of range\t" + count + "\t" + "|");
				symbolMaker(count);
				System.out.print("\nTotal count: " + mmList.length);
			
				success = true;									//loop ends
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
				System.out.println("File not found, enter file that exists");
			}
		}
    }	
	public static void symbolMaker(int x)						//Static method to create stars
	{
		if(x <= 50)	
		{
			for(int index= 0; index < x; index++)
			{
				if(index%10==0)
					System.out.print(" ");							//spacing after every 10 stars are printed
				System.out.print("*"+ "");
			}
		}
		else
			System.out.print(" ********** ********** ********** ********** ********** " + "Max stars reached");
	}
}