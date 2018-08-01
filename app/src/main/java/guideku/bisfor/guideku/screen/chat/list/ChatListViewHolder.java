package guideku.bisfor.guideku.screen.chat.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import guideku.bisfor.guideku.R;

public class ChatListViewHolder extends RecyclerView.ViewHolder{
    TextView tvRowChatListTitle,tvRowChatListLast,tvRowChatListCount,tvRowChatListTime;
    CircleImageView civRowChatListImage;
    LinearLayout layoutRowChatList;

    public ChatListViewHolder(View itemView) {
        super(itemView);
        tvRowChatListCount = itemView.findViewById(R.id.tvRowChatCount);
        tvRowChatListTime = itemView.findViewById(R.id.tvRowChatTime);
        tvRowChatListTitle = itemView.findViewById(R.id.tvRowChatTitle);
        tvRowChatListLast = itemView.findViewById(R.id.tvRowChatSubtitle);
        civRowChatListImage = itemView.findViewById(R.id.civRowChat);
        layoutRowChatList = itemView.findViewById(R.id.layoutRowChatList);
    }
}
