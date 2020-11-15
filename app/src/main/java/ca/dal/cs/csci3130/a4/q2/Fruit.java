package ca.dal.cs.csci3130.a4.q2;

public interface Fruit {
    //This fruit interface must be implemented with different fruits!
    public String getTaste();
    public String getColor();

    class Mango implements Fruit{
        public String getTaste(){
            return "sweet";
        }

        public String getColor(){
            return "green";
        }
    }

    class Orange implements Fruit{
        public String getTaste(){
            return "sour";
        }

        public String getColor(){
            return "yellow";
        }
    }

    class Grape implements Fruit{
        public String getTaste(){
            return "sweet";
        }

        public String getColor(){
            return "green";
        }
    }
}
