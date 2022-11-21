DELIMITER //
create trigger tr_updateStockVentaAnular after update on venta
	for each row begin
    update articulo a
    join detalle_venta dv
    on dv.articulo_id = a.id
    and dv.venta_id = NEW.id
    set a.stock = a.stock + dv.cantidad;
END;
//
DELIMITER ;