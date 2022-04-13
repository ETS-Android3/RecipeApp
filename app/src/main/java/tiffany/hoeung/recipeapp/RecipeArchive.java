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

        // Beef Stir Fry
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

        // Chocolate Chip Cookie
        ingredients = new String[] {"1 cup Butter or margarine, softened",
                "3/4 cup Sugar",
                "3/4 cup Brown Sugar",
                "2 Eggs",
                "2 teaspoons Vanilla",
                "2 1/4 cups Flour",
                "1 teaspoon Baking Soda",
                "1/2 teaspoon Salt",
                "1 cup Walnuts or Pecans (optional)",
                "2 cups Chocolate chips"};

        instructions = new String[] {"Heat oven to 375ºF.",
                "Stir flour with baking soda and salt; set aside.",
                "In large mixing bowl, beat butter with sugar, and brown sugar at medium speed until creamy and lightened in color.",
                "Add eggs and vanilla, one at a time. Mix on low speed until incorporated.",
                "Gradually blend dry mixture into creamed mixture. Stir in nuts and chocolate chips.",
                "Drop by tablespoon onto ungreased cookie sheets.",
                "Bake for 9 to 11 minutes or until chocolate chip cookies are golden brown."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.chocchipcookie);
        recipes.add(new Recipe(recipes.size()+1,"Chocolate Chip Cookies",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Blueberries Muffin
        ingredients = new String[] {"1/2 cup Butter",
                "1 1/4 cup Sugar",
                "2 Eggs",
                "2 cups Flour",
                "2 teaspoons Baking Powder",
                "1/2 teaspoon Salt",
                "1/4 cup Milk",
                "2 1/2 cups Blueberries",
                "1 cup Walnuts or Pecans (optional)",
                "2 cups Chocolate chips"};

        instructions = new String[] {"Preheat oven to 375 degrees F (190 degrees C). Grease and flour muffin pans or use paper liners.",
                "In a large bowl, cream butter and 1 1/4 cup sugar until light and fluffy. Add eggs one at a time and mix in.",
                "Mix flour, baking powder and salt. Add flour mixture, alternating with milk. Mash 1/2 cup berries and stir into batter. Fold in remaining berries.",
                "Fill muffin cups. Bake at 375 degrees F (190 degrees C) for 30 minutes. Remove from oven and wait 20 minutes to remove from pans."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.bluemuffin);
        recipes.add(new Recipe(recipes.size()+1,"Blueberry Muffins",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Popover
        ingredients = new String[] {
                "3 Eggs",
                "1 1/2 cups Flour",
                "3/4 teaspoon Salt",
                "1 1/2 cups Milk"};

        instructions = new String[] {"Preheat oven to 450°F, and prepare popover pan with butter or cooking spray.",
                "In a large bowl, mix together all ingredients",
                "Pour batter into pan.",
                "Bake at 450°F for 20 mins, and then at 350°F for 20 mins, then done."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.popover);
        recipes.add(new Recipe(recipes.size()+1,"Popovers",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Waffles
        ingredients = new String[] {
                "2 cups Milk",
                "1 stick Unsalted Butter",
                "2 1/2 cups Flour",
                "1 1/2 teaspoons Yeast",
                "2 tablespoons Sugar",
                "1 teaspoon Salt",
                "2 Eggs",
                "1 teaspoon Vanilla"};

        instructions = new String[] {"Put the milk and butter in a small saucepan set over medium-low heat.",
                "Once butter has melted remove and cool until just warm.",
                "While the milk and butter are heating, whisk the dry ingredients together in a large mixing bowl.",
                "Gradually add the warm milk/butter mixture and whisk until smooth.",
                "Add the eggs and vanilla and whisk until combined.",
                "Cover with plastic and refrigerate at least 12 hours and up to 24 hours.",
                "Preheat waffle iron to desired temp.",
                "Whisk batter to combine again (batter will deflate).",
                "Pour 1 cup (depending on waffle iron) of batter onto the center of the lower grid of the preheated waffle maker; spread batter evenly using a heatproof spatula.",
                "Close lid of waffle maker.",
                "When tone sounds (depending on waffle iron), waffle is ready.",
                "Open lid and carefully remove baked waffle.",
                "Repeat with remaining batter.",
                "For best results, serve immediately."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.waffles);
        recipes.add(new Recipe(recipes.size()+1,"Yeasted Waffles",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Pancakes
        ingredients = new String[] {"3 tablespoons Butter",
                "1 tablespoon Sugar",
                "1 Egg",
                "1 1/2 cups Flour",
                "3 1/2 teaspoons Baking Powder",
                "1/4 teaspoon Salt",
                "1 1/4 cup Milk"};

        instructions = new String[] {"In a large bowl, sift together the flour, baking powder, salt and sugar. Make a well in the center and pour in the milk, egg and melted butter; mix until smooth.",
                "Heat a lightly oiled griddle or frying pan over medium-high heat. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake. Brown on both sides and serve hot."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.pancakes);
        recipes.add(new Recipe(recipes.size()+1,"Pancakes",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // French Toast
        ingredients = new String[] {"1 teaspoon Ground Cinnamon",
                "1/4 teaspoon Ground Nutmeg",
                "4 Eggs",
                "2 tablespoons Sugar",
                "4 tablespoons Butter",
                "1/4 cup Milk",
                "1 1/2 teaspoons Vanilla",
                "8 slices Bread",
                "1/2 cup Maple Syrup"};

        instructions = new String[] {"In a small bowl, combine cinnamon, nutmeg, and sugar and set aside briefly.",
                "In a 10-inch or 12-inch skillet, melt butter over medium heat. Whisk together cinnamon mixture, eggs, milk, and vanilla and pour into a shallow container such as a pie plate. Dip bread in egg mixture. Fry slices until golden brown, then flip to cook the other side. Serve with syrup."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.frenchtoast);
        recipes.add(new Recipe(recipes.size()+1,"French Toast",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Brownies
        ingredients = new String[] {"1/2 cup Butter",
                "1 cup Sugar",
                "2 Eggs",
                "1 teaspoon Vanilla",
                "1/3 cup Cocoa Powder",
                "1/2 cup Flour",
                "1/4 teaspoon Salt",
                "1/4 teaspoon Baking Powder"};

        instructions = new String[] {"Preheat oven to 350 degrees F (175 degrees C). Grease and flour an 8-inch square pan.",
                "In a large saucepan, melt 1/2 cup butter. Remove from heat, and stir in sugar, eggs, and 1 teaspoon vanilla. Beat in 1/3 cup cocoa, 1/2 cup flour, salt, and baking powder. Spread batter into prepared pan.",
                "Bake in preheated oven for 25 to 30 minutes. Do not overcook."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.brownies);
        recipes.add(new Recipe(recipes.size()+1,"Chocolate Brownies",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Nachos
        ingredients = new String[] {"1 pound Ground Beef",
                "1 Onion, Diced",
                "Salt and Pepper",
                "2 cups Shredded Cheddar",
                "1 16 oz can refried beans",
                "1 14.5 oz bag Chips",
                "1 Sliced Jalapeno Pepper"};

        instructions = new String[] {"In a large frying pan, brown ground beef with onion, salt and pepper over medium heat. Break the meat into very small pieces while it is cooking. After the meat is thoroughly cooked, drain off the grease.",
                "Arrange chips on a microwavable platter. Spread beans over the chips. Layer with 1/2 of the cheese, the ground beef mixture, and remaining cheese. Arrange jalapeno peppers on top.",
                "Microwave on medium-high until cheese has melted. Serve immediately."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.nachos);
        recipes.add(new Recipe(recipes.size()+1,"Nachos",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Salad
        ingredients = new String[] {"1 tablespoon Butter",
                "3/4 cup Almonds",
                "1 pound Spinach",
                "1 cup Dried Cranberries",
                "2 tablespoons Toasted Sesame Seeds",
                "1 tablespoon Poppy Seeds",
                "1/2 cup Sugar",
                "2 teaspoons Minced Onion",
                "1/4 teaspoon Paprika",
                "1/4 cup White Wine Vinegar",
                "1/4 cup Cider Vinegar",
                "1/2 cup Vegetable Oil"};

        instructions = new String[] {"In a medium saucepan, melt butter over medium heat. Cook and stir almonds in butter until lightly toasted. Remove from heat, and let cool.",
                "In a medium bowl, whisk together the sesame seeds, poppy seeds, sugar, onion, paprika, white wine vinegar, cider vinegar, and vegetable oil. Toss with spinach just before serving.",
                "In a large bowl, combine the spinach with the toasted almonds and cranberries."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.salad);
        recipes.add(new Recipe(recipes.size()+1,"Spinach Salad",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Fries
        ingredients = new String[] {"1/2 cup Sugar",
                "2 cups Warm Water",
                "2 Large Russet Potatoes, peeled, and sliced into 1/4 inch strips ",
                "6 cups Vegetable Oil",
                "Salt"};

        instructions = new String[] {"In a medium bowl, dissolve the sugar in warm water. Soak potatoes in water mixture for 15 minutes. Remove from water, and dry thoroughly on paper towels.",
                "Heat oil in deep-fryer to 375 degrees F (190 degrees C). Add potatoes, and cook until golden, 5 to 6 minutes. drain on paper towels. Season with salt to taste."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.fries);
        recipes.add(new Recipe(recipes.size()+1,"French Fries",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Lobster Roll
        ingredients = new String[] {"1 8 oz package Lobster Meat",
                "1/4 cup Mayonnaise",
                "1 tablespoon Finely Chopped Red Onion",
                "1 teaspoon Lemon Juice",
                "1/4 teaspoon OLD BAY Seasoning",
                "1 tablespoon Butter",
                "2 Hot Dog Buns"};

        instructions = new String[] {"In a medium bowl, flake the crabmeat, and mix in mayonnaise, onion, lemon juice and Old Bay seasoning. Cover and refrigerate for 30 minutes to allow the flavors to mingle.",
                "Spread butter on the inside of the hot dog buns, and toast under the broiler. Fill buns with the lobster salad, and serve."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.lobsterroll);
        recipes.add(new Recipe(recipes.size()+1,"Lobster Rolls",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Grilled Cheese Sandwich
        ingredients = new String[] {"2 slices Bread",
                "2 sloces American Cheese",
                "2 teaspoons Brown Sugar",
                "2 teaspoons Butter"};

        instructions = new String[] {"Heat a skillet over medium heat. Spread butter onto one side of a piece of bread and place butter side down in the skillet. Place one piece of cheese on top of the bread, then sprinkle with brown sugar. Top with the other slice of cheese. Butter the other slice of bread and place on top with the butter side up. Fry on each side until golden brown, 3 to 5 minutes per side."};
        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.grilledcheese);
        recipes.add(new Recipe(recipes.size()+1,"Grilled Cheese Sandwich",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Apple Pie
        ingredients = new String[] {"1 tablespoon Butter",
                "3/4 cup Sugar",
                "2 tablespoons Flour",
                "1/2 teaspoon Ground Cinnamon",
                "1/4 teaspoon Ground Nutmeg",
                "1/2 teaspoon Lemon Zest",
                "7 cups Thinly Sliced Apples",
                "2 teaspoons Lemon Juice",
                "1 Pie Crust",
                "4 tablespoons Milk (optional)"};

        instructions = new String[] {"Preheat oven to 425 degrees F (220 degrees C).",
                "Mix together the sugar, flour, cinnamon, nutmeg and lemon peel.",
                "Line one crust in a 9-inch deep-dish pie pan. Layer 1/3 of apples into pie crust. Sprinkle with sugar mixture and repeat until done. Sprinkle with lemon juice and dot with butter.",
                "Place second pie crust on top of filling and flute the edges. Cut vents in top crust and brush with milk for a glazed appearance if desired.",
                "Bake at 425 degrees F (220 degrees C) for 40 to 50 minutes."};

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.applepie);

        recipes.add(new Recipe(recipes.size()+1,"Apple Pie",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Banana Bread
        ingredients = new String[] {"2 sticks Butter",
                "3 cups Sugar",
                "4 Eggs",
                "3 1/2 cups Flour",
                "2 teaspoons Baking Soda",
                "1/4 teaspoon Salt",
                "1 teaspoon Vanilla",
                "1 cup Buttermilk",
                "6 Bananas, Mashed"};

        instructions = new String[] {"Preheat oven to 325 degrees F (165 degrees C). Lightly grease a 9x13 inch baking pan.",
                "In a large bowl, cream together the sugar and margarine until light and fluffy. Stir in the eggs one at a time, beating well with each addition, then stir in the vanilla.",
                "In a large bowl, sift together flour, baking soda and salt. Blend this mixture into the egg mixture, alternately with the buttermilk; stir just to combine. Fold in the mashed bananas; mixing just enough to evenly combine. Pour batter into prepared pan.",
                "Bake in preheated oven until a toothpick inserted into center of the loaf comes our clean, about 60 minutes."};

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.bananabread);

        recipes.add(new Recipe(recipes.size()+1,"Banana Bread",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Jjajangmyeon
        ingredients = new String[] {"Jjajangmyeon noodles",
                "½ pound pork belly, cut into ½ inch cubes (about 1½ cups’ worth)",
                "1 cup of Korean radish (or daikon), cut into ½ inch cubes (about 1 cup’s worth)",
                "1 cup of zucchini, cut into ½ inch cubes",
                "1 cup of potato, peeled and cut into ½ inch cubes",
                "1½ cups of onion chunks",
                "3 tablespoons of vegetable oil",
                "¼ cup and 1 tablespoon of black bean paste",
                "2 tablespoons of potato starch powder, combined with ¼ cup water and 1 teaspoon of sugar in a small bowl, set aside",
                "1 teaspoon of toasted sesame oil",
                "½ cup cucumber, cut into thin matchsticks for garnish",
                "water"};
        instructions = new String[] {"Stir-fry the pork belly in a large, deep wok with 1 Tablespoon of vegetable oil for about 4-5 minutes, until golden brown and crispy.",
                "Pour out the excess pork fat.",
                "Add radish and stir fry for 1 minute.",
                "Add potato, onion, and zucchini and keep stirring for about 3 minutes until the potato looks a little translucent.",
                "Clear a space in the center of the wok by pushing the ingredients to the edges.",
                "Add 2 Tablespoons of vegetable oil to the center of the wok, then add ¼ cup of black bean paste and stir it with a wooden spoon for 1 minute to fry it. Then mix everything in the wok and keep stirring.",
                "Add  2 cups of water to the wok and let it cook with the lid closed for about 10 minutes.",
                "Open the lid and taste a sample of the radish and potato. If they’re fully cooked, stir in the starch water little by little. Keep stirring until it’s well mixed and thick.",
                "Add the sesame oil and remove from the heat.",
                "Serve with noodles (jjajangmyeon) or steamed rice (jjajangbap)."};

        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.jjajangmyeon);

        recipes.add(new Recipe(recipes.size()+1,"Jjajangmyeon",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Fried Rice
        ingredients = new String[] {"White long grain rice",
                "Small white onion",
                "Peas",
                "Carrots",
                "Eggs",
                "Sesame Oil",
                "Soy Sauce",
                "Green Onions"};

        instructions = new String[] {"Turn your skillet to medium high heat and pour sesame oil into the bottom of your skillet and add the onion, peas and carrots.",
                "Fry this until they are tender.", "Pour the beaten eggs onto the other side.", "Use a spatula to scramble the eggs", "Mix them together with the veggies",
                "Combine it with the veggie and egg mixture.", "Pour the soy sauce on top and stir until it is heated throughout.", "Garnish with green onions."};


        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.fried_rice);

        recipes.add(new Recipe(recipes.size()+1,"Fried Rice",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Chicken Pot Pie
        ingredients = new String[] {"1/3 cup butter or margarine",
                "1/3 cup chopped onion",
                "1/3 cup all-purpose flour",
                "1/2 teaspoon salt",
                "1/4 teaspoon pepper",
                "1 3/4 cups Progresso™ chicken broth (from 32-oz carton)",
                "1/2 cup milk",
                "2 1/2 cups shredded cooked chicken or turkey",
                "2 cups frozen mixed vegetables, thawed"};

        instructions = new String[] {"Heat oven to 425°F. Prepare pie crusts as directed on box for Two-Crust Pie using 9-inch glass pie pan.", "\n" +
                "In 2-quart saucepan, melt butter over medium heat. Add onion; cook 2 minutes, stirring frequently, until tender. Stir in flour, salt and pepper until well blended. Gradually stir in broth and milk, cooking and stirring until bubbly and thickened.",
                "Stir in chicken and mixed vegetables. Remove from heat. Spoon chicken mixture into crust-lined pan. Top with second crust; seal edge and flute. Cut slits in several places in top crust.",
                "Bake 30 to 40 minutes or until crust is golden brown. During last 15 to 20 minutes of baking, cover crust edge with strips of foil to prevent excessive browning. Let stand 5 minutes before serving."};


        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.chicken_pot_pie);

        recipes.add(new Recipe(recipes.size()+1,"Chicken Pot Pie",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Broccoli Cheddar Soup
        ingredients = new String[] {"1 tablespoon butter",
                "½ onion, chopped",
                "¼ cup melted butter",
                "¼ cup flour",
                "2 cups milk",
                "2 cups chicken stock",
                "1 ½ cups coarsely chopped broccoli florets",
                "1 cup matchstick-cut carrots",
                "1 stalk celery, thinly sliced",
                "2 ½ cups shredded sharp Cheddar cheese",
                "salt and ground black pepper to taste"};


        instructions = new String[] {"Melt 1 tablespoon butter in a skillet over medium-high heat. Saute onion in hot butter until translucent, about 5 minutes. Set aside.",
                "Whisk 1/4 cup melted butter and flour together in a large saucepan over medium-low heat. Continue to whisk and cook , adding 1 to 2 tablespoons of milk if necessary to keep the flour from burning, 3 to 4 minutes.",
                "Gradually pour milk into flour mixture while whisking constantly. Stir chicken stock into milk mixture. Bring to a simmer; cook until mixture is thickened, about 20 minutes. Add broccoli, carrots, sauteed onion, and celery; simmer until vegetables are tender, about 20 minutes.",
                "Stir Cheddar cheese into vegetable mixture until cheese melts. Season with salt and pepper to taste."};


        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.broccoli_cheddar);

        recipes.add(new Recipe(recipes.size()+1,"Broccoli Cheddar Soup",
                Recipe.convertUriToByteArray(imageUri, listRecipeFragment.getActivity()),
                ingredients, instructions));

        // Korean Fried Chicken
        ingredients = new String[] {"1.4 kg / 3 pounds whole chicken, cut into pieces or chicken wings / drumsticks / boneless chicken thigh",
                "2 Tbsp rice wine",
                "2 tsp minced ginger",
                "1 tsp fine sea salt",
                "1/2 tsp ground black pepper",
                "1 cup potato starch or corn starch",
                "Some cooking oil for deep frying",
                "3 Tbsp tomato sauce / ketchup",
                "2 Tbsp to 2 1/2 Tbsp gochujang (Korean chilli paste)",
                "1/4 cup honey",
                "1/4 cup brown sugar",
                "2 Tbsp soy sauce",
                "2 Tbsp minced garlic",
                "1 Tbsp sesame oil"};


        instructions = new String[] {"In a bowl, place the chicken, rice wine, ginger, salt and black pepper. Combine them well. Then evenly coat the chicken with the starch and set side.",
                " In a deep saucepan (or frier) add a generous amount of oil and heat it until the oil temperature reaches 175 C / 347 F (or boiling). Start adding the battered chicken carefully and fry them until they cook (between 3 to 5 mins, depending on the size of chicken). Do not overcrowd the pan. (It might be useful to use a grease splatter screen if you have one. It’s super handy! It minimises oil splatter.)",
                "Take out the done chicken and place them onto some kitchen paper while frying the remaining chicken pieces. Once the first set of deep frying is completed, quickly scoop out any floating debris from the oil using a skimmer. Then deep fry the chicken again when the oil temperature reaches 175 C / 347 F (or boiling). Fry them until the batter is golden and crisp. (The second time frying is shorter than the first time, 2 to 3 mins) Set aside.",
                "In a separate saucepan, add in the Korean fried chicken sauce ingredients (listed above). Heat the sauce over low to medium heat and stir well. Once it starts bubbling, remove the pan from the heat.",
                "Place the double fried chicken into a large mixing bowl then pour the fried chicken sauce over the chicken to coat. Mix them lightly and thoroughly. Alternatively, serve the fried chicken and the sauce separately and use the sauce as a dipping sauce.",
                "Once all the chicken is coated with the sauce, serve it hot immediately."};


        imageUri = getUriToDrawable(listRecipeFragment.getContext(), R.drawable.kfc);

        recipes.add(new Recipe(recipes.size()+1,"Korean Fried Chicken",
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
