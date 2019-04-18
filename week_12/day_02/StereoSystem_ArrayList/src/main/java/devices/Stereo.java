package devices;

import behaviours.IPlay;
import components.CDPlayer;
import components.Component;
import components.Radio;
import components.RecordDeck;

import java.util.ArrayList;

public class Stereo {

    private String name;
    private int currentVolume;
    private int maxVolume;
    private ArrayList<Component> components;


    public Stereo(String name, ArrayList<Component> components) {
        this.name = name;
        this.currentVolume = 0;
        this.maxVolume = 10;
        this.components = components;
    }

    public String getName() {
        return name;
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


    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public String useComponent(String sound, Component componentType){
        String result = null;
        if(componentType instanceof Radio){
           result = ((Radio) componentType).tune(sound);
        }
        if(componentType instanceof IPlay){
            result = ((IPlay) componentType).play(sound);
        }
        return result;
    }



}
