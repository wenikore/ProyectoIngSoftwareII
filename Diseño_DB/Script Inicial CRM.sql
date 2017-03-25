CREATE OR REPLACE VIEW USUARIOSPORROL
AS SELECT
usuario.usuario_nombre, usuario.usuario_password,rol.rol_nombre
from
usuario, rol
where
usuario.rol_id = rol.rol_id;

INSERT INTO public.rol(
            rol_id, rol_nombre)
    VALUES (1, 'Administrador');
INSERT INTO public.rol(
            rol_id, rol_nombre)
    VALUES (2, 'Supervisor');
INSERT INTO public.rol(
            rol_id, rol_nombre)
    VALUES (3, 'Vendedor');
	
INSERT INTO public.persona(
            persona_id, persona_direccion, persona_email, persona_fechanacimiento, 
            persona_identificacion, persona_primerapellido, persona_primernombre, 
            persona_segundoapellido, persona_telefonofijo, persona_telefonomovil)
    VALUES (1, 'Carrera 53 F No 2B - 18', 'andrespenamantilla@gmail.com', '1991-11-18', 
            '1022371831', 'Peña','Andres', 
            'Mantilla', '4069035', '3193546379');
			
INSERT INTO public.persona(
            persona_id, persona_direccion, persona_email, persona_fechanacimiento, 
            persona_identificacion, persona_primerapellido, persona_primernombre, 
            persona_segundoapellido, persona_telefonofijo, persona_telefonomovil)
    VALUES (2, 'Calle 53 F No 2B - 45', 'wenikore@gmail.com', '1992-03-11', 
            '10202367854', 'Chaparro','Jhon Jairo', 
            'Ceballes', '5221545', '3012565455');	

INSERT INTO public.persona(
            persona_id, persona_direccion, persona_email, persona_fechanacimiento, 
            persona_identificacion, persona_primerapellido, persona_primernombre, 
            persona_segundoapellido, persona_telefonofijo, persona_telefonomovil)
    VALUES (3, 'Calle 45 F No 2B - 45', 'samuel.villanueva.90@hotmail.com', '1990-03-11', 
            '1020456984', 'Villanueva','Samuel Andres', 
            '', '5221545', '3012565455');			
			
//la clave sin encriptar para este usuario es '1022371831'			
INSERT INTO public.usuario(
            usuario_id, usuario_nombre, usuario_password, persona_id, rol_id)
    VALUES (1, 'apenam', 'addc7fbb9dc17a188d708b03be8b5e12', 1, 1);

//la clave sin encriptar para este usuario es '1'		
INSERT INTO public.usuario(
            usuario_id, usuario_nombre, usuario_password, persona_id, rol_id)
    VALUES (2, 'wenikore', 'c4ca4238a0b923820dcc509a6f75849b', 2, 2);
	

//la clave sin encriptar para este usuario es '1'
INSERT INTO public.usuario(
            usuario_id, usuario_nombre, usuario_password, persona_id, rol_id)
    VALUES (3, 'darkdaemon', 'c4ca4238a0b923820dcc509a6f75849b', 3, 3);

UPDATE  public.sequence 
   SET seq_count = 10
 WHERE seq_count= 0;

 select * from sequence;

	
			
			
