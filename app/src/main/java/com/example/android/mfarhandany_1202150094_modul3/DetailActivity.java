package com.example.android.mfarhandany_1202150094_modul3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dany on 25/02/2018.
 */

public class DetailActivity extends AppCompatActivity {
    private TextView Nminum, Pminum;
    private ImageView imgmenu;
    TextView jmlh;
    ImageView bat;
    Button btplus, btmin;
    int i = 1 ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        //inisiasi id yang sesuai

        Nminum = (TextView) findViewById(R.id.textView_nama);
        Pminum = (TextView) findViewById(R.id.textView_pMinum);
        jmlh = (TextView) findViewById(R.id.TextViewjumlah);
        imgmenu = (ImageView) findViewById(R.id.imageViewdetail);
        bat = (ImageView) findViewById(R.id.battray);
        btplus = (Button) findViewById(R.id.btnplus);
        btmin = (Button) findViewById(R.id.btnminus);


        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (bat.getDrawable().getLevel()+1<=3){
                    i= i + 1 ;
                    jmlh.setText(i + "L");
                    bat.setImageLevel(bat.getDrawable().getLevel()+1);
                }else { bat.setImageLevel(3);
                    Toast.makeText(DetailActivity.this, "sudah penuh", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bat.getDrawable().getLevel()-1>=0){
                    i = i - 1 ;
                    jmlh.setText(i + "L");
                    bat.setImageLevel(bat.getDrawable().getLevel()-1);
                }else { bat.setImageLevel(0);
                    Toast.makeText(DetailActivity.this, "tinggal sedikit", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Intent data = getIntent();
        String menu = data.getStringExtra("nama");
        String penminuman = data.getStringExtra("pminuman");
        Integer gmbr = data.getIntExtra("gambar", 0);

        Nminum.setText(menu);
        Pminum.setText(penminuman);
        imgmenu.setImageResource(gmbr);

    }

}
