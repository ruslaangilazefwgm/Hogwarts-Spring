-- liquibase
-- formatted sql

-- changeset ruslee:1
CREATE INDEX student_name_idx ON student (name);

-- changeset ruslee:2
CREATE INDEX faculty_name_idx ON faculty (name, colour);