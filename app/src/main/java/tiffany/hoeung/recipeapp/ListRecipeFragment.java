package tiffany.hoeung.recipeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListRecipeFragment extends Fragment implements RecyclerAdapter.OnNoteListener {
    private NavController navController;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ArrayList<Recipe> favoritesList = new ArrayList<>();
    private RecyclerAdapter adapterRV;
    private RecyclerAdapter favoritesAdapterRV;
    private RecyclerView recipeRV;
    private int screen = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get layout manager (aka, what format RV should take)
        layoutManager = new GridLayoutManager(this.getActivity(), 2);
        recipeRV.setLayoutManager(layoutManager);
        // adds recipes to recipeList arraylist
        if (getArguments() == null) {
            createInitialRecipeList();
        } else {
            recipeList = (ArrayList<Recipe>) getArguments().getSerializable("recipes");
            favoritesList = (ArrayList<Recipe>) getArguments().getSerializable("favorites");
            sortLists();
            screen = getArguments().getInt("screen");
        }
        //create a new recycler view adapter
        adapterRV = new RecyclerAdapter(recipeList, this, this);
        favoritesAdapterRV = new RecyclerAdapter(favoritesList, this, this);
        // set the recycler view's adapter
        if(screen == 0)
            recipeRV.setAdapter(adapterRV);
        else
            recipeRV.setAdapter(favoritesAdapterRV);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get favorites button
        // Button favButton =

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_recipe, container, false);

        recipeRV = view.findViewById(R.id.recipeRV);

        NavHostFragment navHostFragment = (NavHostFragment) this.getActivity()
                .getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null)
            navController = navHostFragment.getNavController();
        // Favorites button will only display entries in the favoritesList
        view.findViewById(R.id.button_favorites).setOnClickListener(view1 -> {
            System.out.println("Favorites has " + favoritesList.size() + " recipes in it");
            recipeRV.setAdapter(favoritesAdapterRV);
            screen = 1;
        });

        view.findViewById(R.id.button_home).setOnClickListener(view1 -> {
            recipeRV.setAdapter(adapterRV);
            screen = 0;
        });

        view.findViewById(R.id.button_new_recipe).setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("recipes", recipeList);
            bundle.putSerializable("favorites", favoritesList);

            navController.navigate(R.id.list_to_new, bundle);
        });

        return view;
    }

    @Override
    public void onNoteClick(int position) {
        //Toast.makeText(this.getActivity(), "Position " + position + " pressed\n" + recipeList.get(position).recipeName, Toast.LENGTH_SHORT).show();
        // this is where we switch to the recipe screen
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putInt("screen", screen);
        bundle.putSerializable("recipes", recipeList);
        bundle.putSerializable("favorites", favoritesList);

        navController.navigate(R.id.list_to_info, bundle);
    }
    public void createInitialRecipeList() {
        System.out.println("Creating initial recipes!");

        RecipeArchive recipeArchive = new RecipeArchive(this);
        recipeList = recipeArchive.createInitialRecipes();
        sortLists();
    }

    public void sortLists() {
        Collections.sort(recipeList, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe r1, Recipe r2) {
                String r1Name = r1.recipeName;
                String r2Name = r2.recipeName;

                return r1Name.compareTo(r2Name);
            }
        });

        Collections.sort(favoritesList, new Comparator<Recipe>() {
            @Override
            public int compare(Recipe r1, Recipe r2) {
                String r1Name = r1.recipeName;
                String r2Name = r2.recipeName;

                return r1Name.compareTo(r2Name);
            }
        });
    }
}