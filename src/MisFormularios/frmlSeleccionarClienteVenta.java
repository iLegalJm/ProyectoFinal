/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package MisFormularios;

import Negocio.PersonaControl;
import javax.swing.JOptionPane;

/**
 *
 * @author CHATARA_II
 */
public class frmlSeleccionarClienteVenta extends javax.swing.JDialog {

    /**
     * Creates new form frmlSeleccionarProovedorCompra
     */
    private frmlVenta vista;
    private final PersonaControl CONTROL;
    private String accion;
    
    private String nombreAnterior;
    
    private int totalPorPagina= 10;
    private int numPaginas=1;
    private boolean primeraCarga=true;
    private int totalRegistros;
    
    public frmlSeleccionarClienteVenta(java.awt.Frame parent, frmlVenta frml, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);//para que me aparezca al centro el frml
        this.vista=frml;
        
        this.CONTROL=new PersonaControl();
        this.paginar();
        this.listar("", false);
        this.primeraCarga=false;
        tabGeneral.setEnabledAt(1, false);        
        this.accion="guardar";
        txtId.setVisible(false);
        
        this.setVisible(true);        
        this.setTitle("Seleccione un cliente para la venta");
    }

    private void paginar(){
        int totalPaginas;
        
        this.totalRegistros=this.CONTROL.total();
        this.totalPorPagina=Integer.parseInt((String)cboTotalPorPagina.getSelectedItem());
        totalPaginas=(int)(Math.ceil((double)this.totalRegistros/this.totalPorPagina));
        
        if (totalPaginas==0) {
            totalPaginas=1;
        }
        cboNumeroPagina.removeAllItems();
        
        for (int i = 1; i <= totalPaginas; i++) {
            cboNumeroPagina.addItem(Integer.toString(i));
        }
        
        cboNumeroPagina.setSelectedIndex(0);
    }
        
    
    private void listar(String texto, boolean paginar){
        this.totalPorPagina=Integer.parseInt((String)cboTotalPorPagina.getSelectedItem());
        if ((String)cboNumeroPagina.getSelectedItem()!=null) {
            this.numPaginas=Integer.parseInt((String)cboNumeroPagina.getSelectedItem());
        }
        
        if (paginar==true) {
            tablaListado.setModel(this.CONTROL.listar(texto, this.totalPorPagina, this.numPaginas));
        } else {
            tablaListado.setModel(this.CONTROL.listar(texto, this.totalPorPagina, 1));
        }
        
        lblRegistros.setText("Mostrando " + this.CONTROL.totalMostrados()+ " registros de un total de " + this.CONTROL.total()+".");
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtId.setText("");
        txtTelefono.setText("");
        txtNumDocumento.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");        
        this.accion="guardar";
    }
    
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnDesactivar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        lblRegistros = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboNumeroPagina = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cboTotalPorPagina = new javax.swing.JComboBox<>();
        btnSeleccionarProovedor = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNumDocumento = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cboTipodocumento = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        txtBuscar.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnEditar.setText("Modificar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaListado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnDesactivar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnActivar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        lblRegistros.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        lblRegistros.setText("Registros");

        jLabel10.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel10.setText("#Pagina:");

        cboNumeroPagina.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        cboNumeroPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNumeroPaginaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel11.setText("Total de registros por paginas:");

        cboTotalPorPagina.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        cboTotalPorPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "50", "100", "200", "400" }));
        cboTotalPorPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTotalPorPaginaActionPerformed(evt);
            }
        });

        btnSeleccionarProovedor.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnSeleccionarProovedor.setText("Seleccionar");
        btnSeleccionarProovedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProovedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActivar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesactivar)
                        .addGap(172, 172, 172)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboNumeroPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cboTotalPorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionarProovedor, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar)
                    .addComponent(btnSeleccionarProovedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboNumeroPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cboTotalPorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActivar)
                    .addComponent(btnDesactivar))
                .addGap(18, 18, 18)
                .addComponent(lblRegistros)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Listado", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setText("Nombre: (*)");

        btnGuardar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel5.setText("(*) Indica que el campo es obligatorio.");

        txtNombre.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel7.setText("Num. documento");

        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel8.setText("Telefono:");

        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel9.setText("Direccion:");

        txtNumDocumento.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel13.setText("Tipo Documento:");

        cboTipodocumento.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        cboTipodocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "Pasaporte", "RUC", " " }));

        jLabel12.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel12.setText("Email: (*)");

        txtTelefono.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboTipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnGuardar)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnCancelar))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                            .addComponent(txtNumDocumento)
                            .addComponent(txtTelefono)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboTipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNumDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Mantenimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.listar(txtBuscar.getText(), false);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion="guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount()==1) {
            String id= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),0));
            //String tipoPersona=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),2));
            this.nombreAnterior= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),2));
            String tipoDocumento= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),3));
            String numDocumento= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),4));
            String direccion= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),5));
            String telefono= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),6));
            String email= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),7));

            txtId.setText(id);
            txtNombre.setText(nombre);
            cboTipodocumento.setSelectedItem(tipoDocumento);
            txtNumDocumento.setText(numDocumento);
            txtDireccion.setText(direccion);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);

            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion="editar";
            btnGuardar.setText("Editar");
        } else {
            this.mensajeError("Seleccione 1 registro por favor");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        // TODO add your handling code here:
        String resp;
        if (tablaListado.getSelectedRowCount()==1) {
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));

            if (JOptionPane.showConfirmDialog(this, "Deseas desactivar el registro: " + nombre + "?", "Desactivar", JOptionPane.YES_NO_OPTION)==0){
                resp=this.CONTROL.desactivar(Integer.parseInt(id));
                if (resp.equals("OK")) {
                    this.mensajeOK("Registro desactivado");
                    this.listar("", false);
                } else {
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione 1 resgitro a activar");
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        // TODO add your handling code here:
        String resp;
        if (tablaListado.getSelectedRowCount()==1) {
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));

            if (JOptionPane.showConfirmDialog(this, "Deseas activar el registro: " + nombre + "?", "Activar", JOptionPane.YES_NO_OPTION)==0){
                resp=this.CONTROL.activar(Integer.parseInt(id));
                if (resp.equals("OK")) {
                    this.mensajeOK("Registro activado");
                    this.listar("", false);
                } else {
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione 1 resgitro a activar");
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void cboNumeroPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNumeroPaginaActionPerformed
        // TODO add your handling code here:
        if (this.primeraCarga==false) {
            this.listar("", true);
        }
    }//GEN-LAST:event_cboNumeroPaginaActionPerformed

    private void cboTotalPorPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTotalPorPaginaActionPerformed
        // TODO add your handling code here:
        this.paginar();
    }//GEN-LAST:event_cboTotalPorPaginaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().length()==0 || txtNombre.getText().length()>70) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre que tenga menos de 20 caracteres, y es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
        }

        if (txtEmail.getText().length()>50){
            JOptionPane.showMessageDialog(this, "Debes ingresar un email no mayor a 50 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
        }

        if (txtTelefono.getText().length()>15){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 9 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtNumDocumento.requestFocus();
            return;
        }

        if (txtNumDocumento.getText().length()>20){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 8 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtNumDocumento.requestFocus();
            return;
        }

        String resp;
        if (this.accion.equals("editar")) {
            //Editar
            resp=this.CONTROL.actualizar(Integer.parseInt(txtId.getText()), "Proovedor", txtNombre.getText(), this.nombreAnterior, (String)cboTipodocumento.getSelectedItem(),txtNumDocumento.getText(), txtDireccion.getText(),txtTelefono.getText(),txtEmail.getText());
            if(resp.equals("OK")){
                this.mensajeOK("Actualizado correctamente");
                this.limpiar();
                this.listar("",false);
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            }else{
                this.mensajeError(resp);
            }
        } else {
            //guardar
            resp=this.CONTROL.insertar("Cliente", txtNombre.getText(), (String)cboTipodocumento.getSelectedItem(), txtNumDocumento.getText(), txtDireccion.getText(), txtTelefono.getText(), txtEmail.getText());
            if (resp.equals("OK")) {
                this.mensajeOK("Registrado correctamente");
                this.limpiar();
                tabGeneral.setEnabledAt(0, true);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setSelectedIndex(0);
                this.listar("", false);
            } else {
                this.mensajeError(resp);
            }

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
        this.limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSeleccionarProovedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProovedorActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount()==1) {
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            
            this.vista.txtIdCliente.setText(id);
            this.vista.txtNombreCliente.setText(nombre);
            this.setVisible(false);
        } else {
            this.mensajeError("Debe seleccionar un proovedor");
        }
    }//GEN-LAST:event_btnSeleccionarProovedorActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionarProovedor;
    private javax.swing.JComboBox<String> cboNumeroPagina;
    private javax.swing.JComboBox<String> cboTipodocumento;
    private javax.swing.JComboBox<String> cboTotalPorPagina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumDocumento;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
