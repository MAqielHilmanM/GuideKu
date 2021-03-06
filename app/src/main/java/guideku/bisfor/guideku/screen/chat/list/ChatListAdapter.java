package guideku.bisfor.guideku.screen.chat.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.chat.detail.ChatDetailActivity;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {
    List<ChatListDao> lists;
    Context context;
    String userId;

    public ChatListAdapter(List<ChatListDao> lists,String userId) {
        this.lists = lists;
        this.userId = userId;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ChatListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, final int position) {
        if(lists.get(position) != null){
            holder.tvRowChatListTitle.setText(lists.get(position).name);
            holder.tvRowChatListLast.setText(lists.get(position).lastText);
            holder.tvRowChatListCount.setText(String.valueOf(lists.get(position).count));
            holder.tvRowChatListTime.setText(lists.get(position).time);
            holder.layoutRowChatList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ChatDetailActivity.startActivity(context,lists.get(position).id,lists.get(position).name,lists.get(position).urlImage,userId);
                }
            });

            if(lists.get(position).urlImage != null && !lists.get(position).urlImage.equals(""))
                Picasso.get().load(lists.get(position).urlImage).fit().into(holder.civRowChatListImage);
        }

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
