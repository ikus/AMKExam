package com.evernet.amkdiscography.control.store.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.control.store.ui.model.CategoryModel;

import butterknife.ButterKnife;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class SecondFilterFragment extends Fragment {

    public static SecondFilterFragment newInstance(CategoryModel categoryModel) {
        SecondFilterFragment fragment = new SecondFilterFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            savedInstanceState = getArguments();
            if (savedInstanceState != null) {
            }
            return;
        } else {
            return;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_firtsfilter, container, false);
        ButterKnife.bind(this, root);

        return root;
    }
}
