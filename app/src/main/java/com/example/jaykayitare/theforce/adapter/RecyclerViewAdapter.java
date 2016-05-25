package com.example.jaykayitare.theforce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaykayitare.theforce.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by imaya on 5/25/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.storyTitle.setText(itemList.get(position).get_title());//setImageBitmap(itemList.get(position).get_media());
        //holder.storyMedia.setImageDrawable(Drawable.createFromPath(itemList.get(position).get_media()));
        Picasso.with(context)
                .load(itemList.get(position).get_media())
                .placeholder(R.drawable.placeholder)
                .into(holder.storyMedia);
        holder.storyDate.setText(itemList.get(position).get_timestamp());
        holder.storyLocation.setText(itemList.get(position).get_location());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}