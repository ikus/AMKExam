package com.evernet.amkdiscography.control.store.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.evernet.amkdiscography.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Emisael Calderon on 8/24/2017.
 */

public class CategoryItemHolder extends RecyclerView.ViewHolder {
    private AppCompatTextView tv_input_name = null;
    private View mView;
    @Bind(R.id.idCategory)
    SimpleDraweeView iconService = null;

    public CategoryItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mView = itemView;
    }

    public View getView() {
        return mView;
    }

    public AppCompatTextView getTv_input_name() {
        if (tv_input_name == null)
            tv_input_name = (AppCompatTextView) getView().findViewById(R.id.tv_item_common_name);
        return tv_input_name;
    }

    public SimpleDraweeView getIconService() {
        return iconService;
    }

    public void setIconService(SimpleDraweeView iconService) {
        this.iconService = iconService;
    }
}
