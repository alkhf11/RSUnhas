package com.example.rsunhas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rsunhas.Model.DataModelkmr;
import com.example.rsunhas.R;

import java.util.List;

public class AdapterKamar extends RecyclerView.Adapter<AdapterKamar.HolderData>{
    private Context ctxkamar;
    private List<DataModelkmr> listkamar;

    public AdapterKamar(Context ctx, List<DataModelkmr> listkamar) {
        this.ctxkamar = ctx;
        this.listkamar = listkamar;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.kamar,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModelkmr dm = listkamar.get(position);
        holder.namakamar.setText(String.valueOf(dm.getNamakamar()));
        holder.update.setText(dm.getUpdate());
        holder.kosong.setText(dm.getKosong());
        holder.tempat.setText(dm.getTempat());

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return listkamar.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView namakamar, update, tempat, kosong;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            namakamar = itemView.findViewById(R.id.kamar);
            update = itemView.findViewById(R.id.tglupdate);
            tempat = itemView.findViewById(R.id.nomor);
            kosong = itemView.findViewById(R.id.nomor2);
        }
    }
}
