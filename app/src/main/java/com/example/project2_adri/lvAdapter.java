package com.example.project2_adri;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class lvAdapter extends ArrayAdapter {
    //Untuk menampung gambar dari array_logo_utama
    TypedArray array_logo;

    //Untuk menampung string dari array_judul_utama
    String[] array_judul;

    //Untuk menampung string dari array_ket_utama
    String[] array_ket;

    //Membuat Constructor yang menghubungkan variable/array dengan parameter
    public lvAdapter(Context context, String[] judul1, String[] ket1, TypedArray logo1){
        super(context, R.layout.listview_utama,R.id.idJudul,judul1);
        this.array_logo = logo1;
        this.array_judul = judul1;
        this.array_ket = ket1;
    }

    @NonNull
    @Override

    //Fungsi untuk menampilkan array berdasarkan posisi array
    public View getView (int pos, View convertView, ViewGroup parent){
        //Gunakan inflater yang berfungsi sebagai fragment dari activity untuk menampilkan data
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Tambahkan baris berdasarkan listview_utama
        View row = inflater.inflate(R.layout.listview_utama,parent,false);

        //Hubungan variable tampil_logo dengan idGambar pada listview_utama
        ImageView tampil_logo = row.findViewById(R.id.idGambar);
        //Hubungan variable tampil_logo dengan idKet pada listview_utama
        TextView tampil_judul = row.findViewById(R.id.idJudul);
        //Hubungan variable tampil_logo dengan idKet pada listview_utama
        TextView tampil_ket = row.findViewById(R.id.idKet);

        //Menampilkan gambar dari array_logo atau array_logo_utama
        tampil_logo.setImageResource(array_logo.getResourceId(pos,-1));
        //Menampilkan judul dari array_judul
        tampil_judul.setText(array_judul[pos]);
        //Menampilkan keterangan dari array_ket
        tampil_ket.setText(array_ket[pos]);
        return row;
    }
}
