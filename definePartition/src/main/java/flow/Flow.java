package flow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName: Flow
 * @Description: 流量对象，包含上行流量、下行流量和总和
 * @Author: zhuaowei
 * @Date: 2021/11/25
 * @Version: 1.0
 */

public class Flow implements Writable {

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
}
