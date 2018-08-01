package guideku.bisfor.guideku.screen.chat.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.chat.detail.ChatDetailActivity;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {
    List<ChatListDao> lists;
    Context context;

    public ChatListAdapter(List<ChatListDao> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {
        holder.layoutRowChatList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatDetailActivity.startActivity(context,"","");
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
