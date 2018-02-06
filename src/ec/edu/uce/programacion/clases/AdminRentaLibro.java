/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import static ec.edu.uce.programacion.clases.RentaDeLibros.adrl;
import ec.edu.uce.programacion.interfaces.InterfazCRUD;
import ec.edu.uce.programacion.pojos.RentaLibro;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class AdminRentaLibro implements InterfazCRUD {

    // Creo una lista renta delibros 
    private static ArrayList<RentaLibro> libro = new ArrayList();

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public String crear(Object obj) {
        libro.add((RentaLibro) obj);
        archiRenta();
        return "<<<Estudiante actualizado>>>";
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public String actualizar(Object obj) {
        RentaLibro lib = (RentaLibro) obj;
        int bandera = 1;
        for (RentaLibro c : libro) {
            if (lib.getCodLib().equals(c.getCodLib())) {
                c = lib;
                bandera = 2;
            }
        }
        if (bandera == 2) {

            archiRenta();
            return "Estudiante Actualizado";
        } else {
            return "Estudiante no actualizado";
        }
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public String borrar(Object obj) {
        return null;
    }

    /**
     *
     * @param parametro
     * @return
     */
    @Override
    public Object buscarPorParametro(Object parametro) {
        String user = (String.valueOf(parametro));
        for (RentaLibro u : libro) {
            if (user.equals(u.getCod())) {
                return u;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public List listar() {
        return libro;
    }

    /**
     * Metodo para buscar por parametro y compararlo con codigo del estudiante
     *
     * @param parametro
     * @return
     */
    public Object buscar(int parametro) {
        RentaLibro a = null;
        for (RentaLibro u : libro) {
            if (parametro == u.getCod()) {
                a = u;
            }
        }
        return a;
    }

    /**
     * Crea una renta para el libro
     *
     * @param obj
     * @return mensaje
     */
    public String crearRenta(RentaLibro obj) {
        libro.add(obj);
        archiRenta();
        return "*******************";
    }

    /**
     * Borra la renta del libro
     *
     * @param obj
     * @return
     */
    public String borrarRenta(RentaLibro obj) {
        libro.remove(obj);
        archiRenta();
        return "*******************";
    }

    /**
     * Agrega toda la coleccion a un archivo llamado Usuarios.txt
     *
     *
     */
    public void archiRenta() {
        File arRenta = new File("RentaLibro.txt");
        List<RentaLibro> lista = adrl.listar();
        try {
            int con = 1;
            if (!arRenta.exists()) {
                System.out.println("*** ARCHIVO NO EXISTE ***");
            } else {
                FileWriter c = new FileWriter(arRenta);
                PrintWriter f = new PrintWriter(c);
                for (RentaLibro reLi : lista) {

                    f.println("Renta de Libro: " + con);
                    f.println("");
                    f.println("Codigo del Estudiante    :" + reLi.getCod());
                    f.println("Codigo del Libro       :" + reLi.getCodLib());
                    f.println("Fecha de Entrega    :" + reLi.getFechaEntrega());
                    f.println("Fecha de Prestamo    :" + reLi.getFechaPrestamo());
                    f.println("Numero de Prestamo      :" + reLi.getNumeroPrestamo());

                    f.println("*************************************");
                    con++;

                }
                c.close();
                f.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
