package com.example.zoo88115.expandablelistviewtest;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private String[] groups={"台北市","花蓮縣","高雄市"};
    private String[][] childs={{"天龍區","文山區","大安區"},{"花蓮市","吉安鄉","玉里鎮"},{"不知道","懶得查","不重要","多一個"}};

    private ExpandableListView listView;
    private MyAdapter adapter=new MyAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {//小孩事件監聽器
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childName = (String) adapter.getChild(groupPosition,childPosition).toString();
                Toast.makeText(MainActivity.this,"Click : "+childName+" item",Toast.LENGTH_LONG).show();// 目標,訊息內容,訊息格式
                Intent intent = new Intent();//跳轉activity
                intent.setClass(MainActivity.this, MainActivity2Activity.class);//跳轉activity
                startActivity(intent);//跳轉activity
                return false;
            }
        });
    }

    class MyAdapter extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return groups.length;//幾個group
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childs[groupPosition].length;   //group的小孩有幾個
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {//不知道捏
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){
                textView = new TextView(MainActivity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(groups[groupPosition]);
            textView.setTextSize(30);
            textView.setPadding(50,10,0,10);//左 上 右 下
            return textView;
        }
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){
                textView = new TextView(MainActivity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(childs[groupPosition][childPosition]);
            textView.setTextSize(20);
            textView.setPadding(72,10,0,10);
            textView.setTextColor(Color.BLUE);
            return textView;
        }
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
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
