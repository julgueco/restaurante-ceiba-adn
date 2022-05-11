insert into descuento(id, cantidad_dias, porcentaje, activo) values(1,6,10,1);
insert into menu(id, nombre, activo) values(1,'Menu lunes',1);
insert into menu(id, nombre, activo) values(2,'Menu jueves',0);
insert into producto(id, nombre, precio) values(1,'Papa a la francesa',3000);
insert into producto(id, nombre, precio) values(2,'Carne asada',4000);
insert into producto(id, nombre, precio) values(3,'Crema de zanahoria',3000);
insert into menu_producto(id, id_menu, id_producto) values(1,1,1);