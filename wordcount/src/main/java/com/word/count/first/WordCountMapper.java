package com.word.count.first;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @ClassName: WordCountMapper
 * @Description: 继承hadoop的 Mapper 类
 * LongWritable 输入数据的下标
 * Text 输入数据
 * Text 输出的key
 * IntWritable 输出的value
 * @Author: zhuaowei
 * @Date: 2021/11/22
 * @Version: 1.0
 */

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    /**\
     * 将输入数据映射成 key-value 形式
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 将输入数据类型转换为 String
        String line = value.toString();
        // 将输入字符串按空格拆分成单词数组
        String[] words = line.split(" ");

        // 遍历单词数组
        for (String word : words) {
            // 将每个单词写到上下文
            // 因为context.write() 需要传入 Text 和 IntWritable，所以要进行一下类型转换
            context.write(new Text(word), new IntWritable(1));
        }
    }
}
