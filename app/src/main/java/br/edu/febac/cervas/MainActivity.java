package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import br.edu.febac.cervas.controller.BebidaComparator;
import br.edu.febac.cervas.model.Bebida;

public class MainActivity extends AppCompatActivity {

    EditText garrafaField;
    EditText lataField;
    EditText valorPersonalizada1Field;
    EditText mlPersonalizada1Field;
    EditText valorPersonalizada2Field;
    EditText mlPersonalizada2Field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        garrafaField = (EditText) findViewById(R.id.valor_garrafa_field_main);
        lataField = (EditText) findViewById(R.id.valor_lata_field_main);
        valorPersonalizada1Field = (EditText) findViewById(R.id.valor_personalizado_1_field_main);
        mlPersonalizada1Field = (EditText) findViewById(R.id.ml_personalizado_1_field_main);
        valorPersonalizada2Field = (EditText) findViewById(R.id.valor_personalizado_2_field_main);
        mlPersonalizada2Field = (EditText) findViewById(R.id.ml_personalizado_2_field_main);

    }

    public void calcular(View view) {

        ArrayList<Bebida> bebidas = new ArrayList<>();

        String campoValorGarrafa = garrafaField.getText().toString();
        if (!campoValorGarrafa.isEmpty()) {
            float valorGarrafa = Float.parseFloat(campoValorGarrafa);
            bebidas.add(new Bebida("Garrafa", valorGarrafa, 600));
        }

        String campoValorLata = lataField.getText().toString();
        if (!campoValorLata.isEmpty()) {
            float valorLata = Float.parseFloat(campoValorLata);
            bebidas.add(new Bebida("Lata", valorLata, 350));
        }

        String campoValorPersonalizado1 = valorPersonalizada1Field.getText().toString();
        String campoMlPersonalizado1 = mlPersonalizada1Field.getText().toString();
        if (!campoValorPersonalizado1.isEmpty() && !campoMlPersonalizado1.isEmpty()) {
            float valor = Float.parseFloat(campoValorPersonalizado1);
            int ml = Integer.parseInt(campoMlPersonalizado1);
            bebidas.add(new Bebida("Personalizada 1", valor, ml));
        }

        String campoValorPersonalizado2 = valorPersonalizada2Field.getText().toString();
        String campoMlPersonalizado2 = mlPersonalizada2Field.getText().toString();
        if (!campoValorPersonalizado2.isEmpty() && !campoMlPersonalizado2.isEmpty()) {
            float valor = Float.parseFloat(campoValorPersonalizado2);
            int ml = Integer.parseInt(campoMlPersonalizado2);
            bebidas.add(new Bebida("Personalizada 2", valor, ml));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about_item_menu:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void limparCampos() {

        garrafaField.setText("");
        lataField.setText("");
        valorPersonalizada1Field.setText("");
        mlPersonalizada1Field.setText("");
        valorPersonalizada2Field.setText("");
        mlPersonalizada2Field.setText("");
    }

    @Override
    protected void onResume() {
        super.onResume();
        limparCampos();
        garrafaField.requestFocus();
    }
}
