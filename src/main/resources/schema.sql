CREATE TABLE note (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    content VARCHAR(2000) NOT NULL,
    creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);