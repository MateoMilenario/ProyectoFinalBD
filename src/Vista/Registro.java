/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.ControlCuenta;
import Modelo.CuentaUsuario;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateo
 */
public class Registro extends javax.swing.JFrame {

    LinkedList<CuentaUsuario> cuentasBD;
    JFileChooser seleccionador;
    File archivo;
    FileInputStream entrada;

    //Se convierte la imagen en un arreglo de bytes
    Cuenta GUIcuenta;

    //************************************
    String nombre1;
    String nombre2;
    String apellido1;
    String apellido2;
    String generoUsuario;
    String contraseñaU;
    String CorreoU;
    String fechaCreacionU;
    String fechaCreacionCuenta;
    String fechaNacimientoU;
    String nombreUsuario;
    String ubicacion;

    CuentaUsuario cuenta1;

    String ImagenCadena;

    long d;

    public Registro() {

        initComponents();
        this.setLocationRelativeTo(this);

        cuentasBD = new LinkedList<>();
        seleccionador = new JFileChooser();
        ImagenPredeterminada();
        BuscarCuentasBD();

        nombre1 = null;
        nombre2 = null;
        apellido1 = null;
        apellido2 = null;
        nombreUsuario = null;
        generoUsuario = null;
        contraseñaU = null;
        CorreoU = null;
        fechaCreacionU = null;
        fechaCreacionCuenta = null;
        fechaNacimientoU = null;
        ImagenCadena = null;
        archivo = null;
        d = 0;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        genero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        LabelFoto = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        Nombre1 = new javax.swing.JTextField();
        Nombre2 = new javax.swing.JTextField();
        Apellido1 = new javax.swing.JTextField();
        Apellido2 = new javax.swing.JTextField();
        subirimagen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        contraseña = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fechaNacimiento1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        BotonM = new javax.swing.JRadioButton();
        BotonF = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Registrarse = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Crea tu cuenta!");

        jLabel2.setText("Primer Nombre");

        jLabel3.setText("Segundo Nombre*");

        jLabel4.setText("Primer Apellido");

        jLabel5.setText("Segundo Apellido*");

        LabelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        subirimagen.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        subirimagen.setText("Subir");
        subirimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirimagenActionPerformed(evt);
            }
        });

        jLabel6.setText("NombreUsuario");

        eliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(subirimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(104, 104, 104))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NombreUsuario)
                    .addComponent(Nombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(Apellido1)
                    .addComponent(Apellido2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nombre2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Apellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(LabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subirimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(7, 7, 7))
        );

        jLabel9.setText("Email");

        jLabel10.setText("Contraseña");

        jLabel11.setText("FechaNacimiento*");

        fechaNacimiento1.setDateFormatString("yy-MM-dd");

        jLabel12.setText("Genero");

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Debe tener máximo 20 caracteres");

        genero.add(BotonM);
        BotonM.setText("Masculino");

        genero.add(BotonF);
        BotonF.setText("Femenino");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaNacimiento1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contraseña)
                            .addComponent(correo)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BotonM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonF)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(BotonM)
                    .addComponent(BotonF))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        Registrarse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Registrarse.setText("Registrar cuenta");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });

        Volver.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Volver.setText("Regresar");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Volver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registrarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Registrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subirimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirimagenActionPerformed

        if (seleccionador.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {

            archivo = seleccionador.getSelectedFile();

            if (archivo.canRead()) {

                //El endsWith especifica si la cadena que compone el archivo imagen termina en jpg o png para ser verificada.
                if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png")) {

                    ImageIcon icon = new ImageIcon(archivo.toString());

                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(LabelFoto.getWidth(), LabelFoto.getHeight(), Image.SCALE_DEFAULT));

                    //Se coloca la imagen con el tamaño que tiene el labol
                    LabelFoto.setIcon(icono);

                }//Fin tercer if

            }//Fin segundo if

        }//Fin primer if

    }//GEN-LAST:event_subirimagenActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed

        Calendar c1 = Calendar.getInstance();

        nombre1 = Nombre1.getText();
        nombre2 = Nombre2.getText();
        apellido1 = Apellido1.getText();
        apellido2 = Apellido2.getText();
        nombreUsuario = NombreUsuario.getText();

        if (apellido2.equals("")) {

            apellido2 = "";

        } else if (nombre2.equals("")) {

            nombre2 = "";

        }//Fin if

        //Se válida el campo de genero dependiendo del que haya seleccionado
        if (BotonM.isSelected()) {

            generoUsuario = "M";

        } else if (BotonF.isSelected()) {

            generoUsuario = "F";

        }//Fin if

        //generoUsuario = genero.getSelectedItem().toString();
        contraseñaU = contraseña.getText();
        CorreoU = correo.getText();

        //Se hace una conversión de fecha proveniente de jCalender con 
        //estructura sql
        Date date = fechaNacimiento1.getDate();

        //Se verifica que la fecha de nacimiento no venga vacía, de tal forma que no genere un error
        if (date != null) {

            d = date.getTime();

            java.sql.Date fecha = new java.sql.Date(d);

            fechaNacimientoU = String.valueOf(fecha).substring(2, 10);

        }//Fin if

        if (fechaNacimientoU == null) {

            fechaNacimientoU = "00-00-00";

        }//Fin if

        //Se obtiene el año, mes y día en el momento en que se crea la cuenta
        String Dia2 = Integer.toString(c1.get(Calendar.DATE));
        String Mes2 = Integer.toString(c1.get(Calendar.MONTH) + 1);
        String Año2 = Integer.toString(c1.get(Calendar.YEAR));

        //Se obtiene la hora, los minutos y los segundos en el momento en que se inserta el comentario
        String Hora = Integer.toString(c1.get(Calendar.HOUR));
        String Minutos = Integer.toString(c1.get(Calendar.MINUTE));
        String Segundos = Integer.toString(c1.get(Calendar.SECOND));

        if (Segundos.length() == 1) {

            Segundos = "0" + Segundos;

        }//Fin if

        fechaCreacionU = Año2.substring(2, 4) + "-0" + Mes2 + "-" + Dia2 + " " + Hora + ":" + Minutos + ":" + Segundos;

        boolean Ejecutar = ValidarCamposGUI();
        
        //Condición para ejecutar el método de crear cuenta
        if (Ejecutar) {

            //Invoca el método para crear la cuenta cuando todo se haya cumplido
            CrearCuenta();

        }//Fin if

    }//GEN-LAST:event_RegistrarseActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        ImagenPredeterminada();

    }//GEN-LAST:event_eliminarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed

        GUIcuenta = new Cuenta();
        GUIcuenta.show();
        this.dispose();
        Registrarse.setEnabled(true);

    }//GEN-LAST:event_VolverActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    //Método para abrir el archivo Tipo Imagen y devuelve una imagen en un arreglo de bytes
    public byte[] AbrirImagenPerfil(File archivo) {

        byte[] Imagen = null;

        try {

            entrada = new FileInputStream(archivo);
            Imagen = new byte[(int) archivo.length()];
            entrada.read(Imagen);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Fallo en subir la imagen:  " + e, "Error", JOptionPane.ERROR_MESSAGE);

        }

        return Imagen;

    }//Fin método

    //Método que establece la imagen predeterminada en la foto de perfil
    public void ImagenPredeterminada() {

        String barra = File.separator;
        //ubicacion = System.getProperty("user.home") + barra + "Desktop" + barra + "Perfil.jpg" + barra;
        ubicacion = System.getProperty("user.dir") + barra + "src" + barra + "Imagenes" + barra + "Perfil.jpg" + barra;

        ImageIcon icon2 = new ImageIcon(Registro.class.getResource("/Imagenes/Perfil.jpg"));
        Icon icono2 = new ImageIcon(icon2.getImage().getScaledInstance(LabelFoto.getWidth(), LabelFoto.getHeight(), Image.SCALE_DEFAULT));
        LabelFoto.setIcon(icono2);

    }//Fin método

    public void BuscarCuentasBD() {

        ControlCuenta Ccuenta = new ControlCuenta();

        cuentasBD = Ccuenta.TraerCuentasRegistradas();

    }//Fin método

    public boolean ValidarNombreUsuario() {

        boolean validacion = false;

        if (cuentasBD.isEmpty() == false) {

            for (int i = 0; i < cuentasBD.size(); i++) {

                if (cuentasBD.get(i).getNombreUsuario().equals(nombreUsuario)) {

                    validacion = true;

                } else {

                    validacion = false;

                }//Fin if

            }//Fin for

        } else {

            validacion = false;

        }//Fin if para validar si el linkedList no venga vacío

        return validacion;

    }//Fin método

    public void CrearCuenta() {

        boolean t = ValidarNombreUsuario();

        if (t) {

            JOptionPane.showMessageDialog(null, "El nombre usuario introducido ya existe.", "Advertencia", JOptionPane.ERROR_MESSAGE);

        } else {

            //Se crea un objeto de la clase cuenta
            //Además, en el campo de Foto cuenta, se envía la ruta donde está la imagen en la pc
            //Otro aspecto a indicar, es si el archivo que contiene la ruta de la imagen está vacío, indicará el usuario no subio foto de perfil
            //Por ende, se guarda una imagen de perfil predeterminada en el aplicativo
            if (archivo != null) {

                cuenta1 = new CuentaUsuario(nombre1, nombre2, apellido1, apellido2, nombreUsuario, generoUsuario, CorreoU, contraseñaU, fechaCreacionU, fechaNacimientoU, archivo.toString());

            } else {

                cuenta1 = new CuentaUsuario(nombre1, nombre2, apellido1, apellido2, nombreUsuario, generoUsuario, CorreoU, contraseñaU, fechaCreacionU, fechaNacimientoU, ubicacion);

            }//Fin if

            ControlCuenta Ccuenta = new ControlCuenta();

            boolean f = Ccuenta.insertarCuenta(cuenta1);

            if (f) {

                JOptionPane.showMessageDialog(null, "Cuenta registrada exitosamente.");

            } else {

                JOptionPane.showMessageDialog(null, "Cuenta no registrada exitosamente", "Error", JOptionPane.ERROR_MESSAGE);

            }//Fin if

            Nombre1.setText("");
            Nombre2.setText("");
            Apellido1.setText("");
            Apellido2.setText("");
            NombreUsuario.setText("");
            contraseña.setText("");
            correo.setText("");
            //genero.setSelectedItem("-------------------------------------");
            Registrarse.setEnabled(false);

        }//Fin if validación nombreUsuario

    }//Fin método

    public boolean ValidarCamposGUI() {

        boolean t = true;

        //**************************************************************************************************************
        //Se válida que los campos obligatorios no estén vacíos
        if (nombre1.equals("")) {

            JOptionPane.showMessageDialog(null, "Ingresar el primer nombre.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;

        }//Fin if

        if (apellido1.equals("")) {

            JOptionPane.showMessageDialog(null, "Ingresar el primer apellido.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;
            
        }//Fin if

        if (nombreUsuario.equals("")) {

            JOptionPane.showMessageDialog(null, "Ingresar el nombre del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;

        }//Fin if

        if (generoUsuario == null) {

            JOptionPane.showMessageDialog(null, "Ingresar el género del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;

        }//Fin if

        if (contraseñaU.equals("")) {

            JOptionPane.showMessageDialog(null, "Ingresar la contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;

        }//Fin if

        if (CorreoU.equals("")) {

            JOptionPane.showMessageDialog(null, "Ingresar el correo eléctronico.", "Error", JOptionPane.ERROR_MESSAGE);
            t = false;

        }//Fin if

        return t;

    }//Fin método

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido1;
    private javax.swing.JTextField Apellido2;
    private javax.swing.JRadioButton BotonF;
    private javax.swing.JRadioButton BotonM;
    private javax.swing.JLabel LabelFoto;
    private javax.swing.JTextField Nombre1;
    private javax.swing.JTextField Nombre2;
    private javax.swing.JTextField NombreUsuario;
    private javax.swing.JButton Registrarse;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField contraseña;
    private javax.swing.JTextField correo;
    private javax.swing.JButton eliminar;
    private com.toedter.calendar.JDateChooser fechaNacimiento1;
    private javax.swing.ButtonGroup genero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton subirimagen;
    // End of variables declaration//GEN-END:variables
}
