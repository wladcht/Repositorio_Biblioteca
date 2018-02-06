/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.pojos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class RentaLibro implements Comparable, Serializable {

    private Date FechaEntrega;
    private Date FechaPrestamo;
    private int numeroPrestamo;
    private int cod; //codigo estudiante
    private String codLib;

    public RentaLibro() {
    }

    /**
     *
     * @param FechaEntrega
     * @param FechaPrestamo
     * @param numeroPrestamo
     * @param E
     */
    public RentaLibro(Date FechaEntrega, Date FechaPrestamo, int numeroPrestamo, int E) {
        this.FechaEntrega = FechaEntrega;
        this.FechaPrestamo = FechaPrestamo;
        this.numeroPrestamo = numeroPrestamo;
        this.cod = E;
    }

    /**
     *
     * @param FechaEntrega
     * @param FechaPrestamo
     * @param numeroPrestamo
     * @param cod
     * @param codLib
     */
    public RentaLibro(Date FechaEntrega, Date FechaPrestamo, int numeroPrestamo, int cod, String codLib) {
        this.FechaEntrega = FechaEntrega;
        this.FechaPrestamo = FechaPrestamo;
        this.numeroPrestamo = numeroPrestamo;
        this.cod = cod;
        this.codLib = codLib;
    }

    /**
     * Devuelve el codigo del estudiante
     *
     * @return cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * Cambia el codigo del estudiante
     *
     * @param cod
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * Devuelve el codigo del libro
     *
     * @return codLib
     */
    public String getCodLib() {
        return codLib;
    }

    /**
     * Cambia el codigo del libro
     *
     * @param codLib
     */
    public void setCodLib(String codLib) {
        this.codLib = codLib;
    }

    /**
     * Devuelve la fecha de entrega
     *
     * @return fecha de entrega
     */
    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    /**
     * Cambia la fecha de entrega
     *
     * @param FechaEntrega
     */
    public void setFechaEntrega(Date FechaEntrega) {
        this.FechaEntrega = FechaEntrega;
    }

    /**
     * Devuelve la fecha de prestamo
     *
     * @return FechaPrestamo
     */
    public Date getFechaPrestamo() {
        return FechaPrestamo;
    }

    /**
     * Cambia la fecha de prestamo
     *
     * @param FechaPrestamo
     */
    public void setFechaPrestamo(Date FechaPrestamo) {
        this.FechaPrestamo = FechaPrestamo;
    }

    /**
     * Devuelve el numero de Prestamo
     *
     * @return numeroPrestamo
     */
    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    /**
     * Cambia el numero de prestamo
     *
     * @param numeroPrestamo
     */
    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    /**
     * Sobrescribir el metodo toString el cual indica como imprimir los
     * atributos de la clase RentaLibro
     *
     * @return
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "RentaLibro: " + "\ncod = " + cod + "\ncodLib = " + codLib + "\nFechaEntrega = " + formato.format(FechaEntrega) + "\nFechaPrestamo = " + formato.format(FechaPrestamo) + "\nnumeroPrestamo = " + numeroPrestamo ;
    }

    /**
     * 
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
