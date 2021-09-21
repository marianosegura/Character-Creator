/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelibdemo;

import gamelib.Character;
import gamelib.Direction;
import gamelib.IPrototype;
import gamelib.SpriteSet;
import gamelib.Weapon;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class Gunner extends Character {
    private int shootSpeed;

    public Gunner(int shootSpeed, int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, HashMap<Integer, SpriteSet> spriteSets, ArrayList<Weapon> weapons, Weapon equipedWeapon, Direction direction, String name, int damage, int level, int x, int y) {
        super(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, spriteSets, weapons, equipedWeapon, direction, name, damage, level, x, y);
        this.shootSpeed = shootSpeed;
    }

    public Gunner(int shootSpeed, int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, Direction direction) {
        super(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, direction);
        this.shootSpeed = shootSpeed;
    }
    
    public Gunner(int shootSpeed) {
        this.shootSpeed = shootSpeed;
    }

    public int getShootSpeed() {
        return shootSpeed;
    }

    public void setShootSpeed(int shootSpeed) {
        this.shootSpeed = shootSpeed;
    }

    @Override
    public IPrototype shallowClone() {
        return new Gunner(shootSpeed, size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, direction);
    }

    @Override
    public IPrototype deepClone() {
        Gunner gunner = new Gunner(shootSpeed, size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, direction);
        
        for(Weapon weapon : weapons) {
            gunner.addWeapon((Weapon) weapon.deepClone());
        }
        
        if (equipedWeapon != null) {
            int weaponIndex = weapons.indexOf(equipedWeapon);
            gunner.equipWeapon(weaponIndex);
        }
        
        for(int setLevel : spriteSets.keySet()) {
            gunner.addSpriteSet(setLevel, (SpriteSet) spriteSets.get(setLevel).deepClone());
        }
        
        return gunner;
    }
    
}
