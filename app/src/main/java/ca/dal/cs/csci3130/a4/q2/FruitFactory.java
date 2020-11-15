package ca.dal.cs.csci3130.a4.q2;

public class FruitFactory {

    public Fruit getFruit(String fruitName) {
        //your code goes here, this method needs modification!
        if (fruitName == null){
            return null;
        }
        else if (fruitName.equals("MANGO")){
            return new Fruit.Mango();
        }
        else if (fruitName.equals("ORANGE")){
            return new Fruit.Orange();
        }
        else if (fruitName.equals("GRAPE")){
            return new Fruit.Grape();
        }

        return null;
    }
}
