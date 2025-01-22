import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PigLatin {
    
    public void tester() {
        // String[] lines = loadStrings("words.txt");
        String[] lines = new String[8]; 
        try{
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
	    System.out.println("there are " + lines.length + " lines");
	    for (int i = 0 ; i < lines.length; i++) {
	        System.out.println(pigLatin(lines[i]));
	    }
    }
    public int findFirstVowel(String sWord) {
  //precondition: sWord is a valid String of length greater than 0.
  //postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
  // your code goes here
  for (int i = 0; i < sWord.length(); i++) { //finds index of first vowel
    if (sWord.substring (i, i+1).equals ("a") || 
      sWord.substring (i, i+1).equals ("e") || 
      sWord.substring (i, i+1).equals ("i") ||
      sWord.substring (i, i+1).equals ("o") || 
      sWord.substring (i, i+1).equals ("u"))
      return i;
  }
  return -1;
}

public String pigLatin(String sWord) {
  //precondition: sWord is a valid String of length greater than 0
  //postcondition: returns the pig latin equivalent of sWord
  // more code should go here
  if (findFirstVowel(sWord) == 0){ //if word begins with vowel
    return sWord + "way";
  }
  
  if (sWord.substring (0, 2).equals ("qu")){ //if begin with qu
    return sWord.substring (2, sWord.length()) + "qu" + "ay";
  }
  
  if (findFirstVowel(sWord) == -1) {
    return sWord + "ay";
  }
  
   if (findFirstVowel(sWord) != 0){ //if begin with consonants
     return sWord.substring (findFirstVowel(sWord)) 
     + sWord.substring (0, findFirstVowel(sWord)) + "ay";
   }
 else {
    return "ERROR!";
  }
}
}//end PigLatin class
