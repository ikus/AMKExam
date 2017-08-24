package com.evernet.amkdiscography.control.store.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.evernet.amkdiscography.R;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryItemHolder extends RecyclerView.ViewHolder {
    private AppCompatTextView tv_input_question = null;
    private View mView;

    public CategoryItemHolder(View itemView) {
        super(itemView);
    }

    public View getView() {
        return mView;
    }

    public AppCompatTextView getTv_input_question() {
        //if (tv_input_question == null)
        //    tv_input_question = (AppCompatTextView) getView().findViewById(R.id.text_input_question);
        return tv_input_question;
    }
}
