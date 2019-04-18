package components;

import behaviours.IConnect;
import devices.Stereo;

public class MP3Player extends Component implements IConnect {


    public MP3Player(String make, String model) {
        super(make, model);
    }

    public String connect(Stereo stereo) {
        return "Connected to - " + stereo.getName();
    }
}
