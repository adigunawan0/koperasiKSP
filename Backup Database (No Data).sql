USE [master]
GO

/****** Object:  Database [sylvahotel]    Script Date: 29/09/2022 09:23:31 ******/
CREATE DATABASE KoperasiKSP
GO

USE [KoperasiKSP]
GO

CREATE TABLE Account(
	[Username] [varchar](255) NOT NULL,
	[Password] [varchar](255) NOT NULL,
	[Role] [varchar](255) NOT NULL,
	[Name] [varchar](255) NOT NULL,
	[Address] [varchar](255) NOT NULL,
	[Email] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE Pengajuan(
	[Id] [bigint] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[Username] [varchar](255) FOREIGN KEY REFERENCES Account(Username),
	[Nominal] [numeric](19, 2) NOT NULL,
	[Keterangan] [varchar](255) NULL,
	[Start_Date] [date] NULL,
	[End_Date] [date] NULL)
GO

CREATE TABLE Transaksi(
	[Id] [bigint] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[PengajuanId] [bigint] FOREIGN KEY REFERENCES Pengajuan(Id),
	[Nominal] [numeric](19, 2) NOT NULL,
	[Keterangan] [varchar](255) NULL,
	[Tanggal] [date] NOT NULL)
GO

CREATE TABLE Riwayat(
	[Id] [bigint] IDENTITY(1,1) NOT NULL PRIMARY KEY,
	[PengajuanId] [bigint] FOREIGN KEY REFERENCES Pengajuan(Id),
	[Keterangan] [varchar](255) NOT NULL,
	[Tanggal] [date] NOT NULL)
GO