create table student
(
    id         bigint  not null
        primary key,
    age        integer not null DEFAULT (20),
    name       varchar(255),
    faculty_id bigint
        constraint fk6geq7tnjed7u4hvgv1ac6lyh
            references faculty
);

alter table student
    owner to student;
ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age > 16);
ALTER TABLE student
    ADD PRIMARY KEY (name);
