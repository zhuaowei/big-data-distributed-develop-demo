package com.student.score;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

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

public class Student implements Writable, WritableComparable {

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

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        if (this.allScore > student.allScore) {
            return -1;
        } else if (this.allScore == student.allScore) {
            if (this.yuwen > student.yuwen) {
                return -1;
            } else if (this.yuwen == this.yuwen) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
