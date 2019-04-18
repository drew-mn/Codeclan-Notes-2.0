import behaviours.ICycle;

public class Cyclist extends Athlete  implements ICycle {

    public void cycle(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }
}
