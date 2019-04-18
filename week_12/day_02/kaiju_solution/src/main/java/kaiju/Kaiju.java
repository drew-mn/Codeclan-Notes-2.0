package kaiju;

import behaviours.IAttack;
import behaviours.IDamage;

public abstract class Kaiju implements IAttack, IDamage {

    private String name;
    private int healthValue;
    private int attackValue;

    public Kaiju(String name, int attackValue) {
        this.name = name;
        this.attackValue = attackValue;
        this.healthValue = 100;
    }

    public String getName() {
        return name;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public String roar(){
        return "Roar";
    }

    public void attack(IDamage iDamage) {
        iDamage.takeDamage(this.attackValue);
    }

    public void takeDamage(int damage) {
        this.healthValue -= damage;
    }

    public abstract String move();
}
