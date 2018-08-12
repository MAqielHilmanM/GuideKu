package guideku.bisfor.guideku.screen.chat.detail;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import guideku.bisfor.guideku.R;

public class ChatDetailAdapter extends RecyclerView.Adapter<ChatDetailViewHolder> {
    List<ChatDetailDao> list;

    public ChatDetailAdapter(List<ChatDetailDao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ChatDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_detail,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatDetailViewHolder holder, int position) {
        holder.tvRowChatDetailText.setText(list.get(position).text);
        holder.tvRowChatDetailTimeMe.setText(list.get(position).time);
        holder.tvRowChatDetailTimeOther.setText(list.get(position).time);

        if(!list.get(position).isOther){
            holder.civRowChatDetail.setVisibility(View.GONE);
            holder.tvRowChatDetailTimeOther.setVisibility(View.GONE);
            holder.tvRowChatDetailTimeMe.setVisibility(View.VISIBLE);
            holder.tvRowChatDetailText.setBackgroundColor(Color.parseColor("#9CBF1F"));
        }else {
            holder.civRowChatDetail.setVisibility(View.VISIBLE);
            holder.tvRowChatDetailTimeOther.setVisibility(View.VISIBLE);
            holder.tvRowChatDetailTimeMe.setVisibility(View.GONE);
            holder.tvRowChatDetailText.setBackgroundColor(Color.parseColor("#3BB2BF"));
        }

        if(list.get(position).urlPic != null && !list.get(position).urlPic.equals(""))
            Picasso.get().load(list.get(position).urlPic).fit().into(holder.civRowChatDetail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
