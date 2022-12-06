#PROCEDIMIENTO ALMACENADO PARA LISTAR ARTICULOS
DELIMITER //
CREATE PROCEDURE sp_listar_articulos(
	in nombre varchar(100), in valor1 int, valor2 int)
BEGIN
	SELECT a.id,a.categoria_id, c.nombre as categoria_nombre, a.codigo, a.nombre, 
    a.precio_venta, a.stock, a.descripcion, a.imagen, a.activo FROM articulo a 
    inner join categoria c ON a.categoria_id=c.id 
    WHERE a.nombre LIKE nombre ORDER BY a.id ASC LIMIT valor1, valor2;
END //
call sp_listar_articulos("%a%", 0, 9);

#PROCEDIMIENTO ALMACENADO PARA INSERTAR ARTICULOS
DELIMITER //
CREATE PROCEDURE sp_insertar_articulo(
	in categoriaId int, in CODIGO varchar(50), in NOMBRE varchar(100), in PRECIO decimal(11,2), 
    in STOCK int, in DESCRIPCION varchar(255),in IMAGEN varchar(50), in ESTADO bit(1)
    )
begin
	INSERT INTO articulo (categoria_id,codigo,nombre,precio_venta,stock,descripcion,imagen,activo) 
    VALUES (categoriaId,CODIGO,NOMBRE,PRECIO,STOCK,DESCRIPCION,IMAGEN,ESTADO);
END //
call sp_insertar_articulo(2, "1234567", "ejem", 10, 1, " ", "", 1); #EJEMPLO DE sp_insertar_articulo
select * from articulo order by id desc;

#PROCEDIMIENTO ALMACENADO PARA ACTIVAR UN ARTICULOS
DELIMITER //
CREATE PROCEDURE sp_activar_articulo(
	IN ID int
    )
BEGIN
	update articulo set activo=1 where id=ID;
END //
call sp_activar_articulo(7); #EJEMPLO DE sp_activar_articulo
