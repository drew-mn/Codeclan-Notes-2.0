DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS pizza_orders;

CREATE TABLE customers (
  id SERIAL4 PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE pizza_orders (
  id SERIAL4 PRIMARY KEY,
  customer_id INT8 REFERENCES customers(id),
  topping VARCHAR(255),
  quantity VARCHAR(255)
);

-- customers
INSERT INTO customers (name) VALUES ('Colin Bell');
INSERT INTO customers (name) VALUES ('Stevie Mieklejohn');
INSERT INTO customers (name) VALUES ('Debi Skea');

-- pizza_orders
INSERT INTO pizza_orders (topping, quantity, customer_id) VALUES ('pineapple', 3, 1);
INSERT INTO pizza_orders (topping, quantity, customer_id) VALUES ('ham', 1, 3);
