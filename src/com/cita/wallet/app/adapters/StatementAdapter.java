package com.cita.wallet.app.adapters;

import java.util.List;

import roboguice.util.temp.Ln;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.cita.wallet.app.R;
import com.cita.wallet.app.models.WalletStatement;

public class StatementAdapter extends BaseAdapter {

	private List<WalletStatement> DATA;

	private LayoutInflater mInflater;
	Context context;

	public StatementAdapter(Context context, List<WalletStatement> DATA) {
		// Cache the LayoutInflate to avoid asking for a new one each time.
		mInflater = LayoutInflater.from(context);
		this.context = context;
		this.DATA = DATA;

	}

	/**
	 * @see android.widget.ListAdapter getCount()
	 */
	public int getCount() {
		return DATA.size();
	}

	/**
	 * @see android.widget.ListAdapter getItem(int)
	 */
	public Object getItem(int position) {
		return DATA.get(position);
	}

	/**
	 * Use the array index as a unique id.
	 * 
	 * @see android.widget.ListAdapter getItemId(int)
	 */
	public long getItemId(int position) {
		return position;
	}

	public void clearData() {
		// Clear everything
		DATA.clear();
	}

	/**
	 * Make a view to hold each row.
	 * 
	 * @see android.widget.ListAdapter getView(int, android view View, android
	 *      view ViewGroup)
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		ViewHolder mHolder;
		if (rowView == null) {
			rowView = mInflater.inflate(R.layout.list_item_statement, null);
			mHolder = new ViewHolder(rowView);
			rowView.setTag(mHolder);
		}

		mHolder = (ViewHolder) rowView.getTag();
		String amountFormat = context.getResources().getString(
				R.string.estado_list_item_amount);

		WalletStatement charge = DATA.get(position);
		Ln.d(charge.toString());

		mHolder.date.setText(charge.getStatement_date());

		String tuition_value = String.format(amountFormat,
				charge.getStatement_tuition());
		mHolder.tuition.setText(tuition_value);

		String insurance_value = String.format(amountFormat,
				charge.getStatement_insurance());
		mHolder.insurance.setText(insurance_value);

		String services_value = String.format(amountFormat,
				charge.getStatement_diverse_services());
		mHolder.services.setText(services_value);
		
		String interests = String.format(amountFormat,
				charge.getStatement_interests());
		mHolder.interests.setText(interests);
		

		return rowView;
	}

	static class ViewHolder {
		@InjectView(R.id.txt_date_value)
		TextView date;
		@InjectView(R.id.txt_tuition_value)
		TextView tuition;
		@InjectView(R.id.txt_insurance_value)
		TextView insurance;
		@InjectView(R.id.txt_services_value)
		TextView services;
		@InjectView(R.id.txt_interests_value)
		TextView interests;
		@InjectView(R.id.layout_background)
		GridLayout background;
		

		public ViewHolder(View view) {
			ButterKnife.inject(this, view);

		}

	}

}
