package tqsorest.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumMap;

import org.junit.Before;
import org.junit.Test;

import tqsorest.main.Dish.DishType;
import tqsorest.main.Dish;
import tqsorest.main.Ingredient;
import tqsorest.main.Ingredient.IngredientType;
import tqsorest.main.Kitchen;

public class KitchenTest {
	// Test member data
	public Kitchen kitchen;
	public EnumMap<Ingredient.IngredientType, Integer> kitchen_stock;
	
	@Before
	public void setUp() {
		kitchen_stock = new EnumMap<Ingredient.IngredientType, Integer>(Ingredient.IngredientType.class);
		kitchen_stock.put(IngredientType.MEAT, 1000);
		kitchen_stock.put(IngredientType.FISH, 1000);
		kitchen_stock.put(IngredientType.SALT, 1000);
		kitchen_stock.put(IngredientType.OLIVE, 1000);
		kitchen_stock.put(IngredientType.PEPPER, 1000);
		kitchen_stock.put(IngredientType.GARLIC, 1000);
		kitchen_stock.put(IngredientType.WATER, 1000);
		kitchen_stock.put(IngredientType.BEER, 1000);
		kitchen_stock.put(IngredientType.COKE, 1000);
		
		kitchen = new Kitchen(kitchen_stock);
	}
	
	@Test
	public void testCheckOrder() {
		assertTrue(kitchen.checkOrder(DishType.MEAT_WATER));
	}
	
	@Test
	public void testMakeOrder() {
		ArrayList<Dish> dishesOfOrder = new ArrayList<Dish>();
		dishesOfOrder.add(new Dish(DishType.MEAT_WATER));
		assertArrayEquals(dishesOfOrder.toArray(), kitchen.makeOrder(DishType.MEAT_WATER, 1).toArray());
	}

}
