package com.example.zoo88115.expandablelistviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;


public class MainActivity extends ActionBarActivity {
    private String[] groups = { "group1", "group2", "group3", "group4"};
    private String[][] children = { { "child11" }, { "child21", "child22" },{ "child31", "child32", "child33" },{ "child41", "child42", "child43", "child44" } };
    private final Integer[][] pictures = {{R.drawable.apple},   {R.drawable.orange,R.drawable.tomato},  {R.drawable.lemon,R.drawable.peach,R.drawable.watermelon},{R.drawable.cheey,R.drawable.pineapple,R.drawable.pineapple,R.drawable.pineapple}};
    ExpandableListView lv;
    MyAdapter lvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ExpandableListView) findViewById (R.id.expandableListView);
        lvAdapter = new MyAdapter(this,groups,children,pictures);
        lv.setAdapter(lvAdapter);
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
}
