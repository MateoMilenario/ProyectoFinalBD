/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCategoria;
import Control.ControlVideo;
import Modelo.Categoria;
import Modelo.Video;
import java.awt.Image;
import java.io.File;
import java.util.Calendar;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Gomez
 */
public class AgregarVideo extends javax.swing.JFrame {

    LinkedList<Categoria> categorias;
    Principal GUIprincipal2;

    //**********************************************************
    JFileChooser seleccionadorVideo;
    File archivo;
    Video videoAgregar;

    String NombreUsuarioVideo;

    //***************************************************
    String NombreVideo;
    String Formato;
    String Duracion;
    String Categoria;
    String Descripcion;
    String FechaSubido;
    boolean MostrarCategorias;
    String pkCategoria;
    String FormatoVideo;

    public AgregarVideo() {
        initComponents();
        this.setLocationRelativeTo(this);
        categorias = new LinkedList<>();

        TraerCategorias();

        seleccionadorVideo = new JFileChooser();
        archivo = null;
        NombreVideo = null;
        Formato = null;
        Duracion = null;
        Categoria = null;
        Descripcion = null;
        FechaSubido = null;
        MostrarCategorias = true;

        Agregar.setEnabled(false);
        formatoVideo.setEnabled(false);

        ImagenInicial();

    }

    public String getNombreUsuarioVideos() {
        return NombreUsuarioVideo;
    }

    public void setNombreUsuarioVideos(String NombreUsuarioVideo) {
        this.NombreUsuarioVideo = NombreUsuarioVideo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelVideoAgregar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombreVideo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        formatoVideo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionVideo = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        CategoriaAgregarVideo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        Seleccionar = new javax.swing.JButton();
        CambiarVideo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        duracionHoras = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        duracionMinutos = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        duracionSegundos = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Agregar Video");

        LabelVideoAgregar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nombre Video");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Formato Video");

        formatoVideo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------------", "MP4", "MOV" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Duración");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Descripción del video/máximo 150 caracteres ");

        descripcionVideo.setColumns(20);
        descripcionVideo.setRows(5);
        jScrollPane1.setViewportView(descripcionVideo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Seleccionar categoría");

        CategoriaAgregarVideo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------------" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });

        Seleccionar.setText("Seleccionar");
        Seleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarActionPerformed(evt);
            }
        });

        CambiarVideo.setText("Regresar");
        CambiarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarVideoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Seleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CambiarVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Seleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(Agregar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(CambiarVideo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nota:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Seleccionar una sola categoría pa-");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("ra el video a subir en el aplicati-");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("vo multimedia.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        duracionHoras.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        duracionHoras.setText("00");
        duracionHoras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                duracionHorasFocusGained(evt);
            }
        });
        duracionHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionHorasActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Hor");

        duracionMinutos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        duracionMinutos.setText("00");
        duracionMinutos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                duracionMinutosFocusGained(evt);
            }
        });
        duracionMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionMinutosActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Min");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText(":");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText(":");

        duracionSegundos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        duracionSegundos.setText("00");
        duracionSegundos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                duracionSegundosFocusGained(evt);
            }
        });
        duracionSegundos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionSegundosActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Seg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelVideoAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreVideo)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CategoriaAgregarVideo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(formatoVideo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(duracionHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel14)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel15))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(duracionMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel17))
                                            .addComponent(duracionSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelVideoAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(duracionHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(duracionSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(duracionMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(formatoVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CategoriaAgregarVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarActionPerformed

        Agregar.setEnabled(true);

        if (seleccionadorVideo.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {

            archivo = seleccionadorVideo.getSelectedFile();

            if (archivo.canRead()) {

                //El endsWith especifica si la cadena que compone el archivo imagen termina en mp4 o mov para ser verificada.
                if (archivo.getName().endsWith("mp4") || archivo.getName().endsWith("mov")) {

                    if (archivo.getName().endsWith("mp4")) {

                        FormatoVideo = "MP4";

                    } else if (archivo.getName().endsWith("mov")) {

                        FormatoVideo = "MOV";

                    }//Fin condición

                    JOptionPane.showMessageDialog(null, "Archivo de video seleccionado.");

                } else {

                    JOptionPane.showMessageDialog(null, "Formato del video no aceptado. Se recomienda: mp4 o mov.", "Advertencia", JOptionPane.ERROR_MESSAGE);

                }//Fin if

            }//Fin segundo if

        }//Fin primer if

    }//GEN-LAST:event_SeleccionarActionPerformed

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed

        //***************************************************************************************************************************************************************
        NombreVideo = nombreVideo.getText();
        //Formato = formatoImagen.getSelectedItem().toString();
        Formato = FormatoVideo;
        boolean Correcto = true;

        //CONDICIONES PARA OBTENER EL TIEMPO EN FORMATO 00:00:00
        if (duracionHoras.getText().equals("")) {
            Duracion = "00";
        } else {
            switch (duracionHoras.getText().length()) {
                case 1:
                    Duracion = "0" + duracionHoras.getText();
                    break;
                case 2:
                    Duracion = duracionHoras.getText();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Hora no valida", "Advertencia", JOptionPane.ERROR_MESSAGE);
                    Correcto = false;
                    break;
            }
        }

        if (duracionMinutos.getText().equals("")) {
            Duracion = Duracion + ":00";
        } else {
            if (duracionMinutos.getText().length() == 1) {
                Duracion = Duracion + ":0" + duracionMinutos.getText();
            } else if (duracionMinutos.getText().length() == 2 && Integer.parseInt(duracionMinutos.getText()) <= 60) {
                Duracion = Duracion + ":" + duracionMinutos.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Minutos no validos", "Advertencia", JOptionPane.ERROR_MESSAGE);
                Correcto = false;
            }
        }

        if (duracionSegundos.getText().equals("")) {
            Duracion = Duracion + ":00";
        } else {
            if (duracionSegundos.getText().length() == 1) {
                Duracion = Duracion + ":0" + duracionSegundos.getText();
            } else if (duracionSegundos.getText().length() == 2 && Integer.parseInt(duracionSegundos.getText()) <= 60) {
                Duracion = Duracion + ":" + duracionSegundos.getText();
            } else {
                JOptionPane.showMessageDialog(null, "Segundos no validos", "Advertencia", JOptionPane.ERROR_MESSAGE);
                Correcto = false;
            }
        }

        //Duracion = duracionHoras.getText() +":"+ duracionMinutos.getText() +":"+ duracionSegundos.getText();
        Descripcion = descripcionVideo.getText();
        Categoria = CategoriaAgregarVideo.getSelectedItem().toString();

        //**********************************************************************
        Calendar c2 = Calendar.getInstance();
        //Se obtiene el año, mes y día en el momento en que se crea la cuenta
        String Dia2 = Integer.toString(c2.get(Calendar.DATE));
        String Mes2 = Integer.toString(c2.get(Calendar.MONTH) + 1);
        String Año2 = Integer.toString(c2.get(Calendar.YEAR));

        //Se obtiene la hora, los minutos y los segundos en el momento en que se inserta el comentario
        String Hora = Integer.toString(c2.get(Calendar.HOUR));
        String Minutos = Integer.toString(c2.get(Calendar.MINUTE));
        String Segundos = Integer.toString(c2.get(Calendar.SECOND));

        if (Segundos.length() == 1) {

            Segundos = "0" + Segundos;

        }//Fin if

        FechaSubido = Año2.substring(2, 4) + "-0" + Mes2 + "-" + Dia2 + " " + Hora + ":" + Minutos + ":" + Segundos;

        //**************************************************************************************************************
        boolean Ejecutar = ValidarCamposGui();

        if (Ejecutar) {

            //Variable que guadará el pk de categoría proveniente del método pkCategoriaImagen
            pkCategoria = PKcategoriaVideo();

            videoAgregar = new Video(FechaSubido, NombreVideo, Formato, Duracion, Descripcion, archivo.toString());

            ControlVideo CV = new ControlVideo();

            boolean t = CV.InsertarVideo(videoAgregar, NombreUsuarioVideo, pkCategoria);

            if (t) {

                JOptionPane.showMessageDialog(null, "Datos del video guardados.");

            } else {

                JOptionPane.showMessageDialog(null, "Datos del video no guardados.");

            }//Fin if

            nombreVideo.setText("");
            //formatoVideo.setSelectedItem("------------------------------------");
            duracionHoras.setText("00");
            duracionMinutos.setText("00");
            duracionSegundos.setText("00");
            CategoriaAgregarVideo.setSelectedItem("------------------------------------");
            descripcionVideo.setText("");
            ImagenPredeterminada();

        }//Fin if

    }//GEN-LAST:event_AgregarActionPerformed

    private void CambiarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarVideoActionPerformed

        GUIprincipal2 = new Principal();
        GUIprincipal2.setNombreUsuarioPrincipal(NombreUsuarioVideo);
        GUIprincipal2.show();
        this.dispose();

    }//GEN-LAST:event_CambiarVideoActionPerformed

    private void duracionHorasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_duracionHorasFocusGained
        duracionHoras.setText("");
    }//GEN-LAST:event_duracionHorasFocusGained

    private void duracionHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionHorasActionPerformed

    }//GEN-LAST:event_duracionHorasActionPerformed

    private void duracionMinutosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_duracionMinutosFocusGained
        duracionMinutos.setText("");
    }//GEN-LAST:event_duracionMinutosFocusGained

    private void duracionMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionMinutosActionPerformed

    }//GEN-LAST:event_duracionMinutosActionPerformed

    private void duracionSegundosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_duracionSegundosFocusGained
        duracionSegundos.setText("");
    }//GEN-LAST:event_duracionSegundosFocusGained

    private void duracionSegundosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionSegundosActionPerformed

    }//GEN-LAST:event_duracionSegundosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarImagen().setVisible(true);
            }
        });
    }

    public void ImagenPredeterminada() {

        ImageIcon icon2 = new ImageIcon(AgregarVideo.class.getResource("/Imagenes/1.jpg"));
        Icon icono2 = new ImageIcon(icon2.getImage().getScaledInstance(LabelVideoAgregar.getWidth(), LabelVideoAgregar.getHeight(), Image.SCALE_DEFAULT));
        LabelVideoAgregar.setIcon(icono2);

    }//Fin método

    public void ImagenInicial() {

        //Se agrega una imagen predeterminada por una ruta para la sección de videos 
        ImageIcon icon = new ImageIcon(AgregarVideo.class.getResource("/Imagenes/video-icon.jpg"));

        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(LabelVideoAgregar.getWidth(), LabelVideoAgregar.getHeight(), Image.SCALE_DEFAULT));

        //Se coloca la imagen con el tamaño que tiene el labol
        LabelVideoAgregar.setIcon(icono);

    }//Fin método

    //******************************************************************************************************************************************************
    public String PKcategoriaVideo() {

        String pkcategoria = "";

        //Se recorre toda la lista para comparar nombres de categorias, el cual el usuario seleccionó
        //Posteriormente, se extrae el PK asociado a esa categoría para colocarlo en la imagen que será guardado en la BD
        for (int i = 0; i < categorias.size(); i++) {

            if (categorias.get(i).getNombreCategoria().equals(Categoria)) {

                pkcategoria = categorias.get(i).getCodigoCategoria();

            }//Fin if

        }//Fin for

        return pkcategoria;

    }//Fin método

    public void TraerCategorias() {

        //Se trae todo los datos de categorías que se encuentran en la BD
        ControlCategoria CC = new ControlCategoria();

        categorias = CC.LeerCategorias();

        //Este for escribe en el comboBox los nombres de las categorías que yacen en la BD        
        for (int i = 0; i < categorias.size(); i++) {

            CategoriaAgregarVideo.addItem(categorias.get(i).getNombreCategoria());

        }//Fin for

    }//Fin método

    public boolean ValidarCamposGui() {

        boolean Correcto = true;

        //**********************************************************************
        //Se válida que los campos obligatorios a llenar sean llenados por el usuario
        //Si sucede el caso contrario, se facilitará un mensaje de advertencia
        if (archivo == null) {

            JOptionPane.showMessageDialog(null, "Video no seleccionado.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

        if (NombreVideo.equals("")) {

            JOptionPane.showMessageDialog(null, "Nombre del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

//        if (Formato.equals("------------------------------------")) {
//
//            JOptionPane.showMessageDialog(null, "Formato del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
//            Correcto = false;
//
//        }//Fin if

        if (Formato == null) {

            JOptionPane.showMessageDialog(null, "Formato del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

        if (Duracion.equals("::")) {

            JOptionPane.showMessageDialog(null, "Duración del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

        if (Descripcion.equals("")) {

            JOptionPane.showMessageDialog(null, "Descripción del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

        if (Categoria.equals("------------------------------------")) {

            JOptionPane.showMessageDialog(null, "Categoría del video faltante.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            Correcto = false;

        }//Fin if

        return Correcto;

    }//Fin método

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton CambiarVideo;
    private javax.swing.JComboBox<String> CategoriaAgregarVideo;
    private javax.swing.JLabel LabelVideoAgregar;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JTextArea descripcionVideo;
    private javax.swing.JTextField duracionHoras;
    private javax.swing.JTextField duracionMinutos;
    private javax.swing.JTextField duracionSegundos;
    private javax.swing.JComboBox<String> formatoVideo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nombreVideo;
    // End of variables declaration//GEN-END:variables
}
