/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.interfaces;

import java.util.*;

/**
 * Esta interface nos permite manejar las operaciones CRUD al momento de persistir los datos del programa.
 * CRUD --> Create (crear), Read (Listar), Update (actualizar), Delete (borrar)
 * 
 * @author Ing. Giovanny Moncayo Unda. M.Sc. 
 * @version 2015-07-15
 */

public interface InterfazCRUD
{
    /**
     * Metodo que permite crear en la coleccion un nuevo Objeto de cualquier clase.
     * @param obj Es el nuevo Objeto que se va a crear
     * @return Un mensaje para alertar al usuario
     */    
    public String crear(Object obj);
    
    /**
     * Metodo que permite modificar el estado de un Objeto dentro de la coleccion
     * @param obj El Objeto a ser actualizado
     * @return Un mensaje para alertar al usuario
     */
    public String actualizar(Object obj);
    
    /**
     * Metodo que permite eliminar un Objeto de la coleccion
     * @param obj El Objeto a ser eliminado
     * @return Un mensaje para alertar al usuario
     */
    public String borrar(Object obj);
    
    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     * @param parametro El parametro del Objeto que se está buscando
     * @return El Objeto encontrado, si el objeto no existe, retorna null
     */
    public Object buscarPorParametro(Object parametro); //String <->Object
        
    /**
     * Metodo que permita listar los Objetos que se encuentran en la coleccion
     * @return La lista de Objetos almacenados
     */
    public List listar();
    
}
