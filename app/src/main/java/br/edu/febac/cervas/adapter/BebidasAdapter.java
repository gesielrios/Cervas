package br.edu.febac.cervas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.febac.cervas.R;
import br.edu.febac.cervas.model.Bebida;

/**
 * Created by gesie on 03/09/2016.
 */
public class BebidasAdapter extends BaseAdapter {

    private final List<Bebida> bebidas;
    private final Context context;

    public BebidasAdapter(Context context, List<Bebida> bebidas) {
        this.context = context;
        this.bebidas = bebidas;
    }


    @Override
    public int getCount() {
        return this.bebidas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.bebidas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Bebida bebida = bebidas.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.list_result_item, parent, false);
        }

        TextView number = (TextView) view.findViewById(R.id.number_item);
        number.setText(String.valueOf(position + 1) + "ª");

        TextView description = (TextView) view.findViewById(R.id.description_item);
        description.setText(bebida.toString());

        TextView cost = (TextView) view.findViewById(R.id.cost_item);
        cost.setText(bebida.getCusto().setScale(4).toString());
        return view;
    }
}
