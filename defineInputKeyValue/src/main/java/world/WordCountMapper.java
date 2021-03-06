package world;

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

public class WordCountMapper extends Mapper<Text, Text, Text, IntWritable> {

    /**\
     * 将输入数据映射成 key-value 形式
     * @param key
     * @param value
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("<==================>");
        System.out.println("key -> " + key.toString());
        System.out.println("value -> " + value.toString());
        context.write(key, new IntWritable(1));
    }
}
