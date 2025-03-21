package menu;

public class Burger extends MenuItem  {
	public Burger() { 
		super.setPrice(4.25);
		super.setVegetarian(false);
		super.setDrinkable(false);
	}

	public String getName() {
		return "Burger";
	}
}
