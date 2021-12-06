package com.student.score;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @ClassName: StudentDriver
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/26
 * @Version: 1.0
 */

public class StudentDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // 获取一个job实例
        Job job = Job.getInstance(new Configuration());
        // 设置主类，就是当前的类
        job.setJarByClass(StudentDriver.class);

        // 设置 map 和 reduce
        job.setMapperClass(StudentMapper.class);
        job.setReducerClass(StudentReducer.class);

        // 设置 map 输入输出类型
        job.setMapOutputKeyClass(Student.class);
        job.setMapOutputValueClass(Text.class);

        // 设置 reduce 输入输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Student.class);

        // 设置分区的类和分区数量
        job.setPartitionerClass(StudentPartitioner.class);
        job.setNumReduceTasks(2);

        // 设置参数，这里在idea本地运行需要在右上方edit configuration配置Program arguments 设置输入输出目录，用空格隔开，设置目录即可，不需要设置到文件
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 提交job
        boolean b = job.waitForCompletion(true);
        // 提交成功退出
        System.exit(b ? 0 : 1);
    }

}
