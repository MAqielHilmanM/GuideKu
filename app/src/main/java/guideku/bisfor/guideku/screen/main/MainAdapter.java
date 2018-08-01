package guideku.bisfor.guideku.screen.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import guideku.bisfor.guideku.R;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    List<MainDao> lists;

    public MainAdapter(List<MainDao> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.tvRowMaintitle.setText(lists.get(position).title);
        holder.ivRowMainImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
