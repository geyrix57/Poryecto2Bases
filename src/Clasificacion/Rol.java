/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clasificacion;

import EsqemaClasificacion.Privilegios;
import java.util.ArrayList;

/**
 *
 * @author Geykel
 */
public class Rol {
    public Rol(String Nombre, ArrayList<Integer> Permisos){
        this.Nombre =  Nombre;
        this.Permisos = Permisos;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public ArrayList<Integer> getPermisos() {
        return Permisos;
    }
    
    public void agregarPermiso(Integer permiso){
        if(!Permisos.contains(permiso)) Permisos.add(permiso);
    }
    
    public int getHashCode(){
        return Nombre.hashCode();
    }
    
    public String generarSqlRol(){
        StringBuilder sql;
        sql = new StringBuilder("CREATE ROLE ").append(this.Nombre);
        return sql.toString();
    }

    public String generarSqlRolUsuario(){
        StringBuilder sql = new StringBuilder("GRANT ");
        StringBuilder perm = null;
        Privilegios priv = Privilegios.getInstance();
        for(Integer i:Permisos){
            if(perm == null){
                perm = new StringBuilder(priv.getPermiso(i).getNombre());
            }
            else perm.append(", ").append(priv.getPermiso(i).getNombre());
        }
        return sql.append(perm).append(" TO ").append(this.Nombre).toString();
    }

    private String Nombre;
    private ArrayList<Integer> Permisos; 
}
