DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(300) NOT NULL,
    password VARCHAR(300) NOT NULL,
    email VARCHAR(100) DEFAULT NULL,
    created_by VARCHAR(300) DEFAULT NULL,
    created_date TIMESTAMP DEFAULT NULL,
    last_modified_by VARCHAR(300) DEFAULT NULL,
    last_modified_date TIMESTAMP DEFAULT NULL
);

DROP TABLE IF EXISTS authority;

CREATE TABLE authority (
    name VARCHAR(50) PRIMARY KEY
);

DROP TABLE IF EXISTS user_authority;

CREATE TABLE user_authority (
    user_id INT PRIMARY KEY,
    authority_name VARCHAR(50) DEFAULT NULL
);