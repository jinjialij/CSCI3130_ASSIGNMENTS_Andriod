package ca.dal.cs.csci3130.a4.q3;

public class SmartPlug implements NormalPlug {

    ThreePlugAdapter threePlugAdapter;

    public SmartPlug(){}

    @Override
    public String plugMe(int numberOfPins) {
        //This method needs modification
        if (numberOfPins == 2){
            return "plugged to two point socket";
        } else if (numberOfPins == 3){
            threePlugAdapter = new ThreePlugAdapter();
            return threePlugAdapter.plugMe(numberOfPins);
        }
        return null;
    }

    @Override
    public boolean hasEarthConnection(int numberOfPins) {
        //This method needs modification
        if (numberOfPins == 2){
            return false;
        } else if (numberOfPins == 3){
            threePlugAdapter = new ThreePlugAdapter();
            return threePlugAdapter.hasEarthConnection(numberOfPins);
        }
        return false;
    }
}
