public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String eat() {
        return "Nom nom";
    }


    public String breathe() {
        return "Breathing sounds";
    }
}
