




create table categorias (
     id serial not null,
	denominacion character varying (60),
	descripcion character varying (60),
	primary key (id)
)


create table Cliente (
    id serial not null,
	nombre character varying (60),
	apellido character varying (60),
	tipo_cliente_id integer,
	primary key (id)
)

create table Producto (
    id serial not null,
	categoria integer,
	nombre character varying (60),
	descripcion character varying (60),
	precio integer,
	
	primary key (id)
)

create table Tipo_Cliente (
	
    id serial not null,
	nombre character varying (60),
	descripcion character varying (60),
	primary key (id)
)


alter table cliente
add constraint fk_tipo_cliente
foreign key (tipo_cliente_id)
references tipo_cliente(id)



alter table producto
add constraint fk_categoria
foreign key (categoria)
references categorias(id)


select * from categorias
