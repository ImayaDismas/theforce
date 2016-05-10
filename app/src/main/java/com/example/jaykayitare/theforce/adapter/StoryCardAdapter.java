package com.example.jaykayitare.theforce.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;

/**
 * Created by jaykayitare on 5/10/16.
 */
public class StoryCardAdapter extends CardArrayRecyclerViewAdapter {
    /**
     * Constructor
     *
     * @param context The current context.
     * @param cards   The cards to represent in the ListView.
     */

    TextView title, location, timedate, bits;

    public StoryCardAdapter(Context context, List<Card> cards) {
        super(context, cards);
    }

    public class ViewHolder extends CardArrayRecyclerViewAdapter.CardViewHolder{

        public ViewHolder(View view) {
            super(view);
            title
        }
    }

}
