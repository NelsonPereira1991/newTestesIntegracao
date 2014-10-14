package tqsorest.main;

import java.util.ArrayList;


public class Dish {
	// Class Members
	public static enum DishType {
		MEAT_WATER, MEAT_BEER, MEAT_COKE, FISH_WATER, FISH_BEER, FISH_COKE
	};
	
	private static boolean[][] menu = new boolean[][] {
		{true, false, true, true, true, false, true, false, false}, // MEAT WATER
		{true, false, true, true, true, false, false, true, false}, // MEAT BEER
		{true, false, true, true, true, false, false, false, true}, // MEAT COKE
		{false, true, true, true, false, true, true, false ,false}, // FISH WATER
		{false, true, true, true, false, true, false, true, false}, // FISH BEER
		{false, true, true, true, false, true, false, false, true}, // FISH COKE
	};
	
	private double m_price;
	private DishType m_type;
	
	// Methods
	public Dish(DishType type) {
		m_type = type;
		calculatePrice();
	}

	public double get_price() {
		return m_price;
	}

	public void set_price(double m_price) {
		this.m_price = m_price;
	}

	public DishType get_type() {
		return m_type;
	}

	public void set_type(DishType m_type) {
		this.m_type = m_type;
	}
	
	public void calculatePrice() {
		boolean[] dishIngredients = menu[m_type.ordinal()];
		for (int i=0; i<DishType.values().length; i++) {
			if ( dishIngredients[i] ) {
				m_price += Ingredient.get_priceTable()[i];
			}
		}
	}
	
	public ArrayList<Ingredient.IngredientType> getDishIngredientsType() {
		ArrayList<Ingredient.IngredientType> dishIngredientsTypeToReturn = new ArrayList<Ingredient.IngredientType>();
		for(int i=0; i<menu[m_type.ordinal()].length; i++) {
			if ( menu[m_type.ordinal()][i] ) {
				
				for (Ingredient.IngredientType ingredientType : Ingredient.IngredientType.values()) {
					if (ingredientType.ordinal() == i) {
						dishIngredientsTypeToReturn.add(ingredientType);
					}
				}
			}
		}
		return dishIngredientsTypeToReturn;
	}
}
