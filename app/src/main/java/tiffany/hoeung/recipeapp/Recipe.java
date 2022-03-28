package tiffany.hoeung.recipeapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Recipe implements Serializable {
    public static ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    public static ArrayList<Recipe> favoritesArrayList = new ArrayList<>();

    public int id;
    public String recipeName;
    public byte[] imageByte;
    /*public int recipeImageCard;
    public int recipeImageInfo;*/
    public String[] ingredients;
    public String[] instructions;

    public int isFavorited = 0;
    public int isDeleted = 0;

    /*public Recipe(int id, String recipeName, int recipeImageCard, int recipeImageInfo,
                  String[] ingredients, String[] instructions) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
        this.recipeImageInfo = recipeImageInfo;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }*/
    public Recipe(int id, String recipeName, byte[] imageByte, String[] ingredients,
                  String[] instructions) {
        this.id = id;
        this.recipeName = recipeName;
        this.imageByte = imageByte;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getId() { return id; }

    public String getRecipeName() {
        return recipeName;
    }

    /*public int getRecipeImageCard() {
        return recipeImageCard;
    }

    public int getRecipeImageInfo() {
        return recipeImageInfo;
    }*/

    public byte[] getImageByte() { return imageByte; }

    public Bitmap getImage() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap imageBitmap = BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length, options);
        return imageBitmap;
    }

    public String getIngredientsString() {
        StringBuilder str = new StringBuilder();
        for (String ingredient : ingredients)
            str.append(ingredient + "\n");
        return str.toString();
    }

    public String getInstructionsString() {
        StringBuilder str = new StringBuilder();
        for (String instruction : instructions)
            str.append(instruction + "\n\n");
        return str.toString();
    }

    public int getIsFavorited() { return isFavorited; }

    public int getIsDeleted() { return isDeleted; }

    public static byte[] convertUriToByteArray(Uri imageUri, Activity activity) {
        Bitmap imageBitmap;
        byte[] imageByte = new byte[0];
        try {
            imageBitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), imageUri);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            imageByte = stream.toByteArray();
            imageBitmap.recycle();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageByte;
    }
}
