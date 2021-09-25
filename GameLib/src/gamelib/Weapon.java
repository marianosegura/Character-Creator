/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

/**
 * Generic weapon class.
 * @author Luis Mariano Ramírez Segura
 */
public class Weapon extends AbstractWeapon {
    public Weapon(int scope, int range, int maxSupplies, int levelMultiplier, String image, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(scope, range, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
    }
    
    public Weapon(int scope, int range, int maxSupplies, int levelMultiplier, String image, boolean levelDependant) {
        super(scope, range, maxSupplies, levelMultiplier, image, levelDependant);
    }
    
    @Override
    public IPrototype shallowClone() {
        return this.deepClone();
    }

    @Override
    public IPrototype deepClone() {
        return new Weapon(scope, explosionRange, maxSupplies, levelMultiplier, image, levelDependant, name, damage, level, x, y);
    }
    
}
