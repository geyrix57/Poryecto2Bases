/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;
import Clasificacion.Permiso.Grant;

/**
 *
 * @author Geykel
 */
public class Permiso {

    public static enum Grant{DELETE,INSERT,UPDATE,SELECT};
    
    public Permiso(Grant g, Tabla t){
        this.g = g;
        this.t = t;
    }
    
    public String getTipo() {
        if(g == Grant.DELETE) return "Delete";
        if(g == Grant.INSERT) return "Insert";
        if(g == Grant.UPDATE) return "Update";
        else return "Select";
    }
    
    public Grant getGrant(){
        return g;
    }
    
    public void setGrant(Grant g) {
        this.g = g;
    }

    public Tabla getTabla() {
        return t;
    }

    public void setTabla(Tabla t) {
        this.t = t;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String generarSqlRole(){
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE ROLE ").append(this.nombre);
        return sql.toString();
    }
    
    public String generarSql(){
        StringBuilder sql = new StringBuilder();
        if(g == Grant.SELECT){
            sql.append("GRANT SELECT (").append(t.stringColumnas()).append(") ON ").append(t.getNombre());
            sql.append(" TO ").append(this.nombre);
        }
        else if(g == Grant.UPDATE){
            sql.append("GRANT UPDATE (").append(t.stringColumnas()).append(") ON ").append(t.getNombre());
            sql.append(" TO ").append(this.nombre);
        }
        else if(g == Grant.INSERT){
            sql.append("GRANT INSERT").append(" ON ").append(t.getNombre());
            sql.append(" TO ").append(this.nombre);
        }
        else {
            sql.append("GRANT DELETE").append(" ON ").append(t.getNombre());
            sql.append(" TO ").append(this.nombre);
        }
        return sql.toString();
    }
    
    public int getHashCode(){
        return nombre.hashCode();
    }
    
    private String nombre;
    private Grant g;
    private Tabla t;
}
