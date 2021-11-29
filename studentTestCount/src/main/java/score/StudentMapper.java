package score;

import org.apache.hadoop.io.IntWritable;
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

public class StudentMapper extends Mapper<Text, Text, Text, IntWritable> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String id = value.toString().split("\t")[0];

        context.write(new Text(id), new IntWritable(1));
    }

}
