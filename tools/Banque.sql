--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2020-07-07 00:16:42

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
-- TOC entry 203 (class 1259 OID 24595)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.client (
    _id integer NOT NULL,
    code character varying(128) NOT NULL,
    nom character varying(32) NOT NULL,
    postnom character varying(32) NOT NULL,
    prenom character varying(32) NOT NULL,
    datenaisance date NOT NULL
);


ALTER TABLE public.client OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 24598)
-- Name: compte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compte (
    _id integer NOT NULL,
    numref character varying(128) NOT NULL,
    codeclient character varying(128) NOT NULL,
    type character varying(32) NOT NULL,
    datecreation timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    solde double precision NOT NULL
);


ALTER TABLE public.compte OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 24585)
-- Name: compte_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compte_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compte_seq OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24602)
-- Name: transaction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transaction (
    _id integer NOT NULL,
    reforigine character varying(128) NOT NULL,
    refdestination character varying(128),
    montant double precision NOT NULL,
    datetransaction timestamp(0) without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    type character varying(32) NOT NULL
);


ALTER TABLE public.transaction OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 32779)
-- Name: transaction__id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.transaction ALTER COLUMN _id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.transaction__id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 2700 (class 2606 OID 24609)
-- Name: client client_code_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_code_key UNIQUE (code);


--
-- TOC entry 2702 (class 2606 OID 24607)
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (_id);


--
-- TOC entry 2704 (class 2606 OID 24613)
-- Name: compte compte_numref_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compte
    ADD CONSTRAINT compte_numref_key UNIQUE (numref);


--
-- TOC entry 2706 (class 2606 OID 24611)
-- Name: compte compte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compte
    ADD CONSTRAINT compte_pkey PRIMARY KEY (_id);


--
-- TOC entry 2708 (class 2606 OID 24615)
-- Name: transaction transaction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (_id);


-- Completed on 2020-07-07 00:16:43

--
-- PostgreSQL database dump complete
--


INSERT INTO public.client (_id, code, nom, postnom, prenom, dateNaisance) VALUES
(1, 'CL1', 'TAMBWE', 'NYZ', 'GAD', '1995-07-14'),
(2, 'CL2', 'MALULU', 'NDETURUYE', 'YVES', '1994-07-28');

INSERT INTO public.compte (_id, numRef, codeClient, type, dateCreation, solde) VALUES
(1, 'CT1', 'CL1', 'compte chèque', '2020-07-05 23:48:02', 5000),
(2, 'CT2', 'CL1', 'compte a terme', '2020-07-05 23:50:02', 6000),
(3, 'CT3', 'CL2', 'compte indivis', '2020-07-05 23:50:45', 9000),
(4, 'CT4', 'CL1', 'compte indivis', '2020-07-05 23:50:45', 0),
(5, 'CT5', 'CL2', 'compte epargne', '2020-07-05 23:51:45', 50000),
(6, 'CT6', 'CL1', 'compte epargne', '2020-07-22 00:00:00', 950000);
