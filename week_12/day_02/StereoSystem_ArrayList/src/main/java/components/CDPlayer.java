package components;

import behaviours.IPlay;

public class CDPlayer extends Component implements IPlay {

    private int noCDs;

    public CDPlayer(String make, String model, int noCDs) {
        super(make, model);
        this.noCDs = noCDs;
    }

    public int getNoCDs() {
        return noCDs;
    }

    public String play(String title) {
        return "CD - Playing: " + title;
    }
}
