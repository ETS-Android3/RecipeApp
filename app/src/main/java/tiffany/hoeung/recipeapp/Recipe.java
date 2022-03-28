package tiffany.hoeung.recipeapp;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    public static ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    public static ArrayList<Recipe> favoritesArrayList = new ArrayList<>();

    public int id;
    public String recipeName;
    public int recipeImageCard;
    public int recipeImageInfo;
    public String[] ingredients;
    public String[] instructions;

    public int isFavorited = 0;
    public int isDeleted = 0;

    /*public Recipe(String recipeName, Drawable recipeImageCard, Drawable recipeImageInfo,
                  String[] ingredients, String[] instructions) {
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
        this.recipeImageInfo = recipeImageInfo;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }*/

    public Recipe(int id, String recipeName, int recipeImageCard, int recipeImageInfo,
                  String[] ingredients, String[] instructions) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
        this.recipeImageInfo = recipeImageInfo;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getId() { return id; }

    public String getRecipeName() {
        return recipeName;
    }

    public int getRecipeImageCard() {
        return recipeImageCard;
    }

    public int getRecipeImageInfo() {
        return recipeImageInfo;
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


}
