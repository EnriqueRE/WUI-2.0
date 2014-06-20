package com.cita.wallet.app.fragments;

import java.util.Calendar;
import java.util.Date;

import roboguice.util.temp.Ln;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.cita.wallet.app.R;
import com.cita.wallet.app.adapters.StatementAdapter;
import com.cita.wallet.app.models.WalletStatement;
import com.cita.wallet.app.models.WalletStatement.List;
import com.cita.wallet.app.network.StatementsByDateRequest;
import com.cita.wallet.app.utils.AppUtils;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.CalendarPickerView.SelectionMode;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link AccountStatementFragment.OnFragmentInteractionListener} interface to
 * handle interaction events. Use the
 * {@link AccountStatementFragment#newInstance} factory method to create an
 * instance of this fragment.
 * 
 */
public class AccountStatementFragment extends BaseFragment {
	private static final String ARG_USER = "id";

	String userId;
	private OnFragmentInteractionListener mListener;

	@InjectView(android.R.id.list)
	AbsListView statements_list;

	@InjectView(android.R.id.empty)
	TextView txtEmpty;

	private CalendarPickerView dialogView;
	private AlertDialog theDialog;
	Calendar lastYear;
	Calendar nextYear;
	String startDate = "";
	String endDate = "";

	StatementsByDateRequest mRequest;

	StatementAdapter mAdapter;

	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 * 
	 * @param userId
	 *            Wallet User.
	 * @return A new instance of fragment AccountStatementFragment.
	 */
	public static AccountStatementFragment newInstance(String userId) {
		AccountStatementFragment fragment = new AccountStatementFragment();
		Bundle args = new Bundle();
		args.putString(ARG_USER, userId);
		fragment.setArguments(args);
		return fragment;
	}

	public AccountStatementFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments() != null) {
			userId = getArguments().getString(ARG_USER);
			Ln.i(userId);
		}

		nextYear = Calendar.getInstance();
		nextYear.add(Calendar.YEAR, 1);

		lastYear = Calendar.getInstance();
		lastYear.add(Calendar.YEAR, -1);

		Date today = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		startDate = AppUtils.getFirstDayOfMonth();
		endDate = AppUtils.changeDateFormatForWebService(today);

		Ln.d("End date: " + startDate);
		Ln.d("Start date: " + endDate);

		makeRequest(userId, startDate, endDate);

		if (savedInstanceState == null) {
			setHasOptionsMenu(true);
		}

	}

	/**
	 * The default content for this Fragment has a TextView that is shown when
	 * the list is empty. If you would like to change the text, call this method
	 * to supply the text it should use.
	 */
	public void setEmptyText(CharSequence emptyText) {
		View emptyView = statements_list.getEmptyView();

		if (emptyText instanceof TextView) {
			((TextView) emptyView).setText(emptyText);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account_statement,
				container, false);
		ButterKnife.inject(this, rootView);

		return rootView;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onFragmentInteraction(Uri uri);
	}

	/** Show the date dialog */
	public void displayDateDialog() {

		dialogView = (CalendarPickerView) getActivity().getLayoutInflater()
				.inflate(R.layout.dialog_calendar, null, false);
		dialogView.init(lastYear.getTime(), nextYear.getTime())
				.inMode(SelectionMode.RANGE).withSelectedDate(new Date());
		theDialog = new AlertDialog.Builder(getActivity())
				.setTitle(
						getActivity().getResources().getString(
								R.string.dialog_title))
				.setView(dialogView)
				.setNeutralButton(
						getActivity().getResources().getString(
								R.string.dialog_button),
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(
									DialogInterface dialogInterface, int i) {

								java.util.List<Date> dates = dialogView
										.getSelectedDates();

								startDate = AppUtils
										.changeDateFormatForWebService(dates
												.get(0));
								endDate = AppUtils
										.changeDateFormatForWebService(dates
												.get(dates.size() - 1));

								makeRequest(userId, startDate, endDate);

								dialogInterface.dismiss();
							}
						}).create();
		theDialog.show();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.fragment_statement_menu, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.calendar:
			displayDateDialog();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void makeRequest(String id, String startDate, String endDate) {

		mRequest = new StatementsByDateRequest(id, startDate, endDate);
		getSpiceManager().execute(mRequest,
				new StatementsByDateRequestListener());

	}

	public final class StatementsByDateRequestListener implements
			RequestListener<WalletStatement.List> {

		@Override
		public void onRequestFailure(SpiceException exception) {
			Toast.makeText(getActivity(),
					"Something went wrong during the request",
					Toast.LENGTH_SHORT).show();

			exception.printStackTrace();

		}

		@Override
		public void onRequestSuccess(List statements) {
			mAdapter = new StatementAdapter(getActivity(), statements);
			((AdapterView<ListAdapter>) statements_list).setAdapter(mAdapter);
			mAdapter.notifyDataSetChanged();

			if (statements.size() > 0) {
				txtEmpty.setVisibility(View.GONE);

			}

		}

	}

}
