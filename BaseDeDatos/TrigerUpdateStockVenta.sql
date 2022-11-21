DELIMITER //
create trigger tr_updateStockVenta after insert on detalle_venta
	for each row begin
    update articulo set stock = stock - NEW.cantidad
    where articulo.id = NEW.articulo_id;
END
//
DELIMITER ;