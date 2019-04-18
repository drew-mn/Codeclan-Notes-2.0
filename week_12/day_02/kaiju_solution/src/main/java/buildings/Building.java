package buildings;

import behaviours.IDamage;

public abstract class Building implements IDamage {

    private String address;
    private int structuralIntegrity;

    public Building(String address) {
        this.address = address;
        this.structuralIntegrity = 100;
    }

    public int getStructuralIntegrity() {
        return structuralIntegrity;
    }

    public void takeDamage(int damage){
        this.structuralIntegrity -= damage;
    }




}
