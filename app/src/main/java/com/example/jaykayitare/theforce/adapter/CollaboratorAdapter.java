package com.example.jaykayitare.theforce.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jaykayitare.theforce.R;
import com.example.jaykayitare.theforce.model.Collaborator;

import java.util.List;

/**
 * Created by jaykayitare on 5/9/16.
 */
public class CollaboratorAdapter extends RecyclerView.Adapter<CollaboratorAdapter.ViewHolder> {

    private List<Collaborator> collaboratorList;

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username, time;

        public ViewHolder(View itemView) {
            super(itemView);
            username = (TextView)itemView.findViewById(R.id.username);
            time = (TextView)itemView.findViewById(R.id.timeadded);
        }
    }

    public CollaboratorAdapter(List<Collaborator> collaboratorList){
        this.collaboratorList = collaboratorList;
    }

    @Override
    public CollaboratorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.collaborator_row, parent, false);
        return new CollaboratorAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CollaboratorAdapter.ViewHolder holder, int position) {
        Collaborator collaborator = collaboratorList.get(position);
        holder.time.setText(collaborator.getTime());
        holder.username.setText(collaborator.getUsername());
    }

    @Override
    public int getItemCount() {
        return collaboratorList.size();
    }
}
