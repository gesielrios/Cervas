package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import br.edu.febac.cervas.controller.BebidaComparator;
import br.edu.febac.cervas.model.Bebida;

public class MainActivity extends CervasBaseActivity {

    private EditText garrafaField;
    private EditText lataField;
    private EditText litraoField;
    private EditText latonaField;
    private EditText longneckField;
    private EditText barrilField;
    private EditText valorPersonalizada1Field;
    private EditText mlPersonalizada1Field;
    private EditText valorPersonalizada2Field;
    private EditText mlPersonalizada2Field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        garrafaField = (EditText) findViewById(R.id.valor_garrafa_field_main);
        lataField = (EditText) findViewById(R.id.valor_lata_field_main);

        litraoField = (EditText) findViewById(R.id.valor_litrao_field_main);
        latonaField = (EditText) findViewById(R.id.valor_latona_field_main);
        longneckField = (EditText) findViewById(R.id.valor_longneck_field_main);
        barrilField = (EditText) findViewById(R.id.valor_barril_field_main);

        valorPersonalizada1Field = (EditText) findViewById(R.id.valor_personalizado_1_field_main);
        mlPersonalizada1Field = (EditText) findViewById(R.id.ml_personalizado_1_field_main);
        valorPersonalizada2Field = (EditText) findViewById(R.id.valor_personalizado_2_field_main);
        mlPersonalizada2Field = (EditText) findViewById(R.id.ml_personalizado_2_field_main);

    }

    public void calcular(View view) {

        ArrayList<Bebida> bebidas = new ArrayList<>();

        String campoValorGarrafa = garrafaField.getText().toString();
        if (!campoValorGarrafa.isEmpty()) {
            BigDecimal valorGarrafa = new BigDecimal(campoValorGarrafa);
            bebidas.add(new Bebida("Garrafa", valorGarrafa, 600, R.drawable.garrafa));
        }

        String campoValorLata = lataField.getText().toString();
        if (!campoValorLata.isEmpty()) {
            BigDecimal valorLata = new BigDecimal(campoValorLata);
            bebidas.add(new Bebida("Lata", valorLata, 350, R.drawable.lata));
        }

        String campoValorLitrao = litraoField.getText().toString();
        if (!campoValorLitrao.isEmpty()) {
            BigDecimal valorLitrao = new BigDecimal(campoValorLitrao);
            bebidas.add(new Bebida("Litrão", valorLitrao, 1000, R.drawable.litrao));
        }

        String campoValorLatona = latonaField.getText().toString();
        if (!campoValorLatona.isEmpty()) {
            BigDecimal valorLatona = new BigDecimal(campoValorLatona);
            bebidas.add(new Bebida("Latona", valorLatona, 550, R.drawable.latona));
        }

        String campoValorLongNeck = longneckField.getText().toString();
        if (!campoValorLongNeck.isEmpty()) {
            BigDecimal valorLongNeck = new BigDecimal(campoValorLongNeck);
            bebidas.add(new Bebida("Long Neck", valorLongNeck, 355, R.drawable.longneck));
        }

        String campoValorBarril = barrilField.getText().toString();
        if (!campoValorBarril.isEmpty()) {
            BigDecimal valorBarril = new BigDecimal(campoValorBarril);
            bebidas.add(new Bebida("Barril", valorBarril, 5000, R.drawable.barril));
        }

        String campoValorPersonalizado1 = valorPersonalizada1Field.getText().toString();
        String campoMlPersonalizado1 = mlPersonalizada1Field.getText().toString();
        if (!campoValorPersonalizado1.isEmpty() && !campoMlPersonalizado1.isEmpty()) {
            BigDecimal valor = new BigDecimal(campoValorPersonalizado1);
            int ml = Integer.parseInt(campoMlPersonalizado1);
            bebidas.add(new Bebida("Personalizada 1", valor, ml, R.drawable.interrogacao));
        }

        String campoValorPersonalizado2 = valorPersonalizada2Field.getText().toString();
        String campoMlPersonalizado2 = mlPersonalizada2Field.getText().toString();
        if (!campoValorPersonalizado2.isEmpty() && !campoMlPersonalizado2.isEmpty()) {
            BigDecimal valor = new BigDecimal(campoValorPersonalizado2);
            int ml = Integer.parseInt(campoMlPersonalizado2);
            bebidas.add(new Bebida("Personalizada 2", valor, ml, R.drawable.interrogacao));
        }

        if (bebidas.size() < 2) {
            Toast.makeText(this, "É necessário preencher ao menos duas bebidas.", Toast.LENGTH_LONG).show();
        } else {
            Collections.sort(bebidas, new BebidaComparator());
            Intent intentVaiParaResultado = new Intent(this, ResultActivity.class);
            intentVaiParaResultado.putExtra("bebidas", bebidas);
            startActivity(intentVaiParaResultado);
        }
    }

    private void limparCampos() {

        garrafaField.setText("");
        lataField.setText("");
        litraoField.setText("");
        latonaField.setText("");
        longneckField.setText("");
        barrilField.setText("");
        valorPersonalizada1Field.setText("");
        mlPersonalizada1Field.setText("");
        valorPersonalizada2Field.setText("");
        mlPersonalizada2Field.setText("");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        limparCampos();
        garrafaField.requestFocus();
    }
}
