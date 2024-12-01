
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                        `author` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                        `publisher` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                        `publish_date` date NULL DEFAULT NULL,
                        `remarks` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
                        PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (2, 'Javaee', '黑马程序员', '人民邮电出版社', '2021-12-31', '难度*****');
INSERT INTO `book` VALUES (3, 'Linux', '凌敏、马雷', '东北林业大学出版社', '2024-10-30', '难度*****');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                          `course_category` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                          `course_period` int NULL DEFAULT NULL,
                          `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'java', '考查课', 15, '一周一节');
INSERT INTO `course` VALUES (2, '软件工程', '考试课', 12, '两周一节');
INSERT INTO `course` VALUES (3, '美食课', '考查课', 18, '一周五节');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
                            `customerId` int NOT NULL AUTO_INCREMENT,
                            `customerName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                            `customerGender` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                            `customerAge` int NULL DEFAULT NULL,
                            `customerPhone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            `customerEmail` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            `customerAddress` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
                            PRIMARY KEY (`customerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (3, '小张', '女', 20, '17745249621', '123456789@qq.com', '哈尔滨信息工程学院哈东校区');
INSERT INTO `customer` VALUES (4, '小钟', '女', 23, '123456', '123@qq.com', '宾县');
INSERT INTO `customer` VALUES (5, '张三', '男', 23, '2343234', '1234321@qq.com', '哈尔滨宾县');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `sex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `age` int NOT NULL,
                           `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '张三', '男', 12, '13班');
INSERT INTO `student` VALUES (2, '李四', '男', 13, '13班');
INSERT INTO `student` VALUES (3, '王五', '男', 10, '13班');
INSERT INTO `student` VALUES (4, '小庄', '女', 200, '13班');

SET FOREIGN_KEY_CHECKS = 1;
