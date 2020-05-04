package se.gritacademy.hangman.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import java.util.concurrent.TimeUnit;

import se.gritacademy.hangman.R;


public class ClockCountDown {

    private TextView countdown_timer;
    private Context context;
    private CountDownTimer counter;
    private int time = 180000;

    public ClockCountDown(Context context) {
        this.context = context;
    }


    public void clock() {

        countdown_timer = ((Activity) context).findViewById(R.id.timer);
        counter = new CountDownTimer(time, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {

                time--;
                countdown_timer.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }


            @Override
            public void onFinish() {

                Toast.makeText(context,"GAME OVER", Toast.LENGTH_SHORT).show();

                }
        };
        counter.start();
    }

    public void stopClock(){

            counter.cancel();

    }
    public void startClock() {
        counter.start();
    }


}
