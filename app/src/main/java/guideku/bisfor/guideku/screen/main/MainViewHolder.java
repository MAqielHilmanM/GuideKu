package guideku.bisfor.guideku.screen.main;

import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import guideku.bisfor.guideku.R;

public class MainViewHolder extends RecyclerView.ViewHolder{
    CardView cvRowMain;
    TextView tvRowMaintitle;
    ImageView ivRowMainImage;

    public MainViewHolder(View itemView) {
        super(itemView);

        cvRowMain = itemView.findViewById(R.id.cvRowMain);
        tvRowMaintitle = itemView.findViewById(R.id.tvRowMainTitle);
        ivRowMainImage = itemView.findViewById(R.id.ivRowMainImage);
    }
}
