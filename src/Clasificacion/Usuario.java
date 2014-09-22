/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;

import EsqemaClasificacion.Privilegios;
import EsqemaClasificacion.Roles;
import java.util.ArrayList;

/**
 *
 * @author Geykel
 */
public class Usuario {
    public Usuario(String Nombre, ArrayList<Integer> roles){
        this.Nombre =  Nombre;
        this.roles = roles;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public ArrayList<Integer> getRoles() {
        return roles;
    }
    
    public void agregarRol(Integer rol){
        if(!roles.contains(rol)) roles.add(rol);
    }
    
    /*resive el hashcode de un rol*/
    public void eliminarRol(Integer key){
        roles.remove(key);
    }
    
    public int getHashCode(){
        return Nombre.hashCode();
    }
    
    public String generarUsuarioSql(){
        StringBuilder sql;
        sql = new StringBuilder("CREATE USER ").append(this.Nombre).append("IDENTIFIED BY").append(this.Nombre);
        return sql.toString();
    }

    public String generarSqlRolesUsuario(){
        StringBuilder sql = new StringBuilder("GRANT ");
        StringBuilder r = null;
        Roles rls = Roles.getInstance();
        for(Integer i:roles){
            if(r == null){
                r = new StringBuilder(rls.getRol(i).getNombre());
            }
            else r.append(", ").append(rls.getRol(i).getNombre());
        }
        return sql.append(r).append(" TO ").append(this.Nombre).toString();
    }
    
    private ArrayList<Integer> roles;
    private String Nombre;
}
