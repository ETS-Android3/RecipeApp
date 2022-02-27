package tiffany.hoeung.recipeapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListRecipeFragment extends Fragment implements RecyclerAdapter.OnNoteListener {

    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Recipe> recipeList = new ArrayList<>();
    private RecyclerAdapter adapterRV;
    private RecyclerView recipeRV;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManager = new GridLayoutManager(this.getActivity(), 2);
        recipeRV.setLayoutManager(layoutManager);
        //recipeRVRight.setLayoutManager(layoutManager);

        createInitialRecipeList();

        adapterRV = new RecyclerAdapter(recipeList, this);

        recipeRV.setAdapter(adapterRV);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_recipe, container, false);

        recipeRV = view.findViewById(R.id.recipeRV1);

        return view;
    }

    @Override
    public void onNoteClick(int position) {
        System.out.println("position " + position + " pressed");
        // this is where we switch to the recipe screen
    }

    public void createInitialRecipeList() {
        System.out.println("Creating initial recipes!");

        recipeList.add(new Recipe(recipeList.size(), "Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti)));
        recipeList.add(new Recipe(recipeList.size(), "Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe(recipeList.size(), "Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe(recipeList.size(), "Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe(recipeList.size(), "Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));        recipeList.add(new Recipe(recipeList.size(), "Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti)));
        recipeList.add(new Recipe(recipeList.size(), "Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe(recipeList.size(), "Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe(recipeList.size(), "Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe(recipeList.size(), "Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));
        recipeList.add(new Recipe(recipeList.size(), "Spaghetti and meatballs", getContext().getDrawable(R.drawable.spaghetti)));
        recipeList.add(new Recipe(recipeList.size(), "Cottage Pie", getContext().getDrawable(R.drawable.cottage_pie)));
        recipeList.add(new Recipe(recipeList.size(), "Crab Rangoon", getContext().getDrawable(R.drawable.crab_rangoon)));
        recipeList.add(new Recipe(recipeList.size(), "Zaru Soba", getContext().getDrawable(R.drawable.zaru_soba)));
        recipeList.add(new Recipe(recipeList.size(), "Chicken Enchiladas", getContext().getDrawable(R.drawable.chicken_enchiladas)));
    }
}