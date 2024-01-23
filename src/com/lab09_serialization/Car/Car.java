package com.lab09_serialization.Car;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Externalizable {

    private static final long serialId = 123123L;
    private String mark;
    private int speed;

    public Car() {
    }

    public Car(String mark, int speed) {
        this.mark = mark;
        this.speed = speed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" + "mark = " + mark + ", speed = " + speed + '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeLong(serialId);
        out.writeObject(mark);
        out.writeInt(speed);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        long serial = in.readLong();
        if (serial != serialId) {
            throw new IOException("Serial IDs do not match.");
        }
        mark = (String) in.readObject();
        speed = in.readInt();
    }
}
