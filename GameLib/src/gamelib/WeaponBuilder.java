/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Generic builder for any type of weapon.Delegates the build method implementation.
 * @author Luis Mariano Ramírez Segura
 * @param <T> Concrete weapon class
 * @param <E> Concrete weapon builder class
 */
public abstract class WeaponBuilder<T extends Weapon, E extends WeaponBuilder> implements IBuilder<T> {
    protected String name,
        image;  
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
    
    public WeaponBuilder() {  // defaults
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
        this.image = "";
        this.levelDependant = false;
    }
 
    public E setName(String name) {
        this.name = name;
        return (E) this;
    }

    public E setImage(String image) {
        this.image = image;
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
    
}
