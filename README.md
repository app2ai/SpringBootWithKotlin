# SpringBootWithKotlin
Design SpringBoot Rest API with Kotlin 

# Setup
IDE: Netbeans 8.2
Language: Kotlin
DB: MySQL

Note: Add Kotlin Plugin to start code in Kotlin in Netbeans IDE and Follow pom.xml for better understanding

# DB SCHEMA:

Create Notes Table
CREATE TABLE `notes` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `note_title` text,
  `note_desc` text,
  `created_by` int(4) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(4) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1

# Insert Query
INSERT INTO `vtest_db`.`notes`(`id`,`note_title`,`note_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES ( NULL,'Todays plan for work','Playing cricket, done home work, helping mom etc','1',NOW(),'1',NOW()); 

INSERT INTO `vtest_db`.`notes`(`id`,`note_title`,`note_desc`,`created_by`,`created_date`,`updated_by`,`updated_date`) VALUES ( NULL,'Afternoon plan','Go to market and bring vegetables','1',NOW(),'1',NOW()); 
