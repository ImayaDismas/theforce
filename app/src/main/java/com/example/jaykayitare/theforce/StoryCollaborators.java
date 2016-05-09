package com.example.jaykayitare.theforce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jaykayitare.theforce.adapter.CollaboratorAdapter;
import com.example.jaykayitare.theforce.model.Collaborator;

import java.util.ArrayList;
import java.util.List;

public class StoryCollaborators extends AppCompatActivity {

    private List<Collaborator> collaboratorList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CollaboratorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_collaborators);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);

        mAdapter = new CollaboratorAdapter(collaboratorList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareData();
    }

    private void prepareData() {
        Collaborator collaborator = new Collaborator("Jay Kayitare","10 minutes ago");
        collaboratorList.add(collaborator);

        collaborator = new Collaborator("Imaya Dismas","15 minutes ago");
        collaboratorList.add(collaborator);
    }
}
