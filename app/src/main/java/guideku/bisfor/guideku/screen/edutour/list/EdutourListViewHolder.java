package guideku.bisfor.guideku.screen.edutour.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import guideku.bisfor.guideku.R;

public class EdutourListViewHolder extends RecyclerView.ViewHolder {
    TextView tvRowEdutourCategory,tvRowEdutourDescription,tvRowEdutourLocation;
    ImageView ivRowEdutourPicture;
    LinearLayout layoutRowEdutour;

    public EdutourListViewHolder(View itemView) {
        super(itemView);

        tvRowEdutourCategory = itemView.findViewById(R.id.tvRowEdutourCategory);
        tvRowEdutourDescription = itemView.findViewById(R.id.tvRowEdutourDescription);
        tvRowEdutourLocation = itemView.findViewById(R.id.tvRowEdutourLocation);
        ivRowEdutourPicture = itemView.findViewById(R.id.ivRowEdutourImage);
        layoutRowEdutour = itemView.findViewById(R.id.layoutRowEdutour);

    }
}
