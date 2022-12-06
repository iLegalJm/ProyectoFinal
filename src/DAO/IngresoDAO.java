
package DAO;

import Conexion.Conexion;
import Entidades.DetalleIngreso;
import Entidades.Ingreso;
import Entidades.Venta;
import java.sql.Statement;
import datosInterfaces.interfaceCrudIngreso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CHATARA_II
 */
public class IngresoDAO implements interfaceCrudIngreso<Ingreso, DetalleIngreso>{
    
    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public IngresoDAO(){
        cx=Conexion.getInstancia();
    }
    
    @Override
    public List<Ingreso> listar(String texto, int totalPorPagina, int numPagina) {
        List<Ingreso> registros=new ArrayList();
        try {
            ps=cx.conectar().prepareStatement("SELECT i.id,i.usuario_id,u.nombre as usuario_nombre,i.persona_id,p.nombre as persona_nombre,i.tipo_comprobante,i.serie_comprobante,i.num_comprobante,i.fecha,i.impuesto,i.total,i.estado FROM ingreso i INNER JOIN persona p ON i.persona_id=p.id INNER JOIN usuario u ON i.usuario_id=u.id WHERE i.num_comprobante LIKE ? ORDER BY i.id ASC LIMIT ?,?");
            ps.setString(1,"%" + texto +"%");            
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Ingreso(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12)));
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

    @Override
    public List<DetalleIngreso> listarDetalle(int id) {
        List<DetalleIngreso> registros=new ArrayList();
        try {
            ps=cx.conectar().prepareStatement("SELECT a.id,a.codigo,a.nombre,d.cantidad,d.precio,(d.cantidad*precio) as SubTotal FROM detalle_ingreso d INNER JOIN articulo a ON d.articulo_id=a.id WHERE d.ingreso_id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new DetalleIngreso(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
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

    @Override
    public boolean insertar(Ingreso obj) {
        resp=false;
        Connection conn=null;
        try {
            conn=cx.conectar();
            conn.setAutoCommit(false);
            String sqlInsertIngreso="INSERT INTO ingreso (persona_id, usuario_id, fecha, tipo_comprobante, serie_comprobante, num_comprobante, impuesto, total, estado) VALUES (?, ?, now(), ?, ?, ?, ?, ?, ?)";
            ps=cx.conectar().prepareStatement(sqlInsertIngreso, Statement.RETURN_GENERATED_KEYS/* Este return me genera el id que es llave primaria*/);
            ps.setInt(1,obj.getPersonaId());
            ps.setInt(2, obj.getUsuarioId());
            ps.setString(3,obj.getTipoComprobante());
            ps.setString(4, obj.getSerieComprobante());
            ps.setString(5, obj.getNumComprobante());
            ps.setDouble(6, obj.getImpuesto());
            ps.setDouble(7, obj.getTotal());
            ps.setString(8, "Aceptado");
            
            int filasAfectadas=ps.executeUpdate(); // al ahcer el execute va generar un uno
            rs=ps.getGeneratedKeys();//aqui obtengo la llave primaria generada
            int idGenerado=0;
                
            if (rs.next()) {
                idGenerado=rs.getInt(1);
            } 
            
            if (filasAfectadas==1) {
                String sqlInsertDetalle="insert into detalle_ingreso (ingreso_id, articulo_id, cantidad, precio) values (?, ?, ?, ?)";
                ps=conn.prepareStatement(sqlInsertDetalle);
                for (DetalleIngreso item : obj.getDetalles()) {
                    ps.setInt(1, idGenerado);
                    ps.setInt(2, item.getArticuloId());
                    ps.setInt(3, item.getCantidad());
                    ps.setDouble(4, item.getPrecio());
                    resp=ps.executeUpdate()>0;
                }
                conn.commit();//si se inserto se abre la conexion
            } else{
                conn.rollback();//regresamos todas las peticiones para no afectar la base de datos
            }
            ps.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            try {
                if(conn!=null){
                conn.rollback();
                } 
            } catch (SQLException ex) {
                Logger.getLogger(IngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally{
             try {                
            if (rs!=null) rs.close();
            if (ps!=null) ps.close();
            if (conn!=null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(IngresoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return resp;
    }

    @Override
    public boolean anular(int id) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("update ingreso set estado='Anulado' where id=?");
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
            ps = cx.conectar().prepareStatement("Select count(id) from ingreso");
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
    public boolean existe(String texto1, String texto2) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("Select id from ingreso where serie_comprobante=? and num_comprobante=?");
            ps.setString(1, texto1);
            ps.setString(2, texto1);
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
    
    public List<Ingreso> consultaFechas(Date fechaInicio, Date fechaFin) {
        List<Ingreso> registros = new ArrayList();
        try {
            ps = cx.conectar().prepareStatement("SELECT i.id, i.usuario_id,u.nombre as usuario_nombre,"
                    + "i.persona_id,p.nombre as persona_nombre,i.tipo_comprobante,i.serie_comprobante,"
                    + "i.num_comprobante,i.fecha,i.impuesto,i.total,i.estado FROM ingreso i "
                    + "INNER JOIN persona p ON i.persona_id=p.id "
                    + "INNER JOIN usuario u ON i.usuario_id=u.id WHERE i.fecha>=? AND i.fecha<=?");
            ps.setDate(1, fechaInicio);
            ps.setDate(2, fechaFin);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Ingreso(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getDouble(10), rs.getDouble(11), rs.getString(12)));
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
}
