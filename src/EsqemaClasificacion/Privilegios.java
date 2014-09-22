/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EsqemaClasificacion;

import Clasificacion.Permiso;
import java.util.HashMap;

/**
 *
 * @author Geykel
 */
public class Privilegios {
    
    public static Privilegios getInstance(){
        if(priv == null){
            priv = new Privilegios();
        }
        return priv;
    }
    
    public void agregarPermiso(Permiso perm){
        contenedor.put(perm.getHashCode(), perm);
    }
    
    public Permiso getPermiso(Integer key){
        return contenedor.get(key);
    }
    
    private Privilegios(){
        contenedor = new HashMap();
    }
    
    private static Privilegios priv = null;
    private HashMap<Integer,Permiso> contenedor;
}
