/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelibdemo;

import gamelib.CharacterBuilder;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class GunnerBuilder extends CharacterBuilder<Gunner, GunnerBuilder>{
    private int shootSpeed;
    
    public GunnerBuilder() {  // override empty constructor to set defaults
        super();
        this.shootSpeed = 1;
    }
    
    public GunnerBuilder setShootSPeed(int shootSpeed) {
        this.shootSpeed = shootSpeed;
        return this;
    }
    
    @Override
    public Gunner build() {
        return new Gunner(shootSpeed, size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, spriteSets, weapons, null, direction, name, damage, level, x, y);
    }
    
}
