package com.krampstudio.nopas.model.entities;

public enum FoodCategory {

	GRAIN(0, "Bread, Cereals, Starchy and Biscuits", new String[]{"Bread", "Rice", "Chips", "Potatoes"}),
	
	FRUIT(1, "Fruits", new String[]{"Banana", "Apple", "Strawberry"}),
	
	LEGUMES(2, "Legumes ans Vegetables", new String[]{"Salad", "Cucumber", "Tomato"}),
	
	MILK(3, "Milk products", new String[]{"Cheese", "Yogurts", "Butter", "Milk"}),
	
	MEAT(4, "Meats, poultry and fish", new String[]{"Beef", "Chicken", "Fish", "Eggs"}),
	
	DRINK(5, "Soft and alchoolic drinks", new String[]{"Juice", "Soda", "Beer", "Wine"}),
	
	SWEET(6, "Sweets", new String[]{"Chocolate", "Cookies"}),
	
	NUT(7, "Nuts and seeds", new String[]{"Almonds", "Hazelnuts", "Beans", "Lentils"}),
	
	COOKED(8, "Mixed base foods in a plate", new String[]{"Hamburger", "Pizzas"}),
	
	OTHER(9, "Everything else", new String[]{});
	
	
	
	private int id;
	
	public int getId(){
		return this.id;
	}
	
	private String description;
	
	public String getDescription(){
		return this.description;
	}
	
	private String[] samples;
	
	public String[] getSamples(){
		return this.samples;
	}
	
	private FoodCategory(int id, String desc, String[] samples){
		this.id=id;
		this.description = desc;
		this.samples = samples;
	}
}
