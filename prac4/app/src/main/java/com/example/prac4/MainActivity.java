package com.example.prac4;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получение айди view, для использования с помощью переменных
        TextView hello = findViewById(R.id.hello);
        TextView linearLayout = findViewById(R.id.linear_layout);
        TextView time = findViewById(R.id.time);

        // Форматирование для вывода 00:00
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String currentTime = now.format(formatter);

        // Передача времени в textView
        String timeMessage = getString(R.string.time, currentTime);
        time.setText(timeMessage);

        // Получение существующих параметров view из layout
        LinearLayout.LayoutParams layoutParamsHello =
                (LinearLayout.LayoutParams) hello.getLayoutParams();

        LinearLayout.LayoutParams layoutParamsLinearLayout =
                (LinearLayout.LayoutParams) linearLayout.getLayoutParams();

        LinearLayout.LayoutParams layoutParamsTime =
                (LinearLayout.LayoutParams) time.getLayoutParams();

        // Добавление параметра gravity к существующим параметрам
        hello.setGravity(Gravity.CENTER);
        linearLayout.setGravity(Gravity.CENTER);
        time.setGravity(Gravity.CENTER);

        // Установка обновленных параметров
        hello.setLayoutParams(layoutParamsHello);
        linearLayout.setLayoutParams(layoutParamsLinearLayout);
        time.setLayoutParams(layoutParamsTime);



        // Добавление параметров в ImageView
        ImageView myDog = findViewById(R.id.my_dog);

        // Получение существующих параметров view из layout
        RelativeLayout.LayoutParams myDogLayoutParams =
                (RelativeLayout.LayoutParams) myDog.getLayoutParams();

        // Добавление параметров
        myDogLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        myDog.setImageResource(R.drawable.maik);
        myDog.setRotation(90);

        // Установка параметров
        myDog.setLayoutParams(myDogLayoutParams);



        Button gridButton = findViewById(R.id.grid_layout);

        GridLayout.LayoutParams gridLayoutParams =
                (GridLayout.LayoutParams) gridButton.getLayoutParams();

        gridLayoutParams.columnSpec = GridLayout.spec(0, 3);
        gridLayoutParams.rowSpec = GridLayout.spec(1);

        gridButton.setLayoutParams(gridLayoutParams);

    }
}