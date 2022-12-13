/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pe.edu.utp.vista;

import pe.edu.utp.entidad.Categoria;
import pe.edu.utp.negocio.ArticuloControl;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CHATARA_II
 */
public class FrmlSeleccionarArticuloCompra extends javax.swing.JDialog {
    
    private FrmlIngreso vista;
    private final ArticuloControl CONTROL;
    private String accion;
    private String nombreAnt;
    
    private String rutaOrigen;
    private String rutaDestino;
    private final String DIRECTORIO="src/Files/Articulos/";
    private String imagen="";
    private String imagenAnterior;
    
    private int totalPorPagina= 10;
    private int numPaginas=1;
    private boolean primeraCarga=true;
    private int totalRegistros;
    /**
     * Creates new form frmlSeleccionarArticuloCompra
     */
    
    
    
    //Para añadir este dialog a mi Jframe tengo q mandar como parametro un objeto del tipo frml 
    public FrmlSeleccionarArticuloCompra(java.awt.Frame parent,FrmlIngreso frm, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        //a mi atributo vista de la clase frmlIngres le doy el valor del frml
        this.vista=frm;
        setTitle("Seleccionar articulos para el ingreso");
        
        //Traje todo lo que tenia en su contructor mi clase frmlArticulo
        this.CONTROL=new ArticuloControl();
        this.paginar();
        this.listar("", false);
        this.primeraCarga=false;
        tabGeneral.setEnabledAt(1, false);        
        this.accion="guardar";
        txtId.setVisible(false);
        this.cargarCategorias();
        
        this.setVisible(true);
    }

    
// Tambien traje sus metodos para evitar errores
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
    
    private void ocultarColumnas(){
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);                                
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
        this.ocultarColumnas();
    }
    
    private void cargarCategorias(){
        DefaultComboBoxModel items=this.CONTROL.seleccionar();
        cboCategoria.setModel(items);        
    }
    
    private void subirImagenes(){
        File origen=new File(this.rutaOrigen);
        File destino=new File(this.rutaDestino);
        
        try {
            InputStream input=new FileInputStream(origen);
            OutputStream output=new FileOutputStream(destino);
            byte[] buf=new byte[1024];
            int largo;
            while ((largo = input.read(buf))>0) {                
                output.write(buf, 0, largo);
            }
            input.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void limpiar(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtCodigo.setText("");
        txtPrecioVenta.setText("");
        txtStock.setText("");
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
        btnSeleccionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1166, 700));

        jLabel1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        txtBuscar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
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

        tablaListado.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
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

        cboNumeroPagina.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cboNumeroPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNumeroPaginaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel11.setText("Total de registros por paginas:");

        cboTotalPorPagina.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cboTotalPorPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "50", "100", "200", "400" }));
        cboTotalPorPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTotalPorPaginaActionPerformed(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(btnSeleccionar))
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(316, 316, 316))
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
                    .addComponent(btnSeleccionar))
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
                .addContainerGap(227, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Listado", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1166, 700));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel3.setText("Nombre: (*)");

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel4.setText("Descripción:");

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
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

        cboCategoria.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel6.setText("Categoria: (*)");

        txtNombre.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel7.setText("PrecioVenta:(*)");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel8.setText("Imagen:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel9.setText("Stock: (*)");

        txtPrecioVenta.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        txtStock.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        lblImagen.setBackground(new java.awt.Color(255, 255, 255));
        lblImagen.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        btnAgregarImagen.setBackground(new java.awt.Color(255, 255, 255));
        btnAgregarImagen.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        btnAgregarImagen.setText("Agregar");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        jLabel12.setText("Codigo: (*)");

        txtCodigo.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel6))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel12))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarImagen))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodigo)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(594, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarImagen))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Mantenimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
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
            int categoriaId=Integer.parseInt(String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),1)));
            String categoriaNombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),2));
            String codigo=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),3));
            String nombre= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),4));
            this.nombreAnt= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),4));
            String precioVenta= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),5));
            String stock= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),6));
            String descripcion= String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),7));
            this.imagenAnterior=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(),8));

            txtId.setText(id);
            Categoria seleccionado=new Categoria(categoriaId,categoriaNombre);
            cboCategoria.setSelectedItem(seleccionado);
            txtCodigo.setText(codigo);
            txtNombre.setText(nombre);
            txtPrecioVenta.setText(precioVenta);
            txtStock.setText(stock);
            txtDescripcion.setText(descripcion);

            ImageIcon image=new ImageIcon(this.rutaOrigen);
            Icon Icono=new ImageIcon(image.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(Icono);
            lblImagen.repaint();

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
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));

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
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));

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
        if (txtNombre.getText().length()==0 || txtNombre.getText().length()>20) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre que tenga menos de 20 caracteres, y es obligatorio", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
        }

        if (txtDescripcion.getText().length()>255){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 255 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
        }

        if (txtStock.getText().length()==0){
            JOptionPane.showMessageDialog(this, "Debes ingresar un stock del artículo, es obligatorio.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtStock.requestFocus();
            return;
        }

        if (txtDescripcion.getText().length()>255){
            JOptionPane.showMessageDialog(this, "Debes ingresar una descripción no mayor a 255 caracteres.","Sistema", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }

        String resp;
        if (this.accion.equals("editar")) {
            //Editar
            String imagenActual="";
            if (this.imagen.equals("")) {
                imagenActual=this.imagenAnterior;
            } else {
                imagenActual=this.imagen;
            }
            Categoria seleccionado=(Categoria)cboCategoria.getSelectedItem();
            resp=this.CONTROL.actualizar(Integer.parseInt(txtId.getText()),seleccionado.getId(),txtCodigo.getText(),txtNombre.getText(),this.nombreAnt,Double.parseDouble(txtPrecioVenta.getText()),Integer.parseInt(txtStock.getText()), txtDescripcion.getText(),imagenActual);
            if (resp.equals("OK")) {
                if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
                this.mensajeOK("Actualizado correctamente");
                this.limpiar();
                this.listar("", false);
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            } else {
                this.mensajeError(resp);
            }
        } else {
            //guardar
            Categoria seleccionado = (Categoria)cboCategoria.getSelectedItem();
            resp=this.CONTROL.insertar(seleccionado.getId(),txtCodigo.getText(),txtNombre.getText(),Double.parseDouble(txtPrecioVenta.getText()),Integer.parseInt(txtStock.getText()), txtDescripcion.getText(),this.imagen);
            if (resp.equals("OK")) {
                if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
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

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        // TODO add your handling code here:
        JFileChooser file=new JFileChooser();
        int estado=file.showOpenDialog(this);

        if (estado==JFileChooser.APPROVE_OPTION) {
            this.imagen=file.getSelectedFile().getName();
            this.rutaOrigen=file.getSelectedFile().getAbsolutePath();
            this.rutaDestino=this.DIRECTORIO+this.imagen;

            ImageIcon image=new ImageIcon(this.rutaOrigen);
            Icon Icono=new ImageIcon(image.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(Icono);
            lblImagen.repaint();
        }
    }//GEN-LAST:event_btnAgregarImagenActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        if (tablaListado.getSelectedRowCount()==1) {
            //String value of para convetir a String un objeto
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String codigo=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            String precio=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            
            //llamo a mi metodo agregar detalles de mi frmlIngreso
            this.vista.agregarDetalles(id, codigo, nombre, precio);          
        } else{
            this.mensajeError("Debe seleccionar un articulo a ingresar");
        }
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    /* --- ELIMINAMOS EL METODO MAIN */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboNumeroPagina;
    private javax.swing.JComboBox<String> cboTotalPorPagina;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblRegistros;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
    
    
    //Clase que sirve para crear un fondo en el JFrame
    class FondoPanel extends JPanel{
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Img/categoriaFondo.png")).getImage(); 
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);            
            
            //Opacamos el fondo por defecto del panel
            setOpaque(false);           
            
            //Dibuja los compentes que ya tenemos
            super.paint(g);
        }
    }
}
