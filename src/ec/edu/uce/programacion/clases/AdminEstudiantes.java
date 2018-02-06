/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import static ec.edu.uce.programacion.clases.EstudianteMetodos.admEst;
import ec.edu.uce.programacion.interfaces.InterfazCRUD;
import ec.edu.uce.programacion.pojos.Estudiante;
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
public class AdminEstudiantes implements InterfazCRUD {

    //Creo una lista de estudiantes
    private ArrayList<Estudiante> estudiantes = new ArrayList();

    /**
     * Metodo que permite crear en la coleccion 
     *
     * @param obj
     * @return mensaje
     */
    @Override
    public String crear(Object obj) {

        Estudiante estu = (Estudiante) obj;
        int bandera = 1;
        for (Estudiante est : estudiantes) {
            if (estu.getCodigo().equals(est.getCodigo())) {
                bandera = 3;
            }
        }
        if (bandera == 3) {
            return "<<<EL USUARIO YA EXISTE>>>";
        } else {
            estudiantes.add(estu);
            archiEstu();
            return "<<<EL USUARIO SE AH CREADO>>>";
        }
    }

    /**
     * Metodo que permite actualizar el estado de un Objeto dentro de la
     * coleccion
     *
     * @param obj
     * @return mensaje
     */
    @Override
    public String actualizar(Object obj) {
        Estudiante estudiante = (Estudiante) obj;
        int bandera = 1;
        for (Estudiante usu : estudiantes) {
            if (estudiante.getCodigo().equals(usu.getCodigo())) {
                usu = estudiante;
                bandera = 3;
            }
        }
        if (bandera == 3) {
            archiEstu();
            return "<<<USUARIO ACTUALIZADO>>>";
        } else {
            return "<<<USUARIO NO ACTUALIZADO>>>";
        }
    }

    /**
     * Metodo que permite borrar un Objeto de la coleccion
     *
     * @param obj
     * @return mensaje
     */
    @Override
    public String borrar(Object obj) {
        estudiantes.remove(obj);
        archiEstu();
        return "borrar";
    }

    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     *
     * @return obj
     */
    @Override
    public Object buscarPorParametro(Object parametro) {
        Integer user = (Integer) (Object) parametro;
        for (Estudiante u : estudiantes) {
            if (user.equals(u.getCodigo())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca por el codigo al estudiante en la coleccion
     *
     * @param obj
     * @return boolean
     */
    public boolean buscarPorParametroCodig(int str) {
        Estudiante a = new Estudiante();
        boolean aux = false;
        for (Estudiante u : estudiantes) {
            if (u.getCodigo() == str) {
                a = u;
                aux = true;
            }
        }
        return aux;
    }

    /**
     * Busca por el codigo al estudiante en la coleccion
     * @param parametro
     * @return
     */
    public Object buscarPorParametroE(int parametro) {
        for (Estudiante u : estudiantes) {
            if (parametro == (u.getCodigo())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Metodo que permita listar los Objetos que se encuentran en la coleccion
     *
     * @param obj
     * @return list
     */
    @Override
    public List listar() {
        return estudiantes;
    }

    /**
     * Agrega toda la coleccion a un archivo llamado Estudiantes.txt
     *
     */
    public void archiEstu() {
        File arEst = new File("Estudiantes.txt");
        List<Estudiante> lista = admEst.listar();
        try {
            int con = 1;
            if (!arEst.exists()) {
                System.out.println("*** ARCHIVO NO EXISTE ***");
            } else {
                FileWriter c = new FileWriter(arEst);
                PrintWriter f = new PrintWriter(c);
                for (Estudiante est : lista) {

                    f.println("Estudiante " + con);
                    f.println("");
                    f.println("Codigo    :" + est.getCodigo());
                    f.println("Nombre    :" + est.getNombre());
                    f.println("Fecha Nacimiento      :" + est.getFec_nacimento());
                    f.println("Celular     :" + est.getCelular());
                    f.println("Curso       :" + est.getCurso());
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

//Prueba de comentario 

