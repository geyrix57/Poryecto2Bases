/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BaseDatos.DataBase;
import Modelo.Categorias.CategoriasModelo;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;



public class CategoriaController implements Initializable {

    @FXML
    Button Buscar;
    @FXML
    TableView Tablas;
    @FXML
    TreeTableView Permisos;
    @FXML
    ComboBox tablespaces;         
    
    CategoriasModelo modelo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tablas.setEditable(true);
        DataBase basedatos=DataBase.getInstance();
        basedatos.setConnection("localhost", 1521, "XE", "sys as sysdba","root");
        modelo= new CategoriasModelo();
        try {
            modelo.ActualizarTablespace();
            modelo.ActualizarListaTablas("USERS");
            modelo.ActualizarTablaColumn();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.tablespaces.setItems(modelo.getTablespaces());
        this.tablespaces.setValue(modelo.getTablespaces().get(0));
        
        
    }    
    
}
