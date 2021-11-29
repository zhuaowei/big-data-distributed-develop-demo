package score;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @ClassName: Student
 * @Description: TODO add a description
 * @Author: zhuaowei
 * @Date: 2021/11/26
 * @Version: 1.0
 */

public class Student implements Writable {

    private int yuwen;
    private int math;
    private int allScore;

    public Student() {
    }

    public Student(int yuwen, int math) {
        this.yuwen = yuwen;
        this.math = math;
        this.allScore = this.yuwen + this.math;
    }

    @Override
    public String toString() {
        return yuwen + "\t" + math + "\t" + allScore;
    }

    public int getYuwen() {
        return yuwen;
    }

    public void setYuwen(int yuwen) {
        this.yuwen = yuwen;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getAllScore() {
        return allScore;
    }

    public void setAllScore(int allScore) {
        this.allScore = allScore;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(yuwen);
        dataOutput.writeInt(math);
        dataOutput.writeInt(allScore);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.yuwen = dataInput.readInt();
        this.math = dataInput.readInt();
        this.allScore = dataInput.readInt();
    }
}
