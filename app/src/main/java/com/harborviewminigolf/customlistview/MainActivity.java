package com.harborviewminigolf.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends AppCompatActivity {

    // Fill the list with images
    //int[] IMAGES = {R.drawable.jif, R.drawable.gif, R.drawable.biff, R.drawable.jif, R.drawable.gif, R.drawable.biff};

    // List of names
    //String[] NAMES = {"JIF", "GIF", "Biff", "JIF", "GIF", "Biff"};

    // List of descriptions
    //String[] DESCRIPTIONS = {"Peanut Butter", "Pronounced like the peanut butter", "BTTF", "Peanut Butter", "Pronounced like the peanut butter", "BTTF"};

    String[] YEARS = {"2016", "2016", "2017", "2018", "2018", "2019"};

    String[] DAYS = {"02", "13", "15", "16", "04", "21"};

    String[] NUM_PLAYERS = {"2", "3", "2", "6", "5", "6"};

    String[] BEST_SCORE = {"37", "40", "44", "39", "58","40"};

    String[] WINNER = {"Brad", "Zach", "Zach", "Mike", "Brad", "Mike"};

    String[] MONTHS = {"JUN", "AUG", "JUL", "JUL", "AUG", "AUG"};

    String[] TIME = {"0h 37m", "0h 56m", "0h 33m", "0h 42m", "1h 23m", "1h 32m"};

    String[] SCORES_1 = {"3","4","1","6","3","3","4","3","2","2","6","5","1","4","3","4","3","2"};
    String[] SCORES_2 = {"4","5","5","6","5","4","4","6","5","2","1","1","3","4","4","3","2","2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a listview object
        ListView listView=(ListView)findViewById(R.id.listView);

        // Create a custom adapter object
        CustomAdapter customAdapter = new CustomAdapter();

        // Set the custom adapter to the listview
        // The adapter is how information gets ~adapted~ to a
        //      graphical representation, such as a list view
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                // Get index
                // print array value at that index
                // show blank scorecard

                Log.d("clickTag", Integer.toString(position));

                // Create intent to go to scorecardActivity
                Intent scorecardIntent = new Intent(MainActivity.this, ScorecardActivity.class);

                // Pass number of players
                scorecardIntent.putExtra("numberOfPlayers", Integer.parseInt(NUM_PLAYERS[position]));

                // Pass first scores array to scorecard
                Bundle bundle_1 = new Bundle();
                bundle_1.putStringArray("scores_1",SCORES_1);
                scorecardIntent.putExtras(bundle_1);

                // Pass second scores array to scorecard
                Bundle bundle_2 = new Bundle();
                bundle_2.putStringArray("scores_2",SCORES_2);
                scorecardIntent.putExtras(bundle_2);

                // Start scorecard activity
                startActivity(scorecardIntent);

            }
        });
    }


    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount(){
            return WINNER.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            // Get the custom list item layout
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            // Get the image view, text view and other text view id's
            /*
            ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_description);
            */

            // DATE
            TextView yearView=(TextView)view.findViewById(R.id.yearView);
            TextView dayView=(TextView)view.findViewById(R.id.dayView);
            TextView monthView=(TextView)view.findViewById(R.id.monthView);

            // NUM PLAYERS
            TextView numPlayersView=(TextView)view.findViewById(R.id.numPlayersView);

            // WINNER
            TextView winnerView=(TextView)view.findViewById(R.id.winnerNameView);

            // TIME
            TextView timePlayedView=(TextView)view.findViewById(R.id.timePlayedView);

            // BEST SCORE
            TextView bestScoreView=(TextView)view.findViewById(R.id.bestScoreView);


            // Set the corresponding fields to the views
            /*
            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTIONS[i]);
            */


            // DATE
            yearView.setText(YEARS[i]);
            dayView.setText(DAYS[i]);
            monthView.setText(MONTHS[i]);

            // NUM PLAYERS
            numPlayersView.setText(NUM_PLAYERS[i]);

            // WINNER
            winnerView.setText(WINNER[i]);

            // TIME
            timePlayedView.setText(TIME[i]);

            // BEST SCORE
            bestScoreView.setText(BEST_SCORE[i]);

            // Return the custom list view
            return view;
        }
    }
}
