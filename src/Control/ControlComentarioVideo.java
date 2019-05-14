/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ComentarioVideo;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlComentarioVideo {

    public boolean InsertarComentario(String PkVideo, String nombreUsuarioBusquedadV, ComentarioVideo CV) {

        ComentarioVideo Cvideo = new ComentarioVideo();

        boolean t = false;

        String InsertarSQL = "INSERT INTO comentarios_videos(FechaPublicacionV, DescripcionComentarioV, id_ContenidoV, NombreUsuario5)"
                + "values('" + CV.getFechaPublicacion() + "', '" + CV.getDescripcionComentario() + "', '" + PkVideo + "', '" + nombreUsuarioBusquedadV + "')";

        t = Cvideo.GuardarComentario(InsertarSQL);

        return t;

    }//Fin método

    public LinkedList<ComentarioVideo> TraerComentarios(String CodigoContenido) {

        LinkedList<ComentarioVideo> comentariosV = new LinkedList<>();

        ResultSet Rset = null;
        ComentarioVideo Cvideo = new ComentarioVideo();
        ComentarioVideo CvideoEnvio = null;

        String TraerSQL = "SELECT cv.CodigoComentarioV, cv.id_ContenidoV, cv.FechaPublicacionV, cv.DescripcionComentarioV, cv.NombreUsuario5, c.Foto FROM cuentas c, videos v, comentarios_videos cv WHERE c.NombreUsuario = cv.NombreUsuario5 AND cv.id_ContenidoV = v.idContenidoV AND v.idContenidoV = '" + CodigoContenido + "'";

        Rset = Cvideo.ConsultarComentarios(TraerSQL);

        try {

            while (Rset.next()) {

                String codigoComentario = Rset.getString("CodigoComentarioV");
                String FechapublicacionV = Rset.getString("FechaPublicacionV");
                String DescripcionC = Rset.getString("DescripcionComentarioV");
                String idContenido = Rset.getString("id_ContenidoV");
                String NombreUsuarioC = Rset.getString("NombreUsuario5");
                Blob blob = Rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] data = blob.getBytes(1, (int) blob.length());

                CvideoEnvio = new ComentarioVideo(FechapublicacionV, DescripcionC, codigoComentario, idContenido, NombreUsuarioC, data);

                comentariosV.add(CvideoEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return comentariosV;

    }//Fin método

    public boolean ModificarComentario(String idComentario, ComentarioVideo Cvideo) {

        boolean t = false;

        ComentarioVideo Cv = new ComentarioVideo();

        String ActualizarSQL = "UPDATE comentarios_videos SET FechaPublicacionV = '" + Cvideo.getFechaPublicacion() + "', DescripcionComentarioV = '" + Cvideo.getDescripcionComentario() + "' WHERE CodigoComentarioV = '" + idComentario + "'";

        t = Cv.ActualizarDatosComentario(ActualizarSQL);

        return t;

    }//Fin método

    public boolean EliminarComentario(String idComentario, String nombreUsuarioBusquedadV) {

        ComentarioVideo Cvideo = new ComentarioVideo();

        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_videos WHERE CodigoComentarioV = '" + idComentario + "' AND NombreUsuario5 = '" + nombreUsuarioBusquedadV + "'";

        t = Cvideo.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método

    public boolean EliminarComentariosVideoCuenta(String idComentario) {

        ComentarioVideo Cvideo = new ComentarioVideo();

        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_videos WHERE CodigoComentarioV = '" + idComentario + "'";

        t = Cvideo.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método
}
