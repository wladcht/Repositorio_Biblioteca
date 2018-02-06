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
public class Persona {

    protected Integer codigo;
    protected String nombre;
    protected Date fec_nacimento;

    public Persona() {
    }

    /**
     * 
     * @param codigo
     * @param nombre
     * @param fec_nacimento 
     */
    
    public Persona(Integer codigo, String nombre, Date fec_nacimento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fec_nacimento = fec_nacimento;
    }

    /**
     * Devuelve el codigo
     * 
     * @return codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * Cambia el valor del codigo
     * 
     * @param codigo 
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Devuelve el nombre
     * 
     * @return nombre
     */   
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la fec_nacimiento
     * 
     * @return fec_nacimiento
     */
    public Date getFec_nacimento() {
        return fec_nacimento;
    }

    /**
     * Cambia la fec_nacimiento
     * 
     * @param fec_nacimento 
     */
    public void setFec_nacimento(Date fec_nacimento) {
        this.fec_nacimento = fec_nacimento;
    }
    
    /**
     * sobrescribir el metodo toString el cual indica como imprimir los
     * atributos de la clase persona
     * 
     * @return 
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "Persona :" + "\ncodigo = " + codigo + "\nnombre = " + nombre + "\nfec_nacimento = " + formato.format(fec_nacimento);
    }

}
