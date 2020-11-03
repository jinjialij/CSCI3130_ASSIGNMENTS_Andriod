package ca.dal.cs.csci3130.a4.q3;

public class ThreePointPlug implements IThreePointPlug {
    @Override
    public String plugMe2ThreePointSocket() {
        return "plugged to three point socket";
    }

    @Override
    public boolean canConnectToEarth() {
        return true;
    }
}
