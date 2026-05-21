CREATE TABLE goods (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL COMMENT '商品名称',
    price DOUBLE(10,2) NOT NULL COMMENT '价格',
    image VARCHAR(200) COMMENT '图片地址',
    detail TEXT COMMENT '商品详情'
);

INSERT INTO goods (name, price, image, detail) VALUES
    ('test', 99.00, '/images/test.jpg', 'test'),
    ('绝地潜兵2蓝币', 79.00, '/images/HellDivers.jpg', 'For Super Earth!'),
    ('绝地潜兵2尸块', 49.00, '/images/HellDivers1.jpg', '自由你大爷的!');

CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username INT NOT NULL,
    password INT NOT NULL
);

CREATE TABLE address (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    userId INT NOT NULL COMMENT '哪个用户的地址',
    receiver VARCHAR(50) NOT NULL COMMENT '收货人',
    phone VARCHAR(50) NOT NULL COMMENT '手机号',
    province VARCHAR(50) NOT NULL COMMENT '省',
    city VARCHAR(50) NOT NULL COMMENT '市',
    district VARCHAR(50) NOT NULL COMMENT '区',
    detail VARCHAR(50) NOT NULL COMMENT '详细地址',
    isDefault BOOLEAN NOT NULL COMMENT '是否为默认地址'
);
