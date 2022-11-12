/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MisFormularios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author CHATARA_II
 */
public class ColoFila extends DefaultTableCellRenderer{
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){                
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        //if (table.getValueAt(row, column).toString()) {
            
        //}
        
        return this;
    }                                   
        
                                      
                                      
                                      
                                      
    
}
