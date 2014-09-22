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
public class Usuarios {
    public static Usuarios getInstance(){
        if(usuarios == null){
            usuarios = new Usuarios();
        }
        return usuarios;
    }
    
    public void agregarUsuario(Rol rol){
        contenedor.put(rol.getHashCode(), rol);
    }
    
    public Rol getUsuario(Integer key){
        return contenedor.get(key);
    }
    
    private Usuarios(){
        contenedor = new HashMap();
    }
    
    private static Usuarios usuarios = null;
    private HashMap<Integer,Rol> contenedor;
}
