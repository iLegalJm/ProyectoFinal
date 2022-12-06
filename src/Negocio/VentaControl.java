
package Negocio;

/**
 *
 * @author CHATARA_II 
 */

import Conexion.Conexion;
import DAO.ArticuloDAO;
import DAO.VentaDAO;
import Entidades.Articulo;
import Entidades.DetalleVenta;
import Entidades.Venta;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class VentaControl {
    
    private final VentaDAO DATOS;
    private final ArticuloDAO DATOSARTI;
    private Venta objVenta;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public VentaControl() {
        this.DATOS= new VentaDAO();
        this.DATOSARTI=new ArticuloDAO();
        this.objVenta=new Venta();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina){
        List<Venta> lista= new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        
        String[] titulos={"Id","Usuario ID","Usuario","Cliente ID","Cliente","Tipo Comprobante","Serie","Número","Fecha","Impuesto","Total","Estado"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[12];
        SimpleDateFormat objFecha=new SimpleDateFormat("dd//MM/yyyy");//Importo e instancio y como parametro le paso el formato
        
        this.registrosMostrados=0;
        for (Venta item:lista) {            
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getUsuarioId());
            registro[2]=item.getUsuarioNombre();
            registro[3]=Integer.toString(item.getPersonaId());
            registro[4]=item.getPersonaNombre();
            registro[5]=item.getTipoComprobante();
            registro[6]=item.getSerieComprobante();
            registro[7]=item.getNumComprobante();
            registro[8]=objFecha.format(item.getFecha());//Para mi objeto fecha le agrego la funcion format
            registro[9]=Double.toString(item.getImpuesto());
            registro[10]=Double.toString(item.getTotal());
            registro[11]=item.getEstado();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;            
        }      
        return this.modeloTabla;        
    }
    
    public DefaultTableModel listarDetalles(int id){
        List<DetalleVenta> lista= new ArrayList();
        lista.addAll(DATOS.listarDetalle(id));
        
        String[] titulos={"Id", "Codigo", "Articulo", "Stock", "Cantidad","Precio", "Descuento", "Sub Total"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[8];        
        
        for (DetalleVenta item:lista) {            
            registro[0]=Integer.toString(item.getArticuloId());
            registro[1]=item.getArticuloCodigo();
            registro[2]=item.getArticuloNombre();
            registro[3]=Integer.toString(item.getArticuloStock());
            registro[4]=Integer.toString(item.getCantidad());
            registro[5]=Double.toString(item.getPrecio());
            registro[6]=Double.toString(item.getDescuento());
            registro[7]=Double.toString(item.getSubTotal());
            
            this.modeloTabla.addRow(registro);            
        }      
        return this.modeloTabla;        
    }
    
    public Articulo obtenerArticuloCodigoVenta(String codigo){
        Articulo objArti=DATOSARTI.obtenerArticuloCodigoVenta(codigo);
        return objArti;
    }
    
    public String ultimoSerie(String tipoComprobante){
        return this.DATOS.ultimoSerie(tipoComprobante);
    }
    
    public String ultimoNumero(String tipoComprobante, String serieComprobante){
        return this.DATOS.ultimoNumero(tipoComprobante, serieComprobante);
    }
    
    public String insertar(int personaId, String tipoComprobante, String serieComprobante, String numComprobante, double impuesto, double total, DefaultTableModel modeloDetalles){
        if (DATOS.existe(serieComprobante, numComprobante)) {
            return "El registro ya existe";
        } else {
            objVenta.setUsuarioId(Variables.usuarioID);
            objVenta.setPersonaId(personaId);
            objVenta.setTipoComprobante(tipoComprobante);
            objVenta.setSerieComprobante(serieComprobante);
            objVenta.setNumComprobante(numComprobante);
            objVenta.setImpuesto(impuesto);
            objVenta.setTotal(total);
            List<DetalleVenta> detalles=new ArrayList();
            int articuloId;
            int cantidad;
            double precio;
            double descuento;
            
            for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
                articuloId=Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));                
                cantidad=Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 4)));
                precio=Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 5)));
                descuento=Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 6)));
                detalles.add(new DetalleVenta(articuloId, cantidad, precio, descuento));
            }            
            objVenta.setDetalles(detalles);
            
            if (DATOS.insertar(objVenta)) {
                return "OK";
            } else {
                return "Error en el registro";
            }            
        }
    }    
    
    
    public String anular(int id){
        if (DATOS.anular(id)) {
            return "OK";
        } else {
            return "No se puede anular el registro";
        }
    }    
    
    public int total(){
        return DATOS.total();
    }    
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
    public void reporteComprobante(String idventa){
        Map p=new HashMap();
        p.put("idventa", idventa);
        JasperReport report;
        JasperPrint print;
        
        Conexion cnn=Conexion.getInstancia();
        
        try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/ReporteComrpobante.jasper");
            print=JasperFillManager.fillReport(report, p,cnn.conectar());
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Reporte de Comprobante");
            view.setVisible(true);
        } catch (JRException e) {
            e.getMessage();
        }
    }
    
    
    
    public DefaultTableModel consultaFechas(Date fechaInicio, Date fechaFin){
        List<Venta> lista=new ArrayList();
        lista.addAll(DATOS.consultaFechas(fechaInicio,fechaFin));
        
        String[] titulos={"Id","Usuario ID","Usuario","Cliente ID","Cliente","Tipo Comprobante","Serie","Número","Fecha","Impuesto","Total","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String[] registro = new String[12];
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        this.registrosMostrados=0;
        
        for (Venta item:lista){
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getUsuarioId());
            registro[2]=item.getUsuarioNombre();
            registro[3]=Integer.toString(item.getPersonaId());
            registro[4]=item.getPersonaNombre();
            registro[5]=item.getTipoComprobante();
            registro[6]=item.getSerieComprobante();
            registro[7]=item.getNumComprobante();
            registro[8]=sdf.format(item.getFecha());
            registro[9]=Double.toString(item.getImpuesto());
            registro[10]=Double.toString(item.getTotal());
            registro[11]=item.getEstado();
            
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    
}
