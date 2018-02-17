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

    private RadioGroup radioGroup1;
    private ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb=(ProgressBar)findViewById(R.id.progressBarMain);
        pb.setVisibility(View.INVISIBLE);
        radioGroup1 = (RadioGroup)findViewById(R.id.radioPilihMenu);
        Toast.makeText(this,"FILHAN DENNIS_1202150079",Toast.LENGTH_SHORT).show();
    }

    public void goTo(View view){

        pb.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable(){
            @Override
                public void run() {
                pb.setVisibility(View.INVISIBLE);
                gogo();
            }
        }, 1000);

    }

    public void gogo(){
        int go = radioGroup1.getCheckedRadioButtonId();
        switch (go){
            case R.id.takeawayradio:
                Toast.makeText(this,"Take Away",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Takeaway.class)); break;
            case R.id.dineinradio:
                Toast.makeText(this,"Dine In",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,Dinein.class)); break;
            default:break;
        }
    }
}
