package se.gritacademy.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }




    @Override
    protected void onStart(){
        super.onStart();

        Log.d("Started","onStarted invoked" +getLocalClassName());
    }
    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Started","onPaused invoked" +getLocalClassName());
    }

    public void resetGame(View view) {
    }

    public void showStats(View view) {

        startActivity(new Intent(GameActivity.this,ResultsActivity.class));
    }

    public void quitGame(View view) {

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}


