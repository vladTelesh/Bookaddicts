CREATE SCHEMA `bookaddicts` ;

CREATE TABLE `bookaddicts`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  ADD COLUMN `email` VARCHAR(45) NOT NULL,
ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id`));

CREATE TABLE `bookaddicts`.`author` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bookaddicts`.`book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `number_of_pages` INT NOT NULL,
  `publication year` DATE NOT NULL,
  `id_author` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_author_fk_idx` (`id_author` ASC) VISIBLE,
  CONSTRAINT `id_author_fk`
    FOREIGN KEY (`id_author`)
    REFERENCES `bookaddicts`.`author` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `bookaddicts`.`comment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `text` VARCHAR(500) NOT NULL,
  `rating` INT NOT NULL,
  `id_book` BIGINT(20) NOT NULL,
  `id_user` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_fk_idx` (`id_user` ASC) VISIBLE,
  INDEX `id_books_fk_idx` (`id_book` ASC) VISIBLE,
  CONSTRAINT `id_users_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `bookaddicts`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_books_fk`
    FOREIGN KEY (`id_book`)
    REFERENCES `bookaddicts`.`book` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
