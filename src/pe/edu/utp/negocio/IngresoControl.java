/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.negocio;

/**
 *
 * @author CHATARA_II Cueva Zevallos
 */

import pe.edu.utp.dao.ArticuloDAO;
import pe.edu.utp.dao.IngresoDAO;
import pe.edu.utp.entidad.Articulo;
import pe.edu.utp.entidad.DetalleIngreso;
import pe.edu.utp.entidad.Ingreso;
import pe.edu.utp.entidad.Venta;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class IngresoControl {
    
    private final IngresoDAO DATOS;
    private final ArticuloDAO DATOSARTI;
    private Ingreso objIngreso;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public IngresoControl() {
        this.DATOS= new IngresoDAO();
        this.DATOSARTI=new ArticuloDAO();
        this.objIngreso=new Ingreso();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto, int totalPorPagina, int numPagina){
        List<Ingreso> lista= new ArrayList();
        lista.addAll(DATOS.listar(texto, totalPorPagina, numPagina));
        
        String[] titulos={"Id","Usuario Id","Usuario","Proovedor Id","Proovedor","Tipo Comprobante","Serie","Numero", "Fecha", "Impuesto", "Total","Estado"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[12];
        SimpleDateFormat objFecha=new SimpleDateFormat("dd//MM/yyyy");//Importo e instancio y como parametro le paso el formato
        
        this.registrosMostrados=0;
        for (Ingreso item:lista) {            
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
        List<DetalleIngreso> lista= new ArrayList();
        lista.addAll(DATOS.listarDetalle(id));
        
        String[] titulos={"Id", "Codigo","Articulo", "Cantidad","Precio","Sub Total"};
        this.modeloTabla=new DefaultTableModel(null, titulos);   
        
        String estado;        
        String[] registro = new String[6];        
        
        for (DetalleIngreso item:lista) {            
            registro[0]=Integer.toString(item.getArticuloId());
            registro[1]=item.getArticulocodigo();
            registro[2]=item.getArticuloNombre();
            registro[3]=Integer.toString(item.getCantidad());
            registro[4]=Double.toString(item.getPrecio());
            registro[5]=Double.toString(item.getSubTotal());
            
            this.modeloTabla.addRow(registro);            
        }      
        return this.modeloTabla;        
    }
    
    public Articulo obtenerArticuloCodigoIngreso(String codigo){
        Articulo objArti=DATOSARTI.obtenerArticuloCodigoIngreso(codigo);
        return objArti;
    }
    
    public String insertar(int personaId, String tipoComprobante, String serieComprobante, String numComprobante, double impuesto, double total, DefaultTableModel modeloDetalles){
        if (DATOS.existe(serieComprobante, numComprobante)) {
            return "El registro ya existe";
        } else {
            objIngreso.setUsuarioId(Variables.usuarioID);
            objIngreso.setPersonaId(personaId);
            objIngreso.setTipoComprobante(tipoComprobante);
            objIngreso.setSerieComprobante(serieComprobante);
            objIngreso.setNumComprobante(numComprobante);
            objIngreso.setImpuesto(impuesto);
            objIngreso.setTotal(total);
            List<DetalleIngreso> detalles=new ArrayList();
            int articuloId;
            int cantidad;
            double precio;
            
            for (int i = 0; i < modeloDetalles.getRowCount(); i++) {
                articuloId=Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 0)));
                cantidad=Integer.parseInt(String.valueOf(modeloDetalles.getValueAt(i, 3)));
                precio=Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 4)));
                detalles.add(new DetalleIngreso(articuloId, cantidad, precio));
            }            
            objIngreso.setDetalles(detalles);
            
            if (DATOS.insertar(objIngreso)) {
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
    
    public DefaultTableModel consultaFechas(Date fechaInicio, Date fechaFin){
        List<Ingreso> lista=new ArrayList();
        lista.addAll(DATOS.consultaFechas(fechaInicio,fechaFin));
        
        String[] titulos={"Id","Usuario ID","Usuario","Proovedor ID","Proovedor","Tipo Comprobante","Serie","Número","Fecha","Impuesto","Total","Estado"};
        this.modeloTabla=new DefaultTableModel(null,titulos);        
        
        String[] registro = new String[12];
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        this.registrosMostrados=0;
        
        for (Ingreso item:lista){
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
