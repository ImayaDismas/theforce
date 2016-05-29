package com.example.jaykayitare.theforce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jaykayitare.theforce.adapter.All;
import com.example.jaykayitare.theforce.adapter.ItemObject;
import com.example.jaykayitare.theforce.adapter.RecyclerViewAdapter;
import com.example.jaykayitare.theforce.adapter.StoryApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by imaya on 5/29/16.
 */
public class DiscoverActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private LinearLayoutManager lLayout;
    String API = "http://52.37.33.186/";

    @Bind(R.id.swipe_container)
    SwipeRefreshLayout mSwipeRefreshLayout;

    List<ItemObject> allItems = new ArrayList<ItemObject>(); //holds data read from the api

    /*Reads data from an API*/
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(API).build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);
        
        ButterKnife.bind(this);

        mSwipeRefreshLayout.setOnRefreshListener(this);

        lLayout = new LinearLayoutManager(DiscoverActivity.this);
        List<ItemObject> rowListItem = getAllItemList();

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(DiscoverActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

        Toast.makeText(getApplicationContext(), "Swipe down to refresh", Toast.LENGTH_LONG).show();

        mSwipeRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        addListenerOnButton();

    }
    public void addListenerOnButton() {
        ImageButton button;

        button = (ImageButton) findViewById(R.id.imageButton2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                finish();
            }

        });

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
                lLayout = new LinearLayoutManager(DiscoverActivity.this);
                List<ItemObject> rowListItem = getAllItemList();

                RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
                rView.setLayoutManager(lLayout);

                RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(DiscoverActivity.this, rowListItem);
                rView.setAdapter(rcAdapter);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_story, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Toast.makeText(DiscoverActivity.this, "Search", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public List<ItemObject> getAllItemList() {

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