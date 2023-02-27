package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Test
    public void getNameTest() {
        String name = "test_name";
        Bun bun = new Bun(name, 0);
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        float price = 99.9f;
        Bun bun = new Bun("any_name", price);
        float actual = bun.getPrice();
        assertEquals(price, actual, 0.000001);
    }
}