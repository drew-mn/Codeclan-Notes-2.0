package kaiju;

public class Godzilla extends Kaiju{

    public Godzilla(String name) {
        super(name, 100);
    }

    public String roar(){
        return super.roar() + " I'm " + this.getName();
    }

    public String move() {
        return "Stomp stomp stomp";
    }


}
