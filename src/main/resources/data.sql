INSERT INTO authority (name) VALUES ('ROLE_ADMIN'), ('ROLE_USER');

INSERT INTO person (f_name, l_name)
VALUES ('Hans', 'Huber'), ('Maria', 'Müller'),
       ('Linus', 'Torvalds'), ('Alan', 'Turing');

INSERT INTO lecturer VALUES (3), (4);

INSERT INTO student (person_id, matriculation_number, class_name)
VALUES (1, '2010b', 'WEBvz20'),
       (2, '2010a', 'WEBvz20');

INSERT INTO university_user (username, password_hash, student_id)
VALUES ('hansi', '{bcrypt}$2a$10$h2IsgSouClQBT2tIObVu9eJ2/RB.H6Qb76UemjostIF5tTb4LSSfO', 1),
       ('mary', '{bcrypt}$2a$10$9OzgegTiX4XvQ0b8sNuml.bdrfCuYIvMMj57uiTdC8TOgXx2ZGJbO', 2),
       ('admin', '{bcrypt}$2a$10$nUq29qF9H4u0rmylKy/R7e3o2Knuqn8aNcGlXzzcdb1BU8pPi1jme', null);

INSERT INTO user_to_authority (user_id, authority_id) VALUES (1,2), (2, 2), (3, 1);

INSERT INTO course (name, lecturer_id)
VALUES ('Mathematische Grundlagen der Informatik', 4), ('Wissenschaftliches Arbeiten', 3), ('Software Engineering', 3);

INSERT INTO semester (season, start_year) VALUES ('WS', 2020), ('SS', 2021), ('WS', 2021);

INSERT INTO student_semester (student_id, semester_id) VALUES (1, 1), (1, 2), (2, 1), (2, 2);

INSERT INTO student_semester_course (student_semester_id, course_id) VALUES (1, 1), (1, 2), (2, 3), (3, 1), (4, 3);

INSERT INTO grade (student_semester_to_course_id, grade) VALUES (1, 5), (1, 3), (2, 2), (3, 3), (4, 4), (5, 2);