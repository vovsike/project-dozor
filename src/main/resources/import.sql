INSERT INTO account (active, id, email, user_name) VALUES (true, 1, 'test-email1@email.com', 'test-user-name1');
INSERT INTO account (active, id, email, user_name) VALUES (true, 2, 'test-email2@email.com', 'test-user-name2');
INSERT INTO account (active, id, email, user_name) VALUES (true, 3, 'test-email3@email.com', 'test-user-name3');

INSERT INTO student (account_id, first_name, last_name) VALUES (1, 'test-first-name', 'test-last-name');
INSERT INTO student (account_id, first_name, last_name) VALUES (2, 'test-first-name2', 'test-last-name2');