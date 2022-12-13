/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.utp.daoImpl;

import java.util.List;

/**
 *
 * @author CHATARA_II
 */
public interface interfaceCrudIngreso<T, D> {
    public List<T> listar(String texto, int totalPorPagina, int numPagina);
    public List<D> listarDetalle(int id);
    public boolean insertar(T obj);
    public boolean anular(int id);
    public int total();
    public boolean existe(String texto1, String texto2);    
}
