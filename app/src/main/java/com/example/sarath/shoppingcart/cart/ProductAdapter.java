package com.example.sarath.shoppingcart.cart;

/**
 * Created by sarath on 1/18/2017.
 */
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sarath.shoppingcart.R;

import com.squareup.picasso.Picasso;

public class ProductAdapter extends BaseAdapter {

    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowCheckbox;
    Context mContext;

    public ProductAdapter(Context context, List<Product> list, LayoutInflater inflater, boolean showCheckbox) {
        mProductList = list;
        mContext=context;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }

    public ProductAdapter(Context context, LayoutInflater inflater, boolean showCheckbox) {
        mContext=context;
        mInflater = inflater;
        mShowCheckbox = showCheckbox;
    }



    @Override
    public int getCount() {

        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {

        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item, parent,false);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem);

            item.productTitle = (TextView) convertView.findViewById(R.id.TextViewItem);

            item.productCheckbox = (CheckBox) convertView.findViewById(R.id.CheckBoxSelected);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product curProduct = mProductList.get(position);

        //item.productImageView.setImageDrawable(curProduct.productImage);

        Picasso.with(mContext).load(curProduct.getImageUrl()).resize(200,200).into(item.productImageView);

        item.productTitle.setText(curProduct.title);

        if(!mShowCheckbox) {
            item.productCheckbox.setVisibility(View.GONE);
        } else {
            if(curProduct.selected == true)
                item.productCheckbox.setChecked(true);
            else
                item.productCheckbox.setChecked(false);
        }


        return convertView;
    }

    public void swapList(List<Product> mProductList) {
        if (mProductList!=null){
            this.mProductList=mProductList;
            notifyDataSetChanged();
        }

    }


    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        CheckBox productCheckbox;
    }

}
