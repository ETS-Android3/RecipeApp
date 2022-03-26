package tiffany.hoeung.recipeapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class NewRecipeFragment extends Fragment {
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private ArrayList<Recipe> favoritesList = new ArrayList<>();
    private NavController navController;

    private EditText recipeName;
    private EditText recipeIngredients;
    private EditText recipeInstructions;
    private ImageView image100, image450;
    private Uri imageUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_recipe, container, false);

        // get the components from the xml file
        recipeName = view.findViewById(R.id.new_recipe_name);
        recipeIngredients = view.findViewById(R.id.new_recipe_ingredients);
        recipeInstructions =  view.findViewById(R.id.new_recipe_instructions);

        // saving the arrays to modify if needed
        recipeList = (ArrayList<Recipe>) getArguments().getSerializable("recipes");
        favoritesList = (ArrayList<Recipe>) getArguments().getSerializable("favorites");

        // For navigation
        NavHostFragment navHostFragment =
                (NavHostFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Make the buttons do stuff

        // 100x100 Upload Image Button:
        ActivityResultLauncher<Intent> galleryResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        System.out.println("Processing data");
                        Intent data = result.getData();
                        imageUri = Objects.requireNonNull(data).getData();
                        image100.setImageURI(imageUri);
                    }
                });
        view.findViewById(R.id.recipe_imageBtn100).setOnClickListener(view1 -> {
            System.out.println("Opening gallery!");
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            gallery.setType("image/*");
            galleryResultLauncher.launch(gallery);
        });

        // Cancel Button:
        view.findViewById(R.id.button_cancel).setOnClickListener(view1 -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 0);

                navController.navigate(R.id.new_to_list, bundle);
        });

        // Home Button:
        view.findViewById(R.id.button_home).setOnClickListener(view1 -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 0);

                navController.navigate(R.id.new_to_list, bundle);
        });

        // Favorites Button:
        view.findViewById(R.id.button_favorites).setOnClickListener(view1 -> {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 1);

                navController.navigate(R.id.new_to_list, bundle);
        });

        // Save Button:
        view.findViewById(R.id.button_add).setOnClickListener(view1 -> {
            // Save recipe to recipeList
            if(saveNewRecipe() == 0) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("recipes", recipeList);
                bundle.putSerializable("favorites", favoritesList);
                bundle.putInt("screen", 0);

                navController.navigate(R.id.new_to_list, bundle);
            }
        });

        return view;
    }

    private int saveNewRecipe() {
        // check if recipeName has text in it
        if(recipeName.getText().toString().compareTo("") != 0) {
            String[] ingredients = recipeIngredients.getText().toString().split("\n");
            String[] instructions = recipeIngredients.getText().toString().split("\n");
            recipeList.add(new Recipe(recipeName.getText().toString(), R.drawable.spaghetti,
                    R.drawable.spaghetti_2, ingredients, instructions));
            return 0;
        } else {
            Toast.makeText(this.getActivity(), "Cannot add recipe.\nMissing recipe name.", Toast.LENGTH_SHORT).show();
            return 1;
        }
    }

}