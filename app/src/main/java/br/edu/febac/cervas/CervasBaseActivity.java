package br.edu.febac.cervas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by gesie on 23/09/2016.
 */

public class CervasBaseActivity extends AppCompatActivity {

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
