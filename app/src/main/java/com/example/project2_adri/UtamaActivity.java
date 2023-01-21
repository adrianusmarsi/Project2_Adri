package com.example.project2_adri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class UtamaActivity extends AppCompatActivity {
    String[] judul;
    String[] ket;
    TypedArray gambar;
    String nim;
    TextView tNim;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        lv = findViewById(R.id.lvData);
        tNim = findViewById(R.id.tNim);

        nim = getIntent().getExtras().getString("nim");

        tNim.setText("Selamat Datang " + nim);

        judul = getResources().getStringArray(R.array.array_judul);
        ket = getResources().getStringArray(R.array.arary_ket);
        gambar = getResources().obtainTypedArray(R.array.array_logo);

        //lvAdapter adapter = new lvAdapter(this,judul,ket,gambar);
        lvAdapter adapter = new lvAdapter(this, judul, ket, gambar);
        lv.setAdapter(adapter);

        //Digunakan untuk berpindah activity saat pengguna memilih listview
        //Saat pengguna memilih urutan ke 1 (Array ke - 0) maka akan berpindah ke Profil
        //Saat pengguna memilih urutan ke 2 (Array ke - 1) maka akan berpindah ke Visi Misi
        //Saat pengguna memilih urutan ke 3 (Array ke - 2) maka akan berpindah ke Prestasi
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent j = new Intent(UtamaActivity.this, ProfilActivity.class);
                    startActivity(j);
                }
                else if (i == 1) {
                    Intent j = new Intent(UtamaActivity.this, VMActivity.class);
                    startActivity(j);
                }
                else if (i == 2) {
                    Intent j = new Intent(UtamaActivity.this, PrestasiActivity.class);
                    startActivity(j);
                }
            }
        });
    }
}

