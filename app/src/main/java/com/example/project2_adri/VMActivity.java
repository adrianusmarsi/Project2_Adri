package com.example.project2_adri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class VMActivity extends AppCompatActivity {
    //Deklarasikan TextView untuk menampung Visi, Misi dan Sasaran
    TextView tVisi, tMisi, tSasaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vmactivity);

        //hubungkan tVisi dengan tVisi pada desain
        tVisi = findViewById(R.id.tVisi);
        //hubungkan tMisi dengan tMisi pada desain
        tMisi = findViewById(R.id.tMisi);
        //hubungkan tSasaran dengan tSasaran pada desain
        tSasaran = findViewById(R.id.tSasaran);

        //Tampilkan isi dari file visi,misi dan sasaran
        //Jika menggunakan folder asset, maka perlu diserkatan extensinya
        //tVisi.setText(tampilFile(visi.txt));
        tVisi.setText(tampilFile("visi"));
        tMisi.setText(tampilFile("misi"));
        tSasaran.setText(tampilFile("sasaran"));
    }

    public String tampilFile(String fileName) {
        //text untuk menampung isi dari text
        //awalnya kosong
        String text = "";

        //Lakukan eror trap agar apabila error tidak menampilkan pesan kesalahan
        try {
            //apabila data pada folder raw gunakan koding ini
            //digunakan untuk membaca file yang diinginkan
            InputStream is = getResources().openRawResource(getResources().
                    getIdentifier(fileName, "raw", getPackageName()));
            /*
            apabila data pada folder assets gunakan koding ini
            InputStram is = getAssets().open(fileName);
             */
            //Menentukan ukuran dari file
            int size = is.available();
            byte[] buffer = new byte[size];
            //menyiapkan buffer sesuai ukuran file
            //menampung isi dari file ke buffer
            is.read(buffer);
            //tutup file
            is.close();
            //tampung data dari buffer ke variabel text
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //mengembalikan nilai dari variable text ke pemanggil
        return text;
    }
}