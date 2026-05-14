CREATE TABLE goods (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(100) NOT NULL COMMENT '商品名称',
                       price DOUBLE(10,2) NOT NULL COMMENT '价格',
                       image VARCHAR(200) COMMENT '图片地址',
                       detail TEXT COMMENT '商品详情'
);

INSERT INTO goods (name, price, image, detail) VALUES
                                                ('Java编程思想', 99.00, '/images/java.jpg', 'Java经典书籍'),
                                                ('Spring Boot实战', 79.00, '/images/spring.jpg', 'Spring Boot入门到精通'),
                                                ('MySQL必知必会', 49.00, '/images/mysql.jpg', '数据库入门好书'),
                                                ('test', 99.00, '/images/test.jpg', 'test'),
                                                ('绝地潜兵2蓝币', 79.00, '/images/HellDivers.jpg', 'For Super Earth!'),
                                                ('绝地潜兵2尸块', 49.00, '/images/HellDivers1.jpg', '自由你大爷的!');