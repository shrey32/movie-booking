
CREATE TABLE addresses(id BIGINT PRIMARY KEY AUTO_INCREMENT, line1 VARCHAR(20) NOT NULL,line2 VARCHAR(20), 
city VARCHAR(15),state(20),country(20),pincode(10),created TIMESTAMP,updated TIMESTAMP);

CREATE TABLE contacts(id BIGINT PRIMARY KEY AUTO_INCREMENT, contactType VARCHAR(6) NOT NULL,number VARCHAR(11),created TIMESTAMP,updated TIMESTAMP);

CREATE TABLE theatres(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30), addressId BIGINT NOT NULL, contactId BIGINT NOT NULL,status VARCHAR(12),created TIMESTAMP,updated TIMESTAMP,
    CONSTRAINT fk_theatre_1 FOREIGN KEY(addressId) references addresses(id),
    CONSTRAINT fk_theatre_1 FOREIGN KEY(contactId) references contacts(id));

CREATE TABLE screens(id BIGINT PRIMARY KEY AUTO_INCREMENT, theatreId BIGINT NOT NULL,capacity INT, created TIMESTAMP,updated TIMESTAMP,
CONSTRAINT fk_screen_1 FOREIGN KEY(theatreId) references theatres(id));  

CREATE TABLE shows(id BIGINT PRIMARY KEY AUTO_INCREMENT,theatreId BIGINT NOT NULL, screenId BIGINT NOT NULL, movieId BIGINT NOT NULL,startTime TIMESTAMP,price DECIMAL,status VARCHAR(15),
created TIMESTAMP,updated TIMESTAMP,
CONSTRAINT fk_show_1 FOREIGN KEY(theatreId) references theatres(id)),
CONSTRAINT fk_show_2 FOREIGN KEY(screenId) references screens(id));  

CREATE TABLE seats(id BIGINT PRIMARY KEY AUTO_INCREMENT, screenId BIGINT NOT NULL,row INT,seatNumber INT,created TIMESTAMP,updated TIMESTAMP,
CONSTRAINT fk_seats_1 FOREIGN KEY(screenId) references screens(id));  