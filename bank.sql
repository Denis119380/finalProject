PGDMP     (    /                |            bank    15.3    15.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    25487    bank    DATABASE        CREATE DATABASE bank WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1251';
    DROP DATABASE bank;
                postgres    false            �            1259    25488    bank    TABLE     Q   CREATE TABLE public.bank (
    id integer NOT NULL,
    balance numeric(10,2)
);
    DROP TABLE public.bank;
       public         heap    postgres    false            �          0    25488    bank 
   TABLE DATA           +   COPY public.bank (id, balance) FROM stdin;
    public          postgres    false    214   �       e           2606    25492    bank bank_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.bank
    ADD CONSTRAINT bank_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.bank DROP CONSTRAINT bank_pkey;
       public            postgres    false    214            �   &   x�34�4400�34�2�42 1�L9M��=... x�      