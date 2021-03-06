package guideku.bisfor.guideku.screen.favorites.guide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;

public class FavoritesGuideFragment extends Fragment {

    LinearLayout layoutFavGuideEmpty;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<FavoritesGuideDao> list;

    public FavoritesGuideFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_favorites_guide, container, false);

        initObject(getContext(),v);

        initDummy();

        checkListData();

        return v;
    }

    private void initDummy() {
        list.add(new FavoritesGuideDao("","John Doe","Lorem City",""));
        list.add(new FavoritesGuideDao("","John Doe","Lorem City",""));
        list.add(new FavoritesGuideDao("","John Doe","Lorem City",""));
        list.add(new FavoritesGuideDao("","John Doe","Lorem City",""));
    }

    private void initObject(Context context,View v) {
        layoutFavGuideEmpty = v.findViewById(R.id.layoutFavGuide);
        recyclerView = v.findViewById(R.id.rvFavGuide);
        list = new ArrayList<>();
        adapter = new FavoritesGuideAdapter(list);
        layoutManager = new GridLayoutManager(context,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void checkListData() {
        if(list.isEmpty()){
            layoutFavGuideEmpty.setVisibility(View.VISIBLE);
        }else {
            layoutFavGuideEmpty.setVisibility(View.GONE);
        }
    }


}
