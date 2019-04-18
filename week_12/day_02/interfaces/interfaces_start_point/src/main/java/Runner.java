import behaviours.IRun;

public class Runner extends Athlete implements IRun {


    public void run(int distance) {
        int distanceTravelled = this.getDistanceTravelled();
        this.setDistanceTravelled(distanceTravelled += distance);
    }
}
