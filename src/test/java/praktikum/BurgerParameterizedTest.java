package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    private ReceiptPart receiptPart;
    private String testValue;

    public BurgerParameterizedTest(ReceiptPart receiptPart, String testValue) {
        this.receiptPart = receiptPart;
        this.testValue = testValue;
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("any_bun", 0));
        switch (receiptPart) {
            case BUN: {
                burger.setBuns(new Bun(testValue, 0));
                break;
            }
            case INGREDIENT: {
                burger.addIngredient(new Ingredient(IngredientType.FILLING, testValue, 0));
                break;
            }
            case PRICE: {
                burger.addIngredient(new Ingredient(IngredientType.FILLING, "any_name", Float.parseFloat(testValue)));
                break;
            }
        }
        String actual = testValue;
        if (receiptPart == ReceiptPart.PRICE) {
            actual = testValue.replace(".", ",");
        }
        assertTrue(burger.getReceipt().contains(actual));
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {ReceiptPart.BUN, "Bun_name"},
                {ReceiptPart.INGREDIENT, "Ingredient_name"},
                {ReceiptPart.PRICE, "9.99"}
        };
    }


    private enum ReceiptPart {
        BUN, INGREDIENT, PRICE
    }

}
