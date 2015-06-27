package com.example.demo.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.demo.R;
import com.example.demo.customview.MyGridView;

public class ExpandableGridAdapter extends BaseExpandableListAdapter {

	private String[] group_title_arry;
	private String[][] child_text_array;
	private Context context;
	private MyGridView gridview;
	List<String> child_array = new ArrayList<String>();

	private int groupSize, childSize;

	public ExpandableGridAdapter(Context context, String[] group_title_arry,
			String[][] child_text_array) {
		this.context = context;
		this.group_title_arry = group_title_arry;
		this.child_text_array = child_text_array;
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
				R.layout.item_group_layout, null);

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

		groupSize = groupPosition;
		if (child_array != null) {
			child_array.clear();
		}
		for (int i = 0; i < getChildrenCount(groupPosition); i++) {
			child_array.add(child_text_array[groupPosition][i]);
		}

		return convertView;
	}

	/**
	 * 对一级标签下的二级标签进行设置
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = (RelativeLayout) RelativeLayout.inflate(context,
				R.layout.item_grid_child_layout, null);
		gridview = (MyGridView) convertView.findViewById(R.id.gridview);

		Log.i("111111", groupSize + "" + childPosition);
		childSize = childPosition;
		gridview.setAdapter(new GoodsCityAdapter(context, groupSize, childSize));
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