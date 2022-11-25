
package Entidades;

/**
 *
 * @author CHATARA_II
 */
public class DetalleIngreso {
    private int id;
    private int ingresoId;
    private int articuloId;
    private String articuloCodigo;
    private String articuloNombre;    
    private int cantidad;
    private double precio;
    private double subTotal;

    public DetalleIngreso() {
    }
    
    

    public DetalleIngreso(int id, int ingresoId, String articulocodigo, String articuloNombre, int articuloId, int cantidad, double precio, double subTotal) {
        this.id = id;
        this.ingresoId = ingresoId;
        this.articuloCodigo = articulocodigo;
        this.articuloNombre = articuloNombre;
        this.articuloId = articuloId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public DetalleIngreso(int id, String articuloNombre, int articuloId, int cantidad, double precio, double subTotal) {
        this.id = id;
        this.articuloNombre = articuloNombre;
        this.articuloId = articuloId;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public DetalleIngreso(int articuloId, String articuloCodigo, String articuloNombre, int cantidad, double precio, double subTotal) {
        this.articuloId = articuloId;
        this.articuloCodigo = articuloCodigo;
        this.articuloNombre = articuloNombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subTotal = subTotal;
    }

    public DetalleIngreso(int articuloId, int cantidad, double precio) {
        this.articuloId = articuloId;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
    }

    public String getArticulocodigo() {
        return articuloCodigo;
    }

    public void setArticulocodigo(String articulocodigo) {
        this.articuloCodigo = articulocodigo;
    }

    public String getArticuloNombre() {
        return articuloNombre;
    }

    public void setArticuloNombre(String articuloNombre) {
        this.articuloNombre = articuloNombre;
    }

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetalleIngreso{" + "id=" + id + ", ingresoId=" + ingresoId + ", articulocodigo=" + articuloCodigo + ", articuloNombre=" + articuloNombre + ", articuloId=" + articuloId + ", cantidad=" + cantidad + ", precio=" + precio + ", subTotal=" + subTotal + '}';
    }        
}
