CREATE TABLE employer
(
    employer_id   BIGSERIAL PRIMARY KEY,
    email         VARCHAR UNIQUE NOT NULL,
    employer_name VARCHAR        NOT NULL,
    site          VARCHAR        NOT NULL
);

CREATE TABLE employe
(
    employe_id BIGSERIAL PRIMARY KEY,
    email      VARCHAR UNIQUE NOT NULL,
    name       VARCHAR        NOT NULL,
    surname    VARCHAR        NOT NULL,
    resume     VARCHAR        NOT NULL
);

CREATE TABLE vacancy
(
    vacancy_id  BIGSERIAL PRIMARY KEY,
    title       VARCHAR NOT NULL,
    discription VARCHAR NOT NULL,
    isActive    BOOLEAN DEFAULT TRUE,
    employe_message VARCHAR,
    employer_id INTEGER REFERENCES employer (employer_id),
    employe_id INTEGER REFERENCES employe (employe_id)
);


