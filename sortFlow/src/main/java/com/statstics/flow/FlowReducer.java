package com.statstics.flow;

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

public class FlowReducer extends Reducer<Flow, Text, Text, Flow> {

    /**\
     * 计算 map 中字段的个数
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Flow key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for (Text value : values) {
            context.write(value, key);
        }

    }
}
