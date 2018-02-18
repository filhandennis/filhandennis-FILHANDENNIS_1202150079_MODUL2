package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Takeaway extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeaway);
    }

    //Method yang dijalankan saat tombol diklik
    //Digunakan untuk berpindah ke acitivy DaftarMenu
    public void selectMenu2(View view){
        //Pindah Activity
        startActivity(new Intent(this, DaftarMenu.class));
    }
}
