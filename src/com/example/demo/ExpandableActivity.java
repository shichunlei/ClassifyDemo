package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;

public class ExpandableActivity extends Activity {

	private ExpandableListView expandableListView;

	private ExpandableListAdapter adapter;

	private String[] group_title_arry;
	private String[][] child_text_array;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_expandable);

		init();
		setListener();

	}

	private void init() {
		group_title_arry = Model.group_title_arry;
		child_text_array = Model.child_text_array;
		
		adapter = new ExpandableListAdapter(this);

		expandableListView = (ExpandableListView) findViewById(R.id.list);
		expandableListView.setAdapter(adapter);
	}

	private void setListener() {
		expandableListView.setOnGroupClickListener(new OnGroupClickListener() {

			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				return false;
			}
		});

		expandableListView.setOnChildClickListener(new OnChildClickListener() {

			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				return false;
			}
		});
	}

	public class ExpandableListAdapter extends BaseExpandableListAdapter {

		private Context context;

		public ExpandableListAdapter(Context context) {
			this.context = context;
		}

		/**
		 * 获取一级标签总数
		 */
		@Override
		public int getGroupCount() {
			return group_title_arry.length;
		}

		/**
		 * 获取一级标签下二级标签的总数
		 */
		@Override
		public int getChildrenCount(int groupPosition) {
			return child_text_array[groupPosition].length;
		}

		/**
		 * 获取一级标签内容
		 */
		@Override
		public Object getGroup(int groupPosition) {
			return group_title_arry[groupPosition];
		}

		/**
		 * 获取一级标签下二级标签的内容
		 */
		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return child_text_array[groupPosition][childPosition];
		}

		/**
		 * 获取一级标签的ID
		 */
		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		/**
		 * 获取二级标签的ID
		 */
		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		/**
		 * 指定位置相应的组视图
		 */
		@Override
		public boolean hasStableIds() {
			return true;
		}

		/**
		 * 对一级标签进行设置
		 */
		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			convertView = (LinearLayout) LinearLayout.inflate(context,
					R.layout.group_layout, null);

			TextView group_title = (TextView) convertView
					.findViewById(R.id.group_title);
			if (isExpanded) {
				group_title.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.group_down, 0);
			} else {
				group_title.setCompoundDrawablesWithIntrinsicBounds(0, 0,
						R.drawable.group_up, 0);
			}
			group_title.setText(group_title_arry[groupPosition]);

			return convertView;
		}

		/**
		 * 对一级标签下的二级标签进行设置
		 */
		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			convertView = (RelativeLayout) RelativeLayout.inflate(context,
					R.layout.child_layout, null);
			TextView child_text = (TextView) convertView
					.findViewById(R.id.child_text);

			child_text.setText(child_text_array[groupPosition][childPosition]);

			return convertView;
		}

		/**
		 * 当选择子节点的时候，调用该方法
		 */
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
	}

}
