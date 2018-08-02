package guideku.bisfor.guideku.screen.edutour.detail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import guideku.bisfor.guideku.R;

public class EdutourDetailViewHolder extends RecyclerView.ViewHolder {
    ImageView ivRowEdutourDetail;

    public EdutourDetailViewHolder(View itemView) {
        super(itemView);

        ivRowEdutourDetail = itemView.findViewById(R.id.ivRowEdutourImage);
    }
}
