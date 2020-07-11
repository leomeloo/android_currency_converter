package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        this.mViewHolder.editValue = findViewById(R.id.editReal);
        this.mViewHolder.valorDolar = findViewById(R.id.textValorDolar);
        this.mViewHolder.valorEuro = findViewById(R.id.textValorEuro);
        this.mViewHolder.btResult = findViewById(R.id.btResult);
        this.mViewHolder.editCotacaoDolar = findViewById(R.id.editCotacaoDolar);
        this.mViewHolder.editCotacaoEuro = findViewById(R.id.editCotacaoEuro);

        this.mViewHolder.btResult.setOnClickListener(this);
        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.valorDolar.setText("");
        this.mViewHolder.valorEuro.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btResult){
            String value = this.mViewHolder.editValue.getText().toString();
            String cotacaoDolar = this.mViewHolder.editCotacaoDolar.getText().toString();
            String cotacaoEuro = this.mViewHolder.editCotacaoEuro.getText().toString();
            if ("".equals(value) || "".equals(cotacaoDolar) || "".equals(cotacaoEuro))
                Toast.makeText(this, R.string.informe_valor, Toast.LENGTH_LONG).show();
            else{
                Double real = Double.valueOf(value);
                Double cotDolar = Double.valueOf(cotacaoDolar);
                Double cotEuro = Double.valueOf(cotacaoEuro);

                this.mViewHolder.valorDolar.setText(String.format("%.2f", (real / cotDolar)));
                this.mViewHolder.valorEuro.setText(String.format("%.2f", (real / cotEuro)));
            }
        }
    }

    private static class ViewHolder {
        EditText editValue;
        EditText editCotacaoDolar;
        EditText editCotacaoEuro;
        TextView valorDolar;
        TextView valorEuro;
        Button btResult;
    }
}
