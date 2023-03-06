package br.edu.ifsp.dmos5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText pesoEditTExt;
    private EditText alturaEditText;
    private TextView result;
    private Button buttonImc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        pesoEditTExt = findViewById(R.id.editTextPesoId);
        alturaEditText = findViewById(R.id.editTextAlturaId);
        result = findViewById(R.id.textViewResult);
        buttonImc = findViewById(R.id.buttonImcId);
        buttonImc.setOnClickListener(view -> calcularImc());

    }
    public void calcularImc() {
        Double altura = getDouble(alturaEditText);
        Double peso = getDouble(pesoEditTExt);
        double imc;
        if (altura != 0 && peso != 0) {
            imc = peso / (altura * altura);
            result.setText(String.format("%s %.2f","IMC",imc));
        }
    }
    public Double getDouble (EditText text) {
        double retorno;
        try {
            retorno = Double.valueOf(text.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this,R.string.erroNumber,Toast.LENGTH_SHORT).show();
            retorno = 0.0;
        }
        return retorno;
    }
}