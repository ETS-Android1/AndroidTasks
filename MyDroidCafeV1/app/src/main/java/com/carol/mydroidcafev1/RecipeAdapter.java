package com.carol.mydroidcafev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeData;
    private Context myContext;

    RecipeAdapter (ArrayList<Recipe> mRecipeData,Context context){
        this.myContext=context;
        this.recipeData=mRecipeData;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item, parent, false)) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {

        Recipe currentRecipe = recipeData.get(position);
        holder.bindTo(currentRecipe);

    }

    @Override
    public int getItemCount() {

        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipeDescription = itemView.findViewById(R.id.recipe_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if (dessertPosition == 0){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else if (dessertPosition==1){
                        Intent froyoIntent = new Intent(myContext,FroyoActivity.class);
                        froyoIntent.putExtra("fTitle",currentDessert.getRecipeTitle());
                        froyoIntent.putExtra("fImage",currentDessert.getRecipeImage());
                        froyoIntent.putExtra("fDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(froyoIntent);
                      
                    }else if (dessertPosition == 2){
                        Intent iceIntent = new Intent(myContext,IceActivity.class);
                        iceIntent.putExtra("iTitle",currentDessert.getRecipeTitle());
                        iceIntent.putExtra("iImage",currentDessert.getRecipeImage());
                        iceIntent.putExtra("iDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(iceIntent);
                    }else {
                        Toast.makeText(myContext,"Create an activity for the dessert",Toast.LENGTH_SHORT).show();
                    }

                    int pastryPosition = getAdapterPosition();
                    Recipe currentPastry = recipeData.get(pastryPosition);
                    if (pastryPosition == 0){
                        Intent pastry1Intent = new Intent(myContext,Pastry1Activity.class);
                        pastry1Intent.putExtra("p1Title",currentPastry.getRecipeTitle());
                        pastry1Intent.putExtra("dImage",currentPastry.getRecipeImage());
                        pastry1Intent.putExtra("p1Description", currentDessert.getRecipeDescription());
                        myContext.startActivity(pastry1Intent);
                    }else if (pastryPosition==1){
                        Intent pastry2Intent = new Intent(myContext,Pastry2Activity.class);
                        pastry2Intent.putExtra("p2Title",currentPastry.getRecipeTitle());
                        pastry2Intent.putExtra("fImage",currentPastry.getRecipeImage());
                        pastry2Intent.putExtra("p2Description", currentPastry.getRecipeDescription());
                        myContext.startActivity(pastry2Intent);

                    }else if (pastryPosition == 2){
                        Intent pastry3Intent = new Intent(myContext,Pastry3Activity.class);
                        pastry3Intent.putExtra("p3Title",currentPastry.getRecipeTitle());
                        pastry3Intent.putExtra("iImage",currentPastry.getRecipeImage());
                        pastry3Intent.putExtra("p3Description", currentPastry.getRecipeDescription());
                        myContext.startActivity(pastry3Intent);
                    }else {
                        Toast.makeText(myContext,"Create an activity for the dessert",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bindTo(Recipe currentRecipe) {
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
