package com.example.jaykayitare.theforce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaykayitare.theforce.R;

/**
 * Created by imaya on 5/25/16.
 */
public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView storyTitle;
    public ImageView storyMedia;
    public TextView storyDate;
    public TextView storyLocation;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        storyTitle = (TextView)itemView.findViewById(R.id.story_title);
        storyMedia = (ImageView)itemView.findViewById(R.id.story_media);
        storyDate = (TextView)itemView.findViewById(R.id.story_date);
        storyLocation = (TextView)itemView.findViewById(R.id.story_location);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Story Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
