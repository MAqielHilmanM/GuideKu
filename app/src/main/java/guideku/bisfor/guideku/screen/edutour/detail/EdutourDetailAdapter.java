package guideku.bisfor.guideku.screen.edutour.detail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;

public class EdutourDetailAdapter extends RecyclerView.Adapter<EdutourDetailViewHolder> {
    List<EdutourDetailDao> list;

    public EdutourDetailAdapter(List<EdutourDetailDao> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public EdutourDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EdutourDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_edutour_detail,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EdutourDetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
