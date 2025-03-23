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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

