USE master;
GO

CREATE DATABASE PetShop;
GO

USE PetShop;
GO

CREATE TABLE ProductCategory
(
    ProductCategoryID    INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    ProductCategoryName  NVARCHAR(255)         NOT NULL,
    Photo                VARCHAR(255)          NOT NULL
);

CREATE TABLE Service
(
    ServiceID            INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    ServiceName          NVARCHAR(255)         NOT NULL,
    Price                INT NOT NULL,
    Description          NVARCHAR(255)         NOT NULL
);

CREATE TABLE Users
(
    UserName             VARCHAR(50)          NOT NULL        PRIMARY KEY,
    UserPassword         NVARCHAR(100)         NOT NULL,
    FullName             NVARCHAR(50)          NOT NULL,
    Email                NVARCHAR(50)          NOT NULL,
    PhoneNumber          NVARCHAR(20)          NOT NULL,
    UserAddress          NVARCHAR(255)         NOT NULL,
    Enable               BIT NOT NULL,
    ActiveToken          VARCHAR(200)          NOT NULL,
    DateCreated          DATETIME NOT NULL
);

CREATE TABLE Roles 
(
    Id                   VARCHAR(50)          PRIMARY KEY,
    Name                 VARCHAR(50)          NOT NULL
);

CREATE TABLE Authorities
(
    Id                   INT IDENTITY(1,1)    PRIMARY KEY,
    UserName             VARCHAR(50),
    RoleId               VARCHAR(50),
    FOREIGN KEY (RoleId) REFERENCES Roles(Id),
    FOREIGN KEY (UserName) REFERENCES Users(UserName)
);

CREATE TABLE Pets
(
    PetID                VARCHAR(50)          NOT NULL        PRIMARY KEY,
    Breed                NVARCHAR(255)         NOT NULL,
    Age                  INT NOT NULL,
    Gender               BIT NOT NULL,
    Price                INT NOT NULL,
    PetDescription       NVARCHAR(255)         NOT NULL,
    Photo                VARCHAR(255)          NOT NULL,
    Famous               NVARCHAR(255)         NOT NULL,
    Hair                 NVARCHAR(255)         NOT NULL,
    Enable               BIT NOT NULL,
    Available            BIT NOT NULL,
    PetCategoryID        INT NOT NULL,
    FOREIGN KEY (PetCategoryID) REFERENCES PetCategory(PetCategoryID)
);

CREATE TABLE OrderStatus
(
    OrderStatusID        INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    StatusName           NVARCHAR(255)         NOT NULL
);

CREATE TABLE PaymentStatus
(
    PaymentStatusID      INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    StatusPayment        NVARCHAR(255)         NOT NULL
);

CREATE TABLE Orders
(
    OrderID              INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    OrderDate            DATE NOT NULL,
    ShippingAddress      NVARCHAR(255),
    TotalAmount          INT NOT NULL,
    UserName             VARCHAR(50)          NOT NULL,
    Enable               BIT NOT NULL,
    OrderStatusID        INT NOT NULL,
    PaymentStatusID      INT NOT NULL,
    FOREIGN KEY (UserName) REFERENCES Users(UserName),
    FOREIGN KEY (OrderStatusID) REFERENCES OrderStatus(OrderStatusID),
    FOREIGN KEY (PaymentStatusID) REFERENCES PaymentStatus(PaymentStatusID)
);

CREATE TABLE Products
(
    ProductID            INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    ProductName          NVARCHAR(255)         NOT NULL,
    Price                INT NOT NULL,
    Photo                VARCHAR(255)          NOT NULL,
    Available            BIT NOT NULL,
    Quantity             INT NOT NULL,
    ProductDescription    NVARCHAR(255)        NOT NULL,
    ProductCategoryID    INT NOT NULL,
    FOREIGN KEY (ProductCategoryID) REFERENCES ProductCategory(ProductCategoryID)
);

CREATE TABLE Reviews
(
    ReviewID             INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    Comment              NVARCHAR(255)         NOT NULL,
    UserName             VARCHAR(50)          NOT NULL,
    ProductID            INT NOT NULL,
    FOREIGN KEY (UserName) REFERENCES Users(UserName),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Rating
(
    RatingID             INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    Number               INT NOT NULL,
    ProductID            INT NOT NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE OrderProductDetails
(
    OrderProductDetailID  INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    OrderID               INT NOT NULL,
    ProductID             INT NOT NULL,
    Quantity              INT NOT NULL,
    Price                 INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)
);

CREATE TABLE Voucher
(
    VoucherID            INT IDENTITY(1,1)    NOT NULL        PRIMARY KEY,
    Code                 VARCHAR(50)          NOT NULL,
    Discount             INT NOT NULL,
    ExpiryDate           DATE NOT NULL,
    UserName             VARCHAR(50)          NOT NULL, 
    OrderID              INT NULL, 
    FOREIGN KEY (UserName) REFERENCES Users(UserName),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

CREATE TABLE SliderBar
(
    SliderId             INT IDENTITY(1,1)    PRIMARY KEY,
    SliderImage          VARCHAR(30)          NOT NULL
);