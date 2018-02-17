package com.example.dnn.filhandennis_1202150079_modul2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuListAdapter menuAdapter;

    public static ArrayList<MenuModel> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarmenu);

        menuList = isiMenu();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        menuAdapter = new MenuListAdapter(menuList);
        recyclerView.setAdapter(menuAdapter);
//        recyclerView.addOnItemTouchListener(new RecycleView.Item);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public ArrayList<MenuModel> isiMenu(){
        ArrayList<MenuModel> data = new ArrayList<>();
        //MenuModel(String nama, int harga, int gambar, String deskripsi)
        data.add(new MenuModel("Ayam Cabe Hijau", 22000, R.drawable.ampera_ayamcabeijo, "Ayam Cabe Hijau + Nasi"));
        data.add(new MenuModel("Ayam Bakar", 21273, R.drawable.ampera_ayambakar, "Ayam Bakar + Nasi"));
        data.add(new MenuModel("Dendeng", 14000, R.drawable.ampera_dendeng, "Dendeng + Nasi. daging yang dipotong tipis menjadi serpihan yang lemaknya dipangkas, dibumbui dengan saus asam, asin atau manis dengan dikeringkan dengan api kecil atau diasinkan dan dijemur"));
        data.add(new MenuModel("Lele Goreng", 14000, R.drawable.ampera_lelegoreng, "Lele Goreng + Nasi"));
        data.add(new MenuModel("Nila Goreng", 18040, R.drawable.ampera_nilagoreng, "Nila Goreng + Nasi"));
        data.add(new MenuModel("Pepes Ayam", 18182, R.drawable.ampera_pepesayam, "Pepes Ayam + Nasi. Olahan daging ayam yang dikukus dengan daun"));
        data.add(new MenuModel("Rendang", 19909, R.drawable.ampera_rendang, "Rendang + Nasi. masakan daging bercita rasa pedas yang menggunakan campuran dari berbagai bumbu dan rempah-rempah"));
        data.add(new MenuModel("Sayur Asem", 6363, R.drawable.ampera_sayurasem, "Sayur Asem + Nasi. makanan khas orang jawa ini cukup di kenal banyak orang, sayur asem biasanya di sebut juga dengan sayur bening"));
        return data;
    }
}
