CREATE TABLE `moeda` (
                         `moeCodi` varchar(36) NOT NULL,
                         `moeNome` varchar(50) NOT NULL,
                         `moeSimb` varchar(5) DEFAULT NULL,
                         PRIMARY KEY (`moeCodi`)
) ENGINE=InnoDB;


INSERT INTO `moeda` (`moeCodi`,`moeNome`,`moeSimb`) VALUES
('693b7986-c6fc-11eb-89c3-4d9f3735665f','Real','BRL'),
('693c79d0-c6fc-11eb-89c3-4d9f3735665f','Dolar','USD'),
('693c8cfe-c6fc-11eb-89c3-4d9f3735665f','Euro','EUR');
