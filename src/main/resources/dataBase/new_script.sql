CREATE SCHEMA `bookaddicts` ;

CREATE TABLE `bookaddicts`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `birthday` DATE NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`id`));

CREATE TABLE `bookaddicts`.`author` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `patronymic` VARCHAR(255) NOT NULL,
  `birthday` DATE NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bookaddicts`.`book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `number_of_pages` INT NOT NULL,
  `publication_year` DATE NOT NULL,
  `image` VARCHAR(200) NOT NULL,
  `link_to_source` VARCHAR(255),
  `id_author` BIGINT(40) NOT NULL,
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
  `id_book` BIGINT(40) NOT NULL,
  `id_user` BIGINT(40) NOT NULL,
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

CREATE TABLE `bookaddicts`.`user_book` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_user` BIGINT(20) NOT NULL,
  `id_book` BIGINT(20) NOT NULL,
  `rating` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_mtm_pk_idx` (`id_user` ASC) VISIBLE,
  INDEX `id_book_mtm_pk_idx` (`id_book` ASC) VISIBLE,
  CONSTRAINT `id_user_mto_fk`
    FOREIGN KEY (`id_user`)
    REFERENCES `bookaddicts`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_book_mto_fk`
    FOREIGN KEY (`id_book`)
    REFERENCES `bookaddicts`.`book` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);