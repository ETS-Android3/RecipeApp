package tiffany.hoeung.recipeapp;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Recipe implements Serializable {
    public String recipeName;
    /*public Drawable recipeImageCard;
    public Drawable recipeImageInfo;*/
    public int recipeImageCard;
    public int recipeImageInfo;
    public String[] ingredients;
    public String[] instructions;

    /*public Recipe(String recipeName, Drawable recipeImageCard, Drawable recipeImageInfo,
                  String[] ingredients, String[] instructions) {
        this.recipeName = recipeName;
        this.recipeImageCard = recipeImageCard;
        this.recipeImageInfo = recipeImageInfo;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }*/

    public Recipe(String recipeName, int recipeImageCard, int recipeImageInfo,
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

    public int getRecipeImageCard() {
        return recipeImageCard;
    }

    public int getRecipeImageInfo() {
        return recipeImageInfo;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public String[] getInstructions() {
        return instructions;
    }


}
