/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import ec.edu.uce.programacion.excepciones.ControlValidaciones;
import ec.edu.uce.programacion.pojos.Estudiante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class EstudianteMetodos {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public static AdminEstudiantes admEst = new AdminEstudiantes();
    public static ControlValidaciones v = new ControlValidaciones();

    /**
     * Crea tres estudiantes por defecto
     *
     * @throws ParseException
     */
    public void crearEstudiante() throws ParseException {

        admEst.crear(new Estudiante(1, "Eduardo", formato.parse("1993-08-01"), "0988866953", 1));
        admEst.crear(new Estudiante(2, "Paola", formato.parse("1994-01-16"), "0995597027", 4));
        admEst.crear(new Estudiante(3, "Monica", formato.parse("1992-11-01"), "0987794761", 3));
        
    }

    /**
     * Crea un nuevo estudiante
     */
    public void nuevoEstudiante() {
        Estudiante est = new Estudiante();
        try {
            System.out.println("******** NUEVO ESTUDIANTE ************");
            System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE");
            int ss = 0;
            do {
                if (admEst.buscarPorParametroCodig(ss) == true) {
                    System.out.println("<<<EL CODIGO INGRESADO EXISTE INTENTE CON OTRO>>>");
                }
                ss = v.codigo("<<<CODIGO INCORRECTO>>>");
            } while (admEst.buscarPorParametroCodig(ss));
            est.setCodigo(ss);
            System.out.println("INGRESE EL NOMBRE");
            est.setNombre(v.nombre("** NOMBRE NO VALIDO **"));
            System.out.println("INGRESE LA FECHA DE NACIMIENTO");
            est.setFec_nacimento(v.fecha("** FECHA NO VALIDA **"));
            System.out.println("INGRESE EL CELULAR");
            est.setCelular(v.celular("** CELULAR NO VALIDO **"));
            System.out.println("INGRESE EL CURSO");
            est.setCurso(v.curso("** CURSO NO VALIDA **"));
            System.out.println(admEst.crear(est));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Edita los estudiantes que se encuentran en la coleccion
     */
    public void editarEstudiante() {
        System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE QUE DESEA ACTUALIZAR");
        try {
            Integer editar = Integer.parseInt(leer.readLine());
            Estudiante est = (Estudiante) admEst.buscarPorParametro(editar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (est != null) {
                System.out.println("INGRESE EL NOMBRE");
                est.setNombre(v.nombre("** NOMBRE NO VALIDO **"));
                System.out.println("INGRESE LA FECHA DE NACIMIENTO");
                est.setFec_nacimento(v.fecha("** FECHA DE NACIMIENTO INCORRECTA **"));
                System.out.println("INGRESE EL CELULAR");
                est.setCelular(v.celular("** CELULAR NO VALIDO **"));
                System.out.println("INGRESE EL CURSO");
                est.setCurso(v.curso("** CURSO INCORRECTO **"));

                System.out.println(admEst.actualizar(est));
            } else {
                System.out.println("<<<EL ESTUDIANTE NO EXISTE>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina los estudiantes que existe en la coleccion lo busca por codigo para
     * eliminarlo
     */
    public void eliminarEstudiante() {
        try {
            System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE QUE DESEA ELIMINAR");
            Integer eliminar = Integer.parseInt(leer.readLine());
            Estudiante est = (Estudiante) admEst.buscarPorParametro(eliminar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (est != null) {
                if (admEst.borrar(est).equals("borrar")) {
                    System.out.println("<<<EL ESTUDIANTE SE AH ELIMINADO CON EXITO>>>");
                }

            } else {
                System.out.println("<<<EL USUARIO NO EXISTE PARA ELIMINAR>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Busca el estudiante por el codigo
     *
     * @throws IOException
     */
    public void buscarEstudiante() throws IOException {
        System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE QUE DESEA BUSCAR:");
        Integer buscar = Integer.parseInt(leer.readLine());
        Estudiante est = (Estudiante) admEst.buscarPorParametro(buscar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
        if (est != null) {
            System.out.println(est);
        } else {
            System.out.println("<<<NO EXISTE EL ESTUDIANTE>>>");
        }
    }

    /**
     * Lista los estudiantes de toda la coleccion
     */
    public void listarEstudiante() {
        List<Estudiante> lista = admEst.listar();
        for (Estudiante a : lista) {
            System.out.println(a);
            System.out.println("*************************************");
        }
    }

    /**
     * 
     * @return 
     */
    public Estudiante nuevoEst() {
        Estudiante est = new Estudiante();
        try {
            System.out.println("******** NUEVO ESTUDIANTE ************");
            System.out.println("INGRESE EL CODIGO DEL ESTUDIANTE");
            int ss = 0;
            do {
                if (admEst.buscarPorParametroCodig(ss) == true) {
                    System.out.println("<<<EL CODIGO INGRESADO EXISTE INTENTE CON OTRO>>>");
                }
                ss = v.codigo("<<<CODIGO INCORRECTO>>>");
            } while (admEst.buscarPorParametroCodig(ss));
            est.setCodigo(ss);
            System.out.println("INGRESE EL NOMBRE");
            est.setNombre(v.nombre("** NOMBRE NO VALIDO **"));
            System.out.println("INGRESE LA FECHA DE NACIMIENTO");
            est.setFec_nacimento(v.fecha("** FECHA NO VALIDA **"));
            System.out.println("INGRESE EL CELULAR");
            est.setCelular(v.celular("** CELULAR NO VALIDO **"));
            System.out.println("INGRESE EL CURSO");
            est.setCurso(v.curso("** CURSO NO VALIDA **"));
            System.out.println(admEst.crear(est));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return est;
    }

}
