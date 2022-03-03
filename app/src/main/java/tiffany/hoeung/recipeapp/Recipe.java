package tiffany.hoeung.recipeapp;

import android.graphics.drawable.Drawable;

public class Recipe {
    public String recipeName;
    public Drawable recipeImageCard;
    public Drawable recipeImageInfo;
    public String[] ingredients;
    public String[] instructions;

    public Recipe(String recipeName, Drawable recipeImageCard) {
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
    }

    public Recipe(String recipeName, Drawable recipeImageCard, Drawable recipeImageInfo,
                  String[] ingredients, String[] instructions) {
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
        this.recipeImageInfo = recipeImageInfo;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Drawable getRecipeImageCard() {
        return recipeImageCard;
    }

    public Drawable getRecipeImageInfo() {
        return recipeImageInfo;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }


}
