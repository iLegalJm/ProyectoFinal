    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pe.negocio;

/**
 *
 * @author CHATARA_II
 */

import pe.edu.pe.config.Conexion;
import pe.edu.pe.dao.ArticuloDAO;
import pe.edu.pe.dao.CategoriaDAO;
import pe.edu.pe.entidad.Articulo;
import pe.edu.pe.entidad.Categoria;
import java.awt.HeadlessException;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ArticuloControl {
    private final ArticuloDAO DATOS;
    private final CategoriaDAO DATOSCATEGORIA;
    private Articulo objArticulo;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public ArticuloControl() {
        this.DATOS= new ArticuloDAO();
        this.DATOSCATEGORIA=new CategoriaDAO();
        this.objArticulo=new Articulo();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina){
        List<Articulo> lista= new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        
        String[] titulos={"Id","Categoría ID","Categoría","Código","Nombre","Precio Venta","Stock","Descripción","Imagen","Estado"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[10];
        
        this.registrosMostrados=0;
        for (Articulo item:lista) {
            if (item.isActivo()) {
                estado="Activo";
            } else {
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getCategoriaId());
            registro[2]=item.getCategoriaNombre();
            registro[3]=item.getCodigo();
            registro[4]=item.getNombre();
            registro[5]=Double.toString(item.getPrecioVenta());
            registro[6]=Integer.toString(item.getStock());
            registro[7]=item.getDescripcion();
            registro[8]=item.getImagen();
            registro[9]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;            
        }      
        return this.modeloTabla;        
    }
    
    public DefaultTableModel listarArticuloVenta(String texto, int totalPorPagina, int numPagina){
        List<Articulo> lista= new ArrayList();
        lista.addAll(DATOS.listarArticuloVenta(texto, totalPorPagina, numPagina));
        
        String[] titulos={"Id","Categoría ID","Categoría","Código","Nombre","Precio Venta","Stock","Descripción","Imagen","Estado"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[10];
        
        this.registrosMostrados=0;
        for (Articulo item:lista) {
            if (item.isActivo()) {
                estado="Activo";
            } else {
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getCategoriaId());
            registro[2]=item.getCategoriaNombre();
            registro[3]=item.getCodigo();
            registro[4]=item.getNombre();
            registro[5]=Double.toString(item.getPrecioVenta());
            registro[6]=Integer.toString(item.getStock());
            registro[7]=item.getDescripcion();
            registro[8]=item.getImagen();
            registro[9]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;            
        }      
        return this.modeloTabla;        
    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items=new DefaultComboBoxModel();
        List<Categoria> lista=new ArrayList();
        lista=DATOSCATEGORIA.seleccionar();
        for (Categoria item: lista) {
            items.addElement(new Categoria(item.getId(), item.getNombre()));
        }
        return items;
    }
    
    public String insertar(int categoriaId, String codigo, String nombre, double precioVenta, int stock,String descripcion, String imagen){
        if (DATOS.existe(nombre)) {
            return "El registro ya existe";
        } else {
            objArticulo.setCategoriaId(categoriaId);
            objArticulo.setCodigo(codigo);
            objArticulo.setNombre(nombre);
            objArticulo.setPrecioVenta(precioVenta);
            objArticulo.setStock(stock);
            objArticulo.setDescripcion(descripcion);
            objArticulo.setImagen(imagen);
            if (DATOS.insertar(objArticulo)) {
                return "OK";
            } else {
                return "Error en el registro";
            }            
        }
    }
    
    public String actualizar(int id,int categoriaId, String codigo, String nombre, String nombreAnt, double precioVenta, int stock, String descripcion, String imagen){
        if (nombre.equals(nombreAnt)) {
            objArticulo.setId(id);
            objArticulo.setCategoriaId(categoriaId);
            objArticulo.setCodigo(codigo);
            objArticulo.setNombre(nombre);
            objArticulo.setPrecioVenta(precioVenta);
            objArticulo.setStock(stock);
            objArticulo.setDescripcion(descripcion);
            objArticulo.setImagen(imagen);
            if (DATOS.actualizar(objArticulo)) {
                return "OK";
            } else {
                return "Error en la actualizacion.";
            }
        } else {            
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                objArticulo.setId(id);
                objArticulo.setCategoriaId(categoriaId);
                objArticulo.setCodigo(codigo);
                objArticulo.setNombre(nombre);
                objArticulo.setPrecioVenta(precioVenta);
                objArticulo.setStock(stock);
                objArticulo.setDescripcion(descripcion);
                objArticulo.setImagen(imagen);
                if (DATOS.actualizar(objArticulo)) {
                    return "OK";
                } else {
                    return "Error en la actualización.";
                }
            }            
        }
    }
    
    public String activar(int id){
        if (DATOS.activar(id)) {
            return "OK";
        } else {
            return "No se puede activar el registro";
        }
    }
    
    public String desactivar(int id){
        if (DATOS.desactivar(id)) {
            return "OK";
        } else {
            return "No se puede desactivar el registro";
        }
    }
    
    public int total(){
        return DATOS.total();
    }    
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
    //Metodo para traer mi reporte
    public void reporteArticulos(){
        Map p=new HashMap();
        JasperReport report;
        JasperPrint print;
        
        Conexion cnn=Conexion.getInstancia();
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reporte/rptArticulo.jasper");
            print=JasperFillManager.fillReport(report, p,cnn.conectar());
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Artículos");
            view.setVisible(true);
        } catch (JRException e) {
            e.getMessage();
        }
    }
    
    public void reporteArticulosBarras(){
        Map p=new HashMap();
        JasperReport report;
        JasperPrint print=null;        
        Conexion cnn=Conexion.getInstancia();        
        try {
            report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reporte/reporteArticuloBarra.jasper"));
            print=JasperFillManager.fillReport(report, p, cnn.conectar());
            if (print!=null) {
                JasperViewer view=new JasperViewer(print,false);
                view.setTitle("Reporte de Barras de Artículos");
                view.setVisible(true);
            }
        } catch (HeadlessException | NumberFormatException | JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void ejecutarReporte() {
        Conexion cnn=Conexion.getInstancia(); 
        String reportPath = "src/Reporte/reporteArticulos.jasper";
    try {
        // asumiendo que archivo es algo como reporte.jasper
        // MiClase es la clase donde se encuentra este método
        InputStream inputStream = JRLoader.getFileInputStream(reportPath);
            JasperPrint jPrint = JasperFillManager.fillReport(inputStream, null, cnn.conectar());
            JasperViewer jViewer = new JasperViewer(jPrint, false);
            jViewer.setTitle("Personas registradas");            
            jViewer.setVisible(true);
    } catch(JRException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
