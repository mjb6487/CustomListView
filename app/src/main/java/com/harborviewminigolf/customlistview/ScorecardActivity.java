package com.harborviewminigolf.customlistview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ScorecardActivity extends AppCompatActivity {

    private LinearLayout namesCol,  hole1Col,  hole2Col, hole3Col, hole4Col, hole5Col, hole6Col, hole7Col,
            hole8Col, hole9Col, hole10Col, hole11Col, hole12Col, hole13Col, hole14Col, hole15Col,
            hole16Col, hole17Col, hole18Col, halfTotal, gameTotal;
    private Button enter1, enter2, enter3, enter4, enter5, enter6;
    private TextView selectedView;
    private TextView[][] holeTracker;
    private TextView[] nameTracker, halfTotalTracker, gameTotalTracker;
    private String[] pNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);

        /**************************************************
            // THIS IS A TEMPORARY IMPLEMENTATION //
            // PLAYER NAMES WILL BE RETRIEVED FROM DATA //
            // THIS LOOP CREATES THEM VIA HARDCODE //
         *************************************************/
        Intent mainIntent = getIntent();
        int numberOfPlayers = mainIntent.getIntExtra("numberOfPlayers", 0);

        // Get scores for player 0
        final String[] scores_1 = mainIntent.getExtras().getStringArray("scores_1");

        // Get scores for player 1
        final String[] scores_2 = mainIntent.getExtras().getStringArray("scores_2");

        final String[] playerNames = new String[numberOfPlayers];

        for(int index = 0; index < numberOfPlayers; index++){
            playerNames[index] = "Player " + Integer.toString(index);
        }

        /**************************************************
                    // END OF HARDCODE //
         *************************************************/

        //final String[] playerNames = getIntent().getStringArrayExtra("NAMES");
        //final String[] playerNames = {"Player 1", "Player 2"};
        pNames = playerNames;

        namesCol = findViewById(R.id.nameColumn);
        hole1Col = findViewById(R.id.holeOneColumn);
        hole2Col = findViewById(R.id.holeTwoColumn);
        hole3Col = findViewById(R.id.holeThreeColumn);
        hole4Col = findViewById(R.id.holeFourColumn);
        hole5Col = findViewById(R.id.holeFiveColumn);
        hole6Col = findViewById(R.id.holeSixColumn);
        hole7Col = findViewById(R.id.holeSevenColumn);
        hole8Col = findViewById(R.id.holeEightColumn);
        hole9Col = findViewById(R.id.holeNineColumn);
        hole10Col = findViewById(R.id.holeTenColumn);
        hole11Col = findViewById(R.id.holeElevenColumn);
        hole12Col = findViewById(R.id.holeTwelveColumn);
        hole13Col = findViewById(R.id.holeThirteenColumn);
        hole14Col = findViewById(R.id.holeFourteenColumn);
        hole15Col = findViewById(R.id.holeFifteenColumn);
        hole16Col = findViewById(R.id.holeSixteenColumn);
        hole17Col = findViewById(R.id.holeSeventeenColumn);
        hole18Col = findViewById(R.id.holeEighteenColumn);
        halfTotal = findViewById(R.id.halfTotal);
        gameTotal = findViewById(R.id.gameTotal);

        enter1 = findViewById(R.id.scoreOneButton);
        enter2 = findViewById(R.id.scoreTwoButton);
        enter3 = findViewById(R.id.scoreThreeButton);
        enter4 = findViewById(R.id.scoreFourButton);
        enter5 = findViewById(R.id.scoreFiveButton);
        enter6 = findViewById(R.id.scoreSixButton);

        holeTracker = new TextView[playerNames.length][18];
        nameTracker = new TextView[playerNames.length];
        halfTotalTracker = new TextView[playerNames.length];
        gameTotalTracker = new TextView[playerNames.length];
        selectedView = null;
        TextView tempTextView;
        final Context context  = getApplicationContext();

        for(int i = 0; i < playerNames.length; i++)
        {
            tempTextView = new TextView(context);
            tempTextView.setAllCaps(true);
            tempTextView.setText(playerNames[i]);
            tempTextView.setBackgroundResource(R.drawable.textview_border);

            //tempTextView.getLayoutParams().height = 30;
            namesCol.addView(tempTextView);
            nameTracker[i] = tempTextView;

            for(int j = 0; j < 18; j++)
            {
                tempTextView = new TextView(context);
                if(i == 0)
                {
                    tempTextView.setText(scores_1[j]);
                }
                else if(i == 1)
                {
                    tempTextView.setText(scores_2[j]);
                }
                else
                {
                    tempTextView.setText("");
                }
                tempTextView.setGravity(Gravity.CENTER);
                tempTextView.setBackgroundResource(R.drawable.textview_border);
                //tempTextView.getLayoutParams().width = 30;
                //tempTextView.getLayoutParams().height = 30;
                tempTextView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        if(selectedView != null)
                        {
                            selectedView.setBackgroundResource(R.drawable.textview_border);
                        }
                        selectedView = (TextView) v;
                        selectedView.setBackgroundResource(R.drawable.textview_highlight);
                    }
                });

                switch (j)
                {
                    case 0:
                        hole1Col.addView(tempTextView);
                        break;
                    case 1:
                        hole2Col.addView(tempTextView);
                        break;
                    case 2:
                        hole3Col.addView(tempTextView);
                        break;
                    case 3:
                        hole4Col.addView(tempTextView);
                        break;
                    case 4:
                        hole5Col.addView(tempTextView);
                        break;
                    case 5:
                        hole6Col.addView(tempTextView);
                        break;
                    case 6:
                        hole7Col.addView(tempTextView);
                        break;
                    case 7:
                        hole8Col.addView(tempTextView);
                        break;
                    case 8:
                        hole9Col.addView(tempTextView);
                        break;
                    case 9:
                        hole10Col.addView(tempTextView);
                        break;
                    case 10:
                        hole11Col.addView(tempTextView);
                        break;
                    case 11:
                        hole12Col.addView(tempTextView);
                        break;
                    case 12:
                        hole13Col.addView(tempTextView);
                        break;
                    case 13:
                        hole14Col.addView(tempTextView);
                        break;
                    case 14:
                        hole15Col.addView(tempTextView);
                        break;
                    case 15:
                        hole16Col.addView(tempTextView);
                        break;
                    case 16:
                        hole17Col.addView(tempTextView);
                        break;
                    case 17:
                        hole18Col.addView(tempTextView);
                        break;
                    default:
                }
                holeTracker[i][j] = tempTextView;
            }

            tempTextView = new TextView(context);
            tempTextView.setText("0");
            tempTextView.setBackgroundResource(R.drawable.textview_border);
            tempTextView.setGravity(Gravity.CENTER);
            halfTotal.addView(tempTextView);
            halfTotalTracker[i] = tempTextView;

            tempTextView = new TextView(context);
            tempTextView.setText("0");
            tempTextView.setBackgroundResource(R.drawable.textview_border);
            tempTextView.setGravity(Gravity.CENTER);
            gameTotal.addView(tempTextView);
            gameTotalTracker[i] = tempTextView;
        }

        enter1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("1");
                calculateScores(playerNames.length);
            }
        });
        enter2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("2");
                calculateScores(playerNames.length);
            }
        });
        enter3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("3");
                calculateScores(playerNames.length);
            }
        });
        enter4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("4");
                calculateScores(playerNames.length);
            }
        });
        enter5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("5");
                calculateScores(playerNames.length);
            }
        });
        enter6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                selectedView.setText("6");
                calculateScores(playerNames.length);
            }
        });
    }

    private void calculateScores(int numberOfPlayers)
    {
        int halfSum;
        int gameSum;
        String text;
        boolean gameOver = true;
        for (int i = 0; i < numberOfPlayers; i++)
        {
            halfSum = 0;
            gameSum = 0;
            for(int j = 0; j < 18; j++)
            {
                switch (holeTracker[i][j].getText().toString())
                {
                    case "1":
                        if (j < 9)
                        {
                            halfSum += 1;
                        }
                        gameSum += 1;
                        break;
                    case "2":
                        if (j < 9)
                        {
                            halfSum += 2;
                        }
                        gameSum += 2;
                        break;
                    case "3":
                        if (j < 9)
                        {
                            halfSum += 3;
                        }
                        gameSum += 3;
                        break;
                    case "4":
                        if (j < 9)
                        {
                            halfSum += 4;
                        }
                        gameSum += 4;
                        break;
                    case "5":
                        if (j < 9)
                        {
                            halfSum += 5;
                        }
                        gameSum += 5;
                        break;
                    case "6":
                        if (j < 9)
                        {
                            halfSum += 6;
                        }
                        gameSum += 6;
                        break;
                    default:
                        gameOver = false;
                        break;
                }
            }
            halfTotalTracker[i].setText(Integer.toString(halfSum));
            gameTotalTracker[i].setText(Integer.toString(gameSum));
        }
        if (gameOver == true)
        {
            startGameOver();
        }
    }

    private void startGameOver()
    {
        String[] playerScores =  new String[pNames.length];
        for (int i = 0; i < pNames.length; i++)
        {
            playerScores[i] = gameTotalTracker[i].getText().toString();
        }
        //Intent intent = new Intent(ScorecardActivity.this, GameOverActivity.class);
        //intent.putExtra("NAMES", pNames);
        //intent.putExtra("SCORES", playerScores);
        //startActivity(intent);
    }


}
