package score;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName: StudentPartitioner
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/29
 * @Version: 1.0
 */

public class StudentPartitioner extends Partitioner<Text, Student> {
    @Override
    public int getPartition(Text text, Student student, int i) {
        String id = text.toString();

        if ("1003".equals(id) || "1004".equals(id)) {
            return 1;
        }
        return 0;
    }
}
