/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pe.negocio;

/**
 *
 * @author CHATARA_II 
 */

import pe.edu.pe.dao.CategoriaDAO;
import pe.edu.pe.entidad.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {
    private final CategoriaDAO DATOS;
    private Categoria objCategoria;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;

    public CategoriaControl() {
        this.DATOS= new CategoriaDAO();
        this.objCategoria=new Categoria();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto){
        List<Categoria> lista= new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos={"Id", "Nombre", "Descripcion", "Estado"};
        this.modeloTabla=new DefaultTableModel(null, titulos);
        
        String estado;        
        String[] registro = new String[4];
        
        this.registrosMostrados=0;
        for (Categoria item:lista) {
            if (item.isActivo()) {
                estado="Activo";
            } else {
                estado="Inactivo";
            }
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getNombre();
            registro[2]=item.getDescripcion();
            registro[3]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;            
        }      
        return this.modeloTabla;        
    }
    
    public String insertar(String nombre, String Descripcion){
        if (DATOS.existe(nombre)) {
            return "El registro ya existe";
        } else {
            objCategoria.setNombre(nombre);
            objCategoria.setDescripcion(Descripcion);
            if (DATOS.insertar(objCategoria)) {
                return "OK";
            } else {
                return "Error en el registro";
            }            
        }
    }
    
    public String actualizar(int id, String nombre, String nombreAnt, String descripcion){
        if (nombre.equals(nombreAnt)) {
            objCategoria.setId(id);
            objCategoria.setNombre(nombre);
            objCategoria.setDescripcion(descripcion);
            if (DATOS.actualizar(objCategoria)) {
                return "OK";
            } else {
                return "Error en la actualizacion.";
            }
        } else {            
            if (DATOS.existe(nombre)) {
                return "El registro ya existe.";
            } else {
                objCategoria.setId(id);
                objCategoria.setNombre(nombre);
                objCategoria.setDescripcion(descripcion);
                if (DATOS.actualizar(objCategoria)) {
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
}
