
package pe.edu.pe.daoImpl;

import java.util.List;

/**
 *
 * @author CHATARA_II
 */
public interface interfaceCrudSimple<T> {
    public List<T> listar(String texto);
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public boolean desactivar(int id);
    public boolean activar(int id);
    public int total();
    public boolean existe(String texto);    
}
