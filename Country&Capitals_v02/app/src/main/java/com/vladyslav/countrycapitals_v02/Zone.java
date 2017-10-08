package com.vladyslav.countrycapitals_v02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vladyslav.countrycapitals_v01.R;

public class Zone extends AppCompatActivity implements View.OnClickListener{

    int start = 0; //Объявляем переменные
    int end = 0; //***
    int variant = 0;

    Button btnEurope; //Объявляем кнопки
    Button btnAsia;
    Button btnNorthAmerica;
    Button btnSouthAmerica;
    Button btnAfrica;
    Button btnAustralia;
    Button btnAllCountries; //***

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zone);

        Bundle extras = getIntent().getExtras();
        Integer value = extras.getInt("key");

        btnEurope = (Button) findViewById(R.id.btnEurope); //Находим кнопки
        btnAsia = (Button) findViewById(R.id.btnAsia);
        btnNorthAmerica = (Button) findViewById(R.id.btnNorthAmerica);
        btnSouthAmerica = (Button) findViewById(R.id.btnSouthAmerica);
        btnAfrica = (Button) findViewById(R.id.btnAfrica);
        btnAustralia = (Button) findViewById(R.id.btnAustralia);
        btnAllCountries = (Button) findViewById(R.id.btnAllCountries); //***

        btnEurope.setOnClickListener(this); //Назначаем кнопкам обработчик
        btnAsia.setOnClickListener(this);
        btnNorthAmerica.setOnClickListener(this);
        btnSouthAmerica.setOnClickListener(this);
        btnAfrica.setOnClickListener(this);
        btnAustralia.setOnClickListener(this);
        btnAllCountries.setOnClickListener(this); //***

        variant = value;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEurope:
                start = 0; //начало перебоа стран
                end = 5; //конец перебора стран
                Intent intent1 = new Intent(getApplication(), Country.class); //переходим в другое активити Country и передаем переменную
                intent1.putExtra("startBusting", start); //назначаем ключ первой переменной
                intent1.putExtra("endBusting", end); //назначаем ключ второй переменной
                intent1.putExtra("key", variant);
                startActivity(intent1);
                break;
            case R.id.btnAsia:
                start = 5;
                end = 10;
                Intent intent2 = new Intent(getApplication(), Country.class);
                intent2.putExtra("startBusting", start);
                intent2.putExtra("endBusting", end);
                intent2.putExtra("key", variant);
                startActivity(intent2);
                break;
            case R.id.btnNorthAmerica:
                start = 10;
                end = 15;
                Intent intent3 = new Intent(getApplication(), Country.class);
                intent3.putExtra("startBusting", start);
                intent3.putExtra("endBusting", end);
                intent3.putExtra("key", variant);
                startActivity(intent3);
                break;
            case R.id.btnSouthAmerica:
                start = 15;
                end = 20;
                Intent intent4 = new Intent(getApplication(), Country.class);
                intent4.putExtra("startBusting", start);
                intent4.putExtra("endBusting", end);
                intent4.putExtra("key", variant);
                startActivity(intent4);
                break;
            case R.id.btnAfrica:
                start = 20;
                end = 25;
                Intent intent5 = new Intent(getApplication(), Country.class);
                intent5.putExtra("startBusting", start);
                intent5.putExtra("endBusting", end);
                intent5.putExtra("key", variant);
                startActivity(intent5);
                break;
            case R.id.btnAustralia:
                start = 25;
                end = 30;
                Intent intent6 = new Intent(getApplication(), Country.class);
                intent6.putExtra("startBusting", start);
                intent6.putExtra("endBusting", end);
                intent6.putExtra("key", variant);
                startActivity(intent6);
                break;
            case R.id.btnAllCountries:
                start = 0;
                end = 30;
                Intent intent7 = new Intent(getApplication(), Country.class);
                intent7.putExtra("startBusting", start);
                intent7.putExtra("endBusting", end);
                intent7.putExtra("key", variant);
                startActivity(intent7);//***
                break;
            default:
                break;
        }
    }
}
