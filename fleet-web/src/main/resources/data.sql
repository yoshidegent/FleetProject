INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `version`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`) VALUES ('Employee', '1', '1', 'yoshi.degent@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', NOW(), 'Yoshi', 'Developer', '5', NOW(), 'Degent');
INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `version`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`) VALUES ('Employee', '2', '1', 'dean.wyns@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', NOW(), 'Dean', 'Developer', '2', NOW(), 'Wyns');

INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('1', 'Employee');
INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('2', 'Employee');

INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('1', 'Towing Bracket');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('2', 'GPS');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('3', 'GSM Bluetooth');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('4', 'Rims');
