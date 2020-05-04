package se.gritacademy.hangman;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import se.gritacademy.hangman.adapter.ClockCountDown;
import se.gritacademy.hangman.graphics.HangmanModel;


public class GameActivity extends AppCompatActivity {

    final public String TAG = "GameActivity";
    public TextView counter_text;
    public TextView word_to_guess;
    public TextView clockCountDown;
    public ImageView image;
    public ImageView guess_btn;
    public EditText enter_guess;
    GameLogic gameLogic = new GameLogic(this);
    HangmanModel hangman = new HangmanModel();
    ClockCountDown countDown = new ClockCountDown(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameLogic.playGame(8);
        clockCountDown = findViewById(R.id.timer);
        image = findViewById(R.id.hangman_picture);
        word_to_guess = findViewById(R.id.word_to_guess);
        guess_btn = findViewById(R.id.guess_btn);
        enter_guess = findViewById(R.id.enter_guess);
        counter_text = findViewById(R.id.counter);

        countDown.clock();
        image.setImageResource(hangman.hangmanPictures(gameLogic.counter));

        word_to_guess.setText(gameLogic.wordAsChar.toString());
        counter_text.setText(String.valueOf(gameLogic.counter));

        Log.d(TAG, "onCreate Word in Play: " + gameLogic.wordInPlay);
        Log.d(TAG, "onCreate Used Letters: " + gameLogic.usedLetters);
    }

        @Override
    protected void onStart(){
        super.onStart();

        countDown.startClock();


        Log.d(TAG,"onStarted invoked" +getLocalClassName());
        Log.d(TAG, "onStart Word in Play: " + gameLogic.wordInPlay);
        Log.d(TAG, "onStart Used Letters: " + gameLogic.usedLetters);




    }
    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = getSharedPreferences("GameSaved", MODE_PRIVATE).edit();
        editor.putString("WORD", gameLogic.wordInPlay);
        editor.putString("GUESSED_LETTERS", String.valueOf(gameLogic.usedLetters));
        editor.putInt("TRIES_LEFT", gameLogic.counter);

        editor.apply();
        editor.commit();
        countDown.stopClock();

        Log.d(TAG, "Saved");
        Log.d(TAG,"onPaused invoked" +getLocalClassName());
        Log.d(TAG, "onPause Word in Play: " + gameLogic.wordInPlay);
        Log.d(TAG, "onPause Used Letters: " + gameLogic.usedLetters);



    }

    @SuppressLint("SetTextI18n")
    public void checkWord(View view) {

        if (enter_guess.getText().toString().isEmpty()) {
            enter_guess.setError("Blank Field!");
        }

        if (gameLogic.usedLetters.toString().contains(enter_guess.getText().toString())
                || (gameLogic.usedWords.toString().contains(enter_guess.getText().toString()))) {
            Toast.makeText(this,"Already Guessed That", Toast.LENGTH_SHORT).show();
        } else {
            gameLogic.checkWord(enter_guess.getText().toString());
            word_to_guess.setText(gameLogic.wordAsChar);
            counter_text.setText(String.valueOf(gameLogic.counter));
            image.setImageResource(hangman.hangmanPictures(gameLogic.counter));
        }

        if (enter_guess.getText().toString().equals(gameLogic.wordInPlay)
                || word_to_guess.getText().toString().equals(gameLogic.wordInPlay)){
            word_to_guess.setText(getString(R.string.you_won));
            gameLogic.wordAsChar.setLength(0);
        }
        if (gameLogic.counter == 0) {
            image.setImageResource(hangman.hangmanPictures(gameLogic.counter));
            word_to_guess.setText(getString(R.string.word_was) + gameLogic.wordInPlay);

        }


        Log.d(TAG,"text input " + enter_guess.getText().toString());
        Log.d(TAG,"char check " + gameLogic.usedLetters.toString());
        Log.d(TAG,"word check " + gameLogic.usedWords.toString());
        Log.d(TAG,"word as char check " + gameLogic.wordAsChar.toString());
        Log.d(TAG, "check counter " + gameLogic.counter);

        enter_guess.getText().clear();

    }
    // Sends over guessed words and letters to result page
    public void showStats(View view) {
        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);

        intent.putExtra("guessedLetters", gameLogic.usedLetters.toString());
        intent.putExtra("guessedWords", gameLogic.usedWords.toString());
        startActivity(intent);
    }

    // Restarts game and resets all values
    public void resetGame(View view) {

        gameLogic.playGame(8);


        word_to_guess.setText(gameLogic.wordAsChar.toString());
        image.setImageResource(hangman.hangmanPictures(gameLogic.counter));
        gameLogic.usedLetters.setLength(0);
        gameLogic.usedWords.setLength(0);
        enter_guess.getText().clear();
        countDown.clock();

        Log.d(TAG,"After Reset : "  + gameLogic.wordAsChar);
        Log.d(TAG,"After Reset : "  + gameLogic.wordInPlay);
        Log.d(TAG,"After Reset : "  + gameLogic.usedLetters);
    }

    public void quitGame(View view) {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }


}


