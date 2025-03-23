package menu;

public abstract class MenuItem {
    private double Price;
    private boolean Vegetarian;
    private boolean Drinkable;

    // Abstract method that concrete subclasses must implement
    public abstract String getName();

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

    @Override
    public String toString() {
        return "Price: " + Price + "\nVegetarian: " + Vegetarian + "\nDrinkability: " + Drinkable;
    }

    @Override
    public boolean equals(Object o) {
        // Check for reference equality
        if (this == o) return true;
        // Check for null and ensure both objects are of the same class
        if (o == null || getClass() != o.getClass()) return false;
        // Cast and compare using getName()
        MenuItem menuItem = (MenuItem) o;
        String name = getName();
        String otherName = menuItem.getName();
        return name != null ? name.equals(otherName) : otherName == null;
    }

    @Override
    public int hashCode() {
        String name = getName();
        return name != null ? name.hashCode() : 0;
    }
}
