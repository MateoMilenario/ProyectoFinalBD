/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ComentarioImagen;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlComentarioImagen {

    public boolean InsertarComentario(String PkImagen, String nombreUsuarioBusquedadI, ComentarioImagen CI) {

        ComentarioImagen Cimagen = new ComentarioImagen();

        boolean t = false;

        String InsertarSQL = "INSERT INTO comentarios_imagenes(FechaPublicacionI, DescripcionComentarioI, id_ContenidoI, NombreUsuario4)"
                + "values('" + CI.getFechaPublicacion() + "', '" + CI.getDescrpcionImagen() + "', '" + PkImagen + "', '" + nombreUsuarioBusquedadI + "')";

        t = Cimagen.GuardarComentario(InsertarSQL);

        return t;

    }//Fin método

    public LinkedList<ComentarioImagen> TraerComentarios(String CodigoContenido) {

        LinkedList<ComentarioImagen> comentariosI = new LinkedList<>();

        ResultSet Rset = null;
        ComentarioImagen Cimagen = new ComentarioImagen();
        ComentarioImagen CimagenEnvio = null;

        //String TraerSQL = "SELECT ci.CodigoComentarioI, ci.id_ContenidoI, ci.FechaPublicacionI, ci.DescripcionComentarioI, ci.NombreUsuario4, c.Foto FROM cuentas c, imagenes i, comentarios_imagenes ci WHERE c.NombreUsuario = ci.NombreUsuario4 AND ci.id_ContenidoI = i.idContenidoI AND i.idContenidoI = '" + CodigoContenido + "'";
        String TraerSQL = "call ConsultaComentariosImagen('" + CodigoContenido + "')";

        Rset = Cimagen.ConsultarComentariosImagenes(TraerSQL);

        try {

            while (Rset.next()) {

                String codigoComentario = Rset.getString("CodigoComentarioI");
                String FechapublicacionI = Rset.getString("FechaPublicacionI");
                String DescripcionC = Rset.getString("DescripcionComentarioI");
                String idContenido = Rset.getString("id_ContenidoI");
                String NombreUsuarioC = Rset.getString("NombreUsuario4");
                Blob blob = Rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] data = blob.getBytes(1, (int) blob.length());

                CimagenEnvio = new ComentarioImagen(FechapublicacionI, DescripcionC, codigoComentario, idContenido, NombreUsuarioC, data);

                comentariosI.add(CimagenEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return comentariosI;

    }//Fin método

    public boolean ModificarComentario(String idComentario, ComentarioImagen Cimagen) {

        boolean t = false;

        ComentarioImagen Ci = new ComentarioImagen();

        String ActualizarSQL = "UPDATE comentarios_imagenes SET FechaPublicacionI = '" + Cimagen.getFechaPublicacion() + "', DescripcionComentarioI = '" + Cimagen.getDescrpcionImagen() + "' WHERE CodigoComentarioI = '" + idComentario + "'";

        t = Ci.ActualizarDatosComentario(ActualizarSQL);

        return t;

    }//Fin método

    public boolean EliminarComentario(String idComentario, String nombreUsuarioBusquedadI) {

        ComentarioImagen Cimagen = new ComentarioImagen();

        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_imagenes WHERE CodigoComentarioI = '" + idComentario + "' AND NombreUsuario4 = '" + nombreUsuarioBusquedadI + "'";

        t = Cimagen.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método
    
    public boolean EliminarComentariosImagenesCuenta(String idComentario) {

        ComentarioImagen Cimagen = new ComentarioImagen();

        boolean t = false;

        String EliminarSQL = "DELETE FROM comentarios_imagenes WHERE CodigoComentarioI = '" + idComentario + "'";

        t = Cimagen.BorrarComentario(EliminarSQL);

        return t;

    }//Fin método
}
