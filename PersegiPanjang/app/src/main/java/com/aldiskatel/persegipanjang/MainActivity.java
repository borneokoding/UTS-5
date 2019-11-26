package com.aldiskatel.persegipanjang;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtPanjang, edtLebar;
    private Button btnSubmit;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        edtPanjang = findViewById(R.id.edtPanjang);
        edtLebar = findViewById(R.id.edtLebar);
        btnSubmit = findViewById(R.id.btnSubmit);
        tv = findViewById(R.id.tv);

        actions();
    }

    private void actions() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPanjang.getText().length() == 0 || edtLebar.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, "Mohon isi semua data!", Toast.LENGTH_SHORT).show();
                } else {
                    tv.setText(String.valueOf(Double.valueOf(edtLebar.getText().toString().trim()) * Double.valueOf(edtPanjang.getText().toString().trim())));
                }
            }
        });
    }
}
