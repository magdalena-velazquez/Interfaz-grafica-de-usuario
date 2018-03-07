package mx.unam.aragon.fes.diplo.temperatura;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private View radioButton;
    private View radioButton2;
    private TextView txtVista;
    private SeekBar sBar;
    private TextView txtVista2;
    private Button convertir;
    private TextView txtVista3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton = findViewById(R.id.textView2);
        radioButton2 = findViewById(R.id.textView2);
        txtVista = findViewById(R.id.textView2);
        sBar = (SeekBar) findViewById(R.id.seekBar);
        txtVista2 = findViewById(R.id.textView2);
        convertir = findViewById(R.id.button);
        txtVista3 = findViewById(R.id.textView3);

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar sBar, int progress, boolean fromUser) {
                txtVista2.setText(String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar sBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar sBar) {

            }
        });

    }

    public double operacion() {
        double multiplicacion;
        double suma;
        multiplicacion = sBar.getProgress() * 1.8;
        suma = multiplicacion + 32;
        return suma;
    }

    public double operacion2() {
        double division;
        double resta;
        resta = sBar.getProgress() - 32;
        division = resta / 1.800;
        return division;
    }


    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton:
                if (marcado) {
                    txtVista.setText("Temperatura: " + sBar.getProgress() + " °C");
                    mostrarC(false);

                    convertir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txtVista3.setText(sBar.getProgress() + " °C :: " + operacion() + " °F");
                            txtVista3.setTextColor(Color.RED);
                        }
                    });
                }
                break;
            case R.id.radioButton2:
                if (marcado) {
                    txtVista.setText("Temperatura: " + sBar.getProgress() + "°F");
                    mostrarC(true);

                    convertir.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txtVista3.setText(sBar.getProgress() + " °F :: " + operacion2() + " °C");
                            txtVista3.setTextColor(Color.GREEN);
                        }
                    });
                }
                break;
            }
        }
    private void mostrarC(boolean b) {
        radioButton2.setVisibility(b ? View.VISIBLE : View.VISIBLE);
        radioButton.setVisibility(b ? View.VISIBLE : View.VISIBLE);
    }


}


