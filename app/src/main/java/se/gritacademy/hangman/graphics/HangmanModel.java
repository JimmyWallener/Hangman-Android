package se.gritacademy.hangman.graphics;



import se.gritacademy.hangman.R;


public class HangmanModel {


    public int hangmanPictures(int tries) {

        switch (tries) {
            case 0:
               return R.drawable.gameover;
            case 1:
               return R.drawable.full_hangman;
            case 2:
               return R.drawable.body_first_leg;
            case 3:
               return R.drawable.both_arms_body;
            case 4:
               return R.drawable.head_neck_first_second_arm;
            case 5:
               return R.drawable.head_neck_first_arm;
            case 6:
               return R.drawable.gallow_with_head_neck;
            case 7:
               return R.drawable.gallow_with_head;
            case 8:
               return R.drawable.gallow;
            default:
               return R.drawable.error;
        }

    }
}

