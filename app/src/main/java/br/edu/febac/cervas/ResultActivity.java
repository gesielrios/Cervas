package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.febac.cervas.adapter.BebidasAdapter;
import br.edu.febac.cervas.controller.BebidaComparator;
import br.edu.febac.cervas.model.Bebida;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<Bebida> bebidas = (ArrayList<Bebida>) getIntent().getSerializableExtra("bebidas");
        BebidasAdapter adapter = new BebidasAdapter(this, bebidas);

        ListView resultadoList = (ListView) findViewById(R.id.list_result);
        resultadoList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.about_item_menu:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
