package com.zucc.circle.summerwork.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zucc.circle.summerwork.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFinacialFragment extends Fragment {


    public PersonFinacialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_finacial, container, false);
    }

}
