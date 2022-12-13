/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.utp.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CHATARA_II
 */

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }       

    @Override
    public String toString() {
        return nombre;
    }

    
}
