/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import static ec.edu.uce.programacion.clases.EstudianteMetodos.admEst;
import static ec.edu.uce.programacion.clases.LibroMetodos.adminLibro;
import static ec.edu.uce.programacion.clases.LibroMetodos.v;
import ec.edu.uce.programacion.excepciones.ControlValidaciones;
import ec.edu.uce.programacion.pojos.Estudiante;
import ec.edu.uce.programacion.pojos.Libro;
import ec.edu.uce.programacion.pojos.RentaLibro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class RentaDeLibros {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public static ControlValidaciones va = new ControlValidaciones();
    public static EstudianteMetodos em = new EstudianteMetodos();
    public static int nprestamo;

    Menu met = new Menu();

    public static AdminRentaLibro adrl = new AdminRentaLibro();

    public void solicitarLIbro() {
    }

    /**
     * Metodo para solicitar un libro
     */
    public void solicitarLibro() {

        try {
            System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE QUE DESEA SOLICITAR EL LIBRO");
            String aa = va.codigoE("<<<CODIGO NO VALIDO>>>");
            int a = verificarEstudiante(aa);
            if (a == 1) {
                System.out.println("<<<EL ESTUDIANTE NO EXISTE>>>");
                Estudiante e = em.nuevoEst();
                System.out.println(e);
                validacionSolicitud(e);
            }
            if (a == 2) {
                System.out.println("<<<EL ESTUDIANTE EXISTE>>>");
                Estudiante e = (Estudiante) admEst.buscarPorParametroE(Integer.parseInt(aa));
                RentaLibro renta = (RentaLibro) adrl.buscar(e.getCodigo());
                if (renta == null) {
                    validacionSolicitud(e);
                } else {
                    System.out.println("<<<EL ESTUDIANTE YA RENTO UN LIBRO>>>");
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Metodo para validar la solicitud del estudiante
     *
     * @param e
     */
    public void validacionSolicitud(Estudiante e) {

        try {
            System.out.println("INGRESE EL CODIGO DEL LIBRO");
            String lib = v.codigoLibro("<<<CODIGO INGRESADO NO ES VALIDO>>>");
            Libro libro = (Libro) adminLibro.buscarPorParametrocod(lib);
            if (libro != null && libro.isTipo() == true) {
                System.out.println("Numero de prestamo");
                nprestamo += 1;
                System.out.println("n :" + nprestamo);
                Date f;
                Date ff;
                do {

                    System.out.println("Fecha de prestamo");
                    f = v.fechaSolicitud("<<<FECHA NO VALIDA>>>");
                    System.out.println("Fecha de entrega:_____(Fecha de entrega mayor a la de prestamo)");
                    ff = v.fechaSolicitud("<<<FECHA NO VALIDA>>>");

                } while (ff.before(f));
                libro.setTipo(false);
                System.out.println(adrl.crearRenta(new RentaLibro(ff, f, nprestamo, e.getCodigo(), libro.getCodigo())));
            } else if (libro.isTipo() == false) {
                System.out.println("<<<LIBRO NO DISPONIBLE>>>");
            } else {
                System.out.println("<<<EL LIBRO NO EXISTE>>>");
            }
            System.out.println(adminLibro.actualizar(libro));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /* Metodo para verificar si existe el estudiante
     *
     * @param a
     * @return*/
    public int verificarEstudiante(String a) {

        List<Estudiante> est = admEst.listar();
        int bandera = 0;
        for (Estudiante c : est) {
            String d = String.valueOf(c.getCodigo());
            if (d.equals(a)) {
                bandera = 2;
            }

        }
        if (bandera == 2) {
            return 2;

        } else {
            return 1;
        }
    }

    /**
     * Metodo para devolver el libro solicitado anteriormente
     */
    public void devolverLibro() {

        try {
            System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE QUE DESEA DEVOLVER EL LIBRO");
            String aa = va.codigoE("<<<CODIGO NO VALIDO>>>");
            int a = verificarEstudiante(aa);
            if (a == 1) {
                System.out.println("<<<EL ESTUDIANTE NO EXISTE>>>");
            }
            if (a == 2) {
                System.out.println("<<<EL ESTUDIANTE EXISTE>>>");
                Estudiante e = (Estudiante) admEst.buscarPorParametroE(Integer.parseInt(aa));
                RentaLibro renta = (RentaLibro) adrl.buscar(e.getCodigo());
                Libro libro = null;
                if (renta == null) {
                    System.out.println("<<<NO SE HA RENTADO LIBRO>>>");
                } else {

                    libro = (Libro) adminLibro.buscarPorParametrocod(renta.getCodLib());
                    System.out.println("Libro solicitado: " + libro.getCodigo());
                    adrl.borrarRenta(renta);
                    libro.setTipo(true);

                    System.out.println(adminLibro.actualizar(libro));
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
