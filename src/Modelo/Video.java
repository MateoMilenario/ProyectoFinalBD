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
 * @author Jose Gomez
 */
public class Video {

    private String IdContenidoV;
    private String fechaSubidaV;
    private String NombreVideo;
    private byte[] Video;
    private String Formato_Video;
    private String DuracionVideo;
    private String DescripcionVideo;
    private String NombreUsuarioV;
    private String categoriaVideo;
    private String rutaVideo;

    private byte[] ImagenUsuario;

    public Video() {
    }

    public Video(String IdContenidoV, String fechaSubidaV, String NombreVideo, byte[] Video, String Formato_Video, String DuracionVideo, String DescripcionVideo, String NombreUsuarioV, String categoriaImagen) {
        this.IdContenidoV = IdContenidoV;
        this.fechaSubidaV = fechaSubidaV;
        this.NombreVideo = NombreVideo;
        this.Video = Video;
        this.Formato_Video = Formato_Video;
        this.DuracionVideo = DuracionVideo;
        this.DescripcionVideo = DescripcionVideo;
        this.NombreUsuarioV = NombreUsuarioV;
        this.categoriaVideo = categoriaImagen;
    }

    public Video(String fechaSubidaV, String NombreVideo, String Formato_Video, String DuracionVideo, String DescripcionVideo, String rutaVideo) {
        this.fechaSubidaV = fechaSubidaV;
        this.NombreVideo = NombreVideo;
        this.Formato_Video = Formato_Video;
        this.DuracionVideo = DuracionVideo;
        this.DescripcionVideo = DescripcionVideo;
        this.rutaVideo = rutaVideo;
    }

    public Video(String IdContenidoV, String fechaSubidaV, String NombreVideo, byte[] Video, String Formato_Video, String DuracionVideo, String DescripcionVideo, String NombreUsuarioV, String categoriaVideo, byte[] ImagenUsuario) {
        this.IdContenidoV = IdContenidoV;
        this.fechaSubidaV = fechaSubidaV;
        this.NombreVideo = NombreVideo;
        this.Video = Video;
        this.Formato_Video = Formato_Video;
        this.DuracionVideo = DuracionVideo;
        this.DescripcionVideo = DescripcionVideo;
        this.NombreUsuarioV = NombreUsuarioV;
        this.categoriaVideo = categoriaVideo;
        this.ImagenUsuario = ImagenUsuario;
    }

    public byte[] getImagenUsuario() {
        return ImagenUsuario;
    }

    public void setImagenUsuario(byte[] ImagenUsuario) {
        this.ImagenUsuario = ImagenUsuario;
    }

    public String getRutaVideo() {
        return rutaVideo;
    }

    public void setRutaVideo(String rutaVideo) {
        this.rutaVideo = rutaVideo;
    }

    public String getIdContenidoV() {
        return IdContenidoV;
    }

    public void setIdContenidoV(String IdContenidoV) {
        this.IdContenidoV = IdContenidoV;
    }

    public String getFechaSubidaV() {
        return fechaSubidaV;
    }

    public void setFechaSubidaV(String fechaSubidaV) {
        this.fechaSubidaV = fechaSubidaV;
    }

    public String getNombreVideo() {
        return NombreVideo;
    }

    public void setNombreVideo(String NombreVideo) {
        this.NombreVideo = NombreVideo;
    }

    public byte[] getVideo() {
        return Video;
    }

    public void setVideo(byte[] Video) {
        this.Video = Video;
    }

    public String getFormato_Video() {
        return Formato_Video;
    }

    public void setFormato_Video(String Formato_Video) {
        this.Formato_Video = Formato_Video;
    }

    public String getDuracionVideo() {
        return DuracionVideo;
    }

    public void setDuracionVideo(String DuracionVideo) {
        this.DuracionVideo = DuracionVideo;
    }

    public String getDescripcionVideo() {
        return DescripcionVideo;
    }

    public void setDescripcionVideo(String DescripcionVideo) {
        this.DescripcionVideo = DescripcionVideo;
    }

    public String getNombreUsuarioV() {
        return NombreUsuarioV;
    }

    public void setNombreUsuarioV(String NombreUsuarioV) {
        this.NombreUsuarioV = NombreUsuarioV;
    }

    public String getCategoriaVideo() {
        return categoriaVideo;
    }

    public void setCategoriaVideo(String categoriaVideo) {
        this.categoriaVideo = categoriaVideo;
    }

    @Override
    public String toString() {
        return "Video{" + "IdContenidoV=" + IdContenidoV + ", fechaSubidaV=" + fechaSubidaV + ", NombreVideo=" + NombreVideo + ", Video=" + Video + ", Formato_Video=" + Formato_Video + ", DuracionVideo=" + DuracionVideo + ", DescripcionVideo=" + DescripcionVideo + ", NombreUsuarioV=" + NombreUsuarioV + ", categoriaVideo=" + categoriaVideo + ", rutaVideo=" + rutaVideo + ", ImagenUsuario=" + ImagenUsuario + '}';
    }

    public ResultSet TraerVideosCuenta(String TraerSQL) {

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

    public boolean ModificarDatosVideo(String ActualizarSQL, Video videoActualizar, String pkcategoria) {

        ConnectBD CBD = new ConnectBD();
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);
                ps = CBD.getConexion().prepareStatement(ActualizarSQL);

                ps.setString(1, videoActualizar.getNombreVideo());
                ps.setString(2, videoActualizar.getFormato_Video());
                ps.setString(3, videoActualizar.getDescripcionVideo());
                ps.setString(4, videoActualizar.getDuracionVideo());
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

    public boolean insertarVideos(Video video, String insertarSQL, String NombreUsuario, String pkCategoria) {

        ConnectBD CBD = new ConnectBD();
        FileInputStream fis = null;
        PreparedStatement ps = null;
        boolean f = false;

        try {

            if (CBD.crearConexion()) {

                CBD.getConexion().setAutoCommit(false);
                ps = CBD.getConexion().prepareStatement(insertarSQL);

                File file = new File(video.getRutaVideo());
                fis = new FileInputStream(file);

                ps.setString(1, video.getFechaSubidaV());
                ps.setString(2, video.getNombreVideo());

               // ps.setString(3, video.getRutaVideo());

                ps.setString(4, video.getFormato_Video());
                ps.setString(5, video.getDuracionVideo());
                ps.setString(6, video.getDescripcionVideo());
                ps.setString(7, NombreUsuario);
                ps.setString(8, pkCategoria);

                ps.setBinaryStream(9, fis, (int) file.length());

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

    public boolean BorrarDatosVideos(String EliminarSQl) {

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

    public ResultSet TraerVideosComentarios(String LeerSQL) {

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
