/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import static ec.edu.uce.programacion.clases.LibroMetodos.adminLibro;
import ec.edu.uce.programacion.interfaces.InterfazCRUD;
import ec.edu.uce.programacion.pojos.Libro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class AdminLibros implements InterfazCRUD {

    // Creo una lista de libros 
    private ArrayList<Libro> libro = new ArrayList();

    /**
     * Metodo que permite crear en la coleccion un nuevo Objeto de la clase
     * libro
     *
     * @param obj
     * @return mensaje
     */
    @Override
    public String crear(Object obj) {
        Libro lib = (Libro) obj;
        int bandera = 1;
        for (Libro c : libro) {
            if (lib.equals(c)) {
                bandera = 3;
            }
        }
        if (bandera == 3) {
            return "<<<EL LIBRO YA EXISTE>>>";
        } else {
            libro.add(lib);
            Collections.sort(libro);
            sobArchivo();
            return "<<<EL LIBRO SE AH CREADO CON EXITO>>>";
        }
    }

    /**
     * Metodo que permite actualizar el estado de un Objeto dentro de la
     * coleccion
     *
     * @param obj
     * @return
     */
    @Override
    public String actualizar(Object obj) {
        Libro lib = (Libro) obj;
        int bandera = 1;
        for (Libro c : libro) {
            if (lib.getCodigo().equals(c.getCodigo())) {
                c = lib;
                bandera = 2;
            }
        }
        if (bandera == 2) {
            Collections.sort(libro);
            sobArchivo();
            return "<<<El LIBRO SE AH ACTUALIZADO>>>";
        } else {
            return "<<<EL LIBRO NO SE ACTUALIZO>>>";
        }
    }

    /**
     * Borra un libro de la coleccion
     *
     * @param obj
     * @return mensaje
     */
    @Override
    public String borrar(Object obj) {
        libro.remove(obj);
        Collections.sort(libro);
        sobArchivo();
        return "borrar";
    }

    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     *
     * @return obj
     */
    @Override
    public Object buscarPorParametro(Object parametro) {

        String user = (String.valueOf(parametro));
        for (Libro u : libro) {
            if (user.equals(u.getCodigo())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     *
     * @param parametro
     * @return
     */
    public Object buscarPorParametrocod(String parametro) {

        Libro a = null;
        for (Libro u : libro) {
            if (parametro.equals(u.getCodigo())) {
                a = u;
            }
        }
        return a;
    }

    /**
     * Busca por el codigo del libro en la coleccion
     *
     * @param obj
     * @return boolean
     */
    public boolean buscarPorParametroCodigo(String str) {
        Libro a = new Libro();
        boolean aux = false;
        for (Libro u : libro) {
            if (u.getCodigo().equals(str)) {
                a = u;
                aux = true;
            }
        }
        return aux;
    }

    /**
     * Lista toda la coleccion de libro
     *
     * @param obj
     * @return list
     */
    @Override
    public List listar() {
        return libro;
    }

    /**
     * Agrega toda la coleccion a un archivo llamado Libro.txt
     *
     *
     */
    public void sobArchivo() {
        File arLibros = new File("Libro.txt");
        List<Libro> lista = adminLibro.listar();
        try {
            int cont = 1;

            if (!arLibros.exists()) {
                System.out.println("*******ARCHIVO NO EXISTE************");

            } else {

                FileWriter f = new FileWriter(arLibros);
                PrintWriter d = new PrintWriter(f);
                for (Libro lib : libro) {

//                    f.append(" Persona " + cont);
//                    f.append("Nombre      :" + cli.getNombre());
                    d.println("LIBRO " + cont);
                    d.println("");
                    d.println("Codigo      :" + lib.getCodigo());
                    d.println("Titulo    :" + lib.getTitulo());
                    d.println("Autor      :" + lib.getAutor());
                    d.println("Paginas     :" + lib.getPaginas());
                    d.println("Fecha Edicion       :" + lib.getFechaEdicion());
                    d.println("Precio    :" + lib.getPrecio());
                    d.println("*************************************");
                    cont++;

                }
                f.close();
                d.close();
            }
        } catch (IOException ex) {
        }
    }

    /**
     * 
     * @param parametro
     * @return 
     */
    public boolean buscarPorParametroco(String parametro) {
        boolean bandera = false;
        for (Libro u : libro) {
            if (parametro.equals(u.getCodigo())) {
                bandera = true;
            }
        }
        return bandera;
    }
}
