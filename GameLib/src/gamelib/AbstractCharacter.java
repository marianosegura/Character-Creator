/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Base character class, handles sprites sets and weapons.
 * @author Luis Mariano Ramírez Segura
 */
public abstract class AbstractCharacter extends GameObject<AbstractCharacter> {
    protected int size,
        maxHealth,
        health,  // character health, unlike maxHealth, indicates the current amount of character health 
        hitsPerTimeUnit,  // amount of hits the character delivers per time unit
        cost,  // character cost
        unlockLevel,  // level in which the character is unlocked
        moveSteps;  // amount of steps the character moves when calling move
    protected String spriteState;  // current character state (running, attacking etc)
    protected HashMap<Integer, SpriteSet> spriteSets;  // sets of sprites maping level to sprite set
    protected ArrayList<AbstractWeapon> weapons;  // list of character available weapons
    protected AbstractWeapon equipedWeapon;  // weapon being currently held by the character
    protected Direction direction;  // direction the character is facing

    public AbstractCharacter(int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, HashMap<Integer, SpriteSet> spriteSets, ArrayList<AbstractWeapon> weapons, AbstractWeapon equipedWeapon, Direction direction, String name, int damage, int level, int x, int y) {
        super(name, damage, level, x, y);
        this.size = size;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.hitsPerTimeUnit = hitsPerTimeUnit;
        this.cost = cost;
        this.unlockLevel = unlockLevel;
        this.moveSteps = moveSteps;
        this.spriteState = spriteState;
        this.spriteSets = spriteSets;
        this.weapons = weapons;
        this.equipedWeapon = equipedWeapon;
        this.direction = direction;
    }

    public AbstractCharacter(int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, Direction direction, String name, int damage, int level, int x, int y) {
        super(name, damage, level, x, y);
        this.size = size;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.hitsPerTimeUnit = hitsPerTimeUnit;
        this.cost = cost;
        this.unlockLevel = unlockLevel;
        this.moveSteps = moveSteps;
        this.spriteState = spriteState;
        this.spriteSets = new HashMap<>();
        this.weapons = new ArrayList<>();
        this.equipedWeapon = null;
        this.direction = direction;
    }
    
    public AbstractCharacter() {
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
        this.equipedWeapon = null;
        this.direction = Direction.RIGHT;
    }
    
    /**
     * Adds a new available weapon.
     * @param weapon New available weapon
     */
    public void addWeapon(AbstractWeapon weapon) {
        this.weapons.add(weapon);
    }
    
    /**
     * Equips an available character weapon.
     * @param weaponIndex Weapon index in the weqpon list
     */
    public void equipWeapon(int weaponIndex) {
        if (this.weapons.size() < weaponIndex && weaponIndex > 0) {
            this.equipedWeapon = this.weapons.get(weaponIndex);
        }
    }
    
    /**
     * Unequips the current character weapon.
     */
    public void unequipWeapon() {
        this.equipedWeapon = null;
    }
    
    /**
     * Adds a sprite set for a given level.
     * @param level Set level
     * @param spriteSet Set of sprites
     */
    public void addSpriteSet(int level, SpriteSet spriteSet) {
        this.spriteSets.put(level, spriteSet);
    }
    
    public String getSprite() {
        int maxSpriteLevel = -1;
        for(int levelKey : this.spriteSets.keySet()) {  // iterate levels of sprite sets 
            if (levelKey >= this.level && levelKey > maxSpriteLevel)
                maxSpriteLevel = levelKey;  // take the biggest value that is below or same as character range
        }
        if (maxSpriteLevel == -1) return null;  // no level matched

        SpriteSet maxSpriteSet = this.spriteSets.get(maxSpriteLevel);

        if (!maxSpriteSet.getSprites().containsKey(this.spriteState)) return null;  // sprite state not matched

        return maxSpriteSet.getSprite(this.spriteState);  // return sprite according to current sprite state
    }
    
    /**
     * Moves the character in the current direction according to the character moving steps.
     */
    public void move() {
        this.x += this.moveSteps * this.direction.getUnitaryX();
        this.y += this.moveSteps * this.direction.getUnitaryY();
    }
    
    /**
     * Reduces the character health by a given damage amount.
     * @param damage Amount of damage being taken
     */
    public void getHit(int damage) {
        this.health -= damage;
        this.health = (damage >= 0) ? Math.max(0, this.health)  // cap to zero if positive damage
                :  Math.min(this.maxHealth, this.health);  // cap to maxHealth if negative damage

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHitsPerTimeUnit() {
        return hitsPerTimeUnit;
    }

    public void setHitsPerTimeUnit(int hitsPerTimeUnit) {
        this.hitsPerTimeUnit = hitsPerTimeUnit;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUnlockLevel() {
        return unlockLevel;
    }

    public void setUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }

    public int getMoveSteps() {
        return moveSteps;
    }

    public void setMoveSteps(int moveSteps) {
        this.moveSteps = moveSteps;
    }

    public String getSpriteState() {
        return spriteState;
    }

    public void setSpriteState(String spriteState) {
        this.spriteState = spriteState;
    }

    public HashMap<Integer, SpriteSet> getSpriteSets() {
        return spriteSets;
    }

    public void setSpriteSets(HashMap<Integer, SpriteSet> spriteSets) {
        this.spriteSets = spriteSets;
    }

    public ArrayList<AbstractWeapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<AbstractWeapon> weapons) {
        this.weapons = weapons;
    }

    public AbstractWeapon getEquipedWeapon() {
        return equipedWeapon;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Attacks a given character. Total damage is calculated from weapon (or melee) 
     * and amount of hits character does per time unit.
     * @param character Character being attacked
     */
    @Override
    public void attack(AbstractCharacter character) {
        if (this.equipedWeapon != null) {
            for (int i = 0; i < this.hitsPerTimeUnit; i++) {
                this.equipedWeapon.attack(character);
            }
        } else {  // melee damage
            character.getHit(this.damage * this.hitsPerTimeUnit);
        }
    }

    /**
     * Increments the character and the weapons level. 
     * @param increment Level increment
     */
    @Override
    public void increaseLevel(int increment) {
        super.increaseLevel(increment); 
        for (AbstractWeapon weapon : weapons) {
            weapon.increaseLevel(increment);
        }
    }

    @Override
    public String toString() {
        return "AbstractCharacter{"  + super.toString() + "\nsize=" + size + ", maxHealth=" + maxHealth + ", health=" + health + ", hitsPerTimeUnit=" + hitsPerTimeUnit + ", cost=" + cost + ", unlockLevel=" + unlockLevel + ", moveSteps=" + moveSteps + ", spriteState=" + spriteState + ", spriteSets=" + spriteSets + ",direction=" + direction + ",\nweapons=" + weapons + ",\nequipedWeapon=" + equipedWeapon + ",direction=" + direction + '}';
    }
    
    
    
}
