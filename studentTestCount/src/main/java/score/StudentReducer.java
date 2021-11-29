package score;

import org.apache.hadoop.io.IntWritable;
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

public class StudentReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int sum = 0;

        for (IntWritable value : values) {
            sum += value.get();
        }

        // 将结果写入上下文，同样进行一下类型转换
        context.write(key, new IntWritable(sum));
    }

}
