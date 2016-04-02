import java.util.*;
import java.io.*;

class CaesarCipher //Cipher Class
{
	// Method that reads all text from a file with the given name
    static String TakeInInputTextFile(String fileName) throws IOException 
    {
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        String message = "";
        while (input.hasNextLine()) {
            message += input.nextLine();
        }
        return message;
    }
	
static String cipher_function_encrypt(String message, int key_shift)  //encrypt function
{
	String encrypted_message = "";
	int length_of_message = message.length(); //get length of string(message)
	for(int i = 0; i< length_of_message; i++)
	{
		int character_identifier = message.charAt(i);  //character_identifier will be used to identify the location of letters to be shifted
		//character_identifier = (char)(character_identifier + key_shift); //old method, but does not work
		if(Character.isUpperCase(character_identifier))
		{
			character_identifier = character_identifier+(key_shift%26);
		if( character_identifier > 'Z') // if letters to be shifted reached the end(z), go back to the beginning of alphabet, and apply Caesar Cipher
		{
			character_identifier = character_identifier - 26;
		}
		else if (character_identifier < 'A') //else, do normal shifting, apply normal Caesar Cipher
		{
			character_identifier = character_identifier + 26;
		}
		}
		
		else if(Character.isLowerCase(character_identifier))
		{
			character_identifier = character_identifier+(key_shift%26);
		if( character_identifier > 'z') // if letters to be shifted reached the end(z), go back to the beginning of alphabet, and apply Caesar Cipher
		{
			character_identifier = character_identifier - 26;
		}
		else if (character_identifier < 'a') //else, do normal shifting, apply normal Caesar Cipher
		{
			character_identifier = character_identifier + 26;
		}
		
		}
		encrypted_message = encrypted_message+(char) character_identifier;
	}
	return encrypted_message; //return encrypted message after Caesar Cipher is applied
}


static String cipher_function_decrypt(String message, int key_shift) //decrypt function
{
	String decrypted_message = "";
	int length_of_message = message.length(); //get length of string(message)
	for(int i = 0; i< length_of_message; i++)
	{
		int character_identifier = message.charAt(i);
		if(Character.isUpperCase(character_identifier))
		{
			character_identifier = character_identifier-(key_shift%26);
		if( character_identifier < 'A')
		{
			character_identifier = character_identifier + 26;
		}
		else if (character_identifier > 'Z') 
		{
			character_identifier = character_identifier - 26;
		}
		}
		
		else if(Character.isLowerCase(character_identifier))
		{
			character_identifier = character_identifier-(key_shift%26);
		if( character_identifier < 'a') // if letters to be shifted reached the end(z), go back to the beginning of alphabet, and apply Caesar Cipher
		{
			character_identifier = character_identifier + 26;
		}
		else if (character_identifier > 'z') 
		{
			character_identifier = character_identifier - 26;
		}
		
		}
		decrypted_message = decrypted_message+(char) character_identifier;
	}
	return decrypted_message; //return decrypted message
}
 
//Function to analyze frequency of each letter and attempt to decrypt the encrypted message using frequency analysis
// This method returns entropy for a string containing some english text
    // calculated using frequencies of individual letters.
    public static double frequency_analysis(String message) {
        double[] freq = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228,  //frequency of each letter of English alphabet, e has highest frequency
                         0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025,
                         0.02406, 0.06749, 0.07507, 0.01929, 0.00095, 0.05987,
                         0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150,
                         0.01974,0.00074};

        double the_message = 0;
        for (int i = 0; i < message.length(); i++) 
        {
            char analysis = message.charAt(i);
            if ('a' <= analysis && analysis <= 'z')  //analysis for lower case letters
                the_message += -Math.log(freq[analysis - 'a']);
            else if ('A' <= analysis && analysis <= 'Z') //analysis for upper case letters
                the_message += -Math.log(freq[analysis - 'A']);
        }
        return the_message;
}


//Main Function to test
public static void main(String[] args) throws IOException//testing both encrypt and decrypt functions
{
	/* Method 1: Test it manually without having to enter text file, by calling encrypt and decrypt functions
System.out.println(cipher_function_encrypt("the fox jumped the fence", 3)); //call encrypt, and test message to be shifted by 3 places
System.out.println(cipher_function_encrypt("zzzz", 3)); // test the case when letters reached the end of alphabet
System.out.println(cipher_function_encrypt("ThE fOX juMpEd tHe FeNcE", -4));//call encrypt, and test message with capital letters to be shifted backward 4 places

System.out.println(cipher_function_decrypt("wkh ira mxpshg wkh ihqfh", 3)); //call decrypt, and convert encrypted message back to original message
System.out.println(cipher_function_decrypt("cccc", 3)); 
System.out.println(cipher_function_decrypt("PdA bKT fqIlAz pDa BaJyA", -4));//call decrypt, and convert encrypted message back to original message  */
       
        if (args.length != 2)  //check to make sure user correctly enters input file as first argument and output file as second argument
        {
            System.out.println("Wrong number of parameters. Usage: java Caesar <input file> <output file>");
            return;
        }
//Method 2: Output an encrypted message or output the original message using input file output file as command line arguments
//If you want to encrypt a message, put encrypted_message_finalized as parameter on line outputWriter.write() down here
         Scanner input = new Scanner(System.in);
                System.out.println();
        System.out.println("Enter 1 to Encrypt, Enter 2 to Decrypt");
        int user_choice;
        do
        {
			user_choice= input.nextInt();

			if(user_choice == 1)
			{

        String text = TakeInInputTextFile(args[0]);
		String encrypted_message_finalized = "";
		String encrypted_text = cipher_function_encrypt(text, 22);
		encrypted_message_finalized = encrypted_text;
		//String decrypted_message_finalized = " ";
		//String decrypted_text = cipher_function_decrypt(text, 3);
		//decrypted_message_finalized = decrypted_text;
        File outputFile = new File(args[1]);
        BufferedWriter outputWriter =
            new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
        outputWriter.write(encrypted_message_finalized);
		
        outputWriter.close();
	}
	else if(user_choice == 2)
	{
        String text = TakeInInputTextFile(args[0]);
        double lowestEntropy = Double.MAX_VALUE; //store lowest entropy so far
        String lowestEntropyString = ""; 

        for (int key = 0; key < 26; ++key) //attempt to try all possible keys
        {
            String decrypted_message_finalized = cipher_function_encrypt(text, -key);  //decrypted message
            double entropy = frequency_analysis(decrypted_message_finalized);//find all possible entropies of each letter based on the decrypted message
			System.out.println(entropy);
            if (entropy < lowestEntropy)  
            {
                lowestEntropy = entropy; 
                lowestEntropyString = decrypted_message_finalized; //string with lowest entropy with most likely be the final decrypted message, or the original message
            }
        }

       
        File outputFile = new File(args[1]);
        BufferedWriter outputWriter =
            new BufferedWriter(new FileWriter(outputFile.getAbsoluteFile()));
        outputWriter.write(lowestEntropyString); //output decrypted message based on lowestEntropyString after the process of frequency analysis
        outputWriter.close();
    }
	}
while (user_choice!= 1 && user_choice != 2);

}
}

