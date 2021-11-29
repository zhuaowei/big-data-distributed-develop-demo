package flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @ClassName: MyPartitioner
 * @Description: 自定义分区配置
 * @Author: zhuaowei
 * @Date: 2021/11/29
 * @Version: 1.0
 */

public class MyPartitioner extends Partitioner<Text, Flow> {

    /**\
     * 对每一个 key-value 返回一个分区编号
     * @param text
     * @param flow
     * @param i
     * @return
     */
    @Override
    public int getPartition(Text text, Flow flow, int i) {
        String phone = text.toString();
        // [0, 3) 前闭后开
        String start = phone.substring(0, 3);
        System.out.println(start);
        if ("136".equals(start)) {
            return 0;
        } else if ("137".equals(start)) {
            return 1;
        } else if ("138".equals(start)) {
            return 2;
        } else {
            return 3;
        }
    }
}
