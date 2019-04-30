/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ConnectBD;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CuentaUsuario {

    private String Nombre1c;
    private String Nombre2c;
    private String Apellido1c;
    private String Apellido2c;
    private String NombreUsuario;
    private String Genero;
    private String Email;
    private String Contrasena;
    private String Fecha_Creacion;
    private String Fecha_Nacimiento;
    private String Foto;
    private byte[] FotoPerfil;

    public CuentaUsuario() {
    }

    public CuentaUsuario(String Nombre1c, String Nombre2c, String Apellido1c, String Apellido2c, String NombreUsuario, String Genero, String Email, String Contrasena, String Fecha_Creacion, String Fecha_Nacimiento, String Foto) {
        this.Nombre1c = Nombre1c;
        this.Nombre2c = Nombre2c;
        this.Apellido1c = Apellido1c;
        this.Apellido2c = Apellido2c;
        this.NombreUsuario = NombreUsuario;
        this.Genero = Genero;
        this.Email = Email;
        this.Contrasena = Contrasena;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Foto = Foto;
    }

    public CuentaUsuario(String Nombre1c, String Nombre2c, String Apellido1c, String Apellido2c, String NombreUsuario, String Genero, String Email, String Contrasena, String Fecha_Creacion, String Fecha_Nacimiento, byte[] FotoPerfil) {
        this.Nombre1c = Nombre1c;
        this.Nombre2c = Nombre2c;
        this.Apellido1c = Apellido1c;
        this.Apellido2c = Apellido2c;
        this.NombreUsuario = NombreUsuario;
        this.Genero = Genero;
        this.Email = Email;
        this.Contrasena = Contrasena;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.FotoPerfil = FotoPerfil;
    }

    public CuentaUsuario(String Nombre1c, String Nombre2c, String Apellido1c, String Apellido2c, String NombreUsuario, String Genero, String Email, String Contrasena, String Fecha_Creacion, String Fecha_Nacimiento) {
        this.Nombre1c = Nombre1c;
        this.Nombre2c = Nombre2c;
        this.Apellido1c = Apellido1c;
        this.Apellido2c = Apellido2c;
        this.NombreUsuario = NombreUsuario;
        this.Genero = Genero;
        this.Email = Email;
        this.Contrasena = Contrasena;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getNombre1c() {
        return Nombre1c;
    }

    public void setNombre1c(String Nombre1c) {
        this.Nombre1c = Nombre1c;
    }

    public String getNombre2c() {
        return Nombre2c;
    }

    public void setNombre2c(String Nombre2c) {
        this.Nombre2c = Nombre2c;
    }

    public String getApellido1c() {
        return Apellido1c;
    }

    public void setApellido1c(String Apellido1c) {
        this.Apellido1c = Apellido1c;
    }

    public String getApellido2c() {
        return Apellido2c;
    }

    public void setApellido2c(String Apellido2c) {
        this.Apellido2c = Apellido2c;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(String Fecha_Creacion) {
        this.Fecha_Creacion = Fecha_Creacion;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public byte[] getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(byte[] FotoPerfil) {
        this.FotoPerfil = FotoPerfil;
    }

    //Método que genera la conexión para enviar SQL para la base de datos
    public boolean insertarCuentas(CuentaUsuario cuenta1, String insertarSQL) {

        ConnectBD CBD = new ConnectBD();
        FileInputStream fis = null;
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                File file = new File(cuenta1.getFoto());
                fis = new FileInputStream(file);
                ps = CBD.getConexion().prepareStatement(insertarSQL);

                ps.setString(1, cuenta1.getNombreUsuario());
                ps.setString(2, cuenta1.getNombre1c());
                ps.setString(3, cuenta1.getNombre2c());
                ps.setString(4, cuenta1.getApellido1c());
                ps.setString(5, cuenta1.getApellido2c());
                ps.setString(6, cuenta1.getEmail());
                ps.setString(7, cuenta1.getContrasena());
                ps.setString(8, cuenta1.getGenero());
                
                //Si la fecha de nacimiento no fue seleccionada, ese campo 
                //será llenado con un null en la base de datos
                if(cuenta1.getFecha_Nacimiento().equals("00-00-00")){
                    
                    ps.setString(9, null);
                    
                }else{
                    
                    ps.setString(9, cuenta1.getFecha_Nacimiento());
                    
                }//Fin if               
                
                ps.setString(10, cuenta1.getFecha_Creacion());

                ps.setBinaryStream(11, fis, (int) file.length());

                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();
                fis.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin carch2

        }//Fin finally

        return f;

    }

    public ResultSet TraerCuenta(String leerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(leerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }
        }

        return rset;

    }//Fin método

    public boolean ModificarDato1(CuentaUsuario cuenta, String ModificarSQL) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);
                
                ps = CBD.getConexion().prepareStatement(ModificarSQL);

                ps.setString(1, cuenta.getNombre1c());
                ps.setString(2, cuenta.getNombre2c());
                ps.setString(3, cuenta.getApellido1c());
                ps.setString(4, cuenta.getApellido2c());
                ps.setString(5, cuenta.getEmail());
                ps.setString(6, cuenta.getContrasena());
                ps.setString(7, cuenta.getGenero());
                ps.setString(8, cuenta.getFecha_Nacimiento());
                ps.setString(9, cuenta.getFecha_Creacion());

                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin finally

        return f;

    }//Fin método

    public boolean Eliminarcuentas(String EliminarSQL) {

        ConnectBD CBD = new ConnectBD();

        boolean f = false;

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                CBD.getSt().executeUpdate(EliminarSQL);

                f = true;

            } catch (Exception ex) {

                ex.printStackTrace();
                f = false;

            }
        }

        return f;

    }//Fin método

    //Método para modificar datos de la cuenta del usuario
    public boolean ModificarDato(CuentaUsuario cuenta, String ModificarSQL) {

        ConnectBD CBD = new ConnectBD();
        FileInputStream fis = null;
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                File file = new File(cuenta.getFoto());
                fis = new FileInputStream(file);
                ps = CBD.getConexion().prepareStatement(ModificarSQL);

                ps.setString(1, cuenta.getNombre1c());
                ps.setString(2, cuenta.getNombre2c());
                ps.setString(3, cuenta.getApellido1c());
                ps.setString(4, cuenta.getApellido2c());
                ps.setString(5, cuenta.getEmail());
                ps.setString(6, cuenta.getContrasena());
                ps.setString(7, cuenta.getGenero());
                ps.setString(8, cuenta.getFecha_Nacimiento());
                ps.setString(9, cuenta.getFecha_Creacion());

                ps.setBinaryStream(10, fis, (int) file.length());

                ps.executeUpdate();

                CBD.getConexion().commit();

                f = true;

            }//Fin if

        } catch (Exception ex) {

            f = false;
            JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        } finally {

            try {

                ps.close();
                fis.close();

            } catch (Exception e) {

                f = false;
                JOptionPane.showMessageDialog(null, "Error al guardar los datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin catch2

        }//Fin finally

        return f;

    }//Fin método

}
