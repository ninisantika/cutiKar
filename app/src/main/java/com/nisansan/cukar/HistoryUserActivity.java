package com.nisansan.cukar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nisansan.cukar.adapter.DataCutiAdapter;
import com.nisansan.cukar.model.DataCutiModel;

import java.util.ArrayList;

public class HistoryUserActivity extends AppCompatActivity {

    ArrayList<DataCutiModel> list;
    DataCutiAdapter adapter;

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayout;
    private String id_cuti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_user);

        recyclerView = findViewById(R.id.list_historycuti);
        recyclerView.setHasFixedSize(true);

        linearLayout = new LinearLayoutManager(this);
        linearLayout.setReverseLayout(true);
        linearLayout.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayout);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Cuti");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    DataCutiModel rvCuti = ds.getValue(DataCutiModel.class);
                    list.add(rvCuti);
                }
                adapter = new DataCutiAdapter(getApplicationContext(), list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
