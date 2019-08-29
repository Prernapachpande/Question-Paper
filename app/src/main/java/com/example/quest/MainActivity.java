package com.example.quest;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quest.Jeeadvanced.JeeAdvanced;
import com.example.quest.Jeemain.MainJee;
import com.example.quest.Mhtcet.MainCet;
import com.example.quest.Neet.MainNeet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView jeemain = (ImageView) findViewById(R.id.rect2);
        jeemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(MainActivity.this, MainJee.class);
                startActivity(main);
            }
        });
        ImageView jeeadvanced = (ImageView) findViewById(R.id.rect3);
        jeeadvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adv = new Intent(MainActivity.this, JeeAdvanced.class);
                startActivity(adv);
            }
        });
        ImageView mhtcet = (ImageView) findViewById(R.id.rect4);
        mhtcet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent cet = new Intent(MainActivity.this, MainCet.class);
                startActivity(cet);
            }
        });
        ImageView neet = (ImageView) findViewById(R.id.rect5);
        neet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent neet = new Intent(MainActivity.this, MainNeet.class);
                startActivity(neet);
            }
        });
    }
}
