/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Geykel
 */
public class Tabla {
    public Tabla(String Nombre, ArrayList<String> Columnas){
        this.Nombre = new SimpleStringProperty(Nombre);
        this.Columnas = Columnas;
        this.insert=new ArrayList();
        this.update=new ArrayList();
        this.delete=false;
        this.select=false;
    }

    public String getNombre() {
        return Nombre.get();
    }

    public void setNombre(String Nombre) {
        this.Nombre = new SimpleStringProperty(Nombre);
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

    public ArrayList<String> getInsert() {
        return insert;
    }

    

    public ArrayList<String> getUpdate() {
        return update;
    }

   
    public boolean isSelect() {
        return select;
    }

    public void setSelect() {
        this.select = !select;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete() {
        this.delete = !delete;
    }
    
    
    private SimpleStringProperty Nombre;
    private ArrayList<String> Columnas;
    private ArrayList<String> insert;
    private ArrayList<String> update;
    private boolean select;
    private boolean delete;
}
