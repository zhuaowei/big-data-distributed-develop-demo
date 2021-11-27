# big-data-distributed-develop-demo

学习java海量数据分布式开发过程中的案例

这个项目包含多个module，每一个module都是一个可单独运行的程序。运行时配置运行的module和输入文件和输出文件的目录。

## 运行环境

- jdk 1.8

- maven 3.6.3

- hadoop 2.7.2

- idea 2021.1

## 目录结构

- data 存放运行程序需要的所有数据文件。

- output 程序运行生成文件的目录，子文件夹是每一个项目运行生成的，一个项目一个文件夹。

- pom.xml maven依赖文件，项目级，所有module都可以使用。每一个module中都有一个pom.xml，可为这个module单独引入依赖。

- 其余的都是module。

## 数据文件及module说明

- zy1_data.txt
    - wordcount 各单词出现次数统计
    - work01 文件每行第一个单词出现次数统计
    
- phone_data.txt
    - flowStatistics 各号码上行流量、下行流量、总流量统计（不带类）
    - flowStatisticsWithObject 各号码上行流量、下行流量、总流量统计（带类实现）

- zy2_data.txt
    - studentScore 学生成绩统计