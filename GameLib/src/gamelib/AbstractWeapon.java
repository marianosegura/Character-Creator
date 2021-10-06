/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.HashMap;

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
    protected HashMap<Integer, String> sprites;
    protected boolean levelDependant;

    public AbstractWeapon(int scope, int range, int maxSupplies, int levelMultiplier, HashMap<Integer, String> sprites, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(name, damage, level, x, y);
        this.scope = scope;
        this.explosionRange = range;
        this.maxSupplies = maxSupplies;
        this.supplies = maxSupplies;
        this.levelMultiplier = levelMultiplier;
        this.sprites = sprites;
        this.levelDependant = levelDependant;
    }
    
    public AbstractWeapon(int scope, int range, int maxSupplies, int levelMultiplier, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(name, damage, level, x, y);
        this.scope = scope;
        this.explosionRange = range;
        this.maxSupplies = maxSupplies;
        this.supplies = maxSupplies;
        this.levelMultiplier = levelMultiplier;
        this.sprites = new HashMap<>();
        this.levelDependant = levelDependant;
    }
    
    public AbstractWeapon() {
        this.scope = 1;
        this.explosionRange = 1;
        this.maxSupplies = 1;
        this.supplies = maxSupplies;
        this.levelMultiplier = 1;
        this.sprites = new HashMap<>();
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
        return (this.levelDependant) ? (int) this.damage + this.damage * this.levelMultiplier/100 * this.level : this.damage;
    }
    
    public int getRealDamage(){
        return this.damage;
    }
    
    public String getSprite() {
        int maxSpriteLevel = -1;
        for(int levelKey : sprites.keySet()) {  // iterate levels of sprite sets 
            if (levelKey <= level && levelKey > maxSpriteLevel)
                maxSpriteLevel = levelKey;  // take the biggest value that is below or same as character range
        }
        if (maxSpriteLevel == -1) return null;  // no level matched
        return this.sprites.get(maxSpriteLevel);
    }
    
    public void addSprite(int level, String sprite) {
        sprites.put(level, sprite);
    }

    public int getScope() {
        return scope;
    }

    public int getExplosionRange() {
        return explosionRange;
    }

    public int getMaxSupplies() {
        return maxSupplies;
    }

    public int getSupplies() {
        return supplies;
    }

    public int getLevelMultiplier() {
        return levelMultiplier;
    }

    public HashMap<Integer, String> getSprites() {
        return sprites;
    }

    public boolean isLevelDependant() {
        return levelDependant;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public void setExplosionRange(int explosionRange) {
        this.explosionRange = explosionRange;
    }

    public void setMaxSupplies(int maxSupplies) {
        this.maxSupplies = maxSupplies;
    }

    public void setSupplies(int supplies) {
        this.supplies = supplies;
    }

    public void setLevelMultiplier(int levelMultiplier) {
        this.levelMultiplier = levelMultiplier;
    }

    public void setSprites(HashMap<Integer, String> sprites) {
        this.sprites = sprites;
    }

    public void setLevelDependant(boolean levelDependant) {
        this.levelDependant = levelDependant;
    }

    @Override
    public String toString() {
        return "\nAbstractWeapon{" + super.toString() + "scope=" + scope + ", explosionRange=" + explosionRange + ", maxSupplies=" + maxSupplies + ", supplies=" + supplies + ", levelMultiplier=" + levelMultiplier + ", sprites=" + sprites.keySet() + ", levelDependant=" + levelDependant + '}';
    }
      
}
