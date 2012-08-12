package com.gautam.SAXParser;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Custom Adapter extended from Base adapter
 * 
 * @author Gautam B
 * 
 */
public class CustomAdapter extends BaseAdapter {
	/**
	 * values that needs to be set in the adapter
	 */
	private static String[] mData;

	/**
	 * context
	 */
	private Context mContext;

	/**
	 * TAG
	 */

	/**
	 * Constructor of Custom Adapter
	 */
	public CustomAdapter(Context context, String[] s) {
		mContext = context;
		mData = s;

	}

	/**
	 * Get count returns the values
	 */
	public int getCount() {
		return mData.length;
	}

	/**
	 * Get count returns the values
	 */
	public Object getItem(int position) {
		return null;
	}

	/**
	 * Get count returns the values
	 */
	public long getItemId(int position) {
		return 0;
	}

	/**
	 * Renders the view of each object
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater layoutInflater = null;
		View rowView = convertView;
		if (rowView == null) {
			layoutInflater = ((Activity) mContext).getLayoutInflater();
			rowView = layoutInflater.inflate(R.layout.row, null);
		}
		TextView rowText1 = (TextView) rowView.findViewById(R.id.rowText1);
		TextView rowText2 = (TextView) rowView.findViewById(R.id.rowText2);
		TextView rowText3 = (TextView) rowView.findViewById(R.id.rowText3);
		String[] values = mData[position].toString().split("NEXT");
		rowText1.setText(values[0].toString());
		rowText2.setText(values[1].toString());
		rowText3.setText(values[2].toString());

		return rowView;

	}

	@Override
	public boolean isEnabled(int position) {

		return super.isEnabled(position);
	}
}
