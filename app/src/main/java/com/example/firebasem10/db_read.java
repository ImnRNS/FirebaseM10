package com.example.firebasem10;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class db_read extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterMhsRecycleview adapter;
    private List<Mahasiswa> mhsList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mhsList = new ArrayList<>();
        adapter = new AdapterMhsRecycleview(mhsList, this);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Mahasiswa");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mhsList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Mahasiswa mahasiswa = postSnapshot.getValue(Mahasiswa.class);
                    mhsList.add(mahasiswa);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(db_read.this, "Failed to load data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
