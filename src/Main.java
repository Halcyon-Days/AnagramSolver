import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/*
 * Creates GUI, which can find all the anagrams of a word given, or of a random word
 * @Reference Java A Beginner's Guide 6th Edition, chapter 16
 * @Author Christopher Chin
 * 
 */

public class Main implements ActionListener{
   
    JFrame MainGUI;
    private static Dictionary dictionary;
    private JButton randomButton;
    private JButton testAnagramButton;
    private JTextField inputTextField;
    private JLabel Instructions;
    private DefaultListModel<String> AnagramList;
    private JList<String> AnagramJList;
    
    String randomWord;
    
    //creates new frame with input text field, 2 buttons and a list
    Main() {
        MainGUI = new JFrame("Anagram Solver");
        
        MainGUI.setLayout(new FlowLayout());
     
        MainGUI.setSize(400,200);
        MainGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputTextField = new JTextField(30);
        inputTextField.setText("");
        
        Instructions = new JLabel("Input a word or get a random word to find all its anagrams:");
        
        randomButton = new JButton("Random Word");
        randomButton.addActionListener(this);
        
        testAnagramButton = new JButton("Find Anagrams");
        testAnagramButton.addActionListener(this);
        
        AnagramList = new DefaultListModel<String>();

        AnagramJList = new JList<String>(AnagramList);
        JScrollPane AnagramListScroll = new JScrollPane(AnagramJList);
        AnagramListScroll.setPreferredSize(new Dimension(100, 100));
        
        MainGUI.add(Instructions);
        MainGUI.add(inputTextField);
        MainGUI.add(testAnagramButton);
        MainGUI.add(randomButton);
        MainGUI.add(AnagramListScroll, FlowLayout.TRAILING);
        MainGUI.setVisible(true);
    }
    
    //Event handler when buttons are pressed
    public void actionPerformed (ActionEvent ae){
        JButton buttonPressed = (JButton) ae.getSource();
        ArrayList<String> AnagramArrayList;
        
        if (buttonPressed.equals(testAnagramButton)) {
            AnagramArrayList=Anagram.ListAnagrams(inputTextField.getText(), dictionary);

        } else {
            randomWord = dictionary.RandomWord();
            inputTextField.setText(randomWord);
            AnagramArrayList = Anagram.ListAnagrams(randomWord, dictionary);
        }
        
        //clears current list from display
        AnagramList.clear();
        
        //adds new list of anagrams to display
        for(String CurrentAnagram: AnagramArrayList) {
            AnagramList.addElement(CurrentAnagram);
        }
        AnagramJList.setModel(AnagramList);
    }
    
    /*
     * Creates windows for a new dictionary file to be input, and will change dictionary file if a new filename is input, or throws exception when file is not valid
     * Then opens Swing GUI
     */
    public static void main(String[] args) throws IOException{
        

        String fileName = JOptionPane.showInputDialog("Input in new file or leave blank to use vocabulary.txt");
        if(fileName.isEmpty()){
            dictionary = new Dictionary(new File("vocabulary.txt"));
        } else {
            dictionary = new Dictionary(new File(fileName));
        }
        
        SwingUtilities.invokeLater ( new Runnable(){
            public void run() {
                new Main();
            }
        });
    }
}
