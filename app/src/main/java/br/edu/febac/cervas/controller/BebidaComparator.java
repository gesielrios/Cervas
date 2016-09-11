package br.edu.febac.cervas.controller;

import java.util.Comparator;

import br.edu.febac.cervas.model.Bebida;

/**
 * Created by gesie on 03/09/2016.
 */
public class BebidaComparator implements Comparator<Object> {

    @Override
    public int compare(Object obj1, Object obj2) {

        Bebida bebida1 = (Bebida) obj1;
        Bebida bebida2 = (Bebida) obj2;

        if (bebida1.getResultado() < bebida2.getResultado())
            return -1;


        if (bebida1.getResultado() > bebida2.getResultado())
            return 1;

        return 0;
    }
}
