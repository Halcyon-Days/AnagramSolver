import java.util.ArrayList;

/*
 * @param testWord word to be checked for all possible anagrams
 * @param dictionary dictionary object that holds a list of words for anagrams to be found from
 * @author Christopher Chin
 */
public class Anagram {
    private static ArrayList<String> anagramList = new ArrayList<>();
    
    public static void PrintAnagrams(String testWord, Dictionary dictionary){
        anagramList.clear();
        FindAnagrams(testWord.toLowerCase().toCharArray(), dictionary, testWord.length()-1);
    }
    
    /*
     * recursively takes string and finds all possible rearrangements within the length to Rearrange of it in the dictionary passed, printing them out
     * @param testWord word to be checked for all possible anagrams
     * @param dictionary dictionary object that holds a list of words for anagrams to be found from
     * @param length for function to re arrange
     * @ExecutionTime starting from original calling function = [(testWord.length())!, also known as factorial of testword.length() ] * IsWordInDict()
     * @author Christopher Chin
     */
    private static void FindAnagrams(char[] testWord, Dictionary dictionary, int lengthToRearrange){
        //base case, checks to see if word is in dictionary
        if(lengthToRearrange == 0) {
            String testWordString = new String(testWord);
            //prevents repeated words being listed
            if(anagramList.contains(testWordString)){
                return;
            //prints out word if it is anagram
            } else if (dictionary.IsWordInDict(testWordString)) {
                System.out.println(testWordString);
            } else{}
            
        //recursive, rearranges letters within its length and calls itself again
        } else{  
            for(int i = lengthToRearrange; i >= 0; i--){
                char bufferChar = testWord[lengthToRearrange];
                testWord[lengthToRearrange] = testWord[i];
                testWord[i] = bufferChar;
                
            //calls self with one less length to Rearrange
                FindAnagrams(testWord, dictionary, lengthToRearrange-1);
            }
        }
    }
    
    /*
     * @param testWord word to be checked for all possible anagrams
     * @param dictionary dictionary object that holds a list of words for anagrams to be found from
     * @return List of all possible anagrams in an ArrayList of strings
     * @author Christopher Chin
     */
    public static ArrayList<String> ListAnagrams(String testWord, Dictionary dictionary){
       //removes any previous entries in list before starting
        anagramList.clear();
        
        //calls recursive search function
        FindListAnagrams(testWord.toLowerCase().toCharArray(), dictionary, testWord.length()-1);
        
        return anagramList;
    }
    
    /*
     * recursively takes string and finds all possible rearrangements within the length to Rearrange of it in the dictionary passed, adding them to the anagramList ArrayList of Strings
     * @param testWord word to be checked for all possible anagrams
     * @param dictionary dictionary object that holds a list of words for anagrams to be found from
     * @param length for function to re arrange
     * @ExecutionTime starting from original calling function = (testWord.length())!, also known as factorial of testword.length()
     * @author Christopher Chin
     */
    private static void FindListAnagrams(char[] testWord, Dictionary dictionary, int lengthToRearrange){
        //base case, checks to see if word is in dictionary
        if(lengthToRearrange == 0){
            String testWordString = new String(testWord);
            //prevents repeated words being listed
            if(anagramList.contains(testWordString)){
                return;
            
            //adds word to list if it is an anagram
            }else if(dictionary.IsWordInDict(testWordString)) {
                anagramList.add(testWordString);
            } else {}
            
        //recursive, rearranges letters within its length and calls itself again
        } else {
                for(int i = lengthToRearrange; i >= 0; i--){
                    char bufferChar = testWord[lengthToRearrange];
                    testWord[lengthToRearrange] = testWord[i];
                    testWord[i] = bufferChar;
                    
                    //calls self with one less length to Rearrange
                    FindListAnagrams(testWord, dictionary, lengthToRearrange-1);

                }
            }
    }
}
