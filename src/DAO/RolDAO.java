

/**
 *
 * @author CHATARA_II
 */

package DAO;

import Conexion.Conexion;
import Entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class RolDAO {
    
    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public RolDAO(){
        cx=Conexion.getInstancia();
    }
    
    public List<Rol> listar() {
        List<Rol> registros = new ArrayList();
        try {
            ps = cx.conectar().prepareStatement("select * from rol");            
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Rol(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            cx.desconectar();
        }
        return registros;
    }
    
    public List<Rol> seleccionar() {
        List<Rol> registros = new ArrayList();
        try {
            ps = cx.conectar().prepareStatement("select id, nombre from rol order by nombre asc");
            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Rol(rs.getInt(1), rs.getString(2)));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            cx.desconectar();
        }
        return registros;
    }
    
    public int total() {
        int totalRegistros = 0;
        try {
            ps = cx.conectar().prepareStatement("Select count(id) from rol");
            rs = ps.executeQuery();

            if (rs.next()) {
                totalRegistros = rs.getInt("count(id)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            cx.desconectar();
        }
        return totalRegistros;
    }
}
