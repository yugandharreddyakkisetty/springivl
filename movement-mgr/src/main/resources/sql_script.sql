

--
-- Name: cs; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cs;


ALTER SCHEMA cs OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: t_dailyplan; Type: TABLE; Schema: cs; Owner: postgres
--

CREATE TABLE cs.t_dailyplan (
    id bigint NOT NULL,
    material character varying NOT NULL,
    destination character varying NOT NULL,
    qty double precision
);


ALTER TABLE cs.t_dailyplan OWNER TO postgres;

--
-- Name: t_dailyplan_id_seq; Type: SEQUENCE; Schema: cs; Owner: postgres
--

CREATE SEQUENCE cs.t_dailyplan_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cs.t_dailyplan_id_seq OWNER TO postgres;

--
-- Name: t_dailyplan_id_seq; Type: SEQUENCE OWNED BY; Schema: cs; Owner: postgres
--

ALTER SEQUENCE cs.t_dailyplan_id_seq OWNED BY cs.t_dailyplan.id;


--
-- Name: t_tpm; Type: TABLE; Schema: cs; Owner: postgres
--

CREATE TABLE cs.t_tpm (
    id bigint NOT NULL,
    transporter_id bigint NOT NULL,
    vehicle_id bigint NOT NULL,
    dailyplan_id bigint NOT NULL,
    sub_qty double precision NOT NULL
);


ALTER TABLE cs.t_tpm OWNER TO postgres;

--
-- Name: t_tpm_id_seq; Type: SEQUENCE; Schema: cs; Owner: postgres
--

CREATE SEQUENCE cs.t_tpm_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cs.t_tpm_id_seq OWNER TO postgres;

--
-- Name: t_tpm_id_seq; Type: SEQUENCE OWNED BY; Schema: cs; Owner: postgres
--

ALTER SEQUENCE cs.t_tpm_id_seq OWNED BY cs.t_tpm.id;


--
-- Name: t_transporter; Type: TABLE; Schema: cs; Owner: postgres
--

CREATE TABLE cs.t_transporter (
    id bigint NOT NULL,
    code character varying NOT NULL,
    display_name character varying NOT NULL
);


ALTER TABLE cs.t_transporter OWNER TO postgres;

--
-- Name: t_transporter_id_seq; Type: SEQUENCE; Schema: cs; Owner: postgres
--

CREATE SEQUENCE cs.t_transporter_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cs.t_transporter_id_seq OWNER TO postgres;

--
-- Name: t_transporter_id_seq; Type: SEQUENCE OWNED BY; Schema: cs; Owner: postgres
--

ALTER SEQUENCE cs.t_transporter_id_seq OWNED BY cs.t_transporter.id;


--
-- Name: t_vehicle; Type: TABLE; Schema: cs; Owner: postgres
--

CREATE TABLE cs.t_vehicle (
    id bigint NOT NULL,
    vehicle_num character varying NOT NULL,
    display_name character varying NOT NULL,
    transporter_id bigint
);


ALTER TABLE cs.t_vehicle OWNER TO postgres;

--
-- Name: t_vehicle_id_seq; Type: SEQUENCE; Schema: cs; Owner: postgres
--

CREATE SEQUENCE cs.t_vehicle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE cs.t_vehicle_id_seq OWNER TO postgres;

--
-- Name: t_vehicle_id_seq; Type: SEQUENCE OWNED BY; Schema: cs; Owner: postgres
--

ALTER SEQUENCE cs.t_vehicle_id_seq OWNED BY cs.t_vehicle.id;


--
-- Name: t_dailyplan id; Type: DEFAULT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_dailyplan ALTER COLUMN id SET DEFAULT nextval('cs.t_dailyplan_id_seq'::regclass);


--
-- Name: t_tpm id; Type: DEFAULT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_tpm ALTER COLUMN id SET DEFAULT nextval('cs.t_tpm_id_seq'::regclass);


--
-- Name: t_transporter id; Type: DEFAULT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_transporter ALTER COLUMN id SET DEFAULT nextval('cs.t_transporter_id_seq'::regclass);


--
-- Name: t_vehicle id; Type: DEFAULT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_vehicle ALTER COLUMN id SET DEFAULT nextval('cs.t_vehicle_id_seq'::regclass);


--
-- Data for Name: t_dailyplan; Type: TABLE DATA; Schema: cs; Owner: postgres
--

INSERT INTO cs.t_dailyplan (id, material, destination, qty) VALUES (1, 'OPC 45', 'Silchar', 200);
INSERT INTO cs.t_dailyplan (id, material, destination, qty) VALUES (2, 'Clinker', 'Kolkatta', 500);
INSERT INTO cs.t_dailyplan (id, material, destination, qty) VALUES (3, 'OPC 43', 'Chennai', 700);


--
-- Data for Name: t_tpm; Type: TABLE DATA; Schema: cs; Owner: postgres
--

INSERT INTO cs.t_tpm (id, transporter_id, vehicle_id, dailyplan_id, sub_qty) VALUES (1, 1, 1, 1, 50);
INSERT INTO cs.t_tpm (id, transporter_id, vehicle_id, dailyplan_id, sub_qty) VALUES (2, 1, 2, 1, 50);
INSERT INTO cs.t_tpm (id, transporter_id, vehicle_id, dailyplan_id, sub_qty) VALUES (3, 1, 3, 1, 100);
INSERT INTO cs.t_tpm (id, transporter_id, vehicle_id, dailyplan_id, sub_qty) VALUES (4, 2, 4, 2, 200);
INSERT INTO cs.t_tpm (id, transporter_id, vehicle_id, dailyplan_id, sub_qty) VALUES (5, 4, 7, 3, 25);


--
-- Data for Name: t_transporter; Type: TABLE DATA; Schema: cs; Owner: postgres
--

INSERT INTO cs.t_transporter (id, code, display_name) VALUES (1, 'VRL', 'VRL Logistics');
INSERT INTO cs.t_transporter (id, code, display_name) VALUES (2, 'NVT', 'Navata Transports');
INSERT INTO cs.t_transporter (id, code, display_name) VALUES (3, 'SFE', 'Safe Express');
INSERT INTO cs.t_transporter (id, code, display_name) VALUES (4, 'LYD', 'Lloyds logistics');


--
-- Data for Name: t_vehicle; Type: TABLE DATA; Schema: cs; Owner: postgres
--

INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (1, 'KA 12 AB 1234', 'VRL Logistics', 1);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (2, 'KA 12 AB 1235', 'Murugan Transports', 1);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (3, 'KA 12 AB 1236', 'Arunachal Transports', 1);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (4, 'KA 12 CD 1234', 'Haneef Transports', 2);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (5, 'KA 12 CD 1235', 'Road Connects', 2);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (6, 'KA 12 EF 1234', 'Safe Lines', 3);
INSERT INTO cs.t_vehicle (id, vehicle_num, display_name, transporter_id) VALUES (7, 'KA 12 GH 1234', 'Connected Lines', 4);


--
-- Name: t_dailyplan_id_seq; Type: SEQUENCE SET; Schema: cs; Owner: postgres
--

SELECT pg_catalog.setval('cs.t_dailyplan_id_seq', 3, true);


--
-- Name: t_tpm_id_seq; Type: SEQUENCE SET; Schema: cs; Owner: postgres
--

SELECT pg_catalog.setval('cs.t_tpm_id_seq', 5, true);


--
-- Name: t_transporter_id_seq; Type: SEQUENCE SET; Schema: cs; Owner: postgres
--

SELECT pg_catalog.setval('cs.t_transporter_id_seq', 4, true);


--
-- Name: t_vehicle_id_seq; Type: SEQUENCE SET; Schema: cs; Owner: postgres
--

SELECT pg_catalog.setval('cs.t_vehicle_id_seq', 7, true);


--
-- Name: t_dailyplan t_dailyplan_pkey; Type: CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_dailyplan
    ADD CONSTRAINT t_dailyplan_pkey PRIMARY KEY (id);


--
-- Name: t_tpm t_tpm_pkey; Type: CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_tpm
    ADD CONSTRAINT t_tpm_pkey PRIMARY KEY (id);


--
-- Name: t_transporter t_transporter_pkey; Type: CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_transporter
    ADD CONSTRAINT t_transporter_pkey PRIMARY KEY (id);


--
-- Name: t_vehicle t_vehicle_pkey; Type: CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_vehicle
    ADD CONSTRAINT t_vehicle_pkey PRIMARY KEY (id);


--
-- Name: fki_fk_vehicle_tpm; Type: INDEX; Schema: cs; Owner: postgres
--

CREATE INDEX fki_fk_vehicle_tpm ON cs.t_tpm USING btree (vehicle_id);


--
-- Name: t_tpm fk_dailyplan_tpm; Type: FK CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_tpm
    ADD CONSTRAINT fk_dailyplan_tpm FOREIGN KEY (dailyplan_id) REFERENCES cs.t_dailyplan(id);


--
-- Name: t_tpm fk_transporter_tpm; Type: FK CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_tpm
    ADD CONSTRAINT fk_transporter_tpm FOREIGN KEY (transporter_id) REFERENCES cs.t_transporter(id);


--
-- Name: t_vehicle fk_transporter_vehicle; Type: FK CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_vehicle
    ADD CONSTRAINT fk_transporter_vehicle FOREIGN KEY (transporter_id) REFERENCES cs.t_transporter(id);


--
-- Name: t_tpm fk_vehicle_tpm; Type: FK CONSTRAINT; Schema: cs; Owner: postgres
--

ALTER TABLE ONLY cs.t_tpm
    ADD CONSTRAINT fk_vehicle_tpm FOREIGN KEY (vehicle_id) REFERENCES cs.t_vehicle(id) NOT VALID;


--
-- PostgreSQL database dump complete
--

