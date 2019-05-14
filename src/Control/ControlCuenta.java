/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.CuentaUsuario;
import Vista.Cuenta;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlCuenta {

    //Método para insertar un registro a la base de datos
    //Sin embargo, se envía la sentencia a la clase cuentaUsuario
    //Donde se establecerá la conexión con la BD para enviarlo
    //a la BD correspondiente
    public boolean insertarCuenta(CuentaUsuario cuenta1) {

        boolean t = false;

        //String insertarSQL = "INSERT INTO cuentas(NombreUsuario, Nombre1c, Nombre2c, Apellido1c, Apellido2c, Email, Contrasena, Genero, Fecha_Nacimiento, Fecha_Creacion, Foto)"
        //+ "values(?,?,?,?,?,?,?,?,?,?,?)";
        String insertarSQL = "call InsertarCuenta(?,?,?,?,?,?,?,?,?,?,?)";
        t = cuenta1.insertarCuentas(cuenta1, insertarSQL);

        return t;

    }//Fin método

    //Método que mediante la sentencia SQL trae los datos correspondiente a la cuenta ingresada
    public CuentaUsuario LeerCuenta(String nombreUsuario) {

        ResultSet rset;
        CuentaUsuario cuenta2 = new CuentaUsuario();
        CuentaUsuario cuentaEnvio = null;

        String leerSQL = "SELECT * FROM cuentas WHERE NombreUsuario = '" + nombreUsuario + "'";

        rset = cuenta2.TraerCuenta(leerSQL);

        try {

            while (rset.next()) {

                String NombreUsuario = rset.getString("NombreUsuario");
                String Nombre1c = rset.getString("Nombre1c");
                String Nombre2c = rset.getString("Nombre2c");
                String Apellido1c = rset.getString("Apellido1c");
                String Apellido2c = rset.getString("Apellido2c");
                String Genero = rset.getString("Genero");
                String Email = rset.getString("Email");
                String Contrasena = rset.getString("Contrasena");
                String Fecha_Creacion = rset.getString("Fecha_Creacion");
                String Fecha_Nacimiento = rset.getString("Fecha_Nacimiento");
                //Se trae la foto que quedó guardada de tipo blob en BD a 
                Blob blob = rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] data = blob.getBytes(1, (int) blob.length());

                cuentaEnvio = new CuentaUsuario(Nombre1c, Nombre2c, Apellido1c, Apellido2c, NombreUsuario, Genero, Email, Contrasena, Fecha_Creacion, Fecha_Nacimiento, data);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return cuentaEnvio;

    }//Fin método

    //******************************************************************************************************************************************
    public boolean ModificarDatosCuenta(CuentaUsuario cuenta, String NombreUsuario) {

        CuentaUsuario cuenta3 = new CuentaUsuario();

        boolean t = false;

        String ModificarSQL = "UPDATE cuentas SET Nombre1c = ?, Nombre2c = ?, Apellido1c = ?, Apellido2c = ?, Email = ?, Contrasena = ?, Genero = ?, Fecha_Nacimiento = ?, Fecha_Creacion = ? WHERE NombreUsuario = '" + NombreUsuario + "'";

        t = cuenta3.ModificarDato1(cuenta, ModificarSQL);

        return t;

    }//Fin método

    public boolean ModificarDatosCuentaFoto(CuentaUsuario cuentaU, String NombreUsuarioModificar) {

        CuentaUsuario cuenta3 = new CuentaUsuario();

        boolean t = false;

        String ModificarSQL = "UPDATE cuentas SET Nombre1c = ?, Nombre2c = ?, Apellido1c = ?, Apellido2c = ?, Email = ?, Contrasena = ?, Genero = ?, Fecha_Nacimiento = ?, Fecha_Creacion = ?, Foto = ? WHERE NombreUsuario = '" + NombreUsuarioModificar + "'";

        t = cuenta3.ModificarDato(cuentaU, ModificarSQL);

        return t;

    }//Fin método

    //******************************************************************************************************************************************
    public boolean EliminarCuenta(String NombreUsuario) {

        CuentaUsuario cuenta4 = new CuentaUsuario();

        boolean t = false;

        String EliminarSQL = "DELETE FROM cuentas WHERE NombreUsuario = '" + NombreUsuario + "'";

        t = cuenta4.Eliminarcuentas(EliminarSQL);

        return t;

    }//Fin método

    public LinkedList<CuentaUsuario> TraerCuentasRegistradas() {

        LinkedList<CuentaUsuario> cuentasRegistradas = new LinkedList<>();

        CuentaUsuario cuenta = new CuentaUsuario();
        CuentaUsuario cRegistrada = null;
        ResultSet rset = null;

        String LeerSQL = "SELECT * FROM cuentas";

        rset = cuenta.TraerCuenta(LeerSQL);

        try {

            while (rset.next()) {

                String NombreUsuario = rset.getString("NombreUsuario");
                String Nombre1c = rset.getString("Nombre1c");
                String Nombre2c = rset.getString("Nombre2c");
                String Apellido1c = rset.getString("Apellido1c");
                String Apellido2c = rset.getString("Apellido2c");
                String Genero = rset.getString("Genero");
                String Email = rset.getString("Email");
                String Contrasena = rset.getString("Contrasena");
                String Fecha_Creacion = rset.getString("Fecha_Creacion");
                String Fecha_Nacimiento = rset.getString("Fecha_Nacimiento");

                cRegistrada = new CuentaUsuario(Nombre1c, Nombre2c, Apellido1c, Apellido2c, NombreUsuario, Genero, Email, Contrasena, Fecha_Creacion, Fecha_Nacimiento);

                cuentasRegistradas.add(cRegistrada);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return cuentasRegistradas;

    }//Fin método
    
    //*************************************************************************************************************************************************************************
    //Métodos donde se aplica el concepto JOIN. Asimismo, involucra store procedure.

    public LinkedList<String> TraerCuentasImagenes() {

        LinkedList<String> cuentasImagenes = new LinkedList<>();

        String Dato = "";

        CuentaUsuario cuenta = new CuentaUsuario();
        ResultSet rset = null;

        //String LeerSQL = "call CuentasImagenes_LeftJoin()";
        String LeerSQL = "select * from cuentasimagenes_leftjoin_view";

        rset = cuenta.TraerCuenta(LeerSQL);

        try {

            while (rset.next()) {

                String NombreUsuario = rset.getString("NombreUsuario");
                String Nombres = rset.getString("NombreCuenta");
                String NombreImagen = rset.getString("NombreImagen");
                String FechaSubida = rset.getString("FechaSubidaI");
                String Formato = rset.getString("Formato_Imagen");
                String Resolucion = rset.getString("Resolucion");
                String Categoria = rset.getString("NombreCategoria");

                Dato = NombreUsuario + "," + Nombres + "," + NombreImagen + "," + FechaSubida + "," + Formato + "," + Resolucion + "," + Categoria;

                cuentasImagenes.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return cuentasImagenes;

    }//Fin método

    public LinkedList<String> TraerCuentasVideo() {

        LinkedList<String> cuentasVideos = new LinkedList<>();

        String Dato = "";

        CuentaUsuario cuenta = new CuentaUsuario();
        ResultSet rset = null;

        String LeerSQL = "call CuentasVideos_LeftJoin()";

        rset = cuenta.TraerCuenta(LeerSQL);

        try {

            while (rset.next()) {

                String NombreUsuario = rset.getString("NombreUsuario");
                String Nombres = rset.getString("NombreCuenta");
                String NombreVideo = rset.getString("NombreVideo");
                String FechaSubida = rset.getString("FechaSubidaV");
                String Formato = rset.getString("Formato_Video");
                String Duracion = rset.getString("DuracionVideo");
                String Categoria = rset.getString("NombreCategoria");

                Dato = NombreUsuario + "," + Nombres + "," + NombreVideo + "," + FechaSubida + "," + Formato + "," + Duracion + "," + Categoria;

                cuentasVideos.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return cuentasVideos;

    }//Fin método
    
      public LinkedList<String> TraerCuentasAudios() {

        LinkedList<String> cuentasAudios = new LinkedList<>();

        String Dato = "";

        CuentaUsuario cuenta = new CuentaUsuario();
        ResultSet rset = null;

        String LeerSQL = "call CuentasAudios_LeftJoin()";

        rset = cuenta.TraerCuenta(LeerSQL);

        try {

            while (rset.next()) {

                String NombreUsuario = rset.getString("NombreUsuario");
                String Nombres = rset.getString("NombreCuenta");
                String NombreAudio = rset.getString("NombreAudio");
                String FechaSubida = rset.getString("FechaSubidaA");
                String Formato = rset.getString("Formato_Audio");
                String TamanoA = rset.getString("TamanoAudio");
                String Duracion = rset.getString("DuracionAudio");
                String Categoria = rset.getString("NombreCategoria");

                Dato = NombreUsuario + "," + Nombres + "," + NombreAudio + "," + FechaSubida + "," + Formato + "," + TamanoA + "," + Duracion + "," + Categoria;

                cuentasAudios.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return cuentasAudios;

    }//Fin método

}
