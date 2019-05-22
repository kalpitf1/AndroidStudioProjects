package com.example.android.tennisscore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    /**
     * Set initial score for Player A and B to 0.
     */
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int gamePlayerA = 0;
    int gamePlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForPlayerA(0);
        displayForPlayerB(0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
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
    }

    /**
     * Increase the score for Player A.
     */
    public void addPointPlayerA(View v) {
        scorePlayerA = scorePlayerA + 1;
        if(scorePlayerA == 4){
            gamePlayerA = gamePlayerA + 1;
            displayForGameA(gamePlayerA);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }
        displayForPlayerA(scorePlayerConverterA());
        displayForPlayerB(scorePlayerConverterB());
    }

    /**
     * Convert the point 1 to 4 to corresponding tennis score system values for A.
     */
    public int scorePlayerConverterA(){
        int convertedScore = 0;
        switch(scorePlayerA){
            case 1:
                convertedScore = 15;
                break;
            case 2:
                convertedScore = 30;
                break;
            case 3:
                convertedScore = 40;
                break;
            case 4:
                break;
        }
        return convertedScore;
    }

    /**
     * Decrease the score for Player A.
     */
    public void deductPointPlayerA(View v) {
        scorePlayerA = scorePlayerA - 1;
        if(scorePlayerA < 0){scorePlayerA = 0;}
        displayForPlayerA(scorePlayerConverterA());
    }
    /**
     * Displays the given score for Player A.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForGameA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Player B.
     */
    public void addPointPlayerB(View v) {
        scorePlayerB = scorePlayerB + 1;
        if(scorePlayerB == 4){
            gamePlayerB = gamePlayerB + 1;
            displayForGameB(gamePlayerB);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }
        displayForPlayerA(scorePlayerConverterA());
        displayForPlayerB(scorePlayerConverterB());
    }

    /**
     * Convert the point 1 to 4 to corresponding tennis score system values for B.
     */
    public int scorePlayerConverterB(){
        int convertedScore = 0;
        switch(scorePlayerB){
            case 1:
                convertedScore = 15;
                break;
            case 2:
                convertedScore = 30;
                break;
            case 3:
                convertedScore = 40;
                break;
            case 4:
                break;
        }
        return convertedScore;
    }

    /**
     * Decrease the score for Player B.
     */
    public void deductPointPlayerB(View v) {
        scorePlayerB = scorePlayerB - 1;
        if(scorePlayerB < 0){scorePlayerB = 0;}
        displayForPlayerB(scorePlayerConverterB());
    }
    /**
     * Displays the given score for Player B.
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForGameB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.game_b_score);
        scoreView.setText(String.valueOf(score));
    }


    public void resetScore(View v){
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }

    public void resetGameScore(View v){
        gamePlayerA = 0;
        gamePlayerB = 0;
        displayForGameA(gamePlayerA);
        displayForGameB(gamePlayerB);
    }
}