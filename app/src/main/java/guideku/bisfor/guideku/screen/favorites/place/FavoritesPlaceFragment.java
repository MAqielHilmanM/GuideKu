package guideku.bisfor.guideku.screen.favorites.place;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.edutour.list.EdutourListAdapter;

public class FavoritesPlaceFragment extends Fragment {

    LinearLayout layoutFavPlaceEmpty;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<FavoritesPlaceDao> list;

    public FavoritesPlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_favorites_place_guide, container, false);

        initObject(getContext(),v);

        initDummy();

        checkListData();
        return v;
    }

    private void initDummy() {
        list.add(new FavoritesPlaceDao("","","Alven Mountain","Russia"));
        list.add(new FavoritesPlaceDao("","","Alven Mountain","Russia"));
        list.add(new FavoritesPlaceDao("","","Alven Mountain","Russia"));
        list.add(new FavoritesPlaceDao("","","Alven Mountain","Russia"));
        adapter.notifyDataSetChanged();
    }

    private void initObject(Context context,View v) {
        layoutFavPlaceEmpty = v.findViewById(R.id.layoutFavPlace);
        recyclerView = v.findViewById(R.id.rvFavPlace);
        list = new ArrayList<>();
        adapter = new EdutourListAdapter<>(list);
        layoutManager = new GridLayoutManager(context,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void checkListData() {
        if(list.isEmpty()){
            layoutFavPlaceEmpty.setVisibility(View.VISIBLE);
        }else {
            layoutFavPlaceEmpty.setVisibility(View.GONE);
        }
    }

}
