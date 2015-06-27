package com.example.demo.view;

import com.example.demo.Model;
import com.example.demo.R;
import com.example.demo.adapter.ExpandableGridAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class ExpandableGridViewActivity extends Activity {

	private ExpandableListView expandableGridView;

	ExpandableGridAdapter adapter;

	private String[] group_title_arry;
	private String[][] child_text_array;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_gridview);
		init();
		setListener();
	}

	private void init() {
		expandableGridView = (ExpandableListView) findViewById(R.id.list);

		group_title_arry = Model.LISTVIEWTXT2;
		child_text_array = Model.MORELISTTXT2;

		adapter = new ExpandableGridAdapter(this, group_title_arry,
				child_text_array);

		expandableGridView.setAdapter(adapter);
	}

	private void setListener() {

	}

}
