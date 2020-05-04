package se.gritacademy.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hangmanAnimation();



    }

    public void startGame(View view) {

        startActivity(new Intent(getApplicationContext(),GameActivity.class));
    }


    // Making a small moving animation on the hangedMan ImageView.
    public void hangmanAnimation() {
        RotateAnimation anim = new RotateAnimation(0f, 2f,
                Animation.RESTART, 0.2f, Animation.RESTART,
                0f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(700);

    // Start animating the image
        final ImageView splash = (ImageView) findViewById(R.id.hangedMan);
        splash.startAnimation(anim);
    }
}
