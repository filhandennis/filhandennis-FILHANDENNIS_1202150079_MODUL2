package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * MenuListAdapter merupakan Class yang bertanggung jawab untuk mengatur komponen Data
 * yang akan digunakan pada RecyclerView
 * https://medium.com/@dimas_vm/tutorial-android-recyclerview-dan-cardview-9a62aaa6cc0c
 */

//Extends RecyclerView.Adapter<Object>
public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder>{

    //Class ViewHolder extend RecyclerVie.ViewHolder untuk mendeskripsikan rincian item
    class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView lblNama,lblHarga,lblID;
        private ImageView lblGambar;

        public MenuViewHolder(View itemView) {
            super(itemView);
            lblID = (TextView)itemView.findViewById(R.id.lblListID);
            lblNama = (TextView)itemView.findViewById(R.id.lblListNama);
            lblHarga = (TextView)itemView.findViewById(R.id.lblListHarga);
            lblGambar = (ImageView)itemView.findViewById(R.id.lblListGambar);
        }
    }

    //Membuat List Data
    private ArrayList<MenuModel> dataList;

    //Membuat Contructor untuk memasukkan daftar data nanti pada RecyclerView
    public MenuListAdapter(ArrayList<MenuModel> list) {
        //Mengisi Daftar Data
        this.dataList = list;
        //Memberitahukan berapa banyak item dalam list
        Log.d("Jumlah Menu","Size: "+getItemCount());
    }

    //Extends dari RecyclerView.Adapter :bagaimana bentuk item recyclerview
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemmenulist, parent, false);
        return new MenuViewHolder(view);
    }

    //Extends dari RecyclerView.Adapter :apa yang dapat dilakukan oleh item recyclerview
    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        //Setting Nilai Komponen View berdasarkan tiap item data yang berada didalam list data
        holder.lblID.setText(""+position);
        holder.lblNama.setText(dataList.get(position).getNama());
        holder.lblHarga.setText(""+ NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(dataList.get(position).getHarga()));
        holder.lblGambar.setImageResource(dataList.get(position).getGambar());
        //Saat item data di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String idx untuk mengambil data lblID yang nantinya akan dikirimkan ke Activity DetailMenu
                //sebagai identitas data
                String idx = holder.lblID.getText().toString();
                Log.d("ItemMenuCLICKED","ID:"+idx);
                //Membuat Toast
                Toast.makeText(v.getContext(), "Memilih Menu '"+dataList.get(Integer.parseInt(idx)).getNama()+"'", Toast.LENGTH_SHORT).show();
                //Membuat Intent dengan tujuan ke DetailMenu
                Intent i = new Intent(v.getContext().getApplicationContext(), DetailMenu.class);
                //Mengirim data
                i.putExtra("MenuID",""+idx);
                //Pindah ke Intent Lain
                v.getContext().startActivity(i);

            }
        });
    }

    //Extends dari RecyclerView.Adapter :menghitung banyak data dalam list
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

}
