package com.harborviewminigolf.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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

        /*
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String item = ((TextView)view).getText().toString();

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();

            }
        });*/
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
