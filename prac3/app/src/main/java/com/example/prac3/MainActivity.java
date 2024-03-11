package com.example.prac3;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_layout);

        TextView textView = findViewById(R.id.header);
        textView.setBackgroundColor(0xFFC1B6D3);
        textView.setTextColor(0xFF000000);
        textView.setText("mirea");


        TextView sunrise = findViewById(R.id.last);
        sunrise.setBackgroundColor(0xFFC1B6D3);
        sunrise.setTextColor(0xFF000000);


        TextView sunset = findViewById(R.id.object);
        sunset.setBackgroundColor(0xFFC1B6D3);
        sunset.setTextColor(0xFF000000);

        // переопределение параметров
        ConstraintLayout.LayoutParams layoutParamsTextView = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT, // Width
                        ConstraintLayout.LayoutParams.MATCH_CONSTRAINT); // Height

        layoutParamsTextView.verticalWeight = 1;

        // добавление новых параметров к уже существующим
        ConstraintLayout.LayoutParams layoutParamsSunrise =
                (ConstraintLayout.LayoutParams) sunrise.getLayoutParams();

        // добавление новых параметров к уже существующим
        ConstraintLayout.LayoutParams layoutParamsSunset =
                (ConstraintLayout.LayoutParams) sunset.getLayoutParams();

        // добавление новых параметров к уже существующим
//        ConstraintLayout.LayoutParams layoutParamsTextView =
//                (ConstraintLayout.LayoutParams) textView.getLayoutParams();


        // получаем значения в DP, чтобы использовать в setMargins()
        int margin60InDP = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 60, getResources().getDisplayMetrics());

        int margin20InDP = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());

        layoutParamsTextView.setMargins(
                margin60InDP,
                margin20InDP,
                margin60InDP,
                margin20InDP); // установка внешних отступов

        layoutParamsSunrise.setMargins(
                margin60InDP,
                margin20InDP,
                margin60InDP,
                margin20InDP); // установка внешних отступов


        layoutParamsTextView.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParamsTextView.bottomToTop = sunset.getId();
        layoutParamsTextView.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParamsTextView.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;



        layoutParamsTextView.verticalBias = 0.5f; // установка сдвига по вертикали



        textView.setLayoutParams(layoutParamsTextView);
        sunrise.setLayoutParams(layoutParamsSunrise);
        sunset.setLayoutParams(layoutParamsSunset);
    }
}