/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ComentarioAudio;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian EScobar
 */
public class ControlComentarioAudio {

    public boolean InsertarComentario(String PkAudio, String nombreUsuarioBusquedadA, ComentarioAudio CA) {

        ComentarioAudio Caudio = new ComentarioAudio();

        boolean t = false;

        String InsertarSQL = "INSERT INTO comentarios_audios(FechaPublicacionA, DescripcionComentarioA, id_ContenidoA, NombreUsuario6)"
                + "values('" + CA.getFechaPublicacion() + "', '" + CA.getDescripcionComentario() + "', '" + PkAudio + "', '" + nombreUsuarioBusquedadA + "')";

        t = Caudio.GuardarComentario(InsertarSQL);

        return t;

    }//Fin método

    public LinkedList<ComentarioAudio> TraerComentarios(String CodigoContenido) {

        LinkedList<ComentarioAudio> comentariosA = new LinkedList<>();

        ResultSet Rset = null;
        ComentarioAudio Caudio = new ComentarioAudio();
        ComentarioAudio CaudioEnvio = null;

        String TraerSQL = "SELECT ca.CodigoComentarioA, ca.id_ContenidoA, ca.FechaPublicacionA, ca.DescripcionComentarioA, ca.NombreUsuario6, c.Foto FROM cuentas c, audios a, comentarios_audios ca WHERE c.NombreUsuario = ca.NombreUsuario6 AND ca.id_ContenidoA = a.idContenidoA AND a.idContenidoA = '" + CodigoContenido + "'";

        Rset = Caudio.ConsultarComentariosAudios(TraerSQL);

        try {

            while (Rset.next()) {

                String codigoComentario = Rset.getString("CodigoComentarioA");
                String FechapublicacionA = Rset.getString("FechaPublicacionA");
                String DescripcionC = Rset.getString("DescripcionComentarioA");
                String idContenido = Rset.getString("id_ContenidoA");
                String NombreUsuarioC = Rset.getString("NombreUsuario6");
                Blob blob = Rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] data = blob.getBytes(1, (int) blob.length());

                CaudioEnvio = new ComentarioAudio(FechapublicacionA, DescripcionC, codigoComentario, idContenido, NombreUsuarioC, data);

                comentariosA.add(CaudioEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return comentariosA;

    }//Fin método

    public boolean ModificarComentario(String idComentario, ComentarioAudio Caudio) {

        boolean t = false;

        ComentarioAudio Ca = new ComentarioAudio();

        String ActualizarSQL = "UPDATE comentarios_audios SET FechaPublicacionA = '" + Caudio.getFechaPublicacion() + "', DescripcionComentarioA = '" + Caudio.getDescripcionComentario() + "' WHERE CodigoComentarioA = '" + idComentario + "'";

        t = Ca.ActualizarDatosComentario(ActualizarSQL);

        return t;

    }//Fin método

    public boolean EliminarComentario(String idComentario, String nombreUsuarioBusquedadA) {

        ComentarioAudio Caudio = new ComentarioAudio();
        
        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_audios WHERE CodigoComentarioA = '" + idComentario + "' AND NombreUsuario6 = '" + nombreUsuarioBusquedadA + "'";
        
        t = Caudio.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método
    
    public boolean EliminarComentarioAudiosCuenta(String idComentario) {

        ComentarioAudio Caudio = new ComentarioAudio();
        
        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_audios WHERE CodigoComentarioA = '" + idComentario + "'";
        
        t = Caudio.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método
    
}
