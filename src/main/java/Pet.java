public class Pet {

    private static int count = 0; //Counter used to count how many objects created and to place into id variable
    private int id;
    private String name;
    private int age;
    
    public Pet(String name, int age) {
        this.id = count;
        this.name = name;
        this.age = age;
        count++; //Every pet object stored increases the count increment
    }
    
    //Getters and Setters
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
