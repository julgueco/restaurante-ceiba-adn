create table cliente (
 id int(11) not null auto_increment,
 numero_documento varchar(10) not null,
 nombre varchar(100) not null,
 celular varchar(10) not null,
 correo varchar(50) not null,
 cantidad_dias int(4) not null,
 primary key (id)
);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(50) not null,
 precio DECIMAL(10,2) not null,
 primary key (id)
);

create table menu (
 id int(11) not null auto_increment,
 nombre varchar(50) not null,
 activo TINYINT not null,
 primary key (id)
);

create table menu_producto (
 id int(11) not null auto_increment,
 id_menu int(11) not null,
 id_producto int(11) not null,
 primary key (id)
);

create table descuento (
 id int(11) not null auto_increment,
 cantidad_dias int(4) not null,
 porcentaje int(4) not null,
 activo TINYINT not null,
 primary key (id)
);

create table pedido (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 id_descuento int(11) null,
 precio_total DECIMAL(10,2) not null,
 precio_base TINYINT not null,
 primary key (id)
);

create table pedido_producto (
 id int(11) not null auto_increment,
 id_pedido int(11) not null,
 id_producto int(11) not null,
 primary key (id)
);

ALTER TABLE menu_producto
ADD CONSTRAINT mp_producto_fk
  FOREIGN KEY (id_producto)
  REFERENCES producto (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE menu_producto
ADD CONSTRAINT mp_menu_fk
  FOREIGN KEY (id_menu)
  REFERENCES menu (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE pedido
ADD CONSTRAINT p_cliente_fk
  FOREIGN KEY (id_cliente)
  REFERENCES cliente (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE pedido
ADD CONSTRAINT p_descuento_fk
  FOREIGN KEY (id_descuento)
  REFERENCES descuento (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE pedido_producto
ADD CONSTRAINT pp_producto_fk
  FOREIGN KEY (id_producto)
  REFERENCES producto (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE pedido_producto
ADD CONSTRAINT pp_pedido_fk
  FOREIGN KEY (id_pedido)
  REFERENCES pedido (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;