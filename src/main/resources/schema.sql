CREATE TABLE if not exists restaurant (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    address varchar(255),
    cuisinetype varchar(255),
    rating INT
);

CREATE TABLE if not exists chef (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstname varchar(255),
    lastname varchar(255),
    expertise varchar(255),
    experienceyears INT,
    restaurantid INT,
    FOREIGN KEY (restaurantid) REFERENCES restaurant(id)
);

