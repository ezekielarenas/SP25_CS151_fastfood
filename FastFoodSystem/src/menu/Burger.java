package menu;

public class Burger extends MenuItem  {

	private static final int MAX_BURGERS = 100;
    private static int objectCount = 0;

	public Burger() { 
		super.setPrice(4.25);
		super.setVegetarian(false);
		super.setDrinkable(false);
		if(objectCount >= MAX_BURGERS) {
            throw new IllegalStateException("Max # of burgers is 100. Creation failed.");
        }
		objectCount++;
	}

	@Override
	public String getName() {
		return "Burger";
	}
}
