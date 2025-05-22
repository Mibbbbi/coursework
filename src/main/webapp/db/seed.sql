-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 08:21 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotelbooking`
--

--
--
-- Dumping data for table `user`

INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `contact`, `Email`, `Role`, `password`, `user_name`) VALUES
(112, 'Lomas', 'Gurung', 987654433, 'lomasGuru@gmail.com', 'Admin', '3g/lfhlpRHWVva39yqltKA==', 'lowGuru'),
(118, 'Saurav', 'Shrestha', 90000000, 'saurav.shrestha.2.a23@icp.edu.np', 'user', 'NKPwitKwMi6OIo4QbYSFpw==', 'robsus'),
(119, 'Pantheon', 'Minister', 980463025, 'panth12341@gmail.com', 'Admin', 'UtLjGZ3qOxOSix0eac0/pQ==', 'testpanth'),
(121, 'Mike', 'Russell', 98050314050, 'mell213@gmail.com', 'user', 'wHJofTck+jvgX3tcMVWm+w==', 'muller'),
(122, 'Ashik', 'Gurung', 9000000, 'asdasda@gmail.com', 'staff', 'NKPwitKwMi6OIo4QbYSFpw==', 'sickMan'),
(123, 'Ayush', 'shrestha', 912312312, 'ayosh@gmail.com', 'staff', 'gvMbXMoErJG80yo/3Hikuw==', 'ayosh'),
(124, 'John', 'Cena', 98888888888, 'youcantseeme@gmail.com', 'user', 'pqAcUy++BHmfo8TEvNAgxw==', 'cantSeenow'),
(125, 'Prabin', 'Bugati', 9898989898, 'prabin@gmail.com', 'user', '8uuQ14XiDxy0GMoQPLyo5g==', 'bugati420'),
(126, 'akrit', 'thapa', 9888888111, 'akritThaps@gmail.com', 'user', 'mRZwCqGukqF2BBHkY03y0w==', 'icritdmg'),
(127, 'sabina', 'pahadi', 9999991111, 'pahda@gmail.com', 'user', 'vmt9KXpMtHVbIxaNPcrXeQ==', 'solowin');

-- Dumping data for table `room`

INSERT INTO `room` (`Room_ID`, `Status`, `description`, `category`, `image_path`, `price`) VALUES
(1, 'Available', 'Small Standard Room - cozy and comfortable, ideal for solo travelers or short stays. Includes a single bed, compact work desk and a modern bathroom with walk-in shower.', 'small', 'photos\\room_1.jpg', 3500),
(2, 'Available', 'Small Standard Room - cozy and comfortable, ideal for solo travelers or short stays.<br> Includes a single bed, compact work desk and a modern bathroom with walk-in shower.', 'small', 'photos\\room_2.jpg', 3500),
(3, 'Available', 'Small Deluxe Room- Efficiently designed with stylish interiors, featuring a double bed, carpet flooring flat screen TV, free Wi-Fi. Perfect for budget conscious guests and couples.', 'small', 'photos\\room_3.jpeg', 4500),
(4, 'Available', 'Small Deluxe Room- Efficiently designed with stylish interiors, featuring a double bed, flat screen TV and complementary high-speed Wi-Fi. Perfect for budget conscious guests', 'small', 'photos\\room_4.jpg', 5000),
(5, 'Available', '-Comfortable and spacious with a queen-size bed, seating area and ample natural light. Great for couples or extended stays.', 'medium', 'photos\\room_5.png', 6500),
(6, 'Available', 'Comfortable and spacious with a queen-size bed, seating area and ample natural light. Great for couples or extended stays.', 'medium', 'photos\\room_6.jpg', 8500),
(7, 'Available', 'clean and comfortable room with well-ventilated and attached bathroom with WI-FI connection, with a perfect queen sized bed. A medium room so well furnished and standard.', 'medium', 'photos\\room_7.jpeg', 10000),
(8, 'Available', 'comfortable room with well-ventilated and attached bathroom with Wi-Fi connection. A well touch of bright color to make you feel positive and comfortable bed to relax. A maple wood flooring to give a different feel when you walk on it.', 'medium', 'photos\\room_8.jpg', 9000),
(101, 'Available', 'medium room \r\nperfect for couple\r\n2-3 people\r\nRoom delivery (Rs.1000 per call)', 'medium', '/Agnom\\photos\\luxuryroom.avif', 10000),
(102, 'Available', 'asasdad', 'good, fun, small', '/Agnom\\photos\\maldives.avif', 10000),
(103, 'booked', 'Best for a big family\r\nTake your pa, Take your Ma\r\nTake your grand parents, take your neighbor \r\nthe fun is pack, you will lose your time\' track.', 'large', '/Agnom\\photos\\classic_room.jpg', 100000),
(104, 'Available', 'A well-furnished room with an AC and a 24/7 Wi-Fi connection including a 50 inch Oled TV and that unique wood flooring to make you stay feel different and a bright environment to make you feel like on the best place. ', 'medium', 'photos\\room_9.jpeg', 14000),
(105, 'Available', 'A well-furnished room with a sleek marble design, includes  an AC and a 24/7 Wi-Fi connection including a 50 inch Oled TV. A standard wooden design.', 'large', 'photos\\room_10.jpg', 15000),
(111, 'Available', 'our room might be mid but the experience it provides wont be mid \r\n\r\nwelcome to the Medium room 111, when everything is 1.', 'medium', 'photos\\room111.png', 11111),
(201, 'Available', 'high ground advantage for better view and fun <br>\r\nwe guaranteed you with a trampoline at the window if you want some adventure <br>\r\nand hospital staff standby if it goes wrong', 'large', 'photos\\room_13.png', 10000),
(202, 'Available', 'this is a special room for business meetings <br>\r\nproviding: <br>\r\nA quiet surrondings <br>\r\nisolated room', 'large', 'photos\\room_12.jpg', 50000),
(300, 'Available', 'it is roof top room with brilliant views', 'large', 'photos\\room300.webp', 20000);

-- Dumping data for table `bookings`

INSERT INTO `bookings` (`booking_id`, `user_id`, `room_id`, `booking_date`, `expire_date`, `clockIn_Date`, `clockOut_Date`, `total_cost`) VALUES
(1, 122, 102, '2025-05-09', '2025-05-15', NULL, NULL, 10000),
(102, 118, 103, '2025-05-18', '2025-06-07', '2025-05-19', '2025-05-19', 2000000),
(104, 118, 103, '2025-05-19', '2025-05-29', NULL, '2025-05-19', 1000000),
(105, 118, 102, '2025-05-19', '2025-06-08', '2025-05-19', '2025-05-19', 200000),
(106, 118, 102, '2025-05-21', '2025-05-31', NULL, '2025-05-21', 100000),
(107, 112, 111, '2025-05-21', '2025-05-31', '2025-05-21', '2025-05-21', 111110);

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`Issue_ID`, `room_id`, `Issue_Date`, `Issue_Description`, `Issue_type`, `solve_status`, `user_id`, `solvedBy`) VALUES
(126, 101, '2025-05-21 12:00:00', 'it ok', 'issue', 'notSolved', 118, NULL),
(130, 1, '2025-05-22 11:51:19', 'small i cant find my belonging in the room.', 'issue', 'notSolved', 118, NULL),
(131, 2, '2025-05-22 11:52:08', 'great compare to room 1 but could use some more lighting', 'feedback', 'notSolved', 118, NULL),
(132, 300, '2025-05-22 11:53:26', 'it was raining so need better roofing', 'issue', 'notSolved', 123, NULL),
(133, 201, '2025-05-22 11:58:51', 'it was nice but the bathroom tap was leaking ', 'issue', 'notSolved', 124, NULL);

--
--


--
--

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
