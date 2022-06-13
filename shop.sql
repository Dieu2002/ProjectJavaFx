-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 13, 2022 lúc 04:54 PM
-- Phiên bản máy phục vụ: 10.4.24-MariaDB
-- Phiên bản PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `admin`
--

CREATE TABLE `admin` (
  `id` int(5) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phoneshop`
--

CREATE TABLE `phoneshop` (
  `id` int(5) NOT NULL,
  `phonename` varchar(30) NOT NULL,
  `phoneprice` float NOT NULL,
  `quantity` int(5) NOT NULL,
  `img` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phoneshop`
--

INSERT INTO `phoneshop` (`id`, `phonename`, `phoneprice`, `quantity`, `img`, `description`) VALUES
(4, 'Vsmart ', 50000, 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBYNrsKEfm3Y9NGvWgIkEYx_mKm22mIFAdHA&usqp=CAU', 'Điện thoại mới nhập về đó'),
(5, 'Vovo ', 400000, 3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTya3fDUYsUoST8iWqttQZbJmvz21iTRB1h4Q&usqp=CAUhttps://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTya3fDUYsUoST8iWqttQZbJmvz21iTRB1h4Q&usqp=CAU', 'Mới nhập về hãng vivo');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phoneshop`
--
ALTER TABLE `phoneshop`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `phoneshop`
--
ALTER TABLE `phoneshop`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
