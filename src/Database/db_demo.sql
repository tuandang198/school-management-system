-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 09, 2021 at 11:20 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_demo`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(70) NOT NULL,
  `name` varchar(40) NOT NULL,
  `answer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `username`, `password`, `name`, `answer`) VALUES
(1, 'doge', '123456', '', ''),
(2, 'abcd', '34243', '', ''),
(3, 'rew', 'ewrw', '', ''),
(4, 'doge', '123', 'doge', '123'),
(5, 'tr', '123', 'doge', '321'),
(6, 'sd', '2321', 'fd', '32');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `classID` tinyint(4) NOT NULL,
  `className` varchar(30) NOT NULL,
  `teacherID` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`classID`, `className`, `teacherID`) VALUES
(1, 'A1', 1),
(2, 'A2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentID` int(11) NOT NULL,
  `studentName` varchar(32) NOT NULL,
  `avrGrade` float NOT NULL,
  `studentClass` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentID`, `studentName`, `avrGrade`, `studentClass`) VALUES
(1, 'Morata', 9, 1),
(2, 'Dung', 6.3, 2),
(3, 'Matthew', 7, 1),
(4, 'Doge', 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student_subject`
--

CREATE TABLE `student_subject` (
  `id` int(4) NOT NULL,
  `subjectID` tinyint(4) NOT NULL,
  `studentID` int(4) NOT NULL,
  `mark` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_subject`
--

INSERT INTO `student_subject` (`id`, `subjectID`, `studentID`, `mark`) VALUES
(1, 3, 2, 6),
(2, 2, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` tinyint(4) NOT NULL,
  `subjectName` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `subjectName`) VALUES
(1, 'Java'),
(2, 'C & C++'),
(3, 'Database'),
(4, 'HTML, CSS, PHP');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `teacherID` tinyint(4) NOT NULL,
  `teacherName` varchar(30) NOT NULL,
  `teacherEmail` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`teacherID`, `teacherName`, `teacherEmail`) VALUES
(1, 'Doge', 'dogemeister@123'),
(2, 'meister', 'meister@1234');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_subject`
--

CREATE TABLE `teacher_subject` (
  `id` tinyint(4) NOT NULL,
  `teacherID` tinyint(4) NOT NULL,
  `subjectID` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher_subject`
--

INSERT INTO `teacher_subject` (`id`, `teacherID`, `subjectID`) VALUES
(1, 1, 3),
(2, 2, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`classID`),
  ADD UNIQUE KEY `className` (`className`),
  ADD KEY `fk_teacherID` (`teacherID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentID`),
  ADD KEY `fk_class_student` (`studentClass`);

--
-- Indexes for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_studentID_subject` (`studentID`),
  ADD KEY `fk_subjectID_student` (`subjectID`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`teacherID`),
  ADD UNIQUE KEY `teacherEmail` (`teacherEmail`);

--
-- Indexes for table `teacher_subject`
--
ALTER TABLE `teacher_subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_teacherID_subject` (`teacherID`),
  ADD KEY `fk_subjectID` (`subjectID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `classID` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `student_subject`
--
ALTER TABLE `student_subject`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `teacherID` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `teacher_subject`
--
ALTER TABLE `teacher_subject`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `fk_teacherID` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_class_student` FOREIGN KEY (`studentClass`) REFERENCES `class` (`classID`);

--
-- Constraints for table `student_subject`
--
ALTER TABLE `student_subject`
  ADD CONSTRAINT `fk_studentID_subject` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  ADD CONSTRAINT `fk_subjectID_student` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`id`);

--
-- Constraints for table `teacher_subject`
--
ALTER TABLE `teacher_subject`
  ADD CONSTRAINT `fk_subjectID` FOREIGN KEY (`subjectID`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `fk_teacherID_subject` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`teacherID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
