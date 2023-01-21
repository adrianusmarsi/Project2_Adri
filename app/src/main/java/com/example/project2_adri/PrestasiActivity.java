package com.example.project2_adri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class PrestasiActivity extends AppCompatActivity {
    //Untuk menampung array judul prestasi
    String [] judulPrestasi;
    //Untuk menampung array isi prestasi
    String [] isiPrestasi;
    //Untuk menampung array gambar prestasi
    TypedArray gambarPrestasi;
    //Untuk button Previous dan Next
    ImageButton bPrev, bNext;
    //Untuk ImageSwitcher
    ImageSwitcher logoSwitcher;
    //untuk TextSwitcher judul dan isi
    TextSwitcher judulSwitcher, isiSwitcher;
    //posisi awal
    int posisi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestasi);

        //Menghubungkan dengan tombol next dan prev
        bNext = findViewById(R.id.bNext);
        bPrev = findViewById(R.id.bPrev);

        //Menghubungkan dengan imgPrestasi, tJudulPrestasi, dan tIsiPrestasi
        logoSwitcher = findViewById(R.id.ImgPrestasi);
        judulSwitcher = findViewById(R.id.tJudulPrestasi);
        isiSwitcher = findViewById(R.id.tIsiPrestasi);

        //dapatkan data judul dari array_prestasi_judul
        judulPrestasi = getResources().getStringArray(R.array.array_prestasi_judul);
        //dapatkan data isi dari array_prestasi_isi
        isiPrestasi = getResources().getStringArray(R.array.array_prestasi_isi);
        //dapatkan data logo dari array_prestasi_logo
        gambarPrestasi = getResources().obtainTypedArray(R.array.array_prestasi_logo);

        //digunakan untuk menampilkan text dari array ke JudulSwitcher
        judulSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView judulText = new TextView(getApplicationContext());
                return judulText;
            }
        });

        //digunakan untuk menampilkan text dari array ke isiSwitcher
        isiSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView isiText = new TextView(getApplicationContext());
                return isiText;
            }
        });

        //digunakan untuk menampilkan text dari array ke LogoSwitcher
        logoSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView logoImage = new ImageView(getApplicationContext());
                logoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return logoImage;
            }
        });

        //mengatur tombol next saat ditekan
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Jika posisi kurang dari banyaknya isi dari array judul
                maka posisi + 1
                tampilkan judul, isi, logo sesuai dengan posisi */
                if(posisi<judulPrestasi.length-1){
                    posisi = posisi+1;
                    judulSwitcher.setText(judulPrestasi[posisi]);
                    isiSwitcher.setText(isiPrestasi[posisi]);
                    logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi,-1));
                }
            }
        });

        //mengatur tombol prev/previous saat ditekan
        bPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Jika posisi lebih dari 0
                maka posisi - 1
                tampilkan judul, isi, logo sesuai dengan posisi */
                if(posisi>0){
                    posisi = posisi -1;
                    judulSwitcher.setText(judulPrestasi[posisi]);
                    isiSwitcher.setText(isiPrestasi[posisi]);
                    logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi,-1));
                }
            }
        });

        //menampilkan judul,isi,logo sesuai dengan posisi pertama kali
        judulSwitcher.setText(judulPrestasi[posisi]);
        isiSwitcher.setText(isiPrestasi[posisi]);
        logoSwitcher.setImageResource(gambarPrestasi.getResourceId(posisi, -1));
    }
}