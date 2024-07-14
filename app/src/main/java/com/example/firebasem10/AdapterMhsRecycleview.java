package com.example.firebasem10;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMhsRecycleview extends RecyclerView.Adapter<AdapterMhsRecycleview.ViewHolder> {

    private List<Mahasiswa> mhsList;
    private Context context;

    public AdapterMhsRecycleview(List<Mahasiswa> mhsList, Context context) {
        this.mhsList = mhsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mhs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mahasiswa mahasiswa = mhsList.get(position);
        holder.tvName.setText(mahasiswa.getName());
        holder.tvNIM.setText(mahasiswa.getNIM());
    }

    @Override
    public int getItemCount() {
        return mhsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvNIM;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvNIM = itemView.findViewById(R.id.tvNIM);
        }
    }
}

