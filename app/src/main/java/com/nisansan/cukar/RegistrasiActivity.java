package com.nisansan.cukar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nisansan.cukar.model.UserProfile;

public class RegistrasiActivity extends AppCompatActivity {

    private EditText regEmail, regPassword, regNama, regID;
    private Spinner regJabatan;
    private Button btnRegistrasi;
    private String fullname, id_user, email, jabatan, password;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

                btnRegistrasi = (Button) findViewById(R.id.registrasi);
                regNama = (EditText) findViewById(R.id.fullname);
                regID = (EditText) findViewById(R.id.id_user);
                regEmail = (EditText) findViewById(R.id.email);
                regPassword = (EditText) findViewById(R.id.password);
                regJabatan  = (Spinner) findViewById(R.id.spinnerRegis);;
                final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.typeUser, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                regJabatan.setAdapter(adapter);

                regJabatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        String spinner = regJabatan.getSelectedItem().toString();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                btnRegistrasi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String fullname = regNama.getText().toString().trim();
                        String id_user = regID.getText().toString().trim();
                        String email = regEmail.getText().toString().trim();
                        String password = regPassword.getText().toString().trim();
                        String jabatan = regJabatan.getSelectedItem().toString().trim();
                        if (TextUtils.isEmpty(fullname)) {
                            regNama.setError("Masukan Nama");
                            return;
                        }
                        if (TextUtils.isEmpty(id_user)){
                            regID.setError("Masukan ID");
                            return;
                        }
                        if (TextUtils.isEmpty(email)) {
                            regEmail.setError("Masukan Email");
                            return;
                        }
                        if (TextUtils.isEmpty(password)) {
                            regPassword.setError("Masukan Password");
                            return;
                        }
                        if (regPassword.length() < 6) {
                            regPassword.setError("Minimal 6 Karakter!");
                        }
                        else {
                            final FirebaseAuth mAuth = FirebaseAuth.getInstance();
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users").child(id_user);
                            final UserProfile userProfile = new UserProfile(fullname, id_user, email, password, jabatan);
                            reference.setValue(userProfile);
                            mAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                FirebaseUser user = mAuth.getCurrentUser();
                                                startActivity(new Intent(getApplication(), LoginActivity.class) );
                                                Toast.makeText(getApplication(), "Registrasi Sukses.",
                                                        Toast.LENGTH_SHORT).show();
                                                finish();
                                            } else {
                                                Toast.makeText(getApplication(), "Registrasi Gagal.",
                                                        Toast.LENGTH_SHORT).show();
                                            }

                                        }
                                    });
                        }

                    }
                });
            }
        }
