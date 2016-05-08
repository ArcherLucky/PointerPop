package com.archer.pointerpop;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                if (position % 2 == 0) {
                    return "今晚我要去约妹子";
                } else {
                    return "Hello";

                }
//                return "button";
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            int x;

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, null);
                TextView tv = (TextView) convertView.findViewById(R.id.text1);
                tv.setText(getItem(position).toString());

                convertView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == MotionEvent.ACTION_DOWN) {
                            x = (int) event.getX();
                        }
                        return false;
                    }
                });

                convertView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        PopupWindow popupWindow = new PopupWindow
                                (LayoutInflater.from(getApplicationContext()).inflate(R.layout.pop_content, null),
                                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) popupWindow.getContentView().findViewById(R.id.image).getLayoutParams();
                        layoutParams.leftMargin = x;
                        int[] location = new int[2];
                        v.getLocationOnScreen(location);
                        popupWindow.setBackgroundDrawable(new ColorDrawable());
                        popupWindow.setOutsideTouchable(true);
                        popupWindow.setFocusable(true);
                        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], location[1] - v.getHeight());
                    }
                });
                return convertView;

            }
        });

    }
}
