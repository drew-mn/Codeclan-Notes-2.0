package components;

import behaviours.IPlay;

public class RecordDeck extends Component implements IPlay {


    public RecordDeck(String make, String model) {
        super(make, model);
    }

    public String play(String record) {
        return "Record Deck Playing - " + record;
    }
}
