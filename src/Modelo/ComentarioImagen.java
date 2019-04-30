/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ConnectBD;
import java.sql.ResultSet;

/**
 *
 * @author Mateo
 */
public class ComentarioImagen {

    private String FechaPublicacion;
    private String DescripcionImagen;
    private String IdComentario;
    private String idContenido;
    private String NombreUsuarioComentario;
    private byte[] FotoUsuarioComentario;

    public ComentarioImagen() {
    }

    public ComentarioImagen(String FechaPublicacion, String DescrpcionImagen) {
        this.FechaPublicacion = FechaPublicacion;
        this.DescripcionImagen = DescrpcionImagen;
    }

    public ComentarioImagen(String FechaPublicacion, String DescripcionImagen, String IdComentario, String idContenido, String NombreUsuarioComentario, byte[] FotoUsuarioComentario) {
        this.FechaPublicacion = FechaPublicacion;
        this.DescripcionImagen = DescripcionImagen;
        this.IdComentario = IdComentario;
        this.idContenido = idContenido;
        this.NombreUsuarioComentario = NombreUsuarioComentario;
        this.FotoUsuarioComentario = FotoUsuarioComentario;
    }

    public String getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(String FechaPublicacion) {
        this.FechaPublicacion = FechaPublicacion;
    }

    public String getDescrpcionImagen() {
        return DescripcionImagen;
    }

    public void setDescrpcionImagen(String DescrpcionImagen) {
        this.DescripcionImagen = DescrpcionImagen;
    }

    public String getIdComentario() {
        return IdComentario;
    }

    public void setIdComentario(String IdComentario) {
        this.IdComentario = IdComentario;
    }

    public String getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(String idContenido) {
        this.idContenido = idContenido;
    }

    public String getNombreUsuarioComentario() {
        return NombreUsuarioComentario;
    }

    public void setNombreUsuarioComentario(String NombreUsuarioComentario) {
        this.NombreUsuarioComentario = NombreUsuarioComentario;
    }

    public byte[] getFotoUsuarioComentario() {
        return FotoUsuarioComentario;
    }

    public void setFotoUsuarioComentario(byte[] FotoUsuarioComentario) {
        this.FotoUsuarioComentario = FotoUsuarioComentario;
    }

    //**************************************************************************
    public boolean GuardarComentario(String InsertarSQL) {

        ConnectBD CBD = new ConnectBD();

        boolean f = false;

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                CBD.getSt().executeUpdate(InsertarSQL);

                f = true;

            } catch (Exception ex) {

                ex.printStackTrace();
                f = false;

            }
        }//Fin if

        return f;

    }//Fin método

    public ResultSet ConsultarComentariosImagenes(String TraerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(TraerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }//Fin if

        return rset;

    }//Fin método

    public boolean ActualizarDatosComentario(String ActualizarSQL) {

        ConnectBD CBD = new ConnectBD();

        boolean f = false;

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                CBD.getSt().executeUpdate(ActualizarSQL);

                f = true;

            } catch (Exception ex) {

                ex.printStackTrace();
                f = false;

            }
        }//Fin if

        return f;

    }//Fin método

    public boolean BorrarComentario(String EliminarSQL) {
        
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
        }//Fin if

        return f;
        
    }//Fin método

}
