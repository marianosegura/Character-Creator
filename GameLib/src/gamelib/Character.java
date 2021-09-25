/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelib;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Generic character class.
 * @author Luis Mariano Ramírez Segura
 */
public class Character extends AbstractCharacter {
    public Character(int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, HashMap<Integer, SpriteSet> spriteSets, ArrayList<AbstractWeapon> weapons, AbstractWeapon equipedWeapon, Direction direction, String name, int damage, int level, int x, int y) {
        super(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, spriteSets, weapons, equipedWeapon, direction, name, damage, level, x, y);
    }

    public Character(int size, int maxHealth, int hitsPerTimeUnit, int cost, int unlockLevel, int moveSteps, String spriteState, Direction direction) {
        super(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, direction);
    }

    @Override
    public IPrototype shallowClone() {
        return new Character(size, maxHealth, hitsPerTimeUnit, cost, unlockLevel, moveSteps, spriteState, direction);
    }

    @Override
    public IPrototype deepClone() {
        Character character = (Character) shallowClone();
        
        for(AbstractWeapon weapon : weapons) {
            character.addWeapon((AbstractWeapon) weapon.deepClone());
        }
        
        if (equipedWeapon != null) {
            int weaponIndex = weapons.indexOf(equipedWeapon);
            character.equipWeapon(weaponIndex);
        }
        
        for(int setLevel : spriteSets.keySet()) {
            character.addSpriteSet(setLevel, (SpriteSet) spriteSets.get(setLevel).deepClone());
        }
        
        return character;
    }
    
}
