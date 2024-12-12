-- MySQL dump 10.13  Distrib 8.0.40, for macos14 (arm64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Authors`
--

DROP TABLE IF EXISTS `Authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Authors` (
  `author_id` int NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Authors`
--

LOCK TABLES `Authors` WRITE;
/*!40000 ALTER TABLE `Authors` DISABLE KEYS */;
INSERT INTO `Authors` VALUES (101,'F. Scott','Fitzgerald'),(102,'Harper','Lee'),(103,'George','Orwell'),(104,'Jane','Austen'),(105,'J.D.','Salinger'),(106,'J.R.R.','Tolkien'),(107,'Paulo','Coelho'),(108,'Cormac','McCarthy'),(109,'Herman','Melville'),(110,'Agatha','Christie'),(111,'Stephen','King'),(112,'Dan','Brown');
/*!40000 ALTER TABLE `Authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Books`
--

DROP TABLE IF EXISTS `Books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Books` (
  `book_id` int NOT NULL,
  `bookName` varchar(45) NOT NULL,
  `author_id` int NOT NULL,
  `price` decimal(5,2) NOT NULL,
  `genre` varchar(45) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Books`
--

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;
INSERT INTO `Books` VALUES (1,'The Great Gatsby',101,15.99,'Fiction'),(2,'Tender is the Night',101,13.50,'Fiction'),(3,'To Kill a Mockingbird',102,10.50,'Classic'),(4,'1984',103,12.75,'Dystopian'),(5,'Animal Farm',103,8.99,'Satire'),(6,'Pride and Prejudice',104,9.99,'Romance'),(7,'Sense and Sensibility',104,8.75,'Romance'),(8,'The Catcher in the Rye',105,8.49,'Classic'),(9,'The Hobbit',106,14.25,'Fantasy'),(10,'The Lord of the Rings',106,22.75,'Fantasy'),(11,'The Alchemist',107,13.99,'Philosophical'),(12,'The Road',108,16.50,'Post-Apocalyptic'),(13,'Moby Dick',109,17.75,'Adventure'),(14,'Murder on the Orient Express',110,10.99,'Mystery'),(15,'The Shining',111,14.99,'Horror'),(16,'It',111,18.50,'Horror'),(17,'The Da Vinci Code',112,19.99,'Thriller'),(18,'Angels and Demons',112,16.99,'Thriller'),(19,'A Tale of Two Cities',101,11.99,'Historical Fiction'),(20,'Bleak House',101,12.99,'Classic');
/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Reviews`
--

DROP TABLE IF EXISTS `Reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reviews` (
  `review_id` int NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `book_id` int NOT NULL,
  `rating` int NOT NULL,
  PRIMARY KEY (`review_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reviews`
--

LOCK TABLES `Reviews` WRITE;
/*!40000 ALTER TABLE `Reviews` DISABLE KEYS */;
INSERT INTO `Reviews` VALUES (1,'A masterpiece of its time.',1,5),(2,'A vivid depiction of love and loss.',2,4),(3,'Thought-provoking and moving.',3,5),(4,'A chilling depiction of totalitarianism.',4,5),(5,'A clever satire on politics.',5,4),(6,'A timeless love story.',6,5),(7,'Engaging and romantic.',7,4),(8,'A candid look at adolescence.',8,4),(9,'An epic tale of adventure.',9,5),(10,'A fantasy classic.',10,5),(11,'A spiritual and uplifting read.',11,5),(12,'Haunting and powerful.',12,4),(13,'A seafaring classic.',13,5),(14,'A gripping mystery.',14,5),(15,'Terrifying and captivating.',15,5),(16,'A spine-chilling tale.',16,4),(17,'An intriguing thriller.',17,5),(18,'Fast-paced and thrilling.',18,4),(19,'A story of redemption and love.',19,5),(20,'A classic Dickens masterpiece.',20,4),(21,'Highly descriptive and immersive.',1,4),(22,'Couldn’t put it down!',17,5),(23,'The perfect blend of suspense and action.',18,5),(24,'Not as gripping as expected.',14,3),(25,'A great addition to the horror genre.',16,4),(26,'A deeply moving and introspective story.',1,5),(27,'Overrated, but still a decent read.',1,3),(28,'Loved the writing style.',1,4),(29,'A story that lingers with you.',2,5),(30,'Good, but not as engaging as Gatsby.',2,4),(31,'Beautifully written but slow-paced.',2,3),(32,'One of the best classics of all time.',3,5),(33,'A profound story that resonates.',3,5),(34,'The characters are so memorable.',3,4),(35,'A haunting portrayal of dystopia.',4,5),(36,'Chillingly relevant to modern times.',4,5),(37,'The pacing felt off at times.',4,4),(38,'A sharp political allegory.',5,5),(39,'Quick read with a powerful message.',5,5),(40,'Found it too simplistic.',5,3),(41,'An iconic romantic masterpiece.',6,5),(42,'Jane Austen at her best!',6,5),(43,'Not my cup of tea.',6,3),(44,'A compelling tale of love and sacrifice.',7,4),(45,'Charming and well-crafted characters.',7,5),(46,'Felt a bit slow for my taste.',7,3),(47,'An adventurous classic.',9,5),(48,'Captures the imagination of all ages.',9,5),(49,'A great intro to Tolkien\'s world.',9,4),(50,'A fantasy epic like no other.',10,5),(51,'Unparalleled in its scope and detail.',10,5),(52,'Overly descriptive at times.',10,4),(53,'A spiritual journey worth taking.',11,5),(54,'Motivational and inspiring.',11,5),(55,'Repetitive and overhyped.',11,3),(56,'Bleak but incredibly moving.',12,5),(57,'A masterpiece of minimalism.',12,4),(58,'Too depressing for my liking.',12,3),(59,'Keeps you guessing until the end.',14,5),(60,'The ultimate whodunit.',14,5),(61,'Found it predictable.',14,3),(62,'Thrilling from start to finish.',17,5),(63,'A perfect mix of history and mystery.',17,5),(64,'Engaging but a bit far-fetched.',17,4),(65,'Suspenseful and well-paced.',18,5),(66,'Kept me on the edge of my seat.',18,5),(67,'Not as good as The Da Vinci Code.',18,4),(68,'A poignant tale of love and revolution.',19,5),(69,'A classic everyone should read.',19,5),(70,'Takes time to get into.',19,4),(71,'Masterfully written and immersive.',20,5),(72,'A bit too lengthy for me.',20,4),(73,'Excellent portrayal of Victorian England.',20,5);
/*!40000 ALTER TABLE `Reviews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 22:32:22
