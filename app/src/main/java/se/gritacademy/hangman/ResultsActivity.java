package se.gritacademy.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        TextView guessedLetters = findViewById(R.id.guessedLetters);
        TextView guessedWords = findViewById(R.id.guessedWords);

        Intent intent = getIntent();

        guessedLetters.setText((intent.getStringExtra("guessedLetters")));
        guessedWords.setText((intent.getStringExtra("guessedWords")));

    }
}
