abstract class Person {
    
    protected String name;
    protected boolean isWorking;
    protected int id;

    // Constuctor
    public Person (String name, boolean isWorking, int id) {
        this.name = name;
        this.isWorking = isWorking;
        this.id = id;

    }

    public abstract void displayInfo();

}

