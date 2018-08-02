package guideku.bisfor.guideku.screen.main;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.edutour.list.EdutourListFragment;
import guideku.bisfor.guideku.screen.favorites.category.FavoritesCategoryFragment;
import guideku.bisfor.guideku.screen.history.list.HistoryListFragment;
import guideku.bisfor.guideku.screen.setting.SettingFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView tvMainEdutour,tvMainFavorites,tvMainSetting,tvMainHistory;
    RecyclerView rvMain;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<MainDao> lists;
    Context context;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        initObject(v);

        initDummy();

        initAction();

        return v;
    }

    private void initAction() {
        tvMainEdutour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new EdutourListFragment());
            }
        });

        tvMainSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new SettingFragment());
            }
        });

        tvMainHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new HistoryListFragment());
            }
        });

        tvMainFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.changeFragment(new FavoritesCategoryFragment());
            }
        });
    }

    private void initDummy() {
        lists.add(new MainDao("1","1","Mountain Alven"));
        lists.add(new MainDao("2","2","Mountain Alven"));
        lists.add(new MainDao("3","3","Mountain Alven"));
        lists.add(new MainDao("4","4","Mountain Alven"));
        lists.add(new MainDao("5","5","Mountain Alven"));
        adapter.notifyDataSetChanged();
    }

    private void initObject(View v) {
        tvMainEdutour = v.findViewById(R.id.tvMainEdutour);
        tvMainFavorites = v.findViewById(R.id.tvMainFavorite);
        tvMainHistory = v.findViewById(R.id.tvMainHistory);
        tvMainSetting = v.findViewById(R.id.tvMainSetting);
        rvMain = v.findViewById(R.id.rvMain);
        lists = new ArrayList<>();
        context = getContext();
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new MainAdapter(lists);

        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);

    }
}
