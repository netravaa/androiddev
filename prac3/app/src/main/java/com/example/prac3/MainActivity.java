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


        TextView last = findViewById(R.id.last);
        last.setBackgroundColor(0xFFC1B6D3);
        last.setTextColor(0xFF000000);


        TextView object = findViewById(R.id.object);
        object.setBackgroundColor(0xFFC1B6D3);
        object.setTextColor(0xFF000000);

        // переопределение параметров
        ConstraintLayout.LayoutParams layoutParamsTextView = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT, // Width
                        ConstraintLayout.LayoutParams.MATCH_CONSTRAINT); // Height

        layoutParamsTextView.verticalWeight = 1;

        // добавление новых параметров к уже существующим
        ConstraintLayout.LayoutParams layoutParamsObject =
                (ConstraintLayout.LayoutParams) last.getLayoutParams();

        // добавление новых параметров к уже существующим
        ConstraintLayout.LayoutParams layoutParamsSunset =
                (ConstraintLayout.LayoutParams) object.getLayoutParams();

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

        layoutParamsObject.setMargins(
                margin60InDP,
                margin20InDP,
                margin60InDP,
                margin20InDP); // установка внешних отступов


        layoutParamsTextView.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParamsTextView.bottomToTop = last.getId();
        layoutParamsTextView.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
        layoutParamsTextView.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;



        layoutParamsTextView.verticalBias = 0.5f; // установка сдвига по вертикали



        textView.setLayoutParams(layoutParamsTextView);
        object.setLayoutParams(layoutParamsObject);
        last.setLayoutParams(layoutParamsObject);
    }
}