package ca.dal.cs.csci3130.a3;

public class Bus extends Vehicle {

    public Bus(int numberOfWheels, int averageKmPerHour){
        super(numberOfWheels, averageKmPerHour);
    }

    @Override
    public void honk() {
        System.out.println("The bus is honking!");
    }

    @Override
    public boolean carryPassengers() {
        return true;
    }

}
