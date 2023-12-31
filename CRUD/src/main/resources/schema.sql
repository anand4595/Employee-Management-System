-- droping initail tables 
DROP TABLE IF EXISTS `employee_table`;
DROP TABLE IF EXISTS `department_list_table`;
DROP TABLE IF EXISTS `employee_id_seq`;


CREATE TABLE `department_list_table` (
	`name` VARCHAR(255) NOT NULL, 
    PRIMARY KEY (name)
);

CREATE TABLE `employee_id_seq` (next_val BIGINT);
INSERT INTO `employee_id_seq` VALUES ( 1000 );

CREATE TABLE `employee_table` (
	`age` INTEGER NOT NULL, 
    `gender` TINYINT NOT NULL, 
    `role` TINYINT, 
    `salary` INTEGER NOT NULL, 
    `id` BIGINT NOT NULL, 
    `department` VARCHAR(255), 
    `email` VARCHAR(255) NOT NULL, 
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255),
    `middle_name` VARCHAR(255), 
    PRIMARY KEY (id) 
);
ALTER TABLE `employee_table` ADD CONSTRAINT `age_greater_than_18` CHECK (`age` > 18);
ALTER TABLE `employee_table` ADD CONSTRAINT `salary_greater_than_0` CHECK (`age` > 0);

ALTER TABLE `employee_table` ADD CONSTRAINT `unique_email` UNIQUE (`email`);
ALTER TABLE `employee_table` ADD CONSTRAINT `department_table` 
	FOREIGN KEY (department) REFERENCES department_list_table (name)