package tiffany.hoeung.recipeapp;

import android.graphics.drawable.Drawable;

public class Recipe {
    public int id;
    public String recipeName;
    public Drawable recipeImage;
    public String[] ingredients;
    public String[] instructions;

    public Recipe(int id, String recipeName, Drawable recipeImage) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
    }

    public Recipe(int id, String recipeName, Drawable recipeImage,
                  String[] ingredients, String[] instructions) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeImage = recipeImage;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public int getId() {
        return id;
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
