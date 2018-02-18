package com.example.dnn.filhandennis_1202150079_modul2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Attribut Class
    //Deklarasi Attribut untuk Object Komponen
    private RadioGroup radioGroup1;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inisialisasi Komponen ProgressBar
        pb=(ProgressBar)findViewById(R.id.progressBarMain);
        //Menghilangkan ProgressBar saat activity dibuat
        pb.setVisibility(View.INVISIBLE);
        //Inisialisasi Komponen RadioGroup
        radioGroup1 = (RadioGroup)findViewById(R.id.radioPilihMenu);
        //Mmebuat Toast untuk dijalankan saat activity dibuat
        Toast.makeText(this,"FILHAN DENNIS_1202150079",Toast.LENGTH_SHORT).show();
    }

    //Method yang digunakan untuk berpindah ke activity lain dengan menggunakan efek memunculkan progressbar saat tombol di klik
    public void goTo(View view){

        //Set progressbar untuk ditampilkan
        pb.setVisibility(View.VISIBLE);
        //Handler untuk mengatur barapa lama perintah akan dijalankan / Timer / Delay
        new Handler().postDelayed(new Runnable(){
            @Override
                public void run() {
                //Set progressbar untuk di sembunyikan lagi
                pb.setVisibility(View.INVISIBLE);
                //menjalankan method gogo untuk pindah ke activity lain dengan kondisi
                gogo();
            }
        }, 1000);

    }

    //Method yang digunakan untuk berpindah ke activity lain dengan melakukan pengecekan opsi dari user di radiogroup
    public void gogo(){
        //mengambil nilai dari opsi radio yang dipilih
        int go = radioGroup1.getCheckedRadioButtonId();
        //branching untuk opsi yang dipilih berdasarkan id komponennya
        switch (go){
            //jika takeawayradio dipilih
            case R.id.takeawayradio:
                //membuat toas
                Toast.makeText(this,"Take Away",Toast.LENGTH_SHORT).show();
                //berpindah ke activity takeaway
                startActivity(new Intent(this,Takeaway.class)); break;
            //jika dineinradio dipilih
            case R.id.dineinradio:
                //membuat toast
                Toast.makeText(this,"Dine In",Toast.LENGTH_SHORT).show();
                //berpindah ke activity dine in
                startActivity(new Intent(this,Dinein.class)); break;
            default:break;
        }
    }
}
