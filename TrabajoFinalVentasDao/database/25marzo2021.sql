PGDMP                         y         	   VentasDAO    12.3    12.3 M    i           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            j           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            k           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            l           1262    65536 	   VentasDAO    DATABASE     �   CREATE DATABASE "VentasDAO" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Argentina.1252' LC_CTYPE = 'Spanish_Argentina.1252';
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
       public          postgres    false    207            m           0    0    categorias_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.categorias_id_seq OWNED BY public.categorias.id;
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
       public          postgres    false    203            n           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    202            �            1259    65605    detalle_factura    TABLE     �   CREATE TABLE public.detalle_factura (
    id integer NOT NULL,
    cantidad integer NOT NULL,
    factura_id integer NOT NULL,
    producto_id integer NOT NULL
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
       public          postgres    false    213            o           0    0    detalle_factura_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.detalle_factura_id_seq OWNED BY public.detalle_factura.id;
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
       public          postgres    false    211            p           0    0    factura_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.factura_id_seq OWNED BY public.factura.id;
          public          postgres    false    210            �            1259    73787    factura_numero_factura_seq    SEQUENCE     �   CREATE SEQUENCE public.factura_numero_factura_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.factura_numero_factura_seq;
       public          postgres    false    211            q           0    0    factura_numero_factura_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.factura_numero_factura_seq OWNED BY public.factura.numero_factura;
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
       public          postgres    false    215            r           0    0    forma_pago_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.forma_pago_id_seq OWNED BY public.forma_pago.id;
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
       public          postgres    false    209            s           0    0    producto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;
          public          postgres    false    208            �            1259    82015    productosfar    TABLE       CREATE TABLE public.productosfar (
    id integer NOT NULL,
    codigo character varying(50),
    descripcion character varying(100) NOT NULL,
    precio double precision NOT NULL,
    proveedor character varying(100) NOT NULL,
    origen character varying(50) NOT NULL
);
     DROP TABLE public.productosfar;
       public         heap    postgres    false            �            1259    82013    productosfar_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productosfar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.productosfar_id_seq;
       public          postgres    false    220            t           0    0    productosfar_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.productosfar_id_seq OWNED BY public.productosfar.id;
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
       public          postgres    false    205            u           0    0    tipo_cliente_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.tipo_cliente_id_seq OWNED BY public.tipo_cliente.id;
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
       public          postgres    false    218            v           0    0    usuario_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;
          public          postgres    false    217            �
           2604    65579    categorias id    DEFAULT     n   ALTER TABLE ONLY public.categorias ALTER COLUMN id SET DEFAULT nextval('public.categorias_id_seq'::regclass);
 <   ALTER TABLE public.categorias ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            �
           2604    65550 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    65608    detalle_factura id    DEFAULT     x   ALTER TABLE ONLY public.detalle_factura ALTER COLUMN id SET DEFAULT nextval('public.detalle_factura_id_seq'::regclass);
 A   ALTER TABLE public.detalle_factura ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            �
           2604    65600 
   factura id    DEFAULT     h   ALTER TABLE ONLY public.factura ALTER COLUMN id SET DEFAULT nextval('public.factura_id_seq'::regclass);
 9   ALTER TABLE public.factura ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �
           2604    73789    factura numero_factura    DEFAULT     �   ALTER TABLE ONLY public.factura ALTER COLUMN numero_factura SET DEFAULT nextval('public.factura_numero_factura_seq'::regclass);
 E   ALTER TABLE public.factura ALTER COLUMN numero_factura DROP DEFAULT;
       public          postgres    false    216    211            �
           2604    65621    forma_pago id    DEFAULT     n   ALTER TABLE ONLY public.forma_pago ALTER COLUMN id SET DEFAULT nextval('public.forma_pago_id_seq'::regclass);
 <   ALTER TABLE public.forma_pago ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    214    215            �
           2604    65587    producto id    DEFAULT     j   ALTER TABLE ONLY public.producto ALTER COLUMN id SET DEFAULT nextval('public.producto_id_seq'::regclass);
 :   ALTER TABLE public.producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            �
           2604    82018    productosfar id    DEFAULT     r   ALTER TABLE ONLY public.productosfar ALTER COLUMN id SET DEFAULT nextval('public.productosfar_id_seq'::regclass);
 >   ALTER TABLE public.productosfar ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    219    220    220            �
           2604    65566    tipo_cliente id    DEFAULT     r   ALTER TABLE ONLY public.tipo_cliente ALTER COLUMN id SET DEFAULT nextval('public.tipo_cliente_id_seq'::regclass);
 >   ALTER TABLE public.tipo_cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            �
           2604    73834 
   usuario id    DEFAULT     h   ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);
 9   ALTER TABLE public.usuario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    218    218            Y          0    65576 
   categorias 
   TABLE DATA           C   COPY public.categorias (id, denominacion, descripcion) FROM stdin;
    public          postgres    false    207   �V       U          0    65547    cliente 
   TABLE DATA           S   COPY public.cliente (id, nombre, apellido, tipo_cliente_id, documento) FROM stdin;
    public          postgres    false    203   �W       _          0    65605    detalle_factura 
   TABLE DATA           P   COPY public.detalle_factura (id, cantidad, factura_id, producto_id) FROM stdin;
    public          postgres    false    213   tX       ]          0    65597    factura 
   TABLE DATA           �   COPY public.factura (id, fecha_facturacion, numero_factura, monto_total, observaciones, cliente_id, forma_pago_id, expedidor) FROM stdin;
    public          postgres    false    211   �Y       a          0    65618 
   forma_pago 
   TABLE DATA           6   COPY public.forma_pago (id, denominacion) FROM stdin;
    public          postgres    false    215   E[       [          0    65584    producto 
   TABLE DATA           h   COPY public.producto (id, categoria_id, nombre, descripcion, precio, fecha_creacion, stock) FROM stdin;
    public          postgres    false    209   |[       f          0    82015    productosfar 
   TABLE DATA           Z   COPY public.productosfar (id, codigo, descripcion, precio, proveedor, origen) FROM stdin;
    public          postgres    false    220   2^       W          0    65563    tipo_cliente 
   TABLE DATA           ?   COPY public.tipo_cliente (id, nombre, descripcion) FROM stdin;
    public          postgres    false    205   �c       d          0    73831    usuario 
   TABLE DATA           J   COPY public.usuario (id, nombre, clave, tipo, estado, pc_mac) FROM stdin;
    public          postgres    false    218   d       w           0    0    categorias_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.categorias_id_seq', 21, true);
          public          postgres    false    206            x           0    0    cliente_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.cliente_id_seq', 22, true);
          public          postgres    false    202            y           0    0    detalle_factura_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.detalle_factura_id_seq', 202, true);
          public          postgres    false    212            z           0    0    factura_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.factura_id_seq', 51, true);
          public          postgres    false    210            {           0    0    factura_numero_factura_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.factura_numero_factura_seq', 51, true);
          public          postgres    false    216            |           0    0    forma_pago_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.forma_pago_id_seq', 3, true);
          public          postgres    false    214            }           0    0    producto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.producto_id_seq', 31, true);
          public          postgres    false    208            ~           0    0    productosfar_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.productosfar_id_seq', 1, false);
          public          postgres    false    219                       0    0    tipo_cliente_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tipo_cliente_id_seq', 8, true);
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
           2606    82020    productosfar productosfar_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.productosfar
    ADD CONSTRAINT productosfar_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.productosfar DROP CONSTRAINT productosfar_pkey;
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
           2606    65611    detalle_factura fk1    FK CONSTRAINT     w   ALTER TABLE ONLY public.detalle_factura
    ADD CONSTRAINT fk1 FOREIGN KEY (factura_id) REFERENCES public.factura(id);
 =   ALTER TABLE ONLY public.detalle_factura DROP CONSTRAINT fk1;
       public          postgres    false    213    211    2759            �
           2606    73799    factura fk1    FK CONSTRAINT     o   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk1 FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);
 5   ALTER TABLE ONLY public.factura DROP CONSTRAINT fk1;
       public          postgres    false    2751    211    203            �
           2606    73804    factura fk2    FK CONSTRAINT     u   ALTER TABLE ONLY public.factura
    ADD CONSTRAINT fk2 FOREIGN KEY (forma_pago_id) REFERENCES public.forma_pago(id);
 5   ALTER TABLE ONLY public.factura DROP CONSTRAINT fk2;
       public          postgres    false    215    211    2763            �
           2606    73810    detalle_factura fk2    FK CONSTRAINT     y   ALTER TABLE ONLY public.detalle_factura
    ADD CONSTRAINT fk2 FOREIGN KEY (producto_id) REFERENCES public.producto(id);
 =   ALTER TABLE ONLY public.detalle_factura DROP CONSTRAINT fk2;
       public          postgres    false    2757    213    209            �
           2606    65590    producto fk_categoria    FK CONSTRAINT     ~   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES public.categorias(id);
 ?   ALTER TABLE ONLY public.producto DROP CONSTRAINT fk_categoria;
       public          postgres    false    2755    209    207            �
           2606    65569    cliente fk_tipo_cliente    FK CONSTRAINT     �   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT fk_tipo_cliente FOREIGN KEY (tipo_cliente_id) REFERENCES public.tipo_cliente(id);
 A   ALTER TABLE ONLY public.cliente DROP CONSTRAINT fk_tipo_cliente;
       public          postgres    false    2753    203    205            Y   �   x�E��JCA���S���[���Z-]��qf���\�G�퍋�"���/���YUk��Mڊ��Ŋ�.����䔨�,��#�ٍ+�&	�Z�,�k�F��Op�(V�[���eE�\���"��.�^��N᪌;؏�Qh3M�Ĵu��g4�����u��'���3wp�W�
���������*�3$�����e��_���U]8      U   �   x�-�M�1�ׯ3t������"��gSڵĎ$o���ig��+���Q�<ɉG�8ԈP0�vF9R�����!p�����t猵�a#�$�ؗ���iMki������X�&��G��M�����)��g���r�J[����*؄�$�^���r
s�VFI�А��r�!]���?��g�����؆=�      _     x�E�ˍ 1CϤ�ՄO�l�u���4O�ǳ�$�J�������>b�� �x3��:��4���dk���UT0P�r�'�����*�>G6��\Վ�w$mY\#N|#7hb3r�c�è7و|.��1���1�D���������z�<�0wO?�{��0�{r���'F�4�%g��}5��쒳��z���f��Y~����77�������B_��`YL	V�2�����ufN̑�˺���/��~Qu����� 4�\2      ]   �  x�mR1n�0�y���Ul���;�4�k��H�fE�6�+S�!�}��$��Y.vfgX6�hS<��T	t�Z�8�[Gs��Mvv!	��g�2��Q���|��(�l�dܣp��I���
u��k9*��бѵ:���L��=���-wB߾H +ש�3���B5M���ce��dvMF�`V?.���e���ܵ��6p��-�[	)K������/X�-���|�@�ߓ�ɻ�#�.ƛ�:|����)��%�6�VI'T7�Vg���H�Ƭ�(q���Uit�OrO���:T�-4�^�sZ��䖘{w�8��p�Y��Tk���$�c���ĝv�N��M]m����/Fd�r�pq���6�z�[t<��<}̞�9Oä�[;g�Qv�O.^��������Ha��Ms�m�������ێ_����/ֻ�f      a   '   x�3�t��+IL��2�t.JM�,��2�tIM1b���� ��	a      [   �  x��T[n�0�^��p@R��9M⢅#I�~�g-16�tE�Mz����RyX

�lHvfv�J@ˡ7��b�=�r�6.h[��9�Y�ѣ{J�)��j!r�R&����&������v~�;�?���� �B� �`R���-���Y8ou���J���?���TE�\�G�u���,���
;�s������2�R���)W������Ȣ�*a*�٠���5}힟�Z[��j�o�3"\����\�oj��O�H���b*�n�C���mo�6��dM��lڦ�XA7-�c��i�[]܇[X�/�-��Q��U�T1�Ӻn�������b5)^�葪?�&6=�Lf�Ɯ�s�"��#>%��F��]��H���I �&�*�h�s�j��ѩdN,gd�0����z�'�r
+H9����V;8%��d!�1j�4j1c�45Q��1���MO_��øl���[���r�Ơu���{C�����
"��DF��;��������6<I��G	�$�;����Y1)��D��7/�ͫ�`U2[�2e�6��O4�S6��+m�$�>�N>e[U�ҥn:ã�<{��� 4��������v��5���x�O�J'��U�`hq(0�[>Μ�7f|ך��̶��#��|^���N�7���0�f_Oc #\m      f   T  x����r�8������ztF\�d�R�n�Լȼ�H	���T�U\)��[��AP4��I�k�V�K�����yl:̿I|:�S��=��H�b�5�Q��t�/�U�7��>/��1=�����SGq�X�
��Y�}�S0�D�~V_�(��JMx�P&qK;e3	�x���́�sh�:
�q���o#5��1*	$����{Z�$��A�ӰA�E��mZ`� �Ը��D It0�V������T��-
�FC�a_He ��A��]�T���<D	:s8��f��p8�7qH.lO��\z��R���)+��1���9��Uv��ST#>7��~����F�8`J�B�%������ݦ�	~d�,n�l�JQc�4�Y���U&s���F��&K�V��~�%x�O`'/,�%9�9z�<U�>�;��({>��G"nZ�>q�a3r��Ub��)jsx������s�����U�$�waW� RߤQ1�C��~#[	)P�&f{���%:��=	��l(���X���z(�^H0��@�����O�Y�*��ѭ�jO�71#�>������b|v��R��ɠ���J��*��y�nGiTu����a�DU3|/m�Ҵ7m���,�A�s���+'ߒ*����]l�t�9,�3���{�C� q������B��/s�U��%�����L{=	���R\���}<1W93�ӯ�K�6�������g�-f��ڇ>x��� �=s�0����u����� h�� *2͉g;�\]�R�����:ִBNّ��K׭"��~��oJ�:��$`
Jv��%�����b?̎�sQ;�D,s������C��8զx,l�<��w���b���<�F]u�ݛ]S��*��Y��ςFPF���2F�'Jc�4����9�^�?r��N�g �A;/$'�R��)�*r���'��	����?�Q��oO^�8ԞO/:�=�t�è|��P�/����'Ԓ�d���T�^n��f:ے:�4Y�˙M����꼿Z��@V��a�f����-U�LT9� hB�m������l���">q��f�sƖSq�-d)�+?��=HH���� +�tx��}����p��W��?|��<������$͟� �fO�����?��On>��#P���� S��Q��+4�AcV��qz�NO;�Zl�������<����oQ�j�dV_-A-�U�"��A-t�S�v����y�|��I��%>��>�cw��>��'S��$h�+�	�M���	�UИG I�@�IR�=�=mo����C7�	�T�R"�jo5���~�^^^���      W   v   x�}�1
A ��y���hk�v��5{�(��9�=���f���#\�YKu�b�����&���_���ػ'��'xJn޲�&�hɡ[w���Z����	/0�);�d̊�J���259      d   �   x���K�0�s�)z�V���q8�����K]�,�F�n�ooEO"^��H�0q��"�%��2r���%K�ƒ.hA��6�y+YP�r2��0�|$����].&\t�X@Rb�͟�r�Yi��r}�UR��ͳ��o�����*�)y*�<�C�\��&�>t�R5���Xb���c���G}�-�oGQt�A�     