import java.util.ArrayList;

public class Anagram {
    private static ArrayList<String> anagramList = new ArrayList<>();
    private static ArrayList<String> anagramCache = new ArrayList<>();
    
    public static void PrintAnagrams(String testWord, Dictionary dictionary){
        anagramList.clear();
        anagramCache.clear();
        FindAnagrams(testWord.toLowerCase().toCharArray(), dictionary, testWord.length()-1);
    }
    
    private static void FindAnagrams(char[] testWord, Dictionary dictionary, int lengthToRearrange){
        if(lengthToRearrange == 0) {
            String testWordString = new String(testWord);
            if(anagramCache.contains(testWordString)){
                return;
            } else if (dictionary.IsWordInDict(testWordString)) {
                System.out.println(testWordString);
            } else{}
            
            for(int i = 0; i < lengthToRearrange; i++){
                char bufferChar = testWord[lengthToRearrange];
                testWord[lengthToRearrange] = testWord[i];
                testWord[i] = bufferChar;
                FindAnagrams(testWord, dictionary, lengthToRearrange-1);
            }
        }
    }
    
    public static ArrayList<String> ListAnagrams(String testWord, Dictionary dictionary){
        anagramList.clear();
        anagramCache.clear();
        FindListAnagrams(testWord.toLowerCase().toCharArray(), dictionary, testWord.length()-1);
        return anagramList;
    }
    
    private static void FindListAnagrams(char[] testWord, Dictionary dictionary, int lengthToRearrange){
        if(lengthToRearrange == 0){
            String testWordString = new String(testWord);
            if(anagramCache.contains(testWordString)){
                return;
            }
                else if(dictionary.IsWordInDict(testWordString)) {
                anagramList.add(testWordString);
                anagramCache.add(testWordString);
            } else {}
        } else {
                for(int i = 0; i < lengthToRearrange; i++){
                    char bufferChar = testWord[lengthToRearrange];
                    testWord[lengthToRearrange] = testWord[i];
                    testWord[i] = bufferChar;
                    FindListAnagrams(testWord, dictionary, lengthToRearrange-1);
                }
            }
    }
}
