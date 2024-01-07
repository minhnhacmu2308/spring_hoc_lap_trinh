-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 07, 2024 lúc 08:31 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `spring_hoc_lap_trinh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course`
--

CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_free` bit(1) NOT NULL,
  `price` int(11) NOT NULL,
  `course_types_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `course`
--

INSERT INTO `course` (`course_id`, `course_name`, `description`, `image`, `is_free`, `price`, `course_types_id`, `created_at`) VALUES
(4, 'Khóa học lập trình angular js', 'Angular là một framework phát triển ứng dụng web mạnh mẽ, được xây dựng và duy trì bởi Google. Nó cung cấp một cơ sở hạ tầng hoàn chỉnh để phát triển ứng dụng đơn trang (SPA - Single Page Application) hiện đại và linh hoạt. Với sự hỗ trợ mạnh mẽ cho việc ', 'https://bizweb.dktcdn.net/100/278/960/products/angular-4.jpg?v=1527655398977', b'1', 1000000, 3, '2024-01-07 11:16:07'),
(5, 'Khóa học lập trình Flutter', 'Flutter là một framework mã nguồn mở được phát triển bởi Google, giúp nhà phát triển xây dựng ứng dụng di động đa nền tảng với hiệu suất cao và giao diện người dùng đẹp mắt. Flutter sử dụng ngôn ngữ lập trình Dart, một ngôn ngữ chủ đề, hiện đại và linh ho', 'https://media.techmaster.vn/api/static/brbgh4451coepbqoch60/16zIcq28', b'0', 1000000, 4, '2024-01-07 11:25:51'),
(6, 'Khóa học lập trình IOS', 'IOS là một framework mã nguồn mở được phát triển bởi Google, giúp nhà phát triển xây dựng ứng dụng di động đa nền tảng với hiệu suất cao và giao diện người dùng đẹp mắt. Flutter sử dụng ngôn ngữ lập trình Dart, một ngôn ngữ chủ đề, hiện đại và linh ho', 'https://media.techmaster.vn/api/static/brbgh4451coepbqoch60/16zIcq28', b'0', 1000000, 4, '2024-01-07 11:25:51');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course_types`
--

CREATE TABLE `course_types` (
  `course_type_id` int(11) NOT NULL,
  `type_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `course_types`
--

INSERT INTO `course_types` (`course_type_id`, `type_name`) VALUES
(3, 'Lập trình web'),
(4, 'Lập trình mobile');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `course_videos`
--

CREATE TABLE `course_videos` (
  `course_video_id` int(11) NOT NULL,
  `video_name` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `course_videos`
--

INSERT INTO `course_videos` (`course_video_id`, `video_name`, `video_url`, `course_id`) VALUES
(5, 'Angular 2023 - Bài 1: Giới thiệu tổng quan về Angular', 'https://www.youtube.com/embed/rhcyHdL9mfo?list=PLRhlTlpDUWswOJnLxzotd7MgqaRrBlZOG', 4),
(6, 'Angular 2023 - Bài 2: Cài đặt môi trường phát triển', 'https://www.youtube.com/embed/x9Eo359Bz-U?list=PLRhlTlpDUWswOJnLxzotd7MgqaRrBlZOG', 4),
(7, 'Angular 2023 - Bài 3: Cách tạo mới và chạy một project Angular', 'https://www.youtube.com/embed/rWMdn0TyQ1g?list=PLRhlTlpDUWswOJnLxzotd7MgqaRrBlZOG', 4),
(8, 'Angular 2023 - Bài 4: Kiến trúc tổng quan ứng dụng', 'https://www.youtube.com/embed/Z0ZuWfLDEXg?list=PLRhlTlpDUWswOJnLxzotd7MgqaRrBlZOG', 4),
(9, '[Tự học Flutter - Bài 1] - Tại sao lại chọn lập trình mobie app với Flutter?', 'https://www.youtube.com/embed/ZTbPz2i2Dms?list=PL3Ob3F0T-08brnWfs8np2ROjICeT-Pr6T', 5),
(10, '[Tự học Flutter - Bài 2] - Những tài liệu, trang web quan trọng giúp bạn tự học Flutter', 'https://www.youtube.com/embed/wiTg7KJlieY?list=PL3Ob3F0T-08brnWfs8np2ROjICeT-Pr6T', 5),
(11, '[Tự học Flutter - Bài 3] - Cài đặt Flutter SDK & setup biến môi trường trên Windows', 'https://www.youtube.com/embed/aRYsKJ-8ppE?list=PL3Ob3F0T-08brnWfs8np2ROjICeT-Pr6T', 5),
(12, '[Tự học Flutter - Bài 4] - Cài đặt JDK + Android SDK + Tool code Android Studio', 'https://www.youtube.com/embed/wWF59NlIidM?list=PL3Ob3F0T-08brnWfs8np2ROjICeT-Pr6T', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `news`
--

CREATE TABLE `news` (
  `news_id` int(11) NOT NULL,
  `content` longtext DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `news`
--

INSERT INTO `news` (`news_id`, `content`, `image`, `title`) VALUES
(1, 'Bão hòa thị trường truyền thống - cơ hội cho những xu hướng mới\n\nĐại dịch COVID-19 gần 2 năm qua đã đặt ra rất nhiều thách thức và khó khăn cho toàn nền kinh tế cũng như cộng đồng doanh nghiệp, các doanh nghiệp nhìn chung đang phải chật vật tìm lối đi riêng để củng cố và duy trì hoạt động sản xuất kinh doanh. Trong bối cảnh nhiều ảm đạm của thị trường như vậy, ngành Công nghệ thông tin - Viễn thông (CNTT-VT) nổi lên như một điểm sáng hiếm hoi của nền kinh tế.\n\nKinh tế thế giới ghi nhận mức tăng trưởng âm 4,3% trong năm 2020 (số liệu World Bank) và dưới tác động của đại dịch, nhiều ngành nghề cũng nằm trong xu hướng tăng trưởng âm như bán lẻ (-5,7%), hàng không (-60,9%), trong khi đó, ngành công nghệ đã có sự cải thiện đáng kể vào nửa cuối năm 2020. Theo Gartner, thị trường CNTT thế giới chỉ còn tăng trưởng (-3,2%) trong quý 4 năm 2020, trong khi quý 3 là (-5,4%). Tổng chi cho CNTT toàn cầu năm 2020 ước đạt gần 3.700 tỷ USD.\n\nTại Việt Nam, GDP 2020 tăng trưởng dương 2,91% trong bối cảnh đại dịch, trong đó, ngành CNTT vẫn duy trì được đà tăng mặc dù có phần chậm lại so với giai đoạn trước. Theo báo cáo của Bộ Thông tin và Truyền thông, tổng doanh thu toàn ngành CNTT-VT Việt Nam năm 2020 đạt 120 tỷ USD. Số liệu ước tính từ công ty chuyên về dữ liệu thị trường và tiêu dùng Statista (Đức), doanh thu dịch vụ CNTT của Việt Nam ước đạt 1,12 tỷ USD, tăng nhẹ so với năm 2019 (1,1 tỷ USD). Sang năm 2021, Statista dự báo doanh thu lấy lại đà tăng như thời điểm trước khi đại dịch bùng nổ, con số dự đoán năm nay là hơn 1,18 tỷ USD, và tiếp tục tăng lên 1,43 tỷ USD vào năm 2025.\n\nĐại dịch đã đẩy nhanh nhu cầu và làn sóng chuyển đổi số, đầu tư công nghệ tại nhiều tổ chức và doanh nghiệp trên khắp cả nước. Điều này vừa là thách thức cho các doanh nghiệp trong ngành CNTT-VT, lại vừa tạo ra cơ hội rõ ràng cho tiến trình phát triển bền vững của các công ty công nghệ đi tiên phong trong cung cấp các giải pháp, nền tảng, dịch vụ và sản phẩm chuyển đổi số. Đặc biệt xu hướng chuyển đổi số có thể sẽ diễn ra mạnh mẽ hơn khi khách hàng nhận thấy tầm quan trọng của việc số hóa sau dịch COVID-19 như: giúp giảm chi phí, tăng hiệu suất…\n\nNăm 2021, doanh nghiệp ngành CNTT được kỳ vọng hưởng lợi nhờ xu hướng chuyển đổi số tại Việt Nam và trên thế giới và cùng đó là sự gia tăng của các gói thầu đầu tư công nghệ.\n\nTrong báo cáo khảo sát tháng 3/2021 với Top 500 Doanh nghiệp tăng trưởng nhanh nhất Việt Nam của Vietnam Report, cũng cho thấy CNTT-VT nằm trong Top 7 ngành được đánh giá có tiềm năng nhất trong ba năm tới, Công nghệ thông tin/Viễn thông dẫn đầu với tỷ lệ 72,7%. Kết quả này thể hiện đúng theo xu hướng phát triển hiện nay của các doanh nghiệp, đó là đẩy mạnh ứng dụng chuyển đổi số trong quản lý và vận hành.', 'https://cdn.thoibaonganhang.vn/stores/news_dataimages/quanva/072021/20/11/5816_1.png', 'Thị trường Công nghệ thông tin - Viễn thông: Những xu hướng mới'),
(2, 'Công nghệ thông tin là gì?\n\nCông nghệ thông tin được gọi tắt là IT (Information Technology) là một nhánh ngành kỹ thuật sử dụng máy tính và phần mềm máy tính để chuyển đổi, lưu trữ, bảo vệ, xử lý, truyền tải và thu thập thông tin.\n\nCNTT thường được chia t', 'https://daihoctantrao.edu.vn/media/news/2022/Hoc-cong-nghe-thong-tin.jpg', 'BẠN CÓ PHÙ HỢP VỚI NGÀNH CÔNG NGHỆ THÔNG TIN?');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `order_date` datetime DEFAULT NULL,
  `total_price` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`order_id`, `order_date`, `total_price`, `course_id`, `user_id`) VALUES
(3, '2024-01-07 11:51:36', 1000000, 5, 2),
(4, '2024-01-07 13:37:00', 1000000, 5, 7),
(5, '2024-01-07 14:14:04', 1000000, 6, 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `roles`
--

CREATE TABLE `roles` (
  `role_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `roles`
--

INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'Admin'),
(2, 'Customer');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `otp` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`user_id`, `address`, `email`, `full_name`, `gender`, `password`, `phone_number`, `status`, `role_id`, `otp`) VALUES
(2, 'Tam Tiến Núi Thành Quảng Nam', 'nguyenminhnhacmu@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$Y4oMHXBH.Kvhi.XbxMTlt.n0dIK66ZZ.ZIzY55iHIORHyKRQpIYcK', '0379572434', 1, 1, NULL),
(3, 'a', 'nguyenminhnhacmu1@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$qy6vOLG7J7Xe09rGRl0wL.p5TE3mXHeFZWoZBtmLQVC7rGC1el0ey', '0379572434', 1, 2, NULL),
(4, 'a', 'nguyenminhnhacmu11@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$oDCXeopiF5LmJgRCP8y7s.mjwKJDEtDrZxo2ABeWCyzYstySIdyHO', '0379572434', 1, 2, NULL),
(5, 'Tam Tiến Núi Thành Quảng Nam', 'nguyenminhnhacmu9@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$0VD.gj9njNeUdJ1CfR8Ysuv7354ihAb2/flM8wueKlxEdzTfOElvm', '0379572434', 1, 2, NULL),
(6, '1', 'nguyenminhnhacmu1111@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$Tl6.J.Y9HBXDkBaGOs66fuIkdzj2Q5/MHGzt3hDluTwP3D20LsA2C', '0379572434', 1, 2, NULL),
(7, 'Tam Tiến Núi Thành Quảng Nam', 'minhnha2308@gmail.com', 'Nguyễn Minh Nhã', '1', '$2a$10$DSOEp2GAWfFmkO3fisbPJutrTPZuDuqrOGT.lRaqOlfLruiyWSWxS', '0379572434', 1, 2, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`),
  ADD KEY `FKfjw0kthu4gt8gw98l8ts9f5po` (`course_types_id`);

--
-- Chỉ mục cho bảng `course_types`
--
ALTER TABLE `course_types`
  ADD PRIMARY KEY (`course_type_id`);

--
-- Chỉ mục cho bảng `course_videos`
--
ALTER TABLE `course_videos`
  ADD PRIMARY KEY (`course_video_id`),
  ADD KEY `FKl9s2cusi28io1i4b9syx7ljwi` (`course_id`);

--
-- Chỉ mục cho bảng `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`news_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `FK1fks7gjdwcpi0clubcofi727l` (`course_id`),
  ADD KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`);

--
-- Chỉ mục cho bảng `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `FKp56c1712k691lhsyewcssf40f` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `course`
--
ALTER TABLE `course`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `course_types`
--
ALTER TABLE `course_types`
  MODIFY `course_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `course_videos`
--
ALTER TABLE `course_videos`
  MODIFY `course_video_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `news`
--
ALTER TABLE `news`
  MODIFY `news_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FKfjw0kthu4gt8gw98l8ts9f5po` FOREIGN KEY (`course_types_id`) REFERENCES `course_types` (`course_type_id`);

--
-- Các ràng buộc cho bảng `course_videos`
--
ALTER TABLE `course_videos`
  ADD CONSTRAINT `FKl9s2cusi28io1i4b9syx7ljwi` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK1fks7gjdwcpi0clubcofi727l` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  ADD CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Các ràng buộc cho bảng `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `FKp56c1712k691lhsyewcssf40f` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
