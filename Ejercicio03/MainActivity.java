package com.cesar.dado;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgDado;
    Button btnLanzar;

    int[] dados = {
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5,
            R.drawable.dado6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDado = findViewById(R.id.imgDado);
        btnLanzar = findViewById(R.id.btnLanzar);

        btnLanzar.setOnClickListener(v -> lanzarDado());
    }

    private void lanzarDado() {
        Random random = new Random();
        Handler handler = new Handler();

        for (int i = 0; i < 10; i++) {
            int delay = i * 100;

            handler.postDelayed(() -> {
                int temp = random.nextInt(6);
                imgDado.setImageResource(dados[temp]);
            }, delay);
        }

        handler.postDelayed(() -> {
            int resultado = random.nextInt(6);
            imgDado.setImageResource(dados[resultado]);
        }, 1000);
    }
}