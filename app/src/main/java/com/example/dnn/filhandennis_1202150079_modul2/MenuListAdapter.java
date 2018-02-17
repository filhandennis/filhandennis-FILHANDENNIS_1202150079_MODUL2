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
 * Created by ASUS on 17/02/2018.
 * https://medium.com/@dimas_vm/tutorial-android-recyclerview-dan-cardview-9a62aaa6cc0c
 */

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder>{

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

    private ArrayList<MenuModel> dataList;

    public MenuListAdapter(ArrayList<MenuModel> list) {
        this.dataList = list;
        Log.d("Jumlah Menu","Size: "+getItemCount());
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.itemmenulist, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MenuViewHolder holder, final int position) {
        holder.lblID.setText(""+position);
        holder.lblNama.setText(dataList.get(position).getNama());
        holder.lblHarga.setText(""+ NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(dataList.get(position).getHarga()));
        holder.lblGambar.setImageResource(dataList.get(position).getGambar());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idx = holder.lblID.getText().toString();
                Log.d("ItemMenuCLICKED","ID:"+idx);
                Toast.makeText(v.getContext(), "Memilih Menu '"+dataList.get(Integer.parseInt(idx)).getNama()+"'", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext().getApplicationContext(), DetailMenu.class);
                i.putExtra("MenuID",""+idx);
                v.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

}
