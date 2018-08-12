package guideku.bisfor.guideku.screen.chat.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.api.BaseFirebase;
import guideku.bisfor.guideku.api.model.ChatModel;
import guideku.bisfor.guideku.api.model.UserModel;
import guideku.bisfor.guideku.screen.main.MainActivity;
import guideku.bisfor.guideku.utils.Tools;

public class ChatListFragment extends Fragment {
    Context context;
    RecyclerView rvChatList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<ChatListDao> lists;
    LinearLayout layoutChatEmpty;

    String uId;
    int n;
    public static final String TAG = "ChatListFrag";

    public ChatListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat_list, container, false);

        initObject(v);

        initDummy();

        callData(uId);

        checkListData();

        return v;
    }

    private void checkListData() {
        if (lists.isEmpty()) {
            layoutChatEmpty.setVisibility(View.VISIBLE);
        } else {
            layoutChatEmpty.setVisibility(View.GONE);
        }
    }

    private void initDummy() {
        lists.add(new ChatListDao());
        lists.add(new ChatListDao());
        lists.add(new ChatListDao());
        lists.add(new ChatListDao());
        lists.add(new ChatListDao());
    }

    private void initObject(View v) {
        rvChatList = v.findViewById(R.id.rvChatList);
        layoutChatEmpty = v.findViewById(R.id.layoutChatEmpty);
        lists = new ArrayList<>();
        adapter = new ChatListAdapter(lists,uId);
        layoutManager = new LinearLayoutManager(getContext());
        context = getContext();
        rvChatList.setAdapter(adapter);
        rvChatList.setLayoutManager(layoutManager);
        assert getArguments() != null;
        uId = getArguments().getString(MainActivity.EXTRA_ID);
    }


    private void callData(String uId) {
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection(BaseFirebase.KEY_CHAT).whereEqualTo(BaseFirebase.KEY_CHAT_USER, uId).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                lists.clear();
                for (DocumentSnapshot item : queryDocumentSnapshots
                        ) {
                    ChatModel model = item.toObject(ChatModel.class);
                    callUser(model, item.getId());
                }
                adapter.notifyDataSetChanged();
            }
        });


    }

    private void callUser(final ChatModel model, final String Id) {
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firebaseFirestore.collection(BaseFirebase.KEY_USER).document(model.getGuide());
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                UserModel userModel = documentSnapshot.toObject(UserModel.class);
                lists.add(new ChatListDao(Id, userModel.getName(), model.getUserUnread(), model.getLastMessage(), Tools.dateTimeToTimeFormat(model.getLastModified()), userModel.getUrlImage()));
                adapter.notifyDataSetChanged();
            }
        });
    }



}
