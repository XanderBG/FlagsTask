package com.example.xander.flagstask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class FlagActivity extends Activity {

    private int currentColor;
    private int[] colors;
    private int colorCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        colors = this.getResources().getIntArray(R.array.rainbow);

        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (colorCount == colors.length) {
                    colorCount = 0;
                }
                int color = colors[colorCount++];
                if (color == currentColor) {
                    color = colors[colorCount++];
                }
                v.setBackgroundColor(color);
            }
        };


        View topView = findViewById(R.id.top);
        topView.setOnClickListener(onClick);

        View midView = findViewById(R.id.mid);
        midView.setOnClickListener(onClick);

        View botView = findViewById(R.id.bot);
        botView.setOnClickListener(onClick);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.flag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
