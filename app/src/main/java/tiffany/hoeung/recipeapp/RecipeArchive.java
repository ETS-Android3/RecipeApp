package tiffany.hoeung.recipeapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RecipeArchive {
    private final ListRecipeFragment listRecipeFragment;
    public ArrayList<Recipe> recipes = new ArrayList<>();

    //Constructor, requiring a reference to the fragment
    public RecipeArchive(ListRecipeFragment fragment) {
        listRecipeFragment = fragment;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public ArrayList<Recipe> createInitialRecipes() {
        /*********EXAMPLE OF HOW TO ADD A RECIPE:*********/
        // Array of String[] for ingredients
        String[] ingredients = {"1 pound lean ground meat",
                "3 tablespoons olive oil",
                "1 cup chopped onion",
                "3 garlic cloves, minced",
                "2 tablespoons tomato paste",
                "1/2 teaspoon dried oregano",
                "Pinch crushed red pepper flakes",
                "1 cup water, broth or dry red wine",
                "1 (28-ounce) can crushed tomatoes",
                "Salt and fresh ground black pepper",
                "Handful fresh basil leaves",
                "12 ounces dried spaghetti ",
                "1/2 cup shredded parmesan cheese"};

        // Array of String[] for instructions
        String[] instructions = {"Heat the oil in a large pot over medium-high heat (we use a Dutch oven). Add the meat and cook until browned, about 8 minutes. As the meat cooks, use a wooden spoon to break it up into smaller crumbles.",
                "Add the onions and cook, stirring every once and a while, until softened, about 5 minutes.",
                "Stir in the garlic, tomato paste, oregano, and red pepper flakes and cook, stirring continuously for about 1 minute.",
                "Pour in the water and use a wooden spoon to scrape up any bits of meat or onion stuck to the bottom of the pot. Stir in the tomatoes, 3/4 teaspoon of salt, and a generous pinch of black pepper. Bring the sauce to a low simmer. Cook, uncovered, at a low simmer for 25 minutes. As it cooks, stir and taste the sauce a few times so you can adjust the seasoning accordingly (see notes for suggestions).",
                "About 15 minutes before the sauce finishes cooking, bring a large pot of salted water to the boil, and then cook pasta according to package directions, but check for doneness a minute or two before the suggested cooking time.",
                "Take the sauce off of the heat, and then stir in the basil. Toss in the cooked pasta, and then leave for a minute so that the pasta absorbs some of the sauce. Toss again, and then serve with parmesan sprinkled on top."};

        Uri imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.spaghetti_2);

        // listRecipeFragment.getContext() allows us to access the assets folder.
        // .getDrawable gets image. The second is for the larger recipe screen
        recipes.add(new Recipe(recipes.size()+1,"Spaghetti and meatballs",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Cottage Pie
        ingredients = new String[] {"1 pound lean ground beef",
                "1 onion, diced",
                "3 carrots, diced",
                "2 tablespoons all-purpose flour",
                "½ teaspoon ground cinnamon",
                "1 tablespoon Italian seasoning",
                "2 tablespoons chopped fresh parsley",
                "1 ½ cups beef broth",
                "1 tablespoon tomato paste",
                "salt and pepper to taste",
                "4 potatoes, peeled and diced",
                "¼ cup butter, softened",
                "1 cup milk",
                "salt and pepper to taste",
                "¼ pound shredded Cheddar cheese"};
        instructions = new String[]{"Preheat oven to 400 degrees F (200 degrees C).",
                "To Make Meat Filling: Place a large skillet over medium heat. Crumble in ground beef and saute 1 minute. Add onion and carrot, then continue to saute until meat is no longer pink and onion begins to brown, about 5 minutes. Mix in flour, cinnamon, mixed herbs, and parsley.",
                "In a small bowl, combine beef broth and tomato paste. Mix together, then add to beef mixture. Add salt and pepper to taste. Lower heat and simmer mixture for 15 minutes, stirring occasionally, until almost all of liquid has been absorbed. Spoon mixture into a 9 inch pie plate.",
                "To Make Potato Topping: Place diced potatoes in a medium saucepan. Cover with water and place over high heat. Allow to come to a boil. Boil for 15 minutes, or until potatoes are tender. Drain.",
                "Mash potatoes until smooth, then add butter or margarine, followed by milk. Whip until fluffy. Add salt and pepper to taste. Spread potatoes over beef filling. Sprinkle with grated Cheddar cheese.",
                "Bake in preheated oven for 25 minutes, until top is browned and cheese is bubbly."};

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.cottage_pie2);

        recipes.add(new Recipe(recipes.size()+1,"Cottage Pie",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        System.out.println("cottage_pie: " + R.drawable.cottage_pie);

        // Crab Rangoon
        ingredients = new String[] {"1 8 oz Kraft Philadelphia Regular Cream Cheese, room temperature",
                "2 oz crab meat or 2 sticks imitation crab meat, finely diced",
                "1 tablespoon powdered sugar",
                "1 pinch salt",
                "20 wonton wrappers",
                "oil, for deep frying"};
        instructions = new String[] {"Mix all the cream cheese, crab meat, sugar, and salt in a bowl. Stir to blend well. Place about 1 tablespoon of the cream cheese filling in the middle of a wonton wrapper. Dab some water on the outer edges of the wonton wrapper and fold the two ends of the wrapper together. Fold the other two ends to make a tiny parcel pictured below. Pinch to seal tight and make sure that there is no leakage.",
                "Heat up a pot of oil for deep-frying and fry the crab rangoon until golden brown. Dish out with a strainer or slotted spoon, draining the excess oil by laying the crab rangoon on a dish lined with paper towels. Let the crab rangoon cools down a bit before serving them with sweet and sour sauce."   };

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.crab_rangoon2);

        recipes.add(new Recipe(recipes.size()+1,"Crab Rangoon",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Zaru Soba
        ingredients = new String[] {"Salt",
                "1 cup dashi or chicken stock",
                "¼ cup soy sauce",
                "2 tablespoons mirin or 1 tablespoon honey mixed with 1 tablespoon water",
                "8 ounces soba noodles",
                "Finely grated or minced ginger",
                "Minced scallions or toasted sesame seeds for garnish"};
        instructions = new String[] {"Bring a large pot of water to a boil, and salt it. Cook noodles until tender but not mushy. Drain, and quickly rinse under cold running water until cold. Drain well.",
                "Combine dashi or stock, soy sauce and mirin. Taste, and add a little more soy if the flavor is not strong enough. Serve noodles with garnishes, with sauce on side for dipping (or spooning over)."};

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.zaru_soba2);

        recipes.add(new Recipe(recipes.size()+1,"Zaru Soba",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Chicken Enchiladas
        ingredients = new String[] {"4 cups cooked, shredded chicken",
                "2 tbsp taco seasoning",
                "3 cups mozzarella, shredded",
                "3 cups monterey jack, shredded",
                "1 cup sour cream",
                "10 10” corn tortillas",
                "1 28 oz can green enchilada sauce"};
        instructions = new String[] {"Preheat oven to 375°F.",
                "In a large bowl combine shredded chicken, 2 cups of the mozzarella and 2 cups of the Monterey jack cheese, sour cream and taco seasoning. Mix until well incorporated.",
                "Wrap tortillas in a damp paper or tea towel and microwaves for 1 minute.",
                "In a skillet, warm the enchilada sauce. Working with one tortilla at a time, dip it in the enchilada sauce until lightly coated. Scoop ⅓ cup of the enchilada filling into the tortilla and roll tightly. arrange (see side down) in a 9X13 baking dish and repeat with remaining tortillas.",
                "Pour remaining enchilada sauce over the prepared enchiladas followed by the remaining cheese.",
                "Bake for 25 minutes, until cheese is bubbling."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.chicken_enchiladas2);
        recipes.add(new Recipe(recipes.size()+1,"Chicken Enchiladas",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        ingredients = new String[] {"1 1/2 pounds skirt steak, cut into 4-inch-long pieces, then cut against the grain into 1/4-inch-thick slices",
                 "Salt and freshly ground pepper",
                 "1/4 cup low-sodium soy sauce",
                 "1 serrano chile pepper, seeded and finely chopped",
                 "2 teaspoons sugar",
                 "2 tablespoons freshly squeezed lime juice (1 to 2 limes)",
                 "2 tablespoons olive oil",
                 "2 cloves garlic, grated",
                 "1 bunch scallions, thinly sliced",
                 "6 ounces fresh mushrooms, sliced",
                 "1/4 pound snow peas or green beans",
                 "1 12-ounce can baby corn, drained",
                 "1 red bell pepper, thinly sliced (Optional)"};

        instructions = new String[] {"Season the steak with salt and pepper. In a medium bowl, whisk together the soy sauce, chile pepper, sugar and lime juice until the sugar is dissolved. Add the beef, toss to coat and set aside.",
                "In a large skillet over medium-high heat, heat the oil until shimmering, about 1 minute. Add the beef and cook, stirring, until cooked through, 3 to 5 minutes.",
                "Remove the beef from the skillet and set aside. Allow the liquid in the pan to reduce until thickened, about 4 minutes. Add the garlic and scallions and cook 1 minute more. " +
                "Add the mushrooms and cook for 2 to 3 minutes more. Add the snow peas, baby corn and bell pepper and continue cooking until all the vegetables are crisp-tender, about 2 minutes. Return the beef to the skillet and toss to combine."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.beef_stirfry2);
        recipes.add(new Recipe(recipes.size()+1,"Beef Stir-Fry",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        return recipes;
    }

    /**
     * get uri to drawable or any other resource type if u wish
     * @param context - context
     * @param drawableId - drawable res id
     * @return - uri
     */
    public static final Uri getUriToDrawable(@NonNull Context context,
                                             @AnyRes int drawableId) {
        Uri imageUri = Uri.parse(context.getContentResolver().SCHEME_ANDROID_RESOURCE
                + "://" + context.getResources().getResourcePackageName(drawableId)
                + '/' + context.getResources().getResourceTypeName(drawableId)
                + '/' + context.getResources().getResourceEntryName(drawableId) );
        return imageUri;
    }
}
