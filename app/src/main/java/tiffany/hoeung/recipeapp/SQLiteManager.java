package tiffany.hoeung.recipeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class SQLiteManager extends SQLiteOpenHelper {
    private static SQLiteManager sqLiteManager;

    private static final String DATABASE_NAME = "RecipeDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Recipes";
    private static final String COUNTER = "Counter";

    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String IMAGE_FIELD = "image";
    private static final String INGREDIENTS_FIELD = "ingre";
    private static final String INSTRUCTIONS_FIELD = "instr";
    private static final String FAVORITED_FIELD = "fave";
    private static final String DELETED_FIELD = "del";

    public SQLiteManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteManager instanceOfDatabase(Context context) {
        if (sqLiteManager == null)
            sqLiteManager = new SQLiteManager(context);

        return sqLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(TITLE_FIELD)
                .append(" TEXT, ")
                .append(IMAGE_FIELD)
                .append(" BLOB, ")
                .append(INGREDIENTS_FIELD)
                .append(" TEXT, ")
                .append(INSTRUCTIONS_FIELD)
                .append(" TEXT, ")
                .append(FAVORITED_FIELD)
                .append(" INT, ")
                .append(DELETED_FIELD)
                .append(" INT)");

        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addRecipeToDatabase(Recipe recipe) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, recipe.getId());
        contentValues.put(TITLE_FIELD, recipe.getRecipeName());
        contentValues.put(IMAGE_FIELD, recipe.getImageByte());
        contentValues.put(INGREDIENTS_FIELD, recipe.getIngredientsString());
        contentValues.put(INSTRUCTIONS_FIELD, recipe.getInstructionsString());
        contentValues.put(FAVORITED_FIELD, recipe.getIsFavorited());
        contentValues.put(DELETED_FIELD, recipe.getIsDeleted());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void populateRecipeListArray() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null)) {
            if(result.getCount() != 0) {
                while(result.moveToNext() && result.getInt(7) != 1) {
                    int id = result.getInt(1);
                    String title = result.getString(2);
                    byte[] imageByte = result.getBlob(3);
                    String ingredients = result.getString(4);
                    String instructions = result.getString(5);
                    int favorited = result.getInt(6);

                    Recipe recipe = new Recipe(id, title, imageByte, stringToArray(ingredients, "\n"),
                            stringToArray(instructions, "\n\n"));
                    //Add the recipe
                    Recipe.recipeArrayList.add(recipe);
                    // Check if it is favorited
                    if(favorited == 1)
                        Recipe.favoritesArrayList.add(recipe);
                }
            }
        }
    }

    public void updateRecipeInDB(Recipe recipe) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, recipe.getId());
        contentValues.put(TITLE_FIELD, recipe.getRecipeName());
        contentValues.put(INGREDIENTS_FIELD, recipe.getIngredientsString());
        contentValues.put(INSTRUCTIONS_FIELD, recipe.getInstructionsString());
        contentValues.put(IMAGE_FIELD, recipe.getImageByte());
        contentValues.put(FAVORITED_FIELD, recipe.getIsFavorited());
        contentValues.put(DELETED_FIELD, recipe.getIsDeleted());

        sqLiteDatabase.update(TABLE_NAME, contentValues, ID_FIELD + " =? ", new String[]{String.valueOf(recipe.getId())});
    }

    public boolean doesRecipeExistInDB(Recipe recipe) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "Select * from " + TABLE_NAME + " where " + ID_FIELD + " = " + recipe.getId();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    public String[] stringToArray(String toParse, String separator) {
        return toParse.split(separator);
    }
}
