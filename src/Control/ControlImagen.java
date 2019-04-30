/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.CuentaUsuario;
import Modelo.Imagen;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlImagen {

    public boolean InsertarImagen(Imagen img, String NombreUsuario, String Pkcategoria) {

        boolean t = false;

        //String insertarSQL = "INSERT INTO imagenes(FechaSubidaI, NombreImagen, Formato_Imagen, DescripcionImagen, Resolucion, NombreUsuario1, CodigoCategoria1, Imagen)"
        //+ "values(?,?,?,?,?,?,?,?)";
        //Sentencia sql que utiliza la estructura de store procedure
        String insertarSQL = "call InsertarImagenesCuenta(?,?,?,?,?,?,?,?)";

        t = img.insertarImagenes(img, insertarSQL, NombreUsuario, Pkcategoria);

        return t;

    }//Fin método

    public LinkedList<Imagen> TraerImagenes(String NombreUsuarioImagenes) {

        LinkedList<Imagen> ImagenesCuentas = new LinkedList<>();

        ResultSet rset = null;
        Imagen img = new Imagen();
        Imagen img2 = null;

        //String TraerSQL = "SELECT I.idContenidoI, I.FechaSubidaI, I.NombreImagen, I.Formato_Imagen, I.DescripcionImagen, I.Resolucion, I.Imagen, Ca.NombreCategoria FROM cuentas C, imagenes I, categorias Ca where C.NombreUsuario = I.NombreUsuario1 AND I.CodigoCategoria1 = Ca.CodigoCategoria AND C.NombreUsuario = '" + NombreUsuarioImagenes + "'";
        //Sentencia SQL con store procedure
        String TraerSQL = "call ConsultaImagenesCuenta('" + NombreUsuarioImagenes + "')";

        rset = img.TraerImagenesCuenta(TraerSQL);

        try {

            while (rset.next()) {

                String NombreImagen = rset.getString("NombreImagen");
                String IdImagen = String.valueOf(rset.getString("idContenidoI"));
                String fechaSubida = rset.getString("FechaSubidaI");
                String formatoImagen = rset.getString("Formato_Imagen");
                String descripcion = rset.getString("DescripcionImagen");
                String resolucion = rset.getString("Resolucion");
                String categoria = rset.getString("NombreCategoria");
                //Se trae la foto que quedó guardada de tipo blob en BD  
                Blob blob = rset.getBlob("Imagen");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] Imagen = blob.getBytes(1, (int) blob.length());

                img2 = new Imagen(fechaSubida, NombreImagen, formatoImagen, descripcion, resolucion, Imagen, categoria, IdImagen);

                ImagenesCuentas.add(img2);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try
        
        return ImagenesCuentas;

    }//Fin método

    public boolean ActualizarDatos(String idImagen, Imagen imagenActualizar, String pkCategoria) {

        Imagen img = new Imagen();

        boolean t = false;

        String ActualizarSQL = "UPDATE imagenes SET NombreImagen = ?, Formato_Imagen = ?, DescripcionImagen = ?, Resolucion = ?, CodigoCategoria1 = ? WHERE idContenidoI = '" + idImagen + "'";

        t = img.ModificarDatosImagen(ActualizarSQL, imagenActualizar, pkCategoria);

        return t;

    }//Fin método

    public boolean EliminarImagen(String IdContenido) {

        Imagen imgEliminar = new Imagen();

        boolean t = false;

        String EliminarSQl = "DELETE FROM imagenes WHERE idContenidoI = '" + IdContenido + "'";

        t = imgEliminar.BorrarDatosImagen(EliminarSQl);

        return t;

    }//Fin método

    public LinkedList<Imagen> BuscarImagenesGuardadas() {

        LinkedList<Imagen> imagenes = new LinkedList<>();

        //String BuscarSQL = "SELECT I.idContenidoI, I.FechaSubidaI, I.NombreImagen, I.Formato_Imagen, I.DescripcionImagen, I.Resolucion, I.Imagen, Ca.NombreCategoria, C.NombreUsuario, C.Foto FROM cuentas C, imagenes I, categorias Ca where C.NombreUsuario = I.NombreUsuario1 AND I.CodigoCategoria1 = Ca.CodigoCategoria";

        String BuscarSQL = "call ConsultaImagenesTotalesGuardadas()";
        
        Imagen ObjeImg = new Imagen();

        Imagen imgEnvio = null;

        ResultSet rset = null;

        rset = ObjeImg.TraerImagenesCuenta(BuscarSQL);

        try {

            while (rset.next()) {

                String NombreImagen = rset.getString("NombreImagen");
                String IdImagen = String.valueOf(rset.getString("idContenidoI"));
                String fechaSubida = rset.getString("FechaSubidaI");
                String formatoImagen = rset.getString("Formato_Imagen");
                String descripcion = rset.getString("DescripcionImagen");
                String resolucion = rset.getString("Resolucion");
                String categoria = rset.getString("NombreCategoria");
                String Nombreusuario = rset.getString("NombreUsuario");

                //Se trae la foto que quedó guardada de tipo blob en BD  
                Blob blob = rset.getBlob("Imagen");
                Blob blob2 = rset.getBlob("Foto");

                //Se guarda los byte de la imagen en un arreglo de byte
                byte[] Imagen = blob.getBytes(1, (int) blob.length());
                byte[] Imagen2 = blob2.getBytes(1, (int) blob2.length());

                imgEnvio = new Imagen(fechaSubida, NombreImagen, formatoImagen, descripcion, resolucion, Imagen, categoria, IdImagen, Nombreusuario, Imagen2);

                imagenes.add(imgEnvio);

            }//Fin while

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + e, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try

        return imagenes;

    }//Fin método

    public LinkedList<String> TraerImagenesComentarios() {
        
        LinkedList<String> ContenidoComentarios = new LinkedList<>();
        
         String Dato = "";

        Imagen img = new Imagen();
        ResultSet rset = null;

        String LeerSQL = "call ImagenesComentarios_RightJoin()";

        rset = img.TraerImagenesComentarios(LeerSQL);

        try {

            while (rset.next()) {

                String NombreImagen = rset.getString("NombreImagen");
                String FechaSubida = rset.getString("FechaSubidaI");
                String DescripcionComentario = rset.getString("DescripcionComentarioI");
                String FechaPublicacion = rset.getString("FechaPublicacionI");
                String NombreUsuario = rset.getString("NombreUsuario");


                Dato = DescripcionComentario + ";" + FechaPublicacion + ";" + NombreUsuario + ";" + NombreImagen + ";" + FechaSubida;

                ContenidoComentarios.add(Dato);

            }//Fin while

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos: " + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }//Fin try
        
        return ContenidoComentarios;
        
    }

}
