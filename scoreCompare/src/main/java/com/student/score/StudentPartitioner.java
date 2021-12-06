package com.student.score;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName: StudentPartitioner
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/29
 * @Version: 1.0
 */

public class StudentPartitioner extends Partitioner<Student, Text> {
    @Override
    public int getPartition(Student student, Text text, int i) {
        String id = text.toString();
        // 默认是 0 分区，1003和1004在 1 分区
        if ("1003".equals(id) || "1004".equals(id)) {
            return 1;
        }
        return 0;
    }
}

