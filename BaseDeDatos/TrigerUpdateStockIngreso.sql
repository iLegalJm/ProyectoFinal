DELIMITER //
CREATE TRIGGER tr_updateStockIngreso AFTER INSERT ON detalle_ingreso
 FOR EACH ROW BEGIN
 UPDATE articulo SET stock = stock + NEW.cantidad 
 WHERE articulo.id = NEW.articulo_id;
END
//
DELIMITER ;

drop trigger tr_updateStockIngresoAnular;