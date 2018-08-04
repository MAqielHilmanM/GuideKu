package guideku.bisfor.guideku.screen.favorites.guide;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import guideku.bisfor.guideku.R;

public class FavoritesGuideViewHolder extends RecyclerView.ViewHolder {
    ImageView ivRowFavGuide;
    TextView tvRowFavGuideName,tvRowFavGuideLocation;
    CardView cvRowFavGuide;

    public FavoritesGuideViewHolder(View itemView) {
        super(itemView);

        ivRowFavGuide = itemView.findViewById(R.id.ivRowFavGuide);
        tvRowFavGuideLocation = itemView.findViewById(R.id.tvRowFavGuideLocation);
        tvRowFavGuideName = itemView.findViewById(R.id.tvRowFavGuideName);
        cvRowFavGuide = itemView.findViewById(R.id.cvRowFavGuide);
    }
}
