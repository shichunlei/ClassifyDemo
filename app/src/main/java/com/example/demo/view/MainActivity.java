package com.example.demo.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.demo.R;

public class MainActivity extends AppCompatActivity {

    private Button listlistview, listgridview, expandableListView, expandableGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listlistview = findViewById(R.id.listlist);
        listgridview = findViewById(R.id.listgrid);
        expandableListView = findViewById(R.id.expandableListView);
        expandableGridView = findViewById(R.id.expandableGridView);

        listlistview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ListListActivity.class);
                startActivity(intent);
            }
        });

        listgridview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ScrollGridActivity.class);
                startActivity(intent);
            }
        });

        expandableListView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });

        expandableGridView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ExpandableGridViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
