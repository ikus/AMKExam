package com.evernet.amkdiscography.control.store.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evernet.amkdiscography.R;
import com.evernet.amkdiscography.control.store.ui.model.CategoryModel;

import java.util.ArrayList;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryItemHolder> {
    private ArrayList<CategoryModel> listCategories;

    public CategoryRecyclerViewAdapter() {
        this.listCategories = new ArrayList<>();
    }

    public CategoryRecyclerViewAdapter(ArrayList<CategoryModel> listCategories) {
        this.listCategories = listCategories;
    }
    //private RecyclerViewListener mListener;

    @Override
    public CategoryItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryItemHolder rcv = new CategoryItemHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(CategoryItemHolder holder, int position) {
        final CategoryModel mCategory = getItem(position);
        holder.getTv_input_name().setText(mCategory.getName());
        holder.getIconService().setImageURI(mCategory.getUrlPrevew());
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private CategoryModel getItem(int index) {
        return listCategories.get(index);
    }

    @Override
    public int getItemCount() {
        if (listCategories == null) return 0;
        return listCategories.size();
    }

    public void swapItems(ArrayList<CategoryModel> categories) {
        if (listCategories == null) listCategories = new ArrayList<>();
        listCategories.clear();
        listCategories.addAll(categories);
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return listCategories.isEmpty();
    }

    public interface CategoriesListener {
        void onClickItem(CategoryModel mCategory);
    }
}
