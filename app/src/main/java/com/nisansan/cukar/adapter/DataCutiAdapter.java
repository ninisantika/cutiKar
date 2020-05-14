package com.nisansan.cukar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nisansan.cukar.DetailCutiUser;
import com.nisansan.cukar.R;
import com.nisansan.cukar.model.DataCutiModel;

import java.util.ArrayList;

public class DataCutiAdapter extends RecyclerView.Adapter<DataCutiAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<DataCutiModel> dataCutiModelArrayList;

    public DataCutiAdapter(Context cont, ArrayList<DataCutiModel> data) {
        context = cont;
        dataCutiModelArrayList = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_historycuti, parent, false);
        return new MyViewHolder(view);
    }

    /* data terhubung ke db */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.valStatusAproval.setText(dataCutiModelArrayList.get(position).getStatus_approval());
        holder.valIdCuti.setText(dataCutiModelArrayList.get(position).getId_cuti());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context.getApplicationContext(), DetailCutiUser.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("id_cuti", dataCutiModelArrayList.get(position).getId_cuti());
                i.putExtra("jumlah_cuti", dataCutiModelArrayList.get(position).getJumlah_cuti());
                i.putExtra("tanggal_cuti", dataCutiModelArrayList.get(position).getTgl_cuti());
                i.putExtra("keterangan_cuti", dataCutiModelArrayList.get(position).getKeterangan_cuti());
                i.putExtra("status_approval", dataCutiModelArrayList.get(position).getStatus_approval());

                context.startActivity(i);

            }
        });

    }

    /* data sesuai dari db */
    @Override
    public int getItemCount() {
        return dataCutiModelArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView valStatusAproval, valIdCuti;
        Button btnDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            valStatusAproval = itemView.findViewById(R.id.id_statuscuti);
            valIdCuti = itemView.findViewById(R.id.id_listcuti);
            btnDetail = itemView.findViewById(R.id.detail_cuti);
        }
    }
}
