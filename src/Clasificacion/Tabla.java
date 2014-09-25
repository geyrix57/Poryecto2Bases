/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;

import java.util.ArrayList;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
        this.delete= new SimpleBooleanProperty (true);
        delete.set(true);
        this.select= new SimpleBooleanProperty (false);
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
        return select.get();
    }

    public void setSelect() {
        this.select.set(!select.get());
    }

    public boolean isDelete() {
        return delete.get();
    }

    public void setDelete() {
        this.delete.set(!delete.get());
    }
    
    
    private SimpleStringProperty Nombre;
    private ArrayList<String> Columnas;
    private ArrayList<String> insert;
    private ArrayList<String> update;
    private BooleanProperty select;
    private BooleanProperty delete;
}
