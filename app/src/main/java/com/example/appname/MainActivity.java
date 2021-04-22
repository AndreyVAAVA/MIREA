package com.example.appname;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText coeffA = findViewById(R.id.coeffA);
        EditText coeffB = findViewById(R.id.coeffB);
        EditText coeffC = findViewById(R.id.coeffC);
        TextView solution = findViewById(R.id.solution);
        Button getSolution = findViewById(R.id.getSolution);
        solution.setGravity(Gravity.CENTER);
        getSolution.setOnClickListener(v -> {
            String strCoeffA = coeffA.getText().toString();
            String strCoeffB = coeffB.getText().toString();
            String strCoeffC = coeffC.getText().toString();
            Integer a;
            Integer b;
            Integer c;
            try {
                a = Integer.valueOf(strCoeffA);
                b = Integer.valueOf(strCoeffB);
                c = Integer.valueOf(strCoeffC);
                if (a.equals(0) && b.equals(c))
                    solution.setText("Бесконечное множество решений");
                Double dbl_x_1;
                Double dbl_x_2;
                int x_1 = 0;
                int x_2 = 0;
                if ((-b - c) % a == 0) {
                    dbl_x_1 = (double) ((-b - c) / a);
                    x_1 = dbl_x_1.intValue();
                    if (((c - b) % a) == 0) {
                        dbl_x_2 = (double) ((c - b) / a);
                        x_2 = dbl_x_2.intValue();
                        if (x_1 == x_2)
                            solution.setText(x_1);
                        else
                            solution.setText(x_1 > x_2 ? x_2 + " " + x_1 : x_1 + " " + x_2);
                    }
                } else {
                    solution.setText("Нет решений");
                }
                if (c < 0)
                    solution.setText("Нет решений");
            } catch (Exception ex) {
                solution.setText("Ошибка ввода");
            }

        });
    }
}