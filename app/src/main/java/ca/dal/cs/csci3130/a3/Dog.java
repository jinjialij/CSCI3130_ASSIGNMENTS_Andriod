package ca.dal.cs.csci3130.a3;

public abstract class Dog {

    private String dogType;

    public Dog(String dogType) {
        this.dogType = dogType;
    }

    public abstract int getSpeed();

    public String getDogType(){
        return dogType;
    }

    protected int getBaseSpeed() {
        return 15;
    }

    protected int getExtraByTraining() {
        return 10;
    }

    protected int getExtraByBodyShape() {
        return 12;
    }

    protected int getSlowerDueToIce() {
        return 9;
    }
}

