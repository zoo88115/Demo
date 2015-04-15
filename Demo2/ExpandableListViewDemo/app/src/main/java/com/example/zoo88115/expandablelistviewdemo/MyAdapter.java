package com.example.zoo88115.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseExpandableListAdapter{
    private String[] groups ;
    private String[][] children;
    private Integer[][] pictures;
    private Context mContext;
    private static LayoutInflater inflater = null;

    public MyAdapter(Context c,String []g,String[][] ch, Integer[][] p){
        groups=g;
        children=ch;
        pictures=p;
        mContext=c;
        inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return groups.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
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
    public boolean hasStableIds() {//不知
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        /*View view = convertView;
        view = inflater.inflate(R.layout.activity_group, null);
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(groups[groupPosition]);
        return view;*/
        TextView textView = null;
        if(convertView==null){
            textView = new TextView(mContext);
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
        View view = convertView;
        view = inflater.inflate(R.layout.activity_child, null);
        TextView text = (TextView) view.findViewById(R.id.textView2);
        text.setText(children[groupPosition][childPosition]);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        img.setImageResource(pictures[groupPosition][childPosition]);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {//不知
        return true;
    }
}
