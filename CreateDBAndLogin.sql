USE master
GO
CREATE DATABASE Truco
ON 
( NAME = 'Truco_dat',
   FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Truco.mdf',
   SIZE = 5 MB ,
   MAXSIZE = 50 MB,
   FILEGROWTH = 5 MB )
LOG ON
( NAME = 'Truco_log',
   FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Truco.ldf',
   SIZE = 2 MB,
   MAXSIZE = 50 MB,
   FILEGROWTH = 5 MB )
GO

create login Truco  with 
			password = '123456', 
			default_database = Truco,
			check_expiration = off,
			check_policy = off;

USE Truco
EXEC sp_changedbowner 'Truco'

