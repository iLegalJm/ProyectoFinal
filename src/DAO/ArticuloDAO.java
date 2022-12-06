
package DAO;

import Conexion.Conexion;
import Entidades.Articulo;
import datosInterfaces.interfaceCrudPaginado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author CHATARA_II
 */
public class ArticuloDAO implements interfaceCrudPaginado<Articulo>{
    
    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ArticuloDAO() {
        cx = Conexion.getInstancia();
    }

    @Override
    public List<Articulo> listar(String texto,int totalPorPagina,int numPagina) {
        List<Articulo> registros=new ArrayList();
        try {
            ps=cx.conectar().prepareStatement("call sp_listar_articulos(?, ?, ?)");
            ps.setString(1, "%"+texto+"%");            
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Articulo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getBoolean(10)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            cx.desconectar();
        }
        return registros;
    }
    
    public List<Articulo> listarArticuloVenta(String texto, int totalPorPagina, int numPagina) {
        List<Articulo> registros = new ArrayList();
        try {
            ps = cx.conectar().prepareStatement("SELECT a.id,a.categoria_id, c.nombre as categoria_nombre, a.codigo, a.nombre, a.precio_venta, a.stock, a.descripcion, a.imagen, a.activo FROM articulo a inner join categoria c ON a.categoria_id=c.id WHERE a.nombre LIKE ? AND a.stock>0 AND a.activo=true ORDER BY a.id ASC LIMIT ?,?");
            ps.setString(1, "%" + texto + "%");
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Articulo(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getInt(7),rs.getString(8),rs.getString(9),rs.getBoolean(10)));
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
    
    public Articulo obtenerArticuloCodigoIngreso(String codigo){
        Articulo objArti=null;
        try {
            ps=cx.conectar().prepareStatement("Select id, codigo, nombre, precio_venta, stock from articulo where codigo=?");
            ps.setString(1, codigo);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                objArti=new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
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
        return objArti;
    }  
    
    public Articulo obtenerArticuloCodigoVenta(String codigo){
        Articulo objArti=null;
        try {
            ps=cx.conectar().prepareStatement("Select id, codigo, nombre, precio_venta, stock from articulo where codigo=? AND stock>0 AND activo=1");
            ps.setString(1, codigo);
            rs=ps.executeQuery();
            
            if (rs.next()) {
                objArti=new Articulo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
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
        return objArti;
    }
    
    @Override
    public boolean insertar(Articulo obj) {
        resp=false;
        try {
            ps=cx.conectar().prepareStatement("call sp_insertar_articulo(?, ?, ?, ?, ?, ?, ?, 1)");
            ps.setInt(1,obj.getCategoriaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setDouble(4, obj.getPrecioVenta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            cx.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Articulo obj) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("call sp_actualizar_articulo(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1,obj.getCategoriaId());
            ps.setString(2, obj.getCodigo());
            ps.setString(3, obj.getNombre());
            ps.setDouble(4, obj.getPrecioVenta());
            ps.setInt(5, obj.getStock());
            ps.setString(6, obj.getDescripcion());
            ps.setString(7, obj.getImagen());
            ps.setInt(8, obj.getId());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            cx.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("update articulo set activo=0 where id=?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            cx.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("call sp_activar_articulo(?)");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            cx.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = cx.conectar().prepareStatement("Select count(id) from articulo");
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
    
    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("Select nombre from articulo where nombre=?");
            ps.setString(1, texto);
            rs = ps.executeQuery();

            if (rs.getRow() > 0) {
                resp = true;
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
        return resp = false;
    }

}
