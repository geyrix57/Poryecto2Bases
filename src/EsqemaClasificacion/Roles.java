/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EsqemaClasificacion;

import Clasificacion.Rol;
import java.util.HashMap;

/**
 *
 * @author Geykel
 */
public class Roles {
    public static Roles getInstance(){
        if(roles == null){
            roles = new Roles();
        }
        return roles;
    }
    
    public void agregarRol(Rol rol){
        contenedor.put(rol.getHashCode(), rol);
    }
    
    public Rol getRol(Integer key){
        return contenedor.get(key);
    }
    
    private Roles(){
        contenedor = new HashMap();
    }
    
    private static Roles roles = null;
    private HashMap<Integer,Rol> contenedor;
}
