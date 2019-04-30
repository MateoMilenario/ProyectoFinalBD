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
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class Imagen {

    private String fechaSubidaI;
    private String NombreImagen;
    private String Formato_Imagen;
    private String DescripcionImagen;
    private String Resolucion;
    private String Imagen;
    private byte[] ImagenCuenta;

    //*****************************
    private String categoriaImagen;
    private String IdImagen;
    private String NombreUsuario;
    private byte[] ImagenUsuario;

    //************************************************************************************************************************************************************************************
    public Imagen() {
    }

    public Imagen(String fechaSubidaI, String NombreImagen, String Formato_Imagen, String DescripcionImagen, String Resolucion, String Imagen) {
        this.fechaSubidaI = fechaSubidaI;
        this.NombreImagen = NombreImagen;
        this.Formato_Imagen = Formato_Imagen;
        this.DescripcionImagen = DescripcionImagen;
        this.Resolucion = Resolucion;
        this.Imagen = Imagen;
    }

    public Imagen(String fechaSubidaI, String NombreImagen, String Formato_Imagen, String DescripcionImagen, String Resolucion, byte[] ImagenCuenta, String categoriaImagen, String IdImagen) {
        this.fechaSubidaI = fechaSubidaI;
        this.NombreImagen = NombreImagen;
        this.Formato_Imagen = Formato_Imagen;
        this.DescripcionImagen = DescripcionImagen;
        this.Resolucion = Resolucion;
        this.ImagenCuenta = ImagenCuenta;
        this.categoriaImagen = categoriaImagen;
        this.IdImagen = IdImagen;
    }

    public Imagen(String fechaSubidaI, String NombreImagen, String Formato_Imagen, String DescripcionImagen, String Resolucion, byte[] ImagenCuenta, String categoriaImagen, String IdImagen, String NombreUsuario, byte[] ImagenUsuario) {
        this.fechaSubidaI = fechaSubidaI;
        this.NombreImagen = NombreImagen;
        this.Formato_Imagen = Formato_Imagen;
        this.DescripcionImagen = DescripcionImagen;
        this.Resolucion = Resolucion;
        this.ImagenCuenta = ImagenCuenta;
        this.categoriaImagen = categoriaImagen;
        this.IdImagen = IdImagen;
        this.NombreUsuario = NombreUsuario;
        this.ImagenUsuario = ImagenUsuario;
    }

    //************************************************************************************************************************************************************************************
    public String getFechaSubidaI() {
        return fechaSubidaI;
    }

    public void setFechaSubidaI(String fechaSubidaI) {
        this.fechaSubidaI = fechaSubidaI;
    }

    public String getNombreImagen() {
        return NombreImagen;
    }

    public void setNombreImagen(String NombreImagen) {
        this.NombreImagen = NombreImagen;
    }

    public String getFormato_Imagen() {
        return Formato_Imagen;
    }

    public void setFormato_Imagen(String Formato_Imagen) {
        this.Formato_Imagen = Formato_Imagen;
    }

    public String getDescripcionImagen() {
        return DescripcionImagen;
    }

    public void setDescripcionImagen(String DescripcionImagen) {
        this.DescripcionImagen = DescripcionImagen;
    }

    public String getResolucion() {
        return Resolucion;
    }

    public void setResolucion(String Resolucion) {
        this.Resolucion = Resolucion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public byte[] getImagenCuenta() {
        return ImagenCuenta;
    }

    public void setImagenCuenta(byte[] ImagenCuenta) {
        this.ImagenCuenta = ImagenCuenta;
    }

    public String getCategoriaImagen() {
        return categoriaImagen;
    }

    public void setCategoriaImagen(String categoriaImagen) {
        this.categoriaImagen = categoriaImagen;
    }

    public String getIdImagen() {
        return IdImagen;
    }

    public void setIdImagen(String IdImagen) {
        this.IdImagen = IdImagen;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public byte[] getImagenUsuario() {
        return ImagenUsuario;
    }

    public void setImagenUsuario(byte[] ImagenUsuario) {
        this.ImagenUsuario = ImagenUsuario;
    }

    //************************************************************************************************************************************************************************************
    public boolean insertarImagenes(Imagen img, String insertarSQL, String NombreUsuario, String pkCategoria) {

        ConnectBD CBD = new ConnectBD();
        FileInputStream fis = null;
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                File file = new File(img.getImagen());
                fis = new FileInputStream(file);
                ps = CBD.getConexion().prepareStatement(insertarSQL);

                ps.setString(1, img.getFechaSubidaI());
                ps.setString(2, img.getNombreImagen());
                ps.setString(3, img.getFormato_Imagen());
                ps.setString(4, img.getDescripcionImagen());
                ps.setString(5, img.getResolucion());
                ps.setString(6, NombreUsuario);
                ps.setString(7, pkCategoria);

                ps.setBinaryStream(8, fis, (int) file.length());

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

    public ResultSet TraerImagenesCuenta(String TraerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }//Fin try
        
        }//Fin if

        return rset;

    }//Fin método

    public boolean ModificarDatosImagen(String ActualizarSQL, Imagen imgActualizar, String pkcategoria) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);
                ps = CBD.getConexion().prepareStatement(ActualizarSQL);

                ps.setString(1, imgActualizar.getNombreImagen());
                ps.setString(2, imgActualizar.getFormato_Imagen());
                ps.setString(3, imgActualizar.getDescripcionImagen());
                ps.setString(4, imgActualizar.getResolucion());
                ps.setString(5, pkcategoria);

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

        }

        return f;

    }//Fin método

    public boolean BorrarDatosImagen(String EliminarSQl) {

        ConnectBD CBD = new ConnectBD();

        boolean f = false;

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                CBD.getSt().executeUpdate(EliminarSQl);

                f = true;

            } catch (Exception ex) {

                ex.printStackTrace();
                f = false;

            }//Fin try
        
        }//Fin if

        return f;

    }//Fin método
    
    //****************************************************************************************************************************************************
    //Métodos que aplican el concepto de JOIN

    public ResultSet TraerImagenesComentarios(String LeerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(LeerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }//Fin try
            
        }//Fin if

        return rset;

    }//Fin método

}//Fin clase
