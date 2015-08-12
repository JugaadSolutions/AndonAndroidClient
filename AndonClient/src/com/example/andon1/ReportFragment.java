package com.example.andon1;

import java.util.Calendar;
import java.util.HashMap;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ReportFragment extends Fragment {
	public ReportFragment(){}
	  

	int from_year, from_month, from_day,to_year, to_month, to_day; //initialize them to current date in onStart()/onCreate()
	//DatePickerDialog.OnDateSetListener from_dateListener,to_dateListener;
	
	private TextView mDateDisplay;
	private TextView endDateDisplay;
	private Button mPickDate;
	private Button endPickDate;
	//private int mYear;
	//private int mMonth;
	//private int mDay;
	static final int START_DATE_DIALOG_ID = 0;
	static final int END_DATE_DIALOG_ID = 0;
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_report, container, false);
		
		 /*  capture our View elements for the start date function   */
        mDateDisplay = (TextView) rootView.findViewById(R.id.mDateDisplay);
        mPickDate = (Button) rootView.findViewById(R.id.mPickDate);

        /* add a click listener to the button   */
        mPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().showDialog(START_DATE_DIALOG_ID);
            }
        });
        /* get the current date */
        final Calendar c = Calendar.getInstance();
        from_year = c.get(Calendar.YEAR);
        from_month = c.get(Calendar.MONTH);
        from_day = c.get(Calendar.DAY_OF_MONTH);
        
      
        /* display the current date (this method is below)  */
        updateStartDisplay();
        
        /* capture our View elements for the end date function */
        endDateDisplay = (TextView) rootView.findViewById(R.id.endDateDisplay);
        endPickDate = (Button) rootView.findViewById(R.id.endPickDate);

        /* add a click listener to the button   */
        endPickDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().showDialog(END_DATE_DIALOG_ID);
            }
        });

        /* get the current date */
        final Calendar c1 = Calendar.getInstance();
        to_year = c.get(Calendar.YEAR);
        to_month = c.get(Calendar.MONTH);
        to_day = c.get(Calendar.DAY_OF_MONTH);
        

        /* display the current date (this method is below)  */
        updateEndDisplay();
		
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
	            
	        
	        protected Dialog onCreateDialog(int id) {
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
