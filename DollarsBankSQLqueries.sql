CREATE DATABASE  IF NOT EXISTS `dollarsbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dollarsbank`;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerId` int NOT NULL,
  `amount` float NOT NULL DEFAULT '0',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `type` enum('CHECKING','SAVINGS','OTHER') NOT NULL DEFAULT 'OTHER',
  `visible` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `customerId_idx` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `mobile` varchar(45) NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `visible` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerTransactionId` int NOT NULL,
  `userTransactionId` int NOT NULL,
  `amount` float NOT NULL DEFAULT '0',
  `initialBalance` float NOT NULL DEFAULT '0',
  `RemainingBalance` float NOT NULL DEFAULT '0',
  --transactionType enum ('DEPOSIT','WITHDRAW','UNSPECIFIED') NOT NULL DEFAULT 'UNSPECIFIED',
  --`type` enum('CHECKING','SAVINGS','OTHER') NOT NULL DEFAULT 'OTHER',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `customerTransactionId_idx` (`customerTransactionId`),
  KEY `accountTransactionId_idx` (`accountTransactionId`),
  CONSTRAINT `accountTransactionId` FOREIGN KEY (`accountTransactionId`) REFERENCES `accounts` (`id`),
  CONSTRAINT `customerTransactionId` FOREIGN KEY (`customerTransactionId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
