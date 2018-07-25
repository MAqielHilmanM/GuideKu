package guideku.bisfor.guideku.screen.favorites.category;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guideku.bisfor.guideku.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesCategoryFragment extends Fragment {


    public FavoritesCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_category, container, false);
    }

}
