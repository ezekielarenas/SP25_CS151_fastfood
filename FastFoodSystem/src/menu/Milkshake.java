package menu;

public class Milkshake extends MenuItem {
	public Milkshake() {
		super.setPrice(6.25);
		super.setVegetarian(true);
		super.setDrinkable(true);
	}
	public String getName() {
		return "Milkshake";
	}
}
