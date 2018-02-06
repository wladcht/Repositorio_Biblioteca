/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.excepciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class Validaciones {

    /**
     *
     * Metodo para validar las cadenas
     *
     * @param expReg
     * @param valor
     * @return
     */
    public static boolean validar(String expReg, String valor) {
        Pattern patron = Pattern.compile(expReg);
        Matcher encajador = patron.matcher(valor);
        return encajador.matches();
    }

    /**
     * Validar el codigo solo debe de tener numeros la longitud de 1 a 3 numeros
     * codigo en Estudiante y Usuario
     *
     * @param d
     * @return
     */
    public boolean isCodigo(String d) {
        return validar("\\d{1,3}", d);
    }

    /**
     * Valida el nombre (Persona, Usuario, Estudiante), titulo Debe de empezar
     * con una letra mayuscula seguido de letras minusculas
     *
     * @param parametro
     * @return boolean
     */
    public boolean isCadena(String d) {
        return validar("^[A-Z]{1,1}[a-z]{2,}", d);
    }

    /**
     * Valida la fecha año-mes-dia debe ser una fecha comprendida entre 1980 -
     * 2015
     *
     * @param a
     * @return
     */
    public boolean isFechaNacimiento(String a) {
        return validar("^((19[8|9][0-9])|(20(0[0-9]|1[0-5])))\\-((0[1-9])|[1-9]|(1[0-2]))\\-((0[1-9])|[1-9]|(1[0-9])|(2[0-9]|(30|31)))", a);
    }

    /**
     * Valida un usuario que contenga letras numeros y _ longitud de la cadena
     * de 4 a 32 caracteres
     *
     * @param d
     * @return
     */
    public boolean isUsuario(String d) {
        return validar("^[a-zA-Z]+([a-z0-9A-Z]*[\\_]*[a-zA-Z]*)*{4,32}", d);
    }

    /**
     * Validar la clave del usuario al menos debe tener una longitud de 5
     *
     * @param m
     * @return
     */
    public boolean isClaveUsuario(String m) {
        return validar("^[a-zA-Z0-9]{5,}", m);
    }

    /**
     * Valida el numero de celular debe contener 10 numeros y siempre debe de
     * empezar con 09
     *
     * @param d
     * @return
     */
    public boolean isCelular(String d) {
        return validar("^09\\d{8,8}", d);
    }

    /**
     * Valida el numero de curso de 1 en adelante
     *
     * @param c
     * @return
     */
    public boolean isCurso(String c) {

        return validar("\\d{1,}", c);
    }

    /**
     * Validar el codigo del libro: Empieza por mayuscula, seguido de dos
     * numeros
     *
     * @param d
     * @return
     */
    public boolean isCodigoLibro(String d) {
        return validar("^[A-Z]{1,1}[0-9]{2,}", d);
    }

    /**
     * Valida el nombre del Autor Debe de empezar con una letra mayuscula
     * seguido de letras minusculas, un espacio, una letra mayuscula y de letras
     * minusculas seguido de letras minusculas
     *
     * @param nombre
     * @return boolean
     */
    public boolean isAutor(String d) {
        return validar("^[A-Z]{1,1}[a-z]{2,} [A-Z]{1,1}[a-z]{2,}", d);
    }

    /**
     *
     * @param p
     * @return
     */
    public boolean isPaginas(String p) {

        return validar("\\d{1,3}", p);
    }

    /**
     * Este método valida que no se ingresen menos de cuatro números y
     * opcionalmente un punto seguido de cuatro números.
     *
     * @param p
     * @return
     *
     */
    public boolean isPrecio(String p) {
        return validar("[0-9]{1,10}.[0-9]{1,2}", p);
    }

    /**
     * Valida la fecha año-mes-dia debe ser una fecha comprendida entre
     * 2000-2015
     *
     * @param a
     * @return
     */
    public boolean isFechaPrestamoEntrega(String a) {
        return validar("^(20(0[0-9]|1[0-5]))\\-((0[1-9])|[1-9]|(1[0-2]))\\-((0[1-9])|[1-9]|(1[0-9])|(2[0-9]|(30|31)))", a);      
    }
}
