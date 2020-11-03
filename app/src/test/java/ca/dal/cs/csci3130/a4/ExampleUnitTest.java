package ca.dal.cs.csci3130.a4;

import org.junit.Test;

import ca.dal.cs.csci3130.a4.q2.Fruit;
import ca.dal.cs.csci3130.a4.q2.FruitBasket;
import ca.dal.cs.csci3130.a4.q3.SmartPlug;

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
    public void checkFruitBasket() {
        Fruit[] basket = FruitBasket.fillInTheBasket();
        assertTrue("sweet".equals(basket[0].getTaste()));
        assertTrue("sour".equals(basket[1].getTaste()));
        assertTrue("green".equals(basket[2].getColor()));

        assertTrue("green".equals(basket[0].getColor()));
        assertTrue("yellow".equals(basket[1].getColor()));
        assertTrue("sweet".equals(basket[2].getTaste()));
    }


    @Test
    public void checkElectricPlugs() {
        SmartPlug smartPlug = new SmartPlug();
        assertTrue("plugged to three point socket".equals(smartPlug.plugMe(3)));
        assertTrue("plugged to two point socket".equals(smartPlug.plugMe(2)));
        assertTrue(smartPlug.hasEarthConnection(3));
        assertFalse(smartPlug.hasEarthConnection(2));
    }

}