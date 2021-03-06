package com.chungzheng.benchmarkingandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void startTest(View view){
        resetTest(view);
        long startTime = System.currentTimeMillis();
        LinearLayout lnlayout = (LinearLayout)findViewById(R.id.ll_horde);
        EditText etViewNum = (EditText)findViewById(R.id.et_viewNumber);
        String etValue = etViewNum.getText().toString().trim();
        if (etValue.equals(""))
            etValue = "0";
        int numViews = Integer.parseInt(etValue);
        for (int i = 0; i < numViews; i++)
        {
            TextView tv_spawn = new TextView(this);
            tv_spawn.setText(Integer.toString(i));
            tv_spawn.setBackgroundResource(android.R.drawable.bottom_bar);
            tv_spawn.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            lnlayout.addView(tv_spawn);
        }
        long stopTime = System.currentTimeMillis();
        ((TextView) findViewById(R.id.tv_timer)).setText("Time: " + String.valueOf(stopTime - startTime) + " milliseconds");
    }

    public void resetTest(View view){
        LinearLayout lnlayout = (LinearLayout)findViewById(R.id.ll_horde);
        if(lnlayout.getChildCount()>0)
            lnlayout.removeAllViews();
    }
}
