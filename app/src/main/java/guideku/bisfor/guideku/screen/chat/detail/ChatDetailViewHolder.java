package guideku.bisfor.guideku.screen.chat.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import guideku.bisfor.guideku.R;

public class ChatDetailViewHolder extends RecyclerView.ViewHolder {
    TextView tvRowChatDetailTimeOther,tvRowChatDetailTimeMe,tvRowChatDetailText;
    CircleImageView civRowChatDetail;

    public ChatDetailViewHolder(View itemView) {
        super(itemView);

        tvRowChatDetailText = itemView.findViewById(R.id.tvRowChatDetailText);
        tvRowChatDetailTimeMe = itemView.findViewById(R.id.tvRowChatDetailTimeMe);
        tvRowChatDetailTimeOther = itemView.findViewById(R.id.tvRowChatDetailTimeOther);
        civRowChatDetail = itemView.findViewById(R.id.civRowChatDetail);
    }
}
