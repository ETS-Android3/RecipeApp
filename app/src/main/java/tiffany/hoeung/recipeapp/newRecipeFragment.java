package tiffany.hoeung.recipeapp;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class newRecipeFragment extends Fragment {
    private NavController navController;

    private EditText recipeName;
    private EditText recipeIngredients;
    private EditText recipeInstructions;
    private ImageView imageView;
    private Uri imageUri;
    private byte[] imageByte;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_recipe, container, false);

        // get the components from the xml file
        getComponenets(view);

        // For navigation
        NavHostFragment navHostFragment =
                (NavHostFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }

        // Make the buttons do stuff
        setButtons(view);

        return view;
    }

    private void setButtons(View view) {
        // 100x100 Upload Image Button:
        // Run second after image is selected:
        ActivityResultLauncher<Intent> galleryResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        System.out.println("Processing data");
                        Intent data = result.getData();
                        imageUri = Objects.requireNonNull(data).getData();
                        if(imageUri != null)
                            imageView.setImageURI(imageUri);
                        Bitmap imageBitmap;
                        try {
                            imageBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), imageUri);
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            imageByte = stream.toByteArray();
                            imageBitmap.recycle();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        // This gets run first:
        view.findViewById(R.id.recipe_imageBtn100).setOnClickListener(view1 -> {
            System.out.println("Opening gallery!");
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            gallery.setType("image/*");
            galleryResultLauncher.launch(gallery);
        });

        // Cancel Button:
        view.findViewById(R.id.button_cancel).setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putInt("screen", 0);

            navController.navigate(R.id.new_to_list, bundle);
        });

        // Home Button:
        view.findViewById(R.id.button_home).setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putInt("screen", 0);

            navController.navigate(R.id.new_to_list, bundle);
        });

        // Favorites Button:
        view.findViewById(R.id.button_favorites).setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putInt("screen", 1);

            navController.navigate(R.id.new_to_list, bundle);
        });

        // Save Button:
        view.findViewById(R.id.button_add).setOnClickListener(view1 -> {
            // Save recipe to recipeList
            if(saveNewRecipe() == 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("screen", 0);

                navController.navigate(R.id.new_to_list, bundle);
            }
        });
    }

    private void getComponenets(View view) {
        recipeName = view.findViewById(R.id.new_recipe_name);
        recipeIngredients = view.findViewById(R.id.new_recipe_ingredients);
        recipeInstructions =  view.findViewById(R.id.new_recipe_instructions);
        imageView = view.findViewById(R.id.recipe_image100);
    }

    private int saveNewRecipe() {
        // check if recipeName has text in it
        if(recipeName.getText().toString().compareTo("") != 0) {
            SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this.getActivity());
            String[] ingredients = recipeIngredients.getText().toString().split("\n");
            String[] instructions = recipeInstructions.getText().toString().split("\n");
            Recipe newRecipe = new Recipe(Recipe.recipeArrayList.size(), recipeName.getText().toString(),
                    imageByte, ingredients, instructions);

            Recipe.recipeArrayList.add(newRecipe);
            sqLiteManager.addRecipeToDatabase(newRecipe);
            return 0;
        } else {
            Toast.makeText(this.getActivity(), "Cannot add recipe.\nMissing recipe name.", Toast.LENGTH_SHORT).show();
            return 1;
        }
    }

}