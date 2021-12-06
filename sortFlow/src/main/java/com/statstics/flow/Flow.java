package com.statstics.flow;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName: Flow
 * @Description: 排序发生在 key 中，所以在map阶段，把Flow作为key，最后输出再换回来
 * @Author: zhuaowei
 * @Date: 2021/11/25
 * @Version: 1.0
 */

public class Flow implements Writable, WritableComparable {

    private int upFlow;
    private int downFlow;
    private int sumFlow;

    public Flow() {}

    public Flow(int upFlow, int downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow + downFlow;
    }

    @Override
    public String toString() {
        return upFlow + "\t" + downFlow + "\t" + sumFlow;
    }

    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }

    public int getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(int sumFlow) {
        this.sumFlow = sumFlow;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.upFlow);
        dataOutput.writeInt(this.downFlow);
        dataOutput.writeInt(this.sumFlow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.upFlow = dataInput.readInt();
        this.downFlow = dataInput.readInt();
        this.sumFlow = dataInput.readInt();
    }

    @Override
    public int compareTo(Object o) {
        Flow flow = (Flow) o;
        if (this.sumFlow > flow.sumFlow) {
            return -1;
        } else if (this.sumFlow == flow.sumFlow) {
            if (this.downFlow > flow.downFlow) {
                return -1;
            } else if (this.downFlow == flow.downFlow) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
