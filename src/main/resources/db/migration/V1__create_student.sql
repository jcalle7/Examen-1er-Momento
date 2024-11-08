CREATE TABLE IF NOT EXISTS student(
    id SERIAL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255),
    PRIMARY KEY (id)
);