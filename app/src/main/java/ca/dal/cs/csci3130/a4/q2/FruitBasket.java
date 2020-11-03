package ca.dal.cs.csci3130.a4.q2;

public class FruitBasket {

    static int NUMBER_OF_FRUITS = 3;

    public static Fruit[] fillInTheBasket() {
        FruitFactory fruitMaker = new FruitFactory();
        Fruit[] fruits = new Fruit[NUMBER_OF_FRUITS];
        Fruit fruit1 = fruitMaker.getFruit("MANGO");
        fruits[0] = fruit1;
        Fruit fruit2 = fruitMaker.getFruit("ORANGE");
        fruits[1] = fruit2;
        Fruit fruit3 = fruitMaker.getFruit("GRAPE");
        fruits[2] = fruit3;
        return fruits;
    }
}
