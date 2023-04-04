create table Person(
                       person_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name varchar NOT NULL UNIQUE,
                       age int CHECK ( age>0 )
);

create table Book(
                     book_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                     title varchar NOT NULL,
                     author varchar NOT NULL,
                     year int NOT NULL,
                     person_id int REFERENCES person(person_id) ON DELETE SET NULL
);