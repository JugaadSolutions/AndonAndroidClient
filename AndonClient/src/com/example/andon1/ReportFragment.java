package com.example.andon1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ReportFragment extends DialogFragment

{
	int from_year, from_month, from_day,to_year, to_month, to_day; 
	
	private TextView mDateDisplay;
	private TextView endDateDisplay;
	private Button mPickDate;
	private Button endPickDate;
	//private int mYear;
	//private int mMonth;
	//private int mDay;
	static final int START_DATE_DIALOG_ID = 0;
	static final int END_DATE_DIALOG_ID = 1;
	
		public ReportFragment(){}
  
		
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_report, container, false);
		
		               
		        return rootView;
  }
	 private void updateEndDisplay() {
	        endDateDisplay.setText(
	                new StringBuilder()
	                    // Month is 0 based so add 1
	                    .append(to_day + 1).append("-")
	                    .append(to_month).append("-")
	                    .append(to_year).append(" "));

	    }
	 
	 private void updateStartDisplay() {
	        mDateDisplay.setText(
	                new StringBuilder()
	                    // Month is 0 based so add 1
	                    .append(from_day + 1).append("-")
	                    .append(from_month).append("-")
	                    .append(from_year).append(" "));


	    }
	    private DatePickerDialog.OnDateSetListener from_dateListener  =
	            new DatePickerDialog.OnDateSetListener() {

	            public void onDateSet(DatePicker view, int year, 
	                                  int monthOfYear, int dayOfMonth) {
	            	from_year = year;
	            	from_month = monthOfYear;
	            	from_day = dayOfMonth;
	                updateStartDisplay();
	            }
	        };

	        private DatePickerDialog.OnDateSetListener to_dateListener  =
	                new DatePickerDialog.OnDateSetListener() {

	                public void onDateSet(DatePicker view, int year, 
	                                      int monthOfYear, int dayOfMonth) {
	                	to_year = year;
	                    to_month = monthOfYear;
	                    to_day = dayOfMonth;
	                    updateEndDisplay();
	                }
	            };
	            
	           
	        	
	            
	            @Override   
	            public  Dialog onCreateDialog(Bundle savedInstanceState) {
	            	
	            	Bundle bundle = new Bundle();
	                bundle = getArguments();
	                int id = bundle.getInt("dialog_id");
	            	
	            if (id == START_DATE_DIALOG_ID) {
					return new DatePickerDialog(getActivity(),
							from_dateListener,
							from_year, from_month, from_day);
				} else if (id == END_DATE_DIALOG_ID) {
					return new DatePickerDialog(getActivity(),
							to_dateListener,
							to_year, to_month, to_day);
				}
	            return null;
	        }
		
}
