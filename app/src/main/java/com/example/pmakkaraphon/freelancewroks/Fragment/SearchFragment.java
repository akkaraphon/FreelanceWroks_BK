package com.example.pmakkaraphon.freelancewroks.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pmakkaraphon.freelancewroks.MainActivity;
import com.example.pmakkaraphon.freelancewroks.R;
import com.example.pmakkaraphon.freelancewroks.Utils.StaticClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private View view;
    StaticClass sc = new StaticClass();



    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) getActivity()).setActionBarTitle("ค้นหา");
    }

}
