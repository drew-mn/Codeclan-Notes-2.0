package devices;

import components.CDPlayer;
import components.Component;
import components.Radio;
import components.RecordDeck;

import java.util.ArrayList;

public class Stereo {

    private String name;
    private Radio radio;
    private RecordDeck recordDeck;
    private CDPlayer cdPlayer;
    private int currentVolume;
    private int maxVolume;


    public Stereo(String name, Radio radio, RecordDeck recordDeck, CDPlayer cdPlayer) {
        this.name = name;
        this.radio = radio;
        this.recordDeck = recordDeck;
        this.cdPlayer = cdPlayer;
        this.currentVolume = 0;
        this.maxVolume = 10;
    }

    public String getName() {
        return name;
    }

    public String tuneRadio(String station){
        return this.radio.tune(station);
    }

    public String playCD(String title) {
        return cdPlayer.play(title);
    }

    public String playRecord(String title) {
        return recordDeck.play(title);
    }

    public void turnItUp() {
        if (this.currentVolume < maxVolume) {
            this.currentVolume++;
        }
    }

    public void turnItDown() {
        if (this.currentVolume > 0) {
            this.currentVolume--;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }


}
