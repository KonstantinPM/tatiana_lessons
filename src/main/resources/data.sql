INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (5, 'Nick', 'Green', 'nick@mail.com', '$2a$10$CJgEoobU2gm0euD4ygru4ukBf9g8fYnPrMvYk.q0GMfOcIDtUhEwC', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (6, 'Nora', 'White', 'nora@mail.com', '$2a$10$yYQaJrHzjOgD5wWCyelp0e1Yv1KEKeqUlYfLZQ1OQvyUrnEcX/rOy', 2);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (4, 'Mike', 'Brown', 'mike@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);

INSERT INTO states (id, name) VALUES (5, 'New');
INSERT INTO states (id, name) VALUES (6, 'Doing');
INSERT INTO states (id, name) VALUES (7, 'Verify');
INSERT INTO states (id, name) VALUES (8, 'Done');

INSERT INTO todos (id, title, created_at) VALUES (7, 'Mike''s To-Do #1', '2020-09-16 14:00:04.810221');
INSERT INTO todos (id, title, created_at) VALUES (8, 'Mike''s To-Do #2', '2020-09-16 14:00:11.480271');
INSERT INTO todos (id, title, created_at) VALUES (9, 'Mike''s To-Do #3', '2020-09-16 14:00:16.351238');
INSERT INTO todos (id, title, created_at) VALUES (10, 'Nick''s To-Do #1', '2020-09-16 14:14:54.532337');
INSERT INTO todos (id, title, created_at) VALUES (11, 'Nick''s To-Do #2', '2020-09-16 14:15:04.707176');
INSERT INTO todos (id, title, created_at) VALUES (12, 'Nora''s To-Do #1', '2020-09-16 14:15:32.464391');
INSERT INTO todos (id, title, created_at) VALUES (13, 'Nora''s To-Do #2', '2020-09-16 14:15:39.16246');

INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (6, 'Task #2', 'LOW', 7, 5);
INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (5, 'Task #1', 'HIGH', 7, 8);
INSERT INTO tasks (id, name, priority, todo_id, state_id) VALUES (7, 'Task #3', 'MEDIUM', 7, 6);

INSERT INTO users_todos (todos_id, users_id) VALUES (7, 5);
INSERT INTO users_todos (todos_id, users_id) VALUES (7, 6);
INSERT INTO users_todos (todos_id, users_id) VALUES (10, 6);
INSERT INTO users_todos (todos_id, users_id) VALUES (10, 4);
INSERT INTO users_todos (todos_id, users_id) VALUES (12, 5);
INSERT INTO users_todos (todos_id, users_id) VALUES (12, 4);