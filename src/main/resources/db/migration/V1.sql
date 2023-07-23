CREATE TABLE candidate
(
    id     BIGSERIAL PRIMARY KEY,
    email  VARCHAR UNIQUE NOT NULL,
    f_name VARCHAR        NOT NULL,
    l_name VARCHAR        NOT NULL
);

CREATE TABLE cv
(
    candidate_id BIGSERIAL PRIMARY KEY REFERENCES candidate,
    content      VARCHAR UNIQUE NOT NULL
);

CREATE TABLE employer
(
    id            BIGSERIAL PRIMARY KEY,
    email         VARCHAR UNIQUE NOT NULL,
    employer_name VARCHAR        NOT NULL,
    site          VARCHAR
);

CREATE TABLE vacancy
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR   NOT NULL,
    discription VARCHAR   NOT NULL,
    isActive    BOOLEAN   NOT NULL,
    created_at  TIMESTAMP NOT NULL,
    employer_id BIGINT    NOT NULL REFERENCES employer
);

CREATE TABLE vacancy_add
(
    id           BIGSERIAL PRIMARY KEY,
    vacancy_id   BIGINT    NOT NULL REFERENCES vacancy,
    candidate_id BIGINT    NOT NULL REFERENCES candidate,
    cover_letter TEXT      NOT NULL,
    created_at   TIMESTAMP NOT NULL,
    UNIQUE (vacancy_id, candidate_id)
);


