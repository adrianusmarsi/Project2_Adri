package com.example.project2_adri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Animation animasi;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imgLogo);
        animasi();
        
        //Handler untuk berpindah dari activity saat ini ke activity login
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Perintah Intent
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                
                //jalankan intent
                startActivity(intent);
                
                //selesai/tutup activity ini
                finish();
            }
            //Waktu 3000 ms atau 3 detik sebelum berpindah ke loginactivity
        }, 3000);
    }
    private void animasi(){
        animasi = AnimationUtils.loadAnimation(this,R.anim.splash_animasi);
        logo.startAnimation(animasi);
    }
}