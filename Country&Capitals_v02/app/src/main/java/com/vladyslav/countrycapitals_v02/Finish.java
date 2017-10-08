package com.vladyslav.countrycapitals_v02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.vladyslav.countrycapitals_v01.R;


public class Finish extends AppCompatActivity {

   TextView text_correctAnsw; //объявляем текст вью
   TextView text_wrongAnsw;
   TextView text_percent; //***

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);

        Bundle extras = getIntent().getExtras();
        Integer variant = extras.getInt("key");

        Bundle extras3 = getIntent().getExtras();
        Integer quantityQ = extras3.getInt("keyQuantityQ");

        text_correctAnsw = (TextView) findViewById(R.id.text_correctAnsw); //Находим кнопки
        text_wrongAnsw = (TextView) findViewById(R.id.text_wrongAnsw);
        text_percent = (TextView) findViewById(R.id.text_percent); //***

        Bundle extras1 = getIntent().getExtras(); //объявленяем Bundle и создаем объект extras1
        int correct = extras1.getInt("counterOfCorrectAsnw"); //записываем значение переменной correctAnsw в переменную correct по ключю counterOfCorrectAsnw

        Bundle extras2 = getIntent().getExtras(); //объявленяем Bundle и создаем объект extras2
        int wrong = extras2.getInt("counterOfWrongAsnw"); //записываем значение переменной wrongAnsw в переменную wrong по ключю counterOfWrongAsnw

        int percent = correct * 100 / quantityQ; //расчет правильных ответов в процентном соотношении
        //if(wrong > correct) //если неправильных ответов больше, чем правильных, то прогресс 0%
            //percent = 0;
        int percent2 = 100 - (wrong / quantityQ * 100); //расчет правильных ответов в процентном соотношении


         //присваиваем текст текущему текст вью
        text_wrongAnsw.setText("Неправильные ответы: " + wrong);
        /*if(variant == 0){
            text_percent.setText("Ты крут на: " + quantityQ + "%"); //***
        }
        */
        if(variant == 1){
            text_correctAnsw.setText("Правильне ответы: " + correct);
            text_percent.setText("Ты крут на: " + percent + "%"); //***
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemStartOver:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
