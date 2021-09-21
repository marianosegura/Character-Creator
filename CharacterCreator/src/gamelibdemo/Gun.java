/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelibdemo;

import gamelib.IPrototype;
import gamelib.Weapon;

/**
 *
 * @author Luis Mariano Ramírez Segura
 */
public class Gun extends Weapon {
    private int recoil;  // extra attribute

    public Gun(int recoil, int scope, int range, int maxSupplies, int levelMultiplier, String image, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(scope, range, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
        this.recoil = recoil;
    }
    
    public Gun(int recoil) {
        this.recoil = recoil;
    }

    public int getRecoil() {
        return recoil;
    }

    public void setRecoil(int recoil) {
        this.recoil = recoil;
    }
    
    @Override
    public IPrototype shallowClone() {
        return this.deepClone();
    }

    @Override
    public IPrototype deepClone() {
        return new Gun(recoil, scope, explosionRange, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
    }
    
}
