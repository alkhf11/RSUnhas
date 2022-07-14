package com.example.rsunhas.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rsunhas.Model.DataModel5;
import com.example.rsunhas.R;

import java.util.List;

public class AdapterTht extends RecyclerView.Adapter<AdapterTht.HolderData>{
    private Context ctx;
    private List<DataModel5> listdata5;

    public AdapterTht(Context ctx, List<DataModel5> listdata) {
        this.ctx = ctx;
        this.listdata5 = listdata;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.tikettht,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        DataModel5 dm = listdata5.get(position);
        holder.noantri.setText(String.valueOf(dm.getNoantri()));
        holder.nama.setText(dm.getNama());
        holder.notelepon.setText(dm.getNotelepon());
        holder.rekmed.setText(dm.getRekmed());
        holder.poli.setText(dm.getPoli());
        holder.kunjungan.setText(dm.getKunjungan());
    }

    @Override
    public int getItemCount() {
        return listdata5.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView noantri, nama,notelepon, rekmed, poli, kunjungan;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            noantri = itemView.findViewById(R.id.noantri5);
            nama = itemView.findViewById(R.id.nama5);
            notelepon = itemView.findViewById(R.id.notelepon5);
            rekmed = itemView.findViewById(R.id.rekmed5);
            poli = itemView.findViewById(R.id.poli5);
            kunjungan = itemView.findViewById(R.id.kunjungan5);
        }
    }
}
