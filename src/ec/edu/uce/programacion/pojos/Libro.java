/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.pojos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class Libro implements Comparable<Libro> {

    private String codigo;
    protected String titulo;
    protected String autor;
    protected Integer paginas;
    private Date fechaEdicion;
    private Date fechaPrestamo;
    private Date fechaEntrega;
    private Double precio;
    public static Float descuento = 500f;

    private boolean tipo = true;
   

    public Libro() {
    }

    /**
     *
     * @param codigo
     * @param titulo
     * @param autor
     * @param paginas
     * @param fechaEdicion
     * @param precio
     */
    public Libro(String codigo, String titulo, String autor, Integer paginas, Date fechaEdicion, Double precio) throws ParseException {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.fechaEdicion = fechaEdicion;
        this.precio = precio;
    }

    /**
     * Devuelve el codigo
     *
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Cambia el valor de codigo
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el titulo
     *
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Cambia la cadena titulo
     *
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor
     *
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Cambia la cadena autor
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtener paginas
     *
     * @return paginas
     */
    public Integer getPaginas() {
        return paginas;
    }

    /**
     * Cambiar paginas
     *
     * @param paginas
     */
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    /**
     * Obtener fecha
     *
     * @return fechaEdicion
     */
    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Cambia fecha
     *
     * @param fechaEdicion
     */
    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Obtener precio
     *
     * @return precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * Cambiar precio
     *
     * @param precio
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la fecha de prestamo
     *
     * @return
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Cambia la fecha de prestamo
     *
     * @param fechaPrestamo
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Devuelve la fecha de entrega
     *
     * @return fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Cambia la fecha de entrega
     *
     * @param fechaEntrega
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     *
     *
     * @return tipo
     */
    public boolean isTipo() {
        return tipo;
    }

    /**
     * Cambia el tipo
     * 
     * @param tipo
     */
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para cambiar el estado del tipo (Disponible-No Disponible)
     *
     * @param tipo
     * @return
     */
    public String tipo(boolean tipo) {
        if (tipo == false) {
            return "No disponible";
        } else {
            return "Disponible";
        }
    }

    /**
     * Sobrescribir el metodo toString el cual indica como imprimir los
     * atributos de la clase libro
     *
     * @return cadena conformada por los atributos
     *
     */
    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return "Libro :" + "\ncodigo = " + codigo + "\ntitulo = " + titulo
                + "\nautor = " + autor + "\npaginas = " + paginas
                + "\nfechaEdicion = " + formato.format(fechaEdicion) + "\n precio = " + precio
                + "\n Disponibilidad :" + tipo;
    }

    /**
     *
     * @param o
     * @return compara el codigo de los libros
     */
    @Override
    public int compareTo(Libro o) {
        return this.getCodigo().compareToIgnoreCase(codigo);
    }

}
