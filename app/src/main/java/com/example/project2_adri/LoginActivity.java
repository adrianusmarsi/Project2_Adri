package com.example.project2_adri;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    //Deklarasi EditText untuk menghubungkan dengan eNim dan ePass
    EditText eNim,ePass;

    //Deklarasikan Button untuk menggabungkan dengan bLogin
    Button bLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Hubungkan Variable eNim dengan EditText eLoginNim
        eNim = findViewById(R.id.eLoginNim);

        //Hubungkan Variable ePass dengan EditText eLoginPass
        ePass = findViewById(R.id.eLoginPass);

        //Hubungkan Variable bLogin dengan Button bLogin
        bLogin = findViewById(R.id.bLogin);

        //Perintah pada saat menekan Tombol Login
        //Jalankan Fungsi btnLogin()
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnLogin();
            }
        });
    }

    public void btnLogin(){
        //Fungsi btnLogin untuk menampilkan pesan selamat datang
        //Validasi Password
        //Memberikan Peringatan apabila Password tidak sesuai

        //Deklarasikan String NIM untuk menampung data dari variabel eNim
        //Deklarasikan Sting Pass untuk menampung dara dari variable ePass
        String nim,pass;

        //Mengubah tipe data eNim menjadi string dan simpan variable nim
        nim = eNim.getText().toString();
        //Mengubah tipe data ePass menjadi string dan simpan variable pass
        pass = ePass.getText().toString();

        //Lakukan Validasi
        //Jika Pass benar, Maka Sistem akan menampilkan pesan selamat datang
        //dan berpindah ke UtamaActivity
        //Simpan data NIm
        //Jika Pass salah, Maka sistem akan menampilkan pesan Password salah

        if (pass.equals("232010081")){
            //Tampilkan Pesan Selamat Datang
            Toast.makeText(this,"Selamat Datang "+nim,Toast.LENGTH_LONG).show();
            //Deklarasikan intent untuk berpindah LoginActivity ke UtamaActivity
            Intent intent = new Intent(LoginActivity.this,UtamaActivity.class);

            //Simpan data nim ke nim
            intent.putExtra("nim",nim);

            //Jalankan Perintah intent
            startActivity(intent);
        } else {
            //Tamplkan Fungsi showDialog
            showDialog();
        }
    }
    public void showDialog(){
        //Membuat alertdialog/Pesan Kesalahan dengan nama pesanSalah
        AlertDialog.Builder pesanSalah = new AlertDialog.Builder(this);
        //Atur judul pesanSalah
        pesanSalah.setTitle("Error!!!");
        //Atur pesanSalah
        pesanSalah
                //Isi Pesan
                .setMessage("Maaf, Email atau Password Salah")
                //Icon
                .setIcon(R.drawable.error)
                //Tombol Ok
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = pesanSalah.create();
        //Tampilkan Pesan Kesalahan
        alertDialog.show();
    }
}