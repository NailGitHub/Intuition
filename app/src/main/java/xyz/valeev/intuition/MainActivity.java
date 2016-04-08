package xyz.valeev.intuition;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends Activity {

    private ImageView imgViewAI, imgViewHuman;
    int count = 0;
    int aiCount = 0;
    int humanCount = 0;
    int humanChoice =0;
    int aiChoice= 0;
    ProgressBar aiProgressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //image views

        imgViewAI = (ImageView)findViewById(R.id.imageViewAIChoice);
        imgViewHuman = (ImageView)findViewById(R.id.imageViewHumanChoice);

        //progress bar
        aiProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        aiProgressBar.setProgress(0);
        aiProgressBar.setMax(100);


    }

// Methods for buttons. Setting appropriate value to variable, image to ImageView
    public void onClickStone(View view){

        humanChoice = 1;
        ((TextView)findViewById(R.id.textViewStatus)).setText("STONE");
        imgViewHuman.setImageResource(R.drawable.stone);
        //Now submitButton is visible
        ((Button)findViewById(R.id.submitButton)).setVisibility(View.VISIBLE);
        imgViewAI.setImageResource(R.drawable.ufo);
        aiProgressBar.setVisibility(View.INVISIBLE);
        aiProgressBar.setProgress(0);



    }

    public void onClickScissors(View view){

        humanChoice = 2;
        ((TextView)findViewById(R.id.textViewStatus)).setText("SCISSORS");
        imgViewHuman.setImageResource(R.drawable.scissors);
        //Now submitButton is visible
        ((Button)findViewById(R.id.submitButton)).setVisibility(View.VISIBLE);
        imgViewAI.setImageResource(R.drawable.ufo);
        aiProgressBar.setVisibility(View.INVISIBLE);
        aiProgressBar.setProgress(0);
    }

    public void onClickPaper(View view){

        humanChoice = 3;
        ((TextView)findViewById(R.id.textViewStatus)).setText("PAPER");
        imgViewHuman.setImageResource(R.drawable.paper);
        //Now submitButton is visible
        ((Button)findViewById(R.id.submitButton)).setVisibility(View.VISIBLE);
        imgViewAI.setImageResource(R.drawable.ufo);
        aiProgressBar.setVisibility(View.INVISIBLE);
        aiProgressBar.setProgress(0);
    }

    public void onClickReset(View view){

        aiCount=0;
        humanCount=0;
        ((TextView)findViewById(R.id.textViewAIResult)).setText(""+aiCount);
        ((TextView)findViewById(R.id.textViewPlayerResult)).setText(""+humanCount);
        ((TextView)findViewById(R.id.textViewStatus)).setText("TRY AGAIN");
        imgViewAI.setImageResource(R.drawable.ufo);
        imgViewHuman.setImageResource(R.drawable.ufo);
        aiProgressBar.setVisibility(View.INVISIBLE);
        aiProgressBar.setProgress(0);


    }

    public void onClickSubmit(View view){
        aiProgressBar.setVisibility(View.VISIBLE);
        for (int i = 1;i<=90;i++) {

            aiProgressBar.setProgress(i);
            aiProgressBar.setSecondaryProgress(i+10);
        }

        ((Button)findViewById(R.id.submitButton)).setVisibility(View.INVISIBLE);

        //aiChoice generating
        aiChoice = (int)(Math.random()*3 + 1 );

            //number of attempts increasing
            count++;

        //Winner determination
            switch(aiChoice){

                case 1://AI has STONE
                    imgViewAI.setImageResource(R.drawable.stone);

                    switch(humanChoice){

                        case 1:

                            ((TextView)findViewById(R.id.textViewStatus)).setText("DRAW");
                            break;
                        case 2:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU LOOSE");
                            aiCount++;
                            ((TextView)findViewById(R.id.textViewAIResult)).setText(""+aiCount);

                            break;

                        case 3:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU WIN");
                            humanCount++;
                            ((TextView)findViewById(R.id.textViewPlayerResult)).setText(""+humanCount);

                            break;

                    }
                    break;

                case 2://AI has SCISSORS
                    imgViewAI.setImageResource(R.drawable.scissors);


                    switch(humanChoice){

                        case 1:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU WIN");
                            humanCount++;
                            ((TextView)findViewById(R.id.textViewPlayerResult)).setText(""+humanCount);

                            break;
                        case 2:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("DRAW");
                            break;
                        case 3:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU LOOSE");
                            aiCount++;
                            ((TextView)findViewById(R.id.textViewAIResult)).setText("" + aiCount);
                            break;



                    }
                    break;


                case 3:
                    imgViewAI.setImageResource(R.drawable.paper);


                    switch(humanChoice){
                        case 1:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU LOOSE");
                            aiCount++;
                            ((TextView)findViewById(R.id.textViewAIResult)).setText("" + aiCount);
                            break;
                        case 2:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("YOU WIN");
                            humanCount++;
                            ((TextView)findViewById(R.id.textViewPlayerResult)).setText("" + humanCount);
                            break;
                        case 3:
                            ((TextView)findViewById(R.id.textViewStatus)).setText("DRAW");
                            break;
                    }
                    break;

            }

        }



/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
