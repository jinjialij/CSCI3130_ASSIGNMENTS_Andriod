package ca.dal.cs.csci3130.a3;

public class Dalmatian extends Dog{

    public Dalmatian(){
        super("Dalmatian");
    }

    public int getSpeed(){
        return getBaseSpeed() + getExtraByTraining() +getExtraByBodyShape();
    }
}