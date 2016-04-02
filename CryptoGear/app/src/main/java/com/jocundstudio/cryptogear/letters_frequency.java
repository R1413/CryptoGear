import java.util.*;
import java.io.*;
class LettersFrequency {
	
    static String TextFile(String fileName) throws IOException 
    {
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        String message = "";
        while (input.hasNextLine()) {
            message += input.nextLine();
        }
        return message;
    }
	public static void main(String[] args) throws IOException 
	{
		String the_string = TextFile(args[0]);
		char[] the_array = the_string.toCharArray(); //store string in array
		int size_of_array = the_array.length; //get size of array
		int i =0,j=0,counter = 0;
		
		for(i=0; i<size_of_array; i++) //first for loop of i loops through the array
		{
			counter = 0;
			for(j=0; j< size_of_array; j++)//second for loop of j also loops through the same array
			{
				
				if(the_array[j] == the_array[i]) //if there is a match between i and j, increment counter
				{
					counter++;
				}
				if(j<i && the_array[i]==the_array[j]) //make sure the occurances of characters don't print out multiple times
				{
					break;
				}
				if(j==size_of_array-1)
				{
				System.out.println("character "+ the_array[i]+" appears "+counter+" times"); //print out characters by their frequency of appereances
				}
			}
			
		}
	}
}
