package ca.dal.cs.csci3130.a3;

public class Husky extends Dog{

    public Husky(){
        super("Husky");
    }

    public int getSpeed(){
        return getBaseSpeed() + getExtraByBodyShape() +getExtraByTraining() - getSlowerDueToIce();
    }
}