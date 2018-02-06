/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import ec.edu.uce.programacion.excepciones.ControlValidaciones;
import ec.edu.uce.programacion.pojos.Usuario;
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
public class UsuarioMetodos {

    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    public static AdminUsuarios admUsu = new AdminUsuarios();
    public static ControlValidaciones v = new ControlValidaciones();

    /**
     * Crea tres usuarios por defecto
     *
     * @throws ParseException
     */
    public void crearUsuario() throws ParseException {

        admUsu.crear(new Usuario(100, "Andrea", formato.parse("1992-12-10"), "Andre", "Andre92"));
        admUsu.crear(new Usuario(200, "Alex", formato.parse("1986-06-26"), "Alex", "Alex86"));
        admUsu.crear(new Usuario(300, "Gabriela", formato.parse("1993-01-10"), "Gaby", "Gaby93"));

    }

    /**
     * Metodo para crea un nuevo usuario
     */
    public void nuevoUsuario() {
        Usuario usu = new Usuario();
        try {
            System.out.println("******** NUEVO USUARIO ***********");
            System.out.println("INGRESE EL CODIGO");
            int ss = 0;
            do {
                if (admUsu.buscarPorParametroCodigo(ss) == true) {
                    System.out.println("<<<EL CODIGO INGRESADO EXISTE INTENTE CON OTRO>>>");
                }
                ss = v.codigo("<<<CODIGO INCORRECTO>>>");
            } while (admUsu.buscarPorParametroCodigo(ss));
            usu.setCodigo(ss);
            System.out.println("INGRESE EL NOMBRE");
            usu.setNombre(v.nombre("** NOMBRE NO VALIDO **"));
            System.out.println("INGRESE LA FECHA DE NACIMIENTO");
            usu.setFec_nacimento(v.fecha("** Fecha Incorrecta **"));
            System.out.println("INGRESE EL USUARIO");
            usu.setUsuario(v.usuario("** USUARIO NO VALIDO **"));
            System.out.println("INGRESE LA CLAVE");
            usu.setClave(v.claveUsuario("** CLAVE NO VALIDA **"));
            System.out.println(admUsu.crear(usu));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para edita los usuarios que se encuentran en la coleccion
     */
    public void editarUsuario() {
        System.out.println("INGRESE EL CODIGO DEL USUARIO QUE DESEE EDITAR");
        try {
            Integer editar = Integer.parseInt(leer.readLine());
            Usuario usu = (Usuario) admUsu.buscarPorParametro(editar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (usu != null) {
                System.out.println("INGRESE EL NOMBRE");
                usu.setNombre(v.nombre("** NOMBRE NO VALIDO **"));
                System.out.println("INGRESE LA FECHA DE NACIMIENTO");
                usu.setFec_nacimento(v.fecha("** FECHA DE NACIMIENTO INCORRECTA **"));
                System.out.println("INGRESE EL USUARIO");
                usu.setUsuario(v.usuario("** USUARIO NO VALIDO **"));
                System.out.println("INGRESE LA CLAVE");
                usu.setClave(v.claveUsuario("** CLAVE INCORRECTA **"));
                System.out.println(admUsu.actualizar(usu));
            } else {
                System.out.println("<<<EL USUARIO NO EXISTE>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para elimina los usuarios que existe en la coleccion
     *
     */
    public void eliminarUsuario() {
        try {
            System.out.println("INGRESE EL CODIGO DEL USUARIO QUE DESEA ELIMINAR");
            Integer eliminar = Integer.parseInt(leer.readLine());
            Usuario usu = (Usuario) admUsu.buscarPorParametro(eliminar);//el metodo buscar por parametro retorno un objeto por lo que se hace castinng.
            if (usu != null) {
                if (admUsu.borrar(usu).equals("borrar")) {
                    System.out.println("<<<EL USUARIO SE AH ELIMINADO CON EXITO>>>");
                }

            } else {
                System.out.println("<<<EL USUARIO NO EXISTE PARA ELIMINAR>>>");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo para buscar un usuario de la coleccion
     *
     * @throws IOException
     */
    public void buscarUsuario() throws IOException {
        System.out.println("INGRESE EL CODIGO DEL USUARIO QUE DESEA BUSCAR:");
        Integer buscar = Integer.parseInt(leer.readLine());
        Usuario usu = (Usuario) admUsu.buscarPorParametro(buscar);// casting para tratar el objeto com Usuario
        if (usu != null) {
            System.out.println(usu);
        } else {
            System.out.println("<<<NO EXISTE EL USUARIO>>>");
        }
    }

    /**
     * Metodo para listar los usuarios de la coleccion
     */
    public void listarUsuario() {
        List<Usuario> lista = admUsu.listar();
        for (Usuario a : lista) {
            System.out.println(a);
            System.out.println("*************************************");
        }
    }

}
