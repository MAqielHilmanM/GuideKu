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

import java.util.ArrayList;
import java.util.List;

import guideku.bisfor.guideku.R;

public class ChatListFragment extends Fragment {
    Context context;
    RecyclerView rvChatList;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<ChatListDao> lists;
    LinearLayout layoutChatEmpty;

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

        checkListData();

        return v;
    }

    private void checkListData() {
        if(lists.isEmpty()){
            layoutChatEmpty.setVisibility(View.VISIBLE);
        }else {
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
        adapter = new ChatListAdapter(lists);
        layoutManager = new LinearLayoutManager(getContext());
        context = getContext();
        rvChatList.setAdapter(adapter);
        rvChatList.setLayoutManager(layoutManager);


    }




}
