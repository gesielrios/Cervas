package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.febac.cervas.model.Bebida;

public class DrinkDetailActivity extends CervasBaseActivity {

    private ImageView drinkImage;
    private TextView nameDrinkField;
    private TextView amountDrinkField;
    private TextView valueDrinkField;
    private TextView MlCostDrinkField;
    private TextView CostPerLitreDrinkField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drinkImage = (ImageView) findViewById(R.id.image_drink_detail);
        nameDrinkField = (TextView) findViewById(R.id.name_drink_detail);
        amountDrinkField = (TextView) findViewById(R.id.amount_drink_detail);
        valueDrinkField = (TextView) findViewById(R.id.value_drink_detail);
        MlCostDrinkField = (TextView) findViewById(R.id.cost_ml_drink_detail);
        CostPerLitreDrinkField = (TextView) findViewById(R.id.cost_per_litre_drink_detail);

        Intent intent = getIntent();
        Bebida bebida = (Bebida) intent.getSerializableExtra("bebida");

        if (bebida != null)
            preencherDados(bebida);

    }

    private void preencherDados(Bebida bebida) {

        drinkImage.setImageResource(garregaImagem(bebida));
        nameDrinkField.setText(bebida.getNome());
        amountDrinkField.setText(bebida.getQuantidade() + " ml");
        valueDrinkField.setText("R$ " + bebida.getValor().setScale(2));
        MlCostDrinkField.setText("R$ " + bebida.getCusto().setScale(4));
        CostPerLitreDrinkField.setText("R$ " + bebida.getCustoPorLivro().setScale(2));
    }

    private int garregaImagem(Bebida bebida) {

        switch (bebida.getImagemID()) {
            case R.drawable.garrafa:
                return R.drawable.garrafa;
            case R.drawable.lata:
                return R.drawable.lata;
            case R.drawable.litrao:
                return R.drawable.litrao;
            case R.drawable.latona:
                return R.drawable.latona;
            case R.drawable.longneck:
                return R.drawable.longneck;
            case R.drawable.barril:
                return R.drawable.barril;
            default:
                return R.drawable.interrogacao;
        }
    }

}
