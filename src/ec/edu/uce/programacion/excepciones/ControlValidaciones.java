/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uce.programacion.excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ANDREA ALVAREZ
 * @version 8.0.2
 */
public class ControlValidaciones {

    static Validaciones n = new Validaciones();
    public static BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
    public SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * valida el codigo
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public Integer codigo(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isCodigo(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return Integer.parseInt(d);
    }

    /**
     * valida el nombre
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String nombre(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isCadena(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida la fecha de nacimiento
     *
     * @param mensaje
     * @return
     * @throws Exception
     */
    public Date fecha(String mensaje) throws Exception {
        String a;
        while (true) {
            a = leer.readLine();
            if (n.isFechaNacimiento(a)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return formato.parse(a);
    }

    /**
     * valida un usuario
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String usuario(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isUsuario(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida la clave
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String claveUsuario(String mensaje) throws IOException {
        String m;
        while (true) {
            m = leer.readLine();
            if (n.isClaveUsuario(m)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return m;
    }

    /**
     * Valida el numero de celular
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String celular(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isCelular(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida el numero de curso
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public Integer curso(String mensaje) throws IOException {
        String c;
        while (true) {
            c = leer.readLine();
            if (n.isCurso(c)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return Integer.parseInt(c);
    }

    /**
     * Valida el codigo del libro
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String codigoLibro(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isCodigoLibro(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida el autor
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String autor(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isAutor(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida las paginas del libro
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public Integer paginas(String mensaje) throws IOException {
        String p;
        while (true) {
            p = leer.readLine();
            if (n.isPaginas(p)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return Integer.parseInt(p);
    }

    /**
     * Valida el precio sea un mumero positivo
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public Double precio(String mensaje) throws IOException {
        String p;
        while (true) {
            p = leer.readLine();
            if (n.isPrecio(p)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }

        return Double.parseDouble(p);
    }

    /**
     * Valida el codigo del estudiante de renta
     *
     * @param mensaje
     * @return
     * @throws IOException
     */
    public String codigoE(String mensaje) throws IOException {
        String d;
        while (true) {
            d = leer.readLine();
            if (n.isCodigo(d)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return d;
    }

    /**
     * Valida la fecha de prestamo y entrega
     *
     * @param mensaje
     * @return
     * @throws Exception
     */
    public Date fechaSolicitud(String mensaje) throws Exception {
        String a;
        while (true) {
            a = leer.readLine();
            if (n.isFechaPrestamoEntrega(a)) {
                break;
            } else {
                System.out.println(mensaje);
            }
        }
        return formato.parse(a);
    }
}
