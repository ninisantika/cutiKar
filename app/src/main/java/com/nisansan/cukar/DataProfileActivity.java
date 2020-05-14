package com.nisansan.cukar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nisansan.cukar.model.UserProfile;


public class DataProfileActivity extends AppCompatActivity {

    private TextView profileNama, profileID, profileEmail, profilePassword, profileJabatan;
    private TextView fullnameLabel;
    private static final String TAG = "DataProfileActivity";
    private DatabaseReference reference;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_profile);

        fullnameLabel = (TextView) findViewById(R.id.fullnamaLabel);
        profileNama = (TextView) findViewById(R.id.fullnameData);
        profileID = (TextView) findViewById(R.id.id_Data);
        profileEmail = (TextView) findViewById(R.id.usernameData);
        profilePassword = (TextView) findViewById(R.id.passwordData);
        profileJabatan = (TextView) findViewById(R.id.spinnerData);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.orderByChild("email").equalTo(email);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    UserProfile userProfile = ds.getValue(UserProfile.class);

                    fullnameLabel.setText(userProfile.getFullname());
                    profileNama.setText(userProfile.getFullname());
                    profileID.setText(userProfile.getId_user());
                    profileEmail.setText(userProfile.getEmail());
                    profilePassword.setText(userProfile.getPassword());
                    profileJabatan.setText(userProfile.getJabatan());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(DataProfileActivity.this, "Data Belum Ada", Toast.LENGTH_SHORT).show();

            }
        });
    }
}