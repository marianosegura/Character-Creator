/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public abstract class AbstractWeapon extends GameObject<AbstractCharacter> {
    protected int scope,
        explosionRange,
        maxSupplies,
        supplies,
        levelMultiplier;
    protected String image;
    protected boolean levelDependant;

    public AbstractWeapon(int scope, int range, int maxSupplies, int levelMultiplier, String image, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(name, damage, level, x, y);
        this.scope = scope;
        this.explosionRange = range;
        this.maxSupplies = maxSupplies;
        this.supplies = maxSupplies;
        this.levelMultiplier = levelMultiplier;
        this.image = image;
        this.levelDependant = levelDependant;
    }

    public AbstractWeapon(int scope, int range, int maxSupplies, int levelMultiplier, String image, boolean levelDependant) {
        this.scope = scope;
        this.explosionRange = range;
        this.maxSupplies = maxSupplies;
        this.supplies = maxSupplies;
        this.levelMultiplier = levelMultiplier;
        this.image = image;
        this.levelDependant = levelDependant;
    }
    
    public AbstractWeapon() {
        this.scope = 1;
        this.explosionRange = 1;
        this.maxSupplies = 1;
        this.supplies = maxSupplies;
        this.levelMultiplier = 1;
        this.image = "";
        this.levelDependant = false;
    }
    
    /**
     * Reloads the weapon. Limited to maximum supplies.
     * @param amount Amount of supplies to reload
     */
    public void reload(int amount) {
        this.supplies = Math.min(this.maxSupplies, this.supplies + amount);
    }

    /**
     * 
     * @param character 
     */
    @Override
    public void attack(AbstractCharacter character) { 
        character.getHit(this.getDamage());
    }
    
    @Override
    public int getDamage() {  // multiply by factor if level dependant
        return (this.levelDependant) ? this.damage * this.levelMultiplier : this.damage;
    }
}
