CREATE TABLE IF NOT EXISTS student(
    id SERIAL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS comments(
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    course_name VARCHAR(255),
    description VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES student(id)
);