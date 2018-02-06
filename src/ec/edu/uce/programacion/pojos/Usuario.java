/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.pojos;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class Usuario extends Persona implements Comparable<Usuario>{
    
    private String usuario;
    private String clave;

    public Usuario() {
    }

    /**
     * 
     * @param codigo
     * @param nombre
     * @param fec_nacimento
     * @param usuario
     * @param clave 
     */
    public Usuario(Integer codigo, String nombre, Date fec_nacimento, String usuario, String clave) {
        super(codigo, nombre, fec_nacimento);
        this.usuario = usuario;
        this.clave = clave;
    }

    /**
     * Devuelve el usuario
     * 
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Cambia el usuario
     * 
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la clave
     * 
     * @return clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * Cambia la clave
     * 
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * sobrescribir el metodo toString el cual indica como imprimir los
     * atributos de la clase usuario
     * 
     * @return 
     */
    @Override
    public String toString() {
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "Usuario: " + "\ncodigo = " + codigo + "\nnombre = " + nombre + "\nfec_nacimento = " + formato.format(fec_nacimento)+ "\nusuario = " + usuario + " \nclave=" + clave ;
    }

    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Usuario o) {
        return this.getCodigo().compareTo(codigo);
    }
}
