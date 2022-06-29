INSERT INTO authority (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO person (f_name, l_name)
VALUES ('Hans', 'Huber'), ('Maria', 'Müller'),
       ('Linus', 'Torvalds'), ('Alan', 'Turing');

INSERT INTO lecturer VALUES (3), (4);

INSERT INTO student (person_id, matriculation_number, password, start_year)
VALUES (1, '2010b', 'bbb', 'WEBvz20'),
       (2, '2010a', 'aaa', 'WEBvz20');