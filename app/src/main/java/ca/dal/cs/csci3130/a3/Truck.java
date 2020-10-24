package ca.dal.cs.csci3130.a3;

public class Truck  extends Vehicle {

    public Truck(int numberOfWheels, int averageKmPerHour){
        super(numberOfWheels, averageKmPerHour);
    }

    @Override
    public void honk() {
        System.out.println("The truck is honking!");
    }

    @Override
    public boolean carryPassengers() {
        return false;
    }

    public boolean carryGoods() {
        return true;
    }
}
