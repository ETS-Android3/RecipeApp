package tiffany.hoeung.recipeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeInfoFragment extends Fragment {

    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ArrayList<Recipe> favoritesList = new ArrayList<>();
    private int position;
    private int screen;
    private NavController navController;

    private ImageView foodImage;
    private TextView titleText;
    private TextView ingredientsText;
    private TextView instructionsText;

    public static RecipeInfoFragment newInstance(String param1, String param2) {
        RecipeInfoFragment fragment = new RecipeInfoFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_info, container, false);

        // Get XML Components
        getComponents(view);

        // Get stuff from bundle
        position = getArguments().getInt("position");
        screen = getArguments().getInt("screen");

        // Fills out recipe page with appropriate info using position
        updateLayout();

        // For navigation
        NavHostFragment navHostFragment =
                (NavHostFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        //Set the buttons:
        setButtons(view);

        return view;
    }

    private void setButtons(View view) {

        //Home Button:
        view.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen", 0);

                navController.navigate(R.id.info_to_list, bundle);
            }
        });

        //Favorites home Button:
        view.findViewById(R.id.button_favorites).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen", 1);

                navController.navigate(R.id.info_to_list, bundle);
            }
        });

        // Favorite Button:
        CheckBox favoriteButton = view.findViewById(R.id.button_isFavorited);
        //Check if the current recipe is already faovrited
        if(Recipe.favoritesArrayList.contains(Recipe.recipeArrayList.get(position)))
            favoriteButton.setChecked(true);

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Recipe recipe = Recipe.recipeArrayList.get(position);
                SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(getActivity());

                if(favoriteButton.isChecked()) {
                    recipe.isFavorited = 1;
                    sqLiteManager.updateRecipeInDB(recipe);
                    Recipe.favoritesArrayList.add(Recipe.recipeArrayList.get(position));
                } else {
                    recipe.isFavorited = 0;
                    sqLiteManager.updateRecipeInDB(recipe);
                    Recipe.favoritesArrayList.remove(Recipe.recipeArrayList.get(position));
                }
            }
        });

        // Delete Button:
        view.findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remove the recipe from the list
                Recipe recipe = Recipe.recipeArrayList.get(position);
                // Remove the item from both lists
                Recipe.recipeArrayList.remove(recipe);
                Recipe.favoritesArrayList.remove(recipe);
                // Set the recipe to deleted in the DB
                SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(getActivity());
                recipe.isDeleted = 1;
                sqLiteManager.updateRecipeInDB(recipe);

                Bundle bundle = new Bundle();
                bundle.putInt("screen", 0);
                navController.navigate(R.id.info_to_list, bundle);
            }
        });
    }

    private void getComponents(View view) {
        // get the layouts from the xml file
        foodImage = view.findViewById(R.id.info_image);
        titleText = view.findViewById(R.id.info_name);
        ingredientsText = view.findViewById(R.id.info_ingredients);
        instructionsText = view.findViewById(R.id.info_instructions);
    }

    private void updateLayout() {
        Recipe recipe;
        if(screen == 0)
            recipe = Recipe.recipeArrayList.get(position);
        else
            recipe = Recipe.favoritesArrayList.get(position);
        //setting image
        foodImage.setImageBitmap(recipe.getImage());

        // set name of recipe
        titleText.setText(recipe.recipeName);

        // list the ingredients
        ingredientsText.setText(recipe.getIngredientsString());

        // list the instructions
        instructionsText.setText(recipe.getInstructionsString());
    }


}