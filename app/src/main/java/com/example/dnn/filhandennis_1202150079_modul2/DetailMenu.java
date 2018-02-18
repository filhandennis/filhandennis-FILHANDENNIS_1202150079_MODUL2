package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DetailMenu extends AppCompatActivity {

    //Attribut untuk menampung seluruh data
    private ArrayList<MenuModel> menus;
    //Attribut untuk identifikasi id pada menu
    private String idMenu;
    //Attibut Komponen View
    private TextView nama, harga, deskripsi;
    //Attribut Komponen gambar
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailmenu);

        //Inisialisasi Objek dari Komponen View
        nama = (TextView)findViewById(R.id.lblDetailNama);
        harga = (TextView)findViewById(R.id.lblDetailHarga);
        deskripsi = (TextView)findViewById(R.id.lblDetailDeskripsi);
        gambar = (ImageView) findViewById(R.id.lblDetailGambar);

        //Mengisi Data penampungan dengan data menuList yang ada di Class DaftarMenu
        menus = DaftarMenu.menuList;
        //Mengambil Intent
        Intent q = getIntent();
        //Mengambil id dari activity yang mengirimnya dan dimasukkan ke attribut idMenu
        idMenu = q.getStringExtra("MenuID");
        //Memberi log
        Log.d("DETAILED MENU","ID:"+idMenu);
        //Mengambil menu berdasarkan ID dan Index yang ada di menuList
        MenuModel menu = menus.get(Integer.parseInt(idMenu));
        //Set nama berdasarkan ID
        nama.setText(menu.getNama());
        //Set nama pada Action Bar
        setTitle(menu.getNama());
        //Set Harga berdasarkan ID
        harga.setText(""+ NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(menu.getHarga()) +",- / Porsi");
        //Set Deskripsi berdasarkan ID
        deskripsi.setText(menu.getDeskripsi());
        //Set Gambar berdasarkan ID
        gambar.setImageResource(menu.getGambar());
    }
}
