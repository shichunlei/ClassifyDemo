package com.example.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button listlistview, listgridview, expandable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listlistview = (Button) findViewById(R.id.listlist);
		listgridview = (Button) findViewById(R.id.listgrid);
		expandable = (Button) findViewById(R.id.expandable);

		listlistview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ListListActivity.class);
				startActivity(intent);
			}
		});

		listgridview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ListGridActivity.class);
				startActivity(intent);
			}
		});
		
		expandable.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, ExpandableActivity.class);
				startActivity(intent);
			}
		});
	}

}
