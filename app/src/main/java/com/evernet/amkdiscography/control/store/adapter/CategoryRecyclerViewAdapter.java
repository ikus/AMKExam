package com.evernet.amkdiscography.control.store.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.control.store.ui.model.Category;

import java.util.ArrayList;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryItemHolder> {
    private ArrayList<Category> listCategories;
    //private RecyclerViewListener mListener;

    @Override
    public CategoryItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryItemHolder rcv = new CategoryItemHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CategoryItemHolder holder, int position) {
//        final Insect mInsect = getItem(position);
//        holder.getTvCommonName().setText(mInsect.name);
//        holder.getTvScientificLevel().setText(mInsect.scientificName);
//        holder.getTvDangerLevel().setDangerLevel(mInsect.dangerLevel);
//
//        holder.getView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.onItemClick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void swapItems(ArrayList<Category> categories) {
        listCategories.clear();
        listCategories.addAll(categories);
        //DebugUtils.logDebug("TotalItems:: ", flashcards.size());
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return listCategories.isEmpty();
    }
}
