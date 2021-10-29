package com.carol.mydroidcafev1;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class PastriesRecipeFragment extends Fragment {
    private RecyclerView pastryRecyclerView;
    private ArrayList<Recipe> pastryRecipeData;
    private RecipeAdapter pastryAdapter;

    public PastriesRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  rootView = inflater.inflate(R.layout.fragment_pastries_recipe, container, false);
        pastryRecyclerView = rootView.findViewById(R.id.recycler_pastry);
        pastryRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        pastryRecipeData = new ArrayList<>();
        pastryAdapter = new RecipeAdapter(pastryRecipeData, getContext());
        pastryRecyclerView.setAdapter(pastryAdapter);
        initializeData();

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull  RecyclerView.ViewHolder viewHolder, @NonNull  RecyclerView.ViewHolder target) {

                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(pastryRecipeData,from,to);
                pastryAdapter.notifyItemMoved(from,to);

                return true;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                pastryRecipeData.remove(viewHolder.getAdapterPosition());
                pastryAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
    });
        helper.attachToRecyclerView(pastryRecyclerView);

        return rootView;
}
    private void initializeData() {
        String[] pastryTitles = getResources().getStringArray(R.array.pastry_titles);
        String[] pastryDescription = getResources().getStringArray(R.array.pastry_description);
        TypedArray pastryImages = getResources().obtainTypedArray(R.array.desserts_images);

        pastryRecipeData.clear();
        for (int i=0;i<pastryTitles.length;i++){
            pastryRecipeData.add(new Recipe(pastryImages.getResourceId(i,0),pastryTitles[i],pastryDescription[i]));
        }
        pastryImages.recycle();
        pastryAdapter.notifyDataSetChanged();
    }}