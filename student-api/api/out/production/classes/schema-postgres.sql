DROP TABLE IF EXISTS student;
CREATE TABLE student(id serial PRIMARY KEY, name VARCHAR(100), class integer,active boolean, admissionYear date);