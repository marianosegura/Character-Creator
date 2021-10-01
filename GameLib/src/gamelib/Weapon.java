/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.HashMap;

/**
 * Generic weapon class.
 * @author Luis Mariano Ramírez Segura
 */
public class Weapon extends AbstractWeapon {
    public Weapon(int scope, int range, int maxSupplies, int levelMultiplier, HashMap<Integer, String> sprites, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(scope, range, maxSupplies, levelMultiplier, sprites, levelDependant, name, damage, level, x, y);
    }
    
    public Weapon(int scope, int range, int maxSupplies, int levelMultiplier, boolean levelDependant, String name, int damage, int level, int x, int y) {
        super(scope, range, maxSupplies, levelMultiplier, levelDependant, name, damage, level, x, y);
    }
    
    @Override
    public IPrototype shallowClone() {
        return new Weapon(scope, explosionRange, maxSupplies, levelMultiplier, levelDependant, name, damage, level, x, y);
    }

    @Override
    public IPrototype deepClone() {
        HashMap<Integer, String> clonedSprites = new HashMap<>();
        for(int spriteLevel: sprites.keySet()) {  // copy sprites
            clonedSprites.put(spriteLevel, sprites.get(spriteLevel));
        }
        return new Weapon(scope, explosionRange, maxSupplies, levelMultiplier, clonedSprites, levelDependant, name, damage, level, x, y);
    }
    
}
