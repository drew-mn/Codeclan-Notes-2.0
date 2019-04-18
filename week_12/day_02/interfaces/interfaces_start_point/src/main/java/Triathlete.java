import behaviours.ICycle;
import behaviours.IRun;
import behaviours.ISwim;

public class Triathlete extends Athlete implements IRun, ISwim, ICycle {

    public void run(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }

    public void cycle(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }

    public void swim(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }
}
