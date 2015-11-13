INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`, `active`) VALUES ('Employee', '1', 'yoshi.degent@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', '1993-10-19', 'Yoshi', 'Developer', '2', '2015-09-01', 'Degent', 1);
INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`, `active`) VALUES ('Employee', '2', 'dean.wyns@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', '1994-09-30', 'Dean', 'Developer', '2', '2015-09-01', 'Wyns', 1);
INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`, `active`) VALUES ('Admin', '3', 'josephine.wauters@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', '1960-02-14', 'Josephine', 'Fleet', '3', '2012-04-01', 'Wauters', 1);

INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('1', 'ROLE_EMPLOYEE');
INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('2', 'ROLE_EMPLOYEE');
INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('3', 'ROLE_ADMIN');

INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('1', 'Towing bracket');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('2', 'GPS');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('3', 'GSM Bluetooth');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('4', 'Rims');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('5', 'Leather interior');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('6', 'Cruise control');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('7', 'Automatic');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('8', 'Park sensors');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('9', 'Tinted windows');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('10', 'Roof rails');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('11', 'Heated seats');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('12', '7-seats');

INSERT INTO `carmodel` VALUES (1,0,0,3924.43,NULL,104.17,'Audi',2,89,'P5M',9,'DIESEL',140000,25048.99,180000,'A3 sportback 1,6 tdi 110 pk ultra attraction','Pack intuition Plus attraction',NULL,'STEEL'),(2,0,0,2479.69,NULL,104.17,'Seat',2,109,'P3M15D',7,'DIESEL',140000,19945.48,180000,'Ibiza St 1,6 crtdi 105 pk Style ecomotive','Pack electronic / accoustic parking system/ Seat portable system/ oberg module',NULL,'STEEL'),(3,0,0,5491.27,NULL,104.17,'Seat',2,87,'P3M',9,'DIESEL',140000,23178.00,180000,'Leon style 1,6 Tdi 110 pk ecomotive','Pack Dynamic / Full led',NULL,'STEEL'),(4,0,0,4253.93,NULL,104.17,'Skoda ',2,90,'P3M',9,'DIESEL',140000,24566.82,180000,'Octavia Berline 1,6 tdi 110 pk  greenline','Pack Ambition GPs ',NULL,'STEEL'),(5,0,0,4042.73,NULL,104.17,'Skoda ',2,90,'P3M15D',9,'DIESEL',140000,25343.22,180000,'Octavia combi 1,6 tdi 110 pk  greenline','Pack Ambition GPs ',NULL,'STEEL'),(6,0,0,1907.41,NULL,104.17,'Skoda ',2,109,'P3M15D',7,'DIESEL',180000,17187.91,200000,'Roomster 1,2 crtdi 75 pk','Pack ambition Greenline - GPS TomTom Via 135 LTM',NULL,'STEEL'),(7,0,0,1369.33,NULL,123.65,'VW',2,99,'P4M',9,'DIESEL',140000,27476.95,180000,'Golf 7 Highline 1,6l CRTDI 110 pk BMT ','Pack BUSINESS CLASS @ GPS \"MEDIA\"',NULL,'STEEL'),(8,0,0,1407.33,NULL,125.86,'VW',2,102,'P3M15D',9,'DIESEL',140000,26696.57,180000,'Golf Variant Trendl.1,6 CRTDI 110 pk BMT','Pack Business Class Discover Media',NULL,'STEEL'),(9,0,0,2795.35,2431.85,122.93,'VW',3,107,'P5M',11,'DIESEL',140000,24240.16,180000,'Beetle Design 2,0l TDI 110pk BMT','Pack business@gps discover Media/Pack comfort 2',NULL,'STEEL'),(10,0,0,3036.91,2190.29,126.98,'Audi',3,99,'P5M',9,'DIESEL',140000,28218.01,180000,'A3 sportback 1,6 tdi 110 pk Ambiente','Pack intuition Plus ambiente / Pack lounge',NULL,'STEEL'),(11,0,0,3165.90,2061.30,134.92,'VW',3,102,'P4M',9,'DIESEL',180000,28618.88,200000,'Golf Variant Highline 1,6CRTDI 110 pk BMT','Pack business @ gps  Discover Media ',NULL,'STEEL'),(12,0,0,2792.90,2434.30,137.66,'Skoda ',3,109,'P4M',9,'DIESEL',180000,26400.74,200000,'Superb berline ambiente 1,6 crtdi greenline ','Pack Company Amundsen,',NULL,'STEEL'),(13,0,0,1363.08,3864.12,152.23,'VW',3,105,'P4M',9,'DIESEL',140000,30887.44,180000,'Passat berline 1.6 TDI 120 pk DPG BMT comfortline','Pack Business @ GPS \"Discover MEDIA',NULL,'ALUMINIUM'),(14,0,0,2349.24,2877.96,153.20,'Skoda ',3,113,'P4M',9,'DIESEL',180000,27853.89,200000,'Superb Combi 1,6 tdi 105 pk 5v geenline amb','Pack Company Amundsen,',NULL,'STEEL'),(15,0,0,1557.73,3669.47,157.65,'VW',3,115,'P5M',9,'DIESEL',140000,27937.26,180000,'New Touran 1.6TDI Trendline 110pk BMT 6v','metaal kleur - GPs Garmin + 2 extra Zetels + velgen Brighton ',NULL,'ALUMINIUM'),(16,0,0,5046.42,761.58,135.73,'VW',4,101,'P4M',9,'DIESEL',140000,29234.32,180000,'Golf Sportsvan 1,6 CRTDI 110 Highline','Pack Business@gps \" Discover Media\" / park pilot / dakrailling',NULL,'STEEL'),(17,0,0,4611.88,1196.12,138.17,'VW',4,105,'P5M',9,'DIESEL',140000,28034.71,180000,'Jetta Comfortline 2,0 tdi 110pk 5v BMT','Pack \"BUSINESS\"  GPS \"RNS 315\"',NULL,'ALUMINIUM'),(18,0,0,4283.85,1524.15,154.61,'Skoda ',4,109,'P4M',9,'DIESEL',180000,29652.19,200000,'Superb Greenline elegance 1,6 tdi 105 pk','Pack elegance admundsen',NULL,'STEEL'),(19,0,0,2150.86,3657.14,166.61,'VW',4,107,'P4M',9,'DIESEL',140000,32852.07,180000,'Passat Variant 1,6 tdi 120 pk Comfortline ','Pack Business @ GPS \"Discover MEDIA',NULL,'ALUMINIUM'),(20,0,0,2713.57,3094.43,167.34,'VW',4,115,'P5M',9,'DIESEL',140000,29655.48,180000,'New Touran 1.6TDI Trendline 110 pk BMT 6v','Pack Business : +2 EXTRA ZETELS + velgen Brighton',NULL,'ALUMINIUM'),(21,0,0,1835.36,3972.64,170.75,'Audi',4,117,'P4M',11,'DIESEL',180000,29511.49,200000,'A4 berline 2,0 tdi 120 pk','pack executive plus',NULL,'ALUMINIUM'),(22,0,0,3548.40,2259.60,170.89,'Skoda ',4,113,'P4M',9,'DIESEL',180000,31070.18,200000,'Superb combi Greenline elegance 1,6 tdi 105 pk','Pack elegance admundsen',NULL,'STEEL'),(23,0,0,3614.96,4806.64,104.17,'vw',5,95,'P5M',8,'GASOLINE',180000,32608.02,200000,'Jetta hybride 1,4 tsi 150 pk dsg','Radio gps rns 315/ gsm pre installatie / mutifunctie stuur',NULL,'ALUMINIUM'),(24,0,0,7942.24,479.36,139.56,'Audi',5,105,'P5M',11,'DIESEL',140000,28316.18,180000,'A3 sportback 2,0 tdi 150 pk Attraction','Pack intuition plus Attraction / Pack lounge',NULL,'ALUMINIUM'),(25,0,0,7357.86,1063.74,150.31,'Audi',5,104,'P4M',9,'DIESEL',180000,30945.61,200000,'A4 berline 2,0 tdi ultra 136 pk','pack executive fleet plus',NULL,'STEEL'),(26,0,0,5420.33,3001.27,175.21,'VW',5,107,'P4M',9,'DIESEL',140000,34547.75,180000,'Passat variant 1,6 tdi 120 pk highline','Pack Business @ GPS \"Discover MEDIA',NULL,'ALUMINIUM'),(27,0,0,6970.93,1450.67,175.62,'VW',5,115,'P5M',9,'DIESEL',140000,31122.47,180000,'New Touran 1.6TDI Highline 110 pk BMT 6v','Pack Business + Park Assist + Park Pilot + 2 extra zetels + velgen Brighton ',NULL,'ALUMINIUM'),(28,0,0,4957.47,3464.13,175.94,'VW',5,106,'P4M',11,'DIESEL',180000,35187.49,200000,'Passat berline 2,0 tdi 150 pk highline ','Pack Business @ GPS \"Discover PRO',NULL,'ALUMINIUM'),(29,0,0,5635.71,2785.89,183.17,'Skoda ',5,121,'P4M',11,'DIESEL',180000,30169.23,200000,'superb combi 2,0 tdi 140 pk Greentec','Pack Admundsen',NULL,'STEEL'),(30,0,0,4343.68,4077.92,193.76,'Audi',5,123,'P4M',11,'DIESEL',180000,31180.52,200000,'A4 avant 2,0 tdi 120 pk','pack executive fleet plus',NULL,'ALUMINIUM'),(31,0,0,NULL,1501.75,181.79,'Audi',6,109,'P4M',11,'DIESEL',180000,34864.63,200000,'A4 avant 2,0 tdi ultra 136 pk 6 v','pack executive fleet plus + pack lounge',NULL,'STEEL'),(32,0,0,NULL,2487.12,187.98,'Audi',6,114,'P5M',11,'DIESEL',180000,33739.60,200000,'Q3 2,0 tdi ultra 150 pk ','Pack Adventure Plus',NULL,'ALUMINIUM'),(33,0,0,NULL,2963.81,188.60,'Audi',6,109,'P4M',11,'DIESEL',180000,36170.39,200000,'A4 berline 2,0 tdi 163 pk ultra ','pack executive fleet plus + pack lounge',NULL,'STEEL'),(34,0,0,NULL,3488.23,217.89,'Audi',6,114,'P4M',11,'DIESEL',180000,39108.50,200000,'A6 berline 2,0 tdi 136 pk','pack executive fleet plus ',NULL,'ALUMINIUM'),(35,0,0,NULL,4376.24,223.60,'Audi',6,118,'P4M',11,'DIESEL',180000,38175.30,200000,'A5 sportback 2,0 tdi 150 pk ','Pack Intenso Plus (GPS)+ GSM 2W dualband pre-installatie (Bluetooth)/ pack lounge',NULL,'ALUMINIUM'),(36,0,0,NULL,4827.21,236.78,'Seat',6,130,'P4M',11,'DIESEL',140000,35265.09,180000,'New Alhambra Style2,0 tdi 150 pk','Pack technology / Pack executive',NULL,'ALUMINIUM'),(37,0,0,NULL,5689.32,241.08,'Audi',6,118,'P4M',11,'DIESEL',180000,41159.30,200000,'A6 avant 2,0 tdi 136 pk','pack executive fleet plus ',NULL,'ALUMINIUM'),(38,0,0,NULL,528.28,240.79,'Seat',7,130,'P4M',11,'DIESEL',140000,35862.03,180000,'New Alhambra Style2,0 tdi 150 pk','Pack technology / Pack executive/Alcantara zetels',NULL,'ALUMINIUM'),(39,0,0,NULL,1090.44,241.40,'Audi',7,114,'P4M',11,'DIESEL',180000,43328.04,200000,'A6 berline 2,0 tdi 150 pk','Pack executive fleet plus + pack lounge',NULL,'ALUMINIUM'),(40,0,0,NULL,3985.73,253.91,'Audi',7,114,'P4M',11,'DIESEL',180000,45574.16,200000,'A6 berline 2,0 tdi 190 pk','Pack executive fleet plus + pack lounge',NULL,'ALUMINIUM'),(41,0,0,NULL,3464.29,265.79,'Audi',7,118,'P4M',11,'DIESEL',180000,45378.84,200000,'A6 avant 2,0 tdi 150 pk','Pack executive fleet plus + pack lounge',NULL,'ALUMINIUM'),(42,0,0,NULL,3393.44,266.01,'Audi',7,129,'P6M',11,'DIESEL',180000,40044.08,200000,'Q5 2,0 tdi150 pk','Pack Adventure Plus / Pack Lounge',NULL,'ALUMINIUM'),(43,0,0,NULL,5625.56,282.35,'Audi',7,119,'P4M',11,'DIESEL',180000,47624.93,200000,'A6 Avant 2,0 tdi 190 pk','Pack executive fleet plus + pack lounge',NULL,'ALUMINIUM'),(44,0,0,NULL,3313.17,290.38,'VW',7,130,'P5M',11,'DIESEL',140000,43247.62,180000,'New Sharan Comfortline 2,0 tdi 150 pk ','Pack business / Velgen Toulon/ nappa leder/dynamic chassis control',NULL,'STEEL');

INSERT INTO `carmodel_optionsdefaultmap` VALUES (1,'\0',1),(1,'',2),(1,'',3),(2,'',2),(2,'',3),(3,'',2),(3,'',3),(4,'\0',1),(4,'',2),(4,'',3),(5,'\0',1),(5,'',2),(5,'',3),(6,'\0',1),(6,'',2),(6,'',3),(7,'\0',1),(7,'',2),(7,'',3),(8,'\0',1),(8,'',2),(8,'',3),(9,'',2),(9,'',3),(10,'\0',1),(10,'',2),(10,'',3),(11,'\0',1),(11,'',2),(11,'',3),(12,'\0',1),(12,'',2),(12,'',3),(13,'\0',1),(13,'',2),(13,'',3),(14,'\0',1),(14,'',2),(14,'',3),(15,'\0',1),(15,'',2),(15,'',3),(16,'\0',1),(16,'',2),(16,'',3),(17,'\0',1),(17,'',2),(17,'',3),(18,'\0',1),(18,'',2),(18,'',3),(19,'\0',1),(19,'',2),(19,'',3),(20,'\0',1),(20,'',2),(20,'',3),(21,'\0',1),(21,'',2),(21,'',3),(22,'\0',1),(22,'',2),(22,'',3),(23,'',2),(23,'',3),(24,'\0',1),(24,'',2),(24,'',3),(25,'\0',1),(25,'',2),(25,'',3),(26,'\0',1),(26,'',2),(26,'',3),(27,'\0',1),(27,'',2),(27,'',3),(28,'\0',1),(28,'',2),(28,'',3),(29,'\0',1),(29,'',2),(29,'',3),(30,'\0',1),(30,'',2),(30,'',3),(31,'\0',1),(31,'',2),(31,'',3),(32,'\0',1),(32,'',2),(32,'',3),(33,'\0',1),(33,'',2),(33,'',3),(34,'\0',1),(34,'',2),(34,'',3),(35,'\0',1),(35,'',2),(35,'',3),(36,'\0',1),(36,'',2),(36,'',3),(37,'\0',1),(37,'',2),(37,'',3),(38,'\0',1),(38,'',2),(38,'',3),(39,'\0',1),(39,'',2),(39,'',3),(40,'\0',1),(40,'',2),(40,'',3),(41,'\0',1),(41,'',2),(41,'',3),(42,'\0',1),(42,'',2),(42,'',3),(43,'\0',1),(43,'',2),(43,'',3),(44,'\0',1),(44,'',2),(44,'',3);

INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('1', '1-LCF-840', '0', 'NO_RENEWAL', '1');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('2', '1-LCP-621', '0', 'NO_RENEWAL', '1');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('3', '1-AAA-111', '0', 'NO_RENEWAL', '2');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('4', '1-BBB-111', '1200', 'NO_RENEWAL', '3');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('5', '1-CCC-222', '5000', 'NO_RENEWAL', '4');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('6', '1-FFF-888', '123215', 'NO_RENEWAL', '8');
INSERT INTO `fleet`.`physicalcar` (`id`, `licensePlate`, `mileage`, `renewalStatus`, `carModel_id`) VALUES ('7', '1-DDD-101', '555', 'NO_RENEWAL', '7');

INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('1', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('1', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('1', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('2', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('2', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('2', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('3', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('3', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('3', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('4', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('4', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('4', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('5', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('5', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('5', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('6', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('6', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('6', '3');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('7', '1');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('7', '2');
INSERT INTO `fleet`.`physicalcar_caroption` (`PhysicalCar_id`, `selectedCarOptions_id`) VALUES ('7', '3');




