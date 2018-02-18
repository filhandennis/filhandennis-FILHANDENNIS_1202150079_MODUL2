package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        //Referensi: https://stackoverflow.com/questions/5486789/how-do-i-make-a-splash-screen
        //Handler untuk mengatur berapa lama perintah didalamnya akan dijalankan (Delay)
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //Pindah ke MainActivity
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //Menutup Activity Ini
                finish();
            }
        }, 5000);
    }
}
