package menu;

public class Milkshake extends MenuItem {
	public Milkshake() {
		super.setPrice(6.25);
		super.setVegetarian(true);
		super.setDrinkable(true);
	}

	@Override
	public String getName() {
		return "Milkshake";
	}
}
