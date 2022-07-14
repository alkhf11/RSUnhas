package com.example.rsunhas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rsunhas.Model.DataModel;
import com.example.rsunhas.R;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData>{
    private Context ctx;
    private List<DataModel> listdata;

    public AdapterData(Context ctx, List<DataModel> listdata) {
        this.ctx = ctx;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.tiket,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel dm = listdata.get(position);
        holder.noantri.setText(String.valueOf(dm.getNoantri()));
        holder.nama.setText(dm.getNama());
        holder.notelepon.setText(dm.getNotelepon());
        holder.rekmed.setText(dm.getRekmed());
        holder.poli.setText(dm.getPoli());
        holder.kunjungan.setText(dm.getKunjungan());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView noantri, nama,notelepon, rekmed, poli, kunjungan;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            noantri = itemView.findViewById(R.id.noantri);
            nama = itemView.findViewById(R.id.nama);
            notelepon = itemView.findViewById(R.id.notelepon);
            rekmed = itemView.findViewById(R.id.rekmed);
            poli = itemView.findViewById(R.id.poli);
            kunjungan = itemView.findViewById(R.id.kunjungan);
        }
    }
}
