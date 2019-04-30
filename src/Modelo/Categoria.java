/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Control.ConnectBD;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author Mateo
 */
public class Categoria {

    private String NombreCategoria;
    private String CodigoCategoria;

    public Categoria() {
    }

    public Categoria(String NombreCategoria, String CodigoCategoria) {
        this.NombreCategoria = NombreCategoria;
        this.CodigoCategoria = CodigoCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getCodigoCategoria() {
        return CodigoCategoria;
    }

    public void setCodigoCategoria(String CodigoCategoria) {
        this.CodigoCategoria = CodigoCategoria;
    }

    //**************************************************************************
    public ResultSet TraerCategorias(String LeerSQL) {

        ResultSet rset = null;

        ConnectBD CBD = new ConnectBD();

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                rset = CBD.getSt().executeQuery(LeerSQL);

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        }//Fin if

        return rset;

    }//Fin método

    public boolean GuardarCategoria(String InsertarSQL) {

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

    }// Fin método

    public boolean BorrarCategoria(String EliminarSQL) {

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

    public boolean ModificarCategoria(String ModificarSQL) {

        ConnectBD CBD = new ConnectBD();

        boolean f = false;

        if (CBD.crearConexion()) {

            try {

                //Statement sentencia = CBD.getConexion().createStatement();
                CBD.getSt().executeUpdate(ModificarSQL);

                f = true;

            } catch (Exception ex) {

                ex.printStackTrace();
                f = false;

            }

        }//Fin if

        return f;
        
    }//Fin método

}
