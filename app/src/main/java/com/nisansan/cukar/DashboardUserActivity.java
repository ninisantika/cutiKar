package com.nisansan.cukar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardUserActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgData, imgCuti, imgHistory, imgLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        imgData = findViewById(R.id.imgData);
        imgCuti = findViewById(R.id.imgCuti);
        imgHistory = findViewById(R.id.imgHistory);
        imgLogout = findViewById(R.id.imgLogout);


        mAuth = FirebaseAuth.getInstance();
        imgData.setOnClickListener(this);
        imgCuti.setOnClickListener(this);
        imgLogout.setOnClickListener(this);
        imgHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgCuti:
                Intent daftar = new Intent(this, DaftarCutiActivity.class);
                daftar.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(daftar);
                break;
            case R.id.imgHistory:
                Intent history = new Intent(this, HistoryUserActivity.class);
                history.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(history);
                break;
            case R.id.imgData:
                Intent profile = new Intent(this, DataProfileActivity.class);
                profile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(profile);
                break;
            case R.id.imgLogout:
                mAuth.signOut();
                Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                Intent signOut = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(signOut);
                finish();
                break;

        }
    }
}
