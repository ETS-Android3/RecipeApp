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
        // get the layouts from the xml file
        foodImage = view.findViewById(R.id.info_image);
        titleText = view.findViewById(R.id.info_name);
        ingredientsText = view.findViewById(R.id.info_ingredients);
        instructionsText = view.findViewById(R.id.info_instructions);

        // this is the recipe list + recipe we want to display
        recipeList = (ArrayList<Recipe>) getArguments().getSerializable("recipes");
        position = getArguments().getInt("position");
        screen = getArguments().getInt("screen");
        favoritesList = (ArrayList<Recipe>) getArguments().getSerializable("favorites");
        // Fills out recipe page with appropriate info
        updateLayout();

        // For navigation
        NavHostFragment navHostFragment =
                (NavHostFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        view.findViewById(R.id.button_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 0);

                navController.navigate(R.id.info_to_list, bundle);
            }
        });

        view.findViewById(R.id.button_favorites).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 1);

                navController.navigate(R.id.info_to_list, bundle);
            }
        });

        CheckBox favoriteButton = view.findViewById(R.id.button_isFavorited);
        //Check if the current recipe is already faovrited
        if(favoritesList.contains(recipeList.get(position)))
            favoriteButton.setChecked(true);

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favoriteButton.isChecked()) {
                    favoritesList.add(recipeList.get(position));
                } else {
                    favoritesList.remove(recipeList.get(position));
                }
            }
        });

        return view;
    }

    private void updateLayout() {
        Recipe recipe;
        if(screen == 0)
            recipe = recipeList.get(position);
        else
            recipe = favoritesList.get(position);
        //setting image
        foodImage.setImageDrawable(getContext().getDrawable(recipe.getRecipeImageInfo()));

        // set name of recipe
        titleText.setText(recipe.recipeName);

        // list the ingredients
        String[] ingredients = recipe.getIngredients();
        StringBuilder strBuilder = new StringBuilder();
        if(ingredients != null) {
            for(String str : ingredients)
                strBuilder.append(str + "\n");


            ingredientsText.setText(strBuilder.toString());
        }

        // list the instructions
        String[] instructions = recipe.getInstructions();
        strBuilder = new StringBuilder();
        if(instructions != null) {
            for(String str : instructions)
                strBuilder.append(str + "\n\n");

            instructionsText.setText(strBuilder.toString());
        }
    }
}