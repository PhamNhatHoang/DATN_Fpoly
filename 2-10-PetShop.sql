use master
go
CREATE DATABASE PetShop
GO

USE PetShop
GO

CREATE TABLE PetCategory
(
  PetCategoryID int identity(1,1) NOT NULL PRIMARY KEY,
  PetCategoryName NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL
);


CREATE TABLE ProductCategory
(
  ProductCategoryID INT identity(1,1) NOT NULL PRIMARY KEY,
  ProductCategoryName NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL
);

CREATE TABLE Service
(
  ServiceID int identity(1,1) NOT NULL PRIMARY KEY,
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
  Enable bit not null,
  ActiveToken varchar(200) not null,
  DateCreated datetime not null,
);
CREATE TABLE Authorities
(
  Username VARCHAR(50),
  Authority VARCHAR(50),
  primary key (Username,Authority),
  foreign key (Username) references Users(UserName)
);

CREATE TABLE Pets
(
  PetID varchar(50) NOT NULL PRIMARY KEY,
  Breed NVARCHAR(255) NOT NULL,
  Age INT NOT NULL,
  Gender bit NOT NULL, 
  Price INT NOT NULL,
  PetDescription NVARCHAR(255) NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Famous nvarchar(255) not null,
  Hair nvarchar(255) not null,
  Enable bit not null,
  Available BIT NOT NULL,
  PetCategoryID INT NOT NULL,
  FOREIGN KEY (PetCategoryID) REFERENCES PetCategory(PetCategoryID)
);

create table OrderStatus
(
	OrderStatusID int identity(1,1) NOT NULL PRIMARY KEY,
	StatusName nvarchar(255) not null
)

create table PaymentStatus
(
	PaymentStatusID int identity(1,1) NOT NULL PRIMARY KEY,
	StatusPayment nvarchar(255) not null
)

CREATE TABLE Orders
(
  OrderID int identity(1,1) NOT NULL PRIMARY KEY,
  OrderDate DATE NOT NULL,
  ShippingAddress NVARCHAR(255),
  TotalAmount INT NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  Enable bit not null,
  OrderStatusID int NOT NULL,
  PaymentStatusID int not null,
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (OrderStatusID) REFERENCES OrderStatus(OrderStatusID),
  FOREIGN KEY (PaymentStatusID) REFERENCES PaymentStatus(PaymentStatusID)
);



CREATE TABLE Products
(
  ProductID int identity(1,1) NOT NULL PRIMARY KEY,
  ProductName NVARCHAR(255) NOT NULL,
  Price INT NOT NULL,
  Photo VARCHAR(255) NOT NULL,
  Available BIT NOT NULL, 
  Quantity int not null,
  ProductDescription NVARCHAR(255) NOT NULL,
  ProductCategoryID INT NOT NULL,
  FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);

CREATE TABLE Reviews
(
  ReviewID int identity(1,1) NOT NULL PRIMARY KEY,
  Comment NVARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  ProductID int NOT NULL,
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE BookingService
(
  BookServiceID int identity(1,1) NOT NULL PRIMARY KEY,
  NumberPhone NVARCHAR(20) NOT NULL,
  BookDate DATE NOT NULL,
  BookStatus NVARCHAR(50) NOT NULL,
  Note NVARCHAR(255) NOT NULL,
  UserName VARCHAR(50) NOT NULL,
  ServiceID INT NOT NULL,
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (ServiceID) REFERENCES Service(ServiceID)
);

CREATE TABLE Rating
(
  RatingID int identity(1,1) NOT NULL PRIMARY KEY,
  Number INT NOT NULL,
  ProductID INT NOT NULL,
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE OrderProductDetails
(
  OrderProductDetailID int identity(1,1) NOT NULL PRIMARY KEY,
  OrderID INT NOT NULL,
  ProductID INT NOT NULL,
  Quantity INT NOT NULL,
  Price INT NOT NULL,
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
  FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Voucher
(
  VoucherID int identity(1,1) NOT NULL PRIMARY KEY,
  Code VARCHAR(50) NOT NULL,
  Discount INT NOT NULL,
  ExpiryDate DATE NOT NULL,
  UserName VARCHAR(50) NOT NULL, 
  OrderID INT NULL, 
  FOREIGN KEY (UserName) REFERENCES Users(UserName),
  FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

CREATE TABLE SliderBar
(
    SliderId INT IDENTITY(1,1) PRIMARY KEY,
    SliderImage VARCHAR(30) NOT NULL
);


