package com.count.world;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName: WordCountReducer
 * @Description: 继承 Hadoop 的 Reducer，计算
 * @Author: zhuaowei
 * @Date: 2021/11/22
 * @Version: 1.0
 */

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    /**\
     * 计算 map 中字段的个数
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        // 总和
        int sum = 0;

        // 遍历 key 的每个 value
        for (IntWritable value : values) {
            // 对 key 的所有 value 进行加和
            sum += value.get();
        }
        // 将结果写入上下文，同样进行一下类型转换
        context.write(key, new IntWritable(sum));
    }
}
