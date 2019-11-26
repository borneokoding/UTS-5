package com.aldiskatel.profilesaya;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText edtNama, edtNpm, edtTahun;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        edtNama = findViewById(R.id.edtNama);
        edtNpm = findViewById(R.id.edtNpm);
        edtTahun = findViewById(R.id.edtTahun);
        btnSubmit = findViewById(R.id.btnSend);
        actions();
    }

    private void actions() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().length() == 0 || edtNpm.getText().length() == 0 || edtTahun.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Mohon lengkapi data!", Toast.LENGTH_SHORT).show();
                } else {
                    @SuppressLint("SimpleDateFormat")
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    int now = Integer.parseInt(sdf.format(new Date()));
                    int umur = now - Integer.parseInt(edtTahun.getText().toString().trim());
                    Log.d("umur", String.valueOf(umur));
                    Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                    i.putExtra("nama", edtNama.getText().toString().trim());
                    i.putExtra("npm", edtNpm.getText().toString().trim());
                    i.putExtra("umur", umur + " tahun");
                    startActivity(i);
                }
            }
        });
    }
}
