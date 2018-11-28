package com.example.jeanderson.appapresentacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //O código abaixo serve para configurar o meu ActionBar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.icone2);
        getSupportActionBar().setTitle("App Apresentação!");
        getSupportActionBar().setSubtitle("Sempre aprendendo mais!");
    }
}
