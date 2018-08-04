package guideku.bisfor.guideku.screen.favorites.guide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;

public class FavoritesGuideAdapter extends RecyclerView.Adapter<FavoritesGuideViewHolder> {
    List<FavoritesGuideDao> list;

    public FavoritesGuideAdapter(List<FavoritesGuideDao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public FavoritesGuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesGuideViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_favorites_guide,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesGuideViewHolder holder, int position) {
        holder.tvRowFavGuideName.setText(list.get(position).name);
        holder.tvRowFavGuideLocation.setText(list.get(position).location);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
