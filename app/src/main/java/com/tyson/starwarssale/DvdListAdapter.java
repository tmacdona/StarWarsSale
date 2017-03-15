package com.tyson.starwarssale;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Tyson on 3/15/2017.
 *
 * This adapter takes in a list of DvdItem
 */

class DvdListAdapter extends RecyclerView.Adapter<DvdListAdapter.DvdItemViewHolder> {

    private ArrayList<DvdItem> mList;
    private AssetManager mAssetManager;

    // define the view holder, complete with click listeners
    class DvdItemViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView price;
        ImageView image;

        DvdItemViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }


    // Constructor for the adapter
    DvdListAdapter(Context context, ArrayList<DvdItem> list){
        mAssetManager = context.getAssets();
        mList = list;
    }


    @Override
    public DvdItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dvd_list_item , parent, false);

        return new DvdItemViewHolder(view);
    }


    // bind data to the view holder
    @Override
    public void onBindViewHolder(DvdItemViewHolder holder, final int position) {

        holder.title.setText(mList.get(position).title);
        holder.price.setText(String.format(Locale.US, "$%0.2f", mList.get(position).price));

        // load image
        try {
            // get input stream
            InputStream ims = mAssetManager.open("poster.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            holder.image.setImageDrawable(d);
        }
        catch(IOException ex) {
            Log.e("Item Adapter", "Could not load image from assets");
        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
