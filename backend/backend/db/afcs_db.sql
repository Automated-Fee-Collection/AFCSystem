-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2025 at 04:09 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `afcs_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(10) NOT NULL,
  `username` varchar(50) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `phone`, `email`, `password`) VALUES
(1, 'Suleiman Suleiman', '255743900555', 'suleimansleiz@gmail.com', '#20SULEiman'),
(2, 'Simon Kitulo', '255623105568', 'kitulosy2@gmail.com', 'S1mkitulo@Ray');

-- --------------------------------------------------------

--
-- Table structure for table `arrivals`
--

CREATE TABLE `arrivals` (
  `id` bigint(100) NOT NULL,
  `plate` varchar(8) NOT NULL,
  `bus_name` varchar(30) NOT NULL,
  `arrival_time` datetime NOT NULL,
  `fee` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arrivals`
--

INSERT INTO `arrivals` (`id`, `plate`, `bus_name`, `arrival_time`, `fee`) VALUES
(1, 'T512 EGM', 'SHABIBY Line', '2025-05-14 04:43:34', 10000),
(2, 'T123 EBC', 'ABC Upper Class', '2025-05-14 05:27:38', 10000),
(3, 'T123 EBC', 'ABC Upper Class', '2025-05-14 12:56:18', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `plate` varchar(8) NOT NULL,
  `bus_name` varchar(50) NOT NULL,
  `bus_type` varchar(20) NOT NULL,
  `route` varchar(7) NOT NULL,
  `owner_phone` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`plate`, `bus_name`, `bus_type`, `route`, `owner_phone`) VALUES
('T123 EBC', 'ABC Upper Class', 'Yutong', 'Dom-Dar', '255743900555'),
('T224 EDO', 'Frester', 'Golden Dragon', 'DAR-BUK', '255743900555'),
('T305 ECC', 'Ally\'s Star Bus', 'Golden Dragon', 'DAR-MWZ', '255743900555'),
('T313 EAZ', 'New Force', 'Zhongtong', 'DAR-KAH', '255743900555'),
('T389 EJN', 'Happy Nation express', 'Higer', 'DAR-MWZ', '255743900555'),
('T512 EGM', 'SHABIBY Line', 'Yutong', 'Dom-Dar', '255627169452');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `id` bigint(100) NOT NULL,
  `plate` varchar(8) NOT NULL,
  `bus_name` varchar(30) NOT NULL,
  `arrival_time` datetime NOT NULL,
  `fee` double NOT NULL,
  `payment_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `arrivals`
--
ALTER TABLE `arrivals`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`plate`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `arrivals`
--
ALTER TABLE `arrivals`
  MODIFY `id` bigint(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
