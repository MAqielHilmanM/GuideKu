package guideku.bisfor.guideku.screen.favorites.place;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import guideku.bisfor.guideku.R;

public class FavoritesPlaceGuide extends Fragment {

    public FavoritesPlaceGuide() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_place_guide, container, false);
    }

}
