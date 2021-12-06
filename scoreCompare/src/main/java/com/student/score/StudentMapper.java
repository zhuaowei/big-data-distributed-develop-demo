package com.student.score;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName: StudentMapper
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/26
 * @Version: 1.0
 */

public class StudentMapper extends Mapper<LongWritable, Text, Student, Text> {
    @Override
    protected void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
        // 将输入数据类型转换为 String
        String line = value.toString();

        // 将输入字符串按空格拆分成单词数组
        String[] record = line.split("\t");

        Text id = new Text(record[1]);
        Student student = new Student(Integer.parseInt(record[2]), Integer.parseInt(record[3]));

        // student作为key排序，id作为value
        context.write(student, id);
    }

}
