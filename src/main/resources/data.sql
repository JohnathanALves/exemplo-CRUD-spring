DROP TABLE IF EXISTS candidate;
DROP TABLE IF EXISTS submission;
DROP TABLE IF EXISTS acceleration;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS challenge;

create sequence user_seq;
CREATE TABLE user (
    id INT DEFAULT user_seq.nextval PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    nickname VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP
);


create sequence challenge_seq;
CREATE TABLE challenge (
    id INT DEFAULT challenge_seq.nextval PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    slug VARCHAR(50) NOT NULL,
    created_at TIMESTAMP
);

create sequence company_seq;
CREATE TABLE company (
    id INT DEFAULT company_seq.nextval PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    slug VARCHAR(50) NOT NULL,
    created_at TIMESTAMP
);

create sequence acceleration_seq;
CREATE TABLE acceleration (
    id INT DEFAULT acceleration_seq.nextval PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    slug VARCHAR(50) NOT NULL,
    challenge_id INT NOT NULL,
    create_at TIMESTAMP,
    FOREIGN KEY (challenge_id) REFERENCES challenge(id)
);

CREATE TABLE candidate (
    user_id INT NOT NULL,
    acceleration_id INT NOT NULL,
    company_id INT NOT NULL,
    status INT NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (acceleration_id) REFERENCES acceleration(id),
    FOREIGN KEY (company_id) REFERENCES company(id)
);

CREATE TABLE submission (
    user_id INT NOT NULL,
    challenge_id INT NOT NULL,
    score FLOAT NOT NULL,
    created_at TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (challenge_id) REFERENCES challenge(id)
);

INSERT INTO user (id, full_name, email, nickname, password) VALUES (100001, 'GERALDO AZEVEDO', 'geraldo@email.com', 'GERALDO', 'password');
INSERT INTO user (id, full_name, email, nickname, password) VALUES (100002, 'TIM MAIA', 'tim@email.com', 'TIM', 'password');
INSERT INTO user (id, full_name, email, nickname, password) VALUES (100003, 'ELBA RAMALHO', 'elba@email.com', 'ELBA', 'password');
INSERT INTO user (id, full_name, email, nickname, password) VALUES (100004, 'JONAS ESTICADO', 'jonas@email.com', 'JONAS', 'password');
INSERT INTO user (id, full_name, email, nickname, password) VALUES (100005, 'KID ABELHA', 'kid@email.com', 'KID', 'password');

INSERT INTO challenge (id, name, slug) VALUES (100001, 'Quem canta melhor', 'canta-melhor');

INSERT INTO company (id, name, slug) VALUES (100001, 'Companhia musical', 'musical-Corp');

INSERT INTO acceleration (id, name, slug, challenge_id) VALUES (100001, 'Aceleracao', 'acc', 100001);

INSERT INTO candidate (user_id, acceleration_id, company_id, status) VALUES (100001, 100001, 100001, 2);
INSERT INTO candidate (user_id, acceleration_id, company_id, status) VALUES (100002, 100001, 100001, 2);
INSERT INTO candidate (user_id, acceleration_id, company_id, status) VALUES (100003, 100001, 100001, 2);
INSERT INTO candidate (user_id, acceleration_id, company_id, status) VALUES (100004, 100001, 100001, 2);
INSERT INTO candidate (user_id, acceleration_id, company_id, status) VALUES (100005, 100001, 100001, 2);


INSERT INTO submission (user_id, challenge_id, score) VALUES (100001, 100001, 9.5);
INSERT INTO submission (user_id, challenge_id, score) VALUES (100002, 100001, 7.5);
INSERT INTO submission (user_id, challenge_id, score) VALUES (100003, 100001, 8.3);
INSERT INTO submission (user_id, challenge_id, score) VALUES (100004, 100001, 5.0);
INSERT INTO submission (user_id, challenge_id, score) VALUES (100005, 100001, 9.0);