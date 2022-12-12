
/**
 *
 * @author CHATARA_II
 */

package pe.edu.pe.negocio;

import pe.edu.pe.dao.RolDAO;
import pe.edu.pe.entidad.Rol;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class RolControl {
    private final RolDAO DATOS;
    private Rol objRol;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    public RolControl() {
        this.DATOS= new RolDAO();
        this.objRol=new Rol();
        this.registrosMostrados=0;
    }
    
    public DefaultTableModel listar( ){
        List<Rol> lista= new ArrayList();
        lista.addAll(DATOS.listar());
        
        String[] titulos={"Id", "Nombre", "Descripcion"};
        this.modeloTabla=new DefaultTableModel(null, titulos);
                   
        String[] registro = new String[4];
        
        this.registrosMostrados=0;
        for (Rol item:lista) {            
            registro[0]=Integer.toString(item.getId());
            registro[1]=item.getNombre();
            registro[2]=item.getDescripcion();
            this.modeloTabla.addRow(registro);
            this.registrosMostrados=this.registrosMostrados+1;            
        }      
        return this.modeloTabla;        
    }
    
    public int total(){
        return DATOS.total();
    }    
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
}
