/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MisFormularios;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;


/**
 *
 * @author CHATARA_II
 */



public class frmlPrincipal extends javax.swing.JFrame {

    jPanelGradient fondo=new jPanelGradient();
    JDesktopPane fondo2=new JDesktopPane();
    /**
     * Creates new form newPrinci
     */
    public frmlPrincipal() {
        setContentPane(fondo);
        initComponents();
        this.cargarOpcionesMenu();
        
    }

private void cargarOpcionesMenu(){        
        if (Negocio.Variables.rolNombre.equals("Administrador")) {
            btnCategorias.setEnabled(true);
            btnArticulos.setEnabled(true);
            btnProovedores.setEnabled(true);            
            btnIngresos.setEnabled(true); 
            btnRoles.setEnabled(true);
            btnClientes.setEnabled(true);
            btnVentas.setEnabled(true);
            btnRoles.setEnabled(true);
            btnUsuarios.setEnabled(true);
            btnVerCompras.setEnabled(true);
            btnVerVentas.setEnabled(true);            
        } else if(Negocio.Variables.rolNombre.equals("Almacenero")){
            btnCategorias.setEnabled(true);
            btnArticulos.setEnabled(true);
            btnProovedores.setEnabled(true);            
            btnIngresos.setEnabled(true);
            btnRoles.setEnabled(false);
            btnClientes.setEnabled(false);
            btnVentas.setEnabled(false);
            btnRoles.setEnabled(false);
            btnUsuarios.setEnabled(false);
            btnVerCompras.setEnabled(true);
            btnVerVentas.setEnabled(false);            
        } else if(Negocio.Variables.rolNombre.equals("Vendedor")){
            btnCategorias.setEnabled(false);
            btnArticulos.setEnabled(false);
            btnProovedores.setEnabled(false);            
            btnIngresos.setEnabled(false); 
            btnRoles.setEnabled(false);
            btnClientes.setEnabled(true);
            btnVentas.setEnabled(true);
            btnRoles.setEnabled(false);
            btnUsuarios.setEnabled(false);
            btnVerCompras.setEnabled(false);
            btnVerVentas.setEnabled(true);
        } else{
            btnCategorias.setEnabled(false);
            btnArticulos.setEnabled(false);
            btnProovedores.setEnabled(false);            
            btnIngresos.setEnabled(false); 
            btnRoles.setEnabled(false);
            btnClientes.setEnabled(false);
            btnVentas.setEnabled(false);
            btnRoles.setEnabled(false);
            btnUsuarios.setEnabled(false);
            btnVerCompras.setEnabled(false);
            btnVerVentas.setEnabled(false);
        }
    }    
    
    //Para darle color al panel
class jPanelGradient extends JPanel{
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(253, 200, 48);
        Color color2 = new Color(243, 115, 53);
        GradientPaint gp = new GradientPaint(15, 15, color1, 180, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        
    }    
}

//le doy color al Desktop panel
class fondoDesktop extends JDesktopPane{
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color color1 = new Color(189, 195, 199);
        Color color2 = new Color(44, 62, 80);
        GradientPaint gp = new GradientPaint(15, 15, color1, 180, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);        
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConsultas = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        lblCompras = new javax.swing.JLabel();
        lblPedidos = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        escritorio = new fondoDesktop();
        btnCategorias = new javax.swing.JButton();
        btnArticulos = new javax.swing.JButton();
        btnProovedores = new javax.swing.JButton();
        btnIngresos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnRoles = new javax.swing.JButton();
        btnUsuarios = new javax.swing.JButton();
        btnVerCompras = new javax.swing.JButton();
        btnVerVentas = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblConsultas.setBackground(new java.awt.Color(253, 200, 48));
        lblConsultas.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblConsultas.setForeground(new java.awt.Color(255, 255, 255));
        lblConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/consultasFerre.png"))); // NOI18N
        lblConsultas.setText("Consultas");
        getContentPane().add(lblConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 200, 40));

        lblAlmacen.setBackground(new java.awt.Color(253, 200, 48));
        lblAlmacen.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        lblAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/almacen2.png"))); // NOI18N
        lblAlmacen.setText("ALMACÉN");
        getContentPane().add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 50));

        lblCompras.setBackground(new java.awt.Color(253, 200, 48));
        lblCompras.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblCompras.setForeground(new java.awt.Color(255, 255, 255));
        lblCompras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/comprasFerre.png"))); // NOI18N
        lblCompras.setText("COMPRAS");
        getContentPane().add(lblCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 40));

        lblPedidos.setBackground(new java.awt.Color(253, 200, 48));
        lblPedidos.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblPedidos.setForeground(new java.awt.Color(255, 255, 255));
        lblPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/VentasFerre.png"))); // NOI18N
        lblPedidos.setText("Pedidos");
        getContentPane().add(lblPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 200, 40));

        lblLogin.setBackground(new java.awt.Color(253, 200, 48));
        lblLogin.setFont(new java.awt.Font("Roboto Medium", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/accesoFerre.png"))); // NOI18N
        lblLogin.setText("Login");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 200, 40));
        getContentPane().add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1166, 700));

        btnCategorias.setBackground(new java.awt.Color(247, 151, 50));
        btnCategorias.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnCategorias.setText("Categorias");
        btnCategorias.setBorder(null);
        btnCategorias.setContentAreaFilled(false);
        btnCategorias.setFocusable(false);
        btnCategorias.setOpaque(true);
        btnCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCategoriasMouseExited(evt);
            }
        });
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(btnCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 100, 50));

        btnArticulos.setBackground(new java.awt.Color(247, 151, 50));
        btnArticulos.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnArticulos.setText("Articulos");
        btnArticulos.setBorder(null);
        btnArticulos.setContentAreaFilled(false);
        btnArticulos.setFocusable(false);
        btnArticulos.setOpaque(true);
        btnArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnArticulosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnArticulosMouseExited(evt);
            }
        });
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });
        getContentPane().add(btnArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 100, 50));

        btnProovedores.setBackground(new java.awt.Color(247, 151, 50));
        btnProovedores.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnProovedores.setText("Proovedores");
        btnProovedores.setBorder(null);
        btnProovedores.setContentAreaFilled(false);
        btnProovedores.setFocusable(false);
        btnProovedores.setOpaque(true);
        btnProovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProovedoresMouseExited(evt);
            }
        });
        btnProovedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProovedoresActionPerformed(evt);
            }
        });
        getContentPane().add(btnProovedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 100, 50));

        btnIngresos.setBackground(new java.awt.Color(247, 151, 50));
        btnIngresos.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnIngresos.setText("Ingresos");
        btnIngresos.setBorder(null);
        btnIngresos.setContentAreaFilled(false);
        btnIngresos.setFocusable(false);
        btnIngresos.setOpaque(true);
        btnIngresos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIngresosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIngresosMouseExited(evt);
            }
        });
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 100, 50));

        btnClientes.setBackground(new java.awt.Color(247, 151, 50));
        btnClientes.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(null);
        btnClientes.setContentAreaFilled(false);
        btnClientes.setFocusable(false);
        btnClientes.setOpaque(true);
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClientesMouseExited(evt);
            }
        });
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 100, 50));

        btnVentas.setBackground(new java.awt.Color(247, 151, 50));
        btnVentas.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.setBorder(null);
        btnVentas.setContentAreaFilled(false);
        btnVentas.setFocusable(false);
        btnVentas.setOpaque(true);
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
        });
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 100, 50));

        btnRoles.setBackground(new java.awt.Color(247, 151, 50));
        btnRoles.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnRoles.setText("Roles");
        btnRoles.setBorder(null);
        btnRoles.setContentAreaFilled(false);
        btnRoles.setFocusable(false);
        btnRoles.setOpaque(true);
        btnRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRolesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRolesMouseExited(evt);
            }
        });
        btnRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolesActionPerformed(evt);
            }
        });
        getContentPane().add(btnRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 100, 50));

        btnUsuarios.setBackground(new java.awt.Color(247, 151, 50));
        btnUsuarios.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(null);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setFocusable(false);
        btnUsuarios.setOpaque(true);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 100, 50));

        btnVerCompras.setBackground(new java.awt.Color(247, 151, 50));
        btnVerCompras.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnVerCompras.setText("Ver Compras");
        btnVerCompras.setBorder(null);
        btnVerCompras.setContentAreaFilled(false);
        btnVerCompras.setFocusable(false);
        btnVerCompras.setOpaque(true);
        btnVerCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerComprasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerComprasMouseExited(evt);
            }
        });
        btnVerCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerComprasActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 100, 50));

        btnVerVentas.setBackground(new java.awt.Color(247, 151, 50));
        btnVerVentas.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        btnVerVentas.setText("Ver Ventas");
        btnVerVentas.setBorder(null);
        btnVerVentas.setContentAreaFilled(false);
        btnVerVentas.setFocusable(false);
        btnVerVentas.setOpaque(true);
        btnVerVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVerVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerVentasMouseExited(evt);
            }
        });
        btnVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 650, 100, 50));

        jSeparator9.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSeparator9.setOpaque(true);
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 10));

        jSeparator11.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator11.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator11.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSeparator11.setOpaque(true);
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, 10));

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator14.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSeparator14.setOpaque(true);
        getContentPane().add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, 10));

        jSeparator8.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSeparator8.setOpaque(true);
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, 10));

        jSeparator13.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator13.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator13.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jSeparator13.setOpaque(true);
        getContentPane().add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 200, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/logo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 190));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        // TODO add your handling code here:
        frmlCategoria frml=new frmlCategoria();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        frmlCliente frml=new frmlCliente();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVentasActionPerformed
        // TODO add your handling code here:
//        frmlProovedor frml=new frmlProovedor();
//        escritorio.add(frml);
//        frml.setVisible(true);
    }//GEN-LAST:event_btnVerVentasActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        // TODO add your handling code here:
        frmlArticulo frml=new frmlArticulo();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnProovedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProovedoresActionPerformed
        // TODO add your handling code here:
        frmlProovedor frml=new frmlProovedor();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnProovedoresActionPerformed

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
        // TODO add your handling code here:
        frmlIngreso frml=new frmlIngreso(this);
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:        
        frmlVenta frml=new frmlVenta(this);
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolesActionPerformed
        // TODO add your handling code here:
        frmlRol frml=new frmlRol();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnRolesActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        frmlUsuario frml=new frmlUsuario();
        escritorio.add(frml);
        frml.setVisible(true);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnVerComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerComprasActionPerformed
        // TODO add your handling code here:
//        frmlProovedor frml=new frmlProovedor();
//        escritorio.add(frml);
//        frml.setVisible(true);
    }//GEN-LAST:event_btnVerComprasActionPerformed

    private void btnCategoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseEntered
        // TODO add your handling code here:
        btnCategorias.setOpaque(true);
        btnCategorias.setBackground(new Color(251, 198, 0));
        btnCategorias.setForeground(Color.WHITE);    
        
    }//GEN-LAST:event_btnCategoriasMouseEntered

    private void btnCategoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCategoriasMouseExited
        // TODO add your handling code here:
        btnCategorias.setOpaque(false);
        btnCategorias.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCategoriasMouseExited

    private void btnArticulosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArticulosMouseEntered
        // TODO add your handling code here:
        btnArticulos.setOpaque(true);
        btnArticulos.setBackground(new Color(251, 198, 0));
        btnArticulos.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_btnArticulosMouseEntered

    private void btnArticulosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArticulosMouseExited
        // TODO add your handling code here:
        btnArticulos.setOpaque(false);
        btnArticulos.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnArticulosMouseExited

    private void btnProovedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseEntered
        // TODO add your handling code here:
        btnProovedores.setOpaque(true);
        btnProovedores.setBackground(new Color(251, 198, 0));
        btnProovedores.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnProovedoresMouseEntered

    private void btnProovedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProovedoresMouseExited
        // TODO add your handling code here:
        btnProovedores.setOpaque(false);
        btnProovedores.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnProovedoresMouseExited

    private void btnIngresosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresosMouseEntered
        // TODO add your handling code here:
        btnIngresos.setOpaque(true);
        btnIngresos.setBackground(new Color(251, 198, 0));
        btnIngresos.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnIngresosMouseEntered

    private void btnIngresosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresosMouseExited
        // TODO add your handling code here:
        btnIngresos.setOpaque(false);
        btnIngresos.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnIngresosMouseExited

    private void btnClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseEntered
        // TODO add your handling code here:
        btnClientes.setOpaque(true);
        btnClientes.setBackground(new Color(251, 198, 0));
        btnClientes.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnClientesMouseEntered

    private void btnClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseExited
        // TODO add your handling code here:
        btnClientes.setOpaque(false);
        btnClientes.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnClientesMouseExited

    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered
        // TODO add your handling code here:
        btnVentas.setOpaque(true);
        btnVentas.setBackground(new Color(251, 198, 0));
        btnVentas.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVentasMouseEntered

    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        // TODO add your handling code here:
        btnVentas.setOpaque(false);
        btnVentas.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnVentasMouseExited

    private void btnRolesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseEntered
        // TODO add your handling code here:
        btnRoles.setOpaque(true);
        btnRoles.setBackground(new Color(251, 198, 0));
        btnRoles.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRolesMouseEntered

    private void btnRolesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRolesMouseExited
        // TODO add your handling code here:
        btnRoles.setOpaque(false);
        btnRoles.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnRolesMouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        // TODO add your handling code here:
        btnUsuarios.setOpaque(true);
        btnUsuarios.setBackground(new Color(251, 198, 0));
        btnUsuarios.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        // TODO add your handling code here:
        btnUsuarios.setOpaque(false);
        btnUsuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnVerComprasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerComprasMouseEntered
        // TODO add your handling code here:
        btnVerCompras.setOpaque(true);
        btnVerCompras.setBackground(new Color(251, 198, 0));
        btnVerCompras.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVerComprasMouseEntered

    private void btnVerComprasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerComprasMouseExited
        // TODO add your handling code here:
        btnVerCompras.setOpaque(false);
        btnVerCompras.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnVerComprasMouseExited

    private void btnVerVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerVentasMouseEntered
        // TODO add your handling code here:
        btnVerVentas.setOpaque(true);
        btnVerVentas.setBackground(new Color(251, 198, 0));
        btnVerVentas.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnVerVentasMouseEntered

    private void btnVerVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerVentasMouseExited
        // TODO add your handling code here:
        btnVerVentas.setOpaque(false);
        btnVerVentas.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnVerVentasMouseExited

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
            java.util.logging.Logger.getLogger(frmlPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmlPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmlPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmlPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmlPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulos;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnProovedores;
    private javax.swing.JButton btnRoles;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnVerCompras;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblCompras;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPedidos;
    // End of variables declaration//GEN-END:variables
}
