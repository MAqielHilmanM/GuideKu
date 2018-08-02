package guideku.bisfor.guideku.screen.edutour.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;
import guideku.bisfor.guideku.screen.edutour.detail.EdutourDetailFragment;
import guideku.bisfor.guideku.screen.main.MainActivity;

public class EdutourListAdapter<T> extends RecyclerView.Adapter<EdutourListViewHolder> {
    List<T> list;

    public EdutourListAdapter(List<T> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public EdutourListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EdutourListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_edutour,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EdutourListViewHolder holder, int position) {

        if( list.get(position) instanceof EdutourListDao){
            holder.tvRowEdutourLocation.setText(((EdutourListDao) list.get(position)).location);
            holder.tvRowEdutourCategory.setText(((EdutourListDao) list.get(position)).getCategory());
            holder.tvRowEdutourDescription.setText(((EdutourListDao) list.get(position)).description);
            holder.layoutRowEdutour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.changeFragment(new EdutourDetailFragment());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
