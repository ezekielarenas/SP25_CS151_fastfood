package menu;

public class Fry extends MenuItem {

	private static final int MAX_FRY = 100;
    private static int objectCount = 0;

	public Fry() {
		super.setPrice(2.75);
		super.setVegetarian(true);
		super.setDrinkable(false);
		if(objectCount >= MAX_FRY) {
            throw new IllegalStateException("Max # of fries is 100. Creation failed.");
        }
		objectCount++;
	}

	@Override
	public String getName() {
		return "Fry";
	}
	@Override
	public String toString() {
		return super.toString() +"\nName: " +getName();

	}

}
