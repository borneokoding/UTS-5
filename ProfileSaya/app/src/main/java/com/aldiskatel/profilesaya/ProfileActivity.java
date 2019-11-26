package com.aldiskatel.profilesaya;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private TextView tvNama, tvNpm, tvUmur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        init();
    }

    private void init() {
        tvNama = findViewById(R.id.edtNama);
        tvNpm = findViewById(R.id.edtNpm);
        tvUmur = findViewById(R.id.edtUmur);

        Intent i = getIntent();
        tvNama.setText(i.getStringExtra("nama"));
        tvNpm.setText(i.getStringExtra("npm"));
        tvUmur.setText(i.getStringExtra("umur"));
    }
}
