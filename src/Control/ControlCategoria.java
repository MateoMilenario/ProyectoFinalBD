/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class ControlCategoria {

    public LinkedList<Categoria> LeerCategorias() {

        LinkedList<Categoria> categorias2 = new LinkedList<>();

        Categoria ca = new Categoria();

        Categoria enviarCategorias = null;

        ResultSet rset;

        String LeerSQL = "SELECT * FROM categorias";

        //Método que trae el resultset de datos provenientes de categorías
        rset = ca.TraerCategorias(LeerSQL);

        try {

            while (rset.next()) {

                String NombreCategoria = rset.getString("NombreCategoria");
                String CodigoCategoria = String.valueOf(rset.getString("CodigoCategoria"));

                enviarCategorias = new Categoria(NombreCategoria, CodigoCategoria);

                categorias2.add(enviarCategorias);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Fallo en la lectura de datos" + ex, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return categorias2;

    }//Fin método

    public boolean InsertarCategoria(String nombreCategoria) {

        Categoria Objcategoria = new Categoria();

        boolean t = false;

        String InsertarSQL = "INSERT INTO categorias(NombreCategoria)"
                + "values('" + nombreCategoria + "')";

        t = Objcategoria.GuardarCategoria(InsertarSQL);

        return t;

    }

    public boolean EliminarCategoria(String pkCategoria) {

        Categoria Objecategoria2 = new Categoria();

        boolean t = false;

        String EliminarSQL = "DELETE FROM categorias WHERE CodigoCategoria = '" + pkCategoria + "'";

        t = Objecategoria2.BorrarCategoria(EliminarSQL);

        return t;

    }

    public boolean ActualizarCategoria(String pkCategoria, String ValorActualizar) {

        Categoria Objcategoria = new Categoria();

        boolean t = false;

        String ModificarSQL = "UPDATE categorias SET NombreCategoria = '" + ValorActualizar + "' WHERE CodigoCategoria = '" + pkCategoria + "'";

        t = Objcategoria.ModificarCategoria(ModificarSQL);

        return t;

    }//Fin método

}
