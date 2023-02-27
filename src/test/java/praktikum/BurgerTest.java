package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    public void testRemoveIngredient() {
        Burger burger = new Burger();
        String ingredientName = "ing_name";
        burger.addIngredient(new Ingredient(IngredientType.FILLING, ingredientName, 100));
        burger.removeIngredient(0);
        assertFalse(burger.getReceipt().contains(ingredientName));
    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        float bunPrice = 10;
        burger.setBuns(new Bun("bun_name", bunPrice));
        float ingredientPrice = 20;
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "ing_name", ingredientPrice));
        assertEquals(bunPrice * 2 + ingredientPrice, burger.getPrice(), 0.000001);
    }
}