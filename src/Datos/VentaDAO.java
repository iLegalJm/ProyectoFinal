/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Conexion.Conexion;
import Entidades.DetalleVenta;
import Entidades.Venta;
import java.sql.Statement;
import datosInterfaces.interfaceCrudVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CHATARA_II
 */
public class VentaDAO implements interfaceCrudVenta<Venta, DetalleVenta>{
    
    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public VentaDAO(){
        cx=Conexion.getInstancia();
    }
    
    @Override
    public List<Venta> listar(String texto, int totalPorPagina, int numPagina) {
        List<Venta> registros=new ArrayList();
        try {
            ps=cx.conectar().prepareStatement("SELECT v.id,v.usuario_id,u.nombre as usuario_nombre,v.persona_id,p.nombre as persona_nombre,v.tipo_comprobante,v.serie_comprobante,v.num_comprobante,v.fecha,v.impuesto,v.total,v.estado FROM venta v INNER JOIN persona p ON v.persona_id=p.id INNER JOIN usuario u ON v.usuario_id=u.id WHERE v.num_comprobante LIKE ? ORDER BY v.id ASC LIMIT ?,?");
            ps.setString(1,"%" + texto +"%");            
            ps.setInt(2, (numPagina-1)*totalPorPagina);
            ps.setInt(3, totalPorPagina);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Venta(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getDate(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12)));
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
    public List<DetalleVenta> listarDetalle(int id) {
        List<DetalleVenta> registros=new ArrayList();
        try {
            ps=cx.conectar().prepareStatement("SELECT a.id,a.codigo,a.nombre,a.stock,d.cantidad,d.precio,d.descuento,((d.cantidad*precio)-d.descuento) as sub_total FROM detalle_venta d INNER JOIN articulo a ON d.articulo_id=a.id WHERE d.venta_id=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new DetalleVenta(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8)));
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
    public boolean insertar(Venta obj) {
        resp=false;
        Connection conn=null;
        try {
            conn=cx.conectar();
            conn.setAutoCommit(false);
            String sqlInsertVenta="INSERT INTO venta (persona_id,usuario_id,fecha,tipo_comprobante,serie_comprobante,num_comprobante,impuesto,total,estado) VALUES (?,?,now(),?,?,?,?,?,?)";
            ps=cx.conectar().prepareStatement(sqlInsertVenta, Statement.RETURN_GENERATED_KEYS/* Este return me genera el id que es llave primaria*/);
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
                String sqlInsertDetalle="INSERT INTO detalle_venta (venta_id,articulo_id,cantidad,precio,descuento) VALUES (?,?,?,?,?)";
                ps=conn.prepareStatement(sqlInsertDetalle);
                for (DetalleVenta item : obj.getDetalles()) {
                    ps.setInt(1, idGenerado);
                    ps.setInt(2, item.getArticuloId());
                    ps.setInt(3, item.getCantidad());
                    ps.setDouble(4, item.getPrecio());
                    ps.setDouble(5, item.getDescuento());
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
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally{
             try {                
            if (rs!=null) rs.close();
            if (ps!=null) ps.close();
            if (conn!=null) conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return resp;
    }

    @Override
    public boolean anular(int id) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("update venta set estado='Anulado' where id=?");
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
            ps = cx.conectar().prepareStatement("Select count(id) from venta");
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
            ps = cx.conectar().prepareStatement("Select id from venta where serie_comprobante=? and num_comprobante=?");
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
    
    public String ultimoSerie(String tipoComprobante) {
        String serieComprobante="";
        try {
            ps=cx.conectar().prepareStatement("SELECT serie_comprobante FROM venta where tipo_comprobante=? order by serie_comprobante desc limit 1");            
            ps.setString(1, tipoComprobante);
            rs=ps.executeQuery();
            
            while(rs.next()){
                serieComprobante=rs.getString("serie_comprobante");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            cx.desconectar();
        }
        return serieComprobante;
    }
    
    public String ultimoNumero(String tipoComprobante,String serieComprobante) {
        String numComprobante="";
        try {
            ps=cx.conectar().prepareStatement("SELECT num_comprobante FROM venta WHERE tipo_comprobante=? AND serie_comprobante=? order by num_comprobante desc limit 1");            
            ps.setString(1, tipoComprobante);
            ps.setString(2, serieComprobante);
            rs=ps.executeQuery();
            
            while(rs.next()){
                numComprobante=rs.getString("num_comprobante");
            }            
            ps.close();
            rs.close();
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps=null;
            rs=null;
            cx.desconectar();
        }
        return numComprobante;
    }
}
