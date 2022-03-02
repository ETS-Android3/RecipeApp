package tiffany.hoeung.recipeapp;

import android.graphics.drawable.Drawable;

public class Recipe {
    public String recipeName;
    public Drawable recipeImage;
    public String[] ingredients;
    public String[] instructions;

    public Recipe(String recipeName, Drawable recipeImage) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public Recipe(String recipeName, Drawable recipeImage,
                  String[] ingredients, String[] instructions) {
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Drawable getRecipeImage() {
        return recipeImage;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }


}
