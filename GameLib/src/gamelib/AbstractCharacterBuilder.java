/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Generic builder for any type of character.Delegates the build method implementation.
 * @author Luis Mariano Ramírez Segura
 * @param <T> Concrete character class
 * @param <E> Concrete character builder class
 */
public abstract class AbstractCharacterBuilder <T extends AbstractCharacter, E extends AbstractCharacterBuilder> implements IBuilder<T> {
    protected String name,
        spriteState; 
    protected int damage,  
        level,  
        x,  
        y,
        size,
        maxHealth,
        health, 
        hitsPerTimeUnit,  
        cost,  
        unlockLevel,  
        moveSteps;
    protected AbstractWeapon equipedWeapon;
    protected HashMap<Integer, SpriteSet> spriteSets; 
    protected ArrayList<AbstractWeapon> weapons;
    protected Direction direction;
    
    public AbstractCharacterBuilder() {  // defaults
        this.name = "";
        this.damage = 0;
        this.level = 1;
        this.x = 0;
        this.y = 0;
        this.size = 1;
        this.maxHealth = 1;
        this.health = maxHealth;
        this.hitsPerTimeUnit = 1;
        this.cost = 0;
        this.unlockLevel = 0;
        this.moveSteps = 1;
        this.spriteState = "idle";
        this.spriteSets = new HashMap<>();
        this.weapons = new ArrayList<>();
        this.direction = Direction.RIGHT;
    }
    
    public E addWeapon(AbstractWeapon weapon) {
        this.weapons.add(weapon);
        return (E) this;
    }
    
    public E addSpriteSet(int level, SpriteSet spriteSet) {
        this.spriteSets.put(level, spriteSet);
        return (E) this;
    }
    
    public SpriteSet getSpriteSet(int level) {
        return this.spriteSets.get(level);
    }

    public E setName(String name) {
        this.name = name;
        return (E) this;
    }

    public E setSpriteState(String spriteState) {
        this.spriteState = spriteState;
        return (E) this;
    }

    public E setDamage(int damage) {
        this.damage = damage;
        return (E) this;
    }

    public E setLevel(int level) {
        this.level = level;
        return (E) this;
    }

    public E setX(int x) {
        this.x = x;
        return (E) this;
    }

    public E setY(int y) {
        this.y = y;
        return (E) this;
    }

    public E setSize(int size) {
        this.size = size;
        return (E) this;
    }

    public E setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
        return (E) this;
    }
    
    public E setHealth(int health) {
        this.health = health;
        return (E) this;
    }

    public E setHitsPerTimeUnit(int hitsPerTimeUnit) {
        this.hitsPerTimeUnit = hitsPerTimeUnit;
        return (E) this;
    }

    public E setCost(int cost) {
        this.cost = cost;
        return (E) this;
    }

    public E setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
        return (E) this;
    }

    public E setMoveSteps(int moveSteps) {
        this.moveSteps = moveSteps;
        return (E) this;
    }
    
    public E setEquipedWeapon(int index) {
        this.equipedWeapon = weapons.get(index);
        return (E) this;
    }

    public E setSpriteSets(HashMap<Integer, SpriteSet> spriteSets) {
        this.spriteSets = spriteSets;
        return (E) this;
    }

    public E setWeapons(ArrayList<AbstractWeapon> weapons) {
        this.weapons = weapons;
        return (E) this;
    }

    public E setDirection(Direction direction) {
        this.direction = direction;
        return (E) this;
    }
    
}
