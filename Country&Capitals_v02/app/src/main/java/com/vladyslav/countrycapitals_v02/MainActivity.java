package com.vladyslav.countrycapitals_v02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.vladyslav.countrycapitals_v01.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnStudying; //Объявляем кнопку
    Button btnTest; //Объявляем кнопку
    Button btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnStudying = (Button) findViewById(R.id.btnStudying); //Находим кнопку в xml макете
        btnTest = (Button) findViewById(R.id.btnTest); //Находим кнопку в xml макете
        btnAbout = (Button) findViewById(R.id.btnAbout); //Находим кнопку в xml макете

        btnStudying.setOnClickListener(this); //Назначаем кнопке обработчик кнопки
        btnTest.setOnClickListener(this); //Назначаем кнопке обработчик кнопки
        btnAbout.setOnClickListener(this); //Назначаем кнопке обработчик кнопки
    }

    @Override
    public void onClick(View v) { //Обработчик нажатия

        int variant;
        switch (v.getId()){
            case R.id.btnStudying: //при нажатии переходим в другое активити (Zone.class)
                variant = 0;
                Intent intent1 = new Intent(getApplicationContext(), Zone.class);
                intent1.putExtra("key", variant);
                startActivity(intent1);
                break;
            case R.id.btnTest:
                variant = 1;
                Intent intent2 = new Intent(getApplicationContext(), Zone.class);
                intent2.putExtra("key", variant);
                startActivity(intent2);
                break;
            case R.id.btnAbout:
                Intent intent3 = new Intent(this, AboutApp.class);
                startActivity(intent3);
                break;
        }
    }
}
