create database mvc;

use mvc;

CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NULL DEFAULT NULL,
	`email` VARCHAR(50) NOT NULL,
	`password` VARCHAR(200) NULL DEFAULT NULL,
	`mobile_no` VARCHAR(12) NULL DEFAULT NULL,
	`city` VARCHAR(50) NULL DEFAULT NULL,
	`status` TINYINT(4) NOT NULL DEFAULT '1',
	`active_flag` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `email` (`email`)
);
