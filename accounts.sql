--
-- PostgreSQL database dump
--

-- Dumped from database version 10.19
-- Dumped by pg_dump version 12.6

-- Started on 2022-09-06 07:23:18 +07

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

--
-- TOC entry 197 (class 1259 OID 16441)
-- Name: accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.accounts (
    user_name character varying(50) NOT NULL,
    active boolean NOT NULL,
    encryted_password character varying(128) NOT NULL,
    user_role character varying(20) NOT NULL
);


ALTER TABLE public.accounts OWNER TO postgres;

--
-- TOC entry 3139 (class 0 OID 16441)
-- Dependencies: 197
-- Data for Name: accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.accounts (user_name, active, encryted_password, user_role) FROM stdin;
employee1@thienloc.com	t	$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu	ROLE_EMPLOYEE
manager1@thienloc.com	t	$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu	ROLE_MANAGER
\.


--
-- TOC entry 3017 (class 2606 OID 16516)
-- Name: accounts accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.accounts
    ADD CONSTRAINT accounts_pkey PRIMARY KEY (user_name);


-- Completed on 2022-09-06 07:23:18 +07

--
-- PostgreSQL database dump complete
--

