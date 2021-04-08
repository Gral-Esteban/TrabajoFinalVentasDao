
select codigo,descripcion,p_dolar,p_venta,origen,proveedor from productos2 order by codigo

select codigo,descripcion,p_dolar,p_venta,origen,proveedor from productos1 order by codigo

select * from productos2 order by codigo
select * from producto order by codigo

do $$
begin
if exists(select codigo from productos1 where codigo='018') then
raise notice 'el codigo efcetivamente existe';
else
raise notice 'el codigo no existe';
end if;
end $$


do $$
begin

if exists (select productos2.codigo from  productos2  inner join productos1 on productos2.codigo=productos1.codigo) then




UPDATE 	productos1 
SET p_venta = (select p_venta from productos2  where (productos1.codigo=codigo) and (productos1.proveedor=proveedor)) , 
	descripcion = (select descripcion from productos2  where productos1.codigo=codigo and productos1.proveedor=proveedor),
	origen = (select origen from productos2  where (productos1.codigo=codigo) and (productos1.proveedor=proveedor)); 
	


select max(id) from productos1

select * from productos1 order by id
select * from productos2

(select min(id) from productos2 where codigo not in (select productos1.codigo from productos1) or proveedor not in(select productos1.proveedor from productos1 where productos1.codigo=productos2.codigo)  )

drop table if exists productos1
delete from productos1
where id=631

select codigo from productos2 where codigo not in (select productos1.codigo from productos1)


delete from productos2
where id=2

end if;

end $$


UPDATE productos1 a, productos2 b
SET precio = b.precio
WHERE a.codigo = b.codigo

alter table productos1
add constraint fk1
foreign key (codigo)
references productos2 (codigo)




create table public.tabla1 (
	id serial not null,
	codigo character varying (100) ,
	proveedor character varying (100) not null,
	primary key (id)
)




create table public.tabla2 (
	id serial not null,
	codigo character varying (100) ,
	descripcion character varying (100) not null,
	precio float not null,
	proveedor character varying (100) not null,
	origen character varying (100) not null,
	primary key (id)
)



create table public.productos1 (
	id serial not null,
	codigo character varying (100) not null ,
	descripcion character varying (100) not null,
	p_dolar float ,
	p_costo float ,
	p_venta float not null,
	origen character varying (100) ,
	proveedor character varying (100) not null,
	stock integer,
	categoria character varying (100),
	primary key (id)
)



insert into productos2(codigo,descripcion,p_dolar,p_costo,p_venta,origen,proveedor,stock,categoria) values('002','j11 new edition',5.89,1440.5,2223.44,'japon','motorolla',100,'celulares')


select * from productos2 order by id
select * from productos1 order by id

/*id serial not null,*/
/*primary key (id)*/

copy public.productosfar from 'D:\LibroCSVfull.csv' delimiter ';' CSV HEADER;

COPY PUBLIC.productosfar2 FROM 'D:\LISTA OKINOI AGOSTO_2020 CSV.csv' DELIMITER ';' CSV HEADER;

/*################### CREATE TABLE IF NOT EXISTS ######################*/

CREATE TABLE IF NOT EXISTS  public.productos1 (
	id serial not null,
	codigo character varying (100) not null ,
	descripcion character varying (100) not null,
	p_dolar float ,
	p_costo float ,
	p_venta float not null,
	origen character varying (100) ,
	proveedor character varying (100) not null,
	stock integer,
	categoria character varying (100),
	primary key (id)
)

/*################## END CREATE TABLE IF NOT EXISTS ##########################*/

ALTER TABLE tabla1 ADD UNIQUE (codigo, proveedor); /*Ësto crea una restriccion unica para que no existan mas de un registro con el mismo codigo y proveedor simultaneamente*/
CREATE UNIQUE INDEX ON tabla2 (codigo, proveedor);

/*################# DELETE AND CREATE TABLE ##########################*/

drop table if exists productos1; 
create table public.productos1 (
	id serial not null,
	codigo character varying (100) not null ,
	descripcion character varying (100) not null,
	p_dolar float ,
	p_costo float ,
	p_venta float not null,
	origen character varying (100) ,
	proveedor character varying (100) not null,
	stock integer,
	categoria character varying (100),
	imagen character varying (200),
	fecha_ingreso date,
	UNIQUE (codigo, proveedor),
	primary key (id)
	
)

/*################## END DELETE AND CREATE TABLE ##########################*/

select count(codigo) from tabla2 where codigo not in (select tabla1.codigo from tabla1) or proveedor not in(select tabla1.proveedor from tabla1 where tabla1.codigo=tabla2.codigo)

select * from productos1 order by id
select * from productos2 order by id

select * from tabla1
select * from tabla2


/*##################### UPDATE TABLE ##############################*/

UPDATE productos1 p1 
SET 
descripcion = p2.descripcion,
p_dolar= p2.p_dolar,
p_costo= p2.p_costo,
p_venta= p2.p_venta,
origen= p2.origen,
stock= p1.stock + p2.stock,
categoria = p2.categoria
FROM productos2 p2
WHERE p2.codigo=p1.codigo and p2.proveedor=p1.proveedor;
 
 
/*##################### END UPDATE TABLE ##############################*/

select * from productos1 order by id
select * from productos2 order by id

/*############################ INSERT ################################*/

INSERT INTO productos1(codigo,descripcion,p_dolar,p_costo,p_venta,origen,proveedor,stock,categoria)
SELECT productos2.codigo,productos2.descripcion,productos2.p_dolar,productos2.p_costo,productos2.p_venta,productos2.origen,productos2.proveedor,productos2.stock,productos2.categoria
FROM productos2 
WHERE productos2.codigo NOT IN (SELECT productos1.codigo FROM productos1) OR proveedor NOT IN(SELECT productos1.proveedor FROM productos1 WHERE productos1.codigo=productos2.codigo)  ;


/*######################## END INSERT #########################################*/




/*######################## TESTING CODE #########################################*/
/*La fila que falla contiene (2425, 5622, null, 35.14, 2811.2, 3795.12, CHINA, OKINOI, 10, null).*/
/* La fila que falla contiene (1170, 3399, null, 29.34, 2347.2, 3168.72, CHINA / VIETNAM, OKINOI, 30, BATERIA)*/
SELECT id, codigo, descripcion, proveedor,p_dolar,p_costo,p_venta,origen,stock,categoria
FROM productos2
WHERE codigo='3399' or p_dolar=35.14

WHERE id=null or codigo = null or descripcion = null or proveedor = null

SELECT id, codigo
FROM productos2
GROUP BY id, codigo
HAVING (COUNT(*) > 1)

select  p.descripcion
from productos2 p
inner join productos1 a ON a.codigo=p.codigo and a.proveedor=p.proveedor 
where a.descripcion not in (select p.descripcion from productos1)
FETCH FIRST z ROWS ONLY

do $$
begin
if exists (select codigo from productos2 inner join productos1 on productos2.codigo=productos1.codigo) then
SELECT productos2.descripcion FROM productos2  
			   WHERE (productos2.codigo=productos1.codigo);
else
RAISE NOTICE 'No existe codigo igual';

end if;
end $$


do $$
begin
if exists(select codigo from productos1 where codigo='018') then
raise notice 'el codigo efcetivamente existe';
else
raise notice 'el codigo no existe';
end if;
end $$

drop table if exists productos1


/*Asi lo tenia antes al insert demoraba muchisimo xD*/
do $$
declare x int := (select count(codigo) from productos2 where codigo not in (select productos1.codigo from productos1) or proveedor not in(select productos1.proveedor from productos1 where productos1.codigo=productos2.codigo));
		y int :=0;
begin
while(y < x)
loop
y := y+1;
insert into productos1(codigo,descripcion,p_dolar,p_costo,p_venta,origen,proveedor,stock,categoria)
select productos2.codigo,productos2.descripcion,productos2.p_dolar,productos2.p_costo,productos2.p_venta,productos2.origen,productos2.proveedor,productos2.stock,productos2.categoria
from productos2 
where productos2.id= (select min(id) from productos2 where codigo not in (select productos1.codigo from productos1) or proveedor not in(select productos1.proveedor from productos1 where productos1.codigo=productos2.codigo)  );


end loop;
end $$


select * from productos1 order by id





