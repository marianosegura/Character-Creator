/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelibdemo;

import gamelib.WeaponBuilder;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class GunBuilder extends WeaponBuilder<Gun, GunBuilder> {
    private int recoil;  // extra attribute
    
    public GunBuilder() {  // override empty constructor to set defaults
        super();  // set parent default values
        this.recoil = 1;
    }
    
    public GunBuilder setRecoil(int recoil) {
        this.recoil = recoil;
        return this;
    }
    
    @Override
    public Gun build() {
        return new Gun(recoil, scope, explosionRange, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
    }
    
}
