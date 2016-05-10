package com.example.jaykayitare.theforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

public class MyStories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_stories);

        ArrayList<Card> cards = new ArrayList<>();


        Card card = new Card(getApplicationContext());
        CardHeader header = new CardHeader(getApplicationContext());
        card.addCardHeader(header);

//        MaterialLargeImageCard card = MaterialLargeImageCard.with(getApplicationContext())
//                .setTextOverImage("Awesome Collaborative Story Title")
//                .useDrawableId(R.drawable.splash_bg)
//                .build();

        cards.add(card);
        cards.add(card);
        cards.add(card);
        cards.add(card);


        CardArrayRecyclerViewAdapter cardArrayRecyclerViewAdapter = new CardArrayRecyclerViewAdapter(getApplicationContext(), cards);

        CardRecyclerView cardRecyclerView = (CardRecyclerView)findViewById(R.id.story_list);
        cardRecyclerView.setHasFixedSize(false);
        cardRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        if (cardRecyclerView != null)
            cardRecyclerView.setAdapter(cardArrayRecyclerViewAdapter);
    }
}
