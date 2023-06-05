package com.chinhtd.lab6;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> list;

    public StudentAdapter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_lv,parent,false);
        TextView textView = convertView.findViewById(R.id.tv1);
        TextView textView1 = convertView.findViewById(R.id.name);
        TextView textView2 = convertView.findViewById(R.id.diachi);

        Button btnDelete = convertView.findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
        Button btupdate = convertView.findViewById(R.id.btn_update);
        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity_home)context).updateSV(position);
            }
        });

        textView.setText(list.get(position).getCoSo());
        textView1.setText(list.get(position).getName());
        textView2.setText(list.get(position).getDiaChi());
        return convertView;
    }

}