CREATE TABLE movies(id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30), description VARCHAR(1000), durationInMinutes INT,image VARCHAR, releaseDate TIMESTAMP, created TIMESTAMP,updated TIMESTAMP);
    
CREATE TABLE languages(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(10) NOT NULL, created TIMESTAMP,updated TIMESTAMP);

CREATE TABLE casts(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20) NOT NULL, image VARCHAR, movieCastRole VARCHAR(20) NOT NULL,created TIMESTAMP,updated TIMESTAMP);

CREATE TABLE categories(id BIGINT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20) NOT NULL, description VARCHAR(30),created TIMESTAMP,updated TIMESTAMP);


CREATE TABLE movielanguage(id BIGINT PRIMARY KEY AUTO_INCREMENT,movieId BIGINT NOT NULL, languageId BIGINT NOT NULL,created TIMESTAMP,updated TIMESTAMP,
               CONSTRAINT fk_movie_lang_1 FOREIGN KEY(movieId) references movies(id),
               CONSTRAINT fk_movie_lang_2 FOREIGN KEY(languageId) references languages(id));
               
CREATE TABLE moviecast(id BIGINT PRIMARY KEY AUTO_INCREMENT,movieId BIGINT NOT NULL, castId BIGINT NOT NULL,created TIMESTAMP,updated TIMESTAMP,
               CONSTRAINT fk_movie_cast_1 FOREIGN KEY(movieId) references movies(id),
               CONSTRAINT fk_movie_cast_2 FOREIGN KEY(castId) references casts(id));
               

CREATE TABLE moviecategory(id BIGINT PRIMARY KEY AUTO_INCREMENT,movieId BIGINT NOT NULL, categoryId BIGINT NOT NULL,created TIMESTAMP,updated TIMESTAMP,
               CONSTRAINT fk_movie_category_1 FOREIGN KEY(movieId) references movies(id),
               CONSTRAINT fk_movie_category_2 FOREIGN KEY(categoryId) references categories(id));