package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getNameTest() {
        String name = "test_name";
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, name, 0);
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void getPriceTest() {
        float price = 149.99f;
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "any_name", price);
        float actual = ingredient.getPrice();
        assertEquals(price, actual, 0.000001);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType type = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(type, "any_name", 0);
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }
}