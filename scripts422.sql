create table human
(
    name        varchar primary key,
    age         int,
    permissions BOOLEAN,
    car_id      int references car (id)

);

create table car
(
    id    int primary key,
    brend varchar,
    model varchar,
    cost  int

);
