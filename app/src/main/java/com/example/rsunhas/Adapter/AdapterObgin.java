package com.example.rsunhas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rsunhas.Model.DataModel3;
import com.example.rsunhas.R;

import java.util.List;

public class AdapterObgin extends RecyclerView.Adapter<AdapterObgin.HolderData>{
    private Context ctx;
    private List<DataModel3> listdata3;

    public AdapterObgin(Context ctx, List<DataModel3> listdata) {
        this.ctx = ctx;
        this.listdata3 = listdata;
    }

    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiketobgin,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel3 dm = listdata3.get(position);
        holder.noantri.setText(String.valueOf(dm.getNoantri()));
        holder.nama.setText(dm.getNama());
        holder.notelepon.setText(dm.getNotelepon());
        holder.rekmed.setText(dm.getRekmed());
        holder.poli.setText(dm.getPoli());
        holder.kunjungan.setText(dm.getKunjungan());
    }

    @Override
    public int getItemCount() {
        return listdata3.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView noantri, nama,notelepon, rekmed, poli, kunjungan;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            noantri = itemView.findViewById(R.id.noantri3);
            nama = itemView.findViewById(R.id.nama3);
            notelepon = itemView.findViewById(R.id.notelepon3);
            rekmed = itemView.findViewById(R.id.rekmed3);
            poli = itemView.findViewById(R.id.poli3);
            kunjungan = itemView.findViewById(R.id.kunjungan3);
        }
    }
}
