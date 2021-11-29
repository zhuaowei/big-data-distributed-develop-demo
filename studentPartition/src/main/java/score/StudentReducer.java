package score;

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

public class StudentReducer extends Reducer<Text, Student, Text, Student> {

    @Override
    protected void reduce(Text key, Iterable<Student> values, Context context) throws IOException, InterruptedException {
        // 总和
        int yuwenSum = 0;
        int mathSum = 0;

        // 遍历 key 的每个 value
        for (Student value : values) {

            yuwenSum += value.getYuwen();
            mathSum += value.getMath();
        }

        // 将结果写入上下文，同样进行一下类型转换
        context.write(key, new Student(yuwenSum, mathSum));
    }

}
