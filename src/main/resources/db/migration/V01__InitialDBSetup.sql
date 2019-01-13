CREATE TABLE IF NOT EXISTS `book` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title` varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `member` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(255),
    `email` varchar(255),
    `membership_status` varchar(255),
    `membership_start_date` date
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

CREATE TABLE IF NOT EXISTS `transaction` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `book_id` int,
    `member_id` int,
    `date_of_issue` date,
    `date_of_return` date
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
