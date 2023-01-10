-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2022-12-20 22:04:12
-- 服务器版本： 5.6.50-log
-- PHP 版本： 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `superc`
--

-- --------------------------------------------------------

--
-- 表的结构 `sms`
--

CREATE TABLE `sms` (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `code` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '验证码',
  `ip` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'ip',
  `phone` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `type` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '短信类型',
  `time` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='短信发送表' ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `sms`
--

INSERT INTO `sms` (`id`, `code`, `ip`, `phone`, `type`, `time`) VALUES
(1, '35190', '', '15927614001', 'reg', '2022-12-18 23:03:50'),
(2, '84237', '', '15927614001', 'reg', '2022-12-18 23:05:10'),
(3, '19888', '', '15927614001', 'reg', '2022-12-18 23:12:17'),
(4, '19395', '', '15927614001', 'reg', '2022-12-18 23:47:46'),
(5, '69517', '', '15927614001', 'reg', '2022-12-18 23:49:54'),
(6, '13156', '', '15927614001', 'reg', '2022-12-18 23:52:22'),
(7, '75406', '', '15927614001', 'login', '2022-12-18 23:55:30'),
(8, '74723', '', '15927614008', 'reg', '2022-12-20 20:24:22'),
(9, '96493', '', '15927614008', 'reg', '2022-12-20 20:30:17'),
(10, '28169', '', '15927614002', 'reg', '2022-12-20 22:01:10'),
(11, '82220', '', '15927614002', 'reg', '2022-12-20 22:03:29');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `userid` char(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'ID',
  `username` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `password` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `userinfo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户简介',
  `phone` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户地址',
  `region` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户所在地区',
  `userdate` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '出生日期',
  `identity` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户身份',
  `code` varchar(55) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT '2' COMMENT '用户身份编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户信息表' ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`userid`, `username`, `password`, `sex`, `userinfo`, `phone`, `address`, `region`, `userdate`, `identity`, `code`, `level`) VALUES
('1', 'user01', 'b75705d7e35e7014521a46b532236ec3', '男', NULL, '15927614001', NULL, NULL, '2022-12-18 23:53:06', NULL, '13156', 1),
('e7f3c6add', 'user02', '8bd108c8a01a892d129c52484ef97a0d', '女', NULL, '15927614002', NULL, NULL, '2022-12-20 22:03:45', NULL, '82220', 1);

--
-- 转储表的索引
--

--
-- 表的索引 `sms`
--
ALTER TABLE `sms`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`) USING BTREE,
  ADD UNIQUE KEY `uk_name` (`username`) USING BTREE;

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `sms`
--
ALTER TABLE `sms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID', AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
