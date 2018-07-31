package guideku.bisfor.guideku.screen.chat.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {
    List<ChatListDao> lists;

    public ChatListAdapter(List<ChatListDao> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
