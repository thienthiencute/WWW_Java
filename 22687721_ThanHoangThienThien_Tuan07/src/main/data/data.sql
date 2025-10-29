USE shoppingdb
-- CATEGORY
INSERT INTO category (name) VALUES 
('Electronics'),
('Books'),
('Clothing'),
('Home Appliances'),
('Sports');

-- PRODUCT 
INSERT INTO product (name, price, in_stock, category_id, image) VALUES
                                                                    ('Laptop Dell XPS 13', 22000000, TRUE, 1, '../uploads/IMG_4090.jpg'),
                                                                    ('Smartphone iPhone 15', 27000000, TRUE, 1, '../uploads/Free-High-Resolution-iPhone-15-Pro-Max-Mockup-PSD.jpg'),
                                                                    ('T-shirt Polo', 450000, TRUE, 3, '../uploads/800-mens-polo-t-shirt-1701846977209.jpg'),
                                                                    ('Book: Spring Boot in Action', 320000, TRUE, 2, '../uploads/spring-boot-in-action-9781617292545_hr.jpg'),
                                                                    ('Book: Java Core', 400000, TRUE, 2, '../uploads/ShowCover.jpg'),
                                                                    ('Microwave Oven Sharp', 1800000, TRUE, 4, '../uploads/R-72E0(S).jpg'),
                                                                    ('Air Conditioner Daikin 1.5HP', 9500000, TRUE, 4, '../uploads/DAIKINR32-FTKF35BV1MF-RM2299-RM1959.jpeg'),
                                                                    ('Football Adidas', 750000, TRUE, 5, '../uploads/800-mens-polo-t-shirt-1701846977209.jpg'),
                                                                    ('Basketball Spalding', 850000, TRUE, 5, '../uploads/800-mens-polo-t-shirt-1701846977209.jpg'),
                                                                    ('Headphones Sony WH-1000XM5', 8900000, TRUE, 1, '../uploads/800-mens-polo-t-shirt-1701846977209.jpg');


-- CUSTOMER
INSERT INTO customer (name, customer_since) VALUES
                                                ('Nguyen Van A', '2022-05-10'),
                                                ('Tran Thi B', '2023-01-20'),
                                                ('Pham Van C', '2021-11-15'),
                                                ('Le Thi D', '2024-02-05'),
                                                ('Do Van E', '2022-09-18');

-- USERS (đăng nhập hệ thống)
-- ⚠️ Khi dùng Spring Security, nên lưu password dạng mã hóa (BCrypt)
-- Nhưng ở đây là dữ liệu mẫu minh họa
INSERT INTO users (username, password, role) VALUES
                                                 ('admin', 'admin123', 'ADMIN'),
                                                 ('user1', 'user1123', 'USER'),
                                                 ('manager', 'manager123', 'MANAGER'),
                                                 ('guest', 'guest123', 'USER');

-- ORDERS
INSERT INTO orders (date, customer_id) VALUES
                                           ('2023-08-01', 1),
                                           ('2023-08-02', 2),
                                           ('2023-08-03', 3),
                                           ('2023-08-05', 1),
                                           ('2023-09-10', 4),
                                           ('2023-10-12', 5),
                                           ('2023-12-01', 2);

-- ORDERLINE
INSERT INTO orderline (order_id, product_id, amount, purchase_price) VALUES
                                                                         (1, 1, 1, 22000000), -- Laptop Dell XPS 13
                                                                         (1, 4, 2, 320000),   -- Spring Boot in Action
                                                                         (2, 2, 1, 27000000), -- iPhone 15
                                                                         (2, 3, 3, 450000),   -- T-shirt Polo
                                                                         (3, 5, 1, 400000),   -- Java Core
                                                                         (4, 1, 1, 22000000), -- Laptop Dell XPS 13
                                                                         (5, 7, 1, 9500000),  -- Máy lạnh Daikin
                                                                         (5, 9, 1, 850000),   -- Bóng rổ Spalding
                                                                         (6, 6, 1, 1800000),  -- Lò vi sóng Sharp
                                                                         (6, 8, 2, 750000),   -- Bóng đá Adidas
                                                                         (7, 10, 1, 8900000); -- Tai nghe Sony WH-1000XM5

-- COMMENT
INSERT INTO comment (product_id, text) VALUES
                                           (1, 'Laptop chạy rất mượt, hài lòng!'),
                                           (2, 'iPhone camera rất đẹp, pin tốt!'),
                                           (4, 'Sách hướng dẫn chi tiết, dễ hiểu.'),
                                           (3, 'Áo Polo chất liệu tốt, mặc thoải mái.'),
                                           (6, 'Lò vi sóng gọn nhẹ, dễ sử dụng.'),
                                           (7, 'Máy lạnh chạy êm, làm mát nhanh.'),
                                           (8, 'Bóng đá chất lượng, độ nảy tốt.'),
                                           (9, 'Bóng rổ bám tay, dùng tốt cho sân xi măng.'),
                                           (10, 'Tai nghe cách âm tuyệt vời, pin lâu.');
