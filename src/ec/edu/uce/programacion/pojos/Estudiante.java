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
public class Estudiante extends Persona implements Comparable<Estudiante> {

    private String celular;
    private Integer curso;

    public Estudiante() {
    }

    /**
     * 
     * @param codigo
     * @param nombre
     * @param fec_nacimento
     * @param celular
     * @param curso 
     */
    public Estudiante(Integer codigo, String nombre, Date fec_nacimento, String celular, Integer curso) {
        super(codigo, nombre, fec_nacimento);
        this.celular = celular;
        this.curso = curso;
    }

    /**
     * Devuelve numero de celular
     * 
     * @return celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Cambia el numero del celular
     * 
     * @param celular 
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Devuelve el numero de curso
     * 
     * @return curso
     */
    public Integer getCurso() {
        return curso;
    }

    /**
     * Cambia el numero de curso
     * 
     * @param curso 
     */
    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    /**
     * Sobrescribir el metodo toString el cual indica como imprimir los
     * atributos de la clase estudiante
     * 
     * @return 
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "Estudiante: " + "\ncodigo = " + codigo + "\nnombre = " + nombre + "\nfec_nacimento = " + formato.format(fec_nacimento) + "\ncelular = " + celular + "\ncurso = " + curso;
    }

    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Estudiante o) {
        return this.getCodigo().compareTo(codigo);
    }



}
