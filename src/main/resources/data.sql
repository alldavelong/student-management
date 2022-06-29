INSERT INTO authority (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO person (f_name, l_name)
VALUES ('Hans', 'Huber'), ('Maria', 'Müller'),
       ('Linus', 'Torvalds'), ('Alan', 'Turing');

INSERT INTO lecturer VALUES (3), (4);

INSERT INTO student (person_id, matriculation_number, password, class_name)
VALUES (1, '2010b', 'bbb', 'WEBvz20'),
       (2, '2010a', 'aaa', 'WEBvz20');

INSERT INTO student_to_authority (student_id, authority_id) VALUES (1, 2), (2, 2);

INSERT INTO course (name, lecturer_id)
VALUES ('Mathematische Grundlagen der Informatik', 4), ('Wissenschaftliches Arbeiten', 3), ('Software Engineering', 3);

INSERT INTO semester (season, start_year) VALUES ('WS', 2020), ('SS', 2021), ('WS', 2021);

INSERT INTO student_semester (student_id, semester_id) VALUES (1, 1), (1, 2), (2, 1), (2, 2);

INSERT INTO student_semester_course (student_semester_id, course_id) VALUES (1, 1), (1, 2), (2, 3), (3, 1), (4, 3);

INSERT INTO grade (student_semester_to_course_id, grade) VALUES (1, 5), (1, 3), (2, 2), (3, 3), (4, 4), (5, 2);