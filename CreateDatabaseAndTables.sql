USE [master]
GO

CREATE DATABASE [Truco]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Truco', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Truco.mdf' , SIZE = 5120KB , MAXSIZE = 51200KB , FILEGROWTH = 5120KB )
 LOG ON 
( NAME = N'Truco_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Truco_log.ldf' , SIZE = 1280KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

USE [Truco]
GO

CREATE TABLE Jugadores (
	IdJugador int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Email varchar(50) NOT NULL,
	Apodo varchar(50) NOT NULL,
	Categoria varchar(20) NOT NULL,
	Contraseña varchar(50) NOT NULL,
	CantidadPartidas int,
	Puntos int
);

CREATE TABLE Ranking (
	IdRanking int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Puntos int
);

CREATE TABLE Grupos (
	IdGrupo int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Nombre varchar(50) NOT NULL,
	Administrador int NOT NULL,
	IdRanking int FOREIGN KEY REFERENCES Ranking(IdRanking)
);



CREATE TABLE Parejas (
	IdPareja int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	IdJugador1 int FOREIGN KEY REFERENCES Jugadores(IdJugador),
	IdJugador2 int FOREIGN KEY REFERENCES Jugadores(IdJugador)
);

CREATE TABLE Juegos(
	IdJuego int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	IdPareja1 int FOREIGN KEY REFERENCES Parejas(IdPareja),
	IdPareja2 int FOREIGN KEY REFERENCES Parejas(IdPareja),
	PuntosPareja1 int,
	PuntosPareja2 int
);

CREATE TABLE Partidas(
	IdPartida int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	IdJugador1 int FOREIGN KEY REFERENCES Jugadores(IdJugador),
	IdJugador2 int FOREIGN KEY REFERENCES Jugadores(IdJugador),
	IdJugador3 int FOREIGN KEY REFERENCES Jugadores(IdJugador),
	IdJugador4 int FOREIGN KEY REFERENCES Jugadores(IdJugador)
);

CREATE TABLE Envites(
	IdEnvites int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Nombre varchar(30),
	Valor int
);

CREATE TABLE Mano(
	IdMano int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	IdPartida int FOREIGN KEY REFERENCES Partidas(IdPartida),
	PuntosPareja1 int,
	PuntosPareja2 int,
	IdEnvites int FOREIGN KEY REFERENCES Envites(IdEnvites)
);

CREATE TABLE Mazo(
	-- Como conectamos las cartas del mazo con otra tabla?
	IdCarta int IDENTITY(1,1) NOT NULL PRIMARY KEY,
	Valor int, 
	Palo int, 
	Rango int
);

CREATE TABLE Baza (
	IdBaza int IDENTITY (1,1) NOT NULL PRIMARY KEY,
	IdMano int FOREIGN KEY REFERENCES Mano(IdMano),
	--Hay que meter las cartas aca o en mano ?
);




