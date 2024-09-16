CREATE DATABASE PetShop
GO

USE PetShop
GO

CREATE TABLE PetCategory
(
  PetCategoryID INT NOT NULL PRIMARY KEY,
  PetCategoryName NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL
);

CREATE TABLE Authorities
(
  AuthID INT NOT NULL PRIMARY KEY,
  RoleName NVARCHAR(50) NOT NULL
);

CREATE TABLE ProductCategory
(
  ProductCategoryID INT NOT NULL PRIMARY KEY,
  ProductCategoryName NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL
);

CREATE TABLE Service
(
  ServiceID INT NOT NULL PRIMARY KEY,
  ServiceName NVARCHAR(255) NOT NULL,
  Price INT NOT NULL,
  Description NVARCHAR(255) NOT NULL
);

CREATE TABLE Users
(
  UserName VARCHAR(50) NOT NULL PRIMARY KEY,
  UserPassword NVARCHAR(50) NOT NULL,
  FullName NVARCHAR(50) NOT NULL,
  Email NVARCHAR(50) NOT NULL,
  PhoneNumber NVARCHAR(20) NOT NULL,
  UserAddress NVARCHAR(255) NOT NULL,
  AuthID INT NOT NULL,
  Enable bit not null,
  ActiveToken varchar(200) not null,
  DateCreated datetime not null,
  FOREIGN KEY (AuthID) REFERENCES Authorities(AuthID)
);

CREATE TABLE Pets
(
  PetID varchar NOT NULL PRIMARY KEY,
  Breed NVARCHAR(255) NOT NULL,
  Age INT NOT NULL,
  Gender bit NOT NULL,  -- Sử dụng CHAR(1) cho giới tính rõ ràng hơn
  Price INT NOT NULL,
  PetDescription NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Available BIT NOT NULL,
  PetCategoryID INT NOT NULL,
  FOREIGN KEY (PetCategoryID) REFERENCES PetCategory(PetCategoryID)
);


CREATE TABLE Orders
(
  OrderID INT NOT NULL PRIMARY KEY,
  OrderDate DATE NOT NULL,
  OrderStatus NVARCHAR(50) NOT NULL,
  ShippingAddress NVARCHAR(255),
  TotalAmount INT NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  Enable bit not null,
  FOREIGN KEY (UserName) REFERENCES Users(UserName)
);

CREATE TABLE Reviews
(
  ReviewID INT NOT NULL PRIMARY KEY,
  Comment NVARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  PetID VARCHAR NOT NULL,
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE PetImage
(
  PetImageID INT NOT NULL PRIMARY KEY,
  Photo VARCHAR(255) NOT NULL,
  PetID VARCHAR NOT NULL,
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE Products
(
  ProductID INT NOT NULL PRIMARY KEY,
  ProductName NVARCHAR(255) NOT NULL,
  Price INT NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Available BIT NOT NULL,  -- Sửa lỗi chính tả từ 'Avaliable' thành 'Available'
  ProductDescription NVARCHAR(255) NOT NULL,
  ProductCategoryID INT NOT NULL,
  FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);

CREATE TABLE BookingService
(
  BookServiceID INT NOT NULL PRIMARY KEY,
  NumberPhone NVARCHAR(20) NOT NULL,
  BookDate DATE NOT NULL,
  BookStatus NVARCHAR(50) NOT NULL,
  Note NVARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  ServiceID INT NOT NULL,
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID)
);

CREATE TABLE PetHair
(
  PetHairID INT NOT NULL PRIMARY KEY,
  PetHairName NVARCHAR(255) NOT NULL,
  PetID VARCHAR NOT NULL,
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE PetFamous
(
  PetFamousID INT NOT NULL PRIMARY KEY,
  PetFamousName NVARCHAR(255) NOT NULL,
  PetID VARCHAR NOT NULL,
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE Rating
(
  RatingID INT NOT NULL PRIMARY KEY,
  Number INT NOT NULL,
  ReviewID INT NOT NULL,
  FOREIGN KEY (ReviewID) REFERENCES Reviews(ReviewID)
);

CREATE TABLE OrderPetDetails
(
  OrderPetDetailID INT NOT NULL PRIMARY KEY,
  OrderID INT NOT NULL,
  PetID VARCHAR NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (PetID) REFERENCES Pets(PetID)
);

CREATE TABLE OrderProductDetails
(
  OrderProductDetailID INT NOT NULL PRIMARY KEY,
  OrderID INT NOT NULL,
  ProductID INT NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Voucher
(
  VoucherID INT NOT NULL PRIMARY KEY,
  Code VARCHAR(50) NOT NULL,
  Discount INT NOT NULL,
  ExpiryDate DATE NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  OrderPetDetailID INT NULL,  
  OrderProductDetailID INT NULL, 
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (OrderPetDetailID) REFERENCES OrderPetDetails(OrderPetDetailID),
  FOREIGN KEY (OrderProductDetailID) REFERENCES OrderProductDetails(OrderProductDetailID)
);

CREATE TABLE SliderBar
(
    SliderId INT IDENTITY(1,1) PRIMARY KEY,
    SliderImage VARCHAR(30) NOT NULL
);


