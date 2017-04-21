import java.util.*;
import java.io.*;


public class Dictionary {
    private ArrayList<String> dictionary;
    private int numWords;
    
    /*
     * Creates Dictionary Object, which takes in a text file, and loads them into a list of strings
     * @param WordList Text file with 1 word per line
     * @return Throws exception upon IO error
     * @Adapted from Lab2/src/UBCPoet.java @Sathish Gopalakrishnan https://github.com/CPEN-221/lab2
     * 
     * @Author Christopher Chin
     */
    
    public Dictionary(File wordList) throws IOException{
        dictionary = new ArrayList<>();
        numWords = 0;
        
        //Below loads dictionary variable with words from text file passed
        //creates new input stream
        InputStream inputStream = new FileInputStream(wordList);
        //creates buffer for input stream
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
        
        String fileLineBuffer;
        //until no more lines can be read from the file
        while ((fileLineBuffer = bufferReader.readLine()) != null) {
            //place line inside string array
            dictionary.add(fileLineBuffer.toLowerCase());
            numWords++;
        }
        bufferReader.close();     //closes input stream
    }

    /*
     * @param Postfix Word prefix subset that will be checked if any words have in the dictionary
     * @return true or false depending on if prefix is in the dictionary
     */
    public Boolean DoAnyWordsStartWith (String preFix){
        for (String dictionaryWord : dictionary) {
            if (dictionaryWord.startsWith(preFix)){
                return true;
            } else {}
        }
        return false;
    }
    
    /*
     * @param Postfix Word postfix subset that will be checked if any words have in the dictionary
     * @return true or false depending on if postfix is in the dictionary
     */
    public Boolean DoAnyWordsEndWith (String postFix){
        for (String dictionaryWord : dictionary) {
            if (dictionaryWord.endsWith(postFix)){
                return true;
            } else {}
        }
        return false;
    }
    
    /*
     * @param TestWord Word that will be checked if its in the dictionary
     * @return true or false depending on if TestWord is in the dictionary
     */
    public Boolean IsWordInDict(String TestWord){
        return dictionary.contains(TestWord);
    }
    
    /*
     * Prints all words in dictionary
     */
    public void PrintDictionary(){
        for (String CurrentWord: dictionary){
            System.out.println(CurrentWord);            
        }
    }
    
    /*
     * @return random word *with less than 6 letters* in the dictionary
     */
    public String RandomWord(){
        //creates random number object
        Random randomNum = new Random();
        String randomWord = dictionary.get(randomNum.nextInt(numWords));
        while(randomWord.length() > 5){
            randomNum = new Random();
            randomWord = dictionary.get(randomNum.nextInt(numWords));
        }

        return randomWord;
    }
    
    /*
     * @return number of words in dictionary
     */
    public int WordCount(){
        return numWords;
    }
}
