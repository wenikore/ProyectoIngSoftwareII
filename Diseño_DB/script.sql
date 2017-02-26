create table Persona(
	persona_id serial primary key,
    persona_identificacion varchar,
    persona_primernombre varchar,
    persona_segundonombre varchar,
    persona_primerapellido varchar,
    persona_segundoapellido varchar,
    persona_fechanacimiento date,
    persona_direccion varchar,
    persona_telefonomovil varchar,
    persona_telefonofijo varchar
    
);

create table Contacto(
	contacto_id serial primary key,
    persona_id integer,
    contacto_estado varchar
);
create table Usuario(
	usuario_id serial primary key,
    usuario_nombre varchar,
    usuario_password varchar,
    persona_id int,
    rol_id int
);
create table Rol(
	rol_id int primary key,
    nombre_rol varchar
);


Alter table contacto 
add constraint contacto_persona foreign key (persona_id) references persona (persona_id)

Alter table usuario 
add constraint usuario_persona foreign key (persona_id) references persona (persona_id)

Alter table usuario 
add constraint usuario_rol foreign key (rol_id) references rol (rol_id)
