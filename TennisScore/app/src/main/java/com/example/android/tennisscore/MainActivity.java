package com.example.android.tennisscore;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.tennisscore.R;


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
        scorePlayerA = scorePlayerA + 15;
        if(scorePlayerA == 60){
            gamePlayerA = gamePlayerA + 1;
            displayForGameA(gamePlayerA);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
    /**
     * Decrease the score for Player A.
     */
    public void deductPointPlayerA(View v) {
        scorePlayerA = scorePlayerA - 15;
        if(scorePlayerA < 0){scorePlayerA = 0;}
        displayForPlayerA(scorePlayerA);
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
        scorePlayerB = scorePlayerB + 15;
        if(scorePlayerB == 60){
            gamePlayerB = gamePlayerB + 1;
            displayForGameB(gamePlayerB);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
    }
    /**
     * Decrease the score for Player B.
     */
    public void deductPointPlayerB(View v) {
        scorePlayerB = scorePlayerB - 15;
        if(scorePlayerB < 0){scorePlayerB = 0;}
        displayForPlayerB(scorePlayerB);
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