INSERT INTO account (active, id, email, user_name) VALUES (true, 1, 'test-email1@email.com', 'test-user-name1');
INSERT INTO account (active, id, email, user_name) VALUES (true, 2, 'test-email2@email.com', 'test-user-name2');
INSERT INTO account (active, id, email, user_name) VALUES (true, 3, 'test-email3@email.com', 'test-user-name3');

ALTER SEQUENCE account_seq RESTART WITH 50;