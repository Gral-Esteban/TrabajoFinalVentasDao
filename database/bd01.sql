--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-11-17 01:02:37

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 207 (class 1259 OID 65576)
-- Name: categorias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categorias (
    id integer NOT NULL,
    denominacion character varying(60),
    descripcion character varying(60)
);


ALTER TABLE public.categorias OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 65574)
-- Name: categorias_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categorias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categorias_id_seq OWNER TO postgres;

--
-- TOC entry 2858 (class 0 OID 0)
-- Dependencies: 206
-- Name: categorias_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categorias_id_seq OWNED BY public.categorias.id;


--
-- TOC entry 203 (class 1259 OID 65547)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    nombre character varying(60),
    apellido character varying(60),
    tipo_cliente_id integer,
    documento integer NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 65545)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 2859 (class 0 OID 0)
-- Dependencies: 202
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- TOC entry 209 (class 1259 OID 65584)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.producto (
    id integer NOT NULL,
    categoria integer,
    nombre character varying(60),
    descripcion character varying(60),
    precio integer
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 65582)
-- Name: producto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_seq OWNER TO postgres;

--
-- TOC entry 2860 (class 0 OID 0)
-- Dependencies: 208
-- Name: producto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;


--
-- TOC entry 205 (class 1259 OID 65563)
-- Name: tipo_cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_cliente (
    id integer NOT NULL,
    nombre character varying(60),
    descripcion character varying(60)
);


ALTER TABLE public.tipo_cliente OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 65561)
-- Name: tipo_cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_cliente_id_seq OWNER TO postgres;

--
-- TOC entry 2861 (class 0 OID 0)
-- Dependencies: 204
-- Name: tipo_cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_cliente_id_seq OWNED BY public.tipo_cliente.id;


--
-- TOC entry 2707 (class 2604 OID 65579)
-- Name: categorias id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorias ALTER COLUMN id SET DEFAULT nextval('public.categorias_id_seq'::regclass);


--
-- TOC entry 2705 (class 2604 OID 65550)
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 65587)
-- Name: producto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto ALTER COLUMN id SET DEFAULT nextval('public.producto_id_seq'::regclass);


--
-- TOC entry 2706 (class 2604 OID 65566)
-- Name: tipo_cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cliente ALTER COLUMN id SET DEFAULT nextval('public.tipo_cliente_id_seq'::regclass);


--
-- TOC entry 2850 (class 0 OID 65576)
-- Dependencies: 207
-- Data for Name: categorias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categorias (id, denominacion, descripcion) FROM stdin;
7	dfr	asd
8	trrr	yui
\.


--
-- TOC entry 2846 (class 0 OID 65547)
-- Dependencies: 203
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, nombre, apellido, tipo_cliente_id, documento) FROM stdin;
3	Esteban	Dalbano	1	3159318
4	pedro	mazs	1	123
6	Cristian	Quevedo	1	12334411
7	Cristian2	Monaca	1	1234444
8	pepito	mengano	2	34555
9	erefe	fdfdf	2	23232
\.


--
-- TOC entry 2852 (class 0 OID 65584)
-- Dependencies: 209
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id, categoria, nombre, descripcion, precio) FROM stdin;
\.


--
-- TOC entry 2848 (class 0 OID 65563)
-- Dependencies: 205
-- Data for Name: tipo_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipo_cliente (id, nombre, descripcion) FROM stdin;
1	Asociado	del gremio camioneros
2	Proveedor	frutos secos
\.


--
-- TOC entry 2862 (class 0 OID 0)
-- Dependencies: 206
-- Name: categorias_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categorias_id_seq', 8, true);


--
-- TOC entry 2863 (class 0 OID 0)
-- Dependencies: 202
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 9, true);


--
-- TOC entry 2864 (class 0 OID 0)
-- Dependencies: 208
-- Name: producto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producto_id_seq', 1, false);


--
-- TOC entry 2865 (class 0 OID 0)
-- Dependencies: 204
-- Name: tipo_cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_cliente_id_seq', 2, true);


--
-- TOC entry 2714 (class 2606 OID 65581)
-- Name: categorias categorias_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categorias
    ADD CONSTRAINT categorias_pkey PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 65552)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 2716 (class 2606 OID 65589)
-- Name: producto producto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);


--
-- TOC entry 2712 (class 2606 OID 65568)
-- Name: tipo_cliente tipo_cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_cliente
    ADD CONSTRAINT tipo_cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 2718 (class 2606 OID 65590)
-- Name: producto fk_categoria; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk_categoria FOREIGN KEY (categoria) REFERENCES public.categorias(id);


--
-- TOC entry 2717 (class 2606 OID 65569)
-- Name: cliente fk_tipo_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_tipo_cliente FOREIGN KEY (tipo_cliente_id) REFERENCES public.tipo_cliente(id);


-- Completed on 2020-11-17 01:02:38

--
-- PostgreSQL database dump complete
--

