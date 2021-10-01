/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.HashMap;

/**
 * Generic builder for any type of weapon.Delegates the build method implementation.
 * @author Luis Mariano Ramírez Segura
 * @param <T> Concrete weapon class
 * @param <E> Concrete weapon builder class
 */
public abstract class AbstractWeaponBuilder<T extends AbstractWeapon, E extends AbstractWeaponBuilder> implements IBuilder<T> {
    protected String name;
    protected HashMap<Integer, String> sprites;
    protected int damage,  
        level,  
        x,  
        y,
        scope,
        explosionRange,
        maxSupplies,
        supplies,
        levelMultiplier;
    protected boolean levelDependant;
    
    public AbstractWeaponBuilder() {  // defaults
        this.name = "";
        this.damage = 0;
        this.level = 1;
        this.x = 0;
        this.y = 0;
        this.scope = 1;
        this.explosionRange = 1;
        this.maxSupplies = 1;
        this.supplies = maxSupplies;
        this.levelMultiplier = 1;
        this.sprites = new HashMap<>();
        this.levelDependant = false;
    }
 
    public E setName(String name) {
        this.name = name;
        return (E) this;
    }

    public E addSprite(int level, String sprite) {
        this.sprites.put(level, sprite);
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

    public E setScope(int scope) {
        this.scope = scope;
        return (E) this;
    }

    public E setExplosionRange(int explosionRange) {
        this.explosionRange = explosionRange;
        return (E) this;
    }

    public E setMaxSupplies(int maxSupplies) {
        this.maxSupplies = maxSupplies;
        return (E) this;
    }

    public E setLevelMultiplier(int levelMultiplier) {
        this.levelMultiplier = levelMultiplier;
        return (E) this;
    }

    public E setLevelDependant(boolean levelDependant) {
        this.levelDependant = levelDependant;
        return (E) this;
    }
    
    public E setSupplies(int supplies) {
        this.supplies = supplies;
        return (E) this;
    }

    public String getName() {
        return name;
    }

    public HashMap<Integer, String> getSprites() {
        return sprites;
    }
    
    public String getSprite() {
        int maxSpriteLevel = -1;
        for(int levelKey : sprites.keySet()) {  // iterate levels of sprite sets 
            if (levelKey >= level && levelKey > maxSpriteLevel)
                maxSpriteLevel = levelKey;  // take the biggest value that is below or same as character range
        }
        if (maxSpriteLevel == -1) return null;  // no level matched
        return this.sprites.get(maxSpriteLevel);
    }

    public int getDamage() {
        return damage;
    }

    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public boolean isLevelDependant() {
        return levelDependant;
    }
   
}
