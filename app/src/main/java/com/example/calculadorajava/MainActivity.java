package com.example.calculadorajava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        TextView resultado = findViewById(R.id.resultado);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sumar(num1,num2,resultado);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    public void sumar(EditText num1, EditText num2, TextView resultado){
        try {
           String text1 = num1.getText().toString();
           float number1 = Float.parseFloat(text1);
           String text2 = num2.getText().toString();
           float number2 = Float.parseFloat(text2);
           float res = number1+number2;
           resultado.setText("Resultado:"+res);
       }catch (NumberFormatException e){
           resultado.setText("Ingrese números decimales o enteros para realizar la suma");
       }

    }



}