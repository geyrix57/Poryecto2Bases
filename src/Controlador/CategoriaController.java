/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Clasificacion.Tabla;
import Modelo.BaseDatos.DataBase;
import Modelo.Categorias.CategoriasModelo;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoriaController implements Initializable {

    @FXML
    Button Buscar;
    @FXML
    TableView Tablas;

    @FXML
    ComboBox tablespaces;
    @FXML
    Button guardarCambios;

    CategoriasModelo modelo;

    @FXML
    public void GuardarCambios(ActionEvent event) {
        for (Object p : (ObservableList) this.Tablas.getItems()) {
            Tabla t = (Tabla) p;
             System.out.println(t.getNombre() + t.isDelete() + t.isSelect());

        }
        System.out.println();
    }

    @FXML
    private void handleTablespaces() throws SQLException {
        System.out.println(tablespaces.getSelectionModel().getSelectedItem() + "\n");
        String tsname = (String) tablespaces.getSelectionModel().getSelectedItem();
        if (tsname == null) {
            this.modelo.ActualizarListaTablas("USERS");
        } else {
            this.modelo.ActualizarListaTablas(tablespaces.getSelectionModel().getSelectedItem().toString());
        }
        this.Tablas.setItems(modelo.getTablas());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tablas.setEditable(true);
        DataBase basedatos = DataBase.getInstance();
        basedatos.setConnection("localhost", 1521, "XE", "sys as sysdba", "root");
        modelo = new CategoriasModelo();
        try {
            modelo.ActualizarTablespace();
            modelo.ActualizarListaTablas("USERS");
            modelo.ActualizarTablaColumn();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.tablespaces.setItems(modelo.getTablespaces());
        this.tablespaces.setValue(modelo.getTablespaces().get(0));
        this.Tablas.setItems(modelo.getTablas());
        TableColumn<Tabla, String> name = new TableColumn("Tabla");

        TableColumn<Tabla, Boolean> select = new TableColumn<>("select");
        TableColumn<Tabla, Boolean> delete = new TableColumn<>("delete");
        TableColumn update = new TableColumn("update");
        TableColumn insert = new TableColumn("insert");

        name.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        select.setCellValueFactory(new PropertyValueFactory <>("select"));
        select.setCellFactory(CheckBoxTableCell.forTableColumn(select));
        select.setEditable(true);
        delete.setCellValueFactory(new PropertyValueFactory <>("delete"));
        delete.setCellFactory(CheckBoxTableCell.forTableColumn(delete));
        delete.setEditable(true);
        this.Tablas.setEditable(true);
        this.Tablas.getColumns().addAll(name, insert, update, select, delete);
        this.Tablas.setItems(modelo.getTablas());

    }

}
