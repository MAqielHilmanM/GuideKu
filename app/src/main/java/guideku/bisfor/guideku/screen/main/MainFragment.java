package guideku.bisfor.guideku.screen.main;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.api.BaseFirebase;
import guideku.bisfor.guideku.api.model.UserModel;
import guideku.bisfor.guideku.screen.edutour.list.EdutourListFragment;
import guideku.bisfor.guideku.screen.favorites.category.FavoritesCategoryFragment;
import guideku.bisfor.guideku.screen.history.list.HistoryListFragment;
import guideku.bisfor.guideku.screen.setting.SettingFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    TextView tvMainEdutour,tvMainFavorites,tvMainSetting,tvMainHistory,tvMainTitle;
    RecyclerView rvMain;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<MainDao> lists;
    Context context;
    String name,uId;
    UserModel userModel;
    public static final String TAG = "MAINFRAGMET";

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

        callData(uId);
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
        tvMainTitle = v.findViewById(R.id.tvMainTitle);
        rvMain = v.findViewById(R.id.rvMain);
        lists = new ArrayList<>();
        context = getContext();
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new MainAdapter(lists);

        assert getArguments() != null;
        name = getArguments().getString(MainActivity.EXTRA_NAME);
        uId = getArguments().getString(MainActivity.EXTRA_ID);

        tvMainTitle.setText("Welcome , "+name);
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);

    }


    private void callData(String uId){
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firebaseFirestore.collection(BaseFirebase.KEY_USER).document(uId);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                 userModel = documentSnapshot.toObject(UserModel.class);
                 tvMainTitle.setText("Welcome, "+userModel.getName());
            }
        });

        firebaseFirestore.collection(BaseFirebase.KEY_PLACE).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    lists.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        lists.add(new MainDao(document.getId(),document.getString(BaseFirebase.KEY_PLACE_URLIMAGE),document.getString(BaseFirebase.KEY_PLACE_NAME)));
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });
    }
}
