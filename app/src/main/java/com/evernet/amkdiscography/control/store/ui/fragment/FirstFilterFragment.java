package com.evernet.amkdiscography.control.store.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.app.flow.ScreenManager;
import com.evernet.amkdiscography.control.store.adapter.CategoryRecyclerViewAdapter;
import com.evernet.amkdiscography.control.store.ui.constructor.CategoriesFilterView;
import com.evernet.amkdiscography.control.store.ui.model.CategoryModel;
import com.evernet.amkdiscography.webservice.controller.CategoryController;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class FirstFilterFragment extends Fragment implements CategoriesFilterView, CategoryRecyclerViewAdapter.CategoriesListener {
    private static final String TAG = FirstFilterFragment.class.getSimpleName();
    private CategoryRecyclerViewAdapter mCategoryAdapter;

    public static FirstFilterFragment newInstance() {
        FirstFilterFragment fragment = new FirstFilterFragment();
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

        RecyclerView cardRecyclerView = (RecyclerView) root.findViewById(R.id.category_recycler_view);
        cardRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager cardLayoutManager = new LinearLayoutManager(getActivity());
        cardRecyclerView.setLayoutManager(cardLayoutManager);

        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mCategoryAdapter = new CategoryRecyclerViewAdapter();
        cardRecyclerView.setAdapter(mCategoryAdapter);
        mCategoryAdapter.notifyDataSetChanged();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        CategoryController ctrl = new CategoryController();
        ctrl.start(this);
    }


    @Override
    public void updateCategories(ArrayList<CategoryModel> categories) {
        mCategoryAdapter.swapItems(categories);
    }

    @Override
    public void onClickItem(CategoryModel category) {
        ScreenManager.getInstance().showSecondFilter(getActivity(), category);
    }
}
