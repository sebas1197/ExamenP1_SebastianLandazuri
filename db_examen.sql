-- MySQL Script generated by MySQL Workbench
-- Mon Nov 29 20:23:35 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema futbol
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema futbol
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `futbol` DEFAULT CHARACTER SET utf8 ;
USE `futbol` ;

-- -----------------------------------------------------
-- Table `futbol`.`LOCALIDAD_PARTIDO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futbol`.`LOCALIDAD_PARTIDO` (
  `CODIGO` INT NOT NULL AUTO_INCREMENT,
  `CODIGO_LOCALIDAD` VARCHAR(45) NULL,
  `DISPONIBILIDAD` INT NULL,
  `PRECIO` DECIMAL(2) NULL,
  PRIMARY KEY (`CODIGO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futbol`.`PARTIDO_FUTBOL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futbol`.`PARTIDO_FUTBOL` (
  `CODIGO` INT NOT NULL AUTO_INCREMENT,
  `EQUIPO_LOCAL` VARCHAR(45) NULL,
  `EQUIPO_VISITA` VARCHAR(45) NULL,
  `FECHA` DATE NULL,
  `LUGAR` VARCHAR(40) NULL,
  `FK_CODIGO_LOCALIDAD` INT NULL,
  PRIMARY KEY (`CODIGO`),
  INDEX `FK_CODIGO_LOCALIDAD_idx` (`FK_CODIGO_LOCALIDAD` ASC) VISIBLE,
  CONSTRAINT `FK_CODIGO_LOCALIDAD`
    FOREIGN KEY (`FK_CODIGO_LOCALIDAD`)
    REFERENCES `futbol`.`LOCALIDAD_PARTIDO` (`CODIGO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO LOCALIDAD_PARTIDO VALUES('PALCO','150','42.5');
INSERT INTO LOCALIDAD_PARTIDO VALUES('TRIBUNA','120','32.5');
INSERT INTO LOCALIDAD_PARTIDO VALUES('GENERAL','110','22.5');
INSERT INTO LOCALIDAD_PARTIDO VALUES('GENERAL VISITA','90','18.5');
INSERT INTO LOCALIDAD_PARTIDO VALUES('PALCO','250','52.5');

INSERT INTO PARTIDO_FUTBOL VALUES('Olmedo','Liga','22/11/2021','Estadio olimpico', 1);
INSERT INTO PARTIDO_FUTBOL VALUES('Nacional','Catolica','21/10/2020','Estadio Atahualpa', 2);
INSERT INTO PARTIDO_FUTBOL VALUES('Macara','Delfin','20/09/2019','Estadio Miraflores', 3);
INSERT INTO PARTIDO_FUTBOL VALUES('Cuenca','Espol','19/08/2020','Estadio Caracas', 4);
INSERT INTO PARTIDO_FUTBOL VALUES('Quito','Liga','18/07/2021','Estadio Magico', 5);