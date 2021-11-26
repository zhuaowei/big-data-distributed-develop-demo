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

public class FlowReducer extends Reducer<Text, Flow, Text, Flow> {

    /**\
     * 计算 map 中字段的个数
     * @param key
     * @param values
     * @param context
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<Flow> values, Context context) throws IOException, InterruptedException {
        // 总和
        int uploadSum = 0;
        int downloadSum = 0;

        // 遍历 key 的每个 value
        for (Flow value : values) {
            // 对 key 的所有 value 进行加和
            uploadSum += value.getUpFlow();
            downloadSum += value.getDownFlow();
        }
        // 将结果写入上下文，同样进行一下类型转换
        context.write(key, new Flow(uploadSum, downloadSum));
    }
}
