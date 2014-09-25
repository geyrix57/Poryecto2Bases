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
public class Permiso {

    public Permiso(String nombre, String tabla, boolean select, boolean delete, ArrayList<String> insert, ArrayList<String> update) {
        this.nombre = nombre;
        this.select = select;
        this.delete = delete;
        this.insert = insert;
        this.update = update;
        this.tabla = tabla;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public ArrayList<String> getInsert() {
        return insert;
    }

    public void setInsert(ArrayList<String> insert) {
        this.insert = insert;
    }

    public ArrayList<String> getUpdate() {
        return update;
    }

    public void setUpdate(ArrayList<String> update) {
        this.update = update;
    }

    public String generarSqlRole() {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE ROLE ").append(this.getNombre());
        return sql.toString();
    }

    public String generarSql() {
        StringBuilder rev = new StringBuilder("REVOKE ");
        StringBuilder sql = new StringBuilder("GRANT ");
        if (this.select) {
            sql.append("SELECT");
            rev.append("SELECT");
        }
        if (this.delete) {
            if (sql.length() == 0) {
                sql.append("DELETE");
                rev.append("DELETE");
            } else {
                sql.append(", DELETE");
                rev.append(", DELETE");
            }
        }
        if (insert != null) {
            if (sql.length() == 0) {
                rev.append("INSERT");
                sql.append("INSERT (");
            } else {
                rev.append(", INSERT");
                sql.append(", INSERT (");
            }
            StringBuilder col = null;
            for (String i : insert) {
                if (col == null) {
                    col = new StringBuilder(i);
                } else {
                    col.append(", ").append(i);
                }
            }
            sql.append(col).append(")");
        }
        if (update != null) {
            if (sql.length() == 0) {
                sql.append("UPDATE (");
                rev.append("UPDATE");
            } else {
                sql.append(", UPDATE (");
                rev.append(", UPDATE");
            }
            StringBuilder col = null;
            for (String i : update) {
                if (col == null) {
                    col = new StringBuilder(i);
                } else {
                    col.append(", ").append(i);
                }
            }
            sql.append(col).append(")");
        }
        sql.append(" ON ").append(this.tabla).append(" TO ").append(nombre);
        rev.append(" ON ").append(this.tabla).append(" FROM ").append(nombre);
        revoke = rev.toString();
        return sql.toString();
    }
    
    public String generarRevokeSql(){
        return revoke;
    }

    public int getHashCode() {
        return nombre.hashCode();
    }
    
    private String revoke = null;
    private String nombre;
    private String tabla;
    private boolean select;
    private boolean delete;
    private ArrayList<String> insert;
    private ArrayList<String> update;
}
