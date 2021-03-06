PGDMP         ;                y         	   VentasDAO    12.3    12.3 k    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    65536 	   VentasDAO    DATABASE     �   CREATE DATABASE "VentasDAO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
    DROP DATABASE "VentasDAO";
                postgres    false            �            1259    65576 
   categorias    TABLE     �   CREATE TABLE public.categorias (
    id integer NOT NULL,
    denominacion character varying(60),
    descripcion character varying(60)
);
    DROP TABLE public.categorias;
       public         heap    postgres    false            �            1259    65574    categorias_id_seq    SEQUENCE     �   CREATE SEQUENCE public.categorias_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.categorias_id_seq;
       public          postgres    false    207            �           0    0    categorias_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.categorias_id_seq OWNED BY public.categorias.id;
          public          postgres    false    206            �            1259    65547    cliente    TABLE     �   CREATE TABLE public.cliente (
    id integer NOT NULL,
    nombre character varying(60),
    apellido character varying(60),
    tipo_cliente_id integer,
    documento integer NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    65545    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    203            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    202            �            1259    65605    detalle_factura    TABLE     �   CREATE TABLE public.detalle_factura (
    id integer NOT NULL,
    cantidad integer NOT NULL,
    factura_id integer NOT NULL,
    codigo character varying(200),
    proveedor character varying(100)
);
 #   DROP TABLE public.detalle_factura;
       public         heap    postgres    false            �            1259    65603    detalle_factura_id_seq    SEQUENCE     �   CREATE SEQUENCE public.detalle_factura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.detalle_factura_id_seq;
       public          postgres    false    213            �           0    0    detalle_factura_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.detalle_factura_id_seq OWNED BY public.detalle_factura.id;
          public          postgres    false    212            �            1259    65597    factura    TABLE     a  CREATE TABLE public.factura (
    id integer NOT NULL,
    fecha_facturacion date DEFAULT CURRENT_DATE NOT NULL,
    numero_factura integer NOT NULL,
    monto_total double precision NOT NULL,
    observaciones character varying(400),
    cliente_id integer NOT NULL,
    forma_pago_id integer NOT NULL,
    expedidor character varying(100) NOT NULL
);
    DROP TABLE public.factura;
       public         heap    postgres    false            �            1259    65595    factura_id_seq    SEQUENCE     �   CREATE SEQUENCE public.factura_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.factura_id_seq;
       public          postgres    false    211            �           0    0    factura_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.factura_id_seq OWNED BY public.factura.id;
          public          postgres    false    210            �            1259    73787    factura_numero_factura_seq    SEQUENCE     �   CREATE SEQUENCE public.factura_numero_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.factura_numero_factura_seq;
       public          postgres    false    211            �           0    0    factura_numero_factura_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.factura_numero_factura_seq OWNED BY public.factura.numero_factura;
          public          postgres    false    216            �            1259    65618 
   forma_pago    TABLE     n   CREATE TABLE public.forma_pago (
    id integer NOT NULL,
    denominacion character varying(120) NOT NULL
);
    DROP TABLE public.forma_pago;
       public         heap    postgres    false            �            1259    65616    forma_pago_id_seq    SEQUENCE     �   CREATE SEQUENCE public.forma_pago_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.forma_pago_id_seq;
       public          postgres    false    215            �           0    0    forma_pago_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.forma_pago_id_seq OWNED BY public.forma_pago.id;
          public          postgres    false    214            �            1259    65584    producto    TABLE     
  CREATE TABLE public.producto (
    id integer NOT NULL,
    categoria_id integer NOT NULL,
    nombre character varying(60) NOT NULL,
    descripcion character varying(60),
    precio integer NOT NULL,
    fecha_creacion date NOT NULL,
    stock integer NOT NULL
);
    DROP TABLE public.producto;
       public         heap    postgres    false            �            1259    65582    producto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.producto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.producto_id_seq;
       public          postgres    false    209            �           0    0    producto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;
          public          postgres    false    208            �            1259    90480 
   productos1    TABLE     �  CREATE TABLE public.productos1 (
    id integer NOT NULL,
    codigo character varying(100) NOT NULL,
    descripcion character varying(100) NOT NULL,
    p_dolar double precision,
    p_costo double precision,
    p_venta double precision NOT NULL,
    origen character varying(100),
    proveedor character varying(100) NOT NULL,
    stock integer,
    categoria character varying(100),
    imagen character varying(200),
    fecha_ingreso date
);
    DROP TABLE public.productos1;
       public         heap    postgres    false            �            1259    90478    productos1_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productos1_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.productos1_id_seq;
       public          postgres    false    226            �           0    0    productos1_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.productos1_id_seq OWNED BY public.productos1.id;
          public          postgres    false    225            �            1259    98671 
   productos2    TABLE     �  CREATE TABLE public.productos2 (
    id integer NOT NULL,
    codigo character varying(100) NOT NULL,
    descripcion character varying(100) NOT NULL,
    p_dolar double precision,
    p_costo double precision,
    p_venta double precision NOT NULL,
    origen character varying(100),
    proveedor character varying(100) NOT NULL,
    stock integer,
    categoria character varying(100)
);
    DROP TABLE public.productos2;
       public         heap    postgres    false            �            1259    98669    productos2_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productos2_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.productos2_id_seq;
       public          postgres    false    228            �           0    0    productos2_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.productos2_id_seq OWNED BY public.productos2.id;
          public          postgres    false    227            �            1259    90232 
   productos3    TABLE     �  CREATE TABLE public.productos3 (
    id integer NOT NULL,
    codigo character varying(100) NOT NULL,
    descripcion character varying(100) NOT NULL,
    p_dolar double precision,
    p_costo double precision,
    p_venta double precision NOT NULL,
    origen character varying(100),
    proveedor character varying(100) NOT NULL,
    stock integer,
    categoria character varying(100)
);
    DROP TABLE public.productos3;
       public         heap    postgres    false            �            1259    90230    productos3_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productos3_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.productos3_id_seq;
       public          postgres    false    224            �           0    0    productos3_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.productos3_id_seq OWNED BY public.productos3.id;
          public          postgres    false    223            �            1259    82147    tabla1    TABLE     �   CREATE TABLE public.tabla1 (
    id integer NOT NULL,
    codigo character varying(100),
    proveedor character varying(100) NOT NULL
);
    DROP TABLE public.tabla1;
       public         heap    postgres    false            �            1259    82145    tabla1_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tabla1_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.tabla1_id_seq;
       public          postgres    false    222            �           0    0    tabla1_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.tabla1_id_seq OWNED BY public.tabla1.id;
          public          postgres    false    221            �            1259    82139    tabla2    TABLE     �   CREATE TABLE public.tabla2 (
    id integer NOT NULL,
    codigo character varying(100),
    proveedor character varying(100) NOT NULL
);
    DROP TABLE public.tabla2;
       public         heap    postgres    false            �            1259    82137    tabla2_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tabla2_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.tabla2_id_seq;
       public          postgres    false    220            �           0    0    tabla2_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.tabla2_id_seq OWNED BY public.tabla2.id;
          public          postgres    false    219            �            1259    65563    tipo_cliente    TABLE     �   CREATE TABLE public.tipo_cliente (
    id integer NOT NULL,
    nombre character varying(60),
    descripcion character varying(60)
);
     DROP TABLE public.tipo_cliente;
       public         heap    postgres    false            �            1259    65561    tipo_cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.tipo_cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.tipo_cliente_id_seq;
       public          postgres    false    205            �           0    0    tipo_cliente_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tipo_cliente_id_seq OWNED BY public.tipo_cliente.id;
          public          postgres    false    204            �            1259    73831    usuario    TABLE        CREATE TABLE public.usuario (
    id integer NOT NULL,
    nombre character varying(200) NOT NULL,
    clave character varying(200) NOT NULL,
    tipo character varying(100) NOT NULL,
    estado character varying(100),
    pc_mac character varying(200)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    73829    usuario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.usuario_id_seq;
       public          postgres    false    218            �           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    217            �
           2604    65579    categorias id    DEFAULT     n   ALTER TABLE ONLY public.categorias ALTER COLUMN id SET DEFAULT nextval('public.categorias_id_seq'::regclass);
 <   ALTER TABLE public.categorias ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            �
           2604    65550 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            �
           2604    65608    detalle_factura id    DEFAULT     x   ALTER TABLE ONLY public.detalle_factura ALTER COLUMN id SET DEFAULT nextval('public.detalle_factura_id_seq'::regclass);
 A   ALTER TABLE public.detalle_factura ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            �
           2604    65600 
   factura id    DEFAULT     h   ALTER TABLE ONLY public.factura ALTER COLUMN id SET DEFAULT nextval('public.factura_id_seq'::regclass);
 9   ALTER TABLE public.factura ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            �
           2604    73789    factura numero_factura    DEFAULT     �   ALTER TABLE ONLY public.factura ALTER COLUMN numero_factura SET DEFAULT nextval('public.factura_numero_factura_seq'::regclass);
 E   ALTER TABLE public.factura ALTER COLUMN numero_factura DROP DEFAULT;
       public          postgres    false    216    211            �
           2604    65621    forma_pago id    DEFAULT     n   ALTER TABLE ONLY public.forma_pago ALTER COLUMN id SET DEFAULT nextval('public.forma_pago_id_seq'::regclass);
 <   ALTER TABLE public.forma_pago ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �
           2604    65587    producto id    DEFAULT     j   ALTER TABLE ONLY public.producto ALTER COLUMN id SET DEFAULT nextval('public.producto_id_seq'::regclass);
 :   ALTER TABLE public.producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    90483    productos1 id    DEFAULT     n   ALTER TABLE ONLY public.productos1 ALTER COLUMN id SET DEFAULT nextval('public.productos1_id_seq'::regclass);
 <   ALTER TABLE public.productos1 ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    225    226            �
           2604    98674    productos2 id    DEFAULT     n   ALTER TABLE ONLY public.productos2 ALTER COLUMN id SET DEFAULT nextval('public.productos2_id_seq'::regclass);
 <   ALTER TABLE public.productos2 ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    227    228    228            �
           2604    90235    productos3 id    DEFAULT     n   ALTER TABLE ONLY public.productos3 ALTER COLUMN id SET DEFAULT nextval('public.productos3_id_seq'::regclass);
 <   ALTER TABLE public.productos3 ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            �
           2604    82150 	   tabla1 id    DEFAULT     f   ALTER TABLE ONLY public.tabla1 ALTER COLUMN id SET DEFAULT nextval('public.tabla1_id_seq'::regclass);
 8   ALTER TABLE public.tabla1 ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221    222            �
           2604    82142 	   tabla2 id    DEFAULT     f   ALTER TABLE ONLY public.tabla2 ALTER COLUMN id SET DEFAULT nextval('public.tabla2_id_seq'::regclass);
 8   ALTER TABLE public.tabla2 ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            �
           2604    65566    tipo_cliente id    DEFAULT     r   ALTER TABLE ONLY public.tipo_cliente ALTER COLUMN id SET DEFAULT nextval('public.tipo_cliente_id_seq'::regclass);
 >   ALTER TABLE public.tipo_cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    73834 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            �          0    65576 
   categorias 
   TABLE DATA           C   COPY public.categorias (id, denominacion, descripcion) FROM stdin;
    public          postgres    false    207   'z       �          0    65547    cliente 
   TABLE DATA           S   COPY public.cliente (id, nombre, apellido, tipo_cliente_id, documento) FROM stdin;
    public          postgres    false    203   
{       �          0    65605    detalle_factura 
   TABLE DATA           V   COPY public.detalle_factura (id, cantidad, factura_id, codigo, proveedor) FROM stdin;
    public          postgres    false    213   �{       �          0    65597    factura 
   TABLE DATA           �   COPY public.factura (id, fecha_facturacion, numero_factura, monto_total, observaciones, cliente_id, forma_pago_id, expedidor) FROM stdin;
    public          postgres    false    211   �{       �          0    65618 
   forma_pago 
   TABLE DATA           6   COPY public.forma_pago (id, denominacion) FROM stdin;
    public          postgres    false    215   |       �          0    65584    producto 
   TABLE DATA           h   COPY public.producto (id, categoria_id, nombre, descripcion, precio, fecha_creacion, stock) FROM stdin;
    public          postgres    false    209   E|       �          0    90480 
   productos1 
   TABLE DATA           �   COPY public.productos1 (id, codigo, descripcion, p_dolar, p_costo, p_venta, origen, proveedor, stock, categoria, imagen, fecha_ingreso) FROM stdin;
    public          postgres    false    226   �~       �          0    98671 
   productos2 
   TABLE DATA           }   COPY public.productos2 (id, codigo, descripcion, p_dolar, p_costo, p_venta, origen, proveedor, stock, categoria) FROM stdin;
    public          postgres    false    228   Ǆ       �          0    90232 
   productos3 
   TABLE DATA           }   COPY public.productos3 (id, codigo, descripcion, p_dolar, p_costo, p_venta, origen, proveedor, stock, categoria) FROM stdin;
    public          postgres    false    224   ��       �          0    82147    tabla1 
   TABLE DATA           7   COPY public.tabla1 (id, codigo, proveedor) FROM stdin;
    public          postgres    false    222   ��       �          0    82139    tabla2 
   TABLE DATA           7   COPY public.tabla2 (id, codigo, proveedor) FROM stdin;
    public          postgres    false    220   �       �          0    65563    tipo_cliente 
   TABLE DATA           ?   COPY public.tipo_cliente (id, nombre, descripcion) FROM stdin;
    public          postgres    false    205   5�       �          0    73831    usuario 
   TABLE DATA           J   COPY public.usuario (id, nombre, clave, tipo, estado, pc_mac) FROM stdin;
    public          postgres    false    218   ��       �           0    0    categorias_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.categorias_id_seq', 21, true);
          public          postgres    false    206            �           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 22, true);
          public          postgres    false    202            �           0    0    detalle_factura_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.detalle_factura_id_seq', 489, true);
          public          postgres    false    212            �           0    0    factura_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.factura_id_seq', 100, true);
          public          postgres    false    210            �           0    0    factura_numero_factura_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.factura_numero_factura_seq', 100, true);
          public          postgres    false    216            �           0    0    forma_pago_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.forma_pago_id_seq', 3, true);
          public          postgres    false    214            �           0    0    producto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.producto_id_seq', 31, true);
          public          postgres    false    208            �           0    0    productos1_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.productos1_id_seq', 1119, true);
          public          postgres    false    225            �           0    0    productos2_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.productos2_id_seq', 1, false);
          public          postgres    false    227            �           0    0    productos3_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.productos3_id_seq', 1, false);
          public          postgres    false    223            �           0    0    tabla1_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tabla1_id_seq', 1, false);
          public          postgres    false    221            �           0    0    tabla2_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.tabla2_id_seq', 1, false);
          public          postgres    false    219            �           0    0    tipo_cliente_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tipo_cliente_id_seq', 8, true);
          public          postgres    false    204            �           0    0    usuario_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.usuario_id_seq', 12, true);
          public          postgres    false    217            �
           2606    65581    categorias categorias_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.categorias
    ADD CONSTRAINT categorias_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.categorias DROP CONSTRAINT categorias_pkey;
       public            postgres    false    207            �
           2606    65552    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    203            �
           2606    65610 $   detalle_factura detalle_factura_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.detalle_factura
    ADD CONSTRAINT detalle_factura_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.detalle_factura DROP CONSTRAINT detalle_factura_pkey;
       public            postgres    false    213            �
           2606    65602    factura factura_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT factura_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.factura DROP CONSTRAINT factura_pkey;
       public            postgres    false    211            �
           2606    65623    forma_pago forma_pago_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.forma_pago
    ADD CONSTRAINT forma_pago_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.forma_pago DROP CONSTRAINT forma_pago_pkey;
       public            postgres    false    215            �
           2606    65589    producto producto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public            postgres    false    209            �
           2606    90490 *   productos1 productos1_codigo_proveedor_key 
   CONSTRAINT     r   ALTER TABLE ONLY public.productos1
    ADD CONSTRAINT productos1_codigo_proveedor_key UNIQUE (codigo, proveedor);
 T   ALTER TABLE ONLY public.productos1 DROP CONSTRAINT productos1_codigo_proveedor_key;
       public            postgres    false    226    226            �
           2606    90488    productos1 productos1_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.productos1
    ADD CONSTRAINT productos1_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.productos1 DROP CONSTRAINT productos1_pkey;
       public            postgres    false    226            �
           2606    98679    productos2 productos2_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.productos2
    ADD CONSTRAINT productos2_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.productos2 DROP CONSTRAINT productos2_pkey;
       public            postgres    false    228            �
           2606    90240    productos3 productos3_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.productos3
    ADD CONSTRAINT productos3_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.productos3 DROP CONSTRAINT productos3_pkey;
       public            postgres    false    224            �
           2606    90266 "   tabla1 tabla1_codigo_proveedor_key 
   CONSTRAINT     j   ALTER TABLE ONLY public.tabla1
    ADD CONSTRAINT tabla1_codigo_proveedor_key UNIQUE (codigo, proveedor);
 L   ALTER TABLE ONLY public.tabla1 DROP CONSTRAINT tabla1_codigo_proveedor_key;
       public            postgres    false    222    222            �
           2606    82152    tabla1 tabla1_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.tabla1
    ADD CONSTRAINT tabla1_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.tabla1 DROP CONSTRAINT tabla1_pkey;
       public            postgres    false    222            �
           2606    82144    tabla2 tabla2_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.tabla2
    ADD CONSTRAINT tabla2_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.tabla2 DROP CONSTRAINT tabla2_pkey;
       public            postgres    false    220            �
           2606    65568    tipo_cliente tipo_cliente_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tipo_cliente
    ADD CONSTRAINT tipo_cliente_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tipo_cliente DROP CONSTRAINT tipo_cliente_pkey;
       public            postgres    false    205            �
           2606    73839    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    218            �
           1259    90267    tabla2_codigo_proveedor_idx    INDEX     b   CREATE UNIQUE INDEX tabla2_codigo_proveedor_idx ON public.tabla2 USING btree (codigo, proveedor);
 /   DROP INDEX public.tabla2_codigo_proveedor_idx;
       public            postgres    false    220    220                        2606    65611    detalle_factura fk1    FK CONSTRAINT     w   ALTER TABLE ONLY public.detalle_factura
    ADD CONSTRAINT fk1 FOREIGN KEY (factura_id) REFERENCES public.factura(id);
 =   ALTER TABLE ONLY public.detalle_factura DROP CONSTRAINT fk1;
       public          postgres    false    211    213    2790            �
           2606    73799    factura fk1    FK CONSTRAINT     o   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk1 FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);
 5   ALTER TABLE ONLY public.factura DROP CONSTRAINT fk1;
       public          postgres    false    203    211    2782            �
           2606    73804    factura fk2    FK CONSTRAINT     u   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk2 FOREIGN KEY (forma_pago_id) REFERENCES public.forma_pago(id);
 5   ALTER TABLE ONLY public.factura DROP CONSTRAINT fk2;
       public          postgres    false    211    215    2794            �
           2606    65590    producto fk_categoria    FK CONSTRAINT     ~   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES public.categorias(id);
 ?   ALTER TABLE ONLY public.producto DROP CONSTRAINT fk_categoria;
       public          postgres    false    209    2786    207            �
           2606    65569    cliente fk_tipo_cliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_tipo_cliente FOREIGN KEY (tipo_cliente_id) REFERENCES public.tipo_cliente(id);
 A   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_tipo_cliente;
       public          postgres    false    203    2784    205            �   �   x�E��JCA���S���[���Z-]��qf���\�G�퍋�"���/���YUk��Mڊ��Ŋ�.����䔨�,��#�ٍ+�&	�Z�,�k�F��Op�(V�[���eE�\���"��.�^��N᪌;؏�Qh3M�Ĵu��g4�����u��'���3wp�W�
���������*�3$�����e��_���U]8      �   �   x�-�M�1�ׯ3t������"��gSڵĎ$o���ig��+���Q�<ɉG�8ԈP0�vF9R�����!p�����t猵�a#�$�ؗ���iMki������X�&��G��M�����)��g���r�J[����*؄�$�^���r
s�VFI�А��r�!]���?��g�����؆=�      �      x������ � �      �      x������ � �      �   '   x�3�t��+IL��2�t.JM�,��2�tIM1b���� ��	a      �   �  x��T[n�0�^��p@R��9M⢅#I�~�g-16�tE�Mz����RyX

�lHvfv�J@ˡ7��b�=�r�6.h[��9�Y�ѣ{J�)��j!r�R&����&������v~�;�?���� �B� �`R���-���Y8ou���J���?���TE�\�G�u���,���
;�s������2�R���)W������Ȣ�*a*�٠���5}힟�Z[��j�o�3"\����\�oj��O�H���b*�n�C���mo�6��dM��lڦ�XA7-�c��i�[]܇[X�/�-��Q��U�T1�Ӻn�������b5)^�葪?�&6=�Lf�Ɯ�s�"��#>%��F��]��H���I �&�*�h�s�j��ѩdN,gd�0����z�'�r
+H9����V;8%��d!�1j�4j1c�45Q��1���MO_��øl���[���r�Ơu���{C�����
"��DF��;��������6<I��G	�$�;����Y1)��D��7/�ͫ�`U2[�2e�6��O4�S6��+m�$�>�N>e[U�ҥn:ã�<{��� 4��������v��5���x�O�J'��U�`hq(0�[>Μ�7f|ך��̶��#��|^���N�7���0�f_Oc #\m      �   �  x���[v�H��;��Gx@�����"���er9l��̚fc�W[;�K� >�W�U��ߒ�E洐�������xY�C��z�-�]��M�w|U7U��f�6L^2�]��p��~�'�6��{�v5�_ZV����o��+�����^0'�Q��C_?~�-3[\dw�C]&~_5i 웤U�eF�L,�R�b֩x�M�|�]{�x��C=��K+�.�fʆ�0mB+��4>��p3t��Ke�apL)p����F\�=�3�A>���p,��I�h�ݺj�}��z�ld�ybE[�%,Ǵ��O��'^�|QR����uz@�t�����3%q�Q��~J�,&��:�Q~US��hE3�h��r-0��5���˷��R�m)�-U4Ԗ�(	��L�Fr�}�~�yz���i��h)�v,`ٿ<]����Bjf�@�֚B,�=�I��ն���S(�Xa�;}U>t�8Y����S�.���I^�_���U�a���g�I��T�&�n���X�6W=��ǵ2Unt����ό#e\u9e3zH�cX��,�cߔ�c̐S=���?�i�-p>M;�>H� kbəxG�d�<Eȓq�H���+�i�괆�`JIm
�Z��"���H�Ɠ�����=������v+��}z!I��D��faJ�cw���Ŧe����)�w�ƭ�������E21z6V��g�H��c�?��d�$���l2.��m�����pٯѶ��]�n���V�����6�w=u�x���A�O��I�F9"Fe71G�y ��A�������|U�=]Ir��l!4�2,�{У8���}D�i�w�+�m[���7�t�+O�������Y[�t�[[X� �gϏ�$��9�Y��X�����mjv�����t��q�����C�AU�?Z���L2cN*a�0�����*o�,�c�c$&�&��"�h� ���r���X�*�|���-c>NQ�+���5�<��]m�����*�F�#�."���	~>�'��c�F��h4)�rr�%���KϽB�����E�H���Y�0��l>�	7���=��ܾ �/|S���V�&�5���8��+�B`��(4)V���"���J�n̋�����?
�$(�=֛��#�����J9�x�y^�S:	gJ�h��4�Aes$�k�]'0�fzP�p^�v�2j���uޮ�89�.�"3�#����5�U�$�?iΙ.�Fi����;��*�d�p��vz�i�5oK��onL�#�>���n.�d.�:�Mj+)��C���L�.��4��o�ޥVu�x���F���Vˬr�K�A7zdʰ�"�q�o�t�_]$��)^�b��ԩ�=��	6���FД�ۜ��՜�Il�h�9��,��`���PdAߨ�E��9�8I}�H����]���»�$�Ep�%<��WL��<b�ēQ����_������`�      �   �  x���Mr�8���)�L��";�b$N(�CQ���+�0s��ؼ����i'UI%�����u��9-�g�誺*Z^�M�Śǎ�][s�kSv-_Vu�E�Y�͊��K&��r&s����n�oVMd폪i+&-�M�U��[��A1'�Q�=�]��Y�NH�.�}�"�EYǞh)�L�Dʙ2!33y�Y��	w�V�⫶YD^,y_����
�3���yf�6y�V�&0�J8���m��RY�;��gZ��|�5b����d�[�)f|Ȭ�>�3+�4w�_�}�.k��?b�L;O�`3?�\5�v�п���QI�j��q-�tYO��噒�� 3��X���*�'�4�Q6e]�� 1� �6�gF�)���j�~�RJ
��0)lK".7*�-��6���G��n�}"3x��R�����K�6�)_�ͤfF
$e��Č�����e�����o8�8DW�$�I�Rz�,K��E�}Z���Ve��4�&�ӳ�d���K�ڏ1�8S��n�������p\��8��y�<�h��N�}R�4�|�b)�R�U���?�LI2�ۮ8���*�~K��;���v�`'ƹ3;��{��9���u�p>zTJ�Le�\�L�ڟ��pC���Z�'y����������v�Ⱥ<�Kc�X�}��3Z���2q�ދ�0+��dG��*j-�L�Z3�p�gCenW���y��Wp��XA��rI�?}�.a�y�M�sKeN�Dp��+���@��m�W�m\��a���7��cB�!t�4�)(�������r,71�"��]ɟ�2�G��4���idk�U>��� n�G��������~�4U�<0y��[��G�V���Ű�Z�t�[�26�n:
�����ԯ�8��~0K)� VZ�ҮG���J��3��u5��PA{j����2�EO2J�	��XXV��-!���%��A��Fc����~��g�VQ�6q!���C���]ݥ�m^:RMS.iMGrh?���: �bs�����x���̮�k@��D��є�����Fv��8�����NC��K�G"1�~XM���B9|�wI� �G��ޕ�m�
�y3~�Zte.2��)w~�#i��x�	����p����C`ޤ��W��Wr*�G��h�}��[�
�x+�(�P�^�JK�į�=�<#E1.�!����o�4�NS�'G�\�$>�j����)�:�nw�M�O#4JS?;�=�z�Bk�B.P��l���˦�[���^B�􌈵̼�₡S	�d�Q�,8�����?����ႂ�'��tܥ�,��;\] ��!I�j�\�>���΀�-= ��������\�Ȉ����)MGR�qB@Ar�c�ܵ6��~�Sj~8�-U��F��%F.h�b`���T�A+݅��۾�a!%Fi� 5܁'8r�g��'X�ȍ���h���$�HW��}�������:%      �      x������ � �      �   .   x�3�400�,N�-.�K�2��<c ��3���3�b���� �E8      �   ?   x�3�400�,�ϫ�22�8+2�s3���c����b. ӄ�81��4/���ʋ���� D�      �   v   x�}�1
A ��y���hk�v��5{�(��9�=���f���#\�YKu�b�����&���_���ػ'��'xJn޲�&�hɡ[w���Z����	/0�);�d̊�J���259      �   �   x���K�0�s�)z�V���q8�����K]�,�F�n�ooEO"^��H�0q��"�%��2r���%K�ƒ.hA��6�y+YP�r2��0�|$����].&\t�X@Rb�͟�r�Yi��r}�UR��ͳ��o�����*�)y*�<�C�\��&�>t�R5���Xb���c���G}�-�oGQt�A�     