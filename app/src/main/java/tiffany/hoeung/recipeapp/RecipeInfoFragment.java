package tiffany.hoeung.recipeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeInfoFragment extends Fragment {

    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private int position;

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

        updateLayout();

        return view;
    }

    private void updateLayout() {
        Recipe recipe = recipeList.get(position);
        //setting image
        if(recipe.getRecipeImageInfo() != null) {
            foodImage.setImageDrawable(recipe.getRecipeImageInfo());
        }

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