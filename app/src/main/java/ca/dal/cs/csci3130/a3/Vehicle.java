package ca.dal.cs.csci3130.a3;

public abstract class Vehicle {
    private int numberOfWheels;
    private int averageKmPerHour;

    public Vehicle(int numberOfWheels, int averageKmPerHour){
        this.numberOfWheels = numberOfWheels;
        this.averageKmPerHour = averageKmPerHour;
    }

    public int getNumberOfWheels(){ return numberOfWheels; };

    public abstract void honk();

    public abstract boolean carryPassengers();

//    public abstract boolean carryGoods();

    public int getAverageSpeed() {
        return averageKmPerHour;
    }
}
