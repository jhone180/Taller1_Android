package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button botonCalcular;
    EditText editNum1;
    EditText editNum2;
    String textNum1;
    String textNum2;
    int num1;
    int num2;
    int resultadoSuma;
    int resultadoMultiplicacion;
    TextView viewSuma;
    TextView viewMultiplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCalcular = findViewById(R.id.buttonCalcular);
        editNum1 = findViewById(R.id.num1);
        editNum2 = findViewById(R.id.num2);
        viewSuma = findViewById(R.id.viewSuma);
        viewMultiplicacion = findViewById(R.id.viewMultiplicacion);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calculadora calcular = new Calculadora();
                num1 = getIntNum(editNum1);
                num2 = getIntNum(editNum2);
                resultadoSuma = calcular.suma(num1, num2);
                resultadoMultiplicacion = calcular.multiplicacion(num1, num2);
                String textSuma = getStringNum(resultadoSuma);
                String textMultiplicacion = getStringNum(resultadoMultiplicacion);
                viewSuma.setText(textSuma);
                viewMultiplicacion.setText(textMultiplicacion);
            }
        });


    }

    public int getIntNum(EditText editNum1){
        textNum1 = editNum1.getText().toString();
        num1 = Integer.parseInt(textNum1);
        return num1;
    }

    public String getStringNum(int resultOperacion){
        String textOperacion = String.valueOf(resultOperacion);
        return  textOperacion;
    }
}