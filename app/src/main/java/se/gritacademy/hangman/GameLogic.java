package se.gritacademy.hangman;


import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic  {

        public String wordInPlay;
        public String characters = "x";
        public StringBuilder usedLetters = new StringBuilder();
        public StringBuilder usedWords = new StringBuilder();
        public StringBuilder wordAsChar = new StringBuilder();
        public int counter = 0;
        public Context context;
        String filePath = "wordlist.txt";
        List<String> listOfWords = new ArrayList<>();

        public GameLogic(){}
        public GameLogic(Context context){
            this.context = context;
        }

        // Lets create a game from a wordfile and randomize it
    public void playGame(int counter){
            this.counter = counter;
            createList(filePath);
            Random random = new Random();
            wordInPlay = listOfWords.get(random.nextInt(listOfWords.size()));
            for (int i = 0; i < wordInPlay.length(); i++) {
                wordAsChar.replace(i,wordInPlay.length(),characters);
//
            }

        }
        /* First remove whitespaces and set to lowercase. Then check if letter is in word
         if letter is there, switch it out. Store letter and word separate

         */
     public void checkWord(String letter) {

            letter = letter.toLowerCase().trim();
            if(wordInPlay.contains(letter)) {
                for (int i = 0; i < wordInPlay.length(); i++) {
                    if (wordInPlay.charAt(i) == letter.charAt(0)) {
                      wordAsChar.setCharAt(i,letter.charAt(0));
                    }
                }
            } else {
                counter--;
            }
            if (letter.length() > 1) {
                usedWords.append(" ").append(letter);
            } else {
                usedLetters.append(" ").append(letter);
            }
     }


        // Create a file reader using AssetManager and store the output words in an array
        public List<String> createList(String path) {

            AssetManager am = context.getAssets();

            try {
                InputStream is = am.open(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while((line = reader.readLine()) != null) {
                    listOfWords.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return listOfWords;

        }
}
