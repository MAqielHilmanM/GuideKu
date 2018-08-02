package guideku.bisfor.guideku.screen.edutour.list;

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

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;


public class EdutourListFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<EdutourListDao> list;

    public EdutourListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_edutour_list, container, false);

        initObject(v);

        initDummy();

        return v;

    }

    private void initDummy() {
        list.add(new EdutourListDao("1","-", EdutourListDao.Category.FriendlyTrips,"Enjoy warm morning call from, B Hill","Lembang",false));
        list.add(new EdutourListDao("1","-", EdutourListDao.Category.FriendlyTrips,"Enjoy warm morning call from, B Hill","Lembang",false));
        list.add(new EdutourListDao("1","-", EdutourListDao.Category.FriendlyTrips,"Enjoy warm morning call from, B Hill","Lembang",false));
    }

    private void initObject(View v) {
        recyclerView = v.findViewById(R.id.rvEdutourList);
        list = new ArrayList<>();
        adapter = new EdutourListAdapter<>(list);
        layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }


}
