package com.hfad.myvolley;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DevelopersAdapter extends RecyclerView.Adapter<DevelopersAdapter.ViewHolder> {
    //declare developerList as a private member variable
    private List<DeveloperList> developerList;
    //set context
    private Context myContext;

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";
    //implement constructor
    public DevelopersAdapter(List<DeveloperList> developerList,Context myContext){
        this.developerList=developerList;
        this.myContext=myContext;
    }
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public DevelopersAdapter.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.developers_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull DevelopersAdapter.ViewHolder holder, int position) {
        //create a variable that gets the current instance of the developer in the list
        final DeveloperList currentDeveloper = developerList.get(position);
        //populate the View objects with data
        holder.login.setText(currentDeveloper.getLogin());
        holder.html_url.setText((currentDeveloper.getHtml_url()));
        //Use the library Picasso to load images without crashing. Loading images is resource intensive
        Picasso.with(myContext).load(currentDeveloper.getAvatar_url()).into(holder.avatar_url);
        //Set onclick listener to handle click events
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an instance of the developer list
                DeveloperList developerList1 = developerList.get(position);
                //create an intent and specify the target class
                Intent skipIntent = new Intent(v.getContext(),ProfileActivity.class);
                //use intent EXTRA to pass data from main activity to profileActivity
                skipIntent.putExtra(KEY_NAME, developerList1.getLogin());
                skipIntent.putExtra(KEY_URL,developerList1.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE,developerList1.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return developerList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        //Define the View objects
        public TextView login;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            //initialize the view objects
            login=itemView.findViewById(R.id.username);
            avatar_url=itemView.findViewById(R.id.imageView);
            html_url=itemView.findViewById(R.id.string_url);
            linearLayout=itemView.findViewById(R.id.linearLayout);

        }

    }
}
