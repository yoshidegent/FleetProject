INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`, `active`) VALUES ('Employee', '1', 'yoshi.degent@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', '1993-10-19', 'Yoshi', 'Developer', '2', '2015-09-01', 'Degent', 1);
INSERT INTO `fleet`.`user` (`DTYPE`, `id`, `email`, `password`, `dateOfBirth`, `firstName`, `function`, `functionalLevel`, `hireDate`, `lastName`, `active`) VALUES ('Employee', '2', 'dean.wyns@realdolmen.com', '$2a$04$4.QXaVbhnR7MR58foRJxROca5yY1qLvN2KkZFdo980vpCep3P5/Lm', '1994-09-30', 'Dean', 'Developer', '2', '2015-09-01', 'Wyns', 1);

INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('1', 'Employee');
INSERT INTO `fleet`.`user_roles` (`User_id`, `roles`) VALUES ('2', 'Employee');

INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('1', 'Towing bracket');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('2', 'GPS');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('3', 'GSM Bluetooth');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('4', 'Rims');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('5', 'Leather interior');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('6', 'Cruise control');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('7', 'Authomatic');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('8', 'Park sensors');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('9', 'Tinted windows');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('10', 'Roof rails');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('11', 'Heated seats');
INSERT INTO `fleet`.`caroption` (`id`, `name`) VALUES ('12', '7-seats');
