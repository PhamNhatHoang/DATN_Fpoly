CREATE DATABASE PetShop
go

CREATE TABLE PetCategory
(
  PetCategoryID INT NOT NULL,
  PetCategoryName VARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  PRIMARY KEY (PetCategoryID)
);

CREATE TABLE Authorities
(
  AuthID INT NOT NULL,
  RoleName VARCHAR(50) NOT NULL,
  PRIMARY KEY (AuthID)
);

CREATE TABLE ProductCategory
(
  ProductCategoryID INT NOT NULL,
  ProductCategoryName VARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  PRIMARY KEY (ProductCategoryID)
);

CREATE TABLE Service
(
  ServiceID INT NOT NULL,
  ServiceName VARCHAR(255) NOT NULL,
  Price INT NOT NULL,
  Description VARCHAR(255) NOT NULL,
  PRIMARY KEY (ServiceID)
);

CREATE TABLE Users
(
  UserName VARCHAR(50) NOT NULL,
  UserPassword VARCHAR(50) NOT NULL,
  FullName VARCHAR(50) NOT NULL,
  Email VARCHAR(50) NOT NULL,
  PhoneNumber VARCHAR(20) NOT NULL,
  UserAddress VARCHAR(255) NOT NULL,
  AuthID INT NOT NULL,
  PRIMARY KEY (UserName),
  FOREIGN KEY (AuthID) REFERENCES Authorities(AuthID)
);

CREATE TABLE Pets
(
  PetID INT NOT NULL,
  Breed VARCHAR(255) NOT NULL,
  Age INT NOT NULL,
  Gender INT NOT NULL,
  Price INT NOT NULL,
  PetDescription VARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Available VARCHAR(50) NOT NULL,
  PetCategoryID INT NOT NULL,
  PRIMARY KEY (PetID),
  FOREIGN KEY (PetCategoryID) REFERENCES PetCategory(PetCategoryID)
);

CREATE TABLE Orders
(
  OrderID INT NOT NULL,
  OrderDate DATE NOT NULL,
  OrderStatus VARCHAR(50) NOT NULL,
  ShippingAddress VARCHAR(255) NOT NULL,
  TotalAmount INT NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  PRIMARY KEY (OrderID),
  FOREIGN KEY (UserName) REFERENCES Users(UserName)
);

CREATE TABLE Reviews
(
  ReviewID INT NOT NULL,
  Comment VARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  PetID INT NOT NULL,
  PRIMARY KEY (ReviewID),
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE PetImage
(
  PetImageID INT NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  PetID INT NOT NULL,
  PRIMARY KEY (PetImageID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE Products
(
  ProductID INT NOT NULL,
  ProductName VARCHAR(255) NOT NULL,
  Price INT NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Avaliable VARCHAR(255) NOT NULL,
  ProductDescription VARCHAR(255) NOT NULL,
  ProductCategoryID INT NOT NULL,
  PRIMARY KEY (ProductID),
  FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);

CREATE TABLE BookService
(
  BookServiceID INT NOT NULL,
  NumberPhone VARCHAR(20) NOT NULL,
  BookDate DATE NOT NULL,
  BookStatus VARCHAR(50) NOT NULL,
  Note VARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  ServiceID INT NOT NULL,
  PRIMARY KEY (BookServiceID),
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID)
);

CREATE TABLE PetHair
(
  PetHairID INT NOT NULL,
  PetHairName VARCHAR(255) NOT NULL,
  PetID INT NOT NULL,
  PRIMARY KEY (PetHairID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE PetFamus
(
  PetFamusID INT NOT NULL,
  PetFamusName VARCHAR(255) NOT NULL,
  PetID INT NOT NULL,
  PRIMARY KEY (PetFamusID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE Rating
(
  RatingID INT NOT NULL,
  Number INT NOT NULL,
  ReviewID INT NOT NULL,
  PRIMARY KEY (RatingID),
  FOREIGN KEY (ReviewID) REFERENCES Reviews(ReviewID)
);

CREATE TABLE Voucher
(
  VoucherID INT NOT NULL,
  Code VARCHAR(50) NOT NULL,
  Discount INT NOT NULL,
  ExpiryDate DATE NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  OrderID INT,
  PRIMARY KEY (VoucherID),
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);
/*
CREATE TABLE OrderDetails
(
  OrderDetailID INT NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  PetID INT NOT NULL,
  OrderID INT NOT NULL,
  ProductID INT NOT NULL,
  PRIMARY KEY (OrderDetailID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
*/
CREATE TABLE OrderPetDetails
(
  OrderPetDetailID INT NOT NULL,
  OrderID INT NOT NULL,
  PetID INT NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  PRIMARY KEY (OrderPetDetailID),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);
CREATE TABLE OrderProductDetails
(
  OrderProductDetailID INT NOT NULL,
  OrderID INT NOT NULL,
  ProductID INT NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  PRIMARY KEY (OrderProductDetailID),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);
