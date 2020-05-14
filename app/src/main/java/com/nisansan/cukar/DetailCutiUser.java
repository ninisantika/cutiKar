package com.nisansan.cukar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailCutiUser extends AppCompatActivity {

    private String id, jumlah, tgl, ket, status;
    private TextView idTv, jumlahTv, tglTv, ketTv, statusTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cuti_user);

        idTv = findViewById(R.id.detail_id);
        jumlahTv = findViewById(R.id.detail_jumlah);
        tglTv = findViewById(R.id.detail_tgl);
        ketTv = findViewById(R.id.detail_keterangan);
        statusTv = findViewById(R.id.detail_status);

        id = getIntent().getStringExtra("id_cuti");
        jumlah = getIntent().getStringExtra("jumlah_cuti");
        tgl = getIntent().getStringExtra("tanggal_cuti");
        ket = getIntent().getStringExtra("keterangan_cuti");
        status = getIntent().getStringExtra("status_approval");

        idTv.setText(id);
        jumlahTv.setText(jumlah);
        tglTv.setText(tgl);
        ketTv.setText(ket);
        statusTv.setText(status);

    }
}
