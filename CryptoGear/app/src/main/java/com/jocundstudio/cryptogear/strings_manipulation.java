import java.util.*;
import java.io.*;
class StringsManipulation
{
	static String TextFileIn(String fileName) throws IOException 
    {
        File inputFile = new File(fileName);
        Scanner input = new Scanner(inputFile);

        String message = "";
        while (input.hasNextLine()) {
            message += input.nextLine();
        }
        return message;
    }
   public static void main(String args[]) throws IOException 
   {
      String the_string = TextFileIn(args[0]);

      System.out.print("New String :" );
      String the_string1 = the_string.replace('a', 'E');
      System.out.println(the_string1);

	  System.out.print("New String :" );
	  String the_string2 = the_string1.replace('e', 'I');
      System.out.println(the_string2);
      
      System.out.print("New String :" );
      String the_string3 = the_string2.replace('p', 'T');
      System.out.println(the_string3);
      
      System.out.print("New String :" );
      String the_string4 = the_string3.replace('k', 'O');
      System.out.println(the_string4);
      
   
       System.out.print("New String :" );
      String the_string5 = the_string4.replace('h', 'L');
      System.out.println(the_string5);
      
       System.out.print("New String :" );
      String the_string6 = the_string5.replace('r', 'V');
      System.out.println(the_string6);
      
      System.out.print("New String :" );
      String the_string7 = the_string6.replace('d', 'H');
      System.out.println(the_string7);
     
     System.out.print("New String :" );
      String the_string8 = the_string7.replace('s', 'W');
      System.out.println(the_string8);
      
      System.out.print("New String :" );
      String the_string9 = the_string8.replace('i', 'M');
      System.out.println(the_string9);
   }
}
