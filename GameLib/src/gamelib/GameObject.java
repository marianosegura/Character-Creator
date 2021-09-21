/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * 
 * @author Luis Mariano Ramírez Segura
 * @param <T> Object type of the object this object attacks
 */
public abstract class GameObject<T extends GameObject> implements IPrototype {
    protected String name;  // object identifier
    protected int damage,  // object damage
        level,  // object level
        x,  // x coordinate
        y;  // y coordinate

    public GameObject(String name, int damage, int level, int x, int y) {
        this.name = name;
        this.damage = damage;
        this.level = level;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
        this.name = "";
        this.damage = 0;
        this.level = 1;
        this.x = 0;
        this.y = 0;
    }
    
    /**
     * Increases the object level by a given amount;
     * @param increment Increment amount
     */
    public void increaseLevel(int increment) {
        this.level += increment;
    }
    
    public abstract void attack(T object);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
}
