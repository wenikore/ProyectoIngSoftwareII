create or replace view usuariosPorRol
AS SELECT
usuario.usuario_nombre, usuario.usuario_password,rol.rol_nombre
from
usuario, rol
where
usuario.rol_id = rol.rol_id;
