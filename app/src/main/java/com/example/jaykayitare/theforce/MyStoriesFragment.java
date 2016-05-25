package com.example.jaykayitare.theforce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by imaya on 5/24/16.
 */
public class MyStoriesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private LinearLayoutManager lLayout;
    String API = "http://52.37.33.186/";

    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<ItemObject> allItems = new ArrayList<ItemObject>(); //holds data read from the api

    /*Reads data from an API*/
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API).build();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_stories_layout,null);

        ButterKnife.bind(this);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        lLayout = new LinearLayoutManager(MyStoriesFragment.this);
        List<ItemObject> rowListItem = getAllItemList();

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

        Toast.makeText(getApplicationContext(), "Swipe down to refresh", Toast.LENGTH_LONG).show();

        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
    }
    @Override
    public void onRefresh() {
        StoryApi story = restAdapter.create(StoryApi.class);
        story.getStory(new Callback<All>() {
            @Override
            public void failure(RetrofitError error) {
                mSwipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getApplicationContext(), "Failed to load", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void success(All all, Response response) {
                mSwipeRefreshLayout.setRefreshing(false);
                lLayout = new LinearLayoutManager(MainActivity.this);
                List<ItemObject> rowListItem = getAllItemList();

                RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
                rView.setLayoutManager(lLayout);

                RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
                rView.setAdapter(rcAdapter);
            }
        });
    }
    public List<ItemObject> getAllItemList(){

        StoryApi story = restAdapter.create(StoryApi.class);
        story.getStory(new Callback<All>() {

            @Override
            public void success(All all, Response response) {

                for (int i = 0; i < all.objects.size(); i++) {
//                    Reads the data into a variable
                    String ti_tle = all.objects.get(i).getTitle();
//                    String pic = R.drawable.canada;
                    String pic = all.objects.get(i).getMedia();
                    String time_stamp = all.objects.get(i).getTimestamp();
                    String loca_tion = all.objects.get(i).getLocation();


//                    Puts the data into another list for cardviews
                    allItems.add(new ItemObject(ti_tle, pic, time_stamp, loca_tion));

//                    allItems.add(new ItemObject(name, num));
                }

            }

            @Override
            public void failure(RetrofitError error) {
                //story_title.setText(error.getMessage());
                Toast.makeText(getApplicationContext(), "Failed to load", Toast.LENGTH_SHORT).show();
            }
        });


        return allItems;
    }
}