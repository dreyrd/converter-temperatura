package com.example.convertertemperatura;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView textTemperatura;
    TextView textIcon;
    SeekBar qtdeTemperatura;
    ToggleButton medida;
    Button botaoConverter;
    Button botaoAjuda;
    String temperaturaIcon = "F";
    int temperatura = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textTemperatura = findViewById(R.id.textTemperatura);
         qtdeTemperatura = findViewById(R.id.qtdeTemperatura);
         medida = findViewById(R.id.medida);
         botaoConverter = findViewById(R.id.botaoConverter);
         botaoAjuda = findViewById(R.id.botaoAjuda);
         textIcon = findViewById(R.id.icon);

        qtdeTemperatura.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //textResultado.setText("onProgressChanged");
                temperatura = i;
                textTemperatura.setText("Temperatura: " + i + "°");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

        medida.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                temperaturaIcon = "C";
            } else {
                temperaturaIcon = "F";
            }
            textIcon.setText(temperaturaIcon);
        });

        botaoAjuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Help");
                builder.setMessage("Use o seekbar para definir a temperatura. Escolha entre Celsius e Fahrenheit. Clique em Converter para ver o resultado.");
                builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
                builder.show();
            }
        });


    }



    public void abrirToast(View view){

        String conversao;

        if (temperaturaIcon.equals("C")){

            conversao = ((temperatura * 9/5) + 35) + "°F";

        }
        else{
            conversao = ((temperatura - 35) * 5/9) + "°C";
        }

        Toast.makeText(
                getApplicationContext(),
                conversao,
                Toast.LENGTH_SHORT
        ).show();

    }

}