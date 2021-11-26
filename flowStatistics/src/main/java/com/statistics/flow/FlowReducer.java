package com.statistics.flow;

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

public class FlowReducer extends Reducer<Text, Text, Text, Text> {

    /**\
     * 计算 map 中字段的个数
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 总和
        int uploadSum = 0;
        int downloadSum = 0;

        // 遍历 key 的每个 value
        for (Text value : values) {
            // 对 key 的所有 value 进行加和
            System.out.println(value);
            String[] upDown = value.toString().split("&");
            uploadSum += Integer.parseInt(upDown[0]);
            downloadSum += Integer.parseInt(upDown[1]);
        }
        int sum = uploadSum + downloadSum;
        // 将结果写入上下文，同样进行一下类型转换
        context.write(key, new Text(uploadSum + "\t" + downloadSum + "\t" + sum));
    }
}
