package MenuItems;

public abstract class MenuItem {
private double Price;
private boolean Vegetarian;
private boolean Drinkable;
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public boolean isVegetarian() {
	return Vegetarian;
}
public void setVegetarian(boolean vegetarian) {
	Vegetarian = vegetarian;
}
public boolean isDrinkable() {
	return Drinkable;
}
public void setDrinkable(boolean drinkable) {
	Drinkable = drinkable;
}

}
