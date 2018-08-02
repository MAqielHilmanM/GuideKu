package guideku.bisfor.guideku.screen.edutour.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;


public class EdutourDetailFragment extends Fragment {
    ImageView ivEdutourDetailImage;
    TextView tvEdutourDetailName, tvEdutourDetailTitle, tvEdutourDetailDescription, tvEdutourDetailFunFact, tvEdutourDetailMore;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<EdutourDetailDao> list;

    public EdutourDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edutour_detail, container, false);

        initObject(getContext(), v);

        initDummy();

        return v;
    }

    private void initDummy() {
        list.add(new EdutourDetailDao(""));
        list.add(new EdutourDetailDao(""));
        list.add(new EdutourDetailDao(""));
        list.add(new EdutourDetailDao(""));
        adapter.notifyDataSetChanged();
    }

    private void initObject(Context context, View v) {
        ivEdutourDetailImage = v.findViewById(R.id.ivEdutourDetailImage);
        tvEdutourDetailName = v.findViewById(R.id.tvEdutourDetailName);
        tvEdutourDetailDescription = v.findViewById(R.id.tvEdutourDetailDesc);
        tvEdutourDetailFunFact = v.findViewById(R.id.tvEdutourDetailFunFact);
        tvEdutourDetailMore = v.findViewById(R.id.tvEdutourDetailMore);
        tvEdutourDetailTitle = v.findViewById(R.id.tvEdutourDetailTitle);
        recyclerView = v.findViewById(R.id.rvEdutourDetail);
        list = new ArrayList<>();
        adapter = new EdutourDetailAdapter(list);
        layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}
