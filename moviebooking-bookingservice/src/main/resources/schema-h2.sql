CREATE TABLE bookings(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    theatreId BIGINT NOT NULL,screenId BIGINT NOT NULL,showId BIGINT NOT NULL, userId BIGINT, amount DECIMAL NOT NULL, status VARCHAR(10) NOT NULL, created TIMESTAMP,updated TIMESTAMP);
    
    
CREATE TABLE bookedseat(id BIGINT PRIMARY KEY AUTO_INCREMENT,bookingId BIGINT NOT NULL, seatId BIGINT NOT NULL,created TIMESTAMP,updated TIMESTAMP,
               CONSTRAINT fk_bookings_bookedseat_1 FOREIGN KEY(bookingId) references bookings(id));