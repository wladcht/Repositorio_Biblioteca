/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import ec.edu.uce.programacion.excepciones.ControlValidaciones;
import ec.edu.uce.programacion.pojos.Libro;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class LibroMetodos {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public static AdminLibros adminLibro = new AdminLibros();
    public static ControlValidaciones v = new ControlValidaciones();

    /**
     * Crea tres libros por defecto
     *
     * @throws ParseException
     */
    public void crearLibro() throws ParseException {

        adminLibro.crear(new Libro("A21", "EL ALQUIMISTA", "PAULO COHELLO", 567, formato.parse("2008-10-17"), 100.0));
        adminLibro.crear(new Libro("B22", "LAGUNA AZUL", "MARIO CONDE", 465, formato.parse("2010-11-26"), 2000.0));
        adminLibro.crear(new Libro("C23", "EL PSIQUICO", "HENRY BARXS", 509, formato.parse("2011-08-18"), 300.0));

    }

    /**
     * Metodo para crea un nuevo libro
     */
    public void nuevoLibro() {
        try {
            Libro libro = new Libro();
            System.out.println("INGRESE EL CODIGO");
            String aux = " ";
            do {
                if (adminLibro.buscarPorParametroCodigo(aux) == true) {
                    System.out.println("****El codigo ingresado existe intente con otro *****");
                }
                aux = v.codigoLibro("** CODIGO INCORRECTO **");
            } while (adminLibro.buscarPorParametroCodigo(aux));
            libro.setCodigo(aux);

            System.out.println("INGRESE EL TITULO DEL LIBRO");
            libro.setTitulo(v.nombre("** TITULO NO VALIDO **"));

            System.out.println("INGRESE EL AUTOR DEL LIBRO");
            libro.setAutor(v.autor("** AUTOR NO VALIDO **"));

            System.out.println("INGRESE LAS PAGINAS DEL LIBRO");
            libro.setPaginas(v.paginas("** PAGINAS NO VALIDAS **"));

            System.out.println("INGRESE LA FECHA DE EDICION DEL LIBRO");
            // Validar edicion
            libro.setFechaEdicion(v.fecha("** FECHA NO VALIDA **"));

            System.out.println("INGRESE EL PRECIO DEL LIBRO");
            libro.setPrecio(v.precio("** PRECIO INCORRECTO **"));

            System.out.println(adminLibro.crear(libro));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Edita el libro que esta en la coleccion
     */
    public void editarLibro() {
        System.out.println("INGRESE EL CODIGO DEL LIBRO QUE DESEA EDITAR");
        try {
            String buscar = leer.readLine();
            Libro libro = (Libro) adminLibro.buscarPorParametrocod(buscar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (libro != null) {

                System.out.println("INGRESE EL TITULO DEL LIBRO");
                libro.setTitulo(v.nombre("** TITULO NO VALIDO **"));

                System.out.println("INGRESE EL AUTOR DEL LIBRO");
                libro.setAutor(v.autor("** AUTOR NO VALIDO **"));

                System.out.println("INGRESE LAS PAGINAS DEL LIBRO");
                libro.setPaginas(v.paginas("** PAGINAS NO VALIDAS **"));

                System.out.println("INGRESE LA FECHA DE EDICION DEL LIBRO");
                libro.setFechaEdicion(v.fecha("** FECHA NO VALIDA **"));

                System.out.println("INGRESE EL PRECIO DEL LIBRO");
                libro.setPrecio(v.precio("** PRECIO INCORRECTO **"));

                System.out.println(adminLibro.actualizar(libro));
            } else {
                System.out.println("<<<LIBRO INGRESA NO EXISTE>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para borrar los libros que exista en la coleccion
     */
    public void borrarLibro() {
        try {
            System.out.println("INGRESE EL CODIGO DEL LIBRO");
            String borrar = leer.readLine();
            Libro libro = (Libro) adminLibro.buscarPorParametrocod(borrar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (libro != null) {
                if (adminLibro.borrar(libro).equals("borrar")) {
                    System.out.println("<<<BORRADO EXITOSAMENTE>>>");
                } else {
                    System.out.println("<<<NO SE HA BORRADO EL LIBRO>>>");
                }
               }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Busca los libros por el codigo del libro.
     */
    public void buscarLibro() {
        try {
            System.out.println("INGRESE EL CODIGO DEL LIBRO");
            String buscar = leer.readLine();
            Libro libro = (Libro) adminLibro.buscarPorParametrocod(buscar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (libro != null) {
                System.out.println(libro);
            } else {
                System.out.println("<<<EL LIBRO NO AH SIDO ENCONTRADO>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     *Lista todos los libros de la coleccion
     */
    public void listarLibro() {
        List<Libro> lista = adminLibro.listar();
        for (Libro c : lista) {
            System.out.println(c);
            System.out.println("*************************************");
        }
    }
    
   

}
