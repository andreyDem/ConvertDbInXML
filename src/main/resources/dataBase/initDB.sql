DROP DATABASE IF EXISTS employeeList;
CREATE DATABASE IF NOT EXISTS employeeList
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE employeeList;

CREATE TABLE IF NOT EXISTS fullName(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(30) NOT NULL,
  middle_name VARCHAR(30) NOT NULL
)
  ENGINE = InnoDB;

