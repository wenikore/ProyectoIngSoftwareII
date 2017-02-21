CREATE TABLE public.persona
(
    persona_id integer NOT NULL DEFAULT nextval('persona_persona_id_seq'::regclass),
    persona_identificacion character varying COLLATE pg_catalog."default",
    persona_primernombre character varying COLLATE pg_catalog."default",
    persona_segundonombre character varying COLLATE pg_catalog."default",
    persona_primerapellido character varying COLLATE pg_catalog."default",
    persona_segundoapellido character varying COLLATE pg_catalog."default",
    persona_fechanacimiento date,
    persona_direccion character varying COLLATE pg_catalog."default",
    persona_telefonomovil character varying COLLATE pg_catalog."default",
    persona_telefonofijo character varying COLLATE pg_catalog."default",
    CONSTRAINT persona_pkey PRIMARY KEY (persona_id)
)



CREATE TABLE public.contacto
(
    contacto_id character varying COLLATE pg_catalog."default" NOT NULL,
    persona_id integer,
    contacto_estado character varying COLLATE pg_catalog."default",
    CONSTRAINT contacto_pkey PRIMARY KEY (contacto_id),
    CONSTRAINT contacto_persona FOREIGN KEY (persona_id)
        REFERENCES public.persona (persona_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.usuario
(
    usuario_id character varying COLLATE pg_catalog."default" NOT NULL,
    usuario_nombre character varying COLLATE pg_catalog."default",
    usuario_password character varying COLLATE pg_catalog."default",
    persona_id integer,
    rol_id integer,
    CONSTRAINT usuario_pkey PRIMARY KEY (usuario_id),
    CONSTRAINT usuario_persona FOREIGN KEY (persona_id)
        REFERENCES public.persona (persona_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT usuario_rol FOREIGN KEY (rol_id)
        REFERENCES public.rol (rol_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.rol
(
    rol_id integer NOT NULL,
    rol_nombre character varying COLLATE pg_catalog."default",
    CONSTRAINT rol_pkey PRIMARY KEY (rol_id)
)