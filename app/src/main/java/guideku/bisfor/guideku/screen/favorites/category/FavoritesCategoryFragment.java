package guideku.bisfor.guideku.screen.favorites.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.favorites.guide.FavoritesGuideFragment;
import guideku.bisfor.guideku.screen.favorites.place.FavoritesPlaceFragment;
import guideku.bisfor.guideku.screen.main.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesCategoryFragment extends Fragment {
    TextView tvFavCategoryPlace,tvFavCategoryGuide;

    public FavoritesCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_favorites_category, container, false);

        initObject(v);

        initAction();

        return v;
    }

    private void initAction() {
        tvFavCategoryPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new FavoritesPlaceFragment());
            }
        });

        tvFavCategoryGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new FavoritesGuideFragment());
            }
        });
    }

    private void initObject(View v) {
        tvFavCategoryGuide = v.findViewById(R.id.tvFavCategoryGuide);
        tvFavCategoryPlace = v.findViewById(R.id.tvFavCategoryPlace);
    }

}
