-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2023 at 08:13 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `roomease`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_action_log`
--

CREATE TABLE `admin_action_log` (
  `log_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `action_description` varchar(255) NOT NULL,
  `action_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `admin_login_log`
--

CREATE TABLE `admin_login_log` (
  `log_id` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `log_type` enum('LOGIN','LOGOUT') NOT NULL,
  `log_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin_login_log`
--

INSERT INTO `admin_login_log` (`log_id`, `admin_id`, `log_type`, `log_time`) VALUES
(1, 1, 'LOGIN', '2023-05-08 20:23:44'),
(2, 1, 'LOGIN', '2023-05-08 21:15:16'),
(3, 1, 'LOGOUT', '2023-05-08 21:15:18'),
(4, 2, 'LOGIN', '2023-05-08 21:15:34'),
(5, 2, 'LOGOUT', '2023-05-08 21:15:39'),
(6, 2, 'LOGIN', '2023-05-08 21:16:03'),
(7, 1, 'LOGIN', '2023-05-08 23:57:35'),
(8, 1, 'LOGIN', '2023-05-09 00:08:29'),
(9, 1, 'LOGOUT', '2023-05-09 00:08:30'),
(10, 1, 'LOGIN', '2023-05-09 11:32:25'),
(11, 1, 'LOGOUT', '2023-05-09 11:32:43'),
(12, 1, 'LOGIN', '2023-05-09 11:39:03'),
(13, 1, 'LOGIN', '2023-05-09 14:52:58'),
(14, 1, 'LOGOUT', '2023-05-09 14:53:01'),
(15, 1, 'LOGIN', '2023-05-09 14:54:20'),
(16, 1, 'LOGOUT', '2023-05-09 14:54:35'),
(17, 1, 'LOGIN', '2023-05-09 14:55:21'),
(18, 1, 'LOGIN', '2023-05-09 14:59:00'),
(19, 1, 'LOGIN', '2023-05-09 15:01:02'),
(20, 1, 'LOGIN', '2023-05-09 15:02:34'),
(21, 1, 'LOGIN', '2023-05-09 15:04:25'),
(22, 1, 'LOGIN', '2023-05-09 15:05:24'),
(23, 1, 'LOGIN', '2023-05-09 15:06:56'),
(24, 1, 'LOGOUT', '2023-05-09 15:06:58'),
(25, 1, 'LOGIN', '2023-05-09 15:07:13'),
(26, 1, 'LOGOUT', '2023-05-09 15:07:23'),
(27, 1, 'LOGIN', '2023-05-09 15:42:46'),
(28, 1, 'LOGOUT', '2023-05-09 15:42:47'),
(29, 1, 'LOGOUT', '2023-05-09 15:44:27'),
(30, 1, 'LOGIN', '2023-05-09 15:44:33'),
(31, 1, 'LOGOUT', '2023-05-09 15:44:41'),
(32, 1, 'LOGIN', '2023-05-09 15:46:06'),
(33, 1, 'LOGOUT', '2023-05-09 15:46:08'),
(34, 1, 'LOGIN', '2023-05-09 15:52:08'),
(35, 1, 'LOGIN', '2023-05-09 16:03:19'),
(36, 1, 'LOGIN', '2023-05-09 17:27:06'),
(37, 1, 'LOGOUT', '2023-05-09 17:28:04'),
(38, 1, 'LOGIN', '2023-05-09 22:56:25'),
(39, 1, 'LOGOUT', '2023-05-09 22:56:59'),
(40, 1, 'LOGIN', '2023-05-10 01:59:36');

-- --------------------------------------------------------

--
-- Table structure for table `complaints`
--

CREATE TABLE `complaints` (
  `complaint_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `complaint_date` date NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` enum('UNRESOLVED','RESOLVED') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `complaints`
--

INSERT INTO `complaints` (`complaint_id`, `room_id`, `complaint_date`, `description`, `status`) VALUES
(1, 3, '2023-05-09', 'testing this', 'UNRESOLVED'),
(2, 3, '2023-05-10', 'afafdafadfadf', 'RESOLVED'),
(4, 12, '2023-05-10', 'testing complaint', 'RESOLVED');

-- --------------------------------------------------------

--
-- Table structure for table `employee_action_log`
--

CREATE TABLE `employee_action_log` (
  `log_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `action_description` varchar(255) NOT NULL,
  `action_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee_login_log`
--

CREATE TABLE `employee_login_log` (
  `log_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `log_type` enum('LOGIN','LOGOUT') NOT NULL,
  `log_time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee_login_log`
--

INSERT INTO `employee_login_log` (`log_id`, `employee_id`, `log_type`, `log_time`) VALUES
(1, 2, 'LOGIN', '2023-05-08 21:16:29'),
(2, 2, 'LOGIN', '2023-05-09 00:11:54'),
(3, 2, 'LOGIN', '2023-05-09 00:25:06'),
(4, 2, 'LOGIN', '2023-05-09 00:30:34'),
(5, 2, 'LOGIN', '2023-05-09 00:32:21'),
(6, 2, 'LOGIN', '2023-05-09 01:14:32'),
(7, 2, 'LOGOUT', '2023-05-09 01:16:07'),
(8, 2, 'LOGIN', '2023-05-09 01:16:48'),
(9, 2, 'LOGIN', '2023-05-09 01:21:10'),
(10, 2, 'LOGIN', '2023-05-09 01:22:23'),
(11, 2, 'LOGOUT', '2023-05-09 01:25:02'),
(12, 2, 'LOGIN', '2023-05-09 01:25:54'),
(13, 2, 'LOGIN', '2023-05-09 01:31:15'),
(14, 2, 'LOGIN', '2023-05-09 01:32:47'),
(15, 2, 'LOGIN', '2023-05-09 01:34:31'),
(16, 2, 'LOGIN', '2023-05-09 01:36:52'),
(17, 2, 'LOGIN', '2023-05-09 01:37:33'),
(18, 2, 'LOGIN', '2023-05-09 01:39:30'),
(19, 2, 'LOGIN', '2023-05-09 01:41:07'),
(20, 2, 'LOGIN', '2023-05-09 01:43:17'),
(21, 2, 'LOGIN', '2023-05-09 01:44:26'),
(22, 2, 'LOGIN', '2023-05-09 01:52:00'),
(23, 2, 'LOGIN', '2023-05-09 01:52:52'),
(24, 2, 'LOGIN', '2023-05-09 02:15:41'),
(25, 2, 'LOGIN', '2023-05-09 02:17:40'),
(26, 2, 'LOGIN', '2023-05-09 02:18:50'),
(27, 2, 'LOGIN', '2023-05-09 02:32:08'),
(28, 2, 'LOGIN', '2023-05-09 02:34:21'),
(29, 2, 'LOGIN', '2023-05-09 02:35:56'),
(30, 2, 'LOGIN', '2023-05-09 02:36:27'),
(31, 2, 'LOGIN', '2023-05-09 02:54:42'),
(32, 2, 'LOGIN', '2023-05-09 02:55:12'),
(33, 2, 'LOGIN', '2023-05-09 02:58:28'),
(34, 2, 'LOGIN', '2023-05-09 03:01:45'),
(35, 2, 'LOGIN', '2023-05-09 03:02:47'),
(36, 2, 'LOGIN', '2023-05-09 03:03:57'),
(37, 2, 'LOGIN', '2023-05-09 03:05:39'),
(38, 2, 'LOGIN', '2023-05-09 03:07:10'),
(39, 2, 'LOGIN', '2023-05-09 03:10:44'),
(40, 2, 'LOGIN', '2023-05-09 03:12:12'),
(41, 2, 'LOGIN', '2023-05-09 03:14:25'),
(42, 2, 'LOGIN', '2023-05-09 11:25:33'),
(43, 2, 'LOGIN', '2023-05-09 11:32:15'),
(44, 2, 'LOGOUT', '2023-05-09 11:32:20'),
(45, 2, 'LOGIN', '2023-05-09 11:32:50'),
(46, 2, 'LOGOUT', '2023-05-09 11:38:59'),
(47, 3, 'LOGIN', '2023-05-09 11:45:58'),
(48, 2, 'LOGIN', '2023-05-09 11:57:25'),
(49, 2, 'LOGIN', '2023-05-09 12:18:23'),
(50, 3, 'LOGIN', '2023-05-09 13:32:51'),
(51, 3, 'LOGIN', '2023-05-09 13:33:59'),
(52, 3, 'LOGIN', '2023-05-09 15:44:49'),
(53, 3, 'LOGOUT', '2023-05-09 15:44:57'),
(54, 2, 'LOGIN', '2023-05-09 15:45:04'),
(55, 2, 'LOGOUT', '2023-05-09 15:45:07'),
(56, 3, 'LOGIN', '2023-05-09 15:45:57'),
(57, 3, 'LOGOUT', '2023-05-09 15:45:59'),
(58, 2, 'LOGIN', '2023-05-09 15:46:14'),
(59, 2, 'LOGOUT', '2023-05-09 15:46:22'),
(60, 3, 'LOGIN', '2023-05-09 17:28:10'),
(61, 3, 'LOGIN', '2023-05-09 22:57:03'),
(62, 2, 'LOGIN', '2023-05-10 00:11:11'),
(63, 2, 'LOGIN', '2023-05-10 01:33:44'),
(64, 2, 'LOGIN', '2023-05-10 01:51:48');

-- --------------------------------------------------------

--
-- Table structure for table `expenses`
--

CREATE TABLE `expenses` (
  `expense_id` int(11) UNSIGNED NOT NULL,
  `user_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `expense_date` date NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `expenses`
--

INSERT INTO `expenses` (`expense_id`, `user_id`, `amount`, `expense_date`, `description`) VALUES
(2, 1, '50.00', '2023-05-01', 'Toilet paper'),
(3, 2, '25.00', '2023-05-02', 'Cleaning supplies'),
(4, 3, '75.00', '2023-05-02', 'New towels'),
(5, 6, '150.00', '2023-05-03', 'Repair work'),
(6, 7, '20.00', '2023-05-04', 'Light bulbs'),
(7, 1, '35.00', '2023-05-05', 'Air fresheners'),
(8, 2, '15.00', '2023-05-06', 'Paper towels'),
(9, 3, '50.00', '2023-05-07', 'Laundry detergent'),
(10, 6, '100.00', '2023-05-08', 'New furniture'),
(11, 7, '10.00', '2023-05-09', 'Trash bags'),
(12, 1, '20.00', '2023-05-09', 'Floor cleaner'),
(13, 2, '30.00', '2023-05-09', 'Window cleaner'),
(14, 3, '80.00', '2023-05-09', 'New bed sheets'),
(15, 6, '120.00', '2023-05-09', 'Paint'),
(16, 7, '15.00', '2023-05-09', 'Air filters');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `rental_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `payment_date` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentals`
--

CREATE TABLE `rentals` (
  `rental_id` int(11) NOT NULL,
  `tenant_id` int(11) NOT NULL,
  `room_id` int(11) NOT NULL,
  `check_in_date` datetime NOT NULL,
  `check_out_date` datetime NOT NULL,
  `total_amount` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rentals`
--

INSERT INTO `rentals` (`rental_id`, `tenant_id`, `room_id`, `check_in_date`, `check_out_date`, `total_amount`) VALUES
(3, 3, 3, '2023-05-09 00:00:00', '2023-05-13 00:00:00', '200.00'),
(4, 4, 3, '2023-05-18 00:00:00', '2023-05-27 00:00:00', '450.00');

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL,
  `room_number` varchar(20) NOT NULL,
  `room_price` decimal(10,2) NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_number`, `room_price`, `description`) VALUES
(3, '101', '50.00', 'Cozy single room with a shared bathroom.'),
(4, '102', '55.00', 'Comfortable single room with a private bathroom.'),
(5, '103', '60.00', 'Spacious single room with a private balcony.'),
(6, '104', '65.00', 'Large single room with a private kitchenette.'),
(7, '201', '75.00', 'Cozy double room with a shared bathroom.'),
(8, '202', '80.00', 'Comfortable double room with a private bathroom.'),
(9, '203', '85.00', 'Spacious double room with a private balcony.'),
(10, '204', '90.00', 'Large double room with a private kitchenette.'),
(11, '301', '100.00', 'Cozy triple room with a shared bathroom.'),
(12, '302', '105.00', 'Comfortable triple room with a private bathroom.'),
(13, '303', '110.00', 'Spacious triple room with a private balcony.'),
(14, '304', '115.00', 'Large triple room with a private kitchenette.'),
(15, '401', '125.00', 'Cozy quad room with a shared bathroom.'),
(16, '402', '130.00', 'Comfortable quad room with a private bathroom.'),
(17, '403', '135.00', 'Spacious quad room with a private balcony.');

-- --------------------------------------------------------

--
-- Table structure for table `tenant`
--

CREATE TABLE `tenant` (
  `tenant_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tenant`
--

INSERT INTO `tenant` (`tenant_id`, `first_name`, `last_name`, `phone_number`, `email`) VALUES
(1, 'tjay', 'abunales', 'tj@gmail.com', '09957'),
(2, 'dasfds', 'asdf', 'asdfa', 'sdafd'),
(3, 'tjay', 'abunales', 'tj@gmail.com', 'tj'),
(4, 'carl', 'victor', 'carl@gmail.com', '099');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_type` enum('ADMIN','EMPLOYEE') NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_type`, `username`, `password`, `name`) VALUES
(1, 'ADMIN', 'ADMIN', 'ADMIN', 'ADMIN'),
(2, 'EMPLOYEE', 'employee', 'employee', 'employee'),
(3, 'EMPLOYEE', 'tjay', 'tjay', 'tjay'),
(6, 'EMPLOYEE', 'carl', 'carl', 'carl'),
(7, 'EMPLOYEE', 'ray', 'ray', 'ray');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_action_log`
--
ALTER TABLE `admin_action_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_admin_action_log_admin_id` (`admin_id`);

--
-- Indexes for table `admin_login_log`
--
ALTER TABLE `admin_login_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_admin_login_log_admin_id` (`admin_id`);

--
-- Indexes for table `complaints`
--
ALTER TABLE `complaints`
  ADD PRIMARY KEY (`complaint_id`),
  ADD KEY `fk_complaint_room_id` (`room_id`);

--
-- Indexes for table `employee_action_log`
--
ALTER TABLE `employee_action_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_employee_action_log_employee_id` (`employee_id`);

--
-- Indexes for table `employee_login_log`
--
ALTER TABLE `employee_login_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_employee_login_log_employee_id` (`employee_id`);

--
-- Indexes for table `expenses`
--
ALTER TABLE `expenses`
  ADD PRIMARY KEY (`expense_id`),
  ADD KEY `fk_users` (`user_id`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `fk_payments_rental_id` (`rental_id`),
  ADD KEY `fk_payments_employee_id` (`employee_id`);

--
-- Indexes for table `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`rental_id`),
  ADD KEY `fk_rentals_tenant_id` (`tenant_id`),
  ADD KEY `fk_rentals_room_id` (`room_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`);

--
-- Indexes for table `tenant`
--
ALTER TABLE `tenant`
  ADD PRIMARY KEY (`tenant_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_action_log`
--
ALTER TABLE `admin_action_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `admin_login_log`
--
ALTER TABLE `admin_login_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `complaints`
--
ALTER TABLE `complaints`
  MODIFY `complaint_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employee_action_log`
--
ALTER TABLE `employee_action_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee_login_log`
--
ALTER TABLE `employee_login_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `expenses`
--
ALTER TABLE `expenses`
  MODIFY `expense_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rentals`
--
ALTER TABLE `rentals`
  MODIFY `rental_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `tenant`
--
ALTER TABLE `tenant`
  MODIFY `tenant_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin_action_log`
--
ALTER TABLE `admin_action_log`
  ADD CONSTRAINT `fk_admin_action_log_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `admin_login_log`
--
ALTER TABLE `admin_login_log`
  ADD CONSTRAINT `fk_admin_login_log_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `complaints`
--
ALTER TABLE `complaints`
  ADD CONSTRAINT `fk_complaint_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `employee_action_log`
--
ALTER TABLE `employee_action_log`
  ADD CONSTRAINT `fk_employee_action_log_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `employee_login_log`
--
ALTER TABLE `employee_login_log`
  ADD CONSTRAINT `fk_employee_login_log_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `expenses`
--
ALTER TABLE `expenses`
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_payments_employee_id` FOREIGN KEY (`employee_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `fk_payments_rental_id` FOREIGN KEY (`rental_id`) REFERENCES `rentals` (`rental_id`);

--
-- Constraints for table `rentals`
--
ALTER TABLE `rentals`
  ADD CONSTRAINT `fk_rentals_room_id` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `fk_rentals_tenant_id` FOREIGN KEY (`tenant_id`) REFERENCES `tenant` (`tenant_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
