CREATE TABLE `driver` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateCreated` Date ,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `latitude` float ,
  `longitude` float,
  `dateCoordinateUpdated` Date ,
  `onlineStatus`  Enum('BUSY' , 'AVAILABLE'),
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ;

INSERT INTO `driver` (`dateCreated`,`userName`,`password`,`latitude`,`longitude`, `dateCoordinateUpdated` ,`onlineStatus`) VALUES (
(now(),'Driver1', SHA1('passDriver1'),25.56 ,45.43, '', 'AVAILABLE'),
(now(),'Driver2', SHA1('passDriver2'),56.60 ,75.30, '', 'AVAILABLE'),
(now(),'Driver3', SHA1('passDriver3'),32.56 ,68.78, '', 'AVAILABLE'),
(now(),'Driver4', SHA1('passDriver4'),10.62 ,61.83, '', 'AVAILABLE'),
(now(),'Driver5', SHA1('passDriver5'),18.56 ,65.73, '', 'AVAILABLE'),
(now(),'Driver6', SHA1('passDriver6'),78.36 ,64.81, '', 'AVAILABLE'));

CREATE TABLE `order` (
  `orderNo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateCreated` Date ,
  `customerName` varchar(255) DEFAULT NULL,
  `latitude` float ,
  `longitude` float,
  PRIMARY KEY (`orderNo`)
) ;

INSERT INTO `order` (`dateCreated`,`customerName`,`latitude`,`longitude`) VALUES (
(now(),'Cust1',15.56 ,35.43),
(now(),'Cust2',46.60 ,65.30),
(now(),'Cust3',22.56 ,58.78),
(now(),'Cust4',12.62 ,41.83),
(now(),'Cust5',17.56 ,55.73),
(now(),'Cust6',68.36 ,54.81));
