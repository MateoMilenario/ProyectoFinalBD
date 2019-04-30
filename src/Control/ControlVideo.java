/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Video;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Gomez
 */
public class ControlVideo {

    public boolean InsertarVideo(Video video, String NombreUsuario, String Pkcategoria) {

        boolean t = false;

        //String insertarSQL = "INSERT INTO videos(FechaSubidaV, NombreVideo, rutaVideo, Formato_Video, DuracionVideo, DescripcionVideo, NombreUsuario2, CodigoCategoria2, Video)"
        // + "values(?,?,?,?,?,?,?,?,?)";
        
        String insertarSQL = "call InsertarVideosCuenta(?,?,?,?,?,?,?,?,?)";

        t = video.insertarVideos(video, insertarSQL, NombreUsuario, Pkcategoria);

        return t;

    }//Fin método

    public boolean ActualizarDatos(String idVideo, Video videoActualizar, String pkCategoria) {

        Video video = new Video();

        boolean t = false;

        String ActualizarSQL = "UPDATE videos SET NombreVideo = ?, Formato_Video = ?, DescripcionVideo = ?, DuracionVideo = ?, CodigoCategoria2 = ? WHERE idContenidoV = '" + idVideo + "'";

        t = video.ModificarDatosVideo(ActualizarSQL, videoActualizar, pkCategoria);

        return t;

    }//Fin método

    public LinkedList<Video> TraerVideos(String NombreUsuarioVideos) {

        LinkedList<Video> VideosCuentas = new LinkedList<>();

        ResultSet rset = null;
        Video vid = new Video();
        Video vid2 = null;

        //String TraerSQL = "SELECT V.idContenidoV, V.FechaSubidaV, V.NombreVideo, V.Video ,V.Formato_Video, V.DuracionVideo, V.DescripcionVideo, Ca.NombreCategoria FROM videos V, categorias Ca, cuentas C where C.NombreUsuario = V.NombreUsuario2 AND V.CodigoCategoria2 = Ca.CodigoCategoria AND C.NombreUsuario = '" + NombreUsuarioVideos + "'";
        String TraerSQL = "call ConsultaVideosCuenta('" + NombreUsuarioVideos + "')";
        rset = vid.TraerVideosCuenta(TraerSQL);

        try {

            while (rset.next()) {

                String IdVideo = String.valueOf(rset.getString("idContenidoV"));
                String fechaSubida = rset.getString("FechaSubidaV");
                String NombreVideo = rset.getString("NombreVideo");

                Blob blob = rset.getBlob("Video");
                byte[] Video = blob.getBytes(1, (int) blob.length());

                String formatoVideo = rset.getString("Formato_Video");
                String Duracion = rset.getString("DuracionVideo");
                String descripcionVideo = rset.getString("DescripcionVideo");
                String categoria = rset.getString("NombreCategoria");

                vid2 = new Video(IdVideo, fechaSubida, NombreVideo, Video, formatoVideo, Duracion, descripcionVideo, NombreUsuarioVideos, categoria);

                VideosCuentas.add(vid2);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }
        return VideosCuentas;

    }//Fin método

    public boolean EliminarVideo(String IdContenido) {

        Video videoEliminar = new Video();

        boolean t = false;

        String EliminarSQl = "DELETE FROM videos WHERE idContenidoV = '" + IdContenido + "'";

        t = videoEliminar.BorrarDatosVideos(EliminarSQl);

        return t;

    }//Fin método

    public LinkedList<Video> BuscarVideosGuardados() {

        LinkedList<Video> Videos = new LinkedList<>();

        //String BuscarSQL = "SELECT V.idContenidoV, V.FechaSubidaV, V.NombreVideo, V.Formato_Video, V.DescripcionVideo, V.DuracionVideo, V.Video, Ca.NombreCategoria, C.NombreUsuario, C.Foto FROM cuentas C, videos V, categorias Ca where C.NombreUsuario = V.NombreUsuario2 AND V.CodigoCategoria2 = Ca.CodigoCategoria";
        String BuscarSQL = "call ConsultaVideosTotalesGuardadas()";
        Video ObjeVideo = new Video();

        Video videoEnvio = null;

        ResultSet rset = null;

        rset = ObjeVideo.TraerVideosCuenta(BuscarSQL);

        try {

            while (rset.next()) {

                String NombreVideo = rset.getString("NombreVideo");
                String IdVideo = String.valueOf(rset.getString("idContenidoV"));
                String fechaSubida = rset.getString("FechaSubidaV");
                String formatoVideo = rset.getString("Formato_Video");
                String descripcion = rset.getString("DescripcionVideo");
                String duracion = rset.getString("DuracionVideo");
                String categoria = rset.getString("NombreCategoria");
                String Nombreusuario = rset.getString("NombreUsuario");

                //Se trae la foto que quedó guardada de tipo blob en BD  
                Blob blob = rset.getBlob("Video");
                Blob blob2 = rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] Video = blob.getBytes(1, (int) blob.length());
                byte[] FotoPerfil = blob2.getBytes(1, (int) blob2.length());

                videoEnvio = new Video(IdVideo, fechaSubida, NombreVideo, Video, formatoVideo, duracion, descripcion, Nombreusuario, categoria, FotoPerfil);

                Videos.add(videoEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return Videos;
    }//Fin método

    public LinkedList<String> TraerVideosComentarios() {

        LinkedList<String> ContenidoComentarios = new LinkedList<>();

        String Dato = "";

        Video vid = new Video();
        ResultSet rset = null;

        String LeerSQL = "call VideosComentarios_InnerJoin()";

        rset = vid.TraerVideosComentarios(LeerSQL);

        try {

            while (rset.next()) {

                String NombreVideo = rset.getString("NombreVideo");
                String FechaSubida = rset.getString("FechaSubidaV");
                String DescripcionComentario = rset.getString("DescripcionComentarioV");
                String FechaPublicacion = rset.getString("FechaPublicacionV");
                String NombreUsuario = rset.getString("NombreUsuario");

                Dato = DescripcionComentario + ";" + FechaPublicacion + ";" + NombreUsuario + ";" + NombreVideo + ";" + FechaSubida;

                ContenidoComentarios.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return ContenidoComentarios;

    }//Fin método

}
