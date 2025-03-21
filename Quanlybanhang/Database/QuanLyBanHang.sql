USE [QuanLyBanHang]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[Admin_ID] [varchar](20) NOT NULL,
	[Admin_Name] [nvarchar](255) NOT NULL,
	[Gender] [varchar](10) NULL,
	[Email] [varchar](255) NULL,
	[Contact] [varchar](15) NOT NULL,
	[Password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Admin_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill_Exported]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill_Exported](
	[Invoice_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Total_Price] [decimal](15, 2) NOT NULL,
 CONSTRAINT [PK_Bill_Exported] PRIMARY KEY CLUSTERED 
(
	[Invoice_No] ASC,
	[Admin_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill_Exported_Details]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill_Exported_Details](
	[Invoice_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Order_No] [varchar](20) NOT NULL,
	[Customer_ID] [varchar](20) NOT NULL,
	[Product_ID] [varchar](20) NOT NULL,
	[IMei_No] [varchar](50) NOT NULL,
	[Unit_Price] [decimal](10, 2) NOT NULL,
	[Quantity] [int] NULL,
	[Discount_No] [varchar](50) NULL,
	[Total_Price_Before] [decimal](15, 2) NOT NULL,
	[Total_Price_After] [decimal](15, 2) NOT NULL,
	[Date_Exported] [date] NOT NULL,
	[Time_Exported] [time](7) NOT NULL,
 CONSTRAINT [PK_Bill_Exported_Details] PRIMARY KEY CLUSTERED 
(
	[Invoice_No] ASC,
	[Admin_ID] ASC,
	[Order_No] ASC,
	[Customer_ID] ASC,
	[Product_ID] ASC,
	[IMei_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill_Imported]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill_Imported](
	[Invoice_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Total_Price] [decimal](15, 2) NOT NULL,
 CONSTRAINT [PK_Bill_Imported] PRIMARY KEY CLUSTERED 
(
	[Invoice_No] ASC,
	[Admin_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill_Imported_Details]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill_Imported_Details](
	[Invoice_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Product_ID] [varchar](50) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Unit_Price] [decimal](10, 2) NOT NULL,
	[Total_Price] [decimal](10, 2) NOT NULL,
	[Date_Imported] [date] NOT NULL,
	[Time_Imported] [time](7) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[Category_ID] [varchar](50) NOT NULL,
	[Category_Name] [nvarchar](225) NOT NULL,
	[Sup_ID] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[Category_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Customer_ID] [varchar](20) NOT NULL,
	[Full_Name] [nvarchar](255) NOT NULL,
	[Gender] [varchar](10) NULL,
	[Date_Of_Birth] [date] NOT NULL,
	[Email] [varchar](255) NULL,
	[Contact] [varchar](15) NOT NULL,
	[Address] [nvarchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Customer_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[Discount_No] [varchar](50) NOT NULL,
	[Discount_Name] [nvarchar](255) NOT NULL,
	[Discount_Value] [varchar](20) NOT NULL,
	[Date_Started] [date] NOT NULL,
	[Date_Ended] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Discount_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IMei_Product]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IMei_Product](
	[IMei_No] [varchar](50) NOT NULL,
	[Product_ID] [varchar](50) NOT NULL,
	[State] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IMei_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IMei_Product_Stock]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IMei_Product_Stock](
	[IMei_No] [varchar](50) NOT NULL,
	[Product_ID] [varchar](50) NOT NULL,
	[State] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IMei_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Insurance]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Insurance](
	[Insurance_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Customer_ID] [varchar](20) NOT NULL,
	[Date_Insurance] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[Insurance_No] ASC,
	[Admin_ID] ASC,
	[Customer_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Insurance_Details]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Insurance_Details](
	[Insurance_No] [varchar](50) NOT NULL,
	[Admin_ID] [varchar](20) NOT NULL,
	[Customer_ID] [varchar](20) NOT NULL,
	[Product_ID] [varchar](50) NOT NULL,
	[IMei_No] [varchar](50) NOT NULL,
	[Description] [nvarchar](255) NOT NULL,
	[Date_Insurance] [date] NOT NULL,
	[Time_Insurance] [time](7) NOT NULL,
 CONSTRAINT [PK_InsuranceDetails] PRIMARY KEY CLUSTERED 
(
	[Insurance_No] ASC,
	[Admin_ID] ASC,
	[Customer_ID] ASC,
	[IMei_No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[Order_No] [varchar](20) NOT NULL,
	[Customer_ID] [varchar](20) NOT NULL,
	[Date_Order] [date] NULL,
	[Time_Order] [time](7) NULL,
PRIMARY KEY CLUSTERED 
(
	[Order_No] ASC,
	[Customer_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders_Details]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders_Details](
	[Order_No] [varchar](20) NOT NULL,
	[Customer_ID] [varchar](20) NOT NULL,
	[Product_ID] [varchar](20) NOT NULL,
	[Price] [decimal](10, 2) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Date_Order] [date] NOT NULL,
	[Time_Order] [time](7) NOT NULL,
	[Status] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Orders_Details] PRIMARY KEY CLUSTERED 
(
	[Order_No] ASC,
	[Customer_ID] ASC,
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[Product_ID] [varchar](50) NOT NULL,
	[Product_Name] [nvarchar](255) NOT NULL,
	[CPU] [varchar](100) NOT NULL,
	[Ram] [varchar](100) NOT NULL,
	[Graphics_Card] [varchar](100) NOT NULL,
	[Battery] [varchar](100) NOT NULL,
	[Weight] [varchar](100) NOT NULL,
	[Price] [decimal](10, 2) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Status] [varchar](20) NOT NULL,
	[Spoiled_Quantity] [int] NOT NULL,
	[Category_ID] [varchar](50) NULL,
	[Image] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_Stock]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Stock](
	[Product_ID] [varchar](50) NOT NULL,
	[Product_Name] [nvarchar](255) NOT NULL,
	[CPU] [varchar](100) NOT NULL,
	[Ram] [varchar](100) NOT NULL,
	[Graphics_Card] [varchar](100) NOT NULL,
	[Battery] [varchar](100) NOT NULL,
	[Weight] [varchar](100) NOT NULL,
	[Price] [decimal](10, 2) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Status] [varchar](20) NOT NULL,
	[Spoiled_Quantity] [int] NOT NULL,
	[Category_ID] [varchar](50) NULL,
	[Image] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Product_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Supplier]    Script Date: 16/03/2025 2:01:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Supplier](
	[Sup_ID] [varchar](100) NOT NULL,
	[Sup_Name] [nvarchar](250) NOT NULL,
	[Address] [nvarchar](255) NOT NULL,
	[Contact] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Sup_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bill_Exported_Details]  WITH CHECK ADD  CONSTRAINT [FK_Bill_Exported] FOREIGN KEY([Invoice_No], [Admin_ID])
REFERENCES [dbo].[Bill_Exported] ([Invoice_No], [Admin_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Bill_Exported_Details] CHECK CONSTRAINT [FK_Bill_Exported]
GO
ALTER TABLE [dbo].[Bill_Exported_Details]  WITH CHECK ADD  CONSTRAINT [FK_Discount] FOREIGN KEY([Discount_No])
REFERENCES [dbo].[Discount] ([Discount_No])
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[Bill_Exported_Details] CHECK CONSTRAINT [FK_Discount]
GO
ALTER TABLE [dbo].[Bill_Exported_Details]  WITH CHECK ADD  CONSTRAINT [FK_IMei_Product] FOREIGN KEY([IMei_No])
REFERENCES [dbo].[IMei_Product] ([IMei_No])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Bill_Exported_Details] CHECK CONSTRAINT [FK_IMei_Product]
GO
ALTER TABLE [dbo].[Bill_Exported_Details]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Details] FOREIGN KEY([Order_No], [Customer_ID], [Product_ID])
REFERENCES [dbo].[Orders_Details] ([Order_No], [Customer_ID], [Product_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Bill_Exported_Details] CHECK CONSTRAINT [FK_Orders_Details]
GO
ALTER TABLE [dbo].[Bill_Imported_Details]  WITH CHECK ADD  CONSTRAINT [FK_BillImported] FOREIGN KEY([Invoice_No], [Admin_ID])
REFERENCES [dbo].[Bill_Imported] ([Invoice_No], [Admin_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Bill_Imported_Details] CHECK CONSTRAINT [FK_BillImported]
GO
ALTER TABLE [dbo].[Bill_Imported_Details]  WITH CHECK ADD  CONSTRAINT [FK_Product] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product] ([Product_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Bill_Imported_Details] CHECK CONSTRAINT [FK_Product]
GO
ALTER TABLE [dbo].[IMei_Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_IMei] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product] ([Product_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[IMei_Product] CHECK CONSTRAINT [FK_Product_IMei]
GO
ALTER TABLE [dbo].[IMei_Product_Stock]  WITH CHECK ADD  CONSTRAINT [FK_Product_IMei_Stock] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product_Stock] ([Product_ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[IMei_Product_Stock] CHECK CONSTRAINT [FK_Product_IMei_Stock]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([Customer_ID])
REFERENCES [dbo].[Customer] ([Customer_ID])
GO
ALTER TABLE [dbo].[Bill_Exported_Details]  WITH CHECK ADD CHECK  (([Quantity]>(0)))
GO
ALTER TABLE [dbo].[Orders_Details]  WITH CHECK ADD CHECK  (([Quantity]>(0)))
GO
