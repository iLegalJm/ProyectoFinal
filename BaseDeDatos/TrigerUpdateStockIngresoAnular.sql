DELIMITER //
create trigger tr_updateStockIngresoAnular after update on ingreso
for each row begin
	update articulo a 
	join detalle_ingreso di
	on di.articulo_id = a.id
	and di.ingreso_id = new.id
	set a.stock = a.stock - di.cantidad;
END;
//
DELIMITER ;