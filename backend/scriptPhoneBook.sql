CREATE SCHEMA if not exists phone_book default character set utf8;
use phone_book;

CREATE TABLE contact (
    con_id INT NOT NULL AUTO_INCREMENT,
    con_name VARCHAR(45) NOT NULL,
    con_lastname VARCHAR(45) NOT NULL,
    con_phone VARCHAR(45) NOT NULL,
    con_email VARCHAR(45) NOT NULL,
    con_datebirth DATE NOT NULL,
    con_created_at DATETIME NULL,
    con_updated_at DATETIME NULL,
    con_deleted_at DATETIME NULL,
    PRIMARY KEY (con_id),
    UNIQUE INDEX con_phone_UNIQUE (con_phone ASC) VISIBLE
    ) engine = InnoDB;