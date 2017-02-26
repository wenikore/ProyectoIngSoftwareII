    insert into persona (
    persona_identificacion,
    persona_primernombre,
	persona_segundonombre,
    persona_primerapellido,
	persona_segundoapellido,
 	persona_fechanacimiento,
 	persona_direccion,  
	persona_telefonomovil, 
	persona_telefonofijo) values (
    '1030574915',
    'Samuel',
    'Andres',
    'Villanueva',
    'Pineda',
    '19/06/1990',
    'clle 19 # 3-52 e',
    '3192973866',
    '8297340')
    
    
    insert into contacto (  
    persona_id,
    contacto_estado) values ( 1, 'Activo')
    
    
    insert into rol values (1, 'Administrador')
    
    insert into usuario (
    
    usuario_nombre,
    usuario_password,
    persona_id,
    rol_id) values ('admin', '1234', 1, 1)
