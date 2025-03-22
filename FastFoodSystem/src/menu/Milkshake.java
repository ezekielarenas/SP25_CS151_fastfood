package menu;

public class Milkshake extends MenuItem {

	private static final int MAX_MILKSHAKES = 100;
    private static int objectCount = 0;

	public Milkshake() {
		super.setPrice(6.25);
		super.setVegetarian(true);
		super.setDrinkable(true);
		if(objectCount >= MAX_MILKSHAKES) {
            throw new IllegalStateException("Max # of milkshakes is 100. Creation failed.");
        }
		objectCount++;
	}

	@Override
	public String getName() {
		return "Milkshake";
	}
}
