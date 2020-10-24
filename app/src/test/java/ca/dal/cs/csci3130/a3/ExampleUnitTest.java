package ca.dal.cs.csci3130.a3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void checkDogSpeed() {
        Dog dog1 = new Dog("HUSKY");
        assertEquals(28, dog1.getSpeed());

        Dog dog2 = new Dog("BULLDOG");
        assertEquals(15, dog2.getSpeed());

        Dog dog3=new Dog("DALMATIAN");
        assertEquals(37, dog3.getSpeed());
    }

    @Test
    public void checkBusSpeed(){
        Bus bus=new Bus(4， 60);
        assertEquals(60, bus.getAverageSpeed());
    }

    @Test
    public void checkTruckSpeed(){
        Truck truck=new Truck(4， 80);
        assertEquals(80, truck.getAverageSpeed());
    }

    @Test
    public void checkCarryPassengers(){
        Bus bus=new Bus();
        assertTrue(bus.carryPassengers());

        Truck truck=new Truck();
        assertFalse(truck.carryPassengers());
        assertTrue(truck.carryGoods());
    }







}