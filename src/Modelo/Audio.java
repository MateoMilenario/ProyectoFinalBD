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
 * @author Julian
 */
public class Audio {

    private String fechaSubidaA;
    private String NombreAudio;
    private String Audio1;
    private String Formato_Audio;
    private String TamanoAudio;
    private String DuracionAudio;
    private String DescripcionAudio;

    //*****************************
    private String IdContenidoA;
    private String categoriaAudio;
    private byte[] ArchivoAudio;

    //*****************************
    private String NombreUsuarioPK;
    private byte[] ImagenUsuario;

    public Audio() {
    }

    public Audio(String fechaSubidaA, String NombreAudio, String Audio1, String Formato_Audio, String TamanoAudio, String DuracionAudio, String DescripcionAudio) {
        this.fechaSubidaA = fechaSubidaA;
        this.NombreAudio = NombreAudio;
        this.Audio1 = Audio1;
        this.Formato_Audio = Formato_Audio;
        this.TamanoAudio = TamanoAudio;
        this.DuracionAudio = DuracionAudio;
        this.DescripcionAudio = DescripcionAudio;
    }

    public Audio(String fechaSubidaA, String NombreAudio, String Formato_Audio, String TamanoAudio, String DuracionAudio, String DescripcionAudio, String IdContenidoA, String categoriaAudio, byte[] ArchivoAudio) {
        this.fechaSubidaA = fechaSubidaA;
        this.NombreAudio = NombreAudio;
        this.Formato_Audio = Formato_Audio;
        this.TamanoAudio = TamanoAudio;
        this.DuracionAudio = DuracionAudio;
        this.DescripcionAudio = DescripcionAudio;
        this.IdContenidoA = IdContenidoA;
        this.categoriaAudio = categoriaAudio;
        this.ArchivoAudio = ArchivoAudio;
    }

    //*****************************************************************************************
    public String getIdContenidoA() {
        return IdContenidoA;
    }

    public void setIdContenidoA(String IdContenidoA) {
        this.IdContenidoA = IdContenidoA;
    }

    public String getFechaSubidaA() {
        return fechaSubidaA;
    }

    public void setFechaSubidaA(String fechaSubidaA) {
        this.fechaSubidaA = fechaSubidaA;
    }

    public String getNombreAudio() {
        return NombreAudio;
    }

    public void setNombreAudio(String NombreAudio) {
        this.NombreAudio = NombreAudio;
    }

    public String getAudio1() {
        return Audio1;
    }

    public void setAudio1(String Audio1) {
        this.Audio1 = Audio1;
    }

    public String getFormato_Audio() {
        return Formato_Audio;
    }

    public void setFormato_Audio(String Formato_Audio) {
        this.Formato_Audio = Formato_Audio;
    }

    public String getTamanoAudio() {
        return TamanoAudio;
    }

    public void setTamanoAudio(String TamanoAudio) {
        this.TamanoAudio = TamanoAudio;
    }

    public String getDuracionAudio() {
        return DuracionAudio;
    }

    public void setDuracionAudio(String DuracionAudio) {
        this.DuracionAudio = DuracionAudio;
    }

    public String getDescripcionAudio() {
        return DescripcionAudio;
    }

    public void setDescripcionAudio(String DescripcionAudio) {
        this.DescripcionAudio = DescripcionAudio;
    }

    public String getNombreUsuarioPK() {
        return NombreUsuarioPK;
    }

    public void setNombreUsuarioPK(String NombreUsuarioPK) {
        this.NombreUsuarioPK = NombreUsuarioPK;
    }

    public String getCategoriaAudio() {
        return categoriaAudio;
    }

    public void setCategoriaAudio(String categoriaAudio) {
        this.categoriaAudio = categoriaAudio;
    }

    public byte[] getImagenUsuario() {
        return ImagenUsuario;
    }

    public void setImagenUsuario(byte[] ImagenUsuario) {
        this.ImagenUsuario = ImagenUsuario;
    }

    public byte[] getArchivoAudio() {
        return ArchivoAudio;
    }

    public void setArchivoAudio(byte[] ArchivoAudio) {
        this.ArchivoAudio = ArchivoAudio;
    }

    //*****************************************************************************************
    public ResultSet TraerAudiosCuenta(String TraerSQL) {
        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }
        }

        return rset;
    }

    public boolean ModificarDatosAudio(String ActualizarSQL, Audio audioActualizar, String pkcategoria) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);
                ps = CBD.getConexion().prepareStatement(ActualizarSQL);

                ps.setString(1, audioActualizar.getNombreAudio());
                ps.setString(2, audioActualizar.getFormato_Audio());
                ps.setString(3, audioActualizar.getTamanoAudio());
                ps.setString(4, audioActualizar.getDescripcionAudio());
                ps.setString(5, audioActualizar.getDuracionAudio());
                ps.setString(6, pkcategoria);

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

        }//Fin try inicial

        return f;

    }//Fin método

    public boolean insertarAudios(Audio audio, String insertarSQL, String NombreUsuario, String pkCategoria) {

        ConnectBD CBD = new ConnectBD();
        FileInputStream fis = null;
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);

                File file = new File(audio.getAudio1());
                fis = new FileInputStream(file);

                ps = CBD.getConexion().prepareStatement(insertarSQL);

                ps.setString(1, audio.getFechaSubidaA());
                ps.setString(2, audio.getNombreAudio());

                ps.setBinaryStream(3, fis, (int) file.length());

                ps.setString(4, audio.getFormato_Audio());
                ps.setString(5, audio.getTamanoAudio());
                ps.setString(6, audio.getDuracionAudio());
                ps.setString(7, audio.getDescripcionAudio());
                ps.setString(8, NombreUsuario);
                ps.setString(9, pkCategoria);

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

    public boolean BorrarDatosAudio(String EliminarSQl) {

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

    public ResultSet TraerAudiosComentarios(String LeerSQL) {

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

}
