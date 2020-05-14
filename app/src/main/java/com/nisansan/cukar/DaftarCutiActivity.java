package com.nisansan.cukar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nisansan.cukar.model.DataCutiModel;

import java.util.Calendar;

public class DaftarCutiActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText idCuti, jumlah, tgl, keterangan, status;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_cuti);

        idCuti = (EditText) findViewById(R.id.id_cuti);
        jumlah = (EditText) findViewById(R.id.jumlah_cuti);
        tgl = (EditText) findViewById(R.id.tgl_cuti);
        keterangan = (EditText) findViewById(R.id.keterangan_cuti);
        status = (EditText) findViewById(R.id.status);
        btnSubmit = (Button) findViewById(R.id.submit_cuti);

        findViewById(R.id.tgl_cuti).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showcalender();
            }
        });

        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Cuti");
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = idCuti.getText().toString().trim();
                String jumlah_cuti = jumlah.getText().toString().trim();
                String tgl_cuti = tgl.getText().toString().trim();
                String ket = keterangan.getText().toString().trim();
                String stts = status.getText().toString().trim();

                DataCutiModel datacuti = new DataCutiModel(id, jumlah_cuti, tgl_cuti, ket, stts);
                reference.child(id).setValue(datacuti);
                Toast.makeText(getApplicationContext(), "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                hapusText();
            }
        });

    }

    public void hapusText(){
        idCuti.getText().clear();
        jumlah.getText().clear();
        tgl.getText().clear();
        keterangan.getText().clear();
    }

    public void showcalender(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,this,
        Calendar.getInstance().get(Calendar.YEAR),
        Calendar.getInstance().get(Calendar.MONTH),
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "-" + month + "-" + year;
        tgl.setText(date);
    }

}
