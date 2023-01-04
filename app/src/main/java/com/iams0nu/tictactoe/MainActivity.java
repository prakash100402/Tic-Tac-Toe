package com.iams0nu.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn;
    //0=cross,1=circle
    int player =0;

    int[] gamestate= {2,2,2,2,2,2,2,2,2};
    int[][] winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameactive=true;

    public void tic(View view)
    {
        ImageView img = (ImageView) view;
        TextView txt=(TextView) findViewById(R.id.textView2);

        int counter = Integer.parseInt(img.getTag().toString());
        if (gamestate[counter]==2 && gameactive) {
            gamestate[counter] = player;

            img.setTranslationY(-1500);

            if (player == 0) {
                img.setImageResource(R.drawable.cross);
                player = 1;
            } else {
                img.setImageResource(R.drawable.circle);
                player = 0;
            }


            img.animate().translationYBy(1500).rotation(360).setDuration(500);

            for (int[] winning : winning) {
                if (gamestate[winning[0]] == gamestate[winning[1]] && gamestate[winning[1]] == gamestate[winning[2]] && gamestate[winning[0]] != 2) {
                    gameactive=false;
                    String thewinner = "";
                    if (player == 1) {
                        thewinner = "X-Cross has won ^_^";

                    } else {
                        thewinner = "O-circle has won ^_^";
                    }

                    txt.setText(thewinner);
                    Button btn = (Button) findViewById(R.id.button);
                    btn.setVisibility(View.VISIBLE);
                    txt.setVisibility(View.VISIBLE);

                }
            }

        }
    }

  /*  public void playagain(View view)
    {
        TextView txt=(TextView) findViewById(R.id.textView2);
        Button btn = (Button) findViewById(R.id.button);
        btn.setVisibility(View.INVISIBLE);
        txt.setVisibility(View.INVISIBLE);
        GridLayout gridLayout=(GridLayout) findViewById(R.id.gridview);

        for (int i=0;i<gridLayout.getChildCount();i++)
        {
            ImageView img = (ImageView) gridLayout.getChildAt(i);
            img.setImageDrawable(null);
        }

        for(int i = 0; i < gamestate.length; i++)
        {
            gamestate[i]=2;
        }
         player =0;
        gameactive=true;
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
                overridePendingTransition(0,0);

            }
        });

    }
}