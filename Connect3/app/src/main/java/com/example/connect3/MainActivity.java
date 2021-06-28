package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int currentPlayer = 0;  //  0 represents player 1 and 1 represents player 2
    //  An array to keep track of the board that which of the
    //  spaces are empty, X or O
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};  //  2 represents box is empty
    //  Win combinations
    int[][] count = {{0, 1, 2},{3, 4, 5},{6, 7, 8}, /*   Horizontal Matches    */
                     {0, 3, 6},{1, 4, 7},{2, 5, 8}, /*   Vertical Matches      */
                     {0, 4, 8},{2, 4, 6}};          /*   Diagonal Matches      */

    private boolean isGameActive = true, isDraw = false;

    Button btnPlayAgain;
    TextView tvWinner;
    ImageView imageView2;
    //  Function that runs when an image view is clicked
    public void appear(View view) {

        ImageView imageView1 = (ImageView) view;
        imageView2 = (ImageView) findViewById(R.id.winnerSign);
        imageView2.setVisibility(View.INVISIBLE);
        //  Stores the tag id of the image that is tapped
        int tappedCounter = Integer.parseInt(imageView1.getTag().toString());
        //  If the image view is not tapped yet, then run the game logic
        if (gameState[tappedCounter] == 2 && isGameActive) {
            //  the game state of the box is set to the player id
            gameState[tappedCounter] = currentPlayer;
            //  Sets the image view to invisible.
            imageView1.setAlpha(0.0f);

            if (currentPlayer == 0) {
                currentPlayer = 1;
                imageView1.setImageResource(R.drawable.o);
            } else {
                currentPlayer = 0;
                imageView1.setImageResource(R.drawable.x);
            }
            //  Animates to image view to appear over a time interval
            imageView1.animate().alpha(1).setDuration(200);

            //  The loop to check whether the valid winning combination is acquired
            for (int[] winningPosition : count) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    if (currentPlayer == 1 && isGameActive) {
                        //winner = "O";
                        imageView2.setImageResource(R.drawable.o);
                    } else if (currentPlayer == 0 && isGameActive) {
                        //winner = "X";
                        imageView2.setImageResource(R.drawable.x);
                    }
                    isGameActive = false;
                    btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
                    tvWinner = (TextView) findViewById(R.id.tvWinner);

                    tvWinner.setVisibility(View.VISIBLE);
                    btnPlayAgain.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    tvWinner.setText(" has won");
                } else {
                    isDraw = true;
                    for (int i : gameState) {
                        if (i == 2)
                            isDraw = false;
                    }

                    if (isDraw){
                        tvWinner.setVisibility(View.VISIBLE);
                        tvWinner.setText("Draw");
                        btnPlayAgain.setVisibility(View.VISIBLE);
                    }

                }
            }
        }
    }

    public void playAgain(View view){

        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        tvWinner = (TextView) findViewById(R.id.tvWinner);
        imageView2 = (ImageView) findViewById(R.id.winnerSign);

        btnPlayAgain.setVisibility(View.INVISIBLE);
        tvWinner.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for (int i = 0; i < gridLayout.getChildCount(); i++){

            ImageView imageView = (ImageView) gridLayout.getChildAt(i);
            imageView.setImageDrawable(null);
        }

        Arrays.fill(gameState, 2);
        isGameActive = true;
        isDraw = false;
        currentPlayer = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        tvWinner = (TextView) findViewById(R.id.tvWinner);
        imageView2 = (ImageView) findViewById(R.id.winnerSign);
        btnPlayAgain.setVisibility(View.INVISIBLE);
        tvWinner.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
    }
}