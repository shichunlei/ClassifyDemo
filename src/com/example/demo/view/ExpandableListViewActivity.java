package com.example.demo.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.Model;
import com.example.demo.R;
import com.example.demo.adapter.ExpandableListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

public class ExpandableListViewActivity extends Activity {

	private ExpandableListView expandableListView;

	private ExpandableListAdapter adapter;

	private List<Map<String, Object>> list;
	private String[][] child_text_array;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable_listview);

		init();
		initModle();
		setListener();
	}

	private void init() {
		expandableListView = (ExpandableListView) findViewById(R.id.list);

		child_text_array = Model.MORELISTTXT2;
	}

	private void setListener() {
		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				Toast.makeText(getApplicationContext(),
						list.get(groupPosition).get("txt").toString(),
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});

		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				Toast.makeText(getApplicationContext(),
						child_text_array[groupPosition][childPosition],
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});
	}

	private void initModle() {
		list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < Model.LISTVIEWTXT2.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("img", Model.LISTVIEWIMG2[i]);
			map.put("txt", Model.LISTVIEWTXT2[i]);
			list.add(map);
		}
		adapter = new ExpandableListAdapter(this, list, child_text_array);
		expandableListView.setAdapter(adapter);
	}

}
