package com.company;

import java.util.Arrays;

/**
 * Created by Colo on 29/10/2018.
 */
public class Calle {

    private final String nombre;
    private final int altura;
    private final String orientacion;

    public Calle(String nombre, int altura, String orientacion) {
        this.nombre=nombre;
        this.altura=altura;
        this.orientacion=orientacion;
    }

    public boolean hasXOrientation() {
        if(orientacion.equals("X")){
            return true;
        }
        return false;
    }

    public int getAltura() {
        return altura;
    }

    public String getNombre() {
        return nombre;
    }
}
