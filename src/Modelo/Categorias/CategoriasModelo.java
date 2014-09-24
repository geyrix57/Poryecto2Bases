/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Categorias;

import Clasificacion.Tabla;
import Modelo.BaseDatos.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aaron
 */
public class CategoriasModelo {
    
    public CategoriasModelo() {
        
        this.database = DataBase.getInstance();
        tablas = new ArrayList();
        this.tablespaces = FXCollections.observableArrayList();
        this.tablespace = "USERS";
        this.consultaT2 = "SELECT TABLESPACE_NAME FROM DBA_DATA_FILES";
    }
    
    public void ActualizarTablespace() throws SQLException {
        if (!database.isConnected()) {
            return;
        }
        ResultSet result = this.database.ExecuteQuery(consultaT2);
        
        while (result.next()) {
            String tsname = result.getString("TABLESPACE_NAME");
            System.out.println(tsname);
            this.tablespaces.add(tsname);
        }
        result.getStatement().close();
    }
    
    public void ActualizarListaTablas(String tablespace) throws SQLException {
        
        if (!database.isConnected()) {
            return;
        }
        String consult2 = "SELECT TABLE_NAME FROM DBA_TABLES WHERE TABLESPACE_NAME LIKE '" + tablespace + "'";
        ResultSet result = this.database.ExecuteQuery(consult2);
        this.tablas.clear();
        
        while (result.next()) {
            String tname = result.getString("TABLE_NAME");
            System.out.println(tname);
            this.tablas.add(new Tabla(tname, new ArrayList()));
        }
        result.getStatement().close();
    }
    
    public void ActualizarTablaColumn() throws SQLException {
        if (!database.isConnected()) {
            return;
        }
        
        for (Tabla t : this.tablas) {
            
            String consultat2 = "SELECT COLUMN_NAME FROM  USER_TAB_COLUMNS WHERE TABLE_NAME= '" + t.getNombre() + "'";
            ResultSet result = this.database.ExecuteQuery(consultat2);
            System.out.println("Tabla:" + t.getNombre());
            System.out.println("Columnas:");
            while (result.next()) {
                String cname = result.getString("COLUMN_NAME");
                System.out.println(cname);
                t.getColumnas().add(cname);
            }
            result.getStatement().close();
        }
    }
    
    public ObservableList getTablespaces() {
        return tablespaces;
    }
    
    private final DataBase database;
    private final ArrayList<Tabla> tablas;
    private final ObservableList<String> tablespaces;
    
    private final String tablespace;
    
    private final String consultaT2;
    
}
