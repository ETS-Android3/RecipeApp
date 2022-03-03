package tiffany.hoeung.recipeapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
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

public class ListRecipeFragment extends Fragment implements RecyclerAdapter.OnNoteListener {

    private NavController navController;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private RecyclerAdapter adapterRV;
    private RecyclerView recipeRV;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //get layout manager (aka, what format RV should take)
        layoutManager = new GridLayoutManager(this.getActivity(), 2);
        recipeRV.setLayoutManager(layoutManager);
        // adds recipes to recipeList arraylist
        createInitialRecipeList();
        //create a new recycler view adapter
        adapterRV = new RecyclerAdapter(recipeList, this);
        // set the recycler view's adapter
        recipeRV.setAdapter(adapterRV);
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

        NavHostFragment navHostFragment =
                (NavHostFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        return view;
    }

    @Override
    public void onNoteClick(int position) {
        Toast.makeText(this.getActivity(), "Position " + position + " pressed\n" + recipeList.get(position).recipeName, Toast.LENGTH_SHORT).show();
        // this is where we switch to the recipe screen
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putSerializable("recipes", recipeList);

        navController.navigate(R.id.list_to_info, bundle);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void createInitialRecipeList() {
        System.out.println("Creating initial recipes!");

        String[] spaghettiIngredients = {"1 pound lean ground meat",
                "3 tablespoons olive oil",
                "1 cup chopped onion",
                "3 garlic cloves, minced",
                "2 tablespoons tomato paste",
                "1/2 teaspoon dried oregano",
                "Pinch crushed red pepper flakes",
                "1 cup water, broth or dry red wine",
                "1 (28-ounce) can crushed tomatoes" ,
                "Salt and fresh ground black pepper",
                "Handful fresh basil leaves",
                "12 ounces dried spaghetti ",
                "1/2 cup shredded parmesan cheese"};

        String[] spaghettiInstructions = {"Heat the oil in a large pot over medium-high heat (we use a Dutch oven). Add the meat and cook until browned, about 8 minutes. As the meat cooks, use a wooden spoon to break it up into smaller crumbles.",
                "Add the onions and cook, stirring every once and a while, until softened, about 5 minutes.",
                "Stir in the garlic, tomato paste, oregano, and red pepper flakes and cook, stirring continuously for about 1 minute.",
                "Pour in the water and use a wooden spoon to scrape up any bits of meat or onion stuck to the bottom of the pot. Stir in the tomatoes, 3/4 teaspoon of salt, and a generous pinch of black pepper. Bring the sauce to a low simmer. Cook, uncovered, at a low simmer for 25 minutes. As it cooks, stir and taste the sauce a few times so you can adjust the seasoning accordingly (see notes for suggestions).",
                "About 15 minutes before the sauce finishes cooking, bring a large pot of salted water to the boil, and then cook pasta according to package directions, but check for doneness a minute or two before the suggested cooking time.",
                "Take the sauce off of the heat, and then stir in the basil. Toss in the cooked pasta, and then leave for a minute so that the pasta absorbs some of the sauce. Toss again, and then serve with parmesan sprinkled on top."};

        recipeList.add(new Recipe("Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti),
                getContext().getDrawable(R.drawable.spaghetti_2), spaghettiIngredients, spaghettiInstructions));

        recipeList.add(new Recipe("Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe("Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe("Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe("Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));
        recipeList.add(new Recipe("Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti)));
        recipeList.add(new Recipe("Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe("Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe("Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe("Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));
        recipeList.add(new Recipe("Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti)));
        recipeList.add(new Recipe("Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe("Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe("Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe("Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));
    }
}