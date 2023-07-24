
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(200) NOT NULL,
    number VARCHAR(10),
    neighborhood VARCHAR(100)  NULL,
    city VARCHAR(100)  NULL,
    state VARCHAR(50)  NULL,
    postal_code VARCHAR(10) NOT NULL,
    country VARCHAR(50)  NULL,
    latitude FLOAT NULL,
    longitude FLOAT NULL
);

CREATE TABLE contacts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) NOT NULL,
    phone VARCHAR(20) NULL,
    address_id BIGINT REFERENCES address(id)
);



CREATE TABLE user_contacts (
    user_id BIGINT REFERENCES users(id),
    contact_id BIGINT REFERENCES contacts(id),
    PRIMARY KEY (user_id, contact_id)
);
