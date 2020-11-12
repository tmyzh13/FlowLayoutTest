package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FlowLayout flowLayout;
    private List<String> texts = new ArrayList<>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowLayout=(FlowLayout)findViewById(R.id.flowlayout);
        texts.add("1111");
        texts.add("aaaaaaaaaaa1");
        texts.add("122211");
        texts.add("1111");
        texts.add("1111");
        texts.add("dasdasd11");
        texts.add("1sadasdasdasdas1");
        texts.add("1111");
        texts.add("2222222222");
        texts.add("333");

        flowLayout.removeAllViews();
        flowLayout.setMaxLine(2);

        View upView= LayoutInflater.from(this).inflate(R.layout.item_up,null,false);
        textView=upView.findViewById(R.id.view);
        textView.setText("下");
        for (int i = 0; i < texts.size(); i++) {
            flowLayout.addView(getTag(texts.get(i)));
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flowLayout.getMaxLine() != -1) {
                    flowLayout.setMaxLine(-1);
                    textView.setText("上");
                } else {
                    flowLayout.setMaxLine(2);
                    textView.setText("下");
                }

            }
        });
        flowLayout.addView(upView);
    }

    private View getTag(String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tag, null, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_tag);
        textView.setText(text);
        return view;
    }
}