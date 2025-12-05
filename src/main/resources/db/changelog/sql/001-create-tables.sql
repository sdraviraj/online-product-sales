CREATE TABLE client (
    client_id VARCHAR(100) PRIMARY KEY,
    client_type VARCHAR(50),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    company_name VARCHAR(255),
    vat_number VARCHAR(100),
    registration_number VARCHAR(100),
    annual_revenue DOUBLE
);

CREATE TABLE product (
    product_type VARCHAR(50) PRIMARY KEY,
    individual_price DOUBLE,
    pro_low_revenue_price DOUBLE,
    pro_high_revenue_price DOUBLE
);

CREATE TABLE cart_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_id VARCHAR(100),
    product_type VARCHAR(50),
    quantity INT,
    FOREIGN KEY (client_id) REFERENCES client(client_id)
);
