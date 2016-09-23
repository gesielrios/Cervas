package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.febac.cervas.adapter.BebidasAdapter;
import br.edu.febac.cervas.controller.BebidaComparator;
import br.edu.febac.cervas.model.Bebida;

public class ResultActivity extends CervasBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Bebida> bebidas = (ArrayList<Bebida>) getIntent().getSerializableExtra("bebidas");
        BebidasAdapter adapter = new BebidasAdapter(this, bebidas);

        final ListView resultadoList = (ListView) findViewById(R.id.list_result);

        resultadoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bebida bebida = (Bebida) resultadoList.getItemAtPosition(position);

                Intent intentVaiParaDetalhesBebida = new Intent(ResultActivity.this, DrinkDetailActivity.class);
                intentVaiParaDetalhesBebida.putExtra("bebida", bebida);
                startActivity(intentVaiParaDetalhesBebida);

            }
        });
        resultadoList.setAdapter(adapter);
    }
}
