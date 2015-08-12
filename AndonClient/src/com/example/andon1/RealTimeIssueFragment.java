package com.example.andon1;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RealTimeIssueFragment extends Fragment {
	
	public RealTimeIssueFragment(){}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
        View rootView = inflater.inflate(R.layout.fragment_realtimeissue, container, false);
         
        return rootView;
    }

	

}
