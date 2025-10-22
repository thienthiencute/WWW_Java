-- Dữ liệu mẫu cho category
INSERT INTO category (name) VALUES ('Electronics'), ('Books'), ('Clothing');

-- Dữ liệu mẫu cho product
INSERT INTO product (name, price, in_stock, category_id) VALUES
                                                             ('Laptop Dell XPS 13', 22000000, TRUE, 1),
                                                             ('Smartphone iPhone 15', 27000000, TRUE, 1),
                                                             ('T-shirt Polo', 450000, TRUE, 3),
                                                             ('Book: Spring Boot in Action', 320000, TRUE, 2),
                                                             ('Book: Java Core', 400000, TRUE, 2);

-- Dữ liệu mẫu cho customer
INSERT INTO customer (name, customer_since) VALUES
                                                ('Nguyen Van A', '2022-05-10'),
                                                ('Tran Thi B', '2023-01-20'),
                                                ('Pham Van C', '2021-11-15');

-- Dữ liệu mẫu cho users (quản trị hệ thống)
INSERT INTO users (username, password, role) VALUES
                                                 ('admin', 'admin123', 'ADMIN'),
                                                 ('user1', 'user1123', 'USER'),
                                                 ('manager', 'manager123', 'MANAGER');

-- Dữ liệu mẫu cho orders
INSERT INTO orders (date, customer_id) VALUES
                                           ('2023-08-01', 1),
                                           ('2023-08-02', 2),
                                           ('2023-08-03', 3),
                                           ('2023-08-05', 1);

-- Dữ liệu mẫu cho orderline
INSERT INTO orderline (order_id, product_id, amount, purchase_price) VALUES
                                                                         (1, 1, 1, 22000000), -- Laptop Dell XPS 13
                                                                         (1, 4, 2, 320000),   -- Book: Spring Boot in Action
                                                                         (2, 2, 1, 27000000), -- iPhone 15
                                                                         (2, 3, 3, 450000),   -- T-shirt Polo
                                                                         (3, 5, 1, 400000),   -- Book: Java Core
                                                                         (4, 1, 1, 22000000); -- Laptop Dell XPS 13

-- Dữ liệu mẫu cho comment
INSERT INTO comment (product_id, text) VALUES
                                           (1, 'Laptop chạy rất mượt, hài lòng!'),
                                           (2, 'iPhone camera rất đẹp!'),
                                           (4, 'Sách hướng dẫn chi tiết, phù hợp cho người mới bắt đầu.'),
                                           (3, 'Áo Polo chất liệu tốt, mặc thoải mái');