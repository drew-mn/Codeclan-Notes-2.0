package vehicles;

import behaviours.IAttack;
import behaviours.IDamage;

public abstract class Vehicle implements IDamage, IAttack {

    private String type;
    private int healthValue;
    private int attackValue;

    public Vehicle(String type, int attackValue) {
        this.type = type;
        this.attackValue = attackValue;
        this.healthValue = 100;
    }

    public String getType() {
        return type;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void attack(IDamage iDamage){
        iDamage.takeDamage(this.attackValue);
    }

    public void takeDamage(int damage){
        this.healthValue -= damage;
    }

}
