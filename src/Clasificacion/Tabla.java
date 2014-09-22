/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;

import java.util.ArrayList;

/**
 *
 * @author Geykel
 */
public class Tabla {
    public Tabla(String Nombre, ArrayList<String> Columnas){
        this.Nombre = Nombre;
        this.Columnas = Columnas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<String> getColumnas() {
        return Columnas;
    }

    public void setColumnas(ArrayList<String> Columnas) {
        this.Columnas = Columnas;
    }
    
    public void agrgarColumna(String col){
        getColumnas().add(col);
    }
    
    public boolean eliminarColumna(String col){
        return getColumnas().remove(col);
    }
    
    public String stringColumnas(){
        StringBuilder str= null;
        for(String a:Columnas){
            if(str == null){
                str = new StringBuilder(a);
            }
            else str.append(", ").append(a);
        }
        if(str == null) return null;
        return str.toString();
    }
    
    private String Nombre;
    private ArrayList<String> Columnas;
}
