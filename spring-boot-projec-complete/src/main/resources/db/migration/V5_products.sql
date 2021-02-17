SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id	                INT(11) NOT NULL AUTO_INCREMENT,
  category_id           INT(11) NOT NULL,
  vendor_code           VARCHAR(8) NOT NULL,
  title                 VARCHAR(255) NOT NULL,
  short_description     VARCHAR(1000) NOT NULL,
  full_description      VARCHAR(5000) NOT NULL,
  price                 DECIMAL(8,2) NOT NULL,
  create_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (category_id)
  REFERENCES categories (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO products (category_id, vendor_code, title, short_description, full_description, price)
VALUES
(1, "00000001", "20\" Телевизор Samsung UE20NU7170U", "Коротко: Хороший телевизор Samsung 20", "LED телевизор Samsung 20", 1.00),
(1, "00000002", "24\" Телевизор Samsung UE24NU7170U", "Коротко: Хороший телевизор Samsung 24", "LED телевизор Samsung 24", 2.00),
(1, "00000003", "28\" Телевизор Samsung UE28NU7170U", "Коротко: Хороший телевизор Samsung 28", "LED телевизор Samsung 28", 3.00),
(1, "00000004", "32\" Телевизор Samsung UE32NU7170U", "Коротко: Хороший телевизор Samsung 32", "LED телевизор Samsung 32", 4.00),
(1, "00000005", "36\" Телевизор Samsung UE36NU7170U", "Коротко: Хороший телевизор Samsung 36", "LED телевизор Samsung 36", 5.00),
(1, "00000006", "40\" Телевизор Samsung UE40NU7170U", "Коротко: Хороший телевизор Samsung 40", "LED телевизор Samsung 40", 6.00),
(1, "00000007", "44\" Телевизор Samsung UE44NU7170U", "Коротко: Хороший телевизор Samsung 44", "LED телевизор Samsung 44", 7.00),
(1, "00000008", "48\" Телевизор Samsung UE48NU7170U", "Коротко: Хороший телевизор Samsung 48", "LED телевизор Samsung 48", 8.00),
(1, "00000009", "52\" Телевизор Samsung UE52NU7170U", "Коротко: Хороший телевизор Samsung 52", "LED телевизор Samsung 52", 9.00),
(1, "00000010", "56\" Телевизор Samsung UE56NU7170U", "Коротко: Хороший телевизор Samsung 56", "LED телевизор Samsung 56", 10.00),
(1, "00000011", "60\" Телевизор Samsung UE60NU7170U", "Коротко: Хороший телевизор Samsung 60", "LED телевизор Samsung 60", 11.00),
(1, "00000012", "64\" Телевизор Samsung UE64NU7170U", "Коротко: Хороший телевизор Samsung 64", "LED телевизор Samsung 64", 12.00);