SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS orders_statuses;

CREATE TABLE orders_statuses (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO orders_statuses (title)
VALUES
("Сформирован");