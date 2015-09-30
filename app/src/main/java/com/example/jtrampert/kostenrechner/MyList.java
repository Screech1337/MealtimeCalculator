package com.example.jtrampert.kostenrechner;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MyList extends Activity {
    public static ArrayList<String> abc = new ArrayList<String>();
    public static ArrayList<String> def = new ArrayList<String>();
    public static ArrayList<String> ghi = new ArrayList<String>();
    public static ArrayList<String> jkl = new ArrayList<String>();
    public static ArrayList<String> mnr = new ArrayList<String>();

    EditText getUserInput;
    ListView listView;
    Context context = this;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_item);
                dialog.show();
                getUserInput = (EditText) findViewById(R.id.add_name);
                Button dialogButton = (Button) dialog.findViewById(R.id.add_button);
                dialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        double a = Math.random();
                        String b = Double.toString(a);

                        getUserInput = (EditText) findViewById(R.id.add_name);
                        String UserInput = getUserInput.getText().toString();

                        abc.add(UserInput);
                        def.add(b);
                        ghi.add("2");
                        jkl.add("3");
                        mnr.add("4");

                        dialog.dismiss();
                        listView = (ListView) findViewById(R.id.list);
                        listView.setAdapter(new EfficientAdapter(context));
                    }
                });
            }
        });
    }

    private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            return abc.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.simplerow, null);
                holder = new ViewHolder();
                holder.text1 = (TextView) convertView
                        .findViewById(R.id.row_name);
                holder.text2 = (TextView) convertView
                        .findViewById(R.id.row_grundmenge);
                holder.text3 = (TextView) convertView
                        .findViewById(R.id.row_preis);
                holder.text4 = (TextView) convertView
                        .findViewById(R.id.row_mz_menge);
                holder.text5 = (TextView) convertView
                        .findViewById(R.id.row_mz_preis);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.text1.setText(abc.get(position));
            holder.text2.setText(def.get(position));
            holder.text3.setText(ghi.get(position));
            holder.text4.setText(jkl.get(position));
            holder.text5.setText(mnr.get(position));
            return convertView;
        }

        static class ViewHolder {
            TextView text1;
            TextView text2;
            TextView text3;
            TextView text4;
            TextView text5;
        }
    }
}
