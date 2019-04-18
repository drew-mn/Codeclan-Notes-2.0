import behaviours.ISwim;

public class Swimmer extends Athlete implements ISwim {

    public void swim(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }
}
