DROP TABLE IF EXISTS `OrderCustomer`;
CREATE TABLE `OrderCustomer` (
  `orderCustomerId` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `customerId` bigint(20) unsigned NOT NULL,
  `orderDate` datetime NOT NULL,
  PRIMARY KEY (`orderCustomerId`),
  FOREIGN KEY (`customerId`) REFERENCES `Customer`(`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;