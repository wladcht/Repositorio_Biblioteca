/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class Menu {

    public static AdminUsuarios admUsu = new AdminUsuarios();
    
    BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    UsuarioMetodos u = new UsuarioMetodos();
    EstudianteMetodos d = new EstudianteMetodos();
    LibroMetodos cu = new LibroMetodos();

    /**
     * Menu de login accede con usuarios registrados y con admin
     *
     * @throws IOException
     */
    public void loginUsuario() throws IOException {
        String usuario;
        String pass;
        int aux = 0;
        do {
            //Codigo que genera vista de usuario por escritorio
            System.out.println("**************************");
            System.out.println("*** INGRESO AL SISTEMA ***");
            System.out.println("*** USUARIO :");
            usuario = leer.readLine();
            System.out.println("*** CONTRASEÑA :");
            pass = leer.readLine();
            boolean log = admUsu.verifLogin(usuario, pass);
            if (log == true) {
                aux = 1;
            }
            if (aux == 1) {
                System.out.println(" LAS CREDENCIALES SON CORRECTAS");
            } else {
                System.out.println(" LAS CREDENCIALES INCORRECTAS");
            }
        } while (aux != 1);
    }

    /**
     * Menu Principal (administracion, renta de libros, salir)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuPrincipal() throws IOException, ParseException {
        int op;
        do {
            //Vista del Menu principal por Ventana
            System.out.println("**************************");
            System.out.println("***   MENU PRINCIPAL   ***");
            System.out.println("*** 1: ADMINISTRACION  ***");
            System.out.println("*** 2: RENTA DE LIBROS ***");
            System.out.println("*** 3: SALIR           ***");
            System.out.println("**************************");
            System.out.println(" ELIJA UNA OPCION: ");
            op = Integer.parseInt(leer.readLine());
            //Llama al metodo segun la opcion del menu que escoja 
            switch (op) {
                case 1:
                    menuAdministracion();
                    break;
                case 2:
                    menuRenta();
                    break;
                case 3:
                    System.out.println(" FIN DEL PROGRAMA");
                    System.exit(op);
                default:
                    System.out.println(" opcion no valida ");
                    break;
            }
        } while (op != 3);

    }

    /**
     * Menu de Administracion (usuarios, libros, estudiantes, regresar)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuAdministracion() throws IOException, ParseException {
        int op;
        do {
            System.out.println("***************************");
            System.out.println("***   ADMINISTRACION    ***");
            System.out.println("*** 1: USUARIOS         ***");
            System.out.println("*** 2: LIBROS           ***");
            System.out.println("*** 3: ESTUDIANTES      ***");
            System.out.println("*** 4: REGRESAR         ***");
            System.out.println("***************************");
            System.out.println(" Elija una opcion: ");
            op = Integer.parseInt(leer.readLine());
            switch (op) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuLibro();
                    break;
                case 3:
                    menuEstudiante();
                case 4:
                    menuPrincipal();
                default:
                    System.out.println(" opcion no valida ");
                    break;
            }
        } while (op != 4);
    }

    /**
     * Menu Usuarios (nuevo, editar, eliminar, buscar, listar, regresar)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuUsuario() throws IOException, ParseException {
        int op = 1;
        do {
            //Opciones a realizar con los libros
            System.out.println("***************************");
            System.out.println("*** USUARIO/LIBRO/ESTUDIANTE ***");
            System.out.println("*** 1: Nuevo                 ***");
            System.out.println("*** 2: Editar                ***");
            System.out.println("*** 3: Eliminar              ***");
            System.out.println("*** 4: Buscar                ***");
            System.out.println("*** 5: Listar                ***");
            System.out.println("*** 6: Regresar              ***");
            System.out.println("********************************");
            System.out.println(" ELIJA UNA OPCION: ");
            op = Integer.parseInt(leer.readLine());
            switch (op) {
                case 1:
                    u.nuevoUsuario();
                    break;
                case 2:
                    u.editarUsuario();
                    break;
                case 3:
                    u.eliminarUsuario();
                    break;
                case 4:
                    u.buscarUsuario();
                    break;
                case 5:
                    u.listarUsuario();
                    break;
                case 6:
                    menuAdministracion();
                    break;
                default:
                    System.out.println("<<<OPCION NO VALIDA>>>");
                    break;
            }
        } while (op != 6);
    }

    /**
     * Menu Libro (nuevo, editar, eliminar, buscar, listar, regresar)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuLibro() throws IOException, ParseException {
        int op = 1;
        do {
            System.out.println("***************************");
            System.out.println("*** USUARIO/LIBRO/ESTUDIANTE ***");
            System.out.println("*** 1: Nuevo                 ***");
            System.out.println("*** 2: Editar                ***");
            System.out.println("*** 3: Eliminar              ***");
            System.out.println("*** 4: Buscar                ***");
            System.out.println("*** 5: Listar                ***");
            System.out.println("*** 6: Regresar              ***");
            System.out.println("********************************");
            System.out.println(" ELIJA UNA OPCION: ");
            op = Integer.parseInt(leer.readLine());
            switch (op) {
                case 1:
                    cu.nuevoLibro();
                    break;
                case 2:
                    cu.editarLibro();
                    break;
                case 3:
                    cu.borrarLibro();
                    break;
                case 4:
                    cu.buscarLibro();
                    break;
                case 5:
                    cu.listarLibro();
                    break;
                case 6:
                    menuAdministracion();
                    break;
                default:
                    System.out.println("<<<OPCION NO VALIDA>>>");
                    break;
            }
        } while (op != 6);
    }

    /**
     * Menu Estudiante (nuevo, editar, eliminar, buscar, listar, regresar)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuEstudiante() throws IOException, ParseException {
        int op = 1;
        do {
            System.out.println("***************************");
            System.out.println("*** USUARIO/LIBRO/ESTUDIANTE ***");
            System.out.println("*** 1: Nuevo                 ***");
            System.out.println("*** 2: Editar                ***");
            System.out.println("*** 3: Eliminar              ***");
            System.out.println("*** 4: Buscar                ***");
            System.out.println("*** 5: Listar                ***");
            System.out.println("*** 6: Regresar              ***");
            System.out.println("********************************");
            System.out.println(" ELIJA UNA OPCION: ");
            op = Integer.parseInt(leer.readLine());
            switch (op) {
                case 1:
                    d.nuevoEstudiante();
                    break;
                case 2:
                    d.editarEstudiante();
                    break;
                case 3:
                    d.eliminarEstudiante();
                    break;
                case 4:
                    d.buscarEstudiante();
                    break;
                case 5:
                    d.listarEstudiante();
                    break;
                case 6:
                    menuAdministracion();
                    break;
                default:
                    System.out.println("<<<OPCION NO VALIDA>>>");
                    break;
            }
        } while (op != 6);
    }

    /**
     * Menu de renta de libro(solicita, devuelve)
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuRenta() throws IOException, ParseException {
        int op = 2;
        do {
            System.out.println("******************************");
            System.out.println("***        BIBLIOTECA      ***");
            System.out.println("***   1: SOLICITAR LIBRO   ***");
            System.out.println("***   2: DEVOLVER LIBRO    ***");
            System.out.println("***   3: REGRESAR          ***");
            System.out.println("******************************");
            System.out.println(" ELIJA UNA OPCION: ");
            op = Integer.parseInt(leer.readLine());
            RentaDeLibros rl = new RentaDeLibros();
            switch (op) {
                case 1:
                    rl.solicitarLibro();
                    break;
                case 2:
                    rl.devolverLibro();
                    break;

                case 3:
                    menuPrincipal();
                    break;
                default:
                    System.out.println("<<<OPCION NO VALIDA>>>");
                    break;

            }
        } while (op != 3);
    }
}
