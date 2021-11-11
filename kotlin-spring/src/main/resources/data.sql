INSERT INTO authority(name) VALUES('ROLE_ADMIN');
INSERT INTO authority(name) VALUES('ROLE_USER');
INSERT INTO USER(id, username, password, email,created_by) VALUES(1, 'admin', '$2a$10$3UM2roOLvLGDFBKwui5NK.O5VvRAfyz./onHKXIzW2fXnOL7mLwEO', 'admin@gmail.com', 'admin');
INSERT INTO USER_AUTHORITY(user_id, authority_name) VALUES(1,'ROLE_ADMIN');
