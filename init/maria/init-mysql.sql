CREATE DATABASE IF NOT EXISTS `auth`;
CREATE DATABASE IF NOT EXISTS `department`;

GRANT ALL ON `auth`.* TO 'mariauser'@'%';
GRANT ALL ON `department`.* TO 'mariauser'@'%';