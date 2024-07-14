package com.example.firebasem10;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class db_create extends AppCompatActivity {

    private EditText etName, etNIM;
    private Button btnSave;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_create);

        etName = findViewById(R.id.etName);
        etNIM = findViewById(R.id.etNIM);
        btnSave = findViewById(R.id.btnSave);

        databaseReference = FirebaseDatabase.getInstance().getReference("Mahasiswa");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String nim = etNIM.getText().toString().trim();

                if (!name.isEmpty() && !nim.isEmpty()) {
                    String id = databaseReference.push().getKey();
                    Mahasiswa mahasiswa = new Mahasiswa(id, name, nim);
                    databaseReference.child(id).setValue(mahasiswa);
                    Toast.makeText(db_create.this, "Data saved", Toast.LENGTH_SHORT).show();
                    etName.setText("");
                    etNIM.setText("");
                } else {
                    Toast.makeText(db_create.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
