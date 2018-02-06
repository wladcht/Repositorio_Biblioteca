/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import static ec.edu.uce.programacion.clases.UsuarioMetodos.admUsu;
import ec.edu.uce.programacion.interfaces.InterfazCRUD;
import ec.edu.uce.programacion.pojos.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class AdminUsuarios implements InterfazCRUD {

    //Crea una lista de usuarios
    private ArrayList<Usuario> usuarios = new ArrayList();

    /**
     * Metodo que permite crear en la coleccion un nuevo Objeto de la clase
     * usuario.
     *
     * @param obj
     * @return
     */
    @Override
    public String crear(Object obj) {
        Usuario usuario = (Usuario) obj;
        int bandera = 1;
        for (Usuario usu : usuarios) {
            if (usuario.getCodigo().equals(usu.getCodigo())) {
                bandera = 3;
            }
        }
        if (bandera == 3) {
            return "<<<EL USUARIO YA EXISTE>>>";
        } else {
            usuarios.add(usuario);
            archiUsuario();
            return "<<<EL USUARIO SE AH CREADO>>>";
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
        Usuario usuario = (Usuario) obj;
        int bandera = 1;
        for (Usuario usu : usuarios) {
            if (usuario.getCodigo().equals(usu.getCodigo())) {
                usu = usuario;
                bandera = 3;
            }
        }
        if (bandera == 3) {
            archiUsuario();
            return "<<<USUARIO ACTUALIZADO>>>";
        } else {
            return "<<<USUARIO NO ACTUALIZADO>>>";
        }
    }

    /**
     * Metodo que permite borrar un Objeto de la coleccion
     *
     * @param obj
     * @return
     */
    @Override
    public String borrar(Object obj) {
        usuarios.remove(obj);
        archiUsuario();
        return "borrar";
    }

    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     *
     * @param parametro
     * @return
     */
    @Override
    public Object buscarPorParametro(Object parametro) {
        Integer user = (Integer) (Object) parametro;
        for (Usuario u : usuarios) {
            if (user.equals(u.getCodigo())) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca por el codigo de un usuario en la coleccion si el usuario existe
     * con el mismo codigo.
     *
     * @param str
     * @return boolean
     */
    public boolean buscarPorParametroCodigo(int str) {
        Usuario a = new Usuario();
        boolean aux = false;
        for (Usuario u : usuarios) {
            if (u.getCodigo() == str) {
                a = u;
                aux = true;
            }
        }
        return aux;
    }

    /**
     * Metodo que permita listar los Objetos que se encuentran en la coleccion
     *
     * @return
     */
    @Override
    public List listar() {
        return usuarios;
    }

    /**
     * Agrega toda la coleccion a un archivo llamado Usuarios.txt
     *
     */
    public void archiUsuario() {
        File arUsu = new File("Usuarios.txt");
        List<Usuario> lista = admUsu.listar();
        try {
            int con = 1;
            if (!arUsu.exists()) {
                System.out.println("*** ARCHIVO NO EXISTE ***");
            } else {

                FileWriter c = new FileWriter(arUsu);
                PrintWriter f = new PrintWriter(c);
                FileReader fr = new FileReader(arUsu);
                BufferedReader br = new BufferedReader(fr);
                for (Usuario usu : lista) {

                    f.println("Usuario " + con);
                    f.println("");
                    f.println("Codigo    :" + usu.getCodigo());
                    f.println("Nombre    :" + usu.getNombre());
                    f.println("Fecha Nacimiento      :" + usu.getFec_nacimento());
                    f.println("Usuario     :" + usu.getUsuario());
                    f.println("Clave       :" + usu.getClave());
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

    /**
     * Utilizado para realizar la verificacion de un usuario y contraseña
     * contenidos en la coleccion de usuarios
     *
     * @param usuario
     * @param pass
     * @return true/false
     */
    public boolean verifLogin(String usuario, String pass) {
        boolean aux = false;
        List<Usuario> lista = admUsu.listar();
        for (Usuario u : lista) {
            if (usuario.equalsIgnoreCase(u.getUsuario()) && pass.equalsIgnoreCase(u.getClave())
                    || usuario.equalsIgnoreCase("admin") && usuario.equalsIgnoreCase("admin")) {
                aux = true;
            }
        }
        return aux;
    }
}
