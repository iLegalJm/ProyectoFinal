
package pe.edu.utp.entidad;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CHATARA_II
 */

@NoArgsConstructor @AllArgsConstructor 
@Setter @Getter 
public class Rol {
    private int id;
    private String nombre;
    private String descripcion;

    public Rol(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    
    /*HashCode es un identificador de 32 bits que se almacena en un Hash en la instancia
    de la clase. El HashCode tiene una especial importancia para el rendimiento de 
    las tablas hash y otras estructuras de datos que agrupan objetos 
    en base al cálculo de los HashCode.*/   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.descripcion);
        return hash;
    }

    
    /*El método equals() de la clase Java String compara las dos cadenas dadas 
    en función del contenido de la cadena. Si algún carácter no coincide, 
    devuelve falso. Si todos los caracteres coinciden, devuelve verdadero.*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }
    
    
}
