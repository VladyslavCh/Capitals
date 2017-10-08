package com.vladyslav.countrycapitals_v02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.vladyslav.countrycapitals_v01.R;

import java.util.ArrayList;
import java.util.Collections;

public class Country extends AppCompatActivity implements View.OnClickListener {

    TextView tvCountry; //Объявляем текст вью

    Button btnVersion1; //Объявляем кнопки
    Button btnVersion2;
    Button btnVersion3;
    Button btnVersion4;
    Button btnLink; //***

    int correctAnsw; //объявляем счетчик правильных ответов
    int wrongAnsw; //объявляем счетчик неправильных ответов
    int quantityQ;
    int variant;
    int start;
    int end;
    int incrementQ;
    boolean ans;

    ArrayList<String[]> qaArr = new ArrayList<>(); //объявляем ArrayList и создаем объект qaArr
    ArrayList<String> linkArr = new ArrayList<>(); //объявляем ArrayList и создаем объект linkArr
    ArrayList<Integer> randQuestions = new ArrayList<>();
    ArrayList<Integer> randAnswers = new ArrayList<>();

    //private int counter; //объявляем счатчик перехода по ArrayList
    //private int counterLink; //объявляем счатчик перехода по ArrayList
    //private int gen; //объявляем счатчик перехода по ArrayList

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country);

        Bundle extras = getIntent().getExtras();
        variant = extras.getInt("key");

        Bundle extras1 = getIntent().getExtras(); //объявленяем Bundle и создаем объект extras1
        start = extras1.getInt("startBusting"); //записываем значение переменной start в переменную entrance по ключю startBusting

        Bundle extras2 = getIntent().getExtras(); //объявленяем Bundle и создаем объект extras2
        end = extras2.getInt("endBusting"); //записываем значение переменной end в переменную exit по ключю endBusting


        for (int i = start; i < end; i++) {
            randQuestions.add(new Integer(i));
        }
        Collections.shuffle(randQuestions);

        for (int j = 1; j < 5; j++) {
            randAnswers.add(new Integer(j));
        }

        tvCountry = (TextView) findViewById(R.id.tvCountry); //Находим элементы вью
        btnVersion1 = (Button) findViewById(R.id.btnVersion1);
        btnVersion2 = (Button) findViewById(R.id.btnVersion2);
        btnVersion3 = (Button) findViewById(R.id.btnVersion3);
        btnVersion4 = (Button) findViewById(R.id.btnVersion4);
        btnLink = (Button) findViewById(R.id.btnLink); //***

        btnVersion1.setOnClickListener(this); //Назначаем кнопкам обработчик
        btnVersion2.setOnClickListener(this);
        btnVersion3.setOnClickListener(this);
        btnVersion4.setOnClickListener(this);
        btnLink.setOnClickListener(this); //***


        switch (variant) {
            case 0:
                btnLink.setVisibility(View.VISIBLE);
                break;
            case 1:
                btnLink.setVisibility(View.INVISIBLE);
                break;
        }

        //0 - 4 - Europe
        //5 - 9 - Asia
        //10 - 14 - North America
        //15 - 19 - South America
        //20 - 24 - Africa
        //25 - 29 - Australia
        //0 - 29 - All countries

        qaArr.add(new String[]{"Украина", "Варшава", "Минск", "Киев", "Львов", "Киев"}); // countries of Europe
        qaArr.add(new String[]{"Польша", "Краков", "Гданьск", "Минск", "Варшава", "Варшава"});
        qaArr.add(new String[]{"Австрия", "Милан", "Вена", "Барселона", "Зальцбург", "Вена"});
        qaArr.add(new String[]{"Норвегия", "Осло", "Мадрид", "Берген", "Рим", "Осло"});
        qaArr.add(new String[]{"Беларусь", "Браслав", "Брест", "Минск", "Львов", "Минск"});//***

        qaArr.add(new String[]{"Турция", "Алания", "Стамбул", "Анталия", "Анкара", "Анкара"}); // countries of Asia
        qaArr.add(new String[]{"Китай", "Пекин", "Шанхай", "Шэньчжэнь", "Гуанчжоу", "Пекин"});
        qaArr.add(new String[]{"Россия", "Сочи", "Владивосток", "Москва", "Санкт-Петербург", "Москва"});
        qaArr.add(new String[]{"Япония", "Киото", "Токио", "Пекин", "Осака", "Токио"});
        qaArr.add(new String[]{"Израиль", "Иерусалим", "Эйлат", "Назарет", "Тель-Авив", "Иерусалим"});//***

        qaArr.add(new String[]{"Канада", "Торонто", "Ванкувер", "Монреаль", "Оттава", "Оттава"}); // countries of North America
        qaArr.add(new String[]{"Мексика", "Канкун", "Мехико", "Пуэрто-Вальярта", "Плайя-дель-Кармен", "Мехико"});
        qaArr.add(new String[]{"США", "Нью-Йорк", "Чикаго", "Вашингтон", "Лос-Анджелес", "Вашингтон"});
        qaArr.add(new String[]{"Сальвадор", "Сучитото", "Сан-Мигель", "Сан-Сальвадор", "Санта-Ана", "Сан-Сальвадор"});
        qaArr.add(new String[]{"Никарагуа", "Манагуа", "Леон", "Гранада", "Ометепе", "Манагуа"});//***


        qaArr.add(new String[]{"Аргентина", "Кордова", "Росарио", "Буэнос-Айрес", "Сальта", "Буэнос-Айрес"}); // countries of South America
        qaArr.add(new String[]{"Бразилия", "Рио-де-Жанейро", "Сальвадор", "Сан-Паулу", "Бразилиа", "Бразилиа"});
        qaArr.add(new String[]{"Чили", "Сантьяго", "Вальпараисо", "Пунта-Аренас", "Сан-Педро-де-Атакама", "Сантьяго"});
        qaArr.add(new String[]{"Колумбия", "Богота", "Картахена", "Медельин", "Санта-Марта", "Богота"});
        qaArr.add(new String[]{"Эквадор", "Salinas", "Кито", "Гуаякиль", "Галапагос", "Кито"});//***

        qaArr.add(new String[]{"Алжир", "Tamanrasset", "Алжир", "Оран", "Анаба", "Алжир"}); // countries of Africa
        qaArr.add(new String[]{"Египет", "Шарм-эль-Шейх", "Хургада", "Каир", "Люксор", "Каир"});
        qaArr.add(new String[]{"Мадагаскар", "Антананариву", "Анциранана", "Туамасина", "Antsirabe", "Антананариву"});
        qaArr.add(new String[]{"Гвинея", "Канкан", "Боке", "Киндиа", "Конакри", "Конакри"});
        qaArr.add(new String[]{"Нигерия", "Аба", "Кано", "Лагос", "Абуджа", "Абуджа"});//***

        qaArr.add(new String[]{"Австралия", "Сидней", "Канберра", "Перт", "Мельбурн", "Канберра"}); // countries of Australia
        qaArr.add(new String[]{"Вануату", "Люганвиль", "Меле", "Порт-Вила", "Люксор", "Порт-Вила"});
        qaArr.add(new String[]{"Кирибати", "Южная Тарава", "Тубаран", "Бутаритари", "Табангетуа", "Южная Тарава"});
        qaArr.add(new String[]{"Новая Зеландия", "Люганвиль", "Меле", "Порт-Вила", "Веллингтон", "Веллингтон"});
        qaArr.add(new String[]{"Фиджи", "Мельбурн", "Перт", "Сува", "Сидней", "Сува"});//***

        linkArr.add("https://en.wikipedia.org/wiki/Kiev");// countries of Europe
        linkArr.add("https://en.wikipedia.org/wiki/Warsaw");
        linkArr.add("https://en.wikipedia.org/wiki/Vienna");
        linkArr.add("https://en.wikipedia.org/wiki/Oslo");
        linkArr.add("https://en.wikipedia.org/wiki/Minsk"); //***

        linkArr.add("https://en.wikipedia.org/wiki/Ankara");// countries of Asia
        linkArr.add("https://en.wikipedia.org/wiki/Beijing");
        linkArr.add("https://en.wikipedia.org/wiki/Moscow");
        linkArr.add("https://en.wikipedia.org/wiki/Tokyo");
        linkArr.add("https://en.wikipedia.org/wiki/Jerusalem"); //***

        linkArr.add("https://en.wikipedia.org/wiki/Ottawa");// countries of North America
        linkArr.add("https://en.wikipedia.org/wiki/Mexico");
        linkArr.add("https://en.wikipedia.org/wiki/Washington");
        linkArr.add("https://en.wikipedia.org/wiki/San_Salvador");
        linkArr.add("https://en.wikipedia.org/wiki/Managua"); //***

        linkArr.add("https://en.wikipedia.org/wiki/Buenos_Aires");// countries of South America
        linkArr.add("https://en.wikipedia.org/wiki/Brasilia");
        linkArr.add("https://en.wikipedia.org/wiki/Santiago");
        linkArr.add("https://en.wikipedia.org/wiki/Bogota");
        linkArr.add("https://en.wikipedia.org/wiki/Quito"); //***

        linkArr.add("https://en.wikipedia.org/wiki/Algeria");// countries of Africa
        linkArr.add("https://en.wikipedia.org/wiki/Cairo");
        linkArr.add("https://en.wikipedia.org/wiki/Antananarivo");
        linkArr.add("https://en.wikipedia.org/wiki/Conakry");
        linkArr.add("https://en.wikipedia.org/wiki/Abuja"); //***

        linkArr.add("https://en.wikipedia.org/wiki/Canberra");// countries of Australia
        linkArr.add("https://en.wikipedia.org/wiki/Port_Vila");
        linkArr.add("https://en.wikipedia.org/wiki/South_Tarawa");
        linkArr.add("https://en.wikipedia.org/wiki/Wellington");
        linkArr.add("https://en.wikipedia.org/wiki/Suva"); //***

        //counter = start; //приравниваем переданное значение из другого активити к счетчику перебора
        //counterLink = start; //приравниваем переданное значение из другого активити к счетчику перебора
        setQuestionData(); //инициализируем вопрос и ответы

        /*for (int i=counter; i<exit; i++) {
            rand.add(new Integer(i));
        }
        Collections.shuffle(rand);*/

    }


    private void setQuestionData() {
        ans =false;
        Collections.shuffle(randAnswers);

        tvCountry.setText(qaArr.get(randQuestions.get(incrementQ))[0]); //страна
        btnVersion1.setText(qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(0)]); //столица1
        btnVersion2.setText(qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(1)]); //столица2
        btnVersion3.setText(qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(2)]); //столица3
        btnVersion4.setText(qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(3)]); //столица4
    }

    /*private void setQuestionData() {
        tvCountry.setText(qaArr.get(rand.get(gen))[0]); //страна
        btnVersion1.setText(qaArr.get(rand.get(gen))[1]); //столица1
        btnVersion2.setText(qaArr.get(rand.get(gen))[2]); //столица2
        btnVersion3.setText(qaArr.get(rand.get(gen))[3]); //столица3
        btnVersion4.setText(qaArr.get(rand.get(gen))[4]); //столица4
    }*/

    /*private void setQuestionData() {
        tvCountry.setText(qaArr.get(counter)[0]); //страна
        btnVersion1.setText(qaArr.get(counter)[1]); //столица1
        btnVersion2.setText(qaArr.get(counter)[2]); //столица2
        btnVersion3.setText(qaArr.get(counter)[3]); //столица3
        btnVersion4.setText(qaArr.get(counter)[4]); //столица4
    }*/


    @Override
    public void onClick(View v) { //обработчик

        String answer = ""; //объявляем отвтет
        switch (v.getId()) {
            case R.id.btnVersion1:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(0)];
                break;
            case R.id.btnVersion2:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(1)];
                break;
            case R.id.btnVersion3:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(2)];
                break;
            case R.id.btnVersion4:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(3)];
                break;
        }

        if (qaArr.get(randQuestions.get(incrementQ))[5].equals(answer)) {
            ans = true;
            correctAnsw++;
            start++;
            incrementQ++;
        } else if (v.getId() == R.id.btnLink) {
            Intent link = new Intent(Intent.ACTION_VIEW, Uri.parse(linkArr.get(randQuestions.get(incrementQ))));
            startActivity(link);
        } else {
            wrongAnsw++;
            if(variant == 0) {
                Toast toast = Toast.makeText(this, "ошибка", Toast.LENGTH_SHORT); //при неверном ответе вывод fail
                toast.setGravity(Gravity.BOTTOM, 0, 0); //вывод текста ниже кнопки, по центру
                toast.show();
            }
            if(variant == 1) {
                start++;
                incrementQ++;
            }
        }
        quantityQ++;

        if (start < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
            if(variant == 0 && ans && v.getId() != R.id.btnLink){
                setQuestionData();
            }
            if(variant == 1){
                setQuestionData();
            }
        } else {
            Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
            intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
            intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
            intent.putExtra("key", variant);
            intent.putExtra("keyQuantityQ", quantityQ);
            startActivity(intent);
        }
    }
}
       /* String answer = ""; //объявляем отвтет
        switch (v.getId()) {
            case R.id.btnVersion1:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(0)];
                break;
            case R.id.btnVersion2:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(1)];
                break;
            case R.id.btnVersion3:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(2)];
                break;
            case R.id.btnVersion4:
                answer = qaArr.get(randQuestions.get(incrementQ))[randAnswers.get(3)];
                break;
        }
        if (qaArr.get(randQuestions.get(incrementQ))[5].equals(answer)) { //если ответ нажатой кнопки ровняется правильному ответу, то...

            if (variant == 0) {
                correctAnsw++; //...прибавляем правильный ответ
                start++;
                incrementQ++; //переход к следующему вопросу
            }

            if (variant == 1) {
                correctAnsw++;
                start++;
                incrementQ++;
                quantityQ++; //счетчк ответов
            }

            if (start < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
                setQuestionData();
            } else {
                Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
                intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
                //intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
                intent.putExtra("key", variant);
                intent.putExtra("keyQuantityQ", quantityQ);
                startActivity(intent);
            }
        }else{

            if (variant == 0) {
                wrongAnsw++; //...прибавляем правильный ответ
                Toast toast = Toast.makeText(this, "fail", Toast.LENGTH_SHORT); //при неверном ответе вывод fail
                toast.setGravity(Gravity.BOTTOM, 0, 0); //вывод текста ниже кнопки, по центру
                toast.show();
            }

            if (variant == 1) {
                wrongAnsw++;
                start++;
                incrementQ++;
                quantityQ++; //счетчк ответов
                if (start < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
                    setQuestionData();
                } else {
                    Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
                    //intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
                    intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
                    intent.putExtra("key", variant);
                    intent.putExtra("keyQuantityQ", quantityQ);
                    startActivity(intent);
                }
            }


        }
*/
/*


        } else if (v.getId() == R.id.btnLink) {
            Intent link = new Intent(Intent.ACTION_VIEW, Uri.parse(linkArr.get(counterLink)[0]));
            startActivity(link);
        } else {
            if (variant == 0) {
                Toast toast = Toast.makeText(this, "fail", Toast.LENGTH_SHORT); //при неверном ответе вывод fail
                toast.setGravity(Gravity.BOTTOM, 0, 0); //вывод текста ниже кнопки, по центру
                toast.show();
            }
            if (variant == 1) {
                counter++;
                gen++;
            }



            wrongAnsw++; //если ответ нажатой кнопки не ровняется правильному ответу, то...прибавляем неправильный ответ
        }

        */





        /*if (variant == 1) {
            counter++;
            gen++;
        }*/

            //counter++; если это тест, то переход на след вопрос, даже если ответ - неверный

        /*if (counter < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
            setQuestionData();
        } else {
            Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
            intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
            intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
            intent.putExtra("key", variant);
            intent.putExtra("keyQuantityQ", quantityQ);
            startActivity(intent);
        }*/

























        /*String answer = ""; //объявляем отвтет
        switch (v.getId()) {
            case R.id.btnVersion1:
                answer = qaArr.get(rand.get(gen))[randQ.get(0)];
                break;
            case R.id.btnVersion2:
                answer = qaArr.get(rand.get(gen))[randQ.get(1)];
                break;
            case R.id.btnVersion3:
                answer = qaArr.get(rand.get(gen))[randQ.get(2)];
                break;
            case R.id.btnVersion4:
                answer = qaArr.get(rand.get(gen))[randQ.get(3)];
                break;
        }
        if (qaArr.get(rand.get(gen))[5].equals(answer)) { //если ответ нажатой кнопки ровняется правильному ответу, то...
            correctAnsw++; //...прибавляем правильный ответ
            if (variant == 0) {
                counter++;
                gen++; //переход к следующему вопросу
            }
            counterLink++;



            if (counter < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
                setQuestionData();
            } else {
                Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
                intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
                intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
                intent.putExtra("key", variant);
                intent.putExtra("keyQuantityQ", quantityQ);
                startActivity(intent);
            }






        } else if (v.getId() == R.id.btnLink) {
            Intent link = new Intent(Intent.ACTION_VIEW, Uri.parse(linkArr.get(counterLink)[0]));
            startActivity(link);
        } else {
            if (variant == 0) {
                Toast toast = Toast.makeText(this, "fail", Toast.LENGTH_SHORT); //при неверном ответе вывод fail
                toast.setGravity(Gravity.BOTTOM, 0, 0); //вывод текста ниже кнопки, по центру
                toast.show();
            }
            if (variant == 1) {
                counter++;
                gen++;
            }



            wrongAnsw++; //если ответ нажатой кнопки не ровняется правильному ответу, то...прибавляем неправильный ответ
        }

        quantityQ++; //счетчк ответов*/




        /*if (variant == 1) {
            counter++;
            gen++;
        }*/

            //counter++; если это тест, то переход на след вопрос, даже если ответ - неверный

        /*if (counter < end) { //если счетчик перехода вопроса не заполнен, то следующий вопрос
            setQuestionData();
        } else {
            Intent intent = new Intent(getApplicationContext(), Finish.class); //иначе переход в другое активити Finish и передаем переменную
            intent.putExtra("counterOfCorrectAsnw", correctAnsw); //назначаем ключ первой переменной
            intent.putExtra("counterOfWrongAsnw", wrongAnsw); //назначаем ключ второй переменной
            intent.putExtra("key", variant);
            intent.putExtra("keyQuantityQ", quantityQ);
            startActivity(intent);
        }*/


