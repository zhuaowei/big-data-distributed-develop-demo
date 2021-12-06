package com.student.score;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: StudentReducer
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/26
 * @Version: 1.0
 */

public class StudentReducer extends Reducer<Student, Text, Text, Student> {

    @Override
    protected void reduce(Student key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 将key和value反过来，写入上下文
        for (Text value : values) {
            context.write(value, key);
        }
    }

}
