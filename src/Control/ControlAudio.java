/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import Modelo.Audio;
import java.sql.Blob;

/**
 *
 * @author Julian
 */
public class ControlAudio {

    public boolean InsertarAudio(Audio audio, String NombreUsuario, String Pkcategoria) {

        Audio ObjAudio = new Audio();

        boolean t = false;

        //String insertarSQL = "INSERT INTO audios(FechaSubidaA, NombreAudio, Audio1, Formato_Audio, TamanoAudio, DuracionAudio, DescripcionAudio, NombreUsuario3, CodigoCategoria3)"
        //      + "values(?,?,?,?,?,?,?,?,?)";
        String insertarSQL = "call InsertarAudiosCuenta(?,?,?,?,?,?,?,?,?)";

        t = ObjAudio.insertarAudios(audio, insertarSQL, NombreUsuario, Pkcategoria);

        return t;

    }//Fin método

    public boolean ActualizarDatos(String idAudio, Audio audioActualizar, String pkCategoria) {

        Audio audio = new Audio();

        boolean t = false;

        String ActualizarSQL = "UPDATE audios SET NombreAudio = ?, Formato_Audio = ?, TamanoAudio = ?, DescripcionAudio = ?, DuracionAudio = ?, CodigoCategoria3 = ? WHERE idContenidoA = '" + idAudio + "'";

        t = audio.ModificarDatosAudio(ActualizarSQL, audioActualizar, pkCategoria);

        return t;

    }//Fin método

    public LinkedList<Audio> TraerAudiosCuenta(String NombreUsuarioAudios) {

        LinkedList<Audio> AudiosCuentas = new LinkedList<>();

        ResultSet rset = null;
        Audio aud = new Audio();
        Audio aud2 = null;

        //String TraerSQL = "SELECT A.idContenidoA, A.FechaSubidaA, A.NombreAudio, A.Audio1, A.Formato_Audio, A.TamanoAudio, A.DuracionAudio, A.DescripcionAudio, Ca.NombreCategoria FROM audios A, categorias Ca, cuentas C WHERE C.NombreUsuario = A.NombreUsuario3 AND A.CodigoCategoria3 = Ca.CodigoCategoria AND C.NombreUsuario = '" + NombreUsuarioAudios + "'";
        String TraerSQL = "call ConsultaAudiosCuenta('" + NombreUsuarioAudios + "')";
        rset = aud.TraerAudiosCuenta(TraerSQL);

        try {

            while (rset.next()) {

                String IdAudio = String.valueOf(rset.getString("idContenidoA"));
                String fechaSubidaA = rset.getString("FechaSubidaA");
                String NombreAudio = rset.getString("NombreAudio");
                String formatoAudio = rset.getString("Formato_Audio");
                String tamanoAudio = rset.getString("TamanoAudio");
                String DuracionA = rset.getString("DuracionAudio");
                String descripcionAudio = rset.getString("DescripcionAudio");
                String categoria = rset.getString("NombreCategoria");

                //Se trae la foto que quedó guardada de tipo blob en BD a 
                Blob blob = rset.getBlob("Audio1");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] archivoAudio = blob.getBytes(1, (int) blob.length());

                aud2 = new Audio(fechaSubidaA, NombreAudio, formatoAudio, tamanoAudio, DuracionA, descripcionAudio, IdAudio, categoria, archivoAudio);

                AudiosCuentas.add(aud2);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return AudiosCuentas;

    }//Fin método

    public boolean EliminarAudio(String IdContenido) {

        Audio audioEliminar = new Audio();

        boolean t = false;

        String EliminarSQl = "DELETE FROM audios WHERE idContenidoA = '" + IdContenido + "'";

        t = audioEliminar.BorrarDatosAudio(EliminarSQl);

        return t;

    }//Fin método

    public LinkedList<Audio> BuscarAudiosGuardados() {

        LinkedList<Audio> audios = new LinkedList<>();

        //String BuscarSQL = "SELECT A.idContenidoA, A.FechaSubidaA, A.NombreAudio, A.Formato_Audio, A.TamanoAudio, A.DuracionAudio, A.DescripcionAudio, Ca.NombreCategoria, C.NombreUsuario, C.Foto FROM cuentas C, audios A, categorias Ca where C.NombreUsuario = A.NombreUsuario3 AND A.CodigoCategoria3 = Ca.CodigoCategoria";

        String BuscarSQL = "call ConsultaAudiosTotalesGuardadas()";
        
        Audio ObjeAud = new Audio();

        Audio audEnvio = null;

        ResultSet rset = null;

        rset = ObjeAud.TraerAudiosCuenta(BuscarSQL);

        try {

            while (rset.next()) {

                String NombreAudio = rset.getString("NombreAudio");
                String IdAudio = String.valueOf(rset.getString("idContenidoA"));
                String fechaSubida = rset.getString("FechaSubidaA");
                String formatoAudio = rset.getString("Formato_Audio");
                String tamanoAudio = rset.getString("TamanoAudio");
                String Duracion = rset.getString("DuracionAudio");
                String descripcion = rset.getString("DescripcionAudio");
                String categoria = rset.getString("NombreCategoria");
                String Nombreusuario = rset.getString("NombreUsuario");

                //Se trae el archivo de audio y la foto que quedó guardada de tipo blob en BD  
                Blob blob = rset.getBlob("Audio1");
                Blob blob2 = rset.getBlob("Foto");

                //Se guarda los byte de los archivos audio e imagen del usuario en un arreglo de byte
                byte[] archivoAudio = blob.getBytes(1, (int) blob.length());
                byte[] archivoFoto = blob.getBytes(1, (int) blob2.length());

                audEnvio = new Audio(fechaSubida, NombreAudio, formatoAudio, tamanoAudio, Duracion, descripcion, IdAudio, categoria, archivoAudio, Nombreusuario, archivoFoto);
                audios.add(audEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return audios;

    }//Fin método

    public LinkedList<String> TraerAudiosComentarios() {

        LinkedList<String> ContenidoComentarios = new LinkedList<>();

        String Dato = "";

        Audio aud = new Audio();
        ResultSet rset = null;

        String LeerSQL = "call AudiosComentarios_RightJoin()";

        rset = aud.TraerAudiosComentarios(LeerSQL);

        try {

            while (rset.next()) {

                String NombreAudio = rset.getString("NombreAudio");
                String FechaSubida = rset.getString("FechaSubidaA");
                String DescripcionComentario = rset.getString("DescripcionComentarioA");
                String FechaPublicacion = rset.getString("FechaPublicacionA");
                String NombreUsuario = rset.getString("NombreUsuario");

                Dato = DescripcionComentario + ";" + FechaPublicacion + ";" + NombreUsuario + ";" + NombreAudio + ";" + FechaSubida;

                ContenidoComentarios.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return ContenidoComentarios;

    }//Fin método

}
