/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.principal;

import ec.edu.uce.programacion.clases.EstudianteMetodos;
import ec.edu.uce.programacion.clases.LibroMetodos;
import ec.edu.uce.programacion.clases.Menu;
import ec.edu.uce.programacion.clases.UsuarioMetodos;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class Principal {

    BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        UsuarioMetodos u = new UsuarioMetodos();
        EstudianteMetodos es = new EstudianteMetodos();
        LibroMetodos lm = new LibroMetodos();
        Menu me = new Menu();

        File arEst = new File("Estudiantes.txt");
        File arUsu = new File("Usuarios.txt");
        File arLibros = new File("Libro.txt");
        File arRenta = new File("RentaLibro.txt");
        if (!arEst.exists()) {
            arEst.createNewFile();
        }
        if (!arUsu.exists()) {
            arUsu.createNewFile();
        }
        if (!arLibros.exists()) {
            arLibros.createNewFile();
        }

        if (!arRenta.exists()) {
            arRenta.createNewFile();
        }

        u.crearUsuario();
        es.crearEstudiante();
        lm.crearLibro();
        me.loginUsuario();
        me.menuPrincipal();

    }

}
