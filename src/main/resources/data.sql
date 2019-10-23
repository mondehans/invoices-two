DROP TABLE IF EXISTS invoices;

CREATE TABLE invoices (

id BIGINT AUTO_INCREMENT  PRIMARY KEY,
client VARCHAR(255),
vat_rate BIGINT,
invoice_date TIMESTAMP
);

DROP TABLE IF EXISTS line_items;

CREATE TABLE line_items (
id BIGINT AUTO_INCREMENT  PRIMARY KEY,
 quantity BIGINT,
 description VARCHAR(255),
 unit_price decimal,
 INVOICE_ID BIGINT
);
