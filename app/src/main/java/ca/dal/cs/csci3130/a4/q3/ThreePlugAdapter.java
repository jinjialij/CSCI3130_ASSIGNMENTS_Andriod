package ca.dal.cs.csci3130.a4.q3;

public class ThreePlugAdapter implements NormalPlug {

    ThreePointPlug threePointPlug;

    public ThreePlugAdapter() {
        //This constructor needs modification
        threePointPlug = new ThreePointPlug();
    }

    @Override
    public String plugMe(int numberOfPins) {
        //This method needs modification
        if (numberOfPins == 3){
            return threePointPlug.plugMe2ThreePointSocket();
        }

        return null;
    }

    @Override
    public boolean hasEarthConnection(int numberOfPins) {
        //This method needs modification
        if (numberOfPins == 3){
            return threePointPlug.canConnectToEarth();
        }
        return false;
    }
}
